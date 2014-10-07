package br.com.ufjf.dao;

import br.com.ufjf.idao.IUserDAO;
import br.com.ufjf.model.main.User;
import br.com.ufjf.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Classe UserDAO rules of access to database
 *
 * @category persistence
 * @author magnus, anrafel, jonathan
 *
 */
public class UserDAO extends GenericDAO implements IUserDAO, Serializable {

    private static final long serialVersionUID = 1L;
    private Session session;

    @Override
    public List<User> todosUser() throws HibernateException {
        List<User> objetos = null;
        Query query;

        try {
            session = (Session) FacesUtil.getRequestAttribute("session");
            query = session.createQuery("From User");//hql
            objetos = (List<User>) query.list();
        } catch (HibernateException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objetos;
    }
    
 
      
    @Override
    public User pesquisarPorIdUser(int id) throws HibernateException {
        User objeto = null;
        try {
            session = (Session) FacesUtil.getRequestAttribute("session");
            objeto = (User) session.get(User.class, id);
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objeto;
    }

}// ultima
