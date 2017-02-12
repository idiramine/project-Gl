/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Entity;

import java.util.Date;
import java.util.Timer;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author amine
 */
@Entity
public class Alarm {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)      
    public Long     idAlarm;
    public String title;   
    public String periodicite;//journalier, mensuel, hebdomadaire, aucune
    public String dateDebut;
    boolean traité;
    public String dateDernierTraitement;
    
    public Alarm(){
    
    }
    
    Alarm(String title, String periodicite, String dateDebut){
    this.dateDebut=dateDebut;
    this.periodicite=periodicite;
    this.title=title;
    }
    
    public Long getidAlarm(){
    return this.idAlarm;
    }
    public String getdateDebut(){
    return this.dateDebut;
    }
    public String getdateDernierTraitement(){
    return this.dateDernierTraitement;
    }
    public String getperiodicite(){
    return this.periodicite;
    }
    public String gettitle(){
    return this.title;
    }
    public boolean gettraite(){
    return this.traité;
    }
    
    public void setidAlarm(long idAlarm){
    this.idAlarm=idAlarm;
    }
    public void setdateDebut(String dateDebut){
    this.dateDebut=dateDebut;
    }
    public void setdateDernierTraitement(String dateDernierTraitement){
    this.dateDernierTraitement=dateDernierTraitement;
    }
    public void setperiodicite(String periodicite){
    this.periodicite=periodicite;
    }
    public void settitle(String title){
    this.title=title;
    }
    public void settraite(boolean traite){
    this.traité=traite;
    }
    
}
