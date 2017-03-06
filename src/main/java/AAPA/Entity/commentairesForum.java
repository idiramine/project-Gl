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
public class commentairesForum {
     @Id
         @GeneratedValue(strategy=GenerationType.AUTO)
     private Long idCommentForm;
     private String textCommentForm;
     private Date dateCommentForm;
     private String authorCommentForm;
      @ManyToOne
    @JoinColumn(name="idformComm")
    private Forum formComm;

    public Long getIdCommentForm() {
        return idCommentForm;
    }

    public void setIdCommentForm(Long idCommentForm) {
        this.idCommentForm = idCommentForm;
    }

    public String getTextCommentForm() {
        return textCommentForm;
    }

    public void setTextCommentForm(String textCommentForm) {
        this.textCommentForm = textCommentForm;
    }

    public Date getDateCommentForm() {
        return dateCommentForm;
    }

    public void setDateCommentForm(Date dateCommentForm) {
        this.dateCommentForm = dateCommentForm;
    }

    public String getAuthorCommentForm() {
        return authorCommentForm;
    }

    public void setAuthorCommentForm(String authorCommentForm) {
        this.authorCommentForm = authorCommentForm;
    }

    public Forum getFormComm() {
        return formComm;
    }

    public void setFormComm(Forum formComm) {
        this.formComm = formComm;
    }

    public commentairesForum(String textCommentForm, Date dateCommentForm, String authorCommentForm) {
        this.textCommentForm = textCommentForm;
        this.dateCommentForm = dateCommentForm;
        this.authorCommentForm = authorCommentForm;
    }

    public commentairesForum() {
    }

}
