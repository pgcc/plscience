/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.Testes.owlapi.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.mindswap.pellet.jena.PelletReasonerFactory;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.impl.IndividualImpl;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.ValidityReport;

/**
 * class MainGabriella
 *
 * @author magnus, anrafel, jonathan
 *
 *
 * classe pega os individuos na ontologia preencho a classe AlgorithmsTask com
 * individuos local e typo dos algoritimos utiliza-se da classe BuscarLocalType
 *
 */
public class MainGabriellaII implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        ArrayList<AlgorithmsTask> x = new ArrayList<AlgorithmsTask>();
        x = getAlgorithms("PHRED");
        /*for (AlgorithmsTask b : x) {
            System.out.println("");
            System.out.println("Nome: " + b.getNameAlgorithm());
            System.out.println("Local: " + b.getLocal());
            System.out.println("Tipo: " + b.getType());
            System.out.println("");
        }*/
    }

    public static void usageWithOntModel() {
        //System.out.println("Results with OntModel");
        //System.out.println("---------------------");
       // System.out.println();

        // ontology that will be used
        String ont = "http://plscience.superdignus.com/SequenceAligningOntologyv1b.owl#";
        String ns = "/PL-Science/backup/onTimeOntology.owll#";

        // create an empty ontology model using Pellet spec
        OntModel model = ModelFactory
                .createOntologyModel(PelletReasonerFactory.THE_SPEC);

        // read the file
        model.read(ont);

        // print validation report
        ValidityReport report = model.validate();
        printIterator(report.getReports(), "Validation Results");

        // print superclasses using the utility function
        OntClass c = model.getOntClass(ns + "bioinformatics_algorithm");
        printIterator(c.listSuperClasses(),
                "All super classes of " + c.getLocalName());
        // OntClass provides function to print *only* the direct subclasses
        printIterator(c.listSuperClasses(true),
                "Direct superclasses of " + c.getLocalName());

       // System.out.println();
    }

    public static void printIterator(Iterator<?> i, String header) {
       // System.out.println(header);
        for (int c = 0; c < header.length(); c++) {
            System.out.print("=");
        }
        //System.out.println();

        if (i.hasNext()) {
            while (i.hasNext()) {
               // System.out.println(i.next());
            }
        } else {
           // System.out.println("<EMPTY>");
        }

        //System.out.println();
    }

    @SuppressWarnings({"rawtypes"})
    public static ArrayList<AlgorithmsTask> getAlgorithms(String busca) {

        ArrayList<AlgorithmsTask> listAgk = new ArrayList<AlgorithmsTask>();

        // ontology that will be used
        String ont = "http://plscience.superdignus.com/SequenceAligningOntologyv1b.owl";

        // create an empty ontology model using Pellet spec
        OntModel model = ModelFactory
                .createOntologyModel(PelletReasonerFactory.THE_SPEC);

        // read the file
        model.read(ont);

        // get the instances of a class
        OntClass Classe1 = model
                .getOntClass("http://plscience.superdignus.com/SequenceAligningOntology#"
                        + busca);

        // Iterator instances = Classe1.listInstances();
        Iterator instances = Classe1.listInstances();

        listAgk = printIteratorII(instances,
                "Indivíduos da Classe " + Classe1.getLocalName());

        return listAgk;

    }

    public static ArrayList<AlgorithmsTask> printIteratorII(Iterator<?> i,
            String header) {

        ArrayList<AlgorithmsTask> listAgk = new ArrayList<AlgorithmsTask>();
        String n = "";
        int n1 = 0;
        String n2 = "";
       // System.out.println(header);
        for (int c = 0; c < header.length(); c++) {
            System.out.print("=");
        }
       // System.out.println();

        if (i.hasNext()) {
            while (i.hasNext()) {
                AlgorithmsTask agk = new AlgorithmsTask();
                IndividualImpl a = (IndividualImpl) i.next();
                // System.out.println(a.getURI().toString());
                n = a.getURI().toString();
                n1 = n.indexOf("#");
                n2 = n.substring(n1 + 1);
                // System.out.println(n2);
                agk.setNameAlgorithm(n2);
                try {
                    String local = BuscarLocalType.buscaLocal(n2);
                    agk.setLocal(local);
                    String tipo = BuscarLocalType.buscaType(n2);
                    agk.setType(tipo);
                } catch (OWLOntologyCreationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                listAgk.add(agk);
            }

			// for (AlgorithmsTask z : listAgk) {
            // System.out.println(z.getNameAlgorithm());
            // }
        } else {
           // System.out.println("<EMPTY>");

           // System.out.println();
        }
        return listAgk;
    }

}// ultimo
