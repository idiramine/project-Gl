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

/**
 *
 * @author youssef
 */
@Entity
public class questions {
    
      @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
     public Long idQuestion;
     public String textQuestion;
     public String dateQuestion;
     public String authorQuestion;
     public String mailQuestion;
     public String reponseQuestion;

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public String getDateQuestion() {
        return dateQuestion;
    }

    public void setDateQuestion(String dateQuestion) {
        this.dateQuestion = dateQuestion;
    }

    public String getAuthorQuestion() {
        return authorQuestion;
    }

    public void setAuthorQuestion(String authorQuestion) {
        this.authorQuestion = authorQuestion;
    }

    public String getMailQuestion() {
        return mailQuestion;
    }

    public void setMailQuestion(String mailQuestion) {
        this.mailQuestion = mailQuestion;
    }

    public String getReponseQuestion() {
        return reponseQuestion;
    }

    public void setReponseQuestion(String reponseQuestion) {
        this.reponseQuestion = reponseQuestion;
    }

    public questions() {
    }

    public questions(String textQuestion, String dateQuestion, String authorQuestion, String mailQuestion, String reponseQuestion) {
        this.textQuestion = textQuestion;
        this.dateQuestion = dateQuestion;
        this.authorQuestion = authorQuestion;
        this.mailQuestion = mailQuestion;
        this.reponseQuestion = reponseQuestion;
    }
     
     
}
