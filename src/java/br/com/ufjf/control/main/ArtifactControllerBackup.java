package br.com.ufjf.control.main;

import br.com.ufjf.base.MetodoAuxiliar;
import br.com.ufjf.control.ArtifactDM;
import br.com.ufjf.control.JDBCController;
import br.com.ufjf.control.UserDM;
import br.com.ufjf.dao.ArtifactDAO;
import br.com.ufjf.dao.CommunicationDAO;
import br.com.ufjf.dao.UserDAO;
import br.com.ufjf.model.AnrafelSQL01;
import br.com.ufjf.model.AnrafelSQL02;
import br.com.ufjf.model.AnrafelSQL03;
import br.com.ufjf.model.AnrafelSQL04;
import br.com.ufjf.model.AnrafelSQL05;
import br.com.ufjf.model.AnrafelSQL06;
import br.com.ufjf.model.AnrafelSQL07;
import br.com.ufjf.model.AnrafelSQL07_1;
import br.com.ufjf.model.AnrafelSQL07_2;
import br.com.ufjf.model.AnrafelSQL07_3;
import br.com.ufjf.model.AnrafelSQL08;
import br.com.ufjf.model.main.Artifact;
import br.com.ufjf.model.main.Communication;
import br.com.ufjf.model.main.User;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
public class ArtifactControllerBackup implements Serializable {

    private static final long serialVersionUID = 1L;
    private ListaArtefatoController listaArtefatoController;
    private UserDAO userDao;
    private ArtifactDAO artifactDao;
    private CommunicationDAO communicatioDao;

    private Artifact selectedArtifact;
    private ArrayList<AnrafelSQL01> listAnrafelSQL01;
    private ArrayList<AnrafelSQL02> listAnrafelSQL02;
    private ArrayList<AnrafelSQL03> listAnrafelSQL03;
    private ArrayList<AnrafelSQL04> listAnrafelSQL04;
    private ArrayList<AnrafelSQL05> listAnrafelSQL05;
    private List<AnrafelSQL06> listAnrafelSQL06;
    private ArrayList<AnrafelSQL07> listAnrafelSQL07;
    private ArrayList<AnrafelSQL07_1> listAnrafelSQL07_1;
    private ArrayList<AnrafelSQL07_2> listAnrafelSQL07_2;
    private ArrayList<AnrafelSQL07_3> listAnrafelSQL07_3;
    private ArrayList<AnrafelSQL08> listAnrafelSQL08;
    private ArrayList<Artifact> listaArtifacts;
    private ArtifactDM mediumArtifactModel;
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
    private ArrayList<User> listaUsers;
    private ArrayList<String> listaLog1;
    private UserDM mediumUserModel;
    private UserDM mediumUserModelII;
    private int idUserContext;
    private String numAbaAberta;
    private User selectedUserModel;
    private String nomeUserTalk;
    private boolean habilitaMSG;
    private boolean habilitaMSGView1;
    private boolean habilitaMSGView2;
    private User adminUser;
    private MetodoAuxiliar metodoAuxiliar;
    private String varSim;
    private String varNao;
    private Boolean mostraPageView = true;
    private Boolean mostraPageViewII = true;
    private String setaPageView;
    private String mensagemValor;
    private String numAbaAbertaII;
    private int idRationaleSelect;
    private String nomeImagem;
    private int controlaTempo;
    private FacesContext facesContext;
    private int userSelecionado;
    private String mensagemEnviada;
    private String nameArtifact;
    private String nameArtifactMap;
    private String nameArtifactOnt;
    private String nameViewArtifact1;
    private String nameViewArtifact2;
    private String nameViewArtifact3;
    private List<Artifact> artifactsArt;
    private List<Artifact> artifactsMap;
    private List<Artifact> artifactsOnt;
     private String communicationMSG;

    public ArtifactControllerBackup() {
        this.userDao = new UserDAO();
        this.listaArtefatoController = new ListaArtefatoController();
        this.artifactDao = new ArtifactDAO();
        this.communicatioDao = new CommunicationDAO();
        this.listAnrafelSQL01 = new ArrayList<AnrafelSQL01>();
        this.listAnrafelSQL02 = new ArrayList<AnrafelSQL02>();
        this.listAnrafelSQL03 = new ArrayList<AnrafelSQL03>();
        this.listAnrafelSQL04 = new ArrayList<AnrafelSQL04>();
        this.listAnrafelSQL05 = new ArrayList<AnrafelSQL05>();
        this.listAnrafelSQL06 = new ArrayList<AnrafelSQL06>();
        this.listAnrafelSQL07 = new ArrayList<AnrafelSQL07>();
        this.listAnrafelSQL07_1 = new ArrayList<AnrafelSQL07_1>();
        this.listAnrafelSQL07_2 = new ArrayList<AnrafelSQL07_2>();
        this.listAnrafelSQL07_3 = new ArrayList<AnrafelSQL07_3>();
        this.listAnrafelSQL08 = new ArrayList<AnrafelSQL08>();
        this.listaArtifacts = new ArrayList<Artifact>();
        this.habilitaMSG = false;
        this.habilitaMSGView1 = true;
        this.habilitaMSGView2 = false;
        this.habilitaUserA = true;
        this.habilitaUserB = true;
        this.mostraMenSG = false;    
        this.habilitaMSG = false;
        this.habilitaMSGView1 = true;
        this.habilitaMSGView2 = false;
        this.listaUsers = new ArrayList<User>();
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

    /* metodo de Navegação */
    
   

     /**
     * Method listarArtefato LIST ARTIFACTS - BANK SEARCH ALL ARTIFACTS
     *
     * @return String
     *
     */
    
    public String listarArtefato() {
        selectedArtifact = null;
        listAnrafelSQL02.clear();
        listAnrafelSQL03.clear();
        listAnrafelSQL04.clear();
        listAnrafelSQL05.clear();
        listAnrafelSQL06.clear();
        listaArtifacts = new ArrayList<Artifact>();      
        listaArtifacts = (ArrayList<Artifact>) artifactDao.todosArtifact();
        mediumArtifactModel = new ArtifactDM(listaArtifacts);

        return "definePage03ViewArtifact1";

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
     * Method pegaIDcontext recovers idUser logged
     *
     *
     *
     */
    
    public void pegaIDcontext() {
        facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        User a;
        a = (User) session.getAttribute("currentUser");
        idUserContext = a.getIdScientist();
        //System.out.println("idUserContext-pegaIDcontext(): " + idUserContext);
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

            numAbaAberta = "2,3";
            habilitaI = true;
            habilitaII = true;
            habilitaIV = true;
            habilitaV = false;
            listAnrafelSQL07.clear();
            listAnrafelSQL08.clear();

            int idDoart = selectedArtifact.getIdArtifact();
            String sIdDoart = String.valueOf(idDoart);

            // USUARIOS-UTILIZOU-ESSE-ARTEFATO-FIM
            listAnrafelSQL07 = JDBCController.anrafelSQL07(sIdDoart);
            // PRODUTOS-FEITOS-COM-ESSE-ARTEFATO-INICIO
            listAnrafelSQL08 = JDBCController.anrafelSQL08(sIdDoart);

            /* preenche os inputtext a serem alterados */
            int idDoArtefato = selectedArtifact.getIdArtifact();
            Artifact bc;
            String query = "SELECT a FROM Artifact a WHERE a.idArtifact = :idArtifact ";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("idArtifact", idDoArtefato);
            bc = (Artifact) artifactDao.pesqParam(query, params);

            artiName = bc.getName();
            artiPurpose = bc.getPurpose();

            // User us = new User();
            listaUsers = new ArrayList<User>();
            // limpando o arrayList
            listaUsers.clear();
            User x = new User();
            listaUsers = (ArrayList<User>) userDao.todos(x.getClass());
            mediumUserModel = new UserDM(listaUsers);
            pegaIDcontext();

            retorna = "definePage13EditArtifact";

        } else {
            mostraMensagemGeral1 = "Please select an artifact!";
            retorna = null;
        }

        return retorna;

    }

    /**
     * Method includeUsuario button include User
     *
     * @return String
     *
     */
    
    public String includeUsuario() {

        habilitaUserA = false;
        // Pega o parâmetro via request.
        String idRationale = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("idRationale");
        if (idRationale == null) {
            return null;
        }

        listAnrafelSQL07_1.clear();
        listAnrafelSQL07_2.clear();
        listAnrafelSQL07_3.clear();

        listAnrafelSQL07_1 = JDBCController.anrafelSQL07_1(idRationale);
        listAnrafelSQL07_2 = JDBCController.anrafelSQL07_2(idRationale);
        listAnrafelSQL07_3 = JDBCController.anrafelSQL07_3(idRationale);

        viewBoxIII = "includePage7ViewBox06.xhtml";

        return "definePage13EditArtifact";
    }

    /**
     * Method includeUsuarioBack button navigation
     *
     * @return String
     *
     */
    
    public String includeUsuarioBack() {
        habilitaUserA = true;
        viewBoxIII = "";

        return "definePage13EditArtifact";
    }

   

    /**
     * Method includeNote which method includes page includePage6ViewBox01.xhtml
     *
     * @return String
     *
     */
    
    public String includeNote() {

        numAbaAberta = "4";
        habilitaII = true;
        habilitaI = false;
        viewBox = "includePage7ViewBox01.xhtml";
        listaUsers = new ArrayList<User>();      
        listaUsers = (ArrayList<User>) userDao.todosUser();
        mediumUserModel = new UserDM(listaUsers);

        return "definePage13EditArtifact";
    }

    /**
     * Method includeNoteCancel which method includes page
     * includePage6ViewBox01.xhtml
     *
     * @return String
     *
     */
    
    public String includeNoteCancel() {

        numAbaAberta = "4";
        habilitaII = true;
        habilitaI = true;
        viewBox = " ";
        listaUsers = new ArrayList<User>();      
        listaUsers = (ArrayList<User>) userDao.todosUser();
        mediumUserModel = new UserDM(listaUsers);
        mensagemValor = "";

        return "definePage13EditArtifact";
    }

    /**
     * Method buscaUserMSG search user
     *
     * @return String
     *
     */
    
    public String buscaUserMSG() {
        if (selectedUserModel != null) {
            numAbaAberta = "5";
            habilitaII = false;
            String nominho = selectedUserModel.getNameScientist();
            nomeUserTalk = nominho.toUpperCase();
            viewBoxII = "includePage7ViewBox02.xhtml";
        } else {
            numAbaAberta = "5";
            viewBoxII = "";
            habilitaII = true;
            habilitaMSG = true;
            mostraMensagemGeral3 = "Select an User!";
        }
        return "definePage13EditArtifact";
    }

    /**
     * Method buscaUserMSGCancel search user on BD
     *
     * @return String
     *
     */
    
    public String buscaUserMSGCancel() {
        numAbaAberta = "5";
        habilitaII = true;
        habilitaMSG = false;
        String nominho = selectedUserModel.getNameScientist();
        nomeUserTalk = nominho.toUpperCase();
        viewBoxII = "";
        communicationMSG = "";
        selectedUserModel = null;
        
        return "definePage13EditArtifact";
    }

    /**
     * Method viewContMassageII makes five different queries in the database
     *
     * @return String
     *
     */
    
    public String viewContMassageII() {
        numAbaAberta = "1";
        numAbaAbertaII = "0";
        mostraPageViewII = false;
        listAnrafelSQL02.clear();
        listAnrafelSQL03.clear();
        listAnrafelSQL04.clear();
        listAnrafelSQL05.clear();
        listAnrafelSQL06.clear();
        // Pega o parâmetro via request.
        String idRationale = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("idRationale");
        if (idRationale == null) {
            return null;
        }
        String num = idRationale.trim();
        idRationaleSelect = Integer.parseInt(num);
        nomeImagem = "e-mail.png";
        controlaTempo = 60;

        //System.out.println("idRationale:idRationale:idRationale: "+ idRationale);
        listAnrafelSQL02 = JDBCController.anrafelSQL02(idRationale);
        listAnrafelSQL03 = JDBCController.anrafelSQL03(idRationale);
        listAnrafelSQL04 = JDBCController.anrafelSQL04(idRationale);
        listAnrafelSQL05 = JDBCController.anrafelSQL05(idRationale);
        mostraPageViewII = false;
        User x = new User();
        listaUsers = (ArrayList<User>) userDao.todos(x.getClass());
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-UPDATE-TABELA-lidaSN-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        pegaIDcontext();
        JDBCController.updateMsgLida(idUserContext);

        setaPageView = "includePage7ViewBox08.xhtml";

        // esta OK
        return "definePage09ProductDevelopment.xhtml";
    }

    /**
     * Method gravaNote NOTE RECORDS IN DATABASE
     *
     * @return String
     *
     */
    
    public String gravaNote() {
       
        numAbaAberta = "4";
        habilitaII = true;
        habilitaI = true;
        viewBox = " ";
        listaUsers = new ArrayList<User>();
        listaUsers = (ArrayList<User>) userDao.todosUser();
        mediumUserModel = new UserDM(listaUsers);
         mensagemValor = "";
        
        return "definePage13EditArtifact";
    }
    
    
     /**
     * Method gravaNote NOTE RECORDS IN DATABASE
     *
     * @return String
     *
     */
    
    public String gravaCommunication() {
       
        numAbaAberta = "5";
        habilitaII = true;
        habilitaI = true;
        viewBox = " ";
        listaUsers = new ArrayList<User>();
        listaUsers = (ArrayList<User>) userDao.todosUser();
        mediumUserModel = new UserDM(listaUsers);
         mensagemValor = "";
         selectedUserModel = null;
        communicationMSG = "";
        return "definePage13EditArtifact";
    }

    /**
     * Method respondeMensagem() message RECORDS IN DATABASE
     *
     *
     */
    
    public void respondeMensagem() {
        int id = userSelecionado;
        Communication cmc = new Communication();
        cmc.setMessage(mensagemEnviada);
        cmc.setIdRationale(idRationaleSelect);
        cmc.setIdScientistEmissor(idUserContext);
        cmc.setIdScientistReceptor(id);
        cmc.setLidaSn(1);
        // obtendo a data de hoje por inteiros com calendar
        // instanciando o date para obter a data de hoje
        Date hoje = new Date();
        String formato = "dd/MM/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        String data = formatter.format(hoje);
        Date hojeW = new Date();
        // instanciando calendar
        Calendar cal = Calendar.getInstance();
        // setando hoje em calendar
        cal.setTime(hojeW);

        // obtendo inteiro da hora
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        // obtendo inteiro do minutos
        int minuto = cal.get(Calendar.MINUTE);
        String hora_ = String.valueOf(hora) + ":" + String.valueOf(minuto);
        cmc.setData(data);
        cmc.setHora(hora_);

        communicatioDao.salvar(cmc);
        listAnrafelSQL06.clear();
        String idScientistString = String.valueOf(idUserContext);
        listAnrafelSQL06 = JDBCController.anrafelSQL06(idScientistString);
        productDevelopment();
    }

    /**
     * Method productDevelopment() BUTTON START DEVELOPMENT IN MAIN MENU
     *
     * @return String
     *
     */
    
    public String productDevelopment() {

        mostraPageViewII = true;
        // Pega o parâmetro via request.
        String idScientist = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("idScientist");
        if (idScientist == null) {
            return null;
        }

        habilitaMSGView1 = false;
        listAnrafelSQL06 = new ArrayList<AnrafelSQL06>();
        /* removendo itens do arreyListe */
        for (int i = 0; i < listAnrafelSQL06.size(); i++) {
            listAnrafelSQL06.remove(i);
        }
        listAnrafelSQL06.clear();
        listAnrafelSQL06 = JDBCController.anrafelSQL06(idScientist);

        // mostraPageView = false;
        // setaPageView = " ";
        // viewBoxIV = "includePage7ViewBox07.xhtml";
        nameArtifact = " ";
        nameArtifactMap = " ";
        nameArtifactOnt = " ";

        nameViewArtifact1 = "Before proceeding select one model of each type shown below:";

        artifactsArt = new ArrayList<Artifact>();
        artifactsMap = new ArrayList<Artifact>();
        artifactsOnt = new ArrayList<Artifact>();
        String query = "SELECT a FROM Artifact a WHERE a.type = 'FeatureModel'";
        artifactsArt = (List<Artifact>) artifactDao.listPesq(query);
        // System.out.println("oi teste:-oi teste:-oi teste: "
        // + artifactsArt.get(0).getName());

        String query1 = "SELECT a FROM Artifact a WHERE a.type = 'MappingFile'";
        artifactsMap = (List<Artifact>) artifactDao.listPesq(query1);
        // System.out.println("oi teste:-oi teste:-oi teste: "
        // + artifactsArt.get(0).getName());

        String query2 = "SELECT a FROM Artifact a WHERE a.type = 'Ontology'";
        artifactsOnt = (List<Artifact>) artifactDao.listPesq(query2);
        // System.out.println("oi teste:-oi teste:-oi teste: "
        // + artifactsArt.get(0).getName());

        return "definePage09ProductDevelopment";

    }

    /**
     * Method stringToInt() Turns a String into integer
     *
     * @param value
     * @param _default
     * @return String
     *
     */
    public static int stringToInt(String value, int _default) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return _default;
        }
    }
    
    
    
    public ListaArtefatoController getListaArtefatoController() {
        return listaArtefatoController;
    }

    public void setListaArtefatoController(ListaArtefatoController listaArtefatoController) {
        this.listaArtefatoController = listaArtefatoController;
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

   

    public Artifact getSelectedArtifact() {
        return selectedArtifact;
    }

    public void setSelectedArtifact(Artifact selectedArtifact) {
        this.selectedArtifact = selectedArtifact;
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

    public ArrayList<AnrafelSQL07> getListAnrafelSQL07() {
        return listAnrafelSQL07;
    }

    public void setListAnrafelSQL07(ArrayList<AnrafelSQL07> listAnrafelSQL07) {
        this.listAnrafelSQL07 = listAnrafelSQL07;
    }

    public ArrayList<AnrafelSQL07_1> getListAnrafelSQL07_1() {
        return listAnrafelSQL07_1;
    }

    public void setListAnrafelSQL07_1(ArrayList<AnrafelSQL07_1> listAnrafelSQL07_1) {
        this.listAnrafelSQL07_1 = listAnrafelSQL07_1;
    }

    public ArrayList<AnrafelSQL07_2> getListAnrafelSQL07_2() {
        return listAnrafelSQL07_2;
    }

    public void setListAnrafelSQL07_2(ArrayList<AnrafelSQL07_2> listAnrafelSQL07_2) {
        this.listAnrafelSQL07_2 = listAnrafelSQL07_2;
    }

    public ArrayList<AnrafelSQL07_3> getListAnrafelSQL07_3() {
        return listAnrafelSQL07_3;
    }

    public void setListAnrafelSQL07_3(ArrayList<AnrafelSQL07_3> listAnrafelSQL07_3) {
        this.listAnrafelSQL07_3 = listAnrafelSQL07_3;
    }

    public ArrayList<AnrafelSQL08> getListAnrafelSQL08() {
        return listAnrafelSQL08;
    }

    public void setListAnrafelSQL08(ArrayList<AnrafelSQL08> listAnrafelSQL08) {
        this.listAnrafelSQL08 = listAnrafelSQL08;
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

    public ArrayList<User> getListaUsers() {
        return listaUsers;
    }

    public void setListaUsers(ArrayList<User> listaUsers) {
        this.listaUsers = listaUsers;
    }

    public ArrayList<String> getListaLog1() {
        return listaLog1;
    }

    public void setListaLog1(ArrayList<String> listaLog1) {
        this.listaLog1 = listaLog1;
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

    public int getIdUserContext() {
        return idUserContext;
    }

    public void setIdUserContext(int idUserContext) {
        this.idUserContext = idUserContext;
    }

    public String getNumAbaAberta() {
        return numAbaAberta;
    }

    public void setNumAbaAberta(String numAbaAberta) {
        this.numAbaAberta = numAbaAberta;
    }

    public User getSelectedUserModel() {
        return selectedUserModel;
    }

    public void setSelectedUserModel(User selectedUserModel) {
        this.selectedUserModel = selectedUserModel;
    }

    public String getNomeUserTalk() {
        return nomeUserTalk;
    }

    public void setNomeUserTalk(String nomeUserTalk) {
        this.nomeUserTalk = nomeUserTalk;
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

    public User getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(User adminUser) {
        this.adminUser = adminUser;
    }

    public MetodoAuxiliar getMetodoAuxiliar() {
        return metodoAuxiliar;
    }

    public void setMetodoAuxiliar(MetodoAuxiliar metodoAuxiliar) {
        this.metodoAuxiliar = metodoAuxiliar;
    }

    public String getVarSim() {
        return varSim;
    }

    public void setVarSim(String varSim) {
        this.varSim = varSim;
    }

    public String getVarNao() {
        return varNao;
    }

    public void setVarNao(String varNao) {
        this.varNao = varNao;
    }

    public Boolean isMostraPageView() {
        return mostraPageView;
    }

    public void setMostraPageView(Boolean mostraPageView) {
        this.mostraPageView = mostraPageView;
    }

    public Boolean isMostraPageViewII() {
        return mostraPageViewII;
    }

    public void setMostraPageViewII(Boolean mostraPageViewII) {
        this.mostraPageViewII = mostraPageViewII;
    }

    public String getSetaPageView() {
        return setaPageView;
    }

    public void setSetaPageView(String setaPageView) {
        this.setaPageView = setaPageView;
    }

    public String getMensagemValor() {
        return mensagemValor;
    }

    public void setMensagemValor(String mensagemValor) {
        this.mensagemValor = mensagemValor;
    }

    public String getNumAbaAbertaII() {
        return numAbaAbertaII;
    }

    public void setNumAbaAbertaII(String numAbaAbertaII) {
        this.numAbaAbertaII = numAbaAbertaII;
    }

    public int getIdRationaleSelect() {
        return idRationaleSelect;
    }

    public void setIdRationaleSelect(int idRationaleSelect) {
        this.idRationaleSelect = idRationaleSelect;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public int getControlaTempo() {
        return controlaTempo;
    }

    public void setControlaTempo(int controlaTempo) {
        this.controlaTempo = controlaTempo;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public int getUserSelecionado() {
        return userSelecionado;
    }

    public void setUserSelecionado(int userSelecionado) {
        this.userSelecionado = userSelecionado;
    }

    public String getMensagemEnviada() {
        return mensagemEnviada;
    }

    public void setMensagemEnviada(String mensagemEnviada) {
        this.mensagemEnviada = mensagemEnviada;
    }

    public String getNameArtifact() {
        return nameArtifact;
    }

    public void setNameArtifact(String nameArtifact) {
        this.nameArtifact = nameArtifact;
    }

    public String getNameArtifactMap() {
        return nameArtifactMap;
    }

    public void setNameArtifactMap(String nameArtifactMap) {
        this.nameArtifactMap = nameArtifactMap;
    }

    public String getNameArtifactOnt() {
        return nameArtifactOnt;
    }

    public void setNameArtifactOnt(String nameArtifactOnt) {
        this.nameArtifactOnt = nameArtifactOnt;
    }

    public String getNameViewArtifact1() {
        return nameViewArtifact1;
    }

    public void setNameViewArtifact1(String nameViewArtifact1) {
        this.nameViewArtifact1 = nameViewArtifact1;
    }

    public String getNameViewArtifact2() {
        return nameViewArtifact2;
    }

    public void setNameViewArtifact2(String nameViewArtifact2) {
        this.nameViewArtifact2 = nameViewArtifact2;
    }

    public String getNameViewArtifact3() {
        return nameViewArtifact3;
    }

    public void setNameViewArtifact3(String nameViewArtifact3) {
        this.nameViewArtifact3 = nameViewArtifact3;
    }

    public List<Artifact> getArtifactsArt() {
        return artifactsArt;
    }

    public void setArtifactsArt(List<Artifact> artifactsArt) {
        this.artifactsArt = artifactsArt;
    }

    public List<Artifact> getArtifactsMap() {
        return artifactsMap;
    }

    public void setArtifactsMap(List<Artifact> artifactsMap) {
        this.artifactsMap = artifactsMap;
    }

    public List<Artifact> getArtifactsOnt() {
        return artifactsOnt;
    }

    public void setArtifactsOnt(List<Artifact> artifactsOnt) {
        this.artifactsOnt = artifactsOnt;
    }

    public String getCommunicationMSG() {
        return communicationMSG;
    }

    public void setCommunicationMSG(String communicationMSG) {
        this.communicationMSG = communicationMSG;
    }

   
}// ultimo
