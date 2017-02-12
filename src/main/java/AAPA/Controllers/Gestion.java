/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Controllers;

import AAPA.Entity.Alarm;
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

/**
 *
 * @author amine
 */
@Controller
public class Gestion {
    @Inject FilesRepo fs;
@Inject BeneficiaryRepo bs;
@Inject CompagnonRepo cs;
@Inject ChildrensRepo chs;
@Inject DonationsRepo ds;
@Inject ArticlesRepo as;
@Inject AlarmRepo als;

    @RequestMapping("/Gestion")
    public String Gestion(Model m) {
        
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
        m.addAttribute("alarms",alarm);
        return "indexGPA";
        
    }
    
    
}
