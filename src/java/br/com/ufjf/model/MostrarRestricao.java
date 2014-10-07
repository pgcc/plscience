package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class MostrarRestricao
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class MostrarRestricao implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nomeRestricao;

    public String getNomeRestricao() {
        return nomeRestricao;
    }

    public void setNomeRestricao(String nomeRestricao) {
        this.nomeRestricao = nomeRestricao;
    }

}
