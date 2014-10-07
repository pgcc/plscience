package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL09_3
 *
 * ( 9.3 ) SQL para trazer as notas feitas sobre este produto //O parâmetro
 * passado nessa SQL é o ID do Rationale que já está armazenado na Classe pela
 * SQL 7 SELECT A.`idRationale`, A.`description` FROM `Notes` A WHERE
 * A.`idRationale` = idRationale idRationale description
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class AnrafelSQL09_3 implements Serializable {

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
}// ultima
