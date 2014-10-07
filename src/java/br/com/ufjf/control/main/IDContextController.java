package br.com.ufjf.control.main;

import antlr.collections.Enumerator;
import br.com.ufjf.model.main.User;
import java.io.Serializable;
import java.util.Enumeration;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author magnus
 */
public  class IDContextController implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private static FacesContext facesContext;

    /**
     * Method seta User no context
     *
     * @param a
     */
    public static void setaUserOnContext(User a) {
        facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("currentUser", a);
    }
    
    
    
     /**
     * Method seta User no context
     *
     * @param a
     */
    public static void setaIdUltimoRatinaleGravdo(int a) {
        facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("IdUltimoRatinaleGravdo", a);
    }
    
    
    
    /**
     * Method seta PerceptionBoxController no context
     *
     * @param perceptionBoxController     
     */
    public static void setaPerceptionBoxControllerOnContext(PerceptionBoxController perceptionBoxController) {
        facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("percepBoxControl", perceptionBoxController);
    }
    
    
    /**
     * Method busca PerceptionBoxController no context
     *
     * @return        
     */
    public static PerceptionBoxController getPerceptionBoxControllerOnContext() {
        PerceptionBoxController perceptionBoxController;
        facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        perceptionBoxController = (PerceptionBoxController) session.getAttribute("percepBoxControl");

        return perceptionBoxController;
    }
    
    

    /**
     * Method pegaIDcontext recovers idUser logged
     *
     * @return
     */
    public static int pegaIDcontext() {
        int idUserContext;
        facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        User a;
        a = (User) session.getAttribute("currentUser");
        idUserContext = a.getIdScientist();
        return idUserContext;
    }
    
    
    /**
     * Method pegaIDcontext recovers idUser logged
     *
     * @return
     */
    public static int pegaIdUltimoRatinaleGravdo() {
        int IdUltimoRatinaleGravdo;
        facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        
        
        String[] x  =  session.getValueNames();
        boolean temsim = false;
        for (String x1 : x) {
            if (x1.equals("IdUltimoRatinaleGravdo")) {
                temsim = true;
            }
        }
       
         if(temsim == true){
              IdUltimoRatinaleGravdo = (Integer) session.getAttribute("IdUltimoRatinaleGravdo");           
        } else{
             IdUltimoRatinaleGravdo = 1;
         }
        return IdUltimoRatinaleGravdo;
    }
    
    
    
    
    /**
     * Method pegaIDcontext recovers idUser logged
     *
     * @return
     */
    public static String pegaIDcontextString() {
        int idUserContext;
        facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        User a;
        a = (User) session.getAttribute("currentUser");
        idUserContext = a.getIdScientist();
        String retorna = String.valueOf(idUserContext);
        return retorna;
    }

    public static FacesContext getFacesContext() {
        return facesContext;
    }

    public static void setFacesContext(FacesContext facesContext) {
        IDContextController.facesContext = facesContext;
    }

   

}//ultima
