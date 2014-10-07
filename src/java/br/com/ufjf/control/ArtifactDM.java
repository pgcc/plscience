package br.com.ufjf.control;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import br.com.ufjf.model.main.Artifact;
import java.io.Serializable;

/**
 * Classe ArtifactDM
 *
 * @category control
 * @author magnus, anrafel, jonathan
 *
 */
public class ArtifactDM extends ListDataModel<Artifact> implements
        SelectableDataModel<Artifact>, Serializable {

    private static final long serialVersionUID = 1L;

    public ArtifactDM() {
    }

    public ArtifactDM(List<Artifact> data) {
        super(data);
    }

    @Override
    public Artifact getRowData(String rowKey) {
        // In a real app, a more efficient way like a query by rowKey should be
        // implemented to deal with huge data

        @SuppressWarnings("unchecked")
        List<Artifact> Artifacts = ((List<Artifact>) getWrappedData());

        for (Artifact Artifact : Artifacts) {
            if (Artifact.getName().equals(rowKey)) {
                return Artifact;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Artifact obj) {
        return obj.getName();
    }
}
