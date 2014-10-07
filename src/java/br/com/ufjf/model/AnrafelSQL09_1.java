package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL09_1 ( 9.1 ) SQL para quando o Cientista Clicar para
 * Visualizar as informações sobre a atividade do cientista que ele selecionou
 *
 * SELECT A.`idRationale`, C.`nameScientist` , C.`institutionScientist` ,
 * G.`day` , G.`month` , G.`year` , G.`time` ,
 *
 * G.`minute` , D.`productName` , H.`description` FROM `Rationale` A LEFT OUTER
 * JOIN `Who` B ON ( A.`idWho` = B.`idWho` ) LEFT OUTER JOIN `User` C ON (
 * B.`idScientist` = C.`idScientist` ) LEFT OUTER JOIN `What` D ON ( A.`idWhat`
 * = D.`idWhat` ) LEFT OUTER JOIN `Where` E ON ( A.`idWhere` = E.`idWhere` )
 * LEFT OUTER JOIN `ArtifactsUsed` F ON ( E.`idWhere` = F.`idWhere` ) LEFT OUTER
 * JOIN `When` G ON ( A.idWhen = G.idWhen ) LEFT OUTER JOIN `How` H ON ( A.idHow
 * = H.idHow ) WHERE (A.`idRationale` =1) LIMIT 1
 *
 * idRationale nameScientist institutionScientist day month year time minute
 * productName description
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class AnrafelSQL09_1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idRationale;
    private String nameScientist;
    private String data;
    private String hora;
    private String productName;
    private String institutionScientist;
    private String description;

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

}// ultima
