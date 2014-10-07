package br.com.ufjf.Testes.owlapi.main;

import java.io.Serializable;

/**
 * class MapTaskAlgorithm
 *
 * @author magnus, anrafel, jonathan
 *
 * auxilia classe TarefaAlgoritmo
 *
 */
public class MapTaskAlgorithm implements Serializable {

    private static final long serialVersionUID = 1L;
    private String taskNameClass;
    private String algorithmNameClass;

    public String getTaskNameClass() {
        return taskNameClass;
    }

    public void setTaskNameClass(String taskNameClass) {
        this.taskNameClass = taskNameClass;
    }

    public String getAlgorithmNameClass() {
        return algorithmNameClass;
    }

    public void setAlgorithmNameClass(String algorithmNameClass) {
        this.algorithmNameClass = algorithmNameClass;
    }

}
