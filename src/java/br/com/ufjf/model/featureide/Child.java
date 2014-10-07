package br.com.ufjf.model.featureide;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

/**
 * Class Child
 *
 * @author magnus, anrafel, jonathan
 *
 */
@XmlRootElement(name = "child")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "child", propOrder = {"id"}, namespace = "http://mballem.wordpress.com/")
public class Child implements Serializable{

    private static final long serialVersionUID = 1L;
    /*
     * Atributos
     */
    // Atributo de opcionalidade
    @XmlAttribute(name = "optional", required = true)
    private Boolean optional;

    /*
     * Elementos
     */
    // Atributo classes
    @XmlElement(name = "id")
    private int id;

    /*
     * Getters e Setters
     */
    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*
     * Métodos
     */
    @Override
    public String toString() {
        return "Child{" + ", id=" + id + '}';
    }

}
