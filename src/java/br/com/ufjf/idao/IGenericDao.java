package br.com.ufjf.idao;

import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;

/**
 * interface IGenericDao rules of access to database signature of methods
 *
 * @author magnus, anrafel, jonathan
 *
 */
public interface IGenericDao {

    public boolean salvar(Object object) throws HibernateException;

    public boolean atualizar(Object object) throws HibernateException;

    public boolean saveOrUpdate(Object object) throws HibernateException;

    public Object pesquisarPorId(int id, Class classe) throws HibernateException;

    public List<?> todos(Class classe) throws HibernateException;

    public boolean excluir(Object object) throws HibernateException;

    /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x*/
    public Object Pesq(String query) throws HibernateException;

    public List<?> listPesq(String query) throws HibernateException;

    public Object pesqParam(String query, Map<String, Object> params) throws HibernateException;

    public List<?> listPesqParam(String query, Map<String, Object> params) throws HibernateException;

    public int pegaUltimoGravado(String query) throws HibernateException;

    public Object PesqII(String query);

    public Boolean insertGeneric(String query);

    public List<?> listPesqII(String query);

    public Object pesqParamII(String query, Map<String, Object> params);

    public List<?> listPesqParamII(String query, Map<String, Object> params);

}
