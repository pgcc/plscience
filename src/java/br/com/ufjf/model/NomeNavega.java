package br.com.ufjf.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Class NomeNavega
 *
 * @author magnus, anrafel, jonathan
 *
 */
@ManagedBean
@SessionScoped
public class NomeNavega implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nomeNavega;

    public String getNomeNavega() {
        return nomeNavega;
    }

    public void setNomeNavega(String nomeNavega) {
        this.nomeNavega = nomeNavega;
    }

}
