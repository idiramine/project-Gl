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
public class Childrens {
     @Id
    @GeneratedValue (strategy = GenerationType.AUTO)      
    private Long     idChildren;
    private String   childrenName;
    private String   childrenFirstName; //prénom
    private String   childrenDateOfBirth;
    private String   childrenPlaceOfBirth;
    private String   childrenSchooling;
    private String   observation;
    // clé etrangéres
    // IdParent
    
   
   Childrens (String childrenSchooling, 
              String observation,
              String childrenName,
              String childrenFirstName,
              String childrenDateOfBirth,
              String childrenPlaceOfBirth) {
       this.childrenDateOfBirth=childrenDateOfBirth;
       this.childrenFirstName=childrenFirstName;
       this.childrenName=childrenName;
       this.childrenSchooling=childrenSchooling;
       this.childrenPlaceOfBirth=childrenPlaceOfBirth;
       this.observation=observation;
    
    }

    public Childrens() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Long getIdChildren (){
    return idChildren;
    }
    
    public String getChildrenPlaceOfBirth (){
    return childrenPlaceOfBirth;
    }
    
    public String getChildrenDateOfBirth (){
    return childrenDateOfBirth;
    }
    
    public String getChildrenFirstName (){
    return childrenFirstName;
    }
    
    public String getChildrenName (){
    return childrenName;
    }
    
    public String getChildrenSchooling (){
    return childrenSchooling;
    }
    
    public String getObservation (){
    return observation;
    }
    
    public void setIdChildren (Long idChildren){
    this.idChildren=idChildren;
    }    
    
    public void setChildrenPlaceOfBirth (String childrenPlaceOfBirth ){
    this.childrenPlaceOfBirth=childrenPlaceOfBirth;
    }
    
    public void setChildrenDateOfBirth (String childrenDateOfBirth ){
    this.childrenDateOfBirth=childrenDateOfBirth;
    }
    
    public void setChildrenFirstName (String childrenFirstName ){
    this.childrenFirstName=childrenFirstName;
    }
    
    public void setChildrenName (String childrenName ){
    this.childrenName=childrenName;
    }
    
    public void setChildrenSchooling (String childrenSchooling ){
    this.childrenSchooling=childrenSchooling;
    }
    
    public void setObservation (String observation){
    this.observation=observation;
    }
    
}

