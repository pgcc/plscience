package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL02 receives (2) when the SQL for Scientist click the message
 * to make the Reading (Spending idRationale as parameter) sql: SELECT
 * A.`idRationale`, C.`nameScientist` , C.`institutionScientist` , G.`day` ,
 * G.`month` , G.`year` , G.`time` , G.`minute` , D.`description`
 * ,D.`productName` , H.`description` FROM `Rationale` A LEFT OUTER JOIN `Who` B
 * ON ( A.`idWho` = B.`idWho` ) LEFT OUTER JOIN `User` C ON ( B.`idScientist` =
 * C.`idScientist` ) LEFT OUTER JOIN `What` D ON ( A.`idWhat` = D.`idWhat` )
 * LEFT OUTER JOIN `Where` E ON ( A.`idWhere` = E.`idWhere` ) LEFT OUTER JOIN
 * `ArtifactsUsed` F ON ( E.`idWhere` = F.`idWhere` ) LEFT OUTER JOIN `When` G
 * ON ( A.idWhen = G.idWhen ) LEFT OUTER JOIN `How` H ON ( A.idHow = H.idHow )
 * WHERE (A.`idRationale` =1) LIMIT 1 return//nameScientist institutionScientist
 * day month year time minute description productName description
 *
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class AnrafelSQL02 implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idRationale;
    private String nameScientist;
    private String institutionScientist;
    private String date;
    private String time;
    private String description;
    private String how;// refere-se ao H.description
    private String productName;

    public String getNameScientist() {
        return nameScientist;
    }

    public void setNameScientist(String nameScientist) {
        this.nameScientist = nameScientist;
    }

    public String getInstitutionScientist() {
        return institutionScientist;
    }

    public void setInstitutionScientist(String institutionScientist) {
        this.institutionScientist = institutionScientist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public int getIdRationale() {
        return idRationale;
    }

    public void setIdRationale(int idRationale) {
        this.idRationale = idRationale;
    }

    public String getHow() {
        return how;
    }

    public void setHow(String how) {
        this.how = how;
    }

}// ultima
