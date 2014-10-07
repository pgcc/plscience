package br.com.ufjf.dao;

import br.com.ufjf.idao.IGenericDao;
import br.com.ufjf.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class GenericDAO implements IGenericDao, Serializable {

    private static final long serialVersionUID = 1L;
    private Session session;

    public Session getSession() throws Exception {
        if (session == null) {
            session = (Session) FacesUtil.getRequestAttribute("session");
        }
        return session;
    }

    @Override
    public boolean salvar(Object object) throws HibernateException {
        boolean retorno = false;
        if (object != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
                session.save(object);
                retorno = true;
            } catch (Exception ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("O Objeto enviado está vazio.");
        }
        return retorno;
    }

    @Override
    public boolean atualizar(Object object) throws HibernateException {
        boolean retorno = false;
        if (object != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
                session.update(object);
                retorno = true;
            } catch (Exception ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("O Objeto enviado está vazio.");
        }
        return retorno;
    }

    @Override
    public boolean saveOrUpdate(Object object) throws HibernateException {
        boolean retorno = false;
        if (object != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
            } catch (Exception ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.saveOrUpdate(object);
            retorno = true;
        } else {
            System.out.println("O Objeto enviado está vazio.");
        }
        return retorno;
    }

    @Override
    public Object pesquisarPorId(int id, Class classe) throws HibernateException {
        Object objeto = null;
        if (id >= 0 && classe != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
            } catch (Exception ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            objeto = (Object) session.get(classe.getSimpleName(), id);
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return objeto;
    }

    @Override
    public List<?> todos(Class classe) throws HibernateException {
        List<?> objetos = null;
        Query query;
        if (classe != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
            } catch (Exception ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            query = session.createQuery("FROM " + classe.getSimpleName());
            objetos = (List<?>) query.list();
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return objetos;
    }

    @Override
    public boolean excluir(Object object) throws HibernateException {
        boolean retorno = false;
        if (object != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
            } catch (Exception ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.delete(object);
            retorno = true;
        } else {
            System.out.println("O Objeto enviado está vazio.");
        }
        return retorno;
    }

    @Override
    public Object Pesq(String query) throws HibernateException {
        Object uno = null;
        Query query1;
        if (query != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
                query1 = session.createQuery(query);
                uno = (Object) query1.uniqueResult();
            } catch (HibernateException ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return uno;
    }

    @Override
    public Object PesqII(String query) throws HibernateException {
        Object uno = null;
        Query query1;
        if (query != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
                query1 = session.createSQLQuery(query);
                uno = (Object) query1.uniqueResult();
            } catch (HibernateException ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return uno;
    }

    @Override
    public Boolean insertGeneric(String query) throws HibernateException {
        Boolean uno = null;
        Query query1;
        if (query != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
                query1 = session.createSQLQuery(query);
                uno = true;
            } catch (Exception ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return uno;
    }

    @Override
    public List<?> listPesq(String query) throws HibernateException {
        List<?> objetos = null;
        Query query1;
        if (query != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
                query1 = session.createQuery(query);
                objetos = (List<?>) query1.list();
            } catch (HibernateException ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return objetos;
    }

    @Override
    public List<?> listPesqII(String query) throws HibernateException {
        List<?> objetos = null;
        Query query1;
        if (query != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
                query1 = session.createSQLQuery(query);
                objetos = (List<?>) query1.list();
            } catch (HibernateException ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return objetos;
    }

    @Override
    public Object pesqParam(String query, Map<String, Object> params) throws HibernateException {
        Object uno = null;
        Query q;
        if (query != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
                q = (Query) session.createQuery(query);

                for (String chave : params.keySet()) {
                    q.setParameter(chave, params.get(chave));
                }
                uno = (Object) q.uniqueResult();
            } catch (HibernateException ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return uno;
    }

    @Override
    public Object pesqParamII(String query, Map<String, Object> params) throws HibernateException {
        Object uno = null;
        Query q;
        if (query != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
            } catch (Exception ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            q = (Query) session.createSQLQuery(query);
            for (String chave : params.keySet()) {
                q.setParameter(chave, params.get(chave));
            }
            uno = (Object) q.uniqueResult();
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return uno;
    }

    @Override
    public List<?> listPesqParam(String query, Map<String, Object> params) throws HibernateException {
        List<?> objetos = null;
        Query q;
        if (query != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
                q = (Query) session.createQuery(query);
                for (String chave : params.keySet()) {
                    q.setParameter(chave, params.get(chave));
                }
                objetos = (List<?>) q.list();
            } catch (HibernateException ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return objetos;
    }

    @Override
    public List<?> listPesqParamII(String query, Map<String, Object> params) throws HibernateException {
        List<?> objetos = null;
        Query q;
        if (query != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
                q = (Query) session.createSQLQuery(query);
                for (String chave : params.keySet()) {
                    q.setParameter(chave, params.get(chave));
                }
                objetos = (List<?>) q.list();
            } catch (HibernateException ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return objetos;
    }

    /**
     *
     * @param query
     * @return
     * @throws HibernateException
     */
    @Override
    public int pegaUltimoGravado(String query) throws HibernateException {
        int ultimo = 0;
        Query query1;
        if (query != null) {
            try {
                session = (Session) FacesUtil.getRequestAttribute("session");
                query1 = session.createQuery(query);
                ultimo = (Integer) query1.uniqueResult();
            } catch (HibernateException ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("O ID ou a Classe enviada está nula.");
        }
        return ultimo;
    }

}
