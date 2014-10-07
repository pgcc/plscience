package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL04 ( 4 ) SQL para Trazer as notas feitas sobre este produto
 * SELECT A.`idRationale`, A.`description` FROM `Notes` A WHERE A.`idRationale`
 * = idRationale
 *
 * @category author magnus, anrafel, jonathan
 *
 */
public class AnrafelSQL04 implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idRationale;
    private String description;

    public int getIdRationale() {
        return idRationale;
    }

    public void setIdRationale(int idRationale) {
        this.idRationale = idRationale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}// ultimo
