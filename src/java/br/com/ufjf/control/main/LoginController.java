package br.com.ufjf.control.main;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import br.com.ufjf.base.MetodoAuxiliar;
import br.com.ufjf.dao.ArtifactDAO;
import br.com.ufjf.dao.CommunicationDAO;
import br.com.ufjf.dao.UserDAO;
import br.com.ufjf.model.main.User;
import br.com.ufjf.util.Mensageiro;

/**
 * Classe LoginController controller system login
 *
 * @category control
 * @author magnus, anrafel, jonathan PerceptionBoxController
 * MessageAlertController ArtifactController
 */
public class LoginController implements Serializable {

    private static final long serialVersionUID = 1L;
    private PerceptionBoxController perceptionBoxController;
    private MessageAlertController messageAlertController;
    private ArtifactController artifactController;
    private UserDAO userDao;
    private CommunicationDAO communicationDAO;
    private ArtifactDAO artifactDao;
    private String login;
    private String senha;
    private String msgLogin;
    private String originalViewId;
    private User adminuser;
    private User pegaUser;
    private String mensagemErro;
    private boolean usuarioLogado;
    private String nameUpercase;
    private int idUserContext;
    private String nomeuser;
    private String figuraType;
    private String mostraMensagemGeral1;
    private boolean autorizaLogin;

    /**
     * constructor method
     */
    public LoginController() {

        this.messageAlertController = new MessageAlertController();
        this.perceptionBoxController = new PerceptionBoxController();
        this.artifactController = new ArtifactController();
        this.userDao = new UserDAO();
        this.communicationDAO = new CommunicationDAO();
        this.artifactDao = new ArtifactDAO();
        this.pegaUser = new User();
        this.usuarioLogado = false;
        this.autorizaLogin = false;
    }

    /*-X-X-X-X-X-X-X-X-X-X-XMETODOS DE LOGIN-X-X-X-X-X-X-X-X-X-X-X-X*/
    /*-X-X-X-X-X-X-X-X-X-X-XMETODOS DE LOGIN-X-X-X-X-X-X-X-X-X-X-X-X*/
    /*-X-X-X-X-X-X-X-X-X-X-XMETODOS DE LOGIN-X-X-X-X-X-X-X-X-X-X-X-X*/
    /**
     * Method verificaAdmin se o login e a senha conferem no banco
     *
     * @param String login, String senha
     * @return User
     *
     */
    private User verificaAdmin(String login, String senha) {
        User userLogin = new User();
        try {

            String query = "SELECT a FROM User a WHERE a.login = :login and a.password = :senha";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("login", login);
            String senhaCripto = MetodoAuxiliar.geraMD5(senha);
            params.put("senha", senhaCripto);
            userLogin = (User) userDao.pesqParam(query, params);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AcentralController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

        return userLogin;
    }

    /**
     * Method validaLogin usa o verificaAdmin(); e redireciona para proxima
     * pagina
     *
     * @return String
     */
    public String validaLogin() {// adminuser.getLogin()
         /* verifica se a senha vinda do view é
         igual a senha encontrada no banco de dados*/
        User a = verificaAdmin(pegaUser.getLogin(), pegaUser.getPassword());

        /* Se existe o usuario com a sua respectiva senha prossigo*/
        if (a != null) {
            /*Setando o usuario numa classe especifica para controllar a minha sessao*/
            IDContextController.setaUserOnContext(a);

            /*pegando o nome dop usuario*/
            nomeuser = a.getNameScientist();
            /*para permitir o acesso a pagina usuarioLogado deve ser true*/
            usuarioLogado = true;
            /* variavel global idUserContext preenchida*/
            idUserContext = a.getIdScientist();
            /*tornando o nome do user maiuscula*/
            nameUpercase = nomeuser.toUpperCase();
            /*permissao para mostrar mensagem se logado*/
            messageAlertController.setMsgDOLogadoViewTrue(true);
            //perceptionBoxController.setMostraPageViewII(true);
            /*toda logica para manipular artifacts nessa classe*/
            artifactController.listarArtefatoLogin();
            perceptionBoxController.buscaUsers();
            String idUserLogado = IDContextController.pegaIDcontextString();
            perceptionBoxController.buscalistAnrafelSQL06(idUserLogado);

            return "/definePage03ViewArtifact1";

        } else {
            Mensageiro.errorMsg("loginMsg");
        }

        return null;

    }

    /* metodo de Navegação */
    public String backToa3Home() {
        return "definePage02Home";
    }

    /**
     * Method logout() kill the session
     *
     * @return String
     */
    public String logout() {

        // MATO DODA A CESSÃO ABERTA NO LOGIN
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        Object session = externalContext.getSession(false);
        HttpSession httpSession = (HttpSession) session;
        httpSession.invalidate();

        return "/definePage02Home";
    }

    /*INICIO DOS GET AND SET*/
    /*INICIO DOS GET AND SET*/
    /*INICIO DOS GET AND SET*/
    public PerceptionBoxController getPerceptionBoxController() {
        return perceptionBoxController;
    }

    public void setPerceptionBoxController(PerceptionBoxController perceptionBoxController) {
        this.perceptionBoxController = perceptionBoxController;
    }

    public MessageAlertController getMessageAlertController() {
        return messageAlertController;
    }

    public void setMessageAlertController(MessageAlertController messageAlertController) {
        this.messageAlertController = messageAlertController;
    }

    public ArtifactController getArtifactController() {
        return artifactController;
    }

    public void setArtifactController(ArtifactController artifactController) {
        this.artifactController = artifactController;
    }

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public CommunicationDAO getCommunicationDAO() {
        return communicationDAO;
    }

    public void setCommunicationDAO(CommunicationDAO communicationDAO) {
        this.communicationDAO = communicationDAO;
    }

    public ArtifactDAO getArtifactDao() {
        return artifactDao;
    }

    public void setArtifactDao(ArtifactDAO artifactDao) {
        this.artifactDao = artifactDao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMsgLogin() {
        return msgLogin;
    }

    public void setMsgLogin(String msgLogin) {
        this.msgLogin = msgLogin;
    }

    public String getOriginalViewId() {
        return originalViewId;
    }

    public void setOriginalViewId(String originalViewId) {
        this.originalViewId = originalViewId;
    }

    public User getAdminuser() {
        return adminuser;
    }

    public void setAdminuser(User adminuser) {
        this.adminuser = adminuser;
    }

    public User getPegaUser() {
        return pegaUser;
    }

    public void setPegaUser(User pegaUser) {
        this.pegaUser = pegaUser;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    public boolean isUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(boolean usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public String getNameUpercase() {
        return nameUpercase;
    }

    public void setNameUpercase(String nameUpercase) {
        this.nameUpercase = nameUpercase;
    }

    public int getIdUserContext() {
        return idUserContext;
    }

    public void setIdUserContext(int idUserContext) {
        this.idUserContext = idUserContext;
    }

    public String getNomeuser() {
        return nomeuser;
    }

    public void setNomeuser(String nomeuser) {
        this.nomeuser = nomeuser;
    }

    public String getFiguraType() {
        return figuraType;
    }

    public void setFiguraType(String figuraType) {
        this.figuraType = figuraType;
    }

    public String getMostraMensagemGeral1() {
        return mostraMensagemGeral1;
    }

    public void setMostraMensagemGeral1(String mostraMensagemGeral1) {
        this.mostraMensagemGeral1 = mostraMensagemGeral1;
    }

    public boolean isAutorizaLogin() {
        return autorizaLogin;
    }

    public void setAutorizaLogin(boolean autorizaLogin) {
        this.autorizaLogin = autorizaLogin;
    }

}// ULTIMO
