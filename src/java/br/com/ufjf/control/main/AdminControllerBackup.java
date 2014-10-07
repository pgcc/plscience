package br.com.ufjf.control.main;

import br.com.ufjf.base.MetodoAuxiliar;
import br.com.ufjf.control.JDBCController;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import br.com.ufjf.control.UserDM;
import br.com.ufjf.dao.AdminuserDAO;
import br.com.ufjf.dao.UserDAO;
import br.com.ufjf.model.main.Adminuser;
import br.com.ufjf.model.main.User;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;


/**
 * Classe AdminController
 *
 * @category control
 * @author magnus, anrafel, jonathan
 *
 */
public class AdminControllerBackup implements Serializable {

    private static final long serialVersionUID = 1L;
    private final AdminuserDAO adminuserDao;
    private final UserDAO userDAO;
   
    private String loginAdmin;
    private String senhaAdmin;
    private Adminuser pegaLoginSenha;
    private boolean usuarioLogado;
    private String nameUpercase;
    private FacesContext facesContext;
    private String nomeuser;
    private UserDM mediumUserModel;
    private User incluirUser;
    private User selectedUser;
    private ArrayList<User> users;
    private ArrayList<User> listUsers;
    private boolean mostraGravaNewUser;
    private String setaPageViewAdmin;
    private String ruleSelecionado;
    private static final Logger logger = Logger.getLogger(AdminControllerBackup.class.getName());
    private boolean skip;
    private boolean mostraEditUser;
    private int idScientist;
    private String nameScientist;
    private String cpfscientist;
    private String emailScientist;
    private String institutionScientist;
    private String Status;
    private String password;
    private String login;
    private String msgTask;
    private int statusUser;
    

    /*construtor*/
    public AdminControllerBackup() {
        this.userDAO = new UserDAO();
        this.adminuserDao = new AdminuserDAO();
        this.users = new ArrayList<User>();
        this.mostraGravaNewUser = false;
        this.incluirUser = new User();
        this.selectedUser = new User();
        this.mostraEditUser = false;
      
        this.listUsers = new ArrayList<User>();
        
    }

    /*-x-x-x-x-x-x-x-x-x-x-x-x-navegação-x-x-x-x-x-x-x-x-x-x-x-x-x-**/
   
       
    
    
    
     public  int pegaIDRoles() {
        facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        User a;
        a = (User) session.getAttribute("currentUser");
        int idRoleContext1;
        idRoleContext1 = a.getRole_id();

        return idRoleContext1;
    }
      public int pegaIDUserLogado() {
        facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        User a;
        a = (User) session.getAttribute("currentUser");
        int idUserContext1;
        idUserContext1 = a.getIdScientist();

        return idUserContext1;
    }
    
    
    
    public String administracao() {
         statusUser = pegaIDRoles();
         int idruleContex = pegaIDRoles();
        if (idruleContex != 2) {

            String query = "SELECT a FROM User ";
            users = (ArrayList<User>) userDAO.todosUser();

        } else {
          int userLogado =   pegaIDUserLogado();
          User us;
          us = (User) userDAO.pesquisarPorIdUser(userLogado);
          users.clear();
          users.add(us);
        }
        return "definePage16ViewAdmin";
    }
    
     public String seeUser() {
        mostraGravaNewUser = true;
        String idScientistX = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idScientist");
        if (idScientistX == null) {
            return null;
        }
        int idScientistInt = Integer.parseInt(idScientistX);
        User xr;
        xr = userDAO.pesquisarPorIdUser(idScientistInt);
        idScientist = xr.getIdScientist();
        nameScientist = xr.getNameScientist();
        cpfscientist = xr.getCpfscientist();
        emailScientist = xr.getEmailScientist();
        institutionScientist = xr.getInstitutionScientist();
        Status = xr.getStatus();
        password = xr.getPassword();
        login = xr.getLogin();
       
       
        ruleSelecionado = String.valueOf(xr.getRole_id());
        setaPageViewAdmin = "includePage7ViewBox09_2.xhtml";

        return null;
    }

    public String backLoginPrincipal() {
        return "definePage02Home";
    }

     public String excluirUser(){
         int idruleContex =  pegaIDRoles();
    if(idruleContex != 2){
        
    }else{
         msgTask = "Você não tem permissão para excluir usuários!";
        setaPageViewAdmin = "includePage7ViewBox09_3.xhtml";
    }
       return null;
   }

    public String viewEditPassword() {
        int idruleContex = pegaIDRoles();
        if (idruleContex != 2) {

            String query = "SELECT a FROM User ";
            users = (ArrayList<User>) userDAO.todosUser();

        } else {
          int userLogado =   pegaIDUserLogado();
          User us;
          us = (User) userDAO.pesquisarPorIdUser(userLogado);
          users.clear();
          users.add(us);
        }
        return "definePage16ViewAdminEditPassword.xhtml";
    }
     
    public String editUser() {
   int idruleContex =  pegaIDRoles();
    if(idruleContex != 2){
        /*Pega o parametro via request.*/
        String idScientistX = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idScientist");
        if (idScientistX == null) {
            return null;
        }
        int idScientistInt = Integer.parseInt(idScientistX);
        User xr;
        xr = userDAO.pesquisarPorIdUser(idScientistInt);
        mostraGravaNewUser = true;
        idScientist = xr.getIdScientist();
        nameScientist = xr.getNameScientist();
        cpfscientist = xr.getCpfscientist();
        emailScientist = xr.getEmailScientist();
        institutionScientist = xr.getInstitutionScientist();
        Status = xr.getStatus();
        setaPageViewAdmin = "includePage7ViewBox09_1.xhtml";
    }else{
        msgTask = "Você não tem permissão para editar usuários!";
        setaPageViewAdmin = "includePage7ViewBox09_3.xhtml";
    }
        return null;
    }

    
    public String editUserPassword(){
    int idruleContex =  pegaIDRoles();
    if(idruleContex != 2){
       
        
    }else{
         msgTask = "Você não tem permissão para editar password usuários! Somente a sua";
        setaPageViewAdmin = "includePage7ViewBox09_3.xhtml";
    }
    return null;
    }
    
    public String atualizarUser() {
        /*Pega o parametro via request.*/
        String idScientistX = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idScientist");
        if (idScientistX == null) {
            return null;
        }
        int idScientistInt = Integer.parseInt(idScientistX);
        User xr;
        xr = userDAO.pesquisarPorIdUser(idScientistInt);
        xr.setNameScientist(nameScientist);
        xr.setCpfscientist(cpfscientist);
        xr.setEmailScientist(emailScientist);
        xr.setInstitutionScientist(institutionScientist);
        xr.setStatus(Status);
        userDAO.atualizar(xr);

        mostraEditUser = true;
        mostraGravaNewUser = false;
        String query = "SELECT a FROM User ";
        users = (ArrayList<User>) userDAO.todosUser();

        // INSTANCIO O DATAMODEL E POR PARAMETRO PARSO O ARRAYLIST
        //mediumUserModel = new UserDM(users);
        return null;
    }

    public String viewGravaNewUser() {
     int idruleContex =  pegaIDRoles();
    if(idruleContex != 2){
        mostraGravaNewUser = true;
        mostraEditUser = false;
        setaPageViewAdmin = "includePage7ViewBox09.xhtml";
    }else{
        msgTask = "Você não tem permissão para incluir usuários!";
        setaPageViewAdmin = "includePage7ViewBox09_3.xhtml";
    }
        return null;
    }
    
   
    
    public String viewEditUser() {
    int idruleContex =  pegaIDRoles();
    if(idruleContex != 2){
        mostraEditUser = true;
        mostraGravaNewUser = false;
        String query = "SELECT a FROM User ";
        users = (ArrayList<User>) userDAO.todosUser();

        // INSTANCIO O DATAMODEL E POR PARAMETRO PARSO O ARRAYLIST
        mediumUserModel = new UserDM(users);
        //return null;
    }else{
         msgTask = "Você não tem permissão para incluir usuários!";
        setaPageViewAdmin = "includePage7ViewBox09_3.xhtml";
    }
        return null;
    }

    public String gravaNewUser() {
        try {
            String url44 = "SELECT A.`idScientist` FROM `User` A ORDER BY A.`idScientist` DESC LIMIT 1";
            String resp44 = "idScientist";
            int ultimoUSERGravadoANTES = JDBCController.buscaUltimoGravado(url44, resp44);
           // System.out.println("ultimoUSERGravadoANTES: " + ultimoUSERGravadoANTES);
            User b = new User();
            b.setNameScientist(incluirUser.getNameScientist());
           // System.out.println("getNameScientist " + incluirUser.getNameScientist());
            b.setCpfscientist(incluirUser.getCpfscientist());
            //System.out.println("getCpfscientist " + incluirUser.getCpfscientist());
            b.setEmailScientist(incluirUser.getEmailScientist());
           // System.out.println("getEmailScientist " + incluirUser.getEmailScientist());
            b.setInstitutionScientist(incluirUser.getInstitutionScientist().toUpperCase());
            //System.out.println("getInstitutionScientist " + incluirUser.getInstitutionScientist().toUpperCase());
            b.setLogin(incluirUser.getLogin());
           // System.out.println("getLogin " + incluirUser.getLogin());
            String senhaCripto = MetodoAuxiliar.geraMD5(incluirUser.getPassword());
           // System.out.println("senhaCripto " + senhaCripto);
            b.setPassword(senhaCripto);
            b.setStatus("1");
            b.setRole_id(Integer.parseInt(ruleSelecionado));
            userDAO.salvar(b);
            String url445 = "SELECT A.`idScientist` FROM `User` A ORDER BY A.`idScientist` DESC LIMIT 1";
            String resp445 = "idScientist";
            int ultimoUSERGravadoDEPOIS = JDBCController.buscaUltimoGravado(url445, resp445);
            int idDoUltimoGravado = ultimoUSERGravadoDEPOIS + 1;
            /*SOMAR MAIS UM POIS  O METODO BUSCAR 
             ULTIMO RETORNA VALOR DO BANCO ANTES DE UM COMMIT DA INSERÇÃO DO ULTIMO*/
           // System.out.println("ultimoUSERGravadoDEPOIS: " + ultimoUSERGravadoDEPOIS);
           

            incluirUser = null;
            mostraGravaNewUser = false;
            String query = "SELECT a FROM User ";
            ArrayList<User> u;
            u = (ArrayList<User>) userDAO.todosUser();

            users = (ArrayList<User>) MetodoAuxiliar.reverseList(u);
            // INSTANCIO O DATAMODEL E POR PARAMETRO PARSO O ARRAYLIST
           // mediumUserModel = new UserDM(users);

        } catch (NoSuchAlgorithmException ex) {
            java.util.logging.Logger.getLogger(AdminControllerBackup.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /*-x-x-x-x-x-x-x-x-x-x-x-x-navegação-x-x-x-x-x-x-x-x-x-x-x-x-x-**/

    /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
    /*-x-x-x-x-x-x-x-x-xCRUD-ADMINUSER-x-x-x-x-x-x-x-x*/
    /*-x-x-x-x-x-x-x-x-xCRUD-ADMINUSER-x-x-x-x-x-x-x-x*/
    /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
    public String getLoginAdmin() {
        return loginAdmin;
    }

    public void setLoginAdmin(String loginAdmin) {
        this.loginAdmin = loginAdmin;
    }

    public String getSenhaAdmin() {
        return senhaAdmin;
    }

    public void setSenhaAdmin(String senhaAdmin) {
        this.senhaAdmin = senhaAdmin;
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

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public String getNomeuser() {
        return nomeuser;
    }

    public void setNomeuser(String nomeuser) {
        this.nomeuser = nomeuser;
    }

    public Adminuser getPegaLoginSenha() {
        return pegaLoginSenha;
    }

    public void setPegaLoginSenha(Adminuser pegaLoginSenha) {
        this.pegaLoginSenha = pegaLoginSenha;
    }

    public UserDM getMediumUserModel() {
        return mediumUserModel;
    }

    public void setMediumUserModel(UserDM mediumUserModel) {
        this.mediumUserModel = mediumUserModel;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public boolean isMostraGravaNewUser() {
        return mostraGravaNewUser;
    }

    public void setMostraGravaNewUser(boolean mostraGravaNewUser) {
        this.mostraGravaNewUser = mostraGravaNewUser;
    }

    public String getSetaPageViewAdmin() {
        return setaPageViewAdmin;
    }

    public void setSetaPageViewAdmin(String setaPageViewAdmin) {
        this.setaPageViewAdmin = setaPageViewAdmin;
    }

    public User getIncluirUser() {
        return incluirUser;
    }

    public void setIncluirUser(User incluirUser) {
        this.incluirUser = incluirUser;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public String getRuleSelecionado() {
        return ruleSelecionado;
    }

    public void setRuleSelecionado(String ruleSelecionado) {
        this.ruleSelecionado = ruleSelecionado;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public boolean isMostraEditUser() {
        return mostraEditUser;
    }

    public void setMostraEditUser(boolean mostraEditUser) {
        this.mostraEditUser = mostraEditUser;
    }

    public String getNameScientist() {
        return nameScientist;
    }

    public void setNameScientist(String nameScientist) {
        this.nameScientist = nameScientist;
    }

    public String getCpfscientist() {
        return cpfscientist;
    }

    public void setCpfscientist(String cpfscientist) {
        this.cpfscientist = cpfscientist;
    }

    public String getEmailScientist() {
        return emailScientist;
    }

    public void setEmailScientist(String emailScientist) {
        this.emailScientist = emailScientist;
    }

    public String getInstitutionScientist() {
        return institutionScientist;
    }

    public void setInstitutionScientist(String institutionScientist) {
        this.institutionScientist = institutionScientist;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getIdScientist() {
        return idScientist;
    }

    public void setIdScientist(int idScientist) {
        this.idScientist = idScientist;
    }

    public ArrayList<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(ArrayList<User> listUsers) {
        this.listUsers = listUsers;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMsgTask() {
        return msgTask;
    }

    public void setMsgTask(String msgTask) {
        this.msgTask = msgTask;
    }

    public int getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(int statusUser) {
        this.statusUser = statusUser;
    }

    
}// ultimo
