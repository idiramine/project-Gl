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
public class Articles {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)      
    private Long     idArticle;
    private String   description;
    private Long     quantity;
    private String   observation;
    
   Articles () {
    
    }
   Articles (String description, Long quantity, String observation) {
       this.description=description;
       this.quantity=quantity;
       this.observation=observation;
    
    }
    
    public Long getIdArticle (){
    return idArticle;
    }
        
    public Long getQuantity (){
    return quantity;
    }    
    
    public String getDescription (){
    return description;
    }
    
    public String getObservation (){
    return observation;
    }
    
    public void setIdArticle (Long idArticle){
    this.idArticle=idArticle;
    }
        
    public  void setQuantity (Long quantity){
    this.quantity=quantity;
    }    
    
    public void setDescription (String description ){
    this.description=description;
    }
    
    public void setObservation (String observation){
    this.observation=observation;
    }
    
}
