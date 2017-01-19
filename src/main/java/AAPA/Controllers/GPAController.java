/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Controllers;


import AAPA.Entity.Repo.commentairesRepo;
import AAPA.Entity.Repo.infosRepo;
import AAPA.Entity.Repo.pubblicationsRepo;
import AAPA.Entity.Repo.questionsRepo;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    questionsRepo questRep;

  
    @RequestMapping("/")

    public String home(Model M) {
        

        return "accueil";
    }
}
