package br.com.ufjf.model.main;
// Generated 13/01/2014 11:59:13 by Hibernate Tools 3.6.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "User", catalog = "collaborate"
)
public class User implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idScientist;
    private Integer role_id;
    private String login;
    private String password;
    private String nameScientist;
    private String cpfscientist;
    private String emailScientist;
    private String institutionScientist;
    private String status;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(int role_id, String login, String password, String nameScientist, String cpfscientist, String emailScientist, String institutionScientist, String status) {
        this.role_id = role_id;
        this.login = login;
        this.password = password;
        this.nameScientist = nameScientist;
        this.cpfscientist = cpfscientist;
        this.emailScientist = emailScientist;
        this.institutionScientist = institutionScientist;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idScientist", unique = true, nullable = false)
    public Integer getIdScientist() {
        return this.idScientist;
    }

    public void setIdScientist(Integer idScientist) {
        this.idScientist = idScientist;
    }

    @Column(name = "login", nullable = false, length = 32)
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "NameScientist", length = 100)
    public String getNameScientist() {
        return this.nameScientist;
    }

    public void setNameScientist(String nameScientist) {
        this.nameScientist = nameScientist;
    }

    @Column(name = "CPFScientist", length = 45)
    public String getCpfscientist() {
        return this.cpfscientist;
    }

    public void setCpfscientist(String cpfscientist) {
        this.cpfscientist = cpfscientist;
    }

    @Column(name = "emailScientist", length = 100)
    public String getEmailScientist() {
        return this.emailScientist;
    }

    public void setEmailScientist(String emailScientist) {
        this.emailScientist = emailScientist;
    }

    @Column(name = "InstitutionScientist", length = 100)
    public String getInstitutionScientist() {
        return this.institutionScientist;
    }

    public void setInstitutionScientist(String institutionScientist) {
        this.institutionScientist = institutionScientist;
    }

    @Column(name = "Status", length = 45)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "role_id", length = 45)
    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

}
