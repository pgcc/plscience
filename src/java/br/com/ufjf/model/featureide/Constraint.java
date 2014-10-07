package br.com.ufjf.model.featureide;

import javax.xml.bind.annotation.*;

/**
 * Class Constraint
 *
 * @author magnus, anrafel, jonathan
 *
 */
@XmlRootElement(name = "constraint")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "constraint", propOrder = {}, namespace = "http://mballem.wordpress.com/")
public class Constraint {

    /*
     * Atributos
     */
    // Atributo de tipo
    @XmlAttribute(name = "type", required = true)
    private String type;

    /*
     * Getters e Setters
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*
     * Métodos
     */
    @Override
    public String toString() {
        return "Constraint{" + "}";
    }

}
