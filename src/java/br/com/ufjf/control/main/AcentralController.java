package br.com.ufjf.control.main;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Classe AcentralController concentrates all the other classes in the same
 * scope control
 *
 * @category control
 * @author magnus, anrafel, jonathan
 *
 */
@ManagedBean(name = "central")
@SessionScoped
public class AcentralController implements Serializable {

    private static final long serialVersionUID = 1L;
    private AdminController adminController;
    private ArtifactController artifactController;
    private DevelopmentController development;
    private LoginController loginController;
    private MessageAlertController messageAlertController;
    private NavegaMenuController navegaMenu;
    private PerceptionBoxController perceptionBoxController;
    private UploadController uploadController;
    private NetworkController networkController;
    private SystematicLiteratureReviewController slrController;

    @PostConstruct
    public void iniciaOnjetos() {
        this.adminController = new AdminController();
        this.artifactController = new ArtifactController();
        this.development = new DevelopmentController();
        this.loginController = new LoginController();
        this.messageAlertController = new MessageAlertController();
        this.navegaMenu = new NavegaMenuController();
        this.perceptionBoxController = new PerceptionBoxController();
        this.uploadController = new UploadController();
        this.networkController = new NetworkController();
        this.setSlrController(new SystematicLiteratureReviewController());
    }

    /*
    IREI INSTANCIAR DENTRO DOS IRMÃOS
    PerceptionBoxController
    MessageAlertController
    ArtifactController
     */
    /* METODOS DE ACESSO PARA OS CONTROLES */
    /* INICIO DOS GET AND SET */
    /* INICIO DOS GET AND SET */
    public AdminController getAdminController() {
        return adminController;
    }

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    public ArtifactController getArtifactController() {
        return artifactController;
    }

    public void setArtifactController(ArtifactController artifactController) {
        this.artifactController = artifactController;
    }

    public DevelopmentController getDevelopment() {
        return development;
    }

    public void setDevelopment(DevelopmentController development) {
        this.development = development;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public MessageAlertController getMessageAlertController() {
        return messageAlertController;
    }

    public void setMessageAlertController(MessageAlertController messageAlertController) {
        this.messageAlertController = messageAlertController;
    }

    public NavegaMenuController getNavegaMenu() {
        return navegaMenu;
    }

    public void setNavegaMenu(NavegaMenuController navegaMenu) {
        this.navegaMenu = navegaMenu;
    }

    public PerceptionBoxController getPerceptionBoxController() {
        return perceptionBoxController;
    }

    public void setPerceptionBoxController(PerceptionBoxController perceptionBoxController) {
        this.perceptionBoxController = perceptionBoxController;
    }

    public UploadController getUploadController() {
        return uploadController;
    }

    public void setUploadController(UploadController uploadController) {
        this.uploadController = uploadController;
    }

    public NetworkController getNetworkController() {
        return networkController;
    }

    public void setNetworkController(NetworkController networkController) {
        this.networkController = networkController;
    }

    /**
     * @return the slrController
     */
    public SystematicLiteratureReviewController getSlrController() {
        return slrController;
    }

    /**
     * @param slrController the slrController to set
     */
    public void setSlrController(SystematicLiteratureReviewController slrController) {
        this.slrController = slrController;
    }
    
    
    

}// ULTIMO
