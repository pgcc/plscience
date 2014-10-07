package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class FeatureModelCode
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class FeatureModelCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String featureTabname;
    private String featureitemName;

    public String getFeatureTabname() {
        return featureTabname;
    }

    public void setFeatureTabname(String featureTabname) {
        this.featureTabname = featureTabname;
    }

    public String getFeatureitemName() {
        return featureitemName;
    }

    public void setFeatureitemName(String featureitemName) {
        this.featureitemName = featureitemName;
    }

}
