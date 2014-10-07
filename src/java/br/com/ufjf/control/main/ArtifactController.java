package br.com.ufjf.control.main;

import br.com.ufjf.control.ArtifactDM;
import br.com.ufjf.control.UserDM;
import br.com.ufjf.dao.ArtifactDAO;
import br.com.ufjf.dao.UserDAO;
import br.com.ufjf.model.main.Artifact;
import br.com.ufjf.model.main.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Classe ArtifactController controller of artifacts
 *
 * @category control
 * @author magnus, anrafel, jonathan
 *
 */
public class ArtifactController implements Serializable {

    private static final long serialVersionUID = 1L;

    private UserDAO userDao;
    private ArtifactDAO artifactDao;
    private PerceptionBoxController perceptionBoxController;
    private NavegaMenuController navegaMenu;
    private Artifact selectedArtifact;
    private ArtifactDM mediumArtifactModel;
    private ArrayList<Artifact> listaArtifacts;
    private String mostraMensagemGeral1;
    private String mostraMensagemGeral2;
    private String mostraMensagemGeral3;
    private boolean habilitaI;
    private boolean habilitaII;
    private boolean habilitaIII;
    private boolean habilitaIV;
    private boolean habilitaV;
    private String viewBox;
    private String viewBoxII;
    private String viewBoxIII;
    private String viewBoxIV;
    private boolean habilitaUserA;
    private boolean habilitaUserB;
    private boolean mostraMenSG;
    private String artiName;
    private String artiPurpose;
    private UserDM mediumUserModel;
    private UserDM mediumUserModelII;
    private ArrayList<User> listaUsers;
     private boolean habilitaMSG;
    private boolean habilitaMSGView1;
    private boolean habilitaMSGView2;

    /*METODO CONSTRUTOR*/
    public ArtifactController() {
        this.userDao = new UserDAO();
        this.artifactDao = new ArtifactDAO();
        this.perceptionBoxController = new PerceptionBoxController();
        this.navegaMenu = new NavegaMenuController();
        this.selectedArtifact = new Artifact();
        this.listaArtifacts = new ArrayList<Artifact>();
        this.listaUsers = new ArrayList<User>();
        this.listaArtifacts = new ArrayList<Artifact>();
        this.habilitaMSG = false;
        this.habilitaMSGView1 = true;
        this.habilitaMSGView2 = false;
        this.habilitaUserA = true;
        this.habilitaUserB = true;
        this.mostraMenSG = false;    
     
        this.listaUsers = new ArrayList<User>();
    
    }

    
    public void nevegacaoBotaoVoltarEdit(){
        navegaMenu.botaoVoltarlistarArtefato();
    }
    
    
    
    
    
    /**
     * Method listarArtefato LIST ARTIFACTS - BANK SEARCH ALL ARTIFACTS
     *
     *
     */
    public void listarArtefatoLogin() {
        listaArtifacts = (ArrayList<Artifact>) artifactDao.todosArtifact();
        mediumArtifactModel = new ArtifactDM(listaArtifacts);
        //return "definePage03ViewArtifact1";
    }
    
    
    public String listarArtefato() {
        listaArtifacts = (ArrayList<Artifact>) artifactDao.todosArtifact();
        mediumArtifactModel = new ArtifactDM(listaArtifacts);
        return "definePage03ViewArtifact1";
    }

    /**
     * Method editArtifact BUTTON edit OF ARTIFACTS
     *
     * @return String
     *
     */
    public String editArtifact() {
        String retorna;
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.getAttribute("currentUser");

        if (selectedArtifact != null) {
            mostraMensagemGeral1 = "";
            habilitaIII = false;
            viewBoxIII = " ";
            habilitaUserA = true;
            habilitaUserB = true;
            mostraMenSG = false;
            habilitaI = true;
            habilitaII = true;
            habilitaIV = true;
            habilitaV = false;

            
            int idDoartefatoSelecionado = selectedArtifact.getIdArtifact();
            String idDoartefatoSelecionadoString = String.valueOf(idDoartefatoSelecionado);    
            perceptionBoxController.editArtifactOnTheArtifactController(idDoartefatoSelecionadoString);
            
            
            perceptionBoxController.buscaUsers();
            String idUserLogado  = IDContextController.pegaIDcontextString();
            perceptionBoxController.buscalistAnrafelSQL06(idUserLogado);
            
            /* preenche os inputtext a serem alterados */
            int idDoArtefato = selectedArtifact.getIdArtifact();
            Artifact bc;
            String query = "SELECT a FROM Artifact a WHERE a.idArtifact = :idArtifact ";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("idArtifact", idDoArtefato);
            bc = (Artifact) artifactDao.pesqParam(query, params);

            artiName = bc.getName();
            artiPurpose = bc.getPurpose();

            // limpando o arrayList
         

            retorna = "definePage13EditArtifact";

        } else {
            mostraMensagemGeral1 = "Please select an artifact!";
            retorna = null;
        }

        return retorna;

    }

    /**
     * Method editArtifactConfirm confirm editing of the artifact
     *
     * @return String
     *
     */
    public String editArtifactConfirm() {

        return "definePage13EditArtifact";
    }
    
      /**
     * Method editArtifactCancel cancel editing of the artifact
     *
     * @return String
     *
     */
    
    public String editArtifactCancel() {
        selectedArtifact = null;
        return "definePage03ViewArtifact1";
    }

    /*INICIO DOS GET AND SET*/
    /*INICIO DOS GET AND SET*/
    /*INICIO DOS GET AND SET*/
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

    public PerceptionBoxController getPerceptionBoxController() {
        return perceptionBoxController;
    }

    public void setPerceptionBoxController(PerceptionBoxController perceptionBoxController) {
        this.perceptionBoxController = perceptionBoxController;
    }

    public Artifact getSelectedArtifact() {
        return selectedArtifact;
    }

    public void setSelectedArtifact(Artifact selectedArtifact) {
        this.selectedArtifact = selectedArtifact;
    }

    public ArtifactDM getMediumArtifactModel() {
        return mediumArtifactModel;
    }

    public void setMediumArtifactModel(ArtifactDM mediumArtifactModel) {
        this.mediumArtifactModel = mediumArtifactModel;
    }

    public ArrayList<Artifact> getListaArtifacts() {
        return listaArtifacts;
    }

    public void setListaArtifacts(ArrayList<Artifact> listaArtifacts) {
        this.listaArtifacts = listaArtifacts;
    }

    public String getMostraMensagemGeral1() {
        return mostraMensagemGeral1;
    }

    public void setMostraMensagemGeral1(String mostraMensagemGeral1) {
        this.mostraMensagemGeral1 = mostraMensagemGeral1;
    }

    public String getMostraMensagemGeral2() {
        return mostraMensagemGeral2;
    }

    public void setMostraMensagemGeral2(String mostraMensagemGeral2) {
        this.mostraMensagemGeral2 = mostraMensagemGeral2;
    }

    public String getMostraMensagemGeral3() {
        return mostraMensagemGeral3;
    }

    public void setMostraMensagemGeral3(String mostraMensagemGeral3) {
        this.mostraMensagemGeral3 = mostraMensagemGeral3;
    }

    public boolean isHabilitaI() {
        return habilitaI;
    }

    public void setHabilitaI(boolean habilitaI) {
        this.habilitaI = habilitaI;
    }

    public boolean isHabilitaII() {
        return habilitaII;
    }

    public void setHabilitaII(boolean habilitaII) {
        this.habilitaII = habilitaII;
    }

    public boolean isHabilitaIII() {
        return habilitaIII;
    }

    public void setHabilitaIII(boolean habilitaIII) {
        this.habilitaIII = habilitaIII;
    }

    public boolean isHabilitaIV() {
        return habilitaIV;
    }

    public void setHabilitaIV(boolean habilitaIV) {
        this.habilitaIV = habilitaIV;
    }

    public boolean isHabilitaV() {
        return habilitaV;
    }

    public void setHabilitaV(boolean habilitaV) {
        this.habilitaV = habilitaV;
    }

    public String getViewBox() {
        return viewBox;
    }

    public void setViewBox(String viewBox) {
        this.viewBox = viewBox;
    }

    public String getViewBoxII() {
        return viewBoxII;
    }

    public void setViewBoxII(String viewBoxII) {
        this.viewBoxII = viewBoxII;
    }

    public String getViewBoxIII() {
        return viewBoxIII;
    }

    public void setViewBoxIII(String viewBoxIII) {
        this.viewBoxIII = viewBoxIII;
    }

    public String getViewBoxIV() {
        return viewBoxIV;
    }

    public void setViewBoxIV(String viewBoxIV) {
        this.viewBoxIV = viewBoxIV;
    }

    public boolean isHabilitaUserA() {
        return habilitaUserA;
    }

    public void setHabilitaUserA(boolean habilitaUserA) {
        this.habilitaUserA = habilitaUserA;
    }

    public boolean isHabilitaUserB() {
        return habilitaUserB;
    }

    public void setHabilitaUserB(boolean habilitaUserB) {
        this.habilitaUserB = habilitaUserB;
    }

    public boolean isMostraMenSG() {
        return mostraMenSG;
    }

    public void setMostraMenSG(boolean mostraMenSG) {
        this.mostraMenSG = mostraMenSG;
    }

    public String getArtiName() {
        return artiName;
    }

    public void setArtiName(String artiName) {
        this.artiName = artiName;
    }

    public String getArtiPurpose() {
        return artiPurpose;
    }

    public void setArtiPurpose(String artiPurpose) {
        this.artiPurpose = artiPurpose;
    }

    public UserDM getMediumUserModel() {
        return mediumUserModel;
    }

    public void setMediumUserModel(UserDM mediumUserModel) {
        this.mediumUserModel = mediumUserModel;
    }

    public UserDM getMediumUserModelII() {
        return mediumUserModelII;
    }

    public void setMediumUserModelII(UserDM mediumUserModelII) {
        this.mediumUserModelII = mediumUserModelII;
    }

    public ArrayList<User> getListaUsers() {
        return listaUsers;
    }

    public void setListaUsers(ArrayList<User> listaUsers) {
        this.listaUsers = listaUsers;
    }

    public boolean isHabilitaMSG() {
        return habilitaMSG;
    }

    public void setHabilitaMSG(boolean habilitaMSG) {
        this.habilitaMSG = habilitaMSG;
    }

    public boolean isHabilitaMSGView1() {
        return habilitaMSGView1;
    }

    public void setHabilitaMSGView1(boolean habilitaMSGView1) {
        this.habilitaMSGView1 = habilitaMSGView1;
    }

    public boolean isHabilitaMSGView2() {
        return habilitaMSGView2;
    }

    public void setHabilitaMSGView2(boolean habilitaMSGView2) {
        this.habilitaMSGView2 = habilitaMSGView2;
    }

    public NavegaMenuController getNavegaMenu() {
        return navegaMenu;
    }

    public void setNavegaMenu(NavegaMenuController navegaMenu) {
        this.navegaMenu = navegaMenu;
    }
    
    
    

}// ultimo
