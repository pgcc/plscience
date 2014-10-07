package br.com.ufjf.Testes.owlapi.main;

import java.io.Serializable;

/**
 * class AlgorithmsTask
 *
 * @author magnus, anrafel, jonathan
 *
 * auxilia classe MainGabriellaII
 *
 */
public class AlgorithmsTask implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nameTask;
    private String nameAlgorithm;
    private String local;
    private String type;

    public String getNameAlgorithm() {
        return nameAlgorithm;
    }

    public void setNameAlgorithm(String nameAlgorithm) {
        this.nameAlgorithm = nameAlgorithm;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

}
