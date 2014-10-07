package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL09 (9) SQL para mostrar as últimas atividades realizadas na
 * abordagem (QUADRO NA TELA colocar dentro do Carrousel)
 *
 * SELECT A.`idRationale` , C.`nameScientist` , C.`institutionScientist` ,
 * D.`description` , G.`day` , G.`month` ,
 *
 * G.`year` , G.`time` , G.`minute` FROM `Rationale` A LEFT OUTER JOIN `Who` B
 * ON ( A.`idWho` = B.`idWho` ) LEFT OUTER JOIN `User` C ON ( B.`idScientist` =
 * C.`idScientist` ) LEFT OUTER JOIN `What` D ON ( A.`idWhat` = D.`idWhat` )
 * LEFT OUTER JOIN `Where` E ON ( A.`idWhere` = E.`idWhere` ) LEFT OUTER JOIN
 * `ArtifactsUsed` F ON ( E.`idWhere` = F.`idWhere` ) LEFT OUTER JOIN `When` G
 * ON ( A.idWhen = G.idWhen ) ORDER BY A.`idRationale` DESC LIMIT 5
 *
 *
 * idRationale nameScientist institutionScientist description day month year
 * time minute
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class AnrafelSQL09 implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idRationale;
    private int idScientist;
    private String nameScientist;
    private String institutionScientist;
    private String data;
    private String hora;
    private String description;
    private int nomeFoto;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNomeFoto() {
        return nomeFoto;
    }

    public void setNomeFoto(int nomeFoto) {
        this.nomeFoto = nomeFoto;
    }

    public int getIdScientist() {
        return idScientist;
    }

    public void setIdScientist(int idScientist) {
        this.idScientist = idScientist;
    }

    
    
}// ultima
