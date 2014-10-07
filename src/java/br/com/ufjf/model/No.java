package br.com.ufjf.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

/**
 * Class No
 *
 * @author magnus, anrafel, jonathan
 *
 */
@XmlRootElement(name = "No")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "No", propOrder = {"nome", "filhos", "pai"}, namespace = "http://mballem.wordpress.com/")
public class No implements Serializable {

    private static final long serialVersionUID = 1L;

    // Logica da selecao dos filhos (ENUM: AND, OR, ALT, PADRAO: AND)
    @XmlAttribute(name = "status_filhos", required = true)
    private String status_filhos;

    // Obrigacao de exibicao da feature com mandatory=true(Boolean)
    @XmlAttribute(name = "mandatory")
    private Boolean mandatory;

    // Nome da feature
    @XmlElement(name = "nome", required = true)
    private String nome;

    @XmlElement(name = "pai", required = true)
    private No pai;

    @XmlElementWrapper(name = "Filhos")
    @XmlElement(name = "No")
    private ArrayList<No> filhos;

    public String getStatusFilhos() {
        return status_filhos;
    }

    public void setStatusFilhos(String status_filhos) {
        this.status_filhos = status_filhos;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<No> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<No> filhos) {
        this.filhos = filhos;
    }

    @Override
    public String toString() {
        return "No{" + ", nome='" + nome + '\'' + ", pai='" + pai + '\''
                + ", filhos=" + filhos + '}';
    }
}
