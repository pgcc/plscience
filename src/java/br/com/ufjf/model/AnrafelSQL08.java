package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL08 SELECT A.`idRationale`, D.`productName`, C.`NameScientist`
 * FROM `Rationale` A LEFT OUTER JOIN `Who` B on (A.`idWho` = B.`idWho`) LEFT
 * OUTER JOIN `User` C on (B.`idScientist` = C.`idScientist`) LEFT OUTER JOIN
 * `What` D on (A.`idWhat` = D.`idWhat`) LEFT OUTER JOIN `Where` E on
 * (A.`idWhere` = E.`idWhere`) LEFT OUTER JOIN `ArtifactsUsed` F on (E.`idWhere`
 * = F.`idWhere`)
 *
 * WHERE (D.`description` LIKE '%Develop a Product%') AND (F.`idArtifact` = 3)
 * idRationale productName NameScientist
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class AnrafelSQL08 implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idRationale;
    private String nameScientist;
    private String productName;

    public int getIdRationale() {
        return idRationale;
    }

    public void setIdRationale(int idRationale) {
        this.idRationale = idRationale;
    }

    public String getNameScientist() {
        return nameScientist;
    }

    public void setNameScientist(String nameScientist) {
        this.nameScientist = nameScientist;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}// ultima
