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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author youssef
 */
@Entity
public class commentaires {
      @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
     private Long idComment;
     private String textComment;
     private Date dateComment;
     private String authorComment;
      @ManyToOne
    @JoinColumn(name="idThemeEvent")
    private pubblications pubComm;
     
}
