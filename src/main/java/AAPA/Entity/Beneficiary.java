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
public class Beneficiary {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)      
    private Long     idBeneficiary;
    private String   beneficiaryName;
    private String   beneficiaryFirstName; //prénom
    private String   beneficiaryDateOfBirth;
    private String   beneficiaryPlaceOfBirth;
    private String   beneficiarySituation;
    private String   observation;
    // clé etrangéres
    // IdCompagnon
    // IdFile
    
   
   Beneficiary (String beneficiarySituation, 
              String observation,
              String beneficiaryName,
              String beneficiaryFirstName,
              String beneficiaryDateOfBirth,
              String beneficiaryPlaceOfBirth) {
       this.beneficiaryDateOfBirth=beneficiaryDateOfBirth;
       this.beneficiaryFirstName=beneficiaryFirstName;
       this.beneficiaryName=beneficiaryName;
       this.beneficiarySituation=beneficiarySituation;
       this.beneficiaryPlaceOfBirth=beneficiaryPlaceOfBirth;
       this.observation=observation;
    
    }

    public Beneficiary() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Long getIdBeneficiary (){
    return idBeneficiary;
    }
    
    public String getBeneficiaryPlaceOfBirth (){
    return beneficiaryPlaceOfBirth;
    }
    
    public String getBeneficiaryDateOfBirth (){
    return beneficiaryDateOfBirth;
    }
    
    public String getBeneficiaryFirstName (){
    return beneficiaryFirstName;
    }
    
    public String getBeneficiaryName (){
    return beneficiaryName;
    }
    
    public String getBeneficiarySituation (){
    return beneficiarySituation;
    }
    
    public String getObservation (){
    return observation;
    }
    
    public void setIdBeneficiary (Long idBeneficiary){
    this.idBeneficiary=idBeneficiary;
    }    
    
    public void setBeneficiaryPlaceOfBirth (String beneficiaryPlaceOfBirth ){
    this.beneficiaryPlaceOfBirth=beneficiaryPlaceOfBirth;
    }
    
    public void setBeneficiaryDateOfBirth (String beneficiaryDateOfBirth ){
    this.beneficiaryDateOfBirth=beneficiaryDateOfBirth;
    }
    
    public void setBeneficiaryFirstName (String beneficiaryFirstName ){
    this.beneficiaryFirstName=beneficiaryFirstName;
    }
    
    public void setBeneficiaryName (String beneficiaryName ){
    this.beneficiaryName=beneficiaryName;
    }
    
    public void setBeneficiarySituation (String beneficiarySituation ){
    this.beneficiarySituation=beneficiarySituation;
    }
    
    public void setObservation (String observation){
    this.observation=observation;
    }
     
}

