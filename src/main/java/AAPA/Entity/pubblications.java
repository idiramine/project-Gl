/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author youssef
 */
@Entity
public class pubblications {
    
      @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
   private Long idPub;
   private String titlePub;
   private String descPub;
   private Date datePub;
   private byte photoPub;
    @OneToMany
   private List<commentaires> CommPub;
  
}
