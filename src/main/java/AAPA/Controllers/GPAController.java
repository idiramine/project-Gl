/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Controllers;


import AAPA.Entity.Alarm;
import AAPA.Entity.Repo.AlarmRepo;
import AAPA.Entity.Repo.commentairesRepo;
import AAPA.Entity.Repo.coordRepo;
import AAPA.Entity.Repo.infosRepo;
import AAPA.Entity.Repo.pubblicationsRepo;
import AAPA.Entity.Repo.questionsRepo;
import AAPA.Entity.coordonnees;
import AAPA.Entity.infos;
import AAPA.Entity.pubblications;
import AAPA.Entity.questions;
import java.awt.PageAttributes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.util.Properties;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


import javax.mail.Message;
import javax.mail.Session;
import javax.activation.*;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


/**
 *
 * @author youssef
 */
@Controller
public class GPAController {



     @Inject
    commentairesRepo commRep;

     @Inject
    infosRepo infoRep;

    @Inject
   pubblicationsRepo pubRep;

    @Inject
   coordRepo cordRepo;

    @Inject
   infosRepo infRep;

    @Inject
    questionsRepo questRep;
    
    @Inject
    AlarmRepo als;

  @Value("${dir.images}")
    private String imageDir;

  @RequestMapping("/GPA")

       
    public String home(Model m1, @Valid questions questionn) {
        m1.addAttribute("qu", questRep.findAll());
        List <Alarm> alarms= als.findAll();
        List <Alarm> alarm= new ArrayList<>();
        
        for(int i=0;i<alarms.size();i++){
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
            int dif= (Integer.parseInt(dateFormat.format(date).toString().substring(0, 4))*365+
                    Integer.parseInt(dateFormat.format(date).toString().substring(5, 7))*30+
                    Integer.parseInt(dateFormat.format(date).toString().substring(8, 10)))-
                    (Integer.parseInt(alarms.get(i).getdateDernierTraitement().substring(0, 4))*365+
                    Integer.parseInt(alarms.get(i).getdateDernierTraitement().substring(5, 7))*30+
                    Integer.parseInt(alarms.get(i).getdateDernierTraitement().substring(8, 10)));
            
            if(alarms.get(i).getperiodicite().equals("Quotidienne")){
                if(dif>0){ alarm.add(alarms.get(i));}
        }else{
            if(alarms.get(i).getperiodicite().equals("Hebdomadaire")){
                if(dif>=7){ alarm.add(alarms.get(i));}
        }else{
            if(alarms.get(i).getperiodicite().equals("Mensuelle")){
                if(dif>=30){ alarm.add(alarms.get(i));}
        }}}}
        m1.addAttribute("alarms",alarm);
       
            return "indexGPA";
//return "indewGestion";
        }

    @RequestMapping("/GPA/LesQuestions")
    public String home(Model m1,Model M2, @Valid questions questionn) {
        m1.addAttribute("questionss", questRep.findAll());
       
        return "GestQuestions";
    }

    @RequestMapping("/GPA/addPub")
    public String SavePub (Model m2, @Valid pubblications publication , @RequestParam(name ="picture")MultipartFile file) throws Exception{

            m2.addAttribute("publication", publication);

            pubRep.save(publication);

            publication.setPhotoPub(file.getOriginalFilename());
            file.transferTo(new File(imageDir +"article "+ publication.getIdPub()));


         return "redirect:/GPA/ListPub";
    }

   @RequestMapping("/GPA/ListPub")
    public String home(Model m3, @Valid pubblications pub) {
        m3.addAttribute("pubAff", pubRep.findAll());
       
       /* Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dat = dateFormat.format(actuelle);
        pub.setDatePub(dat);*/
       
        return "ListPub";

    }


@RequestMapping(value="/GPA/SupprQuest")
public String deleteQuest(@RequestParam("id") long idQuestion) {

  questions questtt = questRep.findOne(idQuestion);
  questRep.delete(questtt);

  return "redirect:/GPA/LesQuestions";

}


  @RequestMapping(value = "/GPA/edit", method = RequestMethod.GET)
        public String edit(@RequestParam("id") long idPub, Model model) {
            pubblications pubbli = pubRep.findOne(idPub);
            model.addAttribute("pubbli",pubbli);

             return "UpdatePub";

        }


         @RequestMapping(value = "/GPA/Reponse", method = RequestMethod.GET)

        public String RepQuest(@RequestParam("id") long idQuestion, Model model2, HttpServletRequest request) {
            questions questi = questRep.findOne(idQuestion);
            model2.addAttribute("questi",questi);
/**********Envoyer le Mail 2*********************
String recipients[]={questi.mailQuestion};
String str1="Réponse sur votre question sur AAPA.com";
String str2=questi.reponseQuestion;
str2 += "\n la question était"+questi.textQuestion;
String str3="idiramine13@gmail.com";
          SendMailUsingAuthentication sma = new SendMailUsingAuthentication();
      try {
          sma.postMail(recipients, str1, str2, str3);


      } catch (MessagingException ex) {
          Logger.getLogger(GPAController.class.getName()).log(Level.SEVERE, null, ex);
      }
 **********Fin Envoyer le Mail 2*********************/


             return "RepondreQuest";

        }


@RequestMapping("/GPA/saveRep")
public String reppQuestt (Model m4, @Valid questions q ) throws IOException{

    m4.addAttribute("question", q);
      questRep.save(q);
 return "redirect:/GPA/LesQuestions";
}


        @RequestMapping("/GPA/update")
    public String updatePub (Model m3, @Valid pubblications p , @RequestParam(name ="pic")MultipartFile file) throws IOException{

            m3.addAttribute("publication", p);

            p.setPhotoPub(file.getOriginalFilename());
            file.transferTo(new File(imageDir +"article "+ p.getIdPub()));
            pubRep.save(p);
         return "redirect:/GPA/ListPub";
    }
    
    @RequestMapping(value="/GPA/DeletePub")
    public String deletepub(@RequestParam("id") long idPub) {

        pubblications pubu = pubRep.findOne(idPub);
        pubRep.delete(idPub);

        return "redirect:/GPA/ListPub";

    }

       @RequestMapping(value="/GPA/getPhoto", produces=MediaType.IMAGE_JPEG_VALUE)
        @ResponseBody
        public byte[] getPhoto(long id) throws Exception {


             File f = new File(imageDir+"article "+id);
             return IOUtils.toByteArray(new FileInputStream(f));

        }

          @RequestMapping("/GPA/GestCoor")
    public String coord(Model m4, @Valid coordonnees cor, @Valid infos inf) {
        m4.addAttribute("coorAff",cordRepo.findAll());
        m4.addAttribute("infAff", infRep.findAll());
        return "GestCoordonnees";

    }

     @RequestMapping(value="/GPA/getLogo", produces=MediaType.IMAGE_JPEG_VALUE)
        @ResponseBody
        public byte[] getLogo(long idLog) throws Exception {

            File f = new File(imageDir+"Logo");
             return IOUtils.toByteArray(new FileInputStream(f));

        }
         @RequestMapping(value = "/GPA/editInfos", method = RequestMethod.GET)
        public String editInfos(@RequestParam("id") long idInf, Model model2) {
            infos inff = infRep.findOne(idInf);
            model2.addAttribute("inff",inff);

             return "UpdateInfos";
        }
        
               @RequestMapping(value = "/GPA/editCoord", method = RequestMethod.GET)
        public String editCoord(@RequestParam("id") long idCoord, Model model2) {
            coordonnees corr = cordRepo.findOne(idCoord);
            model2.addAttribute("corr",corr);

             return "UpdateCoord";

        }
        @RequestMapping("/GPA/updateCoord")
    public String updateCoord (Model m3, @Valid coordonnees c ) throws IOException{

            m3.addAttribute("info", c);

            cordRepo.save(c);
         return "redirect:/GPA/GestCoor";
    }
        
              @RequestMapping("/GPA/updateInfos")
    public String updateInfos (Model m3, @Valid infos i , @RequestParam(name ="log")MultipartFile file) throws IOException{

            m3.addAttribute("info", i);

            i.setLogo(file.getOriginalFilename());
            file.transferTo(new File(imageDir +"Logo"));
            infRep.save(i);
         return "redirect:/GPA/GestCoor";
    }
    
    @RequestMapping(value="/GPA/DeleteCoor")
public String deleteCoord(@RequestParam("id") long idCoor) {

  coordonnees corrr = cordRepo.findOne(idCoor);
  cordRepo.delete(corrr);

  return "redirect:/GPA/GestCoor";

}
@RequestMapping("/GPA/saveCoord")
    public String SaveCoord (Model m2, @Valid coordonnees coord) throws Exception{

            m2.addAttribute("coord", coord);

            cordRepo.save(coord);

         return "redirect:/GPA/GestCoor";
    }
@RequestMapping("/GPA/addCoord")
    public String addCoord (Model m2, @Valid coordonnees coord) throws Exception{

            m2.addAttribute("coord", coord);

            return "AjoutCoord";
    }

    
}
