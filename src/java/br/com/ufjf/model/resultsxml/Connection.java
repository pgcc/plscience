package br.com.ufjf.model.resultsxml;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

/**
 * Class Mapping
 *
 * @author magnus, anrafel, jonathan
 *
 */
@XmlRootElement(name = "Connection")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Connection", propOrder = {}, namespace = "http://mballem.wordpress.com/")
public class Connection implements Serializable{

    private static final long serialVersionUID = 1L;
    // Nome do Processo
    @XmlAttribute(name = "name", required = true)
    private String name;

    // Source
    @XmlAttribute(name = "source", required = true)
    private String source;

    // Target
    @XmlAttribute(name = "target", required = true)
    private String target;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Connection{" + ", name='" + name + '\'' + ", source='" + source + '\''
                + ", target='" + target + '\'' + '}';
    }
}
