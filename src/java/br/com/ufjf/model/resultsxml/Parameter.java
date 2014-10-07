package br.com.ufjf.model.resultsxml;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

/**
 * Class Parameter
 *
 * @author magnus, anrafel, jonathan
 *
 */
@XmlRootElement(name = "Parameter")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Parameter", propOrder = {}, namespace = "http://mballem.wordpress.com/")
public class Parameter implements Serializable{

    private static final long serialVersionUID = 1L;
    // Nome do Processo
    @XmlAttribute(name = "name", required = true)
    private String name;

    // Source
    @XmlAttribute(name = "value", required = true)
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Parameter{" + ", name='" + name + '\'' + ", value='" + value + '\'' + '}';
    }
}
