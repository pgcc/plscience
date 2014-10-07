package br.com.ufjf.model.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author magnus
 */
@Entity
@Table(name = "Roles", catalog = "collaborate"
)
public class Roles implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer role_id;
    private String role_description;

    public Roles() {
    }

    public Roles(Integer role_id, String role_description) {
        this.role_id = role_id;
        this.role_description = role_description;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "role_id", unique = true, nullable = false)
    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    @Column(name = "role_description", nullable = false, length = 20)
    public String getRole_description() {
        return role_description;
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

}
