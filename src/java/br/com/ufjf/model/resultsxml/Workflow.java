package br.com.ufjf.model.resultsxml;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

/**
 * Class Workflow
 *
 * @author magnus, anrafel, jonathan
 *
 */
@XmlRootElement(name = "Workflow")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Workflow", propOrder = {"processes", "connections"}, namespace = "http://mballem.wordpress.com/")
public class Workflow implements Serializable{

    private static final long serialVersionUID = 1L;
    /*
     * Atributos
     */
    /*
     * Elementos
     */
    //Elemento com a Classe que cont�m os Processos
    @XmlElementWrapper(name = "Processes")
    @XmlElement(name = "Process")
    private ArrayList<Process> processes;

    //Elemento com a Classe que cont�m os Processos
    @XmlElementWrapper(name = "Connections")
    @XmlElement(name = "Connection")
    private ArrayList<Connection> connections;


    /*
     * Getters and Setters
     */
    public ArrayList<Process> getProcess() {
        return processes;
    }

    public void setProcess(ArrayList<Process> process) {
        this.processes = process;
    }

    public ArrayList<Connection> getConnection() {
        return connections;
    }

    public void setConnection(ArrayList<Connection> connections) {
        this.connections = connections;
    }

    /*
     * Métodos
     */
    @Override
    public String toString() {
        return "Workflow{" + ", Process=" + processes + '\''
                + ", Connection='" + connections + '\'' + '}';
    }

}
