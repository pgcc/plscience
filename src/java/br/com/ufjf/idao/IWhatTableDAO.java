package br.com.ufjf.idao;

import br.com.ufjf.model.main.WhatTable;
import javax.enterprise.inject.Default;

/**
 * Classe WhatTableDAO rules of access to database
 *
 * @category persistence
 * @author magnus, anrafel, jonathan
 *
 */
@Default
public interface IWhatTableDAO extends IGenericDao{
   
    WhatTable pesquisarPorIdWhatTable(int id);
   
}// ultima

