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
import javax.persistence.OneToOne;

/**
 *
 * @author amine
 */
@Entity
public class Donations {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)      
    private Long     idDonation;
    private Long     donationQuantity;
    private String   donationDate;
    private String   observation;
    @OneToOne
    private Files file;
    @OneToOne
    private Articles article;
    
    
    public Donations () {
    
    }
   Donations (String donationDate, Long donationQuantity, String observation, Files file, Articles article) {
       this.donationDate=donationDate;
       this.donationQuantity=donationQuantity;
       this.observation=observation;
       this.article=article;
       this.file=file;
    
    }
   
    
    public Long getIdDonation (){
    return idDonation;
    }
    
    public Files getFile(){
    return file;
    }
    
    
    public Articles getArticle(){
    return article;
    }
    
    public Long getDonationQuantity (){
    return donationQuantity;
    }    
    
    public String getDonationDate (){
    return donationDate;
    }
    
    public String getObservation (){
    return observation;
    }
    
    public void setIdDonation (Long idDonation){
    this.idDonation=idDonation;
    }
        
    public  void setDonationQuantity (Long donationQuantity){
    this.donationQuantity=donationQuantity;
    }    
    
    public void setDonationDate (String donationDate ){
    this.donationDate=donationDate;
    }
    
    public void setobservation (String observation){
    this.observation=observation;
    }
    
    public void setFile(Files file){
    this.file=file;
    }
    
    
    public void setArticle(Articles article){
    this.article=article;
    }
    
}
