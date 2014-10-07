package br.com.ufjf.control.main;

import java.io.Serializable;
import java.util.ArrayList;
import br.com.ufjf.control.ArtifactDM;
import br.com.ufjf.dao.ArtifactDAO;
import br.com.ufjf.model.main.Artifact;

/**
 * Classe NavegaMenuController
 *
 * @category control
 * @author magnus, anrafel, jonathan
 *
 */
public class NavegaMenuController implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArtifactDAO artifactDao;
    private ArrayList<Artifact> listaArtifacts;
    private ArtifactDM mediumArtifactModel;
    private PerceptionBoxController perceptionBoxController;

    /* METODO CONSTRUTOR */
    public NavegaMenuController() {
        this.artifactDao = new ArtifactDAO();
        this.listaArtifacts = new ArrayList<Artifact>();
        this.perceptionBoxController = new PerceptionBoxController();
        
    }

    /* metodo de Navegação */
    public String backToa3Home() {
        return "definePage02Home";
    }
    
    
     public String botaoVoltarlistarArtefato() {
      
        listaArtifacts = (ArrayList<Artifact>) artifactDao.todosArtifact();
        mediumArtifactModel = new ArtifactDM(listaArtifacts);

        return "definePage03ViewArtifact1";
    }
    

  

    /* INICIO DOS GET AND SET */
    /* INICIO DOS GET AND SET */
    /* INICIO DOS GET AND SET */
    public ArtifactDAO getArtifactDao() {
        return artifactDao;
    }

    public void setArtifactDao(ArtifactDAO artifactDao) {
        this.artifactDao = artifactDao;
    }

    public ArrayList<Artifact> getListaArtifacts() {
        return listaArtifacts;
    }

    public void setListaArtifacts(ArrayList<Artifact> listaArtifacts) {
        this.listaArtifacts = listaArtifacts;
    }

    public ArtifactDM getMediumArtifactModel() {
        return mediumArtifactModel;
    }

    public void setMediumArtifactModel(ArtifactDM mediumArtifactModel) {
        this.mediumArtifactModel = mediumArtifactModel;
    }

    public PerceptionBoxController getPerceptionBoxController() {
        return perceptionBoxController;
    }

    public void setPerceptionBoxController(PerceptionBoxController perceptionBoxController) {
        this.perceptionBoxController = perceptionBoxController;
    }

}// ultimo
