package br.com.ufjf.control;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import java.io.Serializable;

/**
 * Classe ArtifactDM
 *
 * @category control
 * @author magnus, anrafel, jonathan
 *
 */
public class ArquivoIndexXMLDM extends ListDataModel<ArquivoIndexXML> implements
        SelectableDataModel<ArquivoIndexXML>, Serializable {

    private static final long serialVersionUID = 1L;

    public ArquivoIndexXMLDM() {
    }

    public ArquivoIndexXMLDM(List<ArquivoIndexXML> data) {
        super(data);
    }

    @Override
    public ArquivoIndexXML getRowData(String rowKey) {
        // In a real app, a more efficient way like a query by rowKey should be
        // implemented to deal with huge data

        @SuppressWarnings("unchecked")
        List<ArquivoIndexXML> arquivoIndexXMLss = ((List<ArquivoIndexXML>) getWrappedData());

        for (ArquivoIndexXML arquivoIndexXML : arquivoIndexXMLss) {
            if (arquivoIndexXML.getUrlArquivo().equals(rowKey)) {
                return arquivoIndexXML;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(ArquivoIndexXML obj) {
        return obj.getUrlArquivo();
    }
}
