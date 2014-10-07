package br.com.ufjf.Testes.owlapi.main;

import java.io.Serializable;

/**
 * class BuscaComentario
 *
 * @author magnus, anrafel, jonathan
 *
 * auxilia classe QueryComment
 *
 */
public class BuscaComentario implements Serializable {

    private static final long serialVersionUID = 1L;
    private String chaveClasseReferencia;
    private String valorComment;
    private String paiProximo;
    private String algoritmo;
    private String commentSN;
    private String finaliza;
    private String tarefa;

    public String getChaveClasseReferencia() {
        return chaveClasseReferencia;
    }

    public void setChaveClasseReferencia(String chaveClasseReferencia) {
        this.chaveClasseReferencia = chaveClasseReferencia;
    }

    public String getValorComment() {
        return valorComment;
    }

    public void setValorComment(String valorComment) {
        this.valorComment = valorComment;
    }

    public String getPaiProximo() {
        return paiProximo;
    }

    public void setPaiProximo(String paiProximo) {
        this.paiProximo = paiProximo;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public String getCommentSN() {
        return commentSN;
    }

    public void setCommentSN(String commentSN) {
        this.commentSN = commentSN;
    }

    public String getFinaliza() {
        return finaliza;
    }

    public void setFinaliza(String finaliza) {
        this.finaliza = finaliza;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

}
