package br.com.ufjf.control;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import br.com.ufjf.model.main.Adminuser;
import java.io.Serializable;

/**
 * Classe AdminuserDM
 *
 * @category control
 * @author magnus, anrafel, jonathan
 *
 */
public class AdminuserDM extends ListDataModel<Adminuser> implements
        SelectableDataModel<Adminuser>, Serializable {

    private static final long serialVersionUID = 1L;

    public AdminuserDM() {
    }

    public AdminuserDM(List<Adminuser> data) {
        super(data);
    }

    @Override
    public Adminuser getRowData(String rowKey) {
        // In a real app, a more efficient way like a query by rowKey should be
        // implemented to deal with huge data

        @SuppressWarnings("unchecked")
        List<Adminuser> adminuser = ((List<Adminuser>) getWrappedData());

        for (Adminuser Adminuser : adminuser) {
            if (Adminuser.getNameScientist().equals(rowKey)) {
                return Adminuser;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Adminuser obj) {
        return obj.getNameScientist();
    }
}
