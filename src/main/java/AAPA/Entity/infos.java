/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author youssef
 */
@Entity

public class infos {
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
   private Long idInf;
   private String descInf;
   private String telInf;
   private String typeInf;
   private byte logo;
  
   
}
