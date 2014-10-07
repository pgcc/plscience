package br.com.ufjf.model;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

/**
 * Class Mapping
 *
 * @author magnus, anrafel, jonathan
 *
 */
@XmlRootElement(name = "Mapping")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Mapping", propOrder = {"className", "featureName"}, namespace = "http://mballem.wordpress.com/")
public class Mapping implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // Identificador do mapeamento
    @XmlAttribute(name = "id", required = true)
    private int id;

    // Nome da Classe na Ontologia
    @XmlElement(name = "className", required = true)
    private String className;

    // Nome da Feature no Modelo de Features
    @XmlElement(name = "featureName", required = true)
    private String featureName;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureName() {
        return featureName;
    }

    @Override
    public String toString() {
        return "Mapping{" + ", className='" + className + '\''
                + ", featureName='" + featureName + '\'' + '}';
    }
}
