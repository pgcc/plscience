package br.com.ufjf.Testes.owlapi.main;

import java.io.Serializable;
import java.util.ArrayList;

import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.ModelFactory;

/**
 * class TarefaAlgoritmo
 *
 * @author magnus, anrafel, jonathan
 *
 * Busca da ontologia a relação entre tarefa tipo de algoritmo usa-se da classe
 * MapTaskAlgorithm
 *
 */
public class TarefaAlgoritmo implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * bioinformatics_task:
     * 
     * aligning
     * -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     * --->global_aligning
     * -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     * ------>pairwise_global_aligning
     * -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     * ------>multiple_global_aligning
     * -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     * --->local_aligning
     * -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     * ------>pairwise_local_aligning
     * -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     * ------>multiple_local_aligning
     * -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     * 
     * assembly
     * -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     * base_calling
     * -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     * sequence_grouping
     * -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     * vector_masking
     * -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     * viewing_and_editing1
     * -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     * viewing_and_editing2
     * -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
     */
    public static void main(String[] args) {
        ArrayList<MapTaskAlgorithm> listMapa = new ArrayList<MapTaskAlgorithm>();
        listMapa = getTarefaAlgoritmo();

        for (MapTaskAlgorithm mk : listMapa) {
            System.out.print("Chave: " + mk.getTaskNameClass() + " = ");
            System.out.print("Valor: " + mk.getAlgorithmNameClass());
            System.out.print("\n");
        }

    }

    public static ArrayList<String> tarefaAlgoritmo() throws Exception {

        OntDocumentManager mgr = new OntDocumentManager();

        OntModelSpec s = new OntModelSpec(OntModelSpec.OWL_MEM);

        s.setDocumentManager(mgr);

        OntModel m = ModelFactory.createOntologyModel(s, null);

        m.read("http://plscience.superdignus.com/SequenceAligningOntologyv1b.owl");

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#> "
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                + "PREFIX pre0: <http://plscience.superdignus.com/SequenceAligningOntology#>"
                + "SELECT ?c ?i "
                + "WHERE { "
                + "?c rdfs:subClassOf ?r. "
                + "?r rdf:type owl:Restriction . "
                + "?r owl:onProperty <http://plscience.superdignus.com/SequenceAligningOntology#task_performed_by> . "
                + "?r owl:someValuesFrom ?i}";

        com.hp.hpl.jena.query.Query query = QueryFactory.create(queryString);

        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, m);

        try {
            ResultSet rs = qe.execSelect();

            // Armazena o resultado da Query SparQL
            ArrayList<QuerySolution> qs = new ArrayList<QuerySolution>();

            ArrayList<String> stringLine = new ArrayList<String>();

            while (rs.hasNext()) {
                QuerySolution sq = null;
                sq = rs.nextSolution();
                qs.add(sq);
                stringLine.add(sq.toString());

            }
            return stringLine;

        } finally {
            qe.close();
        }
    }

    public static ArrayList<MapTaskAlgorithm> getTarefaAlgoritmo() {
        ArrayList<MapTaskAlgorithm> listMapa = new ArrayList<MapTaskAlgorithm>();
        try {
            ArrayList<String> stringLine = new ArrayList<String>();

            stringLine = tarefaAlgoritmo();

            for (int i = 0; i < stringLine.size(); i++) {

                String a = stringLine.get(i);
                //System.out.println("VALOR: " + a);
                String b = a.replace("( ?c = <http://plscience.superdignus.com/SequenceAligningOntology", "");
                // System.out.println("VALOR: " + b);
                String c = b.replace("( ?i = <http://plscience.superdignus.com/SequenceAligningOntology", "");
                //System.out.println("VALOR: " + c);
                String d = c.replace("> )", "");
				 //System.out.println("VALOR: " + d);
                //int e = d.indexOf("#");
                //System.out.println("VALOR: " + e);
                int f = d.indexOf(" #");
                //System.out.println("VALOR: " + f);
                String chave = d.substring(1, f);
                // System.out.println(chave);
                String chave1 = chave.trim();
                // System.out.println(chave1);
                String valor = d.substring(f + 2);
                // System.out.println(valor);
                String valor1 = valor.trim();
                // System.out.println(valor1);
                MapTaskAlgorithm mapa = new MapTaskAlgorithm();
                mapa.setTaskNameClass(chave1);
                mapa.setAlgorithmNameClass(valor1);
                listMapa.add(mapa);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            
        }

        return listMapa;
    }

}// ultima
