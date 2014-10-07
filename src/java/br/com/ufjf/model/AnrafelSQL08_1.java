package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL08_1
 *
 * ( 8.1 )Os parâmetros passados nessa SQL são: o ID do Artefato que está
 * selecionado // e o do do Rationale que já está armazenado na Classe pela SQL
 * 8
 *
 * SELECT A.`idRationale`, C.`nameScientist`, C.`institutionScientist`, G.`day`,
 * G.`month`, G.`year`, G.`time`, G.`minute`, H.`description`, D.`ProductName`
 * FROM `Rationale` A LEFT OUTER JOIN `Who` B on (A.`idWho` = B.`idWho`) LEFT
 * OUTER JOIN `User` C on (B.`idScientist` = C.`idScientist`) LEFT OUTER JOIN
 * `What` D on (A.`idWhat` = D.`idWhat`) LEFT OUTER JOIN `Where` E on
 * (A.`idWhere` = E.`idWhere`) LEFT OUTER JOIN `ArtifactsUsed` F on (E.`idWhere`
 * = F.`idWhere`) LEFT OUTER JOIN `When` G on (A.`idWhen` = G.`idWhen`) LEFT
 * OUTER JOIN `How` H on (A.`idHow` = H.`idHow`)
 *
 * WHERE (F.`idArtifact` = 3) AND (A.`idRationale` = 1)
 *
 * idRationale nameScientist institutionScientist day month year time minute
 * description ProductName
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class AnrafelSQL08_1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idRationale;
    private String nameScientist;
    private String institutionScientist;
    private String data;
    private String hora;
    private String productName;
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

    public String getInstitutionScientist() {
        return institutionScientist;
    }

    public void setInstitutionScientist(String institutionScientist) {
        this.institutionScientist = institutionScientist;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}// ultima
