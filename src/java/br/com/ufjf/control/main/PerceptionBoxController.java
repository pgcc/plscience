package br.com.ufjf.control.main;

import br.com.ufjf.control.ArquivoIndexXML;
import br.com.ufjf.control.ArquivoIndexXMLDM;
import br.com.ufjf.control.JDBCController;
import br.com.ufjf.control.UserDM;
import br.com.ufjf.dao.ArtifactDAO;
import br.com.ufjf.dao.ArtifactsUsedDAO;
import br.com.ufjf.dao.CommunicationDAO;
import br.com.ufjf.dao.HowTableDAO;
import br.com.ufjf.dao.NotesDAO;
import br.com.ufjf.dao.RationaleDAO;
import br.com.ufjf.dao.UserDAO;
import br.com.ufjf.dao.WhatTableDAO;
import br.com.ufjf.dao.WhenTableDAO;
import br.com.ufjf.dao.WhereTableDAO;
import br.com.ufjf.dao.WhoTableDAO;
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
import br.com.ufjf.model.AnrafelSQL09;
import br.com.ufjf.model.AnrafelSQL10;
import br.com.ufjf.model.AnrafelSQL11;
import br.com.ufjf.model.main.Artifact;
import br.com.ufjf.model.main.Communication;
import br.com.ufjf.model.main.Notes;
import br.com.ufjf.model.main.User;
import br.com.ufjf.webservice.servannotation.ServAnnotation;
import br.com.ufjf.webservice.servannotation.ServAnnotation_Service;
import br.com.ufjf.webservice.servcommunication.ServCommunication;
import br.com.ufjf.webservice.servcommunication.ServCommunication_Service;
import br.com.ufjf.webservice.servontologygenericsparql.ServOntologyGenericSparql;
import br.com.ufjf.webservice.servontologygenericsparql.ServOntologyGenericSparql_Service;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * central.perceptionBox.
 *
 * @author magnus
 */
public class PerceptionBoxController implements Serializable {

    private static final long serialVersionUID = 1L;

    private UserDAO userDao;
    private ArtifactDAO artifactDao;
    private RationaleDAO rationaleDao;
    private WhoTableDAO WhoDao;
    private WhenTableDAO WhenDao;
    private HowTableDAO howDao;
    private WhatTableDAO whatDao;
    private WhereTableDAO where1Dao;
    private CommunicationDAO communicatioDao;
    private ArtifactsUsedDAO artifactUsedDao;
    private NotesDAO notesDAO;
    private AnrafelSQL09 anrafelSQL09;
    private ArrayList<AnrafelSQL09> users;
    /*PARAMETROS DO VIEW DE PERSEPÇÃO DO EDIT ARTEFATO*/
    private ArrayList<AnrafelSQL09> usersATED;
    private boolean habilitaMSGATED;
    private ArrayList<AnrafelSQL07> listAnrafelSQL07ATED;
    private ArrayList<AnrafelSQL07_1> listAnrafelSQL07_1ATED;
    private ArrayList<AnrafelSQL07_2> listAnrafelSQL07_2ATED;
    private ArrayList<AnrafelSQL07_3> listAnrafelSQL07_3ATED;
    private ArrayList<AnrafelSQL08> listAnrafelSQL08ATED;
    private String numAbaAbertaATED;
    private String mostraMensagemGeral1ATED;
    private String mostraMensagemGeral2ATED;
    private String mostraMensagemGeral3ATED;
    private String viewBoxATED;
    private String viewBoxIIATED;
    private String viewBoxIIIATED;
    private boolean habilitaIATED;
    private boolean habilitaIIATED;
    private boolean habilitaIIIATED;
    private boolean habilitaIVATED;
    private boolean habilitaVATED;
    private boolean habilitaUserAATED;
    private boolean habilitaUserBATED;
    private UserDM mediumUserModelATED;
    private UserDM mediumUserModelIIATED;
    private User selectedUserModelATED;
    private String nomeUserTalkATED;
    private ArrayList<User> listaUsersATED;
    private String mensagemValorATED;
    private String msgNotesVaziaATED;
    private String messageCommunicationATED;
    private String msgCommunicatioVaziaATED;
    /*PARAMETROS DO VIEW DE PERSEPÇÃO DO EDIT ARTEFATO*/
    /*PARAMETROS DO VIEW DE PERSEPÇÃO DO DEVELOPMENT MOUNT TREE*/
    private ArrayList<AnrafelSQL09> usersDVLP1T;
    private boolean habilitaMSGDVLP1T;
    private ArrayList<AnrafelSQL07> listAnrafelSQL07DVLP1T;
    private ArrayList<AnrafelSQL07_1> listAnrafelSQL07_1DVLP1T;
    private ArrayList<AnrafelSQL07_2> listAnrafelSQL07_2DVLP1T;
    private ArrayList<AnrafelSQL07_3> listAnrafelSQL07_3DVLP1T;
    private ArrayList<AnrafelSQL08> listAnrafelSQL08DVLP1T;
    private String numAbaAbertaDVLP1T;
    private String mostraMensagemGeral1DVLP1T;
    private String mostraMensagemGeral2DVLP1T;
    private String mostraMensagemGeral3DVLP1T;
    private String viewBoxDVLP1T;
    private String viewBoxIIDVLP1T;
    private String viewBoxIIIDVLP1T;
    private boolean habilitaIDVLP1T;
    private boolean habilitaIIDVLP1T;
    private boolean habilitaIIIDVLP1T;
    private boolean habilitaIVDVLP1T;
    private boolean habilitaVDVLP1T;
    private boolean habilitaUserADVLP1T;
    private boolean habilitaUserBDVLP1T;
    private UserDM mediumUserModelDVLP1T;
    private UserDM mediumUserModelIIDVLP1T;
    private User selectedUserModelDVLP1T;
    private String nomeUserTalkDVLP1T;
    private ArrayList<User> listaUsersDVLP1T;
    private String mensagemValorDVLP1T;
    private String msgNotesVaziaDVLP1T;
    private String messageCommunicationDVLP1T;
    private String msgCommunicatioVaziaDVLP1T;
    private Boolean mostraPageViewIIDVLP1T;
    private List<AnrafelSQL06> listAnrafelSQL06DVLP1T;
    private String mensagemEnviadaDVLP1T;
    private String numAbaAbertaIIDVLP1T;
    private ArrayList<AnrafelSQL01> listAnrafelSQL01DVLP1T;
    private ArrayList<AnrafelSQL02> listAnrafelSQL02DVLP1T;
    private ArrayList<AnrafelSQL03> listAnrafelSQL03DVLP1T;
    private ArrayList<AnrafelSQL04> listAnrafelSQL04DVLP1T;
    private ArrayList<AnrafelSQL05> listAnrafelSQL05DVLP1T;
    private int idRationaleSelectDVLP1T;
    private String setaPageViewDVLP1T;
    private ArrayList<AnrafelSQL10> listAnrafelSQL10DVLP1T;
    /*PARAMETROS DO VIEW DE PERSEPÇÃO DO DEVELOPMENT MOUNT TREE*/
    private String sparqlfield;
    private String fieldTerms;
    private boolean habilitaMSG;
    private boolean habilitaMSGView1;
    private boolean habilitaMSGView2;
    private Boolean mostraPageView;
    private Boolean mostraPageViewII;
    /*PARAMETROS DO VIEW DE PERSEPÇÃO DO DEVELOPMENT*/
    private Boolean mostraPageViewIIDVLP1;
    private ArrayList<AnrafelSQL09> usersDVLP1;
    private ArrayList<AnrafelSQL07> listAnrafelSQL07DVLP1;
    private ArrayList<AnrafelSQL07_1> listAnrafelSQL07_1DVLP1;
    private ArrayList<AnrafelSQL07_2> listAnrafelSQL07_2DVLP1;
    private ArrayList<AnrafelSQL07_3> listAnrafelSQL07_3DVLP1;
    private ArrayList<AnrafelSQL08> listAnrafelSQL08DVLP1;
    private ArrayList<AnrafelSQL01> listAnrafelSQL01DVLP1;
    private ArrayList<AnrafelSQL02> listAnrafelSQL02DVLP1;
    private ArrayList<AnrafelSQL03> listAnrafelSQL03DVLP1;
    private ArrayList<AnrafelSQL04> listAnrafelSQL04DVLP1;
    private ArrayList<AnrafelSQL05> listAnrafelSQL05DVLP1;
    private List<AnrafelSQL06> listAnrafelSQL06DVLP1;
    private String setaPageViewDVLP1;
    private String numAbaAbertaDVLP1;
    private String numAbaAbertaIIDVLP1;
    private String mensagemEnviadaDVLP1;
    private ArrayList<User> listaUsersDVLP1;
    private int userSelecionadoDVLP1;
    private boolean habilitaMSGView1DVLP1;
    private boolean habilitaMSGView2DVLP1;
    private Boolean mostraPageViewDVLP1;
    private ArrayList<AnrafelSQL11> listAnrafelSQL11DVLP1;
    /*PARAMETROS DO VIEW DE PERSEPÇÃO DO DEVELOPMENT*/
    private ArrayList<Communication> listCommunicationView;
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
    private ArrayList<AnrafelSQL09> listAnrafelSQL09;
    private String setaPageView;
    private ArrayList<User> listaUsers;
    /*numero da aba aberta personalizado*/
    private String numAbaAbertaIncludePage5LateralDireita04; //antiga numAbaAberta
    private String numAbaAbertaIncludePage5LateralDireita04II;//antiga numAbaAbertaII
    private String numAbaAbertaIncludePage5LateralDireita03;//antiga numAbaAberta
    private String numAbaAbertaIncludePage5LateralDireita03II;//antiga numAbaAbertaII
    private String numAbaAberta;
    private String numAbaAbertaII;
    private int userSelecionado;
    private String mensagemEnviada;
    private int idUsercontext;
    private int idRationaleSelect;
    private ArrayList<ArquivoIndexXML> mostraIndexXml;
    private ArquivoIndexXMLDM arquivoIndexXMLDM;
    private ArquivoIndexXML arquivoIndexXMLSelecionado;
    private String VARIAVELGLOBALURLXML;
    private boolean mostraDownloadXML;
    private String mostraNomeWorkflow;
    private String mostraMensagemGeral1;
    private String mostraMensagemGeral2;
    private String mostraMensagemGeral3;
    private String viewBox;
    private String viewBoxII;
    private String viewBoxIII;
    private String viewBoxIV;
    private boolean habilitaI;
    private boolean habilitaII;
    private boolean habilitaIII;
    private boolean habilitaIV;
    private boolean habilitaV;
    private boolean habilitaUserA;
    private boolean habilitaUserB;
    private boolean mostraMenSG;
    private UserDM mediumUserModel;
    private UserDM mediumUserModelII;
    private User selectedUserModel;
    private String nomeUserTalk;
    private String artiName;
    private String artiPurpose;
    private String mensagemValor;
    private boolean mostraPageViewAlgoritmo;
    private String messageCommunication;
    private String msgCommunicatioVazia;
    private String msgNotesVazia;
    private String sIdDoartselecionadoGLOBAL;
    private String product_name;
    private String nameArtifactD;
    private String nameArtifactMapD;
    private String nameArtifactOntD;

    public PerceptionBoxController() {
        this.userDao = new UserDAO();
        this.artifactDao = new ArtifactDAO();
        this.rationaleDao = new RationaleDAO();
        this.WhoDao = new WhoTableDAO();
        this.WhenDao = new WhenTableDAO();
        this.howDao = new HowTableDAO();
        this.whatDao = new WhatTableDAO();
        this.where1Dao = new WhereTableDAO();
        this.artifactUsedDao = new ArtifactsUsedDAO();
        this.communicatioDao = new CommunicationDAO();
        this.notesDAO = new NotesDAO();
        this.anrafelSQL09 = new AnrafelSQL09();
        this.users = new ArrayList<AnrafelSQL09>();
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
        carregaabaLogin();
        this.numAbaAberta = "0";
        this.mostraPageViewIIDVLP1 = true;

    }

    private void carregaabaLogin() {
        this.mostraPageViewII = true;
        this.mostraPageViewAlgoritmo = false;
        this.numAbaAbertaIncludePage5LateralDireita04 = "0";

    }

    public void inicioDeveloper() {
        mostraPageViewIIDVLP1 = true;
        numAbaAbertaDVLP1 = "0";
    }

    public void startDevelopmentAbbaControll() {
        mostraPageViewIIDVLP1 = true;
        numAbaAbertaDVLP1 = "0";
        buscaUsersDVLP1();
        //listAnrafelSQL06DVLP1.clear();
        int pegaIDcontext = IDContextController.pegaIDcontext();
        String idScientistString = String.valueOf(pegaIDcontext);
        listAnrafelSQL06DVLP1 = JDBCController.anrafelSQL06(idScientistString);

    }

    public void editArtifactOnTheArtifactController(String sIdDoartselecionado) {
        numAbaAbertaATED = "0";
        habilitaIATED = true;
        habilitaIIATED = true;
        sIdDoartselecionadoGLOBAL = sIdDoartselecionado;
        // USUARIOS-UTILIZOU-ESSE-ARTEFATO-FIM
        listAnrafelSQL07ATED = JDBCController.anrafelSQL07(sIdDoartselecionado);

        // PRODUTOS-FEITOS-COM-ESSE-ARTEFATO-INICIO
        listAnrafelSQL08ATED = JDBCController.anrafelSQL08(sIdDoartselecionado);

        habilitaUserAATED = true;
        habilitaUserBATED = true;
        usersATED = JDBCController.anrafelSQL09();

        listaUsersATED = (ArrayList<User>) userDao.todosUser();
        mediumUserModelATED = new UserDM(listaUsersATED);

    }

    public void developmentMountTREEAbbaController(String sIdDoartselecionado) {
        numAbaAbertaDVLP1T = "0";
        habilitaIDVLP1T = true;
        habilitaIIDVLP1T = true;
        sIdDoartselecionadoGLOBAL = sIdDoartselecionado;
        // USUARIOS-UTILIZOU-ESSE-ARTEFATO-FIM
        listAnrafelSQL10DVLP1T = JDBCController.anrafelSQL10(getProduct_name());

        // PRODUTOS-FEITOS-COM-ESSE-ARTEFATO-INICIO
        listAnrafelSQL08DVLP1T = JDBCController.anrafelSQL08(sIdDoartselecionado);
        mostraPageViewIIDVLP1T = true;
        // listAnrafelSQL06DVLP1T.clear();
        listAnrafelSQL06DVLP1T = JDBCController.anrafelSQL06(sIdDoartselecionado);

        habilitaUserADVLP1T = true;
        habilitaUserBDVLP1T = true;
        usersDVLP1T = JDBCController.anrafelSQL09();

        listaUsersDVLP1T = (ArrayList<User>) userDao.todosUser();
        mediumUserModelDVLP1T = new UserDM(listaUsersDVLP1T);

    }

    public void PerceptionBoxControllerZERO() {
        setAnrafelSQL09(null);
        users.clear();
        setUsers(users);
        setSparqlfield(null);
        setFieldTerms(null);
        setListCommunicationView(null);
        setListAnrafelSQL01(null);
        setListAnrafelSQL02(null);
        setListAnrafelSQL03(null);
        setListAnrafelSQL04(null);
        setListAnrafelSQL05(null);
        listAnrafelSQL06.clear();
        setListAnrafelSQL06(listAnrafelSQL06);
        setListAnrafelSQL07(null);
        setListAnrafelSQL07_1(null);
        setListAnrafelSQL07_2(null);
        setListAnrafelSQL07_3(null);
        setListAnrafelSQL08(null);
        setSetaPageView(null);
        setListaUsers(null);
        setMostraIndexXml(null);
        //   listAnrafelSQL09.clear();
        // setListAnrafelSQL09(listAnrafelSQL09);

    }

    public String queryTerms() {
        return null;
    }

    public String sparqlQuery() {//textarea                  

        ServOntologyGenericSparql_Service webservice = new ServOntologyGenericSparql_Service();
        ServOntologyGenericSparql servico = webservice.getServOntologyGenericSparqlPort();
        String LOCAL = servico.returnGenericSparql("http://plscience.superdignus.com/CollaborativePL-ScienceOntologyv1.owl", sparqlfield);

        return null;
    }

    /**
     * faz 5 consultas (non-Javadoc)
     *
     * @return
     */
    public String viewContMassageII() {
        mensagemEnviada = "";
        numAbaAberta = "2";
        numAbaAbertaII = "1";
        mostraPageViewII = false;
        listAnrafelSQL02.clear();
        listAnrafelSQL03.clear();
        listAnrafelSQL04.clear();
        listAnrafelSQL05.clear();
        listAnrafelSQL06.clear();
        // Pega o parÃ¢metro via request.
        String idRationale1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idRationale");
        if (idRationale1 == null) {
            return null;
        }
        String num = idRationale1.trim();
        idRationaleSelect = Integer.parseInt(num);
        //nomeImagem = "e-mail.png";
        //controlaTempo = 60;

        ////System.out.println("idRationale:idRationale:idRationale: "
        //   + idRationale1);
        listAnrafelSQL02 = JDBCController.anrafelSQL02(idRationale1);
        listAnrafelSQL03 = JDBCController.anrafelSQL03(idRationale1);
        listAnrafelSQL04 = JDBCController.anrafelSQL04(idRationale1);
        listAnrafelSQL05 = JDBCController.anrafelSQL05(idRationale1);
        mostraPageViewII = false;

        listaUsers = (ArrayList<User>) userDao.todosUser();
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-UPDATE-TABELA-lidaSN-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        int idUserContext = IDContextController.pegaIDcontext();
        JDBCController.updateMsgLida(idUserContext);

        setaPageView = "includePage7ViewBox08.xhtml";

        // esta OK
        return null;
    }

    public void buscaBuiltProducts(String NameArtifactD, String NameArtifactMapD, String NameArtifactOntD) {
        listAnrafelSQL11DVLP1 = JDBCController.anrafelSQL11(NameArtifactD, NameArtifactMapD, NameArtifactOntD);
    }

    public String viewContMassageIIDVLP1T() {
        mensagemEnviadaDVLP1T = "";
        numAbaAbertaDVLP1T = "2";
        numAbaAbertaIIDVLP1T = "1";
        mostraPageViewIIDVLP1T = false;
        //listAnrafelSQL02DVLP1T.clear();
        //listAnrafelSQL03DVLP1T.clear();
        //listAnrafelSQL04DVLP1T.clear();
        // listAnrafelSQL05DVLP1T.clear();
        // listAnrafelSQL06DVLP1T.clear();
        // Pega o parÃ¢metro via request.
        String idRationale1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idRationale");
        if (idRationale1 == null) {
            return null;
        }
        String num = idRationale1.trim();
        idRationaleSelectDVLP1T = Integer.parseInt(num);
        //nomeImagem = "e-mail.png";
        //controlaTempo = 60;

        ////System.out.println("idRationale:idRationale:idRationale: "
        //   + idRationale1);
        listAnrafelSQL02DVLP1T = JDBCController.anrafelSQL02(idRationale1);
        listAnrafelSQL03DVLP1T = JDBCController.anrafelSQL03(idRationale1);
        listAnrafelSQL04DVLP1T = JDBCController.anrafelSQL04(idRationale1);
        listAnrafelSQL05DVLP1T = JDBCController.anrafelSQL05(idRationale1);
        mostraPageViewIIDVLP1T = false;

        listaUsersDVLP1T = (ArrayList<User>) userDao.todosUser();
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-UPDATE-TABELA-lidaSN-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        int idUserContext = IDContextController.pegaIDcontext();
        JDBCController.updateMsgLida(idUserContext);

        setaPageViewDVLP1T = "includePage7ViewBox08.xhtml";

        // esta OK
        return null;
    }

    /**
     * faz 5 consultas (non-Javadoc)
     *
     * @return
     * @see br.com.ufjf.control.main.ukj#viewContMassageIII()
     */
    public String viewContMassageIII() {
        numAbaAbertaIncludePage5LateralDireita04 = "2";
        numAbaAbertaIncludePage5LateralDireita04II = "1";
        mensagemEnviada = "";
        mostraPageViewII = false;
        listAnrafelSQL02.clear();
        listAnrafelSQL03.clear();
        listAnrafelSQL04.clear();
        listAnrafelSQL05.clear();
        listAnrafelSQL06.clear();
        // Pega o parÃ¢metro via request.
        String idRationale1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idRationale");
        if (idRationale1 == null) {
            return null;
        }

        String num = idRationale1.trim();
        idRationaleSelect = Integer.parseInt(num);

        // System.out.println("idRationale:idRationale:idRationale: "
        // + idRationale1);
        listAnrafelSQL02 = JDBCController.anrafelSQL02(idRationale1);
        listAnrafelSQL03 = JDBCController.anrafelSQL03(idRationale1);
        listAnrafelSQL04 = JDBCController.anrafelSQL04(idRationale1);
        listAnrafelSQL05 = JDBCController.anrafelSQL05(idRationale1);
        mostraPageViewII = false;

        listaUsers = (ArrayList<User>) userDao.todosUser();
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-UPDATE-TABELA-lidaSN-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        idUsercontext = IDContextController.pegaIDcontext();

        JDBCController.updateMsgLida(idUsercontext);

        setaPageView = "includePage7ViewBox08_1.xhtml";

        // return "definePage03ViewArtifact1.xhtml";
        return null;
    }

    public String viewContMassageIIIDVLP1() {
        numAbaAbertaDVLP1 = "2";
        numAbaAbertaIIDVLP1 = "1";
        mensagemEnviadaDVLP1 = "";
        mostraPageViewIIDVLP1 = false;

        // Pega o parÃ¢metro via request.
        String idRationale1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idRationale");

        String num = idRationale1.trim();
        idRationaleSelect = Integer.parseInt(num);

        listAnrafelSQL02DVLP1 = JDBCController.anrafelSQL02(idRationale1);
        listAnrafelSQL03DVLP1 = JDBCController.anrafelSQL03(idRationale1);
        listAnrafelSQL04DVLP1 = JDBCController.anrafelSQL04(idRationale1);
        listAnrafelSQL05DVLP1 = JDBCController.anrafelSQL05(idRationale1);
        mostraPageViewIIDVLP1 = false;

        listaUsersDVLP1 = (ArrayList<User>) userDao.todosUser();
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-UPDATE-TABELA-lidaSN-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
        idUsercontext = IDContextController.pegaIDcontext();

        JDBCController.updateMsgLida(idUsercontext);

        setaPageViewDVLP1 = "includePage7ViewBox08_1_1.xhtml";

        // return "definePage03ViewArtifact1.xhtml";
        return null;
    }

    public List<AnrafelSQL06> buscaUsersAnrafelSQL06(String idScientistLogado) {
        listAnrafelSQL06 = JDBCController.anrafelSQL06(idScientistLogado);
        return listAnrafelSQL06;
    }

    /**
     * usando webserver
     *
     * @return
     * @see br.com.ufjf.control.main.ukj#respondeMensagem()
     */
    public String respondeMensagemI() {
        listAnrafelSQL06.clear();
        int id = userSelecionado;
        int idUserContext = IDContextController.pegaIDcontext();
        Communication com;
        ServCommunication_Service webservice = new ServCommunication_Service();
        ServCommunication servico = webservice.getServCommunicationPort();
        String LOCAL = servico.fullCommunicationXML(idRationaleSelect, idUserContext, id, mensagemEnviada);
        com = (Communication) unmarshalFromFile(Communication.class, LOCAL);
        communicatioDao.salvar(com);
        listAnrafelSQL06.clear();
        int pegaIDcontext = IDContextController.pegaIDcontext();
        String idScientistString = String.valueOf(pegaIDcontext);
        listAnrafelSQL06 = JDBCController.anrafelSQL06(idScientistString);
        /*seta numero da aba que sera aberta*/
        numAbaAbertaIncludePage5LateralDireita04 = "0";

        /*implenta o <cif> com verdadeiro*/
        mostraPageViewII = true;
        habilitaMSGView1 = false;

        // return "definePage03ViewArtifact1.xhtml";
        return null;

    }

    public String respondeMensagemIDVLP1() {
        listAnrafelSQL06DVLP1.clear();
        int id = userSelecionado;
        int idUserContext = IDContextController.pegaIDcontext();
        Communication com;
        ServCommunication_Service webservice = new ServCommunication_Service();
        ServCommunication servico = webservice.getServCommunicationPort();
        String LOCAL = servico.fullCommunicationXML(idRationaleSelect, idUserContext, id, mensagemEnviadaDVLP1);
        com = (Communication) unmarshalFromFile(Communication.class, LOCAL);
        communicatioDao.salvar(com);
        listAnrafelSQL06DVLP1.clear();
        int pegaIDcontext = IDContextController.pegaIDcontext();
        String idScientistString = String.valueOf(pegaIDcontext);
        listAnrafelSQL06DVLP1 = JDBCController.anrafelSQL06(idScientistString);
        /*seta numero da aba que sera aberta*/
        numAbaAbertaDVLP1 = "0";

        /*implenta o <cif> com verdadeiro*/
        mostraPageViewIIDVLP1 = true;
        habilitaMSGView1DVLP1 = false;

        // return "definePage03ViewArtifact1.xhtml";
        return null;

    }

    /**
     * metodo voltar do nucleo de percepção
     *
     * @return
     * @see br.com.ufjf.control.main.ukj#productDevelopment()
     */
    public void backTreack() {
        numAbaAbertaIncludePage5LateralDireita04 = "0";
        mostraPageViewII = true;
        String idScientist = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("idScientist");
        listAnrafelSQL06.clear();
        listAnrafelSQL06 = JDBCController.anrafelSQL06(idScientist);

    }

    public void backTreackDVLP1T() {
        numAbaAbertaDVLP1T = "0";
        mostraPageViewIIDVLP1T = true;
        String idScientist = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("idScientist");

        listAnrafelSQL06DVLP1T = JDBCController.anrafelSQL06(idScientist);

    }

    /**
     * metodo voltar do nucleo de percepção
     *
     * @return
     * @see br.com.ufjf.control.main.ukj#productDevelopment()
     */
    public String back() {
        numAbaAbertaIncludePage5LateralDireita04 = "0";
        mostraPageViewII = true;
        // Pega o parÃ¢metro via request.
        String idScientist = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("idScientist");

        String query234 = "SELECT A.`idComunication` FROM `Communication` A ORDER BY A.`idComunication` DESC LIMIT 1";

        habilitaMSGView1 = false;
        listAnrafelSQL06 = new ArrayList<AnrafelSQL06>();
        /* removendo itens do arreyListe */
        for (int i = 0; i < listAnrafelSQL06.size(); i++) {
            listAnrafelSQL06.remove(i);
        }
        listAnrafelSQL06.clear();
        listAnrafelSQL06 = JDBCController.anrafelSQL06(idScientist);

        return null;
    }

    public String backDVLP1() {
        numAbaAbertaDVLP1 = "0";
        mostraPageViewIIDVLP1 = true;
        // Pega o parÃ¢metro via request.
        String idScientist = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("idScientist");

        String query234 = "SELECT A.`idComunication` FROM `Communication` A ORDER BY A.`idComunication` DESC LIMIT 1";

        habilitaMSGView1DVLP1 = false;
        listAnrafelSQL06DVLP1 = new ArrayList<AnrafelSQL06>();
        /* removendo itens do arreyListe */
        for (int i = 0; i < listAnrafelSQL06DVLP1.size(); i++) {
            listAnrafelSQL06DVLP1.remove(i);
        }
        listAnrafelSQL06DVLP1.clear();
        listAnrafelSQL06DVLP1 = JDBCController.anrafelSQL06(idScientist);

        return null;
    }

    /**
     * Realiza a conversao (unmarshal) de um arquivo XML em um objeto do seu
     * tipo.
     *
     * @param clazz classe referente ao objeto a ser criado a partir do XML.
     * @param fileXml nome do arquivo XML a ser convertido em objeto.
     * @return novo objeto.
     */
    @SuppressWarnings("rawtypes")
    public static Object unmarshalFromFile(Class clazz, String fileXml) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(new FileInputStream(fileXml));
        } catch (JAXBException e) {
            // e.printStackTrace();
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
        }
        return null;
    }

    public ArrayList<AnrafelSQL09> buscaUsers() {
        users.clear();
        users = JDBCController.anrafelSQL09();
        return users;
    }

    public ArrayList<AnrafelSQL09> buscaUsersDVLP1() {
        //usersDVLP1.clear();
        usersDVLP1 = JDBCController.anrafelSQL09();
        return usersDVLP1;
    }

    public List<AnrafelSQL06> buscalistAnrafelSQL06(String idDoUserLogado) {
        listAnrafelSQL06.clear();
        listAnrafelSQL06 = JDBCController.anrafelSQL06(idDoUserLogado);
        return listAnrafelSQL06;
    }

    /**
     * gerente de artefatos
     *
     *
     *
     * utilizado na pagina de edição de artifacts
     */
    public void artifactManager() {
        String retorna;
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.getAttribute("currentUser");

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

        /*id do artefato aleatorio colocado por mim mesmo com minha autonomia*/
        int idDoart = 1;
        String sIdDoart = String.valueOf(idDoart);

        // USUARIOS-UTILIZOU-ESSE-ARTEFATO-FIM
        listAnrafelSQL07 = JDBCController.anrafelSQL07(sIdDoart);
        // PRODUTOS-FEITOS-COM-ESSE-ARTEFATO-INICIO
        listAnrafelSQL08 = JDBCController.anrafelSQL08(sIdDoart);

        /* preenche os inputtext a serem alterados */
        int idDoArtefato = 1;
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
        listaUsers = (ArrayList<User>) userDao.todosUser();
        mediumUserModel = new UserDM(listaUsers);
        // pegaIDcontext();

        // retorna = "definePage13EditArtifact";
        retorna = null;

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
            viewBoxII = "includePage7ViewBox02_1.xhtml";
        } else {
            numAbaAberta = "5";
            viewBoxII = "";
            habilitaII = true;
            habilitaMSG = true;
            mostraMensagemGeral3 = "Select an User!";
        }
        return null;
    }

    public String buscaUserMSGDVLP1T() {
        if (selectedUserModelDVLP1T != null) {
            numAbaAbertaDVLP1T = "5";
            habilitaIIDVLP1T = false;
            String nominho = selectedUserModelDVLP1T.getNameScientist();
            nomeUserTalkDVLP1T = nominho.toUpperCase();
            viewBoxIIDVLP1T = "includePage7ViewBox02_1_1.xhtml";
        } else {
            numAbaAbertaDVLP1T = "5";
            viewBoxIIDVLP1T = "";
            habilitaIIDVLP1T = true;
            habilitaMSGDVLP1T = true;
            mostraMensagemGeral3DVLP1T = "Select an User!";
        }
        return null;
    }

    public String buscaUserMSGATED() {
        if (selectedUserModelATED != null) {
            numAbaAbertaATED = "5";
            habilitaIIATED = false;
            String nominho = selectedUserModelATED.getNameScientist();
            nomeUserTalkATED = nominho.toUpperCase();
            viewBoxIIATED = "includePage7ViewBox02_1.xhtml";
        } else {
            numAbaAbertaATED = "5";
            viewBoxIIATED = "";
            habilitaIIATED = true;
            habilitaMSGATED = true;
            mostraMensagemGeral3ATED = "Select an User!";
        }
        return null;
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

        return "definePage10ViewFeatureRead";
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
        viewBox = "includePage7ViewBox01_1.xhtml";
        // User us = new User();
        listaUsers = new ArrayList<User>();
        User x = new User();
        listaUsers = (ArrayList<User>) userDao.todos(x.getClass());
        mediumUserModel = new UserDM(listaUsers);
        mensagemValor = "";
        return "definePage10ViewFeatureRead";
    }

    public String includeNoteDVLP1T() {
        numAbaAbertaDVLP1T = "4";
        habilitaIIDVLP1T = true;
        habilitaIDVLP1T = false;
        viewBoxDVLP1T = "includePage7ViewBox01_1_1.xhtml";
        // User us = new User();
        listaUsersDVLP1T = new ArrayList<User>();
        listaUsersDVLP1T = (ArrayList<User>) userDao.todosUser();
        mediumUserModelDVLP1T = new UserDM(listaUsersDVLP1T);
        mensagemValorDVLP1T = "";
        return "definePage10ViewFeatureRead";
    }

    public String includeNoteATED() {
        numAbaAbertaATED = "4";
        habilitaIIATED = true;
        habilitaIATED = false;
        viewBoxATED = "includePage7ViewBox01_1.xhtml";
        // User us = new User();
        listaUsersATED = new ArrayList<User>();

        listaUsersATED = (ArrayList<User>) userDao.todosUser();
        mediumUserModelATED = new UserDM(listaUsersATED);
        mensagemValor = "";

        //return "definePage10ViewFeatureRead";
        return null;
    }

    /**
     * Method gravaNote NOTE RECORDS IN DATABASE
     *
     * @return String
     *
     */
    public String gravaNote() {

        /**
         * SALVA O NOTES COM SERVIÇO DE PREENCHER O OBJETO NOTES
         */
        if (!mensagemValor.equals("")) {
            msgNotesVazia = "";
            Notes nt;
            int idUltimoRatinaleGravdo = IDContextController.pegaIdUltimoRatinaleGravdo();
            ServAnnotation_Service webservice = new ServAnnotation_Service();
            ServAnnotation servico = webservice.getServAnnotationPort();
            String LOCAL = servico.fullNotesXML(mensagemValor, idUltimoRatinaleGravdo);
            nt = (Notes) unmarshalFromFile(Notes.class, LOCAL);

            notesDAO.salvar(nt);
            numAbaAberta = "4";
            habilitaII = true;
            habilitaI = true;
            viewBox = " ";

            listaUsers = new ArrayList<User>();
            User x = new User();
            listaUsers = (ArrayList<User>) userDao.todos(x.getClass());
            mediumUserModel = new UserDM(listaUsers);

        } else {
            msgNotesVazia = "Empty Text!";
        }

        return null;
    }

    public String gravaNoteATED() {

        /**
         * SALVA O NOTES COM SERVIÇO DE PREENCHER O OBJETO NOTES
         */
        if (!mensagemValorATED.equals("")) {
            msgNotesVaziaATED = "";
            Notes nt;
            int idUltimoRatinaleGravdo = IDContextController.pegaIdUltimoRatinaleGravdo();
            if (idUltimoRatinaleGravdo == 0) {
                idUltimoRatinaleGravdo = 1;
            }
            ServAnnotation_Service webservice = new ServAnnotation_Service();
            ServAnnotation servico = webservice.getServAnnotationPort();
            String LOCAL = servico.fullNotesXML(mensagemValorATED, idUltimoRatinaleGravdo);
            nt = (Notes) unmarshalFromFile(Notes.class, LOCAL);

            notesDAO.salvar(nt);
            numAbaAbertaATED = "4";
            habilitaIIATED = true;
            habilitaIATED = true;
            viewBoxATED = " ";

            listaUsersATED = new ArrayList<User>();

            listaUsersATED = (ArrayList<User>) userDao.todosUser();
            mediumUserModelATED = new UserDM(listaUsersATED);

        } else {
            msgNotesVaziaATED = "Empty Text!";
        }

        return null;
    }

    public String gravaNoteDVLP1T() {

        /**
         * SALVA O NOTES COM SERVIÇO DE PREENCHER O OBJETO NOTES
         */
        if (!mensagemValorDVLP1T.equals("")) {
            msgNotesVaziaDVLP1T = "";
            Notes nt;
            int idUltimoRatinaleGravdo = IDContextController.pegaIdUltimoRatinaleGravdo();
            if (idUltimoRatinaleGravdo == 0) {
                idUltimoRatinaleGravdo = 1;
            }
            ServAnnotation_Service webservice = new ServAnnotation_Service();
            ServAnnotation servico = webservice.getServAnnotationPort();
            String LOCAL = servico.fullNotesXML(mensagemValorDVLP1T, idUltimoRatinaleGravdo);
            nt = (Notes) unmarshalFromFile(Notes.class, LOCAL);

            notesDAO.salvar(nt);
            numAbaAbertaDVLP1T = "4";
            habilitaIIDVLP1T = true;
            habilitaIDVLP1T = true;
            viewBoxDVLP1T = " ";

            listaUsersDVLP1T = new ArrayList<User>();

            listaUsersDVLP1T = (ArrayList<User>) userDao.todosUser();
            mediumUserModelDVLP1T = new UserDM(listaUsersDVLP1T);

        } else {
            msgNotesVaziaATED = "Empty Text!";
        }

        return null;
    }

    public void carregaListAnrafelSQL06() {
        String idlogadoString = IDContextController.pegaIDcontextString();
        listAnrafelSQL06 = JDBCController.anrafelSQL06(idlogadoString);
    }

    /**
     * grava nota (non-Javadoc)
     *
     * @see br.com.ufjf.control.main.ukj#respondeMensagem()
     */
    public void respondeMensagem() {

        int id = userSelecionado;

        int idUserContext = IDContextController.pegaIDcontext();
        Communication com;
        ServCommunication_Service webservice = new ServCommunication_Service();
        ServCommunication servico = webservice.getServCommunicationPort();
        String LOCAL = servico.fullCommunicationXML(idRationaleSelect, idUserContext, id, mensagemEnviada);
        com = (Communication) unmarshalFromFile(Communication.class, LOCAL);

        communicatioDao.salvar(com);

        listAnrafelSQL06.clear();

        String idScientistString = IDContextController.pegaIDcontextString();
        listAnrafelSQL06 = JDBCController.anrafelSQL06(idScientistString);

        numAbaAberta = "0";
        mostraPageViewII = true;
        // Pega o parÃ¢metro via request.
        String idScientist = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("idScientist");

        String query234 = "SELECT A.`idComunication` FROM `Communication` A ORDER BY A.`idComunication` DESC LIMIT 1";

        habilitaMSGView1 = false;
        listAnrafelSQL06 = new ArrayList<AnrafelSQL06>();
        /* removendo itens do arreyListe */
        for (int i = 0; i < listAnrafelSQL06.size(); i++) {
            listAnrafelSQL06.remove(i);
        }
        listAnrafelSQL06.clear();
        listAnrafelSQL06 = JDBCController.anrafelSQL06(idScientist);

    }

    public void respondeMensagemDVLP1T() {

        int id = userSelecionadoDVLP1;

        int idUserContext = IDContextController.pegaIDcontext();
        Communication com;
        ServCommunication_Service webservice = new ServCommunication_Service();
        ServCommunication servico = webservice.getServCommunicationPort();
        String LOCAL = servico.fullCommunicationXML(idRationaleSelectDVLP1T, idUserContext, id, mensagemEnviadaDVLP1T);
        com = (Communication) unmarshalFromFile(Communication.class, LOCAL);

        communicatioDao.salvar(com);

        String idScientistString = IDContextController.pegaIDcontextString();
        listAnrafelSQL06DVLP1T = JDBCController.anrafelSQL06(idScientistString);

        numAbaAbertaDVLP1T = "0";
        mostraPageViewIIDVLP1T = true;
        // Pega o parÃ¢metro via request.
        String idScientist = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("idScientist");

        String query234 = "SELECT A.`idComunication` FROM `Communication` A ORDER BY A.`idComunication` DESC LIMIT 1";

        habilitaMSGView1DVLP1 = false;
        listAnrafelSQL06DVLP1T = new ArrayList<AnrafelSQL06>();

        listAnrafelSQL06DVLP1T = JDBCController.anrafelSQL06(idScientist);

    }

    public String includeUsuario() {
        numAbaAberta = "3";
        habilitaUserA = false;
        // Pega o parâmetro via request.
        String idRationale = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("idRationale");

        listAnrafelSQL07_1.clear();
        listAnrafelSQL07_2.clear();
        listAnrafelSQL07_3.clear();

        listAnrafelSQL07_1 = JDBCController.anrafelSQL07_1(idRationale);
        listAnrafelSQL07_2 = JDBCController.anrafelSQL07_2(idRationale);
        listAnrafelSQL07_3 = JDBCController.anrafelSQL07_3(idRationale);

        viewBoxIII = "includePage7ViewBox06_1.xhtml";

        // return "definePage13EditArtifact";
        return null;
    }

    public String includeUsuarioDVLP1T() {
        numAbaAbertaDVLP1T = "3";
        habilitaUserADVLP1T = false;
        // Pega o parâmetro via request.
        String idRationale = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("idRationale");

        //listAnrafelSQL07_1DVLP1T.clear();
        //listAnrafelSQL07_2DVLP1T.clear();
        // listAnrafelSQL07_3DVLP1T.clear();
        listAnrafelSQL07_1DVLP1T = JDBCController.anrafelSQL07_1(idRationale);
        listAnrafelSQL07_2DVLP1T = JDBCController.anrafelSQL07_2(idRationale);
        listAnrafelSQL07_3DVLP1T = JDBCController.anrafelSQL07_3(idRationale);

        viewBoxIIIDVLP1T = "includePage7ViewBox06_1_1.xhtml";

        // return "definePage13EditArtifact";
        return null;
    }

    public String includeUsuarioATED() {
        numAbaAbertaATED = "3";
        habilitaUserAATED = false;
        habilitaUserBATED = false;
        habilitaUserBATED = false;

        // Pega o parâmetro via request.
        String idRationale = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("idRationale");

        listAnrafelSQL07_1ATED = JDBCController.anrafelSQL07_1(idRationale);
        listAnrafelSQL07_2ATED = JDBCController.anrafelSQL07_2(idRationale);
        listAnrafelSQL07_3ATED = JDBCController.anrafelSQL07_3(idRationale);
        viewBoxIIIATED = "includePage7ViewBox06_1.xhtml";

        // return "definePage13EditArtifact";
        return null;
    }

    /**
     * Method includeUsuarioBack button navigation
     *
     * @return String
     *
     */
    public String includeUsuarioBack() {
        numAbaAberta = "3";
        habilitaUserA = true;
        viewBoxIII = "";

        return null;
    }

    /**
     * Method includeUsuarioBack button navigation
     *
     * @return String
     *
     */
    public String includeUsuarioBackATED() {
        numAbaAbertaATED = "0";
        habilitaUserAATED = true;
        viewBoxIIIATED = "";

        // USUARIOS-UTILIZOU-ESSE-ARTEFATO-FIM
        listAnrafelSQL07ATED.clear();
        listAnrafelSQL07ATED = JDBCController.anrafelSQL07(sIdDoartselecionadoGLOBAL);

        listAnrafelSQL08ATED.clear();
        // PRODUTOS-FEITOS-COM-ESSE-ARTEFATO-INICIO
        listAnrafelSQL08ATED = JDBCController.anrafelSQL08(sIdDoartselecionadoGLOBAL);

        habilitaUserAATED = true;
        habilitaUserBATED = true;
        usersATED.clear();
        usersATED = JDBCController.anrafelSQL09();

        return null;
    }

    public String includeUsuarioBackDVLP1T() {
        numAbaAbertaDVLP1T = "0";
        habilitaUserADVLP1T = true;
        viewBoxIIIDVLP1T = "";

        // USUARIOS-UTILIZOU-ESSE-ARTEFATO-FIM
        //listAnrafelSQL07DVLP1T.clear();
        listAnrafelSQL10DVLP1T = JDBCController.anrafelSQL10(getProduct_name());

        //listAnrafelSQL08ATED.clear();
        // PRODUTOS-FEITOS-COM-ESSE-ARTEFATO-INICIO
        //listAnrafelSQL08ATED = JDBCController.anrafelSQL08(sIdDoartselecionadoGLOBAL);
        habilitaUserADVLP1T = true;
        habilitaUserBDVLP1T = true;
        //usersDVLP1T.clear();
        usersDVLP1T = JDBCController.anrafelSQL09();
        ;
        return null;
    }

    public String gravaCommunication() {
        /**
         * SALVA O NOTES COM SERVIÇO DE PREENCHER O OBJETO NOTES
         */
        if (!messageCommunication.equals("")) {
            msgCommunicatioVazia = "";

            int idUserContext = IDContextController.pegaIDcontext();
            int idUltimoRatinaleGravdo = IDContextController.pegaIdUltimoRatinaleGravdo();
            Communication com;
            ServCommunication_Service webservice = new ServCommunication_Service();
            ServCommunication servico = webservice.getServCommunicationPort();
            String LOCAL = servico.fullCommunicationXML(idUltimoRatinaleGravdo, idUserContext, selectedUserModel.getIdScientist(), messageCommunication);
            com = (Communication) unmarshalFromFile(Communication.class, LOCAL);

            communicatioDao.salvar(com);

            messageCommunication = " ";
            numAbaAberta = "5";
            habilitaII = true;
            habilitaI = true;
            viewBoxII = " ";

            listaUsers = new ArrayList<User>();
            User x = new User();
            listaUsers = (ArrayList<User>) userDao.todos(x.getClass());
            mediumUserModel = new UserDM(listaUsers);

        } else {
            msgCommunicatioVazia = "Empty Text!";
        }

        return "definePage10ViewFeatureRead";
    }

    public String gravaCommunicationATED() {
        /**
         * SALVA O NOTES COM SERVIÇO DE PREENCHER O OBJETO NOTES
         */
        if (!messageCommunicationATED.equals("")) {
            msgCommunicatioVaziaATED = "";

            int idUserContext = IDContextController.pegaIDcontext();
            int idUltimoRatinaleGravdo = IDContextController.pegaIdUltimoRatinaleGravdo();

            Communication com;
            ServCommunication_Service webservice = new ServCommunication_Service();
            ServCommunication servico = webservice.getServCommunicationPort();
            String LOCAL = servico.fullCommunicationXML(idUltimoRatinaleGravdo, idUserContext, selectedUserModelATED.getIdScientist(), messageCommunicationATED);
            com = (Communication) unmarshalFromFile(Communication.class, LOCAL);

            communicatioDao.salvar(com);

            messageCommunicationATED = " ";
            numAbaAbertaATED = "5";
            habilitaIIATED = true;
            habilitaIATED = true;
            viewBoxIIATED = " ";

            listaUsersATED = new ArrayList<User>();
            listaUsersATED = (ArrayList<User>) userDao.todosUser();
            mediumUserModelATED = new UserDM(listaUsersATED);

        } else {
            msgCommunicatioVaziaATED = "Empty Text!";
        }

        // return "definePage10ViewFeatureRead";
        return null;
    }

    public String gravaCommunicationDVLP1T() {
        /**
         * SALVA O NOTES COM SERVIÇO DE PREENCHER O OBJETO NOTES
         */
        if (!messageCommunicationDVLP1T.equals("")) {
            msgCommunicatioVaziaDVLP1T = "";

            int idUserContext = IDContextController.pegaIDcontext();
            int idUltimoRatinaleGravdo = IDContextController.pegaIdUltimoRatinaleGravdo();

            Communication com;
            ServCommunication_Service webservice = new ServCommunication_Service();
            ServCommunication servico = webservice.getServCommunicationPort();
            String LOCAL = servico.fullCommunicationXML(idUltimoRatinaleGravdo, idUserContext, selectedUserModelDVLP1T.getIdScientist(), messageCommunicationDVLP1T);
            com = (Communication) unmarshalFromFile(Communication.class, LOCAL);

            communicatioDao.salvar(com);

            messageCommunicationDVLP1T = " ";
            numAbaAbertaDVLP1T = "5";
            habilitaIIDVLP1T = true;
            habilitaIDVLP1T = true;
            viewBoxIIDVLP1T = " ";

            listaUsersDVLP1T = new ArrayList<User>();
            listaUsersDVLP1T = (ArrayList<User>) userDao.todosUser();
            mediumUserModelDVLP1T = new UserDM(listaUsersDVLP1T);
            selectedUserModelDVLP1T = null;

        } else {
            msgCommunicatioVaziaDVLP1T = "Empty Text!";
        }

        // return "definePage10ViewFeatureRead";
        return null;
    }

    public String gravaCommunicationCancel() {

        messageCommunication = " ";
        numAbaAberta = "5";
        habilitaII = true;
        habilitaI = true;
        viewBoxII = " ";

        listaUsers = new ArrayList<User>();
        User x = new User();
        listaUsers = (ArrayList<User>) userDao.todos(x.getClass());
        mediumUserModel = new UserDM(listaUsers);
        selectedUserModel = null;
        return "definePage10ViewFeatureRead";
    }

    public String gravaCommunicationCancelATED() {

        messageCommunicationATED = " ";
        numAbaAbertaATED = "5";
        habilitaIIATED = true;
        habilitaIATED = true;
        viewBoxIIATED = " ";

        listaUsersATED = new ArrayList<User>();

        listaUsersATED = (ArrayList<User>) userDao.todosUser();
        mediumUserModelATED = new UserDM(listaUsersATED);
        selectedUserModelATED = null;
        //return "definePage10ViewFeatureRead";
        return null;
    }

    public String gravaCommunicationCancelDVLP1T() {

        messageCommunicationDVLP1T = " ";
        numAbaAbertaDVLP1T = "5";
        habilitaIIDVLP1T = true;
        habilitaIDVLP1T = true;
        viewBoxIIDVLP1T = " ";

        listaUsersDVLP1T = new ArrayList<User>();

        listaUsersDVLP1T = (ArrayList<User>) userDao.todosUser();
        mediumUserModelDVLP1T = new UserDM(listaUsersDVLP1T);

        selectedUserModelDVLP1T = null;

        //return "definePage10ViewFeatureRead";
        return null;
    }

    public String includeNoteCancel() {

        numAbaAberta = "4";
        habilitaII = true;
        habilitaI = true;
        viewBox = " ";
        listaUsers = new ArrayList<User>();
        listaUsers = (ArrayList<User>) userDao.todosUser();
        mediumUserModel = new UserDM(listaUsers);
        mensagemValor = "";

        return null;
    }

    public String includeNoteCancelATED() {

        numAbaAbertaATED = "4";
        habilitaIIATED = true;
        habilitaIATED = true;
        viewBoxATED = " ";
        listaUsersATED = new ArrayList<User>();
        listaUsersATED = (ArrayList<User>) userDao.todosUser();
        mediumUserModelATED = new UserDM(listaUsersATED);
        mensagemValorATED = "";

        return null;
    }

    public String includeNoteCancelDVLP1T() {

        numAbaAbertaDVLP1T = "4";
        habilitaIIDVLP1T = true;
        habilitaIDVLP1T = true;
        viewBoxDVLP1T = " ";
        listaUsersDVLP1T = new ArrayList<User>();
        listaUsersDVLP1T = (ArrayList<User>) userDao.todosUser();
        mediumUserModelDVLP1T = new UserDM(listaUsersDVLP1T);
        mensagemValorDVLP1T = "";

        return null;
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

    public RationaleDAO getRationaleDao() {
        return rationaleDao;
    }

    public void setRationaleDao(RationaleDAO rationaleDao) {
        this.rationaleDao = rationaleDao;
    }

    public WhoTableDAO getWhoDao() {
        return WhoDao;
    }

    public void setWhoDao(WhoTableDAO WhoDao) {
        this.WhoDao = WhoDao;
    }

    public WhenTableDAO getWhenDao() {
        return WhenDao;
    }

    public void setWhenDao(WhenTableDAO WhenDao) {
        this.WhenDao = WhenDao;
    }

    public HowTableDAO getHowDao() {
        return howDao;
    }

    public void setHowDao(HowTableDAO howDao) {
        this.howDao = howDao;
    }

    public WhatTableDAO getWhatDao() {
        return whatDao;
    }

    public void setWhatDao(WhatTableDAO whatDao) {
        this.whatDao = whatDao;
    }

    public WhereTableDAO getWhere1Dao() {
        return where1Dao;
    }

    public void setWhere1Dao(WhereTableDAO where1Dao) {
        this.where1Dao = where1Dao;
    }

    public CommunicationDAO getCommunicatioDao() {
        return communicatioDao;
    }

    public void setCommunicatioDao(CommunicationDAO communicatioDao) {
        this.communicatioDao = communicatioDao;
    }

    public ArtifactsUsedDAO getArtifactUsedDao() {
        return artifactUsedDao;
    }

    public void setArtifactUsedDao(ArtifactsUsedDAO artifactUsedDao) {
        this.artifactUsedDao = artifactUsedDao;
    }

    public NotesDAO getNotesDAO() {
        return notesDAO;
    }

    public void setNotesDAO(NotesDAO notesDAO) {
        this.notesDAO = notesDAO;
    }

    public AnrafelSQL09 getAnrafelSQL09() {
        return anrafelSQL09;
    }

    public void setAnrafelSQL09(AnrafelSQL09 anrafelSQL09) {
        this.anrafelSQL09 = anrafelSQL09;
    }

    public ArrayList<AnrafelSQL09> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<AnrafelSQL09> users) {
        this.users = users;
    }

    public String getSparqlfield() {
        return sparqlfield;
    }

    public void setSparqlfield(String sparqlfield) {
        this.sparqlfield = sparqlfield;
    }

    public String getFieldTerms() {
        return fieldTerms;
    }

    public void setFieldTerms(String fieldTerms) {
        this.fieldTerms = fieldTerms;
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

    public ArrayList<Communication> getListCommunicationView() {
        return listCommunicationView;
    }

    public void setListCommunicationView(ArrayList<Communication> listCommunicationView) {
        this.listCommunicationView = listCommunicationView;
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

    public String getSetaPageView() {
        return setaPageView;
    }

    public void setSetaPageView(String setaPageView) {
        this.setaPageView = setaPageView;
    }

    public ArrayList<User> getListaUsers() {
        return listaUsers;
    }

    public void setListaUsers(ArrayList<User> listaUsers) {
        this.listaUsers = listaUsers;
    }

    public String getNumAbaAbertaIncludePage5LateralDireita04() {
        return numAbaAbertaIncludePage5LateralDireita04;
    }

    public void setNumAbaAbertaIncludePage5LateralDireita04(String numAbaAbertaIncludePage5LateralDireita04) {
        this.numAbaAbertaIncludePage5LateralDireita04 = numAbaAbertaIncludePage5LateralDireita04;
    }

    public String getNumAbaAbertaIncludePage5LateralDireita04II() {
        return numAbaAbertaIncludePage5LateralDireita04II;
    }

    public void setNumAbaAbertaIncludePage5LateralDireita04II(String numAbaAbertaIncludePage5LateralDireita04II) {
        this.numAbaAbertaIncludePage5LateralDireita04II = numAbaAbertaIncludePage5LateralDireita04II;
    }

    public String getNumAbaAbertaIncludePage5LateralDireita03() {
        return numAbaAbertaIncludePage5LateralDireita03;
    }

    public void setNumAbaAbertaIncludePage5LateralDireita03(String numAbaAbertaIncludePage5LateralDireita03) {
        this.numAbaAbertaIncludePage5LateralDireita03 = numAbaAbertaIncludePage5LateralDireita03;
    }

    public String getNumAbaAbertaIncludePage5LateralDireita03II() {
        return numAbaAbertaIncludePage5LateralDireita03II;
    }

    public void setNumAbaAbertaIncludePage5LateralDireita03II(String numAbaAbertaIncludePage5LateralDireita03II) {
        this.numAbaAbertaIncludePage5LateralDireita03II = numAbaAbertaIncludePage5LateralDireita03II;
    }

    public String getNumAbaAberta() {
        return numAbaAberta;
    }

    public void setNumAbaAberta(String numAbaAberta) {
        this.numAbaAberta = numAbaAberta;
    }

    public String getNumAbaAbertaII() {
        return numAbaAbertaII;
    }

    public void setNumAbaAbertaII(String numAbaAbertaII) {
        this.numAbaAbertaII = numAbaAbertaII;
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

    public int getIdUsercontext() {
        return idUsercontext;
    }

    public void setIdUsercontext(int idUsercontext) {
        this.idUsercontext = idUsercontext;
    }

    public int getIdRationaleSelect() {
        return idRationaleSelect;
    }

    public void setIdRationaleSelect(int idRationaleSelect) {
        this.idRationaleSelect = idRationaleSelect;
    }

    public ArrayList<ArquivoIndexXML> getMostraIndexXml() {
        return mostraIndexXml;
    }

    public void setMostraIndexXml(ArrayList<ArquivoIndexXML> mostraIndexXml) {
        this.mostraIndexXml = mostraIndexXml;
    }

    public ArquivoIndexXMLDM getArquivoIndexXMLDM() {
        return arquivoIndexXMLDM;
    }

    public void setArquivoIndexXMLDM(ArquivoIndexXMLDM arquivoIndexXMLDM) {
        this.arquivoIndexXMLDM = arquivoIndexXMLDM;
    }

    public ArquivoIndexXML getArquivoIndexXMLSelecionado() {
        return arquivoIndexXMLSelecionado;
    }

    public void setArquivoIndexXMLSelecionado(ArquivoIndexXML arquivoIndexXMLSelecionado) {
        this.arquivoIndexXMLSelecionado = arquivoIndexXMLSelecionado;
    }

    public String getVARIAVELGLOBALURLXML() {
        return VARIAVELGLOBALURLXML;
    }

    public void setVARIAVELGLOBALURLXML(String VARIAVELGLOBALURLXML) {
        this.VARIAVELGLOBALURLXML = VARIAVELGLOBALURLXML;
    }

    public boolean isMostraDownloadXML() {
        return mostraDownloadXML;
    }

    public void setMostraDownloadXML(boolean mostraDownloadXML) {
        this.mostraDownloadXML = mostraDownloadXML;
    }

    public String getMostraNomeWorkflow() {
        return mostraNomeWorkflow;
    }

    public void setMostraNomeWorkflow(String mostraNomeWorkflow) {
        this.mostraNomeWorkflow = mostraNomeWorkflow;
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

    public String getMensagemValor() {
        return mensagemValor;
    }

    public void setMensagemValor(String mensagemValor) {
        this.mensagemValor = mensagemValor;
    }

    public boolean isMostraPageViewAlgoritmo() {
        return mostraPageViewAlgoritmo;
    }

    public void setMostraPageViewAlgoritmo(boolean mostraPageViewAlgoritmo) {
        this.mostraPageViewAlgoritmo = mostraPageViewAlgoritmo;
    }

    public String getMessageCommunication() {
        return messageCommunication;
    }

    public void setMessageCommunication(String messageCommunication) {
        this.messageCommunication = messageCommunication;
    }

    public String getMsgCommunicatioVazia() {
        return msgCommunicatioVazia;
    }

    public void setMsgCommunicatioVazia(String msgCommunicatioVazia) {
        this.msgCommunicatioVazia = msgCommunicatioVazia;
    }

    public String getMsgNotesVazia() {
        return msgNotesVazia;
    }

    public void setMsgNotesVazia(String msgNotesVazia) {
        this.msgNotesVazia = msgNotesVazia;
    }

    public ArrayList<AnrafelSQL09> getListAnrafelSQL09() {
        return listAnrafelSQL09;
    }

    public void setListAnrafelSQL09(ArrayList<AnrafelSQL09> listAnrafelSQL09) {
        this.listAnrafelSQL09 = listAnrafelSQL09;
    }

    public ArrayList<AnrafelSQL09> getUsersATED() {
        return usersATED;
    }

    public void setUsersATED(ArrayList<AnrafelSQL09> usersATED) {
        this.usersATED = usersATED;
    }

    public ArrayList<AnrafelSQL07> getListAnrafelSQL07ATED() {
        return listAnrafelSQL07ATED;
    }

    public void setListAnrafelSQL07ATED(ArrayList<AnrafelSQL07> listAnrafelSQL07ATED) {
        this.listAnrafelSQL07ATED = listAnrafelSQL07ATED;
    }

    public ArrayList<AnrafelSQL07_1> getListAnrafelSQL07_1ATED() {
        return listAnrafelSQL07_1ATED;
    }

    public void setListAnrafelSQL07_1ATED(ArrayList<AnrafelSQL07_1> listAnrafelSQL07_1ATED) {
        this.listAnrafelSQL07_1ATED = listAnrafelSQL07_1ATED;
    }

    public ArrayList<AnrafelSQL07_2> getListAnrafelSQL07_2ATED() {
        return listAnrafelSQL07_2ATED;
    }

    public void setListAnrafelSQL07_2ATED(ArrayList<AnrafelSQL07_2> listAnrafelSQL07_2ATED) {
        this.listAnrafelSQL07_2ATED = listAnrafelSQL07_2ATED;
    }

    public ArrayList<AnrafelSQL07_3> getListAnrafelSQL07_3ATED() {
        return listAnrafelSQL07_3ATED;
    }

    public void setListAnrafelSQL07_3ATED(ArrayList<AnrafelSQL07_3> listAnrafelSQL07_3ATED) {
        this.listAnrafelSQL07_3ATED = listAnrafelSQL07_3ATED;
    }

    public ArrayList<AnrafelSQL08> getListAnrafelSQL08ATED() {
        return listAnrafelSQL08ATED;
    }

    public void setListAnrafelSQL08ATED(ArrayList<AnrafelSQL08> listAnrafelSQL08ATED) {
        this.listAnrafelSQL08ATED = listAnrafelSQL08ATED;
    }

    public String getNumAbaAbertaATED() {
        return numAbaAbertaATED;
    }

    public void setNumAbaAbertaATED(String numAbaAbertaATED) {
        this.numAbaAbertaATED = numAbaAbertaATED;
    }

    public String getViewBoxIIIATED() {
        return viewBoxIIIATED;
    }

    public void setViewBoxIIIATED(String viewBoxIIIATED) {
        this.viewBoxIIIATED = viewBoxIIIATED;
    }

    public boolean isHabilitaUserAATED() {
        return habilitaUserAATED;
    }

    public void setHabilitaUserAATED(boolean habilitaUserAATED) {
        this.habilitaUserAATED = habilitaUserAATED;
    }

    public boolean isHabilitaUserBATED() {
        return habilitaUserBATED;
    }

    public void setHabilitaUserBATED(boolean habilitaUserBATED) {
        this.habilitaUserBATED = habilitaUserBATED;
    }

    public boolean isHabilitaIATED() {
        return habilitaIATED;
    }

    public void setHabilitaIATED(boolean habilitaIATED) {
        this.habilitaIATED = habilitaIATED;
    }

    public boolean isHabilitaMSGATED() {
        return habilitaMSGATED;
    }

    public void setHabilitaMSGATED(boolean habilitaMSGATED) {
        this.habilitaMSGATED = habilitaMSGATED;
    }

    public String getMostraMensagemGeral1ATED() {
        return mostraMensagemGeral1ATED;
    }

    public void setMostraMensagemGeral1ATED(String mostraMensagemGeral1ATED) {
        this.mostraMensagemGeral1ATED = mostraMensagemGeral1ATED;
    }

    public String getMostraMensagemGeral2ATED() {
        return mostraMensagemGeral2ATED;
    }

    public void setMostraMensagemGeral2ATED(String mostraMensagemGeral2ATED) {
        this.mostraMensagemGeral2ATED = mostraMensagemGeral2ATED;
    }

    public String getMostraMensagemGeral3ATED() {
        return mostraMensagemGeral3ATED;
    }

    public void setMostraMensagemGeral3ATED(String mostraMensagemGeral3ATED) {
        this.mostraMensagemGeral3ATED = mostraMensagemGeral3ATED;
    }

    public String getViewBoxATED() {
        return viewBoxATED;
    }

    public void setViewBoxATED(String viewBoxATED) {
        this.viewBoxATED = viewBoxATED;
    }

    public String getViewBoxIIATED() {
        return viewBoxIIATED;
    }

    public void setViewBoxIIATED(String viewBoxIIATED) {
        this.viewBoxIIATED = viewBoxIIATED;
    }

    public boolean isHabilitaIIATED() {
        return habilitaIIATED;
    }

    public void setHabilitaIIATED(boolean habilitaIIATED) {
        this.habilitaIIATED = habilitaIIATED;
    }

    public boolean isHabilitaIIIATED() {
        return habilitaIIIATED;
    }

    public void setHabilitaIIIATED(boolean habilitaIIIATED) {
        this.habilitaIIIATED = habilitaIIIATED;
    }

    public boolean isHabilitaIVATED() {
        return habilitaIVATED;
    }

    public void setHabilitaIVATED(boolean habilitaIVATED) {
        this.habilitaIVATED = habilitaIVATED;
    }

    public boolean isHabilitaVATED() {
        return habilitaVATED;
    }

    public void setHabilitaVATED(boolean habilitaVATED) {
        this.habilitaVATED = habilitaVATED;
    }

    public UserDM getMediumUserModelATED() {
        return mediumUserModelATED;
    }

    public void setMediumUserModelATED(UserDM mediumUserModelATED) {
        this.mediumUserModelATED = mediumUserModelATED;
    }

    public UserDM getMediumUserModelIIATED() {
        return mediumUserModelIIATED;
    }

    public void setMediumUserModelIIATED(UserDM mediumUserModelIIATED) {
        this.mediumUserModelIIATED = mediumUserModelIIATED;
    }

    public User getSelectedUserModelATED() {
        return selectedUserModelATED;
    }

    public void setSelectedUserModelATED(User selectedUserModelATED) {
        this.selectedUserModelATED = selectedUserModelATED;
    }

    public String getNomeUserTalkATED() {
        return nomeUserTalkATED;
    }

    public void setNomeUserTalkATED(String nomeUserTalkATED) {
        this.nomeUserTalkATED = nomeUserTalkATED;
    }

    public ArrayList<User> getListaUsersATED() {
        return listaUsersATED;
    }

    public void setListaUsersATED(ArrayList<User> listaUsersATED) {
        this.listaUsersATED = listaUsersATED;
    }

    public String getMensagemValorATED() {
        return mensagemValorATED;
    }

    public void setMensagemValorATED(String mensagemValorATED) {
        this.mensagemValorATED = mensagemValorATED;
    }

    public String getMsgNotesVaziaATED() {
        return msgNotesVaziaATED;
    }

    public void setMsgNotesVaziaATED(String msgNotesVaziaATED) {
        this.msgNotesVaziaATED = msgNotesVaziaATED;
    }

    public String getMessageCommunicationATED() {
        return messageCommunicationATED;
    }

    public void setMessageCommunicationATED(String messageCommunicationATED) {
        this.messageCommunicationATED = messageCommunicationATED;
    }

    public String getMsgCommunicatioVaziaATED() {
        return msgCommunicatioVaziaATED;
    }

    public void setMsgCommunicatioVaziaATED(String msgCommunicatioVaziaATED) {
        this.msgCommunicatioVaziaATED = msgCommunicatioVaziaATED;
    }

    public String getsIdDoartselecionadoGLOBAL() {
        return sIdDoartselecionadoGLOBAL;
    }

    public void setsIdDoartselecionadoGLOBAL(String sIdDoartselecionadoGLOBAL) {
        this.sIdDoartselecionadoGLOBAL = sIdDoartselecionadoGLOBAL;
    }

    public String getNumAbaAbertaDVLP1() {
        return numAbaAbertaDVLP1;
    }

    public void setNumAbaAbertaDVLP1(String numAbaAbertaDVLP1) {
        this.numAbaAbertaDVLP1 = numAbaAbertaDVLP1;
    }

    public String getNumAbaAbertaIIDVLP1() {
        return numAbaAbertaIIDVLP1;
    }

    public void setNumAbaAbertaIIDVLP1(String numAbaAbertaIIDVLP1) {
        this.numAbaAbertaIIDVLP1 = numAbaAbertaIIDVLP1;
    }

    public ArrayList<AnrafelSQL09> getUsersDVLP1() {
        return usersDVLP1;
    }

    public void setUsersDVLP1(ArrayList<AnrafelSQL09> usersDVLP1) {
        this.usersDVLP1 = usersDVLP1;
    }

    public Boolean isMostraPageViewIIDVLP1() {
        return mostraPageViewIIDVLP1;
    }

    public void setMostraPageViewIIDVLP1(Boolean mostraPageViewIIDVLP1) {
        this.mostraPageViewIIDVLP1 = mostraPageViewIIDVLP1;
    }

    public String getSetaPageViewDVLP1() {
        return setaPageViewDVLP1;
    }

    public void setSetaPageViewDVLP1(String setaPageViewDVLP1) {
        this.setaPageViewDVLP1 = setaPageViewDVLP1;
    }

    public ArrayList<AnrafelSQL07> getListAnrafelSQL07DVLP1() {
        return listAnrafelSQL07DVLP1;
    }

    public void setListAnrafelSQL07DVLP1(ArrayList<AnrafelSQL07> listAnrafelSQL07DVLP1) {
        this.listAnrafelSQL07DVLP1 = listAnrafelSQL07DVLP1;
    }

    public ArrayList<AnrafelSQL07_1> getListAnrafelSQL07_1DVLP1() {
        return listAnrafelSQL07_1DVLP1;
    }

    public void setListAnrafelSQL07_1DVLP1(ArrayList<AnrafelSQL07_1> listAnrafelSQL07_1DVLP1) {
        this.listAnrafelSQL07_1DVLP1 = listAnrafelSQL07_1DVLP1;
    }

    public ArrayList<AnrafelSQL07_2> getListAnrafelSQL07_2DVLP1() {
        return listAnrafelSQL07_2DVLP1;
    }

    public void setListAnrafelSQL07_2DVLP1(ArrayList<AnrafelSQL07_2> listAnrafelSQL07_2DVLP1) {
        this.listAnrafelSQL07_2DVLP1 = listAnrafelSQL07_2DVLP1;
    }

    public ArrayList<AnrafelSQL07_3> getListAnrafelSQL07_3DVLP1() {
        return listAnrafelSQL07_3DVLP1;
    }

    public void setListAnrafelSQL07_3DVLP1(ArrayList<AnrafelSQL07_3> listAnrafelSQL07_3DVLP1) {
        this.listAnrafelSQL07_3DVLP1 = listAnrafelSQL07_3DVLP1;
    }

    public ArrayList<AnrafelSQL08> getListAnrafelSQL08DVLP1() {
        return listAnrafelSQL08DVLP1;
    }

    public void setListAnrafelSQL08DVLP1(ArrayList<AnrafelSQL08> listAnrafelSQL08DVLP1) {
        this.listAnrafelSQL08DVLP1 = listAnrafelSQL08DVLP1;
    }

    public String getMensagemEnviadaDVLP1() {
        return mensagemEnviadaDVLP1;
    }

    public void setMensagemEnviadaDVLP1(String mensagemEnviadaDVLP1) {
        this.mensagemEnviadaDVLP1 = mensagemEnviadaDVLP1;
    }

    public ArrayList<AnrafelSQL01> getListAnrafelSQL01DVLP1() {
        return listAnrafelSQL01DVLP1;
    }

    public void setListAnrafelSQL01DVLP1(ArrayList<AnrafelSQL01> listAnrafelSQL01DVLP1) {
        this.listAnrafelSQL01DVLP1 = listAnrafelSQL01DVLP1;
    }

    public ArrayList<AnrafelSQL02> getListAnrafelSQL02DVLP1() {
        return listAnrafelSQL02DVLP1;
    }

    public void setListAnrafelSQL02DVLP1(ArrayList<AnrafelSQL02> listAnrafelSQL02DVLP1) {
        this.listAnrafelSQL02DVLP1 = listAnrafelSQL02DVLP1;
    }

    public ArrayList<AnrafelSQL03> getListAnrafelSQL03DVLP1() {
        return listAnrafelSQL03DVLP1;
    }

    public void setListAnrafelSQL03DVLP1(ArrayList<AnrafelSQL03> listAnrafelSQL03DVLP1) {
        this.listAnrafelSQL03DVLP1 = listAnrafelSQL03DVLP1;
    }

    public ArrayList<AnrafelSQL04> getListAnrafelSQL04DVLP1() {
        return listAnrafelSQL04DVLP1;
    }

    public void setListAnrafelSQL04DVLP1(ArrayList<AnrafelSQL04> listAnrafelSQL04DVLP1) {
        this.listAnrafelSQL04DVLP1 = listAnrafelSQL04DVLP1;
    }

    public ArrayList<AnrafelSQL05> getListAnrafelSQL05DVLP1() {
        return listAnrafelSQL05DVLP1;
    }

    public void setListAnrafelSQL05DVLP1(ArrayList<AnrafelSQL05> listAnrafelSQL05DVLP1) {
        this.listAnrafelSQL05DVLP1 = listAnrafelSQL05DVLP1;
    }

    public List<AnrafelSQL06> getListAnrafelSQL06DVLP1() {
        return listAnrafelSQL06DVLP1;
    }

    public void setListAnrafelSQL06DVLP1(List<AnrafelSQL06> listAnrafelSQL06DVLP1) {
        this.listAnrafelSQL06DVLP1 = listAnrafelSQL06DVLP1;
    }

    public ArrayList<User> getListaUsersDVLP1() {
        return listaUsersDVLP1;
    }

    public void setListaUsersDVLP1(ArrayList<User> listaUsersDVLP1) {
        this.listaUsersDVLP1 = listaUsersDVLP1;
    }

    public int getUserSelecionadoDVLP1() {
        return userSelecionadoDVLP1;
    }

    public void setUserSelecionadoDVLP1(int userSelecionadoDVLP1) {
        this.userSelecionadoDVLP1 = userSelecionadoDVLP1;
    }

    public boolean isHabilitaMSGView1DVLP1() {
        return habilitaMSGView1DVLP1;
    }

    public void setHabilitaMSGView1DVLP1(boolean habilitaMSGView1DVLP1) {
        this.habilitaMSGView1DVLP1 = habilitaMSGView1DVLP1;
    }

    public boolean isHabilitaMSGView2DVLP1() {
        return habilitaMSGView2DVLP1;
    }

    public void setHabilitaMSGView2DVLP1(boolean habilitaMSGView2DVLP1) {
        this.habilitaMSGView2DVLP1 = habilitaMSGView2DVLP1;
    }

    public Boolean isMostraPageViewDVLP1() {
        return mostraPageViewDVLP1;
    }

    public void setMostraPageViewDVLP1(Boolean mostraPageViewDVLP1) {
        this.mostraPageViewDVLP1 = mostraPageViewDVLP1;
    }

    public ArrayList<AnrafelSQL09> getUsersDVLP1T() {
        return usersDVLP1T;
    }

    public void setUsersDVLP1T(ArrayList<AnrafelSQL09> usersDVLP1T) {
        this.usersDVLP1T = usersDVLP1T;
    }

    public boolean isHabilitaMSGDVLP1T() {
        return habilitaMSGDVLP1T;
    }

    public void setHabilitaMSGDVLP1T(boolean habilitaMSGDVLP1T) {
        this.habilitaMSGDVLP1T = habilitaMSGDVLP1T;
    }

    public ArrayList<AnrafelSQL07> getListAnrafelSQL07DVLP1T() {
        return listAnrafelSQL07DVLP1T;
    }

    public void setListAnrafelSQL07DVLP1T(ArrayList<AnrafelSQL07> listAnrafelSQL07DVLP1T) {
        this.listAnrafelSQL07DVLP1T = listAnrafelSQL07DVLP1T;
    }

    public ArrayList<AnrafelSQL07_1> getListAnrafelSQL07_1DVLP1T() {
        return listAnrafelSQL07_1DVLP1T;
    }

    public void setListAnrafelSQL07_1DVLP1T(ArrayList<AnrafelSQL07_1> listAnrafelSQL07_1DVLP1T) {
        this.listAnrafelSQL07_1DVLP1T = listAnrafelSQL07_1DVLP1T;
    }

    public ArrayList<AnrafelSQL07_2> getListAnrafelSQL07_2DVLP1T() {
        return listAnrafelSQL07_2DVLP1T;
    }

    public void setListAnrafelSQL07_2DVLP1T(ArrayList<AnrafelSQL07_2> listAnrafelSQL07_2DVLP1T) {
        this.listAnrafelSQL07_2DVLP1T = listAnrafelSQL07_2DVLP1T;
    }

    public ArrayList<AnrafelSQL07_3> getListAnrafelSQL07_3DVLP1T() {
        return listAnrafelSQL07_3DVLP1T;
    }

    public void setListAnrafelSQL07_3DVLP1T(ArrayList<AnrafelSQL07_3> listAnrafelSQL07_3DVLP1T) {
        this.listAnrafelSQL07_3DVLP1T = listAnrafelSQL07_3DVLP1T;
    }

    public ArrayList<AnrafelSQL08> getListAnrafelSQL08DVLP1T() {
        return listAnrafelSQL08DVLP1T;
    }

    public void setListAnrafelSQL08DVLP1T(ArrayList<AnrafelSQL08> listAnrafelSQL08DVLP1T) {
        this.listAnrafelSQL08DVLP1T = listAnrafelSQL08DVLP1T;
    }

    public String getNumAbaAbertaDVLP1T() {
        return numAbaAbertaDVLP1T;
    }

    public void setNumAbaAbertaDVLP1T(String numAbaAbertaDVLP1T) {
        this.numAbaAbertaDVLP1T = numAbaAbertaDVLP1T;
    }

    public String getMostraMensagemGeral1DVLP1T() {
        return mostraMensagemGeral1DVLP1T;
    }

    public void setMostraMensagemGeral1DVLP1T(String mostraMensagemGeral1DVLP1T) {
        this.mostraMensagemGeral1DVLP1T = mostraMensagemGeral1DVLP1T;
    }

    public String getMostraMensagemGeral2DVLP1T() {
        return mostraMensagemGeral2DVLP1T;
    }

    public void setMostraMensagemGeral2DVLP1T(String mostraMensagemGeral2DVLP1T) {
        this.mostraMensagemGeral2DVLP1T = mostraMensagemGeral2DVLP1T;
    }

    public String getMostraMensagemGeral3DVLP1T() {
        return mostraMensagemGeral3DVLP1T;
    }

    public void setMostraMensagemGeral3DVLP1T(String mostraMensagemGeral3DVLP1T) {
        this.mostraMensagemGeral3DVLP1T = mostraMensagemGeral3DVLP1T;
    }

    public String getViewBoxDVLP1T() {
        return viewBoxDVLP1T;
    }

    public void setViewBoxDVLP1T(String viewBoxDVLP1T) {
        this.viewBoxDVLP1T = viewBoxDVLP1T;
    }

    public String getViewBoxIIDVLP1T() {
        return viewBoxIIDVLP1T;
    }

    public void setViewBoxIIDVLP1T(String viewBoxIIDVLP1T) {
        this.viewBoxIIDVLP1T = viewBoxIIDVLP1T;
    }

    public String getViewBoxIIIDVLP1T() {
        return viewBoxIIIDVLP1T;
    }

    public void setViewBoxIIIDVLP1T(String viewBoxIIIDVLP1T) {
        this.viewBoxIIIDVLP1T = viewBoxIIIDVLP1T;
    }

    public boolean isHabilitaIDVLP1T() {
        return habilitaIDVLP1T;
    }

    public void setHabilitaIDVLP1T(boolean habilitaIDVLP1T) {
        this.habilitaIDVLP1T = habilitaIDVLP1T;
    }

    public boolean isHabilitaIIDVLP1T() {
        return habilitaIIDVLP1T;
    }

    public void setHabilitaIIDVLP1T(boolean habilitaIIDVLP1T) {
        this.habilitaIIDVLP1T = habilitaIIDVLP1T;
    }

    public boolean isHabilitaIIIDVLP1T() {
        return habilitaIIIDVLP1T;
    }

    public void setHabilitaIIIDVLP1T(boolean habilitaIIIDVLP1T) {
        this.habilitaIIIDVLP1T = habilitaIIIDVLP1T;
    }

    public boolean isHabilitaIVDVLP1T() {
        return habilitaIVDVLP1T;
    }

    public void setHabilitaIVDVLP1T(boolean habilitaIVDVLP1T) {
        this.habilitaIVDVLP1T = habilitaIVDVLP1T;
    }

    public boolean isHabilitaVDVLP1T() {
        return habilitaVDVLP1T;
    }

    public void setHabilitaVDVLP1T(boolean habilitaVDVLP1T) {
        this.habilitaVDVLP1T = habilitaVDVLP1T;
    }

    public boolean isHabilitaUserADVLP1T() {
        return habilitaUserADVLP1T;
    }

    public void setHabilitaUserADVLP1T(boolean habilitaUserADVLP1T) {
        this.habilitaUserADVLP1T = habilitaUserADVLP1T;
    }

    public boolean isHabilitaUserBDVLP1T() {
        return habilitaUserBDVLP1T;
    }

    public void setHabilitaUserBDVLP1T(boolean habilitaUserBDVLP1T) {
        this.habilitaUserBDVLP1T = habilitaUserBDVLP1T;
    }

    public UserDM getMediumUserModelDVLP1T() {
        return mediumUserModelDVLP1T;
    }

    public void setMediumUserModelDVLP1T(UserDM mediumUserModelDVLP1T) {
        this.mediumUserModelDVLP1T = mediumUserModelDVLP1T;
    }

    public UserDM getMediumUserModelIIDVLP1T() {
        return mediumUserModelIIDVLP1T;
    }

    public void setMediumUserModelIIDVLP1T(UserDM mediumUserModelIIDVLP1T) {
        this.mediumUserModelIIDVLP1T = mediumUserModelIIDVLP1T;
    }

    public User getSelectedUserModelDVLP1T() {
        return selectedUserModelDVLP1T;
    }

    public void setSelectedUserModelDVLP1T(User selectedUserModelDVLP1T) {
        this.selectedUserModelDVLP1T = selectedUserModelDVLP1T;
    }

    public String getNomeUserTalkDVLP1T() {
        return nomeUserTalkDVLP1T;
    }

    public void setNomeUserTalkDVLP1T(String nomeUserTalkDVLP1T) {
        this.nomeUserTalkDVLP1T = nomeUserTalkDVLP1T;
    }

    public ArrayList<User> getListaUsersDVLP1T() {
        return listaUsersDVLP1T;
    }

    public void setListaUsersDVLP1T(ArrayList<User> listaUsersDVLP1T) {
        this.listaUsersDVLP1T = listaUsersDVLP1T;
    }

    public String getMensagemValorDVLP1T() {
        return mensagemValorDVLP1T;
    }

    public void setMensagemValorDVLP1T(String mensagemValorDVLP1T) {
        this.mensagemValorDVLP1T = mensagemValorDVLP1T;
    }

    public String getMsgNotesVaziaDVLP1T() {
        return msgNotesVaziaDVLP1T;
    }

    public void setMsgNotesVaziaDVLP1T(String msgNotesVaziaDVLP1T) {
        this.msgNotesVaziaDVLP1T = msgNotesVaziaDVLP1T;
    }

    public String getMessageCommunicationDVLP1T() {
        return messageCommunicationDVLP1T;
    }

    public void setMessageCommunicationDVLP1T(String messageCommunicationDVLP1T) {
        this.messageCommunicationDVLP1T = messageCommunicationDVLP1T;
    }

    public String getMsgCommunicatioVaziaDVLP1T() {
        return msgCommunicatioVaziaDVLP1T;
    }

    public void setMsgCommunicatioVaziaDVLP1T(String msgCommunicatioVaziaDVLP1T) {
        this.msgCommunicatioVaziaDVLP1T = msgCommunicatioVaziaDVLP1T;
    }

    public Boolean isMostraPageViewIIDVLP1T() {
        return mostraPageViewIIDVLP1T;
    }

    public void setMostraPageViewIIDVLP1T(Boolean mostraPageViewIIDVLP1T) {
        this.mostraPageViewIIDVLP1T = mostraPageViewIIDVLP1T;
    }

    public List<AnrafelSQL06> getListAnrafelSQL06DVLP1T() {
        return listAnrafelSQL06DVLP1T;
    }

    public void setListAnrafelSQL06DVLP1T(List<AnrafelSQL06> listAnrafelSQL06DVLP1T) {
        this.listAnrafelSQL06DVLP1T = listAnrafelSQL06DVLP1T;
    }

    public String getMensagemEnviadaDVLP1T() {
        return mensagemEnviadaDVLP1T;
    }

    public void setMensagemEnviadaDVLP1T(String mensagemEnviadaDVLP1T) {
        this.mensagemEnviadaDVLP1T = mensagemEnviadaDVLP1T;
    }

    public String getNumAbaAbertaIIDVLP1T() {
        return numAbaAbertaIIDVLP1T;
    }

    public void setNumAbaAbertaIIDVLP1T(String numAbaAbertaIIDVLP1T) {
        this.numAbaAbertaIIDVLP1T = numAbaAbertaIIDVLP1T;
    }

    public ArrayList<AnrafelSQL01> getListAnrafelSQL01DVLP1T() {
        return listAnrafelSQL01DVLP1T;
    }

    public void setListAnrafelSQL01DVLP1T(ArrayList<AnrafelSQL01> listAnrafelSQL01DVLP1T) {
        this.listAnrafelSQL01DVLP1T = listAnrafelSQL01DVLP1T;
    }

    public ArrayList<AnrafelSQL02> getListAnrafelSQL02DVLP1T() {
        return listAnrafelSQL02DVLP1T;
    }

    public void setListAnrafelSQL02DVLP1T(ArrayList<AnrafelSQL02> listAnrafelSQL02DVLP1T) {
        this.listAnrafelSQL02DVLP1T = listAnrafelSQL02DVLP1T;
    }

    public ArrayList<AnrafelSQL03> getListAnrafelSQL03DVLP1T() {
        return listAnrafelSQL03DVLP1T;
    }

    public void setListAnrafelSQL03DVLP1T(ArrayList<AnrafelSQL03> listAnrafelSQL03DVLP1T) {
        this.listAnrafelSQL03DVLP1T = listAnrafelSQL03DVLP1T;
    }

    public ArrayList<AnrafelSQL04> getListAnrafelSQL04DVLP1T() {
        return listAnrafelSQL04DVLP1T;
    }

    public void setListAnrafelSQL04DVLP1T(ArrayList<AnrafelSQL04> listAnrafelSQL04DVLP1T) {
        this.listAnrafelSQL04DVLP1T = listAnrafelSQL04DVLP1T;
    }

    public ArrayList<AnrafelSQL05> getListAnrafelSQL05DVLP1T() {
        return listAnrafelSQL05DVLP1T;
    }

    public void setListAnrafelSQL05DVLP1T(ArrayList<AnrafelSQL05> listAnrafelSQL05DVLP1T) {
        this.listAnrafelSQL05DVLP1T = listAnrafelSQL05DVLP1T;
    }

    public int getIdRationaleSelectDVLP1T() {
        return idRationaleSelectDVLP1T;
    }

    public void setIdRationaleSelectDVLP1T(int idRationaleSelectDVLP1T) {
        this.idRationaleSelectDVLP1T = idRationaleSelectDVLP1T;
    }

    public String getSetaPageViewDVLP1T() {
        return setaPageViewDVLP1T;
    }

    public void setSetaPageViewDVLP1T(String setaPageViewDVLP1T) {
        this.setaPageViewDVLP1T = setaPageViewDVLP1T;
    }

    public ArrayList<AnrafelSQL10> getListAnrafelSQL10DVLP1T() {
        return listAnrafelSQL10DVLP1T;
    }

    public void setListAnrafelSQL10DVLP1T(ArrayList<AnrafelSQL10> listAnrafelSQL10DVLP1T) {
        this.listAnrafelSQL10DVLP1T = listAnrafelSQL10DVLP1T;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public ArrayList<AnrafelSQL11> getListAnrafelSQL11DVLP1() {
        return listAnrafelSQL11DVLP1;
    }

    public void setListAnrafelSQL11DVLP1(ArrayList<AnrafelSQL11> listAnrafelSQL11DVLP1) {
        this.listAnrafelSQL11DVLP1 = listAnrafelSQL11DVLP1;
    }

    public String getNameArtifactD() {
        return nameArtifactD;
    }

    public void setNameArtifactD(String nameArtifactD) {
        this.nameArtifactD = nameArtifactD;
    }

    public String getNameArtifactMapD() {
        return nameArtifactMapD;
    }

    public void setNameArtifactMapD(String nameArtifactMapD) {
        this.nameArtifactMapD = nameArtifactMapD;
    }

    public String getNameArtifactOntD() {
        return nameArtifactOntD;
    }

    public void setNameArtifactOntD(String nameArtifactOntD) {
        this.nameArtifactOntD = nameArtifactOntD;
    }

}//ultimo
