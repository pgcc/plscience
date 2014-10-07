package br.com.ufjf.control.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.UploadedFile;
import br.com.ufjf.control.ArtifactDM;
import br.com.ufjf.dao.ArtifactDAO;
import br.com.ufjf.dao.UserDAO;
import br.com.ufjf.model.main.Artifact;
import br.com.ufjf.model.main.User;

/**
 * Classe UploadController
 *
 * @category control
 * @author magnus, anrafel, jonathan
 *
 */
public class UploadController implements Serializable {

    private static final long serialVersionUID = 1L;
    private UserDAO userDao;
    private ArtifactDAO artifactDao;
    private String name;
    private String purpose;
    private String local;
    private String status;
    private String type;
    private String artiName;
    private String artiPurpose;
    private UploadedFile file;
    private String destination;
    private ArrayList<Artifact> listaArtifacts;
    private ArtifactDM mediumArtifactModel;
    private List<Artifact> artifacts;
    private FacesContext facesContext;
    private int idUserContext;

    public UploadController() {
        this.status = "1";
        this.listaArtifacts = new ArrayList<Artifact>();
        this.userDao = new UserDAO();
        this.artifactDao = new ArtifactDAO();
        artifacts = new ArrayList<Artifact>();

    }

    /* pega o id quem logado */
    public void pegaIDcontext() {
        facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        User a;
        a = (User) session.getAttribute("currentUser");
        idUserContext = a.getIdScientist();
    }

    /*
     * NAVEGAÇÃO - BOTAO - uploadArtifact
     */
    public String uploadArtifact() {
        return "definePage06Upload";
    }

    /* navegação */
    public String viewLocal() {
        return "definePage07Localartifact";
    }

    /* navegação */
    public String viewWeb() {
        return "definePage08Webartifact";
    }

    // private UploadedFile file LOCAL;
    public String salvaArtifactLocal() {
        // Pega o parâmetro via request.
        if (file != null) {
            FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
                copyFile(this.getFile().getFileName(), this.getFile().getInputstream());
            } catch (IOException e) {
            }
        }

        String tipoArtifactLocal = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("tipoArtifactLocal");
        Artifact a = new Artifact();
        a.setName(name);
        a.setPurpose(purpose);
        a.setLocal(getLocal());
        a.setStatus(status);
        a.setType(type);
       // a.setArtifactType(tipoArtifactLocal);
        artifactDao.salvar(a);

        listaArtifacts.clear();
        listaArtifacts = new ArrayList<Artifact>();
         User x = new User();
        listaArtifacts = (ArrayList<Artifact>) artifactDao.todos(x.getClass());
        mediumArtifactModel = new ArtifactDM(listaArtifacts);

        return "definePage03ViewArtifact1";
    }

    public void copyFile(String fileName, InputStream in) {
        try {
            destination = "/PL-Science/backup/";
			//String destinatioII = "/home/magnus/Dropbox/workspacePL-Science/PL-SCIENCE-II/WebContent/resources/artifacts/";

            // write the inputStream to a FileOutputSteam
            OutputStream out = new FileOutputStream(new File(destination + fileName));
            //OutputStream out1 = new FileOutputStream(new File(destinatioII+ fileName));

            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();
			//out1.flush();
            //out1.close();

            String local1 = destination + fileName;
            // System.out.println(local);

            setLocal(local1);

        } catch (IOException e) {
            // System.out.println(e.getMessage());
        }
    }

    // salva artefato
    public String salvaArtifactWeb() {
        // Pega o parâmetro via request.
        String tipoArtifactWeb = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("tipoArtifactWeb");
        Artifact a = new Artifact();
        a.setName(name);
        a.setPurpose(purpose);
        a.setLocal(local);
        a.setStatus(status);
        a.setType(type);
       // a.setArtifactType(tipoArtifactWeb);

        artifactDao.salvar(a);
        artifacts = new ArrayList<Artifact>();
         User x = new User();
        listaArtifacts = (ArrayList<Artifact>) artifactDao.todos(x.getClass());

        return "definePage03ViewArtifact1";
    }

    public String buscaUserArtefact() {
        // Pega o parâmetro via request.
        String idScientist = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("id1");
        if (idScientist == null) {
            return null;
        }

        /*
         * System.out.println("idScientist:idScientist:idScientist: " +
         * idScientist);
         */
        return null;
    }

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Row State " + event.getVisibility(), "Model:"
                + ((User) event.getData()).getNameScientist());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /* INICIO DOS GET AND SET */
    /* INICIO DOS GET AND SET */
    /* INICIO DOS GET AND SET */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public int getIdUserContext() {
        return idUserContext;
    }

    public void setIdUserContext(int idUserContext) {
        this.idUserContext = idUserContext;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}// ULTIMO
