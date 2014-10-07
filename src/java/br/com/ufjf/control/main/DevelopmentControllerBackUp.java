package br.com.ufjf.control.main;

/**
 * Classe DevelopmentController
 *
 * @category control
 * @author magnus, anrafel, jonathan
 *
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;

import br.com.ufjf.Testes.owlapi.main.AlgorithmsTask;
import br.com.ufjf.Testes.owlapi.main.BuscaComentario;
import br.com.ufjf.Testes.owlapi.main.MainGabriellaII;
import br.com.ufjf.Testes.owlapi.main.MapTaskAlgorithm;
import br.com.ufjf.Testes.owlapi.main.QueryComment;
import br.com.ufjf.Testes.owlapi.main.TarefaAlgoritmo;
import br.com.ufjf.base.MetodoAuxiliar;
import br.com.ufjf.control.AlgorithmsTaskDM;
import br.com.ufjf.control.ArquivoIndexXML;
import br.com.ufjf.control.ArquivoIndexXMLDM;
import br.com.ufjf.control.ArtifactDM;
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
import br.com.ufjf.model.Algorithms;
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
import br.com.ufjf.model.Mapping;
import br.com.ufjf.model.MostrarRestricao;
import br.com.ufjf.model.No;
import br.com.ufjf.model.NosObrigatory;
import br.com.ufjf.model.SequenceAligningMapping;
import br.com.ufjf.model.ShowProcess;
import br.com.ufjf.model.featureide.Child;
import br.com.ufjf.model.featureide.Element;
import br.com.ufjf.model.featureide.Plm;
import br.com.ufjf.model.main.Artifact;
import br.com.ufjf.model.main.ArtifactsUsed;
import br.com.ufjf.model.main.Communication;
import br.com.ufjf.model.main.HowTable;
import br.com.ufjf.model.main.Rationale;
import br.com.ufjf.model.main.User;
import br.com.ufjf.model.main.WhatTable;
import br.com.ufjf.model.main.WhenTable;
import br.com.ufjf.model.main.WhereTable;
import br.com.ufjf.model.main.WhoTable;
import br.com.ufjf.model.resultsxml.Connection;
import br.com.ufjf.model.resultsxml.Parameter;
import br.com.ufjf.model.resultsxml.Process;
import br.com.ufjf.model.resultsxml.Workflow;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe DevelopmentController
 *
 * @category control
 * @author magnus, anrafel, jonathan
 *
 */
public class DevelopmentControllerBackUp implements Serializable {

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
    private String nameViewArtifact1;
    private String nameViewArtifact2;
    private String nameViewArtifact3;
    private List<Artifact> selectedArtifactZ;
    private Artifact selectedArtifactMapping;
    private Artifact selectedArtifactFeature;
    private Artifact selectedArtifactOntology;
    private String nameArtifactD;
    private String nameArtifactMapD;
    private String nameArtifactOntD;
    private int artefatoUsadoART;
    private int artefatoUsadoMAP;
    private int artefatoUsadoONT;
    private List<Artifact> artifactsArtD;
    private List<Artifact> artifactsMapD;
    private List<Artifact> artifactsOntD;
    private String product_name;
    private String product_purpose;
    private Plm raiz;
    private TreeNode root;
    private TreeNode selectedNode;
    private ArrayList<Mapping> mapping;
    private Mapping oneMapping;
    private StringBuilder sbd = new StringBuilder();
    private String returnOnto;
    private FacesContext facesContext;
    private String message;
    private ArrayList<MostrarRestricao> mostraRestricao;
    private Boolean mostraPageView;
    private Boolean mostraPageViewII;
    private String setaPageView;
    private int idRationaleSelect;
    private boolean habilitaMSG;
    private boolean habilitaMSGView1;
    private boolean habilitaMSGView2;
    private ArrayList<Communication> listCommunicationView;
    private ArrayList<AnrafelSQL01> listAnrafelSQL01;
    private ArrayList<AnrafelSQL02> listAnrafelSQL02;
    private ArrayList<AnrafelSQL03> listAnrafelSQL03;
    private ArrayList<AnrafelSQL04> listAnrafelSQL04;
    private ArrayList<AnrafelSQL05> listAnrafelSQL05;
    private List<AnrafelSQL06> listAnrafelSQL06;
    private int idUserContext;
    private String varSim;
    private String varNao;
    private String nomeImagem;
    private String numAbaAbertaII;
    private int controlaTempo;
    private int userSelecionado;
    private String mensagemEnviada;
    private ArtifactDM mediumArtifactModel;
    private String numAbaAberta;
    private ArrayList<User> listaUsers;
    private NosObrigatory nosObrigatory5;
    private ArrayList<NosObrigatory> ListnosObrigatorySelect;
    private ArrayList<ShowProcess> showProcess;
    private ArrayList<ShowProcess> preencheDB;
    private String showProcessview;
    private static ArrayList<Element> elements;
    private static ArrayList<TreeNode> nodes;
    private static final ArrayList<Element> pilha = new ArrayList<Element>();
    private static ArrayList<Element> mandatory;
    private ArrayList<BuscaComentario> retornaComentario;
    static ArrayList<BuscaComentario> comentarioOntologia;
    private int contadorY;
    private String tipoAplicacao;
    private boolean mostraPageViewAlgoritmo;
    private String setaPageViewAlgoritmos;
    private ArrayList<Algorithms> algorithmsList;
    private boolean mostraalgoritmo;
    private String selectedArtifactAlgorithm;
    private AlgorithmsTask algoritmsSelect;
    private ArrayList<AlgorithmsTask> listAlgoritms;
    private ArrayList<MapTaskAlgorithm> listMapTaskAlgorithm;
    private String algoritmoBusca;
    private ArrayList<AlgorithmsTask> listSelectAlgorithmForXML;
    private AlgorithmsTaskDM algorithmsTaskDM;
    private List<SelectItem> listaSelectItemview;
    private String campoSelecONeMenuSelecionado;
    private String urlXML;
    private StreamedContent file;
    private String urldeGravacao;
    ArrayList<ArquivoIndexXML> mostraIndexXml;
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
    private ArrayList<AnrafelSQL07_1> listAnrafelSQL07_1;
    private ArrayList<AnrafelSQL07_2> listAnrafelSQL07_2;
    private ArrayList<AnrafelSQL07_3> listAnrafelSQL07_3;
    private ArrayList<Artifact> listaArtifacts;
    private Artifact selectedArtifact;
    private ArrayList<AnrafelSQL07> listAnrafelSQL07;
    private ArrayList<AnrafelSQL08> listAnrafelSQL08;
    private String artiName;
    private String artiPurpose;
    private String mensagemValor;
    private int idUltimoRatinaleGravdo;
    private String msgNotesVazia;
    private String messageCommunication;
    private String msgCommunicatioVazia;
    private  ArrayList<AnrafelSQL09> users;
    private String sparqlfield;
    private String fieldTerms;


    /* METODO CONSTRUTOR */
    public DevelopmentControllerBackUp() {

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
        this.mostraRestricao = new ArrayList<MostrarRestricao>();
        this.selectedArtifactZ = new ArrayList<Artifact>();
        this.mostraRestricao = new ArrayList<MostrarRestricao>();
        this.selectedArtifactMapping = new Artifact();
        this.selectedArtifactFeature = new Artifact();
        this.selectedArtifactOntology = new Artifact();
        this.mapping = new ArrayList<Mapping>();
        this.listCommunicationView = new ArrayList<Communication>();
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
        this.listAnrafelSQL06.clear();
        this.listaUsers = new ArrayList<User>();
        this.ListnosObrigatorySelect = new ArrayList<NosObrigatory>();
        this.showProcess = new ArrayList<ShowProcess>();
        this.retornaComentario = new ArrayList<BuscaComentario>();
        DevelopmentControllerBackUp.comentarioOntologia = new ArrayList<BuscaComentario>();
        this.contadorY = 0;
        this.mostraPageViewAlgoritmo = false;
        this.algorithmsList = new ArrayList<Algorithms>();
        this.mostraalgoritmo = true;
        this.listMapTaskAlgorithm = new ArrayList<MapTaskAlgorithm>();
        this.algoritmoBusca = "";
        this.listSelectAlgorithmForXML = new ArrayList<AlgorithmsTask>();
        this.preencheDB = new ArrayList<ShowProcess>();
        this.mostraIndexXml = new ArrayList<ArquivoIndexXML>();
        this.arquivoIndexXMLSelecionado = new ArquivoIndexXML();
        this.mostraDownloadXML = false;
        this.urldeGravacao = "/PL-Science/backup/";
      
        this.msgNotesVazia = "";
        this.messageCommunication = "";
        this.msgCommunicatioVazia = "";
        this.users = new ArrayList<AnrafelSQL09>();
        
    }

    /* CONFERE OS ARTEFATOS SELECIONADOS SELECIONADO */
    /*
     * (non-Javadoc)
     * 
     * @see br.com.ufjf.control.main.ukj#startDevelopmentIID()
     */
    public String startDevelopmentIID() {
        String retorna = null;

        if (selectedArtifactZ == null) {
            nameViewArtifact1 = "Please select 3 artifacts";
            // //System.out.println("PRIMEIRO-CASO:-selectedArtifactZ = null");
            retorna = null;
        } else if (selectedArtifactZ != null) {
            int val = selectedArtifactZ.size();
            if (val == 1) {
                // //System.out.println("SEGUNDO-CASO:-selectedArtifactZ = "+
                // selectedArtifactZ.size());
                nameViewArtifact1 = "Please select 3 artifact! You selected only 1 artifacts";
                retorna = null;
            } else if (val == 2) {
                // //System.out.println("TERCEIRO-CASO:-selectedArtifactZ = " +
                // selectedArtifactZ.size());
                nameViewArtifact1 = "Please select 3 artifact! You selected only 2 artifacts";
                retorna = null;
            } else if (val == 3) {
                Artifact d1;
                d1 = selectedArtifactZ.get(0);
                String art1 = d1.getType();

                Artifact d2;
                d2 = selectedArtifactZ.get(1);
                String art2 = d2.getType();

                Artifact d3;
                d3 = selectedArtifactZ.get(2);
                String art3 = d3.getType();

                if (art1.equals(art2)) {
                    retorna = null;
                    selectedArtifactZ.clear();
                    nameViewArtifact1 = "Select only one of each: FeatureModel, MappingFile and Ontology: You selected two: "
                            + art1;

                } else if (art2.equals(art3)) {
                    retorna = null;
                    selectedArtifactZ.clear();
                    nameViewArtifact1 = "Select only one of each: FeatureModel, MappingFile and Ontology: You selected two: "
                            + art2;
                } else if (art3.equals(art1)) {
                    retorna = null;

                    nameViewArtifact1 = "Select only one of each: FeatureModel, MappingFile and Ontology You selected two: "
                            + art3;
                } else {

                    retorna = "definePage10ViewFeatureNameProduct";
                }

            }
        }

        return retorna;
    }

    /* AÃ‡ÃƒO DO BOTAO SELECIONAR UM TIPO DE ARTIFACT MODELO */
    /*
     * (non-Javadoc)
     * 
     * @see br.com.ufjf.control.main.ukj#recebeArtifactArtD()
     */
    public String recebeArtifactArtD() {
        nameArtifactD = " ";
        // Pega o parÃ¢metro via request.
        String id = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("idArtifact");

        int s = Integer.parseInt(id);

        Artifact x;
        artefatoUsadoART = s;
        String query = "SELECT a FROM Artifact a WHERE a.idArtifact =" + s;
        x = (Artifact) artifactDao.Pesq(query);

        nameArtifactD = x.getName();

        selectedArtifactZ.add(x);
        return null;
    }

    /* AÃ‡ÃƒO DO BOTAO SELECIONAR UM TIPO DE ARTIFACT MAPEAMENTO */
    /*
     * (non-Javadoc)
     * 
     * @see br.com.ufjf.control.main.ukj#recebeArtifactMapD()
     */
    public String recebeArtifactMapD() {
        nameArtifactMapD = " ";
        // Pega o parÃ¢metro via request.
        String id = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("idArtifact");

        int s = Integer.parseInt(id);

        artefatoUsadoMAP = s;
        Artifact x2;

        String query = "SELECT a FROM Artifact a WHERE a.idArtifact =" + s;
        x2 = (Artifact) artifactDao.Pesq(query);

        nameArtifactMapD = x2.getName();
        selectedArtifactZ.add(x2);
        return null;
    }

    /* AÃ‡ÃƒO DO BOTAO SELECIONAR UM TIPO DE ARTIFACT MAPEAMENTO */
    /*
     * (non-Javadoc)
     * 
     * @see br.com.ufjf.control.main.ukj#recebeArtifactOntD()
     */
    public String recebeArtifactOntD() {
        nameArtifactOntD = " ";

        // Pega o parÃ¢metro via request.
        String id = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("idArtifact");

        int s = Integer.parseInt(id);
        artefatoUsadoONT = s;
        Artifact x3;

        String query = "SELECT a FROM Artifact a WHERE a.idArtifact =" + s;
        x3 = (Artifact) artifactDao.Pesq(query);

        nameArtifactOntD = x3.getName();
        selectedArtifactZ.add(x3);
        return null;
    }

    /*
     * BOTÃƒO CONTINUE DO DESENVOLVIMENTO SERÃ� NECESSÃ�RIO GRAVAR TODOs O
     * RATIONALE
     */
    /*
     * (non-Javadoc)
     * 
     * @see br.com.ufjf.control.main.ukj#viewFeatureReader()
     */
    public String viewFeatureReader() {
        numAbaAberta = "0";
        // PEGANDO O IDUSER DA SESSÃƒO LÃ� DO LOGIN
        facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session1 = request.getSession();
        User u;
        u = (User) session1.getAttribute("currentUser");
        // pegando o iduser da sessÃ£o

        int idUser = u.getIdScientist();
        // instanciando who (quem!)
        WhoTable w = new WhoTable();
        // set iduser
        w.setIdScientist(idUser);
        // salvando who
        WhoDao.salvar(w);
        ////System.out.println("AQUI-EU-SALVEI-1--WHO--(quem!)!!");

        // obtendo a data de hoje por inteiros com calendar
        // instanciando o date para obter a data de hoje
        Date hoje = new Date();
        // instanciando calendar
        Calendar cal = Calendar.getInstance();
        // setando hoje em calendar
        cal.setTime(hoje);
        // obtendo inteiro do dia
        int dia1 = cal.get(Calendar.DATE);
        // obtendo inteiro do ano
        int ano1 = cal.get(Calendar.YEAR);
        // obtendo inteiro do mes
        int mes1 = cal.get(Calendar.MONTH) + 1;
        // obtendo inteiro da hora
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        // obtendo inteiro do minutos
        int minuto = cal.get(Calendar.MINUTE);
        // instanciando when (quando!)
        WhenTable when = new WhenTable();
        // preenchendo when
        when.setDay(dia1);
        when.setMonth(mes1);
        when.setYear(ano1);
        when.setTime(hora);
        when.setMinute(minuto);
        // salvando when
        WhenDao.salvar(when);
        // //System.out.println(dia1);
        // //System.out.println(mes1);
       // //System.out.println("AQUI-EU-SALVEI-1--WHEN--!!");

        // instanciando how (como!)
        HowTable how = new HowTable();
        /*
         * serÃ¡ preenchido mais tarde. agora sÃ³ necessito salvar para obter o
         * idHow
         */
        // salvando how
        howDao.salvar(how);
       // //System.out.println("AQUI-EU-SALVEI-1--HOW--(como!)!!");

        // instanciando o What (o que!)
        WhatTable what = new WhatTable();
        // preenchendo o What
        what.setDescription("PRODUCT DEVELOPMENT");
        what.setProductName(product_name);
        what.setPurposeProduct(product_purpose);
        // salvando o What
        whatDao.salvar(what);
        ////System.out.println("AQUI-EU-SALVEI-1--WHAT--(o que!)!!");

        // instanciando o where (onde!)
        WhereTable where1 = new WhereTable();
        // sÃ³ tem o seu proprio id
        where1Dao.salvar(where1);
        ////System.out.println("AQUI-EU-SALVEI-1--WHERE1--(onde!)!!");

       
        ////System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-xGRAVANDO RATIONALE-x-x-x-x-x-x-x-xx-x-x-x-x-x-x-x");
        // instanciando um rationale
        Rationale rtn = new Rationale();
        // setando id do who
        String url22 = "SELECT A.`idWho` FROM `WhoTable` A ORDER BY A.`idWho` DESC LIMIT 1";
        String resp22 = "idWho";
        int IDWHO = JDBCController.buscaUltimoGravado(url22, resp22);
        ////System.out.println("GRAVANDO RATIONALE::IDWHO "+IDWHO);
        rtn.setIdWho(IDWHO + 1);
        // setando id do where
        String url11 = "SELECT A.`idWhere` FROM `WhereTable` A ORDER BY A.`idWhere` DESC LIMIT 1";
        String resp11 = "idWhere";
        int IDWHERE;
        IDWHERE = JDBCController.buscaUltimoGravado(url11, resp11);
         ////System.out.println("GRAVANDO RATIONALE::IDWHERE "+IDWHERE);
        rtn.setIdWhere(IDWHERE + 1);
        // setando id do when
        String url33 = "SELECT A.`idWhen` FROM `WhenTable` A ORDER BY A.`idWhen` DESC LIMIT 1";
        String resp33 = "idWhen";
        int IDWHEN = JDBCController.buscaUltimoGravado(url33, resp33);
       // //System.out.println("GRAVANDO RATIONALE::IDWHEN "+IDWHEN);
        rtn.setIdWhen(IDWHEN + 1);
        // setando id do what
        String url44 = "SELECT A.`idWhat` FROM `WhatTable` A ORDER BY A.`idWhat` DESC LIMIT 1";
        String resp44 = "idWhat";
        int IDWHAT = JDBCController.buscaUltimoGravado(url44, resp44);
        ////System.out.println("GRAVANDO RATIONALE::IDWHAT "+IDWHAT);
        rtn.setIdWhat(IDWHAT + 1);      
        // setando id do how
        String url55 = "SELECT A.`idHow` FROM `HowTable` A ORDER BY A.`idHow` DESC LIMIT 1";
        String resp55 = "idHow";
        int IDHOW = JDBCController.buscaUltimoGravado(url55, resp55);
        ////System.out.println("GRAVANDO RATIONALE::IDHOW "+IDHOW);
        rtn.setIdHow(IDHOW + 1);
        // salvando rationale
        rationaleDao.salvar(rtn);
       // //System.out.println("AQUI-EU-SALVEI-O--RATIONALE-01--!!");

         /*pegando o ultimo id do rational gravado*/
        String url555 = "SELECT A.`idRationale` FROM `Rationale` A ORDER BY A.`idRationale` DESC LIMIT 1";
        String respl555 = "idRationale";
        idUltimoRatinaleGravdo = JDBCController.buscaUltimoGravado(url555, respl555);
       
         ////System.out.println("GRAVANDO RATIONALE::idUltimoRatinaleGravdo "+idUltimoRatinaleGravdo);
         /*
         * persistindo os tres artefatos usados artefato, mapeamento, ontologia
         */
        // instanciando o primeiro dos artefatos usados
        ArtifactsUsed afu1 = new ArtifactsUsed();
        afu1.setIdArtifact(artefatoUsadoART);
        // Ã© necessario id do where consulto o ultimo gravado
        @SuppressWarnings("unused")
        JDBCController jdbc = new JDBCController();       
        afu1.setIdRationale(idUltimoRatinaleGravdo +1);     
        afu1.setIdWhere(IDWHERE +1);
        // salvando o primeiro dos artefatos
        artifactUsedDao.salvar(afu1);
        ////System.out.println("AQUI-EU-SALVEI-O--ARTIFACTUSED-01--!!");

        // instanciando o segundo dos artefatos usados
        ArtifactsUsed afu2 = new ArtifactsUsed();
        afu2.setIdArtifact(artefatoUsadoMAP);
        // Ã© necessario id do where
        afu2.setIdRationale(idUltimoRatinaleGravdo +1);  
        afu2.setIdWhere(IDWHERE + 1);
        // salvando o segundo dos artefatos usados
        artifactUsedDao.salvar(afu2);
        ////System.out.println("AQUI-EU-SALVEI-O--ARTIFACTUSED-02--!!");

        // instanciando o terceiro dos artefatos usados
        ArtifactsUsed afu3 = new ArtifactsUsed();
        afu3.setIdArtifact(artefatoUsadoONT);
        // Ã© necessario id do where
        afu3.setIdRationale(idUltimoRatinaleGravdo + 1);
        afu3.setIdWhere(IDWHERE + 1);
        // salvando o terceiro dos artefatos usados
        artifactUsedDao.salvar(afu3);
       // //System.out.println("AQUI-EU-SALVEI-O--ARTIFACTUSED-03--!!");
        
        
        
        
        
        
        
        
       
       

        FeatureWizard();
        loadMapping();
        retornaComentario = QueryComment.buscaComentarios();

       /* for (BuscaComentario bc : retornaComentario) {
            //System.out.println("-x-x-x-x-x-x-x-in-x-x-x-x-x-x-x-x");
            //System.out.println("Nome: " + bc.getChaveClasseReferencia());
            //System.out.println("Algoritmo: " + bc.getAlgoritmo());
            //System.out.println("-x-x-x-x-x-x-x-out-x-x-x-x-x-x-x-x");
            //System.out.println("");
        }*/
        artifactManager();
        
       
        
        return "definePage10ViewFeatureRead";
    }

    /*
     * MONTANDO ARVORE DE FEATURE public void FeatureWizard() { String urlFull =
     * "/PL-Science/backup/SequenceAlign.xml"; // Raiz do Tipo NO - Primeira
     * Feature do Modelo raiz = (No) unmarshalFromFile(No.class, urlFull); //
     * Root - Elemento de visualizaï¿½ï¿½o da Tree no PrimeFaces root = new
     * DefaultTreeNode(raiz.getNome(), null); root.setExpanded(true);
     * imprimeArvore(raiz, root); }
     */

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ufjf.control.main.ukj#FeatureWizard()
     */
    public void FeatureWizard() {

        String URL_BD = getArtifactTrue("FeatureModel");

        // String urlFullWin =
        // "C:\\Users\\Jonathan\\Documents\\resources\\model.xml";
        // String urlFullLix = "/PL-Science/backup/model.xml";
        // Raiz do Tipo NO - Primeira Feature do Modelo
        raiz = (Plm) unmarshalFromFile(Plm.class, URL_BD);

        // Root - Elemento de visualizacao da Tree no PrimeFaces
        root = new DefaultTreeNode(raiz.getName(), null);
        root.setExpanded(true);
        generateTree(raiz, root);
        ArrayList<Element> root_childs = getFilho("root");
        mandatory = getMandatorio(root_childs);

        ShowProcess asd = new ShowProcess();
        asd.setNomeShowProcess(raiz.getName());
        preencheDB.add(asd);

        generateFirstStep();

    }

    /* pegando os elementos filhos da raiz */
    /*
     * (non-Javadoc)
     * 
     * @see br.com.ufjf.control.main.ukj#getObrigatorio()
     */
    public void getObrigatorio() {// | c3.getOptional() == false
        ArrayList<NosObrigatory> ListNosObrigatory = new ArrayList<NosObrigatory>();
        ArrayList<NosObrigatory> ListFilhosObrigatorios = new ArrayList<NosObrigatory>();
        ArrayList<Element> teste = raiz.getElement();
        for (Iterator<Element> it = teste.iterator(); it.hasNext();) {
            Element c3 = it.next();
            if (c3.getParentElement() == null) {
                NosObrigatory nosObrigatory = new NosObrigatory();
                nosObrigatory.setId(c3.getId());
                nosObrigatory.setNome(c3.getName());
                nosObrigatory.setOpcional(c3.getOptional());
                if (c3.getParentElement() != null) {
                    nosObrigatory.setPai(c3.getParentElement().getId());
                }
                ListNosObrigatory.add(nosObrigatory);

            }

        }

        for (Iterator<NosObrigatory> it2 = ListNosObrigatory.iterator(); it2
                .hasNext();) {
            NosObrigatory nosObrigatory2;
            nosObrigatory2 = it2.next();
            if (nosObrigatory2.isOpcional() == false) {
                NosObrigatory nosObrigatory4 = new NosObrigatory();
                nosObrigatory4.setId(nosObrigatory2.getId());
                nosObrigatory4.setNome(nosObrigatory2.getNome());
                ListFilhosObrigatorios.add(nosObrigatory4);
            }
        }

        // so imprime
        for (Iterator<NosObrigatory> it3 = ListNosObrigatory.iterator(); it3
                .hasNext();) {
            NosObrigatory nosObrigatory3;
            nosObrigatory3 = it3.next();
           // //System.out.println("OS FILHOS DA RAIZ: " + nosObrigatory3.getNome());
        }

        for (Iterator<NosObrigatory> it5 = ListFilhosObrigatorios.iterator(); it5
                .hasNext();) {
            nosObrigatory5 = new NosObrigatory();
            nosObrigatory5 = it5.next();
            ////System.out.println("OS DA RAIZ OBRIGATORIOS: "+ nosObrigatory5.getNome());
            ListnosObrigatorySelect.add(nosObrigatory5);
        }
        returnOnto = "Choose one of the Child of < "
                + ListnosObrigatorySelect.get(0).getNome() + " >";
    }

    public boolean generateStep(TreeNode node) {

        boolean fleg = false;

        Element element = new Element();
        boolean flag = false;
        int i = 0;

        // Procura no array de elementos o Element que corresponde ao TreeNode
        // selecionado
        while (!flag) {
            element = elements.get(i);
            if (node.toString().equals(element.getName())) {
                flag = true;
            }
            i += 1;
        }

        // Se o elemento selecionado for mandatory E tiver filhos o mesmo será
        // expandido
        if (element.getOptional() == false
                && element.getChildElements().size() > 0) {
            node.setExpanded(true);
            returnOnto = "Select a child of < " + node.toString() + " >";
        } // Se não, será expandido o próximo elemento da lista de mandatórios
        else {
            if (mandatory.size() > 0) {
                element = mandatory.get(0);
                openTreeNode(element.getName());

                ShowProcess sp = new ShowProcess();
                sp.setNomeShowProcess(element.getName());
                sp.setAlgoritmsSN("N");
                showProcess.add(sp);
                preencheDB.add(sp);

                returnOnto = "Select a child of < " + element.getName() + " >";
                mandatory.remove(0);
            } else {

                // returnOnto = "AGORA É COM A ONTOLOGIA MANÉ!!";
                returnOnto = "";
                BuscaComentario gx;
                gx = generateStepOnto();
                String vx = gx.getPaiProximo();

                if ((gx.getTarefa().equals("%"))
                        & (tipoAplicacao.equals("isolated_application"))) {
                    ////System.out.println("To passando aqui tambem Primeiro1");
                    fleg = true;

                } else if (gx.getFinaliza().equals("@")) {
                    ////System.out.println("To passando aqui tambem Primeiro2");
                    fleg = true;

                }/*
                 * else if (tipoAplicacao.equals("isolated_application")) {
                 * //System.out.println("To passando aqui tambem Primeiro3"); fleg
                 * = true; }
                 */

                ShowProcess sp = new ShowProcess();
                sp.setNomeShowProcess(vx);
                sp.setAlgoritmsSN("N");
                Boolean flag1 = true;

                // Verifica se já existe process com o nome a ser adicionado
                // Colocar isto em todas as inserções no array showProcess
                for (int j = 0; j < showProcess.size(); j++) {
                    ShowProcess elementsp = showProcess.get(j);
                    if (elementsp.getNomeShowProcess().equals(vx)) {
                        flag1 = false;
                    }
                }

                if (flag1) {
                    showProcess.add(sp);
                    preencheDB.add(sp);
                }

                openTreeNode(vx);
            }
        }

        return fleg;
    }

    /**
     * METODO: retornaMsg possibilitar mostrar mensagens diferentes
     *
     * @return
     */
    public BuscaComentario generateStepOnto() {

        returnOnto = "";
        BuscaComentario BC;
        // Procura no array de elementos o Element que corresponde ao TreeNode
        // selecionado

        BC = comentarioOntologia.get(0);

        returnOnto = BC.getValorComment();
        comentarioOntologia.remove(0);

        /*
         * for (int i = 0; i < comentarioOntologia.size(); i++) {
         * BuscaComentario teste = comentarioOntologia.get(i);
         * 
         * //System.out.println("INDICE: " + i);
         * //System.out.println("COMENTARIOS: " + teste.getValorComment());
         * //System.out.println("CLASSE-REFERENCIA: " +
         * teste.getChaveClasseReferencia()); //System.out.println(""); }
         */
        return BC;
    }

    /**
     * METODO: dado um arrayList, retornar um ArrayList<Element> de mandatorios
     *
     * @param elementos
     * @return
     */
    public ArrayList<Element> getMandatorio(ArrayList<Element> elementos) {

        ArrayList<Element> mandatorios = new ArrayList<Element>();

        for (int i = 0; i < elementos.size(); i++) {
            Element elemento = elementos.get(i);
            if (elemento.getOptional() == false) {
                mandatorios.add(elemento);
            }
        }

        return mandatorios;
    }

    /**
     * METODO que retorna os filhos de um determinado NO
     *
     *
     * @param node
     * @return
     */
    public ArrayList<Element> getFilho(String node) {

        ArrayList<Element> resultado = new ArrayList<Element>();

        // Se for passado "root" como parÃ¢metro, irÃ¡ retornar os filhos da
        // raiz
        if (node.equals("root")) {
            for (int i = 0; i < elements.size(); i++) {
                Element elemento = elements.get(i);
                if (elemento.getParentElement() == null) {
                    resultado.add(elemento);
                }
            }
            return resultado;
        }

        int i = 0;
        int flag = 0;

        Element elemento = new Element();

        // Encontrar o elemento com nome = node.nome
        while (flag == 0 && i < elements.size()) {
            String nome = elements.get(i).getName();
            ////System.out.println(nome + "-" + node);

            if (nome.equals(node)) {
                flag = 1;
                elemento = elements.get(i);
            }

            i++;
        }

        ArrayList<Child> filhos = elemento.getChildElements();

        // adicionar os filhos do elemento ao vetor de resultado
        if (filhos.isEmpty()) {
            return null;
        }

        for (int j = 0; j < filhos.size(); j++) {
            int id = filhos.get(j).getId();
            id -= 2;
            resultado.add(elements.get(id));
        }

        return resultado;
    }

    /**
     * Metodo gera o primeiro passo
     */
    public void generateFirstStep() {

        /*
         * Adiciona na pilha o primeiro elemento mandatório e o remove da lista
         * de mandatórios
         */
        pilha.add(mandatory.get(0));
        mandatory.remove(0);

        /* Pega o elemento no final da pilha */
        int fim_pilha = pilha.size();
        fim_pilha -= 1;
        Element elemento = pilha.get(fim_pilha);

        ShowProcess sp = new ShowProcess();
        sp.setNomeShowProcess(elemento.getName());
        sp.setAlgoritmsSN("N");
        showProcess.add(sp);
        preencheDB.add(sp);

        returnOnto = "Choose a child of < " + elemento.getName() + " >";

        openTreeNode(elemento.getName());

    }

    /**
     * abre a arvore de Node
     *
     * @param elemento
     */
    @SuppressWarnings("empty-statement")
    public void openTreeNode(String elemento) {

        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).setExpanded(false);
            if (nodes.get(i).toString().equals(elemento)) {
                nodes.get(i).setExpanded(true);
            }
            ;

        }
    }

    /**
     * Monta a arvore de visualização Tree Node
     *
     * @param no
     * @param root
     */
    public static void generateTree(Plm no, TreeNode root) {
        // ArrayList de Elementos do XML
        elements = no.getElement();
        // ArrayList de TreeNodes do PrimeFaces
        nodes = new ArrayList<TreeNode>();

        // Variaveis locais
        TreeNode node;
        int id;

        // Percorre o array de elementos
        for (id = 0; id < elements.size(); id++) {

            // Pega o elemento no id
            Element element = elements.get(id);

            // se o elemento nao tiver pai, a raiz Ã© seu pai
            if (element.getParentElement() == null) {
                node = new DefaultTreeNode(element.getName(), root);
            } // se o elemento tiver pai, buscamos o mesmo no array de TreeNodes
            else {
                node = new DefaultTreeNode(element.getName(), nodes.get(element
                        .getParentElement().getId()));
            }

            nodes.add(node);
        }
    }

    /* LENDO O ARQUIVO DE MAPEAMENTO ORIUNDO DO FEATURE-IDE */
    /*
     * (non-Javadoc)
     * 
     * @see br.com.ufjf.control.main.ukj#loadMapping()
     */
    public void loadMapping() {
        String lugar = getArtifactTrue("MappingFile");

        SequenceAligningMapping teste = (SequenceAligningMapping) unmarshalFromFile(
                SequenceAligningMapping.class, lugar);
        mapping = new ArrayList<Mapping>();
        mapping = teste.getMapping();

    }

    /**
     * ESSE METODO BUSCA NO ARTEFATO SELECIONADO LOCAL OU A URL QUE ELE SE
     * ENCONTRA SE FOR LOCAL OK SE NAO EU CRIO UM ARQUIVO LOCAL PARA USO DOS
     * MEUS METODOS
     */
    private String getArtifactTrue(String typeArtifact) {
        String local = null;
        String arq;
        ////System.out.println("QUAL O SYSTEM OPERATION: "+ System.getProperty("os.name"));
        /* VERIFICO EM QUAL SYSTEMA OPERAÃ‡IONAL ESTOU */
        if (System.getProperty("os.name").equals("Linux")) {
            if (typeArtifact.equals("Ontology")) {
                arq = "/PL-Science/backup/onTime" + typeArtifact + ".owl";
            } else {
                arq = "/PL-Science/backup/onTime" + typeArtifact + ".xml";
            }
        } else {
            if (typeArtifact.equals("Ontology")) {
                arq = "C://PL-Science/backup/onTime" + typeArtifact + ".owl";
            } else {
                arq = "C://PL-Science/backup/onTime" + typeArtifact + ".xml";
            }
        }

        //("(METODO: getArtifactTrue)-STRING-MONTADA: " + arq);
        char artifacttapy;
        Iterator<Artifact> it = selectedArtifactZ.iterator();
        while (it.hasNext()) {
            Artifact atf;
            atf = it.next();
            ////System.out.println("O TIPO DE ARTEFATO: " + atf.getType());
            if (atf.getType().equals(typeArtifact)) {
                artifacttapy = atf.getArtifactType();
                String artifacttapyII = String.valueOf(artifacttapy);
                if (artifacttapyII.equals("W")) {
                    String urlSub = atf.getLocal();
                    MetodoAuxiliar.submeterUrl(urlSub, arq);
                    local = arq;
                } else {
                    local = atf.getLocal();
                }
            }
        }
       // //System.out.println("(METODO: getArtifactTrue)-LOCAL-OU-URL: " + local);
        return local;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ufjf.control.main.ukj#marshal(java.lang.Object)
     */
    public String marshal(Object object) {
        final StringWriter out = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.marshal(object, new StreamResult(out));
        } catch (PropertyException e) {
            // e.printStackTrace();
        } catch (JAXBException e) {
            // e.printStackTrace();
        }
        return out.toString();
    }

    /**
     * Converte o objeto em uma estrutura XML. grava em arquivo
     *
     * @param object objeto a ser convertido em XML.
     * @param fileName nome do arquivo XML a ser gerado.
     * @return uma string com o conteudo do XML gerado.
     */
    @SuppressWarnings("finally")
    public static String marshalToFile(Object object, String fileName) {
        final StringWriter out = new StringWriter();
        Writer writer = null;
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.marshal(object, new StreamResult(out));

            writer = new FileWriter(fileName);
            marshaller.marshal(object, writer);
        } catch (PropertyException e) {
            // e.printStackTrace();
        } catch (JAXBException e) {
            // e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(DevelopmentControllerBackUp.class.getName()).log(Level.SEVERE, null,
                    ex);

        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
        return out.toString();
    }

    /**
     * Converte o objeto em uma estrutura XML. grava em arquivo
     *
     * @param object objeto a ser convertido em XML.
     * @param fileName nome do arquivo XML a ser gerado.
     * @return uma string com o conteudo do XML gerado.
     */
    @SuppressWarnings("finally")
    public static String marshalToFileII(Object object, String fileName) {
        final StringWriter out = new StringWriter();
        Writer writer = null;
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.marshal(object, new StreamResult(out));

            writer = new FileWriter(fileName);
            marshaller.marshal(object, writer);
        } catch (PropertyException e) {
            // e.printStackTrace();
        } catch (JAXBException e) {
            // e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(DevelopmentControllerBackUp.class.getName()).log(Level.SEVERE, null,
                    ex);

        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
        return out.toString();
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

    /* IMPRIME ARVORE MAPEAMENTO DE FEATURES */
    @SuppressWarnings("empty-statement")
    public static void imprimeArvore(No no, TreeNode root) {

        if (no == null) {
            ;
        } else {
            for (int i = 0; i < no.getFilhos().size(); i++) {
                TreeNode node0 = new DefaultTreeNode(no.getFilhos().get(i)
                        .getNome(), root);
                if (no.getFilhos().get(i).getFilhos() != null) {
                    imprimeArvore(no.getFilhos().get(i), node0);
                }
            }
        }
    }

    /* CONTINUIDADE AO ARTEFATOS SELECIONADOS */
    /*
     * (non-Javadoc)
     * 
     * @see br.com.ufjf.control.main.ukj#select()
     */
    /* BOTAO DE SELEÃ‡ÃƒO DO ARTEFATO */
    public void select() {
        // String viewID = null;
        // ArrayList<ShowProcess> -> showProcess /String->showProcessview

        returnOnto = "";
        String noSelecionado = String.valueOf(selectedNode);
        ShowProcess sp = new ShowProcess();
        sp.setNomeShowProcess(noSelecionado);
        BuscaComentario retorna;
        retorna = getBuscaComent(noSelecionado);
        String n = retorna.getAlgoritmo();
        ////System.out.println("_A_L_G_O_R_I_T_M_O_: " + n);
        sp.setAlgoritmsSN(n);
        showProcess.add(sp);
        preencheDB.add(sp);

        if ((noSelecionado.equals("workflow"))
                | (noSelecionado.equals("isolated_application"))) {
            tipoAplicacao = noSelecionado;
           // //System.out.println("tipoAplicacao---tipoAplicacao: "+ tipoAplicacao);
        }

        // Busca Ontológica Funcionando
        // String selecioAlgo = selectedNode.getData().toString();
        // ConsultaOWLRestricao CR = new ConsultaOWLRestricao();
        Iterator<Mapping> it = mapping.iterator();
        while (it.hasNext()) {
            Mapping c3;
            c3 = it.next();
            if (c3.getFeatureName().equals(noSelecionado)) {

                ////System.out.println("***************************");
                ////System.out.println("noSelecionado: " + noSelecionado);
               // //System.out.println("mapeamento: " + c3.getFeatureName());
                ////System.out.println("***************************");

                Iterator<BuscaComentario> it2 = retornaComentario.iterator();
                while (it2.hasNext()) {
                    BuscaComentario k;
                    k = it2.next();
                    // //System.out.println("k.getChaveClasseReferencia(): "
                    // + k.getChaveClasseReferencia());
                    if (k.getChaveClasseReferencia().equals(noSelecionado)) {

                        // //System.out.println("COMENTARIO: " +
                        // k.getValorComment());
                        // //System.out.println("k.getCommentSN() "
                        // + k.getCommentSN());
                        if (k.getCommentSN() != null) // Gambiarra, ver o caso
                        // dos NULL
                        {
                            if (k.getCommentSN().equals("#")) {
                                comentarioOntologia.add(k);
                            }
                        }

                    }
                }
                boolean bca = false;
                bca = generateStep(selectedNode);

                if (bca == true) {
                    mostraalgoritmo = false;
                    mostraPageViewAlgoritmo = true;
                    setaPageViewAlgoritmos = "definePage10ViewFeatureAlgoritmo.xhtml";
                    getSelectFeature();
                }

                StringBuilder nameView1 = new StringBuilder();
                nameView1.append(raiz.getName().toUpperCase());
                nameView1.append(" >>> ");

                for (ShowProcess mr : showProcess) {
                    String nomeShowProcess = mr.getNomeShowProcess()
                            .toUpperCase();
                    nameView1.append(nomeShowProcess);
                    nameView1.append(" >>> ");
                }
                showProcessview = nameView1.toString();
                System.out
                        .println("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-showProcessview--x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x- :"
                                + showProcessview);
            }
        }

    }

    public BuscaComentario getBuscaComent(String nomeDoProcesso) {
        BuscaComentario retorna = new BuscaComentario();
        for (int j = 0; j < retornaComentario.size(); j++) {
            BuscaComentario bc;
            bc = retornaComentario.get(j);

            String chaveClasseReferencia = bc.getChaveClasseReferencia();

            if (chaveClasseReferencia.equals(nomeDoProcesso)) {

                retorna = bc;
                break;
            }
        }
        return retorna;
    }

    public String getSelectFeature() {

        int i = 0;
        boolean teg = false;
        while (teg == false) {

            if (showProcess.isEmpty()) {
                /* monta xml do jonathan */
                System.out
                        .println("EMTRA EM showProcess == NULL E IMPRIME O XML");
                teg = true;
                montaXMLDoJonathanComJAXBAutomagicamente();
                geraListaWorkflow();
                return "definePage10ViewXMLBuild";
            } else {
                ShowProcess k;
                k = showProcess.get(i);
                // String nomeDoProcesso = k.getNomeShowProcess();
                // //System.out.println("nomeDoProcesso_+_+_+_+: " +
                // nomeDoProcesso);
                String algoritmo = k.getAlgoritmsSN();
              //  //System.out.println("SIM OU NAO: " + algoritmo);
                if (algoritmo.equals("S")) {

                    /**
                     * SETO NOME CLASSE DO PROCESSO PARA VISUALIZAÇÃO COM LETRAS
                     * MAIUSCULAS
                     */
                    selectedArtifactAlgorithm = k.getNomeShowProcess()
                            .toUpperCase();
                    /**
                     * STRING COM NOME DO PROCESSO PARA COMPARAR
                     */
                    String compara = k.getNomeShowProcess();
                   // //System.out.println("-x-x-x-x-x-xSelecionadox-x-x-x-x-x-: " + compara);
                    /**
                     * BUNSCA NA ONTOLOGIA RELAÇÃO TAREFA NOME DO ALGORITMO
                     */
                    listMapTaskAlgorithm = TarefaAlgoritmo.getTarefaAlgoritmo();
                    /**
                     * COMPARA TAREFA SELECIONADA RETORNA NOME DO ALGORITMO
                     */
                    String algBusca = comparaGetAlgoritimo(compara);
                    /**
                     * BUSCA NA ONTOLOGIA TODOS INDIVIDUOS RELACIONADOS AO
                     * ALGORITMO BUSCADO (algBusca)
                     */
                    listAlgoritms = MainGabriellaII.getAlgorithms(algBusca);

                    /* pesquisa algoritmos exibe */
                    /* posteriormente passa-se o parametreo de busca */
                    showProcess.remove(0);
                    teg = true;
                } else {
                    showProcess.remove(0);
                    teg = false;

                }
            }
        }

        return null;
    }

    public String pegaXMLSelecionado() {
        VARIAVELGLOBALURLXML = arquivoIndexXMLSelecionado.getUrlArquivo();
        ////System.out.println(VARIAVELGLOBALURLXML);
        mostraDownloadXML = true;
        ///PL-Science/backup/workflow416.xml 
        mostraNomeWorkflow = VARIAVELGLOBALURLXML.substring(19);
        try {
            InputStream stream;
            stream = new FileInputStream(VARIAVELGLOBALURLXML);
            file = new DefaultStreamedContent(stream, "application/xml",
                    mostraNomeWorkflow);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DevelopmentControllerBackUp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * Ação do botão next
     *
     * @return
     */
    public String getSelectedKwqarray() {
        ////System.out.println("entrei aqio no pegaSelecao");
        ////System.out.println("campoSelecONeMenuSelecionado: "
            //+ campoSelecONeMenuSelecionado);
        listSelectAlgorithmForXML
                .add(GetAlgorithmsTask(campoSelecONeMenuSelecionado));
        // montaXMLDoJonathanComJAXBAutomagicamente();
        String retorno = getSelectFeature();
        return retorno;

    }

    /**
     * verifico qual sistema operacional estou
     */
    private String qualOSGravarArquivo() {
        String arq;
       // //System.out.println("QUAL O SYSTEM OPERATION: "
              //  + System.getProperty("os.name"));
        /* VERIFICO EM QUAL SYSTEMA OPERACIONAL ESTOU */
        if (System.getProperty("os.name").equals("Linux")) {
            int n1 = MetodoAuxiliar.sorteia();
            arq = "/PL-Science/backup/workflow" + n1 + ".xml";
        } else {
            int n2 = MetodoAuxiliar.sorteia();
            arq = "C:\\PL-Science\\backup\\workflow" + n2 + ".xml";
        }
        return arq;
    }

    /**
     * gera o xml
     */
    public void montaXMLDoJonathanComJAXBAutomagicamente() {

        String urldeGravacao1 = qualOSGravarArquivo();
      //  //System.out.println("MOSTRA A urldeGravacao1:-Z-Z-Z-Z-Z-Z- " + urldeGravacao1);
        /**
         * Instanciando um ArrayList<Process>
         */
        ArrayList<Process> processes = new ArrayList<Process>();

        /**
         * Instanciando um ArrayList<Connection>
         */
        ArrayList<Connection> connections = new ArrayList<Connection>();

        /**
         * Instanciando um Workflow
         */
        Workflow workflow = new Workflow();

        for (int i = 0; i < listSelectAlgorithmForXML.size(); i++) {

            AlgorithmsTask at;

            at = listSelectAlgorithmForXML.get(i);

            /**
             * instanciando um ArrayList<Parameter>
             */
            ArrayList<Parameter> parameters = new ArrayList<Parameter>();

            /**
             * instanciando uma classe Parameter
             */
            Parameter parameter = new Parameter();

            /**
             * instanciando a segunda classe Parameter
             */
            Parameter parameter1 = new Parameter();

            /**
             * Setando valor nome do parametro(NÃO MUDA)
             */
            parameter.setName("type");

            /**
             * Setando o value do type no parametro
             */
            parameter.setValue(at.getType());

            /**
             * Setando valor hasLocation no parametro(NÃO MUDA)
             */
            parameter1.setName("hasLocation");

            /**
             * Setando o value do hasLocation no parametro é uma URL
             */
            parameter1.setValue(at.getLocal());

            /**
             * setando um parametro em um ArrayList<Parameter>
             */
            parameters.add(parameter);

            /**
             * setando segundo parametro em um ArrayList<Parameter>
             */
            parameters.add(parameter1);

            /**
             * instanciando um process
             */
            Process process = new Process();

            /**
             * Nome do individuo da antologia
             */
            process.setName(at.getNameAlgorithm());

            /**
             * Nome de um id quanquer
             */
            int n = i + 1;
            process.setId("Process_" + n);

            /**
             * aqui set um arrayList de parametros no processo
             */
            process.setParameter(parameters);

            /**
             * adiciono o(s) processo(s) em um ArrayList<Process>
             */
            processes.add(process);
            /**
             * setando o ArrayList<Process> no workflow
             */
            workflow.setProcess(processes);

            /**
             * setando o ArrayList<Connection> no workflow
             */
            workflow.setConnection(connections);

        }

        /**
         * imprimindo o resultado
         */
        ////System.out.println(new Teste().marshal(workflow));
        /**
         * Gravando em arquivo o resultado (o xml)
         */

        marshalToFileII(workflow, urldeGravacao1);

        marshalToFile(workflow, "/PL-Science/backup/workflow.xml");

        String UrlPath = "/PL-Science/backup/indexWorkflow.txt";
        ArrayList<String> work = new ArrayList<String>();
        StringBuilder monta = new StringBuilder();
        monta.append(urldeGravacao1);
        monta.append("#");//data
        String dataDeHoje = MetodoAuxiliar.getHojeFormat();
        monta.append(dataDeHoje);
        monta.append("$");//hora
        String horaTual = MetodoAuxiliar.getHora();
        monta.append(horaTual);
        work.add(monta.toString());
        try {
            MetodoAuxiliar.WritingfileContinuos(work, UrlPath);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block

        } catch (IOException e) {
            // TODO Auto-generated catch block

        }

        /**
         * atualização da tabela How showProcessview
         */
        HowTable a = new HowTable();
        
        String url55 = "SELECT A.`idHow` FROM `HowTable` A ORDER BY A.`idHow` DESC LIMIT 1";
        String resp55 = "idHow";
        int IDHOW = JDBCController.buscaUltimoGravado(url55, resp55);
        
        a =  howDao.pesquisarPorIdHowTable(IDHOW);
       // //System.out.println("ATUALIZANDO IDHOW "+IDHOW);
       // //System.out.println("X-X-X-X-X-X-X-X-X-X->>>>>>>>>Id do HOW: " + IDHOW);
        //a.setIdHow(IDHOW);
        StringBuilder nameView1 = new StringBuilder();
        for (ShowProcess m : preencheDB) {
            StringBuilder append = nameView1.append(m.getNomeShowProcess().toUpperCase());
            nameView1.append(" >>> ");
        }
        String x = nameView1.toString();
        a.setDescription(x);
        
        howDao.atualizar(a);

        /**
         * atualização da tabela what urldeGravacao
         */
        WhatTable b;
        String url44 = "SELECT A.`idWhat` FROM `WhatTable` A ORDER BY A.`idWhat` DESC LIMIT 1";
        String resp44 = "idWhat";
        int IDWHAT = JDBCController.buscaUltimoGravado(url44, resp44);
        ////System.out.println("ATUALIZANDO IDWHAT "+IDWHAT);
        ////System.out.println("X-X-X-X-X-X-X-X-X-X->>>>>>>>>Id do WHAT: " + IDWHAT);
        b =  whatDao.pesquisarPorIdWhatTable(IDWHAT);
        //b.setIdWhat(IDWHAT);
        
        b.setUrlProduct(urldeGravacao);
        whatDao.atualizar(b);

        urlXML = urldeGravacao;

    }

    public void emptyArrayList() {
        mostraIndexXml.clear();
        mostraIndexXml.clear();
        mostraDownloadXML = false;
        mostraNomeWorkflow = "";
        mostraNomeWorkflow = null;
        VARIAVELGLOBALURLXML = "";
        VARIAVELGLOBALURLXML = null;
        arquivoIndexXMLSelecionado = null;
    }

    public String geraListaWorkflow() {
        /**
         * lerArquivoIndexXML
         */
        List<String> lendo;
        List<String> reverseLendo;
        lendo = MetodoAuxiliar.lerArquivoPrincipal("/PL-Science/backup/indexWorkflow.txt");
        /**
         * inverte a lista
         */
        reverseLendo = MetodoAuxiliar.reverseList(lendo);
        for (int i = 0; i < reverseLendo.size(); i++) {
            String n = reverseLendo.get(i);
            ArquivoIndexXML aix = new ArquivoIndexXML();
            int indice1 = n.indexOf("#");
           // //System.out.println("ATENÇÃO PARA O INDECE1: " + indice1);
            int indice2 = n.indexOf("$");
           // //System.out.println("ATENÇÃO PARA O INDECE2: " + indice2);
            String url;
            url = n.substring(0, indice1);//pego a url
           // //System.out.println("ATENÇÃO PARA A URL: " + url);
            aix.setUrlArquivo(url);
            String data;
            data = n.substring(indice1 + 1, indice2);//pego a data
           // //System.out.println("ATENÇÃO PARA A DATA: " + data);
            aix.setData(data);
            String hora;
            hora = n.substring(indice2 + 1);
           // //System.out.println("ATENÇÃO PARA A HORA: " + hora);
            aix.setHora(hora);
            mostraIndexXml.add(aix);
            arquivoIndexXMLDM = new ArquivoIndexXMLDM(mostraIndexXml);

        }

        return "definePage10ViewXMLBuild";
    }

    /**
     * @param compara
     */
    private String comparaGetAlgoritimo(String compara) {
        String volta = "";
        for (int i = 0; i < listMapTaskAlgorithm.size(); i++) {
            MapTaskAlgorithm a;
            a = listMapTaskAlgorithm.get(i);
            String se = compara.trim();
            String var = a.getTaskNameClass();
            if (var.equals(se)) {
                System.out
                        .println("b-b-b-b-b-b-b-b-b-b-b-b-b-b-b-b-b-b-b-b-b-b-b-b-b-b-bSelecionado-Compara: "
                                + a.getTaskNameClass());
                volta = a.getAlgorithmNameClass();
                System.out
                        .println("-c-c-c-c-c-c-c-c-c-c-c-c-c-c-c-c-c-c-c-c-c-c-c-c-c-c-calgoritmoBusca: "
                                + algoritmoBusca);
                break;
            }
        }
        return volta;
    }
         //qualOSGravarArquivo();
    /**
     * @param compara
     */
    private AlgorithmsTask GetAlgorithmsTask(String compara) {
        AlgorithmsTask volta = new AlgorithmsTask();
        for (int i = 0; i < listAlgoritms.size(); i++) {
            AlgorithmsTask a;
            a = listAlgoritms.get(i);
            String se = compara.trim();
            String var = a.getNameAlgorithm();
            if (var.equals(se)) {

                volta = a;

                break;
            }
        }
        return volta;
    }

    public void reset() {

        root.setSelected(false);
        root.setExpanded(false);
        root.setSelectable(false);
        mandatory.clear();
        FeatureWizard();
        selectedNode = null;
        comentarioOntologia.clear();
        showProcess.clear();
        showProcessview = "";

    }

    /* TRASNFORMA ARRAYLIST NUMA STRING GIGANTE */
    /*
     * (non-Javadoc)
     * 
     * @see br.com.ufjf.control.main.ukj#concatenaNomes()
     */
    public void concatenaNomes() {
        StringBuilder nameView = new StringBuilder();
        for (MostrarRestricao mr : mostraRestricao) {
            String nomerestry = mr.getNomeRestricao();
            nameView.append(nomerestry);
            nameView.append("\n");
        }
        returnOnto = nameView.toString();
       // //System.out.println("returnOnto: " + returnOnto);
    }

    public void concatenaNomesII() {

    }

    /* AÃ‡ÃƒO DE UM AJAX */
    /*
     * (non-Javadoc)
     * 
     * @see br.com.ufjf.control.main.ukj#Imprime()
     */
    public void Imprime() {
        String selecioAlgo = selectedNode.getData().toString();
        System.out
                .println("selecioAlgo-selecioAlgo-selecioAlgo-selecioAlgo-selecioAlgo:"
                        + selecioAlgo);

        returnOnto = "Confirm your selection by clicking SELECT FEATURE button!";

        /*
         * ConsultaOWLRestricao CR = new ConsultaOWLRestricao();
         * Iterator<Mapping> it = mapping.iterator(); while (it.hasNext()) {
         * Mapping c3 = new Mapping(); c3 = it.next(); if
         * (c3.getFeatureName().equals(selecioAlgo)) { //
         * ArrayList<MostrarRestricao> al = new //
         * ArrayList<MostrarRestricao>();
         * 
         * try { String query = c3.getClassName(); String local =
         * getArtifactTrue("Ontology"); //System.out.println("local-ONTOLOGY: " +
         * local); CR = QueryRestriction .shouldLookAtRestrictions(query,
         * local);
         * 
         * // al = CR.getAsRestricoes(); if (CR.getNunRestricao() != 0) {
         * 
         * mostraRestricao = CR.getAsRestricoes();
         * 
         * } else { returnOnto = "Sem restriÃ§Ãµes!!"; }
         * 
         * //concatenaNomes(); } catch (OWLOntologyCreationException e) {
         * System.out
         * .println("nÃ£o foi possivel realizar a consulta dom OWL-API");
         * e.printStackTrace(); }
         * 
         * } }
         */
    }

      /**
     * NAVEGAÃ‡ÃƒO - BOTAO - productDevelopment
     *
     * (non-Javadoc)
     *
     * @return
     * @see br.com.ufjf.control.main.ukj#productDevelopment()
     */
    public String back() {
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

          
       return null;
    }
    
      /**
     * NAVEGAÃ‡ÃƒO - BOTAO - productDevelopment
     *
     * (non-Javadoc)
     *
     * @return
     * @see br.com.ufjf.control.main.ukj#productDevelopment()
     */
    public String backII() {
       return "definePage10ViewFeatureNameProduct.xhtml";
    }
    /**
     * 02 - (primeira-do-desenvolvimento-seleciona-artefatos) - -
     * CONTROLLER-QUE-CHAMA === BOTAO-DEVELOPMENT - includePage2Menu01 -
     * @return
     * @see br.com.ufjf.control.main.ukj#productDevelopment()
     */
    public String productDevelopment() {

        /*limpa o arrayliste de mensagens*/
        listAnrafelSQL06.clear();
        listAnrafelSQL06.clear();
        /*seta numero da aba que sera aberta*/
        numAbaAberta = "0";
        /*implenta o <cif> com verdadeiro*/
        mostraPageViewII = true;
       

        int idlogado = pegaIDcontextRetorna();
        String idlogadoString = String.valueOf(idlogado);

        habilitaMSGView1 = false;
        /*ISSO AQUI CARREGA  A ABA includePage5LateralDireita05
         AS MENSAGENS
        */
        listAnrafelSQL06 = JDBCController.anrafelSQL06(idlogadoString);
        //nao sei porque retorna dois estou removendo um
       // listAnrafelSQL06.remove(0);
        
        /*for(AnrafelSQL06 n: listAnrafelSQL06){
            //System.out.println("-z-z-z-z-z-z-z-z-z-z-z-listAnrafelSQL06-z-z-z-z-z-z-z-z-z-z-z-z-z");
            //System.out.println("getNameScientist(): "+n.getNameScientist());
            //System.out.println("getIdRationale: "+n.getIdRationale());
            //System.out.println("-z-z-z-z-z-z-z-z-z-z-z-listAnrafelSQL06-z-z-z-z-z-z-z-z-z-z-z-z-z");
        }*/

        /*AQUI O RESTO É DA PAGINA DEFINE-PAGE ======= definePage09ProductDevelopment -*/
        nameViewArtifact1 = "Before proceeding select one model of each type shown below:";

        artifactsArtD = new ArrayList<Artifact>();
        artifactsMapD = new ArrayList<Artifact>();
        artifactsOntD = new ArrayList<Artifact>();
        String query = "SELECT a FROM Artifact a WHERE a.type = 'FeatureModel'";
        artifactsArtD = (List<Artifact>) artifactDao.listPesq(query);

        String query1 = "SELECT a FROM Artifact a WHERE a.type = 'MappingFile'";
        artifactsMapD = (List<Artifact>) artifactDao.listPesq(query1);

        String query2 = "SELECT a FROM Artifact a WHERE a.type = 'Ontology'";
        artifactsOntD = (List<Artifact>) artifactDao.listPesq(query2);

        return "definePage09ProductDevelopment";

    }

    /**
     * public TreeNode getRoot() { return root; }
     *
     * public TreeNode getSelectedNode() { return selectedNode; }
     *
     * public void setSelectedNode(TreeNode selectedNode) { this.selectedNode =
     * selectedNode; }
     *
     * public String getMessage() { return message; }
     *
     * public void setMessage(String message) { this.message = message; }
     *
     * (non-Javadoc)
     *
     * @param event
     * @see br.com.ufjf.control.main.ukj#onNodeExpand(org.primefaces.event.
     * NodeExpandEvent)
     */
    public void onNodeExpand(NodeExpandEvent event) {
        FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Expanded", event.getTreeNode().toString());
        FacesContext.getCurrentInstance().addMessage(null, message1);
    }

    /**
     * (non-Javadoc)
     *
     * @param event
     * @see br.com.ufjf.control.main.ukj#onNodeCollapse(org.primefaces.event.
     * NodeCollapseEvent)
     */
    public void onNodeCollapse(NodeCollapseEvent event) {
        FacesMessage message11 = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Collapsed", event.getTreeNode().toString());
        FacesContext.getCurrentInstance().addMessage(null, message11);
    }

    /**
     * para o mapeamento
     *
     * (non-Javadoc)
     *
     * @param event
     * @see br.com.ufjf.control.main.ukj#onNodeSelect(org.primefaces.event.
     * NodeSelectEvent)
     */
    public void onNodeSelect(NodeSelectEvent event) {
        returnOnto = "";
        String noSelecionado = String.valueOf(selectedNode);
        FacesMessage message22 = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Selected", noSelecionado);
        FacesContext.getCurrentInstance().addMessage(null, message22);
    }

    /**
     * (non-Javadoc)
     *
     * @param node
     * @param nome
     * @return
     * @see br.com.ufjf.control.main.ukj#searchNode(br.com.ufjf.model.No,
     * java.lang.String)
     */
    public No searchNode(No node, String nome) {

        if (node == null) {
            return null;
        } else {
            for (int i = 0; i < node.getFilhos().size(); i++) {
                if (node.getFilhos().get(i).getNome().equals(nome)) {
                    return node.getFilhos().get(i);
                }
                if (node.getFilhos().get(i).getFilhos() != null) {
                    // //System.out.println(node.getFilhos().get(i).getNome());
                    searchNode(node.getFilhos().get(i), nome);
                }
            }
            return null;
        }
    }

    /**
     * (non-Javadoc)
     *
     * @param event
     * @see br.com.ufjf.control.main.ukj#onNodeUnselect(org.primefaces.event.
     * NodeUnselectEvent)
     */
    public void onNodeUnselect(NodeUnselectEvent event) {
        FacesMessage message44 = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Unselected", event.getTreeNode().toString());
        FacesContext.getCurrentInstance().addMessage(null, message44);
    }

    /**
     * faz 5 consultas (non-Javadoc)
     *
     * @return
     * @see br.com.ufjf.control.main.ukj#viewContMassageII()
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
        nomeImagem = "e-mail.png";
        controlaTempo = 60;

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
        pegaIDcontext();
        JDBCController.updateMsgLida(idUserContext);

        setaPageView = "includePage7ViewBox08.xhtml";

        // esta OK
        return null;
    }

      /**
     * faz 5 consultas (non-Javadoc)
     *
     * @return
     * @see br.com.ufjf.control.main.ukj#viewContMassageII()
     */
    public String viewContMassageIV() {
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
        nomeImagem = "e-mail.png";
        controlaTempo = 60;

       // //System.out.println("idRationale:idRationale:idRationale: "
              //  + idRationale1);
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
        pegaIDcontext();
        JDBCController.updateMsgLida(idUserContext);

        setaPageView = "includePage7ViewBox08_2.xhtml";

        // esta OK
        return "definePage10ViewFeatureNameProduct.xhtml";
    }
    
    
    /**
     * (non-Javadoc)
     *
     * @see br.com.ufjf.control.main.ukj#messageAlert()
     */
    public void messageAlert() {

        if (JDBCController.confereMessage(idUserContext) == 0) {
            nomeImagem = "e-mail.png";
            controlaTempo = 60;
        } else {
            nomeImagem = "e-mail.gif";
        }

    }

    /**
     * grava nota (non-Javadoc)
     *
     * @see br.com.ufjf.control.main.ukj#respondeMensagem()
     */
    public void respondeMensagem() {

        int id = userSelecionado;
     
           // pegaIDcontext();
           // Communication com;
            //ServCommunication_Service webservice = new ServCommunication_Service();
            //ServCommunication servico = webservice.getServCommunicationPort();
           // String LOCAL = servico.fullCommunicationXML(idRationaleSelect, idUserContext, id, mensagemEnviada);
            //com = (Communication) unmarshalFromFile(Communication.class, LOCAL);

           // communicatioDao.salvar(com);
        
        listAnrafelSQL06.clear();
        pegaIDcontext();
        String idScientistString = String.valueOf(idUserContext);
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
    
    /**
     * grava nota (non-Javadoc)
     *
     * @return 
     * @see br.com.ufjf.control.main.ukj#respondeMensagem()
     */
    public String respondeMensagemI() {

        int id = userSelecionado;
     
           // pegaIDcontext();
           // Communication com;
           // ServCommunication_Service webservice = new ServCommunication_Service();
           // ServCommunication servico = webservice.getServCommunicationPort();
           // String LOCAL = servico.fullCommunicationXML(idRationaleSelect, idUserContext, id, mensagemEnviada);
            //com = (Communication) unmarshalFromFile(Communication.class, LOCAL);

           // communicatioDao.salvar(com);
        
        listAnrafelSQL06.clear();
        pegaIDcontext();
        String idScientistString = String.valueOf(idUserContext);
        listAnrafelSQL06 = JDBCController.anrafelSQL06(idScientistString);
       
        productDevelopment();
                return "definePage03ViewArtifact1.xhtml";
    }

/**
     * grava nota (non-Javadoc)
     *
     * @return 
     * @see br.com.ufjf.control.main.ukj#respondeMensagem()
     */
    public String respondeMensagemII() {

        int id = userSelecionado;
     
           // pegaIDcontext();
           // Communication com;
           // ServCommunication_Service webservice = new ServCommunication_Service();
           // ServCommunication servico = webservice.getServCommunicationPort();
          //  String LOCAL = servico.fullCommunicationXML(idRationaleSelect, idUserContext, id, mensagemEnviada);
           // com = (Communication) unmarshalFromFile(Communication.class, LOCAL);

           // communicatioDao.salvar(com);
        
        listAnrafelSQL06.clear();
        pegaIDcontext();
        String idScientistString = String.valueOf(idUserContext);
        listAnrafelSQL06 = JDBCController.anrafelSQL06(idScientistString);
       
        return "definePage10ViewFeatureNameProduct.xhtml";
                
    }
    
    public static int stringToInt(String value, int _default) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return _default;
        }
    }

    /**
     * abas do gerente de artefato
     */
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

        return "definePage10ViewFeatureRead";
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
     * Method listarArtefato LIST ARTIFACTS - BANK SEARCH ALL ARTIFACTS
     *
     * @return String
     *
     */
    public String listarArtefato() {
        listAnrafelSQL02.clear();
        listAnrafelSQL03.clear();
        listAnrafelSQL04.clear();
        listAnrafelSQL05.clear();
        listAnrafelSQL06.clear();
        listaArtifacts = new ArrayList<Artifact>();
        User x = new User();
        listaArtifacts = (ArrayList<Artifact>) artifactDao.todos(x.getClass());
        mediumArtifactModel = new ArtifactDM(listaArtifacts);

        return "definePage03ViewArtifact1";
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

    /**
     * Method includeNoteCancel which method includes page
     * includePage6ViewBox01.xhtml
     *
     * @return String
     *
     */
    public String includeNoteCancel() {

        msgNotesVazia = "";
        numAbaAberta = "4";
        habilitaII = true;
        habilitaI = true;
        viewBox = " ";
        // User us = new User();
        listaUsers = new ArrayList<User>();
        User x = new User();
        listaUsers = (ArrayList<User>) userDao.todos(x.getClass());
        mediumUserModel = new UserDM(listaUsers);

        return "definePage10ViewFeatureRead";
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
        return "definePage10ViewFeatureRead";
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
     * Method viewContMassageII makes five different queries in the database
     *
     * @return String
     *
     *
     * public String viewContMassageII() { numAbaAberta = "1"; numAbaAbertaII =
     * "0"; mostraPageViewII = false; listAnrafelSQL02.clear();
     * listAnrafelSQL03.clear(); listAnrafelSQL04.clear();
     * listAnrafelSQL05.clear(); listAnrafelSQL06.clear(); // Pega o parâmetro
     * via request. String idRationale = FacesContext.getCurrentInstance()
     * .getExternalContext().getRequestParameterMap() .get("idRationale"); if
     * (idRationale == null) { return null; } String num = idRationale.trim();
     * idRationaleSelect = Integer.parseInt(num); nomeImagem = "e-mail.png";
     * controlaTempo = 60;
     *
     * //System.out.println("idRationale:idRationale:idRationale: " +
     * idRationale); listAnrafelSQL02 =
     * JDBCController.anrafelSQL02(idRationale); listAnrafelSQL03 =
     * JDBCController.anrafelSQL03(idRationale); listAnrafelSQL04 =
     * JDBCController.anrafelSQL04(idRationale); listAnrafelSQL05 =
     * JDBCController.anrafelSQL05(idRationale); mostraPageViewII = false; User
     * x = new User(); listaUsers = (ArrayList<User>)
     * userDao.todos(x.getClass());
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     */
    /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
    /*-x-x-x-x-x-x-x-x-x-x-UPDATE-TABELA-lidaSN-x-x-x-x-x-x-x-x-x-x-x-x-x*/
    /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
    /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     pegaIDcontext();
     JDBCController.updateMsgLida(idUserContext);

     setaPageView = "includePage7ViewBox08.xhtml";

     // esta OK
     return "definePage09ProductDevelopment.xhtml";
     }
     */
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
            //Notes nt;
            //ServAnnotation_Service webservice = new ServAnnotation_Service();
            //ServAnnotation servico = webservice.getServAnnotationPort();
            //String LOCAL = servico.fullNotesXML(mensagemValor, idUltimoRatinaleGravdo);
            //nt = (Notes) unmarshalFromFile(Notes.class, LOCAL);
            ////System.out.println("getDescription: " + nt.getDescription());
           // //System.out.println("getIdRationale: " + nt.getIdRationale());
           // notesDAO.salvar(nt);
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

        return "definePage10ViewFeatureRead";
    }

    public String gravaCommunication() {
        /**
         * SALVA O NOTES COM SERVIÇO DE PREENCHER O OBJETO NOTES
         */
        if (!messageCommunication.equals("")) {
            msgCommunicatioVazia = "";

           // pegaIDcontext();
           // Communication com;
           // ServCommunication_Service webservice = new ServCommunication_Service();
           // ServCommunication servico = webservice.getServCommunicationPort();
           // String LOCAL = servico.fullCommunicationXML(idUltimoRatinaleGravdo, idUserContext, selectedUserModel.getIdScientist(), messageCommunication);
           // com = (Communication) unmarshalFromFile(Communication.class, LOCAL);

           // communicatioDao.salvar(com);

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

        return "definePage10ViewFeatureRead";
    }

    /**
     * Method respondeMensagem() message RECORDS IN DATABASE
     *
     * @return String
     *
     *
     * public void respondeMensagem() { int id = userSelecionado; Communication
     * cmc = new Communication(); cmc.setMessage(mensagemEnviada);
     * cmc.setIdRationale(idRationaleSelect);
     * cmc.setIdScientistEmissor(idUserContext); cmc.setIdScientistReceptor(id);
     * cmc.setLidaSn(1); // obtendo a data de hoje por inteiros com calendar //
     * instanciando o date para obter a data de hoje Date hoje = new Date();
     * String formato = "dd/MM/yyyy"; SimpleDateFormat formatter = new
     * SimpleDateFormat(formato); String data = formatter.format(hoje); Date
     * hojeW = new Date(); // instanciando calendar Calendar cal =
     * Calendar.getInstance(); // setando hoje em calendar cal.setTime(hojeW);
     *
     * // obtendo inteiro da hora int hora = cal.get(Calendar.HOUR_OF_DAY); //
     * obtendo inteiro do minutos int minuto = cal.get(Calendar.MINUTE); String
     * hora_ = String.valueOf(hora) + ":" + String.valueOf(minuto);
     * cmc.setData(data); cmc.setHora(hora_);
     *
     * communicatioDao.salvar(cmc); listAnrafelSQL06.clear(); String
     * idScientistString = String.valueOf(idUserContext); listAnrafelSQL06 =
     * JDBCController.anrafelSQL06(idScientistString); productDevelopment(); }
     */
    /**
     * Method productDevelopment() BUTTON START DEVELOPMENT IN MAIN MENU
     *
     * @return String
     *
     *
     * public String productDevelopment() {
     *
     * mostraPageViewII = true; // Pega o parâmetro via request. String
     * idScientist = FacesContext.getCurrentInstance()
     * .getExternalContext().getRequestParameterMap() .get("idScientist"); if
     * (idScientist == null) { return null; }
     *
     * habilitaMSGView1 = false; listAnrafelSQL06 = new
     * ArrayList<AnrafelSQL06>(); /* removendo itens do arreyListe for (int i =
     * 0; i < listAnrafelSQL06.size(); i++) { listAnrafelSQL06.remove(i); }
     * listAnrafelSQL06.clear(); listAnrafelSQL06 =
     * JDBCController.anrafelSQL06(idScientist);
     *
     * // mostraPageView = false; // setaPageView = " "; // viewBoxIV =
     * "includePage7ViewBox07.xhtml"; nameArtifact = " "; nameArtifactMap = " ";
     * nameArtifactOnt = " ";
     *
     * nameViewArtifact1 = "Before proceeding select one model of each type
     * shown below:";
     *
     * artifactsArt = new ArrayList<Artifact>(); artifactsMap = new
     * ArrayList<Artifact>(); artifactsOnt = new ArrayList<Artifact>(); String
     * query = "SELECT a FROM Artifact a WHERE a.type = 'FeatureModel'";
     * artifactsArt = (List<Artifact>) artifactDao.listPesq(query); //
     * //System.out.println("oi teste:-oi teste:-oi teste: " // +
     * artifactsArt.get(0).getName());
     *
     * String query1 = "SELECT a FROM Artifact a WHERE a.type = 'MappingFile'";
     * artifactsMap = (List<Artifact>) artifactDao.listPesq(query1); //
     * //System.out.println("oi teste:-oi teste:-oi teste: " // +
     * artifactsArt.get(0).getName());
     *
     * String query2 = "SELECT a FROM Artifact a WHERE a.type = 'Ontology'";
     * artifactsOnt = (List<Artifact>) artifactDao.listPesq(query2); //
     * //System.out.println("oi teste:-oi teste:-oi teste: " // +
     * artifactsArt.get(0).getName());
     *
     * return "definePage09ProductDevelopment";
     *
     * }
     */
    /**
     * gerente de artefatos
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
        User x = new User();
        listaUsers = (ArrayList<User>) userDao.todos(x.getClass());
        mediumUserModel = new UserDM(listaUsers);
        pegaIDcontext();

        retorna = "definePage13EditArtifact";

    }

    /**
     * Method pegaIDcontext recovers idUser logged
     *
     * idUserContext pegaIDcontext()
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
       // //System.out.println("idUserContext-pegaIDcontext(): " + idUserContext);
    }

    
    /**
     * Method pegaIDcontext recovers idUser logged
     *
     * idUserContext pegaIDcontext()
     *
     * @return 
     */
    public int pegaIDcontextRetorna() {
        facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        User a;
        a = (User) session.getAttribute("currentUser");
        int retorno = a.getIdScientist();
       // //System.out.println("idUserContext-pegaIDcontext(): " + idUserContext);
        return retorno;
    }
    
    
    public String sparqlQuery() {//textarea
        
           
            
           // ServOntologyGenericSparql_Service  webservice = new ServOntologyGenericSparql_Service();
           // ServOntologyGenericSparql servico = webservice.getServOntologyGenericSparqlPort();
           // String LOCAL = servico.returnGenericSparql("http://plscience.superdignus.com/CollaborativePL-ScienceOntologyv1.owl", sparqlfield);
            //com = (Communication) unmarshalFromFile(Communication.class, LOCAL); 
        
        
        return null;
    }
     public String queryTerms() {
        return null;
    }
    
    /**
     * Method stringToInt() Turns a String into integer
     *
     * @param value
     * @param _default
     * @return      *
     *
     *
     * public static int stringToInt(String value, int _default) { try { return
     * Integer.parseInt(value); } catch (NumberFormatException e) { return
     * _default; } }
     */
    /**
     * INICIO DOS GET AND SET. INICIO DOS GET AND SET. INICIO DOS GET AND SET.
     *
     * @return
     */
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

    public void setWhoDao(WhoTableDAO whoDao) {
        WhoDao = whoDao;
    }

    public WhenTableDAO getWhenDao() {
        return WhenDao;
    }

    public void setWhenDao(WhenTableDAO whenDao) {
        WhenDao = whenDao;
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

    public List<Artifact> getSelectedArtifactZ() {
        return selectedArtifactZ;
    }

    public void setSelectedArtifactZ(List<Artifact> selectedArtifactZ) {
        this.selectedArtifactZ = selectedArtifactZ;
    }

    public Artifact getSelectedArtifactMapping() {
        return selectedArtifactMapping;
    }

    public void setSelectedArtifactMapping(Artifact selectedArtifactMapping) {
        this.selectedArtifactMapping = selectedArtifactMapping;
    }

    public Artifact getSelectedArtifactFeature() {
        return selectedArtifactFeature;
    }

    public void setSelectedArtifactFeature(Artifact selectedArtifactFeature) {
        this.selectedArtifactFeature = selectedArtifactFeature;
    }

    public Artifact getSelectedArtifactOntology() {
        return selectedArtifactOntology;
    }

    public void setSelectedArtifactOntology(Artifact selectedArtifactOntology) {
        this.selectedArtifactOntology = selectedArtifactOntology;
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

    public int getArtefatoUsadoART() {
        return artefatoUsadoART;
    }

    public void setArtefatoUsadoART(int artefatoUsadoART) {
        this.artefatoUsadoART = artefatoUsadoART;
    }

    public int getArtefatoUsadoMAP() {
        return artefatoUsadoMAP;
    }

    public void setArtefatoUsadoMAP(int artefatoUsadoMAP) {
        this.artefatoUsadoMAP = artefatoUsadoMAP;
    }

    public int getArtefatoUsadoONT() {
        return artefatoUsadoONT;
    }

    public void setArtefatoUsadoONT(int artefatoUsadoONT) {
        this.artefatoUsadoONT = artefatoUsadoONT;
    }

    public List<Artifact> getArtifactsArtD() {
        return artifactsArtD;
    }

    public void setArtifactsArtD(List<Artifact> artifactsArtD) {
        this.artifactsArtD = artifactsArtD;
    }

    public List<Artifact> getArtifactsMapD() {
        return artifactsMapD;
    }

    public void setArtifactsMapD(List<Artifact> artifactsMapD) {
        this.artifactsMapD = artifactsMapD;
    }

    public List<Artifact> getArtifactsOntD() {
        return artifactsOntD;
    }

    public void setArtifactsOntD(List<Artifact> artifactsOntD) {
        this.artifactsOntD = artifactsOntD;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_purpose() {
        return product_purpose;
    }

    public void setProduct_purpose(String product_purpose) {
        this.product_purpose = product_purpose;
    }

    public Plm getRaiz() {
        return raiz;
    }

    public void setRaiz(Plm raiz) {
        this.raiz = raiz;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public ArrayList<Mapping> getMapping() {
        return mapping;
    }

    public void setMapping(ArrayList<Mapping> mapping) {
        this.mapping = mapping;
    }

    public Mapping getOneMapping() {
        return oneMapping;
    }

    public void setOneMapping(Mapping oneMapping) {
        this.oneMapping = oneMapping;
    }

    public StringBuilder getSbd() {
        return sbd;
    }

    public void setSbd(StringBuilder sbd) {
        this.sbd = sbd;
    }

    public String getReturnOnto() {
        return returnOnto;
    }

    public void setReturnOnto(String returnOnto) {
        this.returnOnto = returnOnto;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<MostrarRestricao> getMostraRestricao() {
        return mostraRestricao;
    }

    public void setMostraRestricao(ArrayList<MostrarRestricao> mostraRestricao) {
        this.mostraRestricao = mostraRestricao;
    }

    public Boolean getMostraPageView() {
        return mostraPageView;
    }

    public void setMostraPageView(Boolean mostraPageView) {
        this.mostraPageView = mostraPageView;
    }

    public Boolean getMostraPageViewII() {
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

    public int getIdRationaleSelect() {
        return idRationaleSelect;
    }

    public void setIdRationaleSelect(int idRationaleSelect) {
        this.idRationaleSelect = idRationaleSelect;
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

    public ArrayList<Communication> getListCommunicationView() {
        return listCommunicationView;
    }

    public void setListCommunicationView(
            ArrayList<Communication> listCommunicationView) {
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

    public void setListAnrafelSQL06(ArrayList<AnrafelSQL06> listAnrafelSQL06) {
        this.listAnrafelSQL06 = listAnrafelSQL06;
    }

    public int getIdUserContext() {
        return idUserContext;
    }

    public void setIdUserContext(int idUserContext) {
        this.idUserContext = idUserContext;
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

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public String getNumAbaAbertaII() {
        return numAbaAbertaII;
    }

    public void setNumAbaAbertaII(String numAbaAbertaII) {
        this.numAbaAbertaII = numAbaAbertaII;
    }

    public int getControlaTempo() {
        return controlaTempo;
    }

    public void setControlaTempo(int controlaTempo) {
        this.controlaTempo = controlaTempo;
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

    public ArtifactDM getMediumArtifactModel() {
        return mediumArtifactModel;
    }

    public void setMediumArtifactModel(ArtifactDM mediumArtifactModel) {
        this.mediumArtifactModel = mediumArtifactModel;
    }

    public String getNumAbaAberta() {
        return numAbaAberta;
    }

    public void setNumAbaAberta(String numAbaAberta) {
        this.numAbaAberta = numAbaAberta;
    }

    public ArrayList<User> getListaUsers() {
        return listaUsers;
    }

    public void setListaUsers(ArrayList<User> listaUsers) {
        this.listaUsers = listaUsers;
    }

    public NosObrigatory getNosObrigatory5() {
        return nosObrigatory5;
    }

    public void setNosObrigatory5(NosObrigatory nosObrigatory5) {
        this.nosObrigatory5 = nosObrigatory5;
    }

    public ArrayList<NosObrigatory> getListnosObrigatorySelect() {
        return ListnosObrigatorySelect;
    }

    public void setListnosObrigatorySelect(
            ArrayList<NosObrigatory> listnosObrigatorySelect) {
        ListnosObrigatorySelect = listnosObrigatorySelect;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public ArrayList<ShowProcess> getShowProcess() {
        return showProcess;
    }

    public void setShowProcess(ArrayList<ShowProcess> showProcess) {
        this.showProcess = showProcess;
    }

    public String getShowProcessview() {
        return showProcessview;
    }

    public void setShowProcessview(String showProcessview) {
        this.showProcessview = showProcessview;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public static ArrayList<TreeNode> getNodes() {
        return nodes;
    }

    public static void setNodes(ArrayList<TreeNode> nodes) {
        DevelopmentControllerBackUp.nodes = nodes;
    }

    public static void setElements(ArrayList<Element> elements) {
        DevelopmentControllerBackUp.elements = elements;
    }

    public ArrayList<BuscaComentario> getRetornaComentario() {
        return retornaComentario;
    }

    public void setRetornaComentario(
            ArrayList<BuscaComentario> retornaComentario) {
        this.retornaComentario = retornaComentario;
    }

    public ArrayList<BuscaComentario> getComentarioOntologia() {
        return comentarioOntologia;
    }

    public void setComentarioOntologia(
            ArrayList<BuscaComentario> comentarioOntologia) {
        DevelopmentControllerBackUp.comentarioOntologia = comentarioOntologia;
    }

    public int getContadorY() {
        return contadorY;
    }

    public void setContadorY(int contadorY) {
        this.contadorY = contadorY;
    }

    public String getTipoAplicacao() {
        return tipoAplicacao;
    }

    public void setTipoAplicacao(String tipoAplicacao) {
        this.tipoAplicacao = tipoAplicacao;
    }

    public boolean isMostraPageViewAlgoritmo() {
        return mostraPageViewAlgoritmo;
    }

    public void setMostraPageViewAlgoritmo(boolean mostraPageViewAlgoritmo) {
        this.mostraPageViewAlgoritmo = mostraPageViewAlgoritmo;
    }

    public String getSetaPageViewAlgoritmos() {
        return setaPageViewAlgoritmos;
    }

    public void setSetaPageViewAlgoritmos(String setaPageViewAlgoritmos) {
        this.setaPageViewAlgoritmos = setaPageViewAlgoritmos;
    }

    public ArrayList<Algorithms> getAlgorithmsList() {
        return algorithmsList;
    }

    public void setAlgorithmsList(ArrayList<Algorithms> algorithmsList) {
        this.algorithmsList = algorithmsList;
    }

    public boolean isMostraalgoritmo() {
        return mostraalgoritmo;
    }

    public void setMostraalgoritmo(boolean mostraalgoritmo) {
        this.mostraalgoritmo = mostraalgoritmo;
    }

    public String getSelectedArtifactAlgorithm() {
        return selectedArtifactAlgorithm;
    }

    public void setSelectedArtifactAlgorithm(String selectedArtifactAlgorithm) {
        this.selectedArtifactAlgorithm = selectedArtifactAlgorithm;
    }

    

    public AlgorithmsTask getAlgoritmsSelect() {
        return algoritmsSelect;
    }

    public void setAlgoritmsSelect(AlgorithmsTask algoritmsSelect) {
        this.algoritmsSelect = algoritmsSelect;
    }

    public ArrayList<AlgorithmsTask> getListAlgoritms() {
        return listAlgoritms;
    }

    public void setListAlgoritms(ArrayList<AlgorithmsTask> listAlgoritms) {
        this.listAlgoritms = listAlgoritms;
    }

    public ArrayList<MapTaskAlgorithm> getListMapTaskAlgorithm() {
        return listMapTaskAlgorithm;
    }

    public void setListMapTaskAlgorithm(
            ArrayList<MapTaskAlgorithm> listMapTaskAlgorithm) {
        this.listMapTaskAlgorithm = listMapTaskAlgorithm;
    }

    public String getAlgoritmoBusca() {
        return algoritmoBusca;
    }

    public void setAlgoritmoBusca(String algoritmoBusca) {
        this.algoritmoBusca = algoritmoBusca;
    }

    public ArrayList<AlgorithmsTask> getListSelectAlgorithmForXML() {
        return listSelectAlgorithmForXML;
    }

    public void setListSelectAlgorithmForXML(
            ArrayList<AlgorithmsTask> listSelectAlgorithmForXML) {
        this.listSelectAlgorithmForXML = listSelectAlgorithmForXML;
    }

    public AlgorithmsTaskDM getAlgorithmsTaskDM() {
        return algorithmsTaskDM;
    }

    public void setAlgorithmsTaskDM(AlgorithmsTaskDM algorithmsTaskDM) {
        this.algorithmsTaskDM = algorithmsTaskDM;
    }

    public List<SelectItem> getListaSelectItemview() {
        return listaSelectItemview;
    }

    public void setListaSelectItemview(List<SelectItem> listaSelectItemview) {
        this.listaSelectItemview = listaSelectItemview;
    }

    public String getCampoSelecONeMenuSelecionado() {
        return campoSelecONeMenuSelecionado;
    }

    public void setCampoSelecONeMenuSelecionado(
            String campoSelecONeMenuSelecionado) {
        this.campoSelecONeMenuSelecionado = campoSelecONeMenuSelecionado;
    }

    public String getUrlXML() {
        return urlXML;
    }

    public void setUrlXML(String urlXML) {
        this.urlXML = urlXML;
    }

    public ArrayList<ShowProcess> getPreencheDB() {
        return preencheDB;
    }

    public void setPreencheDB(ArrayList<ShowProcess> preencheDB) {
        this.preencheDB = preencheDB;
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public String getUrldeGravacao() {
        return urldeGravacao;
    }

    public void setUrldeGravacao(String urldeGravacao) {
        this.urldeGravacao = urldeGravacao;
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

    

    public static ArrayList<Element> getMandatory() {
        return mandatory;
    }

    public static void setMandatory(ArrayList<Element> mandatory) {
        DevelopmentControllerBackUp.mandatory = mandatory;
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

    public ArrayList<Artifact> getListaArtifacts() {
        return listaArtifacts;
    }

    public void setListaArtifacts(ArrayList<Artifact> listaArtifacts) {
        this.listaArtifacts = listaArtifacts;
    }

    public Artifact getSelectedArtifact() {
        return selectedArtifact;
    }

    public void setSelectedArtifact(Artifact selectedArtifact) {
        this.selectedArtifact = selectedArtifact;
    }

    public ArrayList<AnrafelSQL07> getListAnrafelSQL07() {
        return listAnrafelSQL07;
    }

    public void setListAnrafelSQL07(ArrayList<AnrafelSQL07> listAnrafelSQL07) {
        this.listAnrafelSQL07 = listAnrafelSQL07;
    }

    public ArrayList<AnrafelSQL08> getListAnrafelSQL08() {
        return listAnrafelSQL08;
    }

    public void setListAnrafelSQL08(ArrayList<AnrafelSQL08> listAnrafelSQL08) {
        this.listAnrafelSQL08 = listAnrafelSQL08;
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

    public NotesDAO getNotesDAO() {
        return notesDAO;
    }

    public void setNotesDAO(NotesDAO notesDAO) {
        this.notesDAO = notesDAO;
    }

    public int getIdUltimoRatinaleGravdo() {
        return idUltimoRatinaleGravdo;
    }

    public void setIdUltimoRatinaleGravdo(int idUltimoRatinaleGravdo) {
        this.idUltimoRatinaleGravdo = idUltimoRatinaleGravdo;
    }

    public String getMsgNotesVazia() {
        return msgNotesVazia;
    }

    public void setMsgNotesVazia(String msgNotesVazia) {
        this.msgNotesVazia = msgNotesVazia;
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

}// ULTIMA
