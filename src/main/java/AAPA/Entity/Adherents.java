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
public class Adherents {
    
     @Id
    @GeneratedValue (strategy = GenerationType.AUTO)      
    private Long     idAdherent;
    private String   lastname;
    private String   firstname;

    public Long getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(Long idAdherent) {
        this.idAdherent = idAdherent;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public Adherents() {
    }
    

    public Adherents(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    
    
}
