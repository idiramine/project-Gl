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
public class Alarm {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)      
    private Long     idAlarm;
    private String title;    
    
    
    
    
}
