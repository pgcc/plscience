package br.com.ufjf.dao;

import br.com.ufjf.idao.IJDBCControllerDAO;
import br.com.ufjf.model.AnrafelSQL06;
import br.com.ufjf.model.AnrafelSQL07;
import br.com.ufjf.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author magnus
 */
public  class JDBCControllerDAO extends GenericDAO implements IJDBCControllerDAO, Serializable {
private static final long serialVersionUID = 1L;
     private Session session;
    
    
     
     
     
     
    public Object PesqSQL(String query) throws HibernateException {
        Object uno = null;
        Query query1;
        if (query != null) {
            session = (Session) FacesUtil.getRequestAttribute("session");
            query1 = session.createSQLQuery(query);
            uno = (Object) query1.uniqueResult();
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return uno;
    }


    public List<?> listPesqSQL(String query) throws HibernateException {
        List<?> objetos = null;
        Query query1;
        if (query != null) {
            session = (Session) FacesUtil.getRequestAttribute("session");
            query1 = session.createSQLQuery(query);
            objetos = ( List<?>) query1.list();
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return objetos;
    }
    
    
    
    public List<AnrafelSQL07> listPesqSQLEx(String query) throws HibernateException {
        List<Object> objetos = null;
        List<AnrafelSQL07> retorno = null;
        Query query1;
        if (query != null) {
            session = (Session) FacesUtil.getRequestAttribute("session");
            query1 = session.createSQLQuery(query);
            objetos = ( List<Object>) query1.list();
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        
        for (int i = 0; i < objetos.size(); i++) {
            objetos.get(i).getClass().getSimpleName();
        }
        
        return retorno;
    }
    
    public List<AnrafelSQL06> listPesqSQL06(String query) throws HibernateException {
        List<AnrafelSQL06> objetos = null;
        Query query1;
        if (query != null) {
            session = (Session) FacesUtil.getRequestAttribute("session");
            query1 = session.createSQLQuery(query);
            objetos = ( List<AnrafelSQL06>) query1.list();
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return objetos;
    }
    
    
    
     public List<AnrafelSQL07> listPesqSQL07(String query) throws HibernateException {
        List<AnrafelSQL07> objetos = null;
        Query query1;
        if (query != null) {
            session = (Session) FacesUtil.getRequestAttribute("session");
            query1 = session.createSQLQuery(query)
                     .addScalar("idRationale")
                      .addScalar("NameScientist")
                      .addScalar("institutionScientist");
            objetos = ( List<AnrafelSQL07>) query1.list();
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return objetos;
    }
    
}
