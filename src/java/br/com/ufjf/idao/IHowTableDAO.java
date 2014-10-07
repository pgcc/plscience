package br.com.ufjf.idao;

import br.com.ufjf.model.main.HowTable;
import javax.enterprise.inject.Default;

/**
 * Classe HowTableDAO rules of access to database
 *
 * @category persistence
 * @author magnus, anrafel, jonathan
 *
 */
@Default
public interface IHowTableDAO extends IGenericDao {

    HowTable pesquisarPorIdHowTable(int id);

}// ultima
