/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author youssef
 */
@Entity
public class commentaires {
      @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
     private Long idComment;
     private String textComment;
     private Date dateComment;
     private String authorComment;
      @ManyToOne
    @JoinColumn(name="idThemeEvent")
    private pubblications pubComm;

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }

    public String getAuthorComment() {
        return authorComment;
    }

    public void setAuthorComment(String authorComment) {
        this.authorComment = authorComment;
    }

    public pubblications getPubComm() {
        return pubComm;
    }

    public void setPubComm(pubblications pubComm) {
        this.pubComm = pubComm;
    }

    public commentaires() {
    }

    public commentaires(String textComment, Date dateComment, String authorComment, pubblications pubComm) {
        this.textComment = textComment;
        this.dateComment = dateComment;
        this.authorComment = authorComment;
        this.pubComm = pubComm;
    }
     
      
}
