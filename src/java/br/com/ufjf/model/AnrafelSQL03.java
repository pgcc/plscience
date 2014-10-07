package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL03 SQL://(3) SQL para trazer os artefatos que foram
 * utilizados na ATIVIDADE que está selecionado pelo cientista SELECT
 * A.`idRationale`, D.`name` , D.`type` FROM `Rationale` A LEFT OUTER JOIN
 * `Where` B ON ( A.`idWhere` = B.`idWhere` ) LEFT OUTER JOIN `ArtifactsUsed` C
 * ON ( B.`idWhere` = C.`idWhere` ) LEFT OUTER JOIN `Artifact` D ON (
 * C.`idArtifact` = D.`idArtifact` ) WHERE (A.`idRationale` =1) LIMIT 0 , 30
 *
 *
 * @category author magnus, anrafel, jonathan
 *
 */
public class AnrafelSQL03 implements Serializable {

    private static final long serialVersionUID = 1L;
    /*
     * 
     */

    private int idRationale;
    private String name;
    private String type;

    public int getIdRationale() {
        return idRationale;
    }

    public void setIdRationale(int idRationale) {
        this.idRationale = idRationale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
