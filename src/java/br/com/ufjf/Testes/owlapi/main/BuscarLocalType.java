package br.com.ufjf.Testes.owlapi.main;

import java.io.Serializable;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.ConsoleProgressMonitor;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

/**
 * class BuscarLocalType
 *
 * @author magnus, anrafel, jonathan
 *
 *
 * Possui dois metodos que busna na ontologia o local (url) do algoritmo e o seu
 * tipo é usado na classe MainGabriellaII
 *
 */
public class BuscarLocalType implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        try {
            String local = buscaLocal("runPhredService");
           // System.out.println("LOCAL: " + local);

            String tipo = buscaType("runPhredService");
           // System.out.println("TIPO: " + tipo);

        } catch (OWLOntologyCreationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * buscaLocal
     */
    public static String buscaLocal(String individuo)
            throws OWLOntologyCreationException {

        String local = "";
        String DOCUMENT_IRI = "http://plscience.superdignus.com/SequenceAligningOntologyv1b.owl";
        // Create our ontology manager in the usual way.
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		// Load a copy of the people+pets ontology. We'll load the ontology from
        // the web (it's acutally located in the TONES ontology repository).
        IRI docIRI = IRI.create(DOCUMENT_IRI);
        // We load the ontology from a document - our IRI points to it directly
        OWLOntology ont = manager.loadOntologyFromOntologyDocument(docIRI);
       // System.out.println("Loaded " + ont.getOntologyID());

        OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();

        ConsoleProgressMonitor progressMonitor = new ConsoleProgressMonitor();

        OWLReasonerConfiguration config = new SimpleConfiguration(
                progressMonitor);

        OWLReasoner reasoner = reasonerFactory.createReasoner(ont, config);

        reasoner.precomputeInferences();

        OWLDataFactory fac = manager.getOWLDataFactory();

        OWLNamedIndividual nomeIndividual = fac
                .getOWLNamedIndividual(IRI
                        .create("http://plscience.superdignus.com/SequenceAligningOntology#"
                                + individuo));
        OWLDataProperty hasLocation = fac
                .getOWLDataProperty(IRI
                        .create("http://plscience.superdignus.com/SequenceAligningOntology#hasLocation"));
        Set<OWLLiteral> petValuesNodeSet = reasoner.getDataPropertyValues(
                nomeIndividual, hasLocation);
        // System.out.println("Propriedades:");
        for (OWLLiteral ind : petValuesNodeSet) {
            // System.out.println("Local:: " + ind.getLiteral());
            local = ind.getLiteral();
        }

        return local;
    }

    /**
     * buscaType
     */
    public static String buscaType(String individuo)
            throws OWLOntologyCreationException {

        String tipo = "";
        String DOCUMENT_IRI = "http://plscience.superdignus.com/SequenceAligningOntologyv1b.owl";
        // Create our ontology manager in the usual way.
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		// Load a copy of the people+pets ontology. We'll load the ontology from
        // the web (it's acutally located in the TONES ontology repository).
        IRI docIRI = IRI.create(DOCUMENT_IRI);
        // We load the ontology from a document - our IRI points to it directly
        OWLOntology ont = manager.loadOntologyFromOntologyDocument(docIRI);
        //System.out.println("Loaded " + ont.getOntologyID());

        OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();

        ConsoleProgressMonitor progressMonitor = new ConsoleProgressMonitor();

        OWLReasonerConfiguration config = new SimpleConfiguration(
                progressMonitor);

        OWLReasoner reasoner = reasonerFactory.createReasoner(ont, config);

        reasoner.precomputeInferences();

        OWLDataFactory fac = manager.getOWLDataFactory();

        OWLNamedIndividual nomeIndividual = fac
                .getOWLNamedIndividual(IRI
                        .create("http://plscience.superdignus.com/SequenceAligningOntology#"
                                + individuo));
        OWLDataProperty type = fac
                .getOWLDataProperty(IRI
                        .create("http://plscience.superdignus.com/SequenceAligningOntology#type"));
        Set<OWLLiteral> petValuesNodeSet = reasoner.getDataPropertyValues(
                nomeIndividual, type);
        // System.out.println("Propriedades:");
        for (OWLLiteral ind : petValuesNodeSet) {
            // System.out.println("Type: " + ind.getLiteral());
            tipo = ind.getLiteral();
        }

        return tipo;
    }

}// end
