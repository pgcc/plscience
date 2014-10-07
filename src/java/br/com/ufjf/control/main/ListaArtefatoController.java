package br.com.ufjf.control.main;

import br.com.ufjf.control.ArtifactDM;
import br.com.ufjf.dao.ArtifactDAO;
import br.com.ufjf.dao.CommunicationDAO;
import br.com.ufjf.dao.UserDAO;
import br.com.ufjf.model.AnrafelSQL01;
import br.com.ufjf.model.AnrafelSQL02;
import br.com.ufjf.model.AnrafelSQL03;
import br.com.ufjf.model.AnrafelSQL04;
import br.com.ufjf.model.AnrafelSQL05;
import br.com.ufjf.model.AnrafelSQL06;
import br.com.ufjf.model.main.Artifact;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author magnus
 */
public class ListaArtefatoController implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private UserDAO userDao;
    private ArtifactDAO artifactDao;
    private CommunicationDAO communicatioDao;

    private ArrayList<AnrafelSQL01> listAnrafelSQL01;
    private ArrayList<AnrafelSQL02> listAnrafelSQL02;
    private ArrayList<AnrafelSQL03> listAnrafelSQL03;
    private ArrayList<AnrafelSQL04> listAnrafelSQL04;
    private ArrayList<AnrafelSQL05> listAnrafelSQL05;
    private List<AnrafelSQL06> listAnrafelSQL06;
    private ArrayList<Artifact> listaArtifacts;
    private ArtifactDM mediumArtifactModel;

    public ListaArtefatoController() {
        this.userDao = new UserDAO();
        this.artifactDao = new ArtifactDAO();
        this.communicatioDao = new CommunicationDAO();

        this.listAnrafelSQL01 = new ArrayList<AnrafelSQL01>();
        this.listAnrafelSQL02 = new ArrayList<AnrafelSQL02>();
        this.listAnrafelSQL03 = new ArrayList<AnrafelSQL03>();
        this.listAnrafelSQL04 = new ArrayList<AnrafelSQL04>();
        this.listAnrafelSQL05 = new ArrayList<AnrafelSQL05>();
        this.listAnrafelSQL06 = new ArrayList<AnrafelSQL06>();
    }

   

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public ArtifactDAO getArtifactDao() {
        return artifactDao;
    }

    public void setArtifactDao(ArtifactDAO artifactDao) {
        this.artifactDao = artifactDao;
    }

    public CommunicationDAO getCommunicatioDao() {
        return communicatioDao;
    }

    public void setCommunicatioDao(CommunicationDAO communicatioDao) {
        this.communicatioDao = communicatioDao;
    }



    public ArrayList<AnrafelSQL01> getListAnrafelSQL01() {
        return listAnrafelSQL01;
    }

    public void setListAnrafelSQL01(ArrayList<AnrafelSQL01> listAnrafelSQL01) {
        this.listAnrafelSQL01 = listAnrafelSQL01;
    }

    public ArrayList<AnrafelSQL02> getListAnrafelSQL02() {
        return listAnrafelSQL02;
    }

    public void setListAnrafelSQL02(ArrayList<AnrafelSQL02> listAnrafelSQL02) {
        this.listAnrafelSQL02 = listAnrafelSQL02;
    }

    public ArrayList<AnrafelSQL03> getListAnrafelSQL03() {
        return listAnrafelSQL03;
    }

    public void setListAnrafelSQL03(ArrayList<AnrafelSQL03> listAnrafelSQL03) {
        this.listAnrafelSQL03 = listAnrafelSQL03;
    }

    public ArrayList<AnrafelSQL04> getListAnrafelSQL04() {
        return listAnrafelSQL04;
    }

    public void setListAnrafelSQL04(ArrayList<AnrafelSQL04> listAnrafelSQL04) {
        this.listAnrafelSQL04 = listAnrafelSQL04;
    }

    public ArrayList<AnrafelSQL05> getListAnrafelSQL05() {
        return listAnrafelSQL05;
    }

    public void setListAnrafelSQL05(ArrayList<AnrafelSQL05> listAnrafelSQL05) {
        this.listAnrafelSQL05 = listAnrafelSQL05;
    }

    public List<AnrafelSQL06> getListAnrafelSQL06() {
        return listAnrafelSQL06;
    }

    public void setListAnrafelSQL06(List<AnrafelSQL06> listAnrafelSQL06) {
        this.listAnrafelSQL06 = listAnrafelSQL06;
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

}//ultimo
