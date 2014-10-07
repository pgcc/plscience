package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class ProductDevArtifact
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class ProductDevArtifact implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idRationale;
    private int idScientist;
    private String productName;
    private String nameScientist;

    public int getIdRationale() {
        return idRationale;
    }

    public void setIdRationale(int idRationale) {
        this.idRationale = idRationale;
    }

    public int getIdScientist() {
        return idScientist;
    }

    public void setIdScientist(int idScientist) {
        this.idScientist = idScientist;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNameScientist() {
        return nameScientist;
    }

    public void setNameScientist(String nameScientist) {
        this.nameScientist = nameScientist;
    }

}
