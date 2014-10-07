package br.com.ufjf.Testes.owlapi.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import br.com.ufjf.base.MetodoAuxiliar;

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
 * class QueryComment
 *
 * @author magnus, anrafel, jonathan
 *
 * Busca da ontologia todos os comentarios utilisa-se da classe BuscaComentario
 *
 */
public class QueryComment implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        ArrayList<BuscaComentario> valor = new ArrayList<BuscaComentario>();
        valor = buscaComentarios();
        /* Imprimindo o O meu arraylist de */
        /*for (BuscaComentario b : valor) {
            System.out.println("\n");
            System.out.println("ChaveClasseReferencia: "
                    + b.getChaveClasseReferencia());
            System.out.println("ValorComment: " + b.getValorComment());
            System.out.println("Algoritmo: " + b.getAlgoritmo());
            System.out.println("PaiProximo: " + b.getPaiProximo());
            System.out.println("CommentSN: " + b.getCommentSN());
            System.out.println("Finaliza: " + b.getFinaliza());
            System.out.println("Tarefa: " + b.getTarefa());
            System.out.println("\n");
        }*/

    }

    public static ArrayList<String> getComments() throws Exception {

        OntDocumentManager mgr = new OntDocumentManager();
        OntModelSpec s = new OntModelSpec(OntModelSpec.OWL_MEM);
        // System.out.println("PASSEI AQUI-01!...");
        s.setDocumentManager(mgr);
        OntModel m = ModelFactory.createOntologyModel(s, null);
        m.read("http://plscience.superdignus.com/SequenceAligningOntologyv1b.owl");
		// System.out.println("PASSEI AQUI-02!...");
        // SPARQL Query - Get All restrictions from
        // className(pairwise_local_aligning) - 1ª Query do programa!!!
        // colocar className no lugar de 'pairwise'

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#> "
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                + "SELECT ?subject ?object "
                + "WHERE { ?subject rdfs:comment ?object }";

		// System.out.println("PASSEI AQUI-03!...");
        com.hp.hpl.jena.query.Query query = QueryFactory.create(queryString);

        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, m);
        // System.out.println("PASSEI AQUI-04!...");
        try {

            ResultSet rs = qe.execSelect();
			// System.out.println("PASSEI AQUI-05!...");

            // Armazena o resultado da Query SparQL
            ArrayList<QuerySolution> qs = new ArrayList<QuerySolution>();
            ArrayList<String> stringLine = new ArrayList<String>();
            while (rs.hasNext()) {
                QuerySolution sq = null;
                sq = rs.nextSolution();
                qs.add(sq);
                // System.out.println(sq.toString());
                stringLine.add(sq.toString());

            }
            return stringLine;

        } finally {
            qe.close();
        }
    }

    public static ArrayList<BuscaComentario> buscaComentarios() {
        ArrayList<String> stringLine = new ArrayList<String>();
        ArrayList<BuscaComentario> valor = new ArrayList<BuscaComentario>();
        ArrayList<BuscaComentario> valorFinal = new ArrayList<BuscaComentario>();
        try {

            /* Uso do método getComments(); que retorna um arrayList de Strings */
            stringLine = getComments();
            /* Iterator do do arrayList a cima stringLine */
            Iterator<String> it = stringLine.iterator();
            while (it.hasNext()) {
                String j = it.next();
                /*
                 * Processo de substrings e replaces para buscar os dados
                 * precisos
                 */
                // System.out.println("saida: "+j);
                String a = j
                        .replace(
                                "?subject = <http://plscience.superdignus.com/SequenceAligningOntology#",
                                "");
                /* Novamente o replace do java para limpar a string */
                String b = a.replace("object", "");
                /* Novamente o replace do java para limpar a string */
                String c = b.replace("? =", "");
                /*
                 * Busco na string em qual posição isto é um inteiro encontra-se
                 * o ")"
                 */
                int x = c.indexOf(")");
                /* Agora pego com o metodo substring da posição 1 ate x */
                /* Aqui trago o primeiro valor relevante */
                String pri = c.substring(1, x);
                /* remove as aspas da string de comentario */
                String semAspas = MetodoAuxiliar.elimina_aspas(pri);
                /*
                 * Setando o valor an minha classe que guarda chave (classe)
                 * avlor(comentario)
                 */
                BuscaComentario sc = new BuscaComentario();
                sc.setValorComment(semAspas);

                /*
                 * busco o segundo calor relevante a minha chave, ou seja a
                 * classe referente ao comentario
                 */
                String seg = c.substring(x + 1);
                /* Acabamento final na chave remove os parenteses "(" */
                String semParents1 = seg.replace("(", "");
                /* Acabamento final na chave remove os parenteses ")" */
                String semParents2 = semParents1.replace(")", "");
                /*
                 * Acabamento final na chave remove o sinal de Maior final do
                 * palavra ">"
                 */
                int v = semParents2.indexOf(">");
                /*
                 * Uso do indexof/substring para remover o sinal de Maior final
                 * do palavra ">"
                 */
                String sssd = semParents2.substring(0, v);
                /* set a chave na minha classe */
                String espc = sssd.trim();
                sc.setChaveClasseReferencia(espc);
                /* Adiciono A classe no meu arrayList */
                valor.add(sc);

            }

            /* Imprimindo o O meu arraylist de */
            for (int i = 0; i < valor.size(); i++) {
                BuscaComentario bct = new BuscaComentario();
                // System.out.println(" ");
                String tira = "";
                String msg1 = "";
                String msg2 = "";
                String msgEsp1 = "";
                String msgEsp2 = "";
                // System.out.println("Iteração: " + i);
                String total = valor.get(i).getValorComment();
                bct.setChaveClasseReferencia(valor.get(i)
                        .getChaveClasseReferencia());
                // System.out.println("ValorTotal: " + total);
                int ms0 = total.indexOf("#");
                // System.out.println("VALOR DO ms0: " + ms0);
                int ms1 = total.indexOf("&");
                // System.out.println("&: = " + ms1);
                int ms2 = total.indexOf("$");
                // System.out.println("$: = " + ms2);
                int ms3 = total.indexOf("@");
                // System.out.println("@: = " + ms3);
                int ms4 = total.indexOf("%");
                // System.out.println("@: = " + ms3);
                if (ms1 > 0) {// &
                    String msg0 = total.substring(0, ms1);
                    tira = msg0.replace("#", "");
                    if (ms0 > 0) {
                        bct.setCommentSN("#");
                    } else {
                        bct.setCommentSN("nao");
                    }

                    // System.out.println("Comentario: " + tira);
                    bct.setValorComment(tira);
                } else {
                    bct.setCommentSN("nao");
                    bct.setValorComment("not");
                }

                if (ms2 > 0) {// $
                    int x = ms2 + 1;
                    int y = x + 1;
                    msg1 = total.substring(x, y);
                    String fdr = msg1.replace("@", "");
                    String fdr2 = fdr.replace("%", "");
                    msgEsp1 = fdr2.trim();

					// System.out.println("900000Algoritmo: " + msgEsp1);
                    bct.setAlgoritmo(msgEsp1);
                } else {
                    bct.setAlgoritmo("N");
                }

                if ((ms1 > 0) & (ms2 > 0)) {// & a $
                    int x = ms1 + 1;
                    int z = ms2;
                    msg2 = total.substring(x, z);
                    msgEsp2 = msg2.trim();
                    // System.out.println("O PAI: " + msgEsp2);
                    bct.setPaiProximo(msgEsp2);
                } else {
                    bct.setPaiProximo("not");
                }

                if (ms3 > 0) {
                    bct.setFinaliza("@");
                } else {
                    bct.setFinaliza("not");
                }

                if (ms4 > 0) {
                    bct.setTarefa("%");
                } else {
                    bct.setTarefa("not");
                }

                valorFinal.add(bct);

				// System.out.println("Iteração: " + i);
                // System.out.println(" ");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return valorFinal;

    }

}// ultima
