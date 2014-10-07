package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AnrafelSQL01 receives (1) SQL to check for new messages to the
 * scientist. This SQL only checks for new messages (do not read)
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class AnrafelSQL01 implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idComunication;
    private String message;
    private int idRationale;
    private String Subfeature;
    private int idScientist_Receptor;
    private int idScientist_Emissor;
    private String data;
    private String hora;
    private Boolean lidaSN;

    public int getIdComunication() {
        return idComunication;
    }

    public void setIdComunication(int idComunication) {
        this.idComunication = idComunication;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIdRationale() {
        return idRationale;
    }

    public void setIdRationale(int idRationale) {
        this.idRationale = idRationale;
    }

    public String getSubfeature() {
        return Subfeature;
    }

    public void setSubfeature(String subfeature) {
        Subfeature = subfeature;
    }

    public int getIdScientist_Receptor() {
        return idScientist_Receptor;
    }

    public void setIdScientist_Receptor(int idScientist_Receptor) {
        this.idScientist_Receptor = idScientist_Receptor;
    }

    public int getIdScientist_Emissor() {
        return idScientist_Emissor;
    }

    public void setIdScientist_Emissor(int idScientist_Emissor) {
        this.idScientist_Emissor = idScientist_Emissor;
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

}// ultima
