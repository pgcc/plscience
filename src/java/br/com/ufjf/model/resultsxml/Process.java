package br.com.ufjf.model.resultsxml;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

/**
 * Class Mapping
 *
 * @author magnus, anrafel, jonathan
 *
 */
@XmlRootElement(name = "Process")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "process", propOrder = {"parameters"}, namespace = "http://mballem.wordpress.com/")
public class Process implements Serializable{

    private static final long serialVersionUID = 1L;

    // Nome do Processo
    @XmlAttribute(name = "name", required = true)
    private String name;

    // Identificador do Processo
    @XmlAttribute(name = "id", required = true)
    private String id;

    // Classe de Parametros
    @XmlElementWrapper(name = "Parameters")
    @XmlElement(name = "Parameter")
    private ArrayList<Parameter> parameters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Parameter> getParameter() {
        return parameters;
    }

    public void setParameter(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Process{" + ", name='" + name + '\''
                + ", id='" + id + '\''
                + ", Parameter='" + parameters + '\'' + '}';
    }
}
