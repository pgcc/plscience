package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class NosObrigatory
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class NosObrigatory implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nome;
    private int id;
    private int pai;
    private boolean opcional;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPai() {
        return pai;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }

    public boolean isOpcional() {
        return opcional;
    }

    public void setOpcional(boolean opcional) {
        this.opcional = opcional;
    }

}
