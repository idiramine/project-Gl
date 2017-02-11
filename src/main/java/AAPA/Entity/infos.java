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
import javax.persistence.OneToMany;

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
   private String ribInf;
   private String telInf;
   private String adresseInf;
   private String faxInf; 
   private String logo;
   
   
    public Long getIdInf() {
        return idInf;
    }

    public void setIdInf(Long idInf) {
        this.idInf = idInf;
    }

    public String getDescInf() {
        return descInf;
    }

    public void setDescInf(String descInf) {
        this.descInf = descInf;
    }

    public String getRibInf() {
        return ribInf;
    }

    public void setRibInf(String ribInf) {
        this.ribInf = ribInf;
    }

    public String getTelInf() {
        return telInf;
    }

    public void setTelInf(String telInf) {
        this.telInf = telInf;
    }

    public String getAdresseInf() {
        return adresseInf;
    }

    public void setAdresseInf(String adresseInf) {
        this.adresseInf = adresseInf;
    }

    public String getFaxInf() {
        return faxInf;
    }

    public void setFaxInf(String faxInf) {
        this.faxInf = faxInf;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String Logo) {
        this.logo = logo;
    }

    
   

    public infos(String descInf, String ribInf, String telInf, String adresseInf, String faxInf, String logo) {
        this.descInf = descInf;
        this.ribInf = ribInf;
        this.telInf = telInf;
        this.adresseInf = adresseInf;
        this.faxInf = faxInf;
        this.logo = logo;
       
    }

    public infos() {
    }
       
  

  
   
}
