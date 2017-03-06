/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Controllers;

import AAPA.Entity.Alarm;
import AAPA.Entity.Articles;
import AAPA.Entity.Beneficiary;
import AAPA.Entity.Childrens;
import AAPA.Entity.Compagnon;
import AAPA.Entity.Donations;
import AAPA.Entity.Files;
import AAPA.Entity.Repo.AlarmRepo;
import AAPA.Entity.Repo.ArticlesRepo;
import AAPA.Entity.Repo.BeneficiaryRepo;
import AAPA.Entity.Repo.ChildrensRepo;
import AAPA.Entity.Repo.CompagnonRepo;
import AAPA.Entity.Repo.DonationsRepo;
import AAPA.Entity.Repo.FilesRepo;
import AAPA.Entity.Repo.UserRepo;
import AAPA.Entity.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author amine
 */
@Controller
public class GIController {
@Inject FilesRepo fs;
@Inject BeneficiaryRepo bs;
@Inject CompagnonRepo cs;
@Inject ChildrensRepo chs;
@Inject DonationsRepo ds;
@Inject ArticlesRepo as;
@Inject UserRepo us;
@Inject AlarmRepo als;
    
    /*******gestion des dossiers*******/
    @RequestMapping("/gestionfiles")
    public String home(Model m) {
        
        List<Files> fls=fs.findAllByOrderByfileNameAsc();
        m.addAttribute("filescall",fls);
        Files file=new Files();
        m.addAttribute("file",file);
        Beneficiary benef=new Beneficiary();
        m.addAttribute("benef",benef);
        return "GestionFiles"; 
    }
    
    @RequestMapping("/seefiles/{idFile}")
    public String detailsFile(Model m, @PathVariable("idFile") long idFile) {
        Files file = fs.findOne(idFile);
        List <Donations> dons= ds.findByfile(file);
        Childrens child=new Childrens();
        Beneficiary benef=file.getBeneficiary();
        Alarm alarm=new Alarm();
        if(file.getCompagnon()!=null){
            Compagnon comp=file.getCompagnon();
            m.addAttribute("comp",comp);}
        else{
            Compagnon comp=new Compagnon();
        m.addAttribute("comp",comp);}
        m.addAttribute("child",child);
        m.addAttribute("benef",benef);
        m.addAttribute("dons",dons);
        m.addAttribute("file", file);
        m.addAttribute("alarm",alarm);
        m.addAttribute("alarms",file.getAlarms());
        return "FilesDetails";
    }
    
     @RequestMapping("/del-file")
    public String deleteFile(@RequestParam("id") long idFile) {
       Files file =fs.findOne(idFile);
        
       List <Donations> dons= ds.findByfile(file);
       for (int j=0;j<dons.size();j++){
        ds.delete(dons.get(j));
       }
        
       List <Alarm> alarms= file.getAlarms();
       file.setAlarms(null);
       for (int j=0;j<alarms.size();j++){
       als.delete(alarms.get(j));
       }
       
        try {
           Beneficiary benef = fs.findOne(idFile).getBeneficiary();
            fs.findOne(idFile).setBeneficiary(null);
            bs.delete(benef);
        } catch (Exception e) {
        }
        
        try {
            Compagnon comp=fs.findOne(idFile).getCompagnon();
            fs.findOne(idFile).setCompagnon(null);
            cs.delete(comp);
        } catch (Exception e) {
        }
        
        try {
            List<Childrens> childs=fs.findOne(idFile).getChildrens();
            fs.findOne(idFile).setChildrens(null);
            for(int i=0;i<childs.size();i++){
            chs.delete(childs.get(i).getIdChildren());
            }
       } catch (Exception e) {
        }
        
        fs.delete(idFile);
        
        return "redirect:/gestionfiles";
    }
    
     @RequestMapping("/addfiles")
    public String addfiles(Files f, Beneficiary b) {
        bs.save(b);
        f.setBeneficiary(b);
        fs.save(f);
        
        return "redirect:/gestionfiles" ;
    }
    
    @RequestMapping("/modifyFile/{idFile}")
    public String modifyFile(@PathVariable("idFile") long idFile, 
            Files file) {
        Files oldfile = fs.findOne(idFile);
        if(!file.getAdress().equals(""))
        oldfile.setAdress(file.getAdress());
        if(!file.getFileDate().equals(""))
        oldfile.setFileDate(file.getFileDate());
        if(!file.getObservation().equals(""))
        oldfile.setObservation(file.getObservation());
        if(!file.getFileName().equals(""))
        oldfile.setFileName(file.getFileName());
        fs.save(file);
        return "redirect:/seefiles/"+idFile;
    } 
    /*******************************/
    
    /*******gestion des beneficiares*******/
    @RequestMapping("/deleteBeneficiary")
    public String deleteBeneficiary( @RequestParam("id") long idFile) {
        Files file = fs.findOne(idFile);
        if(file.getBeneficiary()!=null&&file.getCompagnon()!=null){
        Long id=file.getBeneficiary().getIdBeneficiary();
        Long idc=file.getCompagnon().getIdCompagnon();
        Compagnon comp=file.getCompagnon();
        //file.setBeneficiary(null);
        file.getBeneficiary().setBeneficiaryDateOfBirth(
                comp.getCompagnonDateOfBirth());
        file.getBeneficiary().setBeneficiaryPlaceOfBirth(
                comp.getCompagnonPlaceOfBirth());
        file.getBeneficiary().setBeneficiaryName(
                comp.getCompagnonName());
        file.getBeneficiary().setBeneficiaryFirstName(
                comp.getCompagnonFirstName());
        file.getBeneficiary().setObservation(
                comp.getObservation());
        file.getBeneficiary().setBeneficiarySituation(
                null);
        file.setCompagnon(null);
        try {
            Long id1=Long.parseLong("4", 10);
            //bs.delete(id);
            cs.delete(idc);
        } catch (Exception e) {
            System.out.println("erreur"+e);
        }
        //fs.save();
    }
        return "redirect:/seefiles/"+idFile;
           
    }
    
    @RequestMapping("/modifyBeneficiary/{idFile}")
    public String modifyBeneficiary(@PathVariable("idFile") long idFile, 
            Beneficiary benef) {
        Files file = fs.findOne(idFile);
        Beneficiary oldbenef = bs.findOne(file.getBeneficiary().getIdBeneficiary());
        if(!benef.getBeneficiaryDateOfBirth().equals(""))
        oldbenef.setBeneficiaryDateOfBirth(benef.getBeneficiaryDateOfBirth());
        if(!benef.getBeneficiaryFirstName().equals(""))
        oldbenef.setBeneficiaryFirstName(benef.getBeneficiaryFirstName());
        if(!benef.getBeneficiaryName().equals(""))
        oldbenef.setBeneficiaryName(benef.getBeneficiaryName());
        if(!benef.getBeneficiaryPlaceOfBirth().equals(""))
        oldbenef.setBeneficiaryPlaceOfBirth(benef.getBeneficiaryPlaceOfBirth());
        if(!benef.getObservation().equals(""))
        oldbenef.setObservation(benef.getObservation());
        if(!benef.getBeneficiarySituation().equals(""))
        oldbenef.setBeneficiarySituation(benef.getBeneficiarySituation());
        bs.save(oldbenef);
        fs.save(file);
        return "redirect:/seefiles/"+idFile;
    }
    /********************************************/
    
    /*******gestion des conjoint*******/
    @RequestMapping("/deleteCompagnon")
    public String deleteCompagnon( @RequestParam("id") long idFile) {
        Files file = fs.findOne(idFile);
        if(file.getCompagnon()!=null){
            
        Long id=file.getCompagnon().getIdCompagnon();
        file.setCompagnon(null);
        try {
            Long id1=Long.parseLong("4", 10);
            cs.delete(id);
        } catch (Exception e) {
            System.out.println("erreur"+e);
        }
        
    }
        return "redirect:/seefiles/"+idFile;
           
    }
    
    @RequestMapping("/addCompagnon")
    public String addCompagnon( @RequestParam("id") long idFile, 
            Compagnon comp) {
        Files file = fs.findOne(idFile);
        cs.save(comp);
        file.setCompagnon(comp);
        fs.save(file);
        return "redirect:/seefiles/"+idFile;
    }
    
    @RequestMapping("/modifyCompagnon/{id}")
    public String modifyCompagnon( @PathVariable("id") long idFile, 
            Compagnon comp) {
        
        Files file = fs.findOne(idFile);
        if(file.getCompagnon()!=null){
        Compagnon oldcomp = cs.findOne(file.getCompagnon().getIdCompagnon());
        if(!comp.getCompagnonDateOfBirth().equals(""))
        oldcomp.setCompagnonDateOfBirth(comp.getCompagnonDateOfBirth());
        if(!comp.getCompagnonFirstName().equals(""))
        oldcomp.setCompagnonFirstName(comp.getCompagnonFirstName());
        if(!comp.getCompagnonName().equals(""))
        oldcomp.setCompagnonName(comp.getCompagnonName());
        if(!comp.getCompagnonPlaceOfBirth().equals(""))
        oldcomp.setCompagnonPlaceOfBirth(comp.getCompagnonPlaceOfBirth());
        if(!comp.getObservation().equals(""))
        oldcomp.setObservation(comp.getObservation());
        cs.save(oldcomp);
        fs.save(file);
        }
        else{
            return addCompagnon(idFile, comp);
           }
        return "redirect:/seefiles/"+idFile;
    }
    /**********************************************/
    
    /*******gestion des enfants*******/
    @RequestMapping("/deleteChild")
    public String deleteChild( @RequestParam("id") long idFile,
            @RequestParam("idch") long idChildren) {
        Files file = fs.findOne(idFile);
        if(file.getChildrens()!=null){
            List<Childrens> listtemp= new ArrayList<>();
            for (int i=0;i<file.getChildrens().size();i++){
            if(file.getChildrens().get(i).getIdChildren()!=idChildren){
            listtemp.add(file.getChildrens().get(i));
            }
            }
            file.setChildrens(listtemp);
            fs.save(file);
        try {
            Long id1=Long.parseLong("4", 10);
            chs.delete(idChildren);
        } catch (Exception e) {
            System.out.println("erreur"+e);
        }
        
    }
        return "redirect:/seefiles/"+idFile;
           
    }
    
    @RequestMapping("/addChild")
    public String addChild( @RequestParam("id") long idFile, 
            Childrens child) {
        Files file = fs.findOne(idFile);
        chs.save(child);
        file.getChildrens().add(child);
        fs.save(file);
        return "redirect:/seefiles/"+idFile;
    }
    
    @RequestMapping("/modifyChild")
    public String modifyChild( @RequestParam("id") long idFile,
            @RequestParam("idch") long idchild,
            Childrens child) {
        Files file = fs.findOne(idFile);
        Childrens oldchild = chs.findOne(idchild);
        if(!child.getChildrenDateOfBirth().equals(""))
            oldchild.setChildrenDateOfBirth(child.getChildrenDateOfBirth());
        if(!child.getChildrenFirstName().equals(""))
            oldchild.setChildrenFirstName(child.getChildrenFirstName());
        if(!child.getChildrenName().equals(""))
            oldchild.setChildrenName(child.getChildrenName());
        if(!child.getChildrenPlaceOfBirth().equals(""))
            oldchild.setChildrenPlaceOfBirth(child.getChildrenPlaceOfBirth());
        if(!child.getObservation().equals(""))
            oldchild.setObservation(child.getObservation());
        if(!child.getChildrenSchooling().equals(""))
            oldchild.setChildrenSchooling(child.getChildrenSchooling());
        chs.save(oldchild);
        fs.save(file);
        return "redirect:/seefiles/"+idFile;
    }
    
     /*************************************/
    
    /********gestion des dons********/
     @RequestMapping("/Seedonations")
    public String donations (Model m){
        List<Donations> dns=ds.findAll();
        m.addAttribute("dnscall",dns);
        List <Articles> articles=as.findAll();//filtrer ceux qui ont zero
       List <Files> files=fs.findAllByOrderByfileNameAsc();//filtrer ceux qui ont zero
       int i=0;
       while(i<articles.size()){
           if(articles.get(i).getQuantity()==0){ 
              articles.remove(i);
           }else i++;//System.out.println(""+articles.get(i).getQuantity());
       }
       Donations don=new Donations();
        m.addAttribute("files",files);
        m.addAttribute("articles",articles);
        m.addAttribute("don",don);
   return ("Donations"); 
    }
    
    @RequestMapping("/makeDonation")
    public String makeDonations (@RequestParam("id") long idFile, Model m){
       Files file=fs.findOne(idFile);
       List <Articles> articles=as.findAll();//filtrer ceux qui ont zero
       int i=0;
       while(i<articles.size()){
           if(articles.get(i).getQuantity()==0){ 
              articles.remove(i);
           }else i++;//System.out.println(""+articles.get(i).getQuantity());
       }
       Donations don=new Donations();
        m.addAttribute("file",file);
        m.addAttribute("articles",articles);
        m.addAttribute("don",don);
   return ("AddDonationArticle"); 
    }
    
    @RequestMapping("/addDonation")
    public String addDonations (@RequestParam("id") long idFile,
                                @RequestParam("idart") long idArticle,
                                Donations don){
       Files file=fs.findOne(idFile);
       Articles art=as.findOne(idArticle);
       try{
      if(don.getDonationQuantity()>art.getQuantity()){
      //erreur
      }else{
      art.setQuantity(art.getQuantity()-don.getDonationQuantity());
      don.setArticle(art);
       don.setFile(file);
       ds.save(don);
      }
       }catch (Exception e){
      
      }
             
   return "redirect:/gestionfiles"; 
    }
    
    @RequestMapping("/addDonationfilearticle")
    public String addDonation ( @RequestParam("id") long idFile,
                                @RequestParam("idart") long idArticle,
                                Donations don){
       Files file=fs.findOne(idFile);
       Articles art=as.findOne(idArticle);
       try{
      if(don.getDonationQuantity()>art.getQuantity()){
      //erreur
      }else{
      art.setQuantity(art.getQuantity()-don.getDonationQuantity());
      don.setArticle(art);
      don.setFile(file);
       ds.save(don);
      }
       }catch (Exception e){
       
      }
   return "redirect:/Seedonations"; 
    }
    
    @RequestMapping("/deleteDonation")
    public String deleteDonation( @RequestParam("id") long idDonation) {
        Donations don = ds.findOne(idDonation);
        
        Articles art=as.findOne(don.getArticle().getIdArticle());
        art.setQuantity(art.getQuantity()+don.getDonationQuantity());
        as.save(art);
        ds.delete(don);
        return "redirect:/Seedonations";
           
    }
    
    @RequestMapping("/deleteDonationFile")
    public String deleteDonationFile( @RequestParam("id") long idDonation) {
        Donations don = ds.findOne(idDonation);
        Articles art=as.findOne(don.getArticle().getIdArticle());
        art.setQuantity(art.getQuantity()+don.getDonationQuantity());
        as.save(art);
    Long idFile = don.getFile().getIdFile();
        ds.delete(don);
        return "redirect:/seefiles/"+idFile;
           
    }
    /************************************/
    
     /******* gestion du stock *******/
    
    @RequestMapping("/gestionstock")
    public String gestionStock(Model M) {
       
        return "redirect:/Articles.html";
    }
    /***************************************/
    
    /******** gestion des alarms ********/
    @RequestMapping("/addAlarm")
    public String addAlarm(@RequestParam("id") long idFile, Alarm alarm) {
       Files file = fs.findOne(idFile);
       alarm.setdateDebut(alarm.getdateDebut().substring(0, 10));
        als.save(alarm);
        file.getAlarms() .add(alarm);
        fs.save(file);
        return "redirect:/seefiles/"+idFile;
    }
    
    @RequestMapping("/deleteAlarm")
    public String deleteAlarm( @RequestParam("id") long idFile,
            @RequestParam("idal") long idAlarm) {
        Files file = fs.findOne(idFile);
        if(file.getAlarms()!=null){
            List<Alarm> listtemp= new ArrayList<>();
            for (int i=0;i<file.getAlarms().size();i++){
            if(file.getAlarms().get(i).getidAlarm()!=idAlarm){
            listtemp.add(file.getAlarms().get(i));
            }
            }
            file.setAlarms(listtemp);
            fs.save(file);
        try {
            Long id1=Long.parseLong("4", 10);
            als.delete(idAlarm);
        } catch (Exception e) {
            System.out.println("erreur"+e);
        }
        
    }
        return "redirect:/seefiles/"+idFile;
           
    }
    
    @RequestMapping("/traiterAlarm")
    public String traiterAlarm( @RequestParam("id") long idFile,
            @RequestParam("idal") long idAlarm) {
        //Files file = fs.findOne(idFile);
        Alarm al= als.findOne(idAlarm);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        al.setdateDernierTraitement(dateFormat.format(date).toString());
        als.save(al);
        return "redirect:/seefiles/"+idFile;
    }
    
    @RequestMapping("/traiterAlarms")
    public String traiterAlarms(@RequestParam("idal") long idAlarm) {
        Alarm al= als.findOne(idAlarm);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        al.setdateDernierTraitement(dateFormat.format(date).toString());
        als.save(al);
        return "redirect:/Gestion";
    }
    
    @RequestMapping("/modifyAlarm")
    public String modifyAlarm( @RequestParam("id") long idFile,  @RequestParam("idal") long idAlarm, Alarm alarm) {
       // Files file = fs.findOne(idFile); 
        Alarm oldalarm = als.findOne(idAlarm);
        if(!alarm.getdateDebut().equals(""))
        oldalarm.setdateDebut(alarm.getdateDebut());
        if(!alarm.getperiodicite().equals(""))
        oldalarm.setperiodicite(alarm.getperiodicite());
        if(!alarm.gettitle().equals(""))
        oldalarm.settitle(alarm.gettitle());
       // if(!alarm.getdateDebut().equals(""))
       // oldalarm.settraite(alarm.gettraite());
        if(!alarm.getdateDernierTraitement().equals(""))
        oldalarm.setdateDernierTraitement(alarm.getdateDernierTraitement());
        als.save(oldalarm);
       // fs.save(file);
        return "redirect:/seefiles/"+idFile;
    }
    /*************************************/
    
    /************ gestion des comptes ************/
   @RequestMapping("/gestioncomptes")
    public String gestioncomptes(  Model m) {
       
       List <User> users= us.findAll();
       m.addAttribute("users",users);
       m.addAttribute("user",new User());
        
        return "Comptes";
    }
    
    @RequestMapping("/deleteuser")
    public String deleteUser( @RequestParam("id") long idUser) {
        //User user = us.findOne(idUser);
            us.delete(idUser);
       
        return "redirect:/gestioncomptes";
           
    }
    
    @RequestMapping("/modifyCompte")
    public String modifyCompte( @RequestParam("id") long idUser,
            User user) {
        User olduser = us.findOne(idUser);
        if(!user.getEmail().equals(""))
            olduser.setEmail(user.getEmail());
        if(!user.getLastName().equals(""))
            olduser.setLastName(user.getLastName());
        if(!user.getFirstName().equals(""))
            olduser.setFirstName(user.getFirstName());
        if(!user.getPassword().equals(""))
            olduser.setPassword(user.getPassword());
        if(!user.getLogin().equals(""))
            olduser.setLogin(user.getLogin());
        if(!user.getRole().equals(""))
            olduser.setRole(user.getRole());
        us.save(olduser);
        return "redirect:/gestioncomptes";
    }
    
    
    @RequestMapping("/adduser") 
    public String addUser(User user) {
        us.save(user);
        return "redirect:/gestioncomptes";
    }
    /****************************************************/
    
    
}
