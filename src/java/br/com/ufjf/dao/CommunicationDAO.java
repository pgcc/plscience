package br.com.ufjf.dao;

import br.com.ufjf.idao.ICommunicationDAO;
import br.com.ufjf.model.main.Communication;
import br.com.ufjf.util.FacesUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Classe CommunicationDAO rules of access to database
 *
 * @category persistence
 * @author magnus, anrafel, jonathan
 *
 */
public class CommunicationDAO extends GenericDAO implements ICommunicationDAO, Serializable {

    private static final long serialVersionUID = 1L;

    private Session session;

    /**
     *
     * @param id
     * @return
     * @throws HibernateException
     */
    @Override
    public Communication pesquisarPorIdCommunication(int id) throws HibernateException {
        Communication objeto = null;

        try {
            session = (Session) FacesUtil.getRequestAttribute("session");
            objeto = (Communication) session.get(Communication.class, id);
        } catch (Exception ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return objeto;
    }

    
    
  
    
    
    
    
}// ultimo
