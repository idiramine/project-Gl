/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Entity;

import java.util.List;
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
public class AlbumPhoto {
      @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
   private Long idPhoto;
   private String namePhoto;
   private Long idPubAlb;
   
//   @ManyToOne
//   @JoinColumn(name="idPub")
//   pubblications Pub ;
//
//    public pubblications getPub() {
//        return Pub;
//    }
//
//    public void setPub(pubblications Pub) {
//        this.Pub = Pub;
//    }

   
   
    public Long getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(Long idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getNamePhoto() {
        return namePhoto;
    }

    public void setNamePhoto(String namePhoto) {
        this.namePhoto = namePhoto;
    }

    public AlbumPhoto(String namePhoto) {
        this.namePhoto = namePhoto;
    }

    public Long getIdPubAlb() {
        return idPubAlb;
    }

    public void setIdPubAlb(Long idPubAlb) {
        this.idPubAlb = idPubAlb;
    }

    public AlbumPhoto() {
    }

    public AlbumPhoto(String namePhoto, Long idPubAlb) {
        this.namePhoto = namePhoto;
        this.idPubAlb = idPubAlb;
    }
  
}
