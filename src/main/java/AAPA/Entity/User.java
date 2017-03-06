package AAPA.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * Class Person which use to have informations for a Person
 * 
 * @author UJM student's
 */
@Entity
public class User/* implements Serializable*/ {
    
   // private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUser;
    @NotNull
    private String login;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String role;

    public User() {}
    
    public User(String lastName, String firstName, String login, String passwordHash, String mail, String role) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.login = login;
        this.password = passwordHash;
        this.email = mail;
        this.role = role;
    }
    public User(String login, String passwordHash,String role) {
        
        this.login = login;
        this.password = passwordHash;
        this.role = role;
    }

    public long getIdUser() {
        return idUser;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
