package br.com.ufjf.control;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.com.ufjf.Testes.owlapi.main.AlgorithmsTask;
import java.io.Serializable;

public class AlgorithmsTaskDM extends ListDataModel<AlgorithmsTask> implements
        SelectableDataModel<AlgorithmsTask> , Serializable{
private static final long serialVersionUID = 1L;
    public AlgorithmsTaskDM() {
    }

    public AlgorithmsTaskDM(List<AlgorithmsTask> data) {
        super(data);
    }

    @Override
    public AlgorithmsTask getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
        // implemented to deal with huge data

        @SuppressWarnings("unchecked")
        List<AlgorithmsTask> Artifacts = ((List<AlgorithmsTask>) getWrappedData());

        for (AlgorithmsTask algorithmsTask : Artifacts) {
            if (algorithmsTask.getNameAlgorithm().equals(rowKey)) {
                return algorithmsTask;
            }
        }

        return null;
    }

    public Object getRowKey(AlgorithmsTask obj) {
        return obj.getNameAlgorithm();
    }

}
