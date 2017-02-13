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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author amine
 */
@Entity
@NamedQuery(name = "Files.findAllByOrderByfileNameAsc", query="select u from Files u order by u.fileName")
public class Files {
      @Id
    @GeneratedValue (strategy = GenerationType.AUTO)      
    private Long     idFile;
    private String   fileName;
    private String   fileDate;
    private String   adress;
    private String   observation;
    @OneToMany 
    private List<Childrens> childrens;
    @OneToMany 
    private List<Alarm> alarms;
    @OneToOne(optional = true)
    private Beneficiary beneficiary;
    @OneToOne(optional = true)
    private Compagnon compagnon;
    
   public Files () {
    
    }
   Files (String fileName, String fileDate,String adress, String observation) {
       this.fileDate=fileDate;
       this.fileName=fileName;
       this.adress=adress;
       this.observation=observation;
    
    }
   Files (String fileName, String fileDate,String adress, String observation, Beneficiary beneficiary) {
       this.fileDate=fileDate;
       this.fileName=fileName;
       this.adress=adress;
       this.observation=observation;
       this.beneficiary=beneficiary;
    
    }
   Files (String fileName, String fileDate,String adress, String observation, Beneficiary beneficiary, Compagnon compagnon) {
       this.fileDate=fileDate;
       this.fileName=fileName;
       this.adress=adress;
       this.observation=observation;
       this.beneficiary=beneficiary;
       this.compagnon=compagnon;
    
    }
   Files (String fileName, String fileDate,String adress, String observation, 
           Beneficiary beneficiary, Compagnon compagnon, List<Childrens> childrens) {
       this.fileDate=fileDate;
       this.fileName=fileName;
       this.adress=adress;
       this.observation=observation;
       this.beneficiary=beneficiary;
       this.compagnon=compagnon;
       this.childrens=childrens;
    
    }
   
   public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }
   
   public Compagnon getCompagnon() {
        return compagnon;
    }

    public void setCompagnon(Compagnon compagnon) {
        this.compagnon = compagnon;
    }
   
   public List<Childrens> getChildrens() {
        return childrens;
    }
   public List<Alarm> getAlarms() {
        return alarms;
    }
    
    public Long getIdFile (){
    return idFile;
    }
        
    public  String getFileName (){
    return fileName;
    }    
    
    public String getFileDate (){
    return fileDate;
    }
    public String getAdress (){
    return adress;
    }
    
    public String getObservation (){
    return observation;
    }
    
    public void setIdFile (Long idFile){
    this.idFile=idFile;
    }
        
    public  void setFileName (String fileName){
    this.fileName=fileName;
    }    
    
    public void setFileDate (String fileDate ){
    this.fileDate=fileDate;
    }
    public void setAdress (String adress ){
    this.adress=adress;
    }
    
    public void setObservation (String observation){
    this.observation=observation;
    }
    

    public void setChildrens(List<Childrens> childrens) {
        this.childrens = childrens;
    }
    
    public void setAlarms(List<Alarm> alarms) {
        this.alarms = alarms;
    }
    
}


