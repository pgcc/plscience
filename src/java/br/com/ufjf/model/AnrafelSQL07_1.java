package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL07_1
 *
 * ( 7.1 )Os parâmetros passados nessa SQL são: o ID do Artefato que está
 * selecionado // e o do do Rationale que já está armazenado na Classe pela SQL
 * 7
 *
 * SELECT C.`nameScientist`, C.`institutionScientist`, G.`day`, G.`month`,
 * G.`year`, G.`time`, G.`minute`, H.`description` FROM `Rationale` A LEFT OUTER
 * JOIN `Who` B on (A.`idWho` = B.`idWho`) LEFT OUTER JOIN `User` C on
 * (B.`idScientist` = C.`idScientist`) LEFT OUTER JOIN `What` D on (A.`idWhat` =
 * D.`idWhat`) LEFT OUTER JOIN `Where` E on (A.`idWhere` = E.`idWhere`) LEFT
 * OUTER JOIN `ArtifactsUsed` F on (E.`idWhere` = F.`idWhere`) LEFT OUTER JOIN
 * `When` G on (A.idWhen = G.idWhen) LEFT OUTER JOIN `How` H on (A.idHow =
 * H.idHow)
 *
 * WHERE (F.`idArtifact` = 3) AND (A.`idRationale` = 1) nameScientist
 * institutionScientist day month year time minute description //idRationale
 * nameScientist institutionScientist description day month year time minute
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class AnrafelSQL07_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idRationale;
    private String NameScientist;
    private String institutionScientist;
    private String data;
    private String hora;
    private String description;

    public int getIdRationale() {
        return idRationale;
    }

    public void setIdRationale(int idRationale) {
        this.idRationale = idRationale;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}// ultima
