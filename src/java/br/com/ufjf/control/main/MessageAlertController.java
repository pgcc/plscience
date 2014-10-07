/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.control.main;

import br.com.ufjf.dao.CommunicationDAO;
import br.com.ufjf.dao.NotesDAO;
import br.com.ufjf.dao.UserDAO;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.PostConstruct;

/**
 *
 * @author magnus
 */
public class MessageAlertController implements Serializable{

    private static final long serialVersionUID = 1L;
    private UserDAO userDao; //
    private CommunicationDAO communicationDAO;
    private NotesDAO notesDAO;

    private Integer cont;
    private String nomeImagem;
    private boolean msgDOLogadoViewTrue;

    public MessageAlertController() {
        this.userDao = new UserDAO();
        this.communicationDAO = new CommunicationDAO();
        this.notesDAO = new NotesDAO();

        this.nomeImagem = "e-mail.png";
        this.cont = 0;
        this.msgDOLogadoViewTrue = false;
        
    }

    /**
     * Method messageAlert verifies the bank if there messages and modifies the
     * messages icon
     *
     */
    @PostConstruct
    public void messageAlert() {
       int idUserContext = IDContextController.pegaIDcontext();
        //System.out.println("VALOR-DE-idUserContext: " + idUserContext);
        
        String query ="SELECT COUNT(`idComunication`) FROM `Communication` WHERE (`idScientist_Receptor` = " + idUserContext + ") AND (`lidaSN` = 1)";
        BigInteger valor1;
        valor1 = (BigInteger) communicationDAO.PesqII(query);
        int valor = valor1.intValue();
        if (valor == 0) {
            cont = cont + 1;
            nomeImagem = "e-mail.png";
            //System.out.println(nomeImagem);
            //System.out.println("CONTADOR: " + cont);
        } else {
            cont = cont + 1;
            nomeImagem = "e-mail.gif";
            //System.out.println(nomeImagem);
            //System.out.println("CONTADOR: " + cont);
        }
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

    public NotesDAO getNotesDAO() {
        return notesDAO;
    }

    public void setNotesDAO(NotesDAO notesDAO) {
        this.notesDAO = notesDAO;
    }

    public Integer getCont() {
        return cont;
    }

    public void setCont(Integer cont) {
        this.cont = cont;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }


    public boolean isMsgDOLogadoViewTrue() {
        return msgDOLogadoViewTrue;
    }

    public void setMsgDOLogadoViewTrue(boolean msgDOLogadoViewTrue) {
        this.msgDOLogadoViewTrue = msgDOLogadoViewTrue;
    }

    
    
    
    
    
    
}//ultimo
