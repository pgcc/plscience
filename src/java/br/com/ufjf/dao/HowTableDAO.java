package br.com.ufjf.dao;

import br.com.ufjf.idao.IHowTableDAO;
import br.com.ufjf.model.main.HowTable;
import br.com.ufjf.util.FacesUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe HowTableDAO rules of access to database
 *
 * @category persistence
 * @author magnus, anrafel, jonathan
 *
 */
public class HowTableDAO extends GenericDAO implements IHowTableDAO, Serializable{
    
private static final long serialVersionUID = 1L;

 private Session session;

 
    public HowTable pesquisarPorIdHowTable(int id) throws HibernateException {
        HowTable objeto = null;
        try {
            session = (Session) FacesUtil.getRequestAttribute("session");
            objeto = (HowTable) session.get(HowTable.class, id);
        } catch (Exception ex) {
            Logger.getLogger(HowTableDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objeto;
    }

   
}// ultima
