package br.com.ufjf.idao;

import br.com.ufjf.model.main.Communication;
import javax.enterprise.inject.Default;

/**
 * Classe CommunicationDAO rules of access to database
 *
 * @category persistence
 * @author magnus, anrafel, jonathan
 *
 */
@Default
public interface ICommunicationDAO extends IGenericDao{

    Communication pesquisarPorIdCommunication(int id);
    
}// ultimo
