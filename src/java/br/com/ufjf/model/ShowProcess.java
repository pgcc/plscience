package br.com.ufjf.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class ShowProcess
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class ShowProcess implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nomeShowProcess;
    private String algoritmsSN;

    private ArrayList<Algorithms> algorithms;

    public String getNomeShowProcess() {
        return nomeShowProcess;
    }

    public void setNomeShowProcess(String nomeShowProcess) {
        this.nomeShowProcess = nomeShowProcess;
    }

    public ArrayList<Algorithms> getAlgorithms() {
        return algorithms;
    }

    public void setAlgorithms(ArrayList<Algorithms> algorithms) {
        this.algorithms = algorithms;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getAlgoritmsSN() {
        return algoritmsSN;
    }

    public void setAlgoritmsSN(String algoritmsSN) {
        this.algoritmsSN = algoritmsSN;
    }

}
