package br.com.ufjf.control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;

import br.com.ufjf.base.MetodoAuxiliar;
import br.com.ufjf.model.ActionSystem;

/**
 * Classe JAXBController
 *
 * @category control
 * @author magnus, anrafel, jonathan
 *
 */
@ManagedBean
@SessionScoped
public class JAXBController implements Serializable {

    private static final long serialVersionUID = 1L;
    private String user;
    private String data;
    private String hora;
    private ArrayList<ActionSystem> listActionsSystem;
    private ActionSystem actionSystem;

    private String URL;

    public JAXBController() {
        this.listActionsSystem = new ArrayList<ActionSystem>();
        this.actionSystem = new ActionSystem();

    }

    public String getURL() {
        return URL;
    }

    public void setURL(String uRL) {
        URL = uRL;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public ArrayList<ActionSystem> getListActionsSystem() {
        return listActionsSystem;
    }

    public void setListActionsSystem(ArrayList<ActionSystem> listActionsSystem) {
        this.listActionsSystem = listActionsSystem;
    }

    public ActionSystem getActionSystem() {
        return actionSystem;
    }

    public void setActionSystem(ActionSystem actionSystem) {
        this.actionSystem = actionSystem;
    }

    public void setActionsSystemInListII(ActionSystem actionSystem) {

        this.listActionsSystem.add(actionSystem);
    }

    public String criarArquivo(String nome) {
        /*
         * / PARA RETORNAR O PATH REAL DA APLICAÇÃO ServletContext ctx =
         * (ServletContext)
         * FacesContext.getCurrentInstance().getExternalContext().getContext();
         * String deploymentDirectoryPath = ctx.getRealPath("/"); /(justamente o
         * caminho do diretório do deploy da aplicação) // O RETORNO(no meu
         * linux foi:) //-
         * "/home/magnus/glassfish-3.1.2.2/glassfish/domains/domain1/eclipseApps/PL-SCIENCE-II/"
         * // PARA RETORNAR O PATH REAL DA APLICAÇÃO
         */

        String aURlLinux = "/home/magnus/workspace/ANRAFEL/PL-SCIENCE-II/WebContent/resources/logSystem/";
        // String aURlWinds = "C://a-url-do-BYTE-QUE-EU-GOSTO-WINDOWS.";

        URL = aURlLinux + nome + ".xml";
        // CRIA O ARQUIVO NO DIRETORIO DA APLICAÇÃO
        MetodoAuxiliar.createFile(URL);

        return URL;
    }

    /**
     * Converte o objeto em uma String com estrutura XML.
     *
     * @param object objeto a ser convertido em XML.
     * @return String contendo a estrutura XML.
     */
    public String marshal(Object object) {
        final StringWriter out = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.marshal(object, new StreamResult(out));
        } catch (PropertyException e) {
            // e.printStackTrace();
        } catch (JAXBException e) {
            // e.printStackTrace();
        }
        return out.toString();
    }

    /**
     * Converte o objeto em uma estrutura XML. grava em arquivo
     *
     * @param object objeto a ser convertido em XML.
     * @param fileName nome do arquivo XML a ser gerado.
     * @return uma string com o conteudo do XML gerado.
     */
    @SuppressWarnings("finally")
    public static String marshalToFile(Object object, String fileName) {
        final StringWriter out = new StringWriter();
        Writer writer = null;
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.marshal(object, new StreamResult(out));

            writer = new FileWriter(fileName);
            marshaller.marshal(object, writer);
        } catch (PropertyException e) {
            // e.printStackTrace();
        } catch (JAXBException e) {
            // e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(JAXBController.class.getName()).log(Level.SEVERE, null,
                    ex);

        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                e.getMessage();
            }

            return out.toString();
        }
    }

    /**
     * Realiza a conversao (unmarshal) de um arquivo XML em um objeto do seu
     * tipo.
     *
     * @param clazz classe referente ao objeto a ser criado a partir do XML.
     * @param fileXml nome do arquivo XML a ser convertido em objeto.
     * @return novo objeto.
     */
    @SuppressWarnings("rawtypes")
    public static Object unmarshalFromFile(Class clazz, String fileXml) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(new FileInputStream(fileXml));
        } catch (JAXBException e) {
            // e.printStackTrace();
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
        }
        return null;
    }

}
