package br.com.ufjf.dao;

import br.com.ufjf.idao.IArtifactDAO;
import br.com.ufjf.model.main.Artifact;
import br.com.ufjf.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Classe ArtifactDAO rules of access to database
 *
 * @category persistence
 * @author magnus, anrafel, jonathan
 *
 */
public class ArtifactDAO extends GenericDAO implements IArtifactDAO, Serializable {

    private static final long serialVersionUID = 1L;
    private Session session;

    public List<Artifact> todosArtifact() throws HibernateException {
        List<Artifact> objetos = null;
        Query query;

        try {
            session = (Session) FacesUtil.getRequestAttribute("session");
            query = session.createQuery("From Artifact");//hql
            objetos = (List<Artifact>) query.list();
        } catch (HibernateException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objetos;
    }

}//ultimo
