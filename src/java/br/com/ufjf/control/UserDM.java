package br.com.ufjf.control;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import br.com.ufjf.model.main.User;
import java.io.Serializable;

/**
 * Classe UserDM
 *
 * @category control
 * @author magnus, anrafel, jonathan
 *
 */
public class UserDM extends ListDataModel<User> implements
        SelectableDataModel<User>, Serializable {

    public UserDM() {
    }

    public UserDM(List<User> data) {
        super(data);
    }

    @Override
    public User getRowData(String rowKey) {
        // In a real app, a more efficient way like a query by rowKey should be
        // implemented to deal with huge data

        @SuppressWarnings("unchecked")
        List<User> user = ((List<User>) getWrappedData());

        for (User User : user) {
            if (User.getNameScientist().equals(rowKey)) {
                return User;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(User obj) {
        return obj.getNameScientist();
    }
}
