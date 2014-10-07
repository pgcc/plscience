package br.com.ufjf.idao;

import br.com.ufjf.model.main.User;
import java.util.List;
import javax.enterprise.inject.Default;

/**
 * Classe UserDAO rules of access to database
 *
 * @category persistence
 * @author magnus, anrafel, jonathan
 *
 */
@Default
public interface IUserDAO extends IGenericDao{

     List<User> todosUser();
     User pesquisarPorIdUser(int id);
  
}// ultima
