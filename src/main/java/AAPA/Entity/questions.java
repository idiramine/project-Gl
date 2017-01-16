/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author youssef
 */
@Entity
public class questions {
    
      @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
     private Long idQuestion;
     private String textQuestion;
     private Date dateQuestion;
     private String authorQuestion;
     
}
