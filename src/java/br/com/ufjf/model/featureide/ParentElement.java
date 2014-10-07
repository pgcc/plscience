package br.com.ufjf.model.featureide;

import javax.xml.bind.annotation.*;

/**
 * Class ParentElement
 *
 * @author magnus, anrafel, jonathan
 *
 */
@XmlRootElement(name = "parentElement")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parentElement", propOrder = {"id"}, namespace = "http://mballem.wordpress.com/")
public class ParentElement {

    /*
     * Atributos
     */

    /*
     * Elementos
     */
    // Atributo classes
    @XmlElement(name = "id")
    private int id;

    /*
     * Getters e Setters
     */
    public int getId() {
        return id - 2;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*
     * Métodos
     */
    @Override
    public String toString() {
        return "ParentElement{" + ", id=" + id + '}';
    }

}
