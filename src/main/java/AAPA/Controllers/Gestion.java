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
import java.util.ArrayList;
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
        if(alarms.get(i).getdateDernierTraitement().equals(i)){
        
        }
        }
        m.addAttribute("alarms",alarms);
        return "Gestion";
    }
    
    
}
