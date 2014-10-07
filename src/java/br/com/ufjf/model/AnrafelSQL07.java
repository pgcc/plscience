package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL07 idRationale nameScientist institutionScientist description
 * day month year time minute
 *
 * ( 7 ) SQL para exibir os cientistas que já Editaram o artefato que está
 * selecionado //Esta SQL vai receber como parâmetros a descrição EDIT ARTIFACT
 * e o ID do Artefato que //está selecionado.
 *
 * SELECT A.`idRationale`, C.`NameScientist`, C.`institutionScientist` FROM
 * `Rationale` A LEFT OUTER JOIN `Who` B on (A.`idWho` = B.`idWho`) LEFT OUTER
 * JOIN `User` C on (B.`idScientist` = C.`idScientist`) LEFT OUTER JOIN `What` D
 * on (A.`idWhat` = D.`idWhat`) LEFT OUTER JOIN `Where` E on (A.`idWhere` =
 * E.`idWhere`) LEFT OUTER JOIN `ArtifactsUsed` F on (E.`idWhere` = F.`idWhere`)
 *
 * WHERE (D.`description` LIKE '%Edit Artifact%') AND (F.`idArtifact` = 3)
 *
 * idRationale NameScientist institutionScientist
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class AnrafelSQL07 implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idRationale;
    private String NameScientist;
    private String institutionScientist;

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

}// ultima
