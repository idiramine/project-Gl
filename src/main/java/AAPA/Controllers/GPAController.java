/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Controllers;


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

  @Value("${dir.images}")
    private String imageDir;

  @RequestMapping("/")

    public String edit(Model model) {

             return "indexGPA";

        }

    @RequestMapping("/LesQuestions")
    public String home(Model m1, @Valid questions questionn) {
        m1.addAttribute("questionss", questRep.findAll());
        return "GestQuestions";
    }

    @RequestMapping("/addPub")
    public String SavePub (Model m2, @Valid pubblications publication , @RequestParam(name ="picture")MultipartFile file) throws Exception{

            m2.addAttribute("publication", publication);

            pubRep.save(publication);

            publication.setPhotoPub(file.getOriginalFilename());
            file.transferTo(new File(imageDir +"article "+ publication.getIdPub()));


         return "redirect:/ListPub";
    }

   @RequestMapping("/ListPub")
    public String home(Model m3, @Valid pubblications pub) {
        m3.addAttribute("pubAff", pubRep.findAll());
        return "ListPub";

    }



      @RequestMapping(value="/DeletePub")
    public String deletepub(@RequestParam("id") long idPub) {

        pubblications pubu = pubRep.findOne(idPub);
        pubRep.delete(idPub);

        return "redirect:/ListPub";

    }



@RequestMapping(value="/SupprQuest")
public String deleteQuest(@RequestParam("id") long idQuestion) {

  questions questtt = questRep.findOne(idQuestion);
  questRep.delete(questtt);

  return "redirect:/LesQuestions";

}


  @RequestMapping(value = "/edit", method = RequestMethod.GET)
        public String edit(@RequestParam("id") long idPub, Model model) {
            pubblications pubbli = pubRep.findOne(idPub);
            model.addAttribute("pubbli",pubbli);

             return "UpdatePub";

        }


         @RequestMapping(value = "/Reponse", method = RequestMethod.GET)

        public String RepQuest(@RequestParam("id") long idQuestion, Model model2, HttpServletRequest request) {
            questions questi = questRep.findOne(idQuestion);
            model2.addAttribute("questi",questi);
/**********Envoyer le Mail 2*********************/
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
 /**********Fin Envoyer le Mail 2*********************/


             return "RepondreQuest";

        }


@RequestMapping("/saveRep")
public String reppQuestt (Model m4, @Valid questions q ) throws IOException{

    m4.addAttribute("question", q);
      questRep.save(q);
 return "redirect:/LesQuestions";
}


        @RequestMapping("/update")
    public String updatePub (Model m3, @Valid pubblications p , @RequestParam(name ="pic")MultipartFile file) throws IOException{

            m3.addAttribute("publication", p);

            p.setPhotoPub(file.getOriginalFilename());
            file.transferTo(new File(imageDir +"article "+ p.getIdPub()));
            pubRep.save(p);
         return "redirect:/ListPub";
    }

       @RequestMapping(value="/getPhoto", produces=MediaType.IMAGE_JPEG_VALUE)
        @ResponseBody
        public byte[] getPhoto(long id) throws Exception {


             File f = new File(imageDir+"article "+id);
             return IOUtils.toByteArray(new FileInputStream(f));

        }

          @RequestMapping("/GestCoor")
    public String coord(Model m4, @Valid coordonnees cor, @Valid infos inf) {
        m4.addAttribute("coorAff",cordRepo.findAll());
        m4.addAttribute("infAff", infRep.findAll());
        return "GestCoordonnees";

    }

     @RequestMapping(value="/getLogo", produces=MediaType.IMAGE_JPEG_VALUE)
        @ResponseBody
        public byte[] getLogo(long idLog) throws Exception {

            File f = new File(imageDir+"Logo");
             return IOUtils.toByteArray(new FileInputStream(f));

        }
         @RequestMapping(value = "/editInfos", method = RequestMethod.GET)
        public String editInfos(@RequestParam("id") long idInf, Model model2) {
            infos inff = infRep.findOne(idInf);
            model2.addAttribute("inff",inff);

             return "UpdateInfos";
        }
        
               @RequestMapping(value = "/editCoord", method = RequestMethod.GET)
        public String editCoord(@RequestParam("id") long idCoord, Model model2) {
            coordonnees corr = cordRepo.findOne(idCoord);
            model2.addAttribute("corr",corr);

             return "UpdateCoord";

        }
        @RequestMapping("/updateCoord")
    public String updateCoord (Model m3, @Valid coordonnees c ) throws IOException{

            m3.addAttribute("info", c);

            cordRepo.save(c);
         return "redirect:/GestCoor";
    }
        
              @RequestMapping("/updateInfos")
    public String updateInfos (Model m3, @Valid infos i , @RequestParam(name ="log")MultipartFile file) throws IOException{

            m3.addAttribute("info", i);

            i.setLogo(file.getOriginalFilename());
            file.transferTo(new File(imageDir +"Logo"));
            infRep.save(i);
         return "redirect:/GestCoor";
    }
    
    @RequestMapping(value="/DeleteCoor")
public String deleteCoord(@RequestParam("id") long idCoor) {

  coordonnees corrr = cordRepo.findOne(idCoor);
  cordRepo.delete(corrr);

  return "redirect:/GestCoor";

}
@RequestMapping("/saveCoord")
    public String SaveCoord (Model m2, @Valid coordonnees coord) throws Exception{

            m2.addAttribute("coord", coord);

            cordRepo.save(coord);

         return "redirect:/GestCoor";
    }
@RequestMapping("/addCoord")
    public String addCoord (Model m2, @Valid coordonnees coord) throws Exception{

            m2.addAttribute("coord", coord);

            return "AjoutCoord";
    }

    
}
