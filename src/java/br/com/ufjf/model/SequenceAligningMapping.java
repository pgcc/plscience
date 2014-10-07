package br.com.ufjf.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

/**
 * Class SequenceAligningMapping
 *
 * @author magnus, anrafel, jonathan
 *
 */
@XmlRootElement(name = "SequenceAligningMapping")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SequenceAligningMapping", propOrder = {"mapping"}, namespace = "http://mballem.wordpress.com/")
public class SequenceAligningMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "mapping")
    private ArrayList<Mapping> mapping;

    public ArrayList<Mapping> getMapping() {
        return mapping;
    }

    public void setMapping(ArrayList<Mapping> mapping) {
        this.mapping = mapping;
    }

    @Override
    public String toString() {
        return "SequenceAligningMapping{" + ", mapping=" + mapping + '}';
    }
}
