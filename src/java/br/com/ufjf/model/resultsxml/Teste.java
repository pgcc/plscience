package br.com.ufjf.model.resultsxml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;

/**
 * Class Teste
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class Teste {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        String localUrlWindows = "C:\\Users\\Jonathan\\Documents\\resources\\teste.xml";
        String localUrlLinux = "/PL-Science/backup/teste.xml";

        /*
         Workflow workflow = (Workflow) unmarshalFromFile(Workflow.class, localUrlLinux);
		
         ArrayList<Process> processes = new ArrayList<Process>();
         processes = workflow.getProcess();
		
         Iterator<Process> it = processes.iterator();
		
         while(it.hasNext()){
         System.out.println("Process Name: " + it.next().getName());
         }*/
        Parameter parameter = new Parameter();
        Parameter parameter1 = new Parameter();

        parameter.setName("type");
        parameter.setValue("WebService");

        parameter1.setName("hasLocation");
        parameter1.setValue("http://www.biocatalogue.org/services/2290");

        ArrayList<Parameter> parameters = new ArrayList<Parameter>();

        parameters.add(parameter);
        parameters.add(parameter1);

        Process process = new Process();

        process.setName("INB-dev:genome.imim.es:runPhred");
        process.setId("Process_1");
        process.setParameter(parameters);

        ArrayList<Process> processes = new ArrayList<Process>();
        processes.add(process);

        ArrayList<Connection> connections = new ArrayList<Connection>();

        Workflow workflow = new Workflow();
        workflow.setProcess(processes);
        workflow.setConnection(connections);

        System.out.println(new Teste().marshal(workflow));
        marshalToFile(workflow, localUrlLinux);

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
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);

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

}// ULTIMO
