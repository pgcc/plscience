package br.com.ufjf.util;

import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ConverterObjeto implements Converter, Serializable{

     private static final long serialVersionUID = 1L;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {

        if (value != null) {
            return component.getAttributes().get(value);
        }
        return null;
    }

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        if (value != null && !"".equals(value)) {
            component.getAttributes().put(value.toString(), value);
            return value.toString();
        }
        return "";
    }
}
