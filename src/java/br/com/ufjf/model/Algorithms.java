package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class ShowProcess
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class Algorithms implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nomeAlgorithm;

    public String getNomeAlgorithm() {
        return nomeAlgorithm;
    }

    public void setNomeAlgorithm(String nomeAlgorithm) {
        this.nomeAlgorithm = nomeAlgorithm;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
