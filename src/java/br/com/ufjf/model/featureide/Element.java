package br.com.ufjf.model.featureide;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

/**
 * Class Element
 *
 * @author magnus, anrafel, jonathan
 *
 */
@XmlRootElement(name = "element")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "element", propOrder = {"path_absolut", "path_relativ",
    "parentElement", "constraints", "childElements", "order", "classes"}, namespace = "http://mballem.wordpress.com/")
public class Element {

    /*
     * Atributos
     */
    // Atributo de dinamicidade
    @XmlAttribute(name = "dynamic", required = true)
    private Boolean dynamic;

    // Atributo identificador do elemento
    @XmlAttribute(name = "id", required = true)
    private int id;

    // Atributo de nome
    @XmlAttribute(name = "name", required = true)
    private String name;

    // Atributo de opcionalidade
    @XmlAttribute(name = "optional", required = true)
    private Boolean optional;

    // Atributo de tipo
    @XmlAttribute(name = "type", required = true)
    private String type;

    /*
     * Elementos
     */
    // Atributo path_absolut
    @XmlElement(name = "path_absolut")
    private String path_absolut;

    // Atributo path_relativ
    @XmlElement(name = "path_relativ")
    private String path_relativ;

    // Atributo parentElement
    @XmlElement(name = "parentElement")
    private ParentElement parentElement;

    // Atributo constraints - restrições da feature
    @XmlElementWrapper(name = "constraints")
    @XmlElement(name = "constraint")
    private ArrayList<Constraint> constraints;

    // Atributo childElements - informações dos filhos da feature
    @XmlElementWrapper(name = "childElements")
    @XmlElement(name = "child")
    private ArrayList<Child> childElements;

    // Atributo order
    @XmlElement(name = "order")
    private Constraint order;

    // Atributo classes
    @XmlElement(name = "classes")
    private Constraint classes;

    /*
     * Getters e Setters
     */
    public Boolean getDynamic() {
        return dynamic;
    }

    public void setDynamic(Boolean dynamic) {
        this.dynamic = dynamic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath_absolut() {
        return path_absolut;
    }

    public void setPath_absolut(String path_absolut) {
        this.path_absolut = path_absolut;
    }

    public String getPath_relativ() {
        return path_relativ;
    }

    public void setPath_relativ(String path_relativ) {
        this.path_relativ = path_relativ;
    }

    public ArrayList<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(ArrayList<Constraint> constraints) {
        this.constraints = constraints;
    }

    public ArrayList<Child> getChildElements() {
        return childElements;
    }

    public void setChildElements(ArrayList<Child> childElements) {
        this.childElements = childElements;
    }

    public Constraint getOrder() {
        return order;
    }

    public void setOrder(Constraint order) {
        this.order = order;
    }

    public Constraint getClasses() {
        return classes;
    }

    public void setClasses(Constraint classes) {
        this.classes = classes;
    }

    public ParentElement getParentElement() {
        return parentElement;
    }

    public void setParentElement(ParentElement parentElement) {
        this.parentElement = parentElement;
    }

    /*
     * Métodos
     */
    @Override
    public String toString() {
        return "Element{" + ", path_absolut='" + path_absolut + '\''
                + ", path_relativ='" + path_relativ + '\'' + ", constraints="
                + constraints + '\'' + ", childElements='" + childElements
                + '\'' + ", order='" + order + '\'' + ", classes='" + classes
                + '}';
    }

}
