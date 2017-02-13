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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

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
  
   private String datePub;
  // private byte[] photoPub;
   private String photoPub;
    @OneToMany
   private List<commentaires> CommPub;

    public Long getIdPub() {
        return idPub;
    }

    public void setIdPub(Long idPub) {
        this.idPub = idPub;
    }

    public String getTitlePub() {
        return titlePub;
    }

    public void setTitlePub(String titlePub) {
        this.titlePub = titlePub;
    }

    public String getDescPub() {
        return descPub;
    }

    public void setDescPub(String descPub) {
        this.descPub = descPub;
    }

    public String getDatePub() {
        return datePub;
    }

    public void setDatePub(String datePub) {
        this.datePub = datePub;
    }

    public String getPhotoPub() {
        return photoPub;
    }

    public void setPhotoPub(String photoPub) {
        this.photoPub = photoPub;
    }

    public List<commentaires> getCommPub() {
        return CommPub;
    }

    public void setCommPub(List<commentaires> CommPub) {
        this.CommPub = CommPub;
    }

    public pubblications() {
    }

    public pubblications(String titlePub, String descPub, String datePub, String photoPub, List<commentaires> CommPub) {
        this.titlePub = titlePub;
        this.descPub = descPub;
        this.datePub = datePub;
        this.photoPub = photoPub;
        this.CommPub = CommPub;
    }

   
}
