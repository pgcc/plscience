package br.com.ufjf.model.featureide;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

/**
 * Class Plm
 *
 * @author magnus, anrafel, jonathan
 *
 */
@XmlRootElement(name = "plm")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "plm", propOrder = {"element"}, namespace = "http://mballem.wordpress.com/")
public class Plm {

    /*
     * Atributos
     */
    //Atributo de Reuso
    @XmlAttribute(name = "canReuseInstance", required = true)
    private Boolean canReuseInstance;

    //Atributo Nome
    @XmlAttribute(name = "name", required = true)
    private String name;

    /*
     * Elementos
     */
    //ArrayList com os Elementos do Modelo de Features
    @XmlElement(name = "element")
    private ArrayList<Element> element;

    /*
     * Getters and Setters
     */
    public ArrayList<Element> getElement() {
        return element;
    }

    public void setElement(ArrayList<Element> element) {
        this.element = element;
    }

    public Boolean getCanReuseInstance() {
        return canReuseInstance;
    }

    public void setCanReuseInstance(Boolean canReuseInstance) {
        this.canReuseInstance = canReuseInstance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Métodos
     */
    @Override
    public String toString() {
        return "Plm{" + ", element=" + element + '}';
    }
}
