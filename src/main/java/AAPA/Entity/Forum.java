/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author youssef
 */
@Entity
public class Forum {
    
        @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
   private Long idForum;
   private String titleForum;
   private String auterForum;
   private Date dateForum;
   
 @OneToMany
   private List<commentairesForum> CommForum;

    public Long getIdForum() {
        return idForum;
    }

    public void setIdForum(Long idForum) {
        this.idForum = idForum;
    }

    public String getTitleForum() {
        return titleForum;
    }

    public void setTitleForum(String titleForum) {
        this.titleForum = titleForum;
    }

    public String getAuterForum() {
        return auterForum;
    }

    public void setAuterForum(String auterForum) {
        this.auterForum = auterForum;
    }

    public Date getDateForum() {
        return dateForum;
    }

    public void setDateForum(Date dateForum) {
        this.dateForum = dateForum;
    }

    public List<commentairesForum> getCommForum() {
        return CommForum;
    }

    public void setCommForum(List<commentairesForum> CommForum) {
        this.CommForum = CommForum;
    }

    public Forum(String titleForum, String auterForum, Date dateForum) {
        this.titleForum = titleForum;
        this.auterForum = auterForum;
        this.dateForum = dateForum;
    }

    public Forum() {
    }

}