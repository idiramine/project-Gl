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
public class coordonnees {
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
   private Long idCoor;
   private String nomCoor;
   private String prenomCoor;
   private String telCoor;
   private String mailCoor;
   private String fonctionCoor;

    public Long getIdCoor() {
        return idCoor;
    }

    public void setIdCoor(Long idCoor) {
        this.idCoor = idCoor;
    }

    public String getNomCoor() {
        return nomCoor;
    }

    public void setNomCoor(String nomCoor) {
        this.nomCoor = nomCoor;
    }

    public String getPrenomCoor() {
        return prenomCoor;
    }

    public void setPrenomCoor(String prenomCoor) {
        this.prenomCoor = prenomCoor;
    }

    public String getTelCoor() {
        return telCoor;
    }

    public void setTelCoor(String telCoor) {
        this.telCoor = telCoor;
    }

    public String getMailCoor() {
        return mailCoor;
    }

    public void setMailCoor(String mailCoor) {
        this.mailCoor = mailCoor;
    }

    public String getFonctionCoor() {
        return fonctionCoor;
    }

    public void setFonctionCoor(String fonctionCoor) {
        this.fonctionCoor = fonctionCoor;
    }

    public coordonnees() {
    }

    public coordonnees(String nomCoor, String prenomCoor, String telCoor, String mailCoor, String fonctionCoor) {
        this.nomCoor = nomCoor;
        this.prenomCoor = prenomCoor;
        this.telCoor = telCoor;
        this.mailCoor = mailCoor;
        this.fonctionCoor = fonctionCoor;
    }

   
}
