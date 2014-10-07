package br.com.ufjf.idao;

import br.com.ufjf.model.AnrafelSQL06;
import br.com.ufjf.model.AnrafelSQL07;
import java.util.List;
import javax.enterprise.inject.Default;

/**
 *
 * @author magnus
 */
@Default
public interface IJDBCControllerDAO extends IGenericDao{

    
     Object PesqSQL(String query);
     List<?> listPesqSQL(String query);
     List<AnrafelSQL07> listPesqSQLEx(String query);
     List<AnrafelSQL06> listPesqSQL06(String query);
     List<AnrafelSQL07> listPesqSQL07(String query);
    
}
