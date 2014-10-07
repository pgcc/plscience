package br.com.ufjf.util;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Class Mensageiro control message Agora criaremos um arquivo chamado
 * “messages.properties” dentro da raiz da aplicação, onde poderemos definir as
 * mensagens da nossa aplicação, bem como chaves para poder utiliza-las. O
 * conteúdo desse arquivo consiste em: chave = valor Exemplo: bdError = Erro ao
 * acessar banco de dados! Quando precisarmos utilizar nosso mensageiro, basta
 * usar:
 *
 * Mensageiro.errorMsg(“bdError”); E nossa classe irá procurar dentro do
 * messages.properties um valor que tenha como chave “bdError“, no nosso exemplo
 * ele adicionaria a mensagem “Erro ao acessar banco de dados!” ao nosso
 * contexto. Bem simples né?
 *
 * Bom, agora iremos entender a nossa classe mensageira: Primeiro nós temos o
 * objeto estático ResourceBundle que utilizaremos para efetuar as buscas das
 * mensagens através dos valores passado no arquivo messages.properties. Repare
 * que eu passo o nome do arquivo sem a extensão .properties e a localização
 * dele, no nosso caso utilizamos o método getViewRoot do FacesContext para
 * obter a localização. O interessante é que todas essas mensagens possuem
 * suporte a internacionalização, você pode definir dentro do
 * messages.properties mensagens personalizadas para cada locale, por isso
 * utilizamos o método getLocale. Os métodos: infoMsg e errorMsg são os
 * responsáveis pelas mensagens, recebem como parâmetro uma string, que será
 * utilizada como chave para encontrar o valor da mensagem. Na linha seguinte
 * ele faz com que a variável ‘msg‘ que antes possuía a chave receba como valor
 * a própria mensagem que é buscada através do método getString do objeto
 * ResourceBundle. Nas próximas linhas não tem muito o que explicar, crio o
 * objeto FacesMessage com a mensagem conseguida anteriormente, obtenho a
 * instancia do FacesContext e adiciona a mensagem. E fim, você está pronta p
 * usar o seu mensageiro.
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class Mensageiro implements Serializable{
 private static final long serialVersionUID = 1L;
    private static final ResourceBundle bundle = ResourceBundle.getBundle(
            "br.com.ufjf.bundle.messages", FacesContext.getCurrentInstance()
            .getViewRoot().getLocale());

    public static void errorMsg(String msg) {
        msg = bundle.getString(msg);
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg,
                msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("ERRO", fm);

    }

    public static void infoMsg(String msg) {
        msg = bundle.getString(msg);
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("INFO", fm);
    }

}
