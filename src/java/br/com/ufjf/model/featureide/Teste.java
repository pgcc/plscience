package br.com.ufjf.model.featureide;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.*;
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

        String localUrlWindows = "C:\\Users\\Jonathan\\Documents\\resources\\model.xml";
        String localUrlLinux = "/PL-Science/backup/onTimeFeatureModel.xml";

        Plm c2 = (Plm) unmarshalFromFile(Plm.class, localUrlLinux);
        System.out.println("PLM Name: " + c2.getName());
        System.out.println("CanReuseInstance: " + c2.getCanReuseInstance());
        System.out.println("Size: " + c2.getElement().size());
        System.out.println("");

        ArrayList<Element> teste = c2.getElement();

        for (Iterator<Element> it = teste.iterator(); it.hasNext();) {
            Element c3 = it.next();
            System.out.println("Id: " + c3.getId());
            System.out.println("Type: " + c3.getType());
            System.out.println("Name: " + c3.getName());
            System.out.println("CanReuseInstance: " + c2.getCanReuseInstance());
            System.out.println("Optional: " + c3.getOptional());

            if (c3.getParentElement() != null) {
                System.out.println("Parent ID: " + c3.getParentElement().getId());
            } else {
                System.out.println("Parent ID: 0");
            }

            ArrayList<Child> teste2 = c3.getChildElements();
            System.out.print("Child ids: ");
            for (Iterator<Child> it2 = teste2.iterator(); it2.hasNext();) {
                Child c4 = it2.next();
                System.out.print(c4.getId() + "; ");
            }

            System.out.println("");
            System.out.println("");
        }

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
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, new StreamResult(out));
        } catch (PropertyException e) {
            //e.printStackTrace();
        } catch (JAXBException e) {
            //e.printStackTrace();
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
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, new StreamResult(out));

            writer = new FileWriter(fileName);
            marshaller.marshal(object, writer);
        } catch (PropertyException e) {
            //e.printStackTrace();
        } catch (JAXBException e) {
            //e.printStackTrace();
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
            //e.printStackTrace();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        return null;
    }

}//ULTIMO
