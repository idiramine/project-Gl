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
 * @author amine
 */
@Entity
public class Compagnon {
   @Id
    @GeneratedValue (strategy = GenerationType.AUTO)      
    private Long     idCompagnon;
    private String   compagnonName;
    private String   compagnonFirstName; //prénom
    private String   compagnonDateOfBirth;
    private String   compagnonPlaceOfBirth;
    private String   observation;
    
    
    public Compagnon() {
    
    }
   Compagnon ( 
              String observation,
              String compagnonName,
              String compagnonFirstName,
              String compagnonDateOfBirth,
              String compagnonPlaceOfBirth) {
       this.compagnonDateOfBirth=compagnonDateOfBirth;
       this.compagnonFirstName=compagnonFirstName;
       this.compagnonName=compagnonName;
       this.compagnonPlaceOfBirth=compagnonPlaceOfBirth;
       this.observation=observation;
    
    }
    
    public Long getIdCompagnon (){
    return idCompagnon;
    }
        
    
    
    public String getCompagnonPlaceOfBirth (){
    return compagnonPlaceOfBirth;
    }
    
    public String getCompagnonDateOfBirth (){
    return compagnonDateOfBirth;
    }
    
    public String getCompagnonFirstName (){
    return compagnonFirstName;
    }
    
    public String getCompagnonName (){
    return compagnonName;
    }
    
    public String getObservation (){
    return observation;
    }
    
    public void setIdCompagnon (Long idCompagnon){
    this.idCompagnon=idCompagnon;
    }
        
    
    
    public void setCompagnonPlaceOfBirth (String compagnonPlaceOfBirth ){
    this.compagnonPlaceOfBirth=compagnonPlaceOfBirth;
    }
    
    public void setCompagnonDateOfBirth (String compagnonDateOfBirth ){
    this.compagnonDateOfBirth=compagnonDateOfBirth;
    }
    
    public void setCompagnonFirstName (String compagnonFirstName ){
    this.compagnonFirstName=compagnonFirstName;
    }
    
    public void setCompagnonName (String compagnonName ){
    this.compagnonName=compagnonName;
    }
    
    public void setObservation (String observation){
    this.observation=observation;
    }
      
}

