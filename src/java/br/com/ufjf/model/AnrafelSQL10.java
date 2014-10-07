package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL09 (9) SQL para mostrar as últimas atividades realizadas na
 * abordagem (QUADRO NA TELA colocar dentro do Carrousel)
 *
 *
 *
 * SELECT A.`idRationale` , C.`NameScientist` , C.`institutionScientist` FROM
 * `Rationale` A LEFT OUTER JOIN `Whotable` B ON ( A.`idWho` = B.`idWho` ) LEFT
 * OUTER JOIN `User` C ON ( B.`idScientist` = C.`idScientist` ) LEFT OUTER JOIN
 * `Whattable` D ON ( A.`idWhat` = D.`idWhat` ) WHERE ( D.`ProductName` LIKE
 * '%Pipe%') AND (A.`idRationale` <>1)
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class AnrafelSQL10 implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idRationale;
    private String nameScientist;
    private String ProductName;

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
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

}// ultima
