package br.com.ufjf.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class ActionSystem
 *
 * @author magnus, anrafel, jonathan
 *
 */
@XmlRootElement(name = "ActionSystem")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://mballem.wordpress.com/")
public class ActionSystem implements Serializable{

    private static final long serialVersionUID = 1L;
    @XmlAttribute(name = "horaAction", required = true)
    private String horaAction;

    @XmlElement(name = "methodName", required = true)
    private String methodName;

    @XmlElement(name = "info", required = true)
    private String info;

    public String getHoraAction() {
        return horaAction;
    }

    public void setHoraAction(String horaAction) {
        this.horaAction = horaAction;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ActionLogSystem [methodName=" + methodName + ", info=" + info
                + "]";
    }

}
