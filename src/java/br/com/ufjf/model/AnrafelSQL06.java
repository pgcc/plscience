package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL06 //(6) SQL para exibir todas as mensagens do usuário SELECT
 * A.`idRationale`, F.`NameScientist` , F.`institutionScientist` ,
 * D.`description` , D.`productName`, A.`data`, A.`hora`, A.`lidaSN` FROM
 * `Communication` A LEFT OUTER JOIN `Rationale` C ON ( A.`idRationale` =
 * C.`idRationale` ) LEFT OUTER JOIN `What` D ON ( C.`idWhat` = D.`idWhat` )
 * LEFT OUTER JOIN `User` F ON (A.`idScientist_Emissor` = F.`idScientist`) WHERE
 * (A.`idScientist_Receptor` = 9)
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class AnrafelSQL06 implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idRationale;
    private String NameScientist;
    private String institutionScientist;
    private String description;
    private String productName;
    private String data;
    private String hora;
    private Boolean lidaSN;

    public String getNameScientist() {
        return NameScientist;
    }

    public void setNameScientist(String nameScientist) {
        NameScientist = nameScientist;
    }

    public String getInstitutionScientist() {
        return institutionScientist;
    }

    public void setInstitutionScientist(String institutionScientist) {
        this.institutionScientist = institutionScientist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Boolean getLidaSN() {
        return lidaSN;
    }

    public void setLidaSN(Boolean lidaSN) {
        this.lidaSN = lidaSN;
    }

    public int getIdRationale() {
        return idRationale;
    }

    public void setIdRationale(int idRationale) {
        this.idRationale = idRationale;
    }

}// ultima
