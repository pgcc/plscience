package br.com.ufjf.dao;

import br.com.ufjf.idao.IWhatTableDAO;
import br.com.ufjf.model.main.WhatTable;
import br.com.ufjf.util.FacesUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe WhatTableDAO rules of access to database
 *
 * @category persistence
 * @author magnus, anrafel, jonathan
 *
 */
public class WhatTableDAO extends GenericDAO implements IWhatTableDAO, Serializable{
   
   private static final long serialVersionUID = 1L;
   
   
   private Session session;

 
   @Override
    public WhatTable pesquisarPorIdWhatTable(int id) throws HibernateException {
        WhatTable objeto = null;
        try {
            session = (Session) FacesUtil.getRequestAttribute("session");
            objeto = (WhatTable) session.get(WhatTable.class, id);
        } catch (Exception ex) {
            Logger.getLogger(WhatTableDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objeto;
    }
   
   
}// ultima

