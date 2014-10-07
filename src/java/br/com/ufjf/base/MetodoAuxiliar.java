package br.com.ufjf.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class MetodoAuxiliar meeting of various methods commonly used multiple
 * applications
 *
 * @author MAGNUS
 *
 *
 *
 * && E ("logical AND") a && b retorna true se a e b forem ambos true. Senão
 * retorna false. Se a for false, b não é avaliada.
 *
 * & E ("boolean logical AND") a & b retorna true se a e b forem ambos true.
 * Senão retorna false. Ambas expressões a e b são sempre avaliadas.
 *
 * || OU ("logical OR") a || b retorna true se a ou b for true. Senão retorna
 * false. Se a for true, b não é avaliada.
 *
 * | OU ("boolean logical inclusive OR") a | b retorna true se a ou b for true.
 * Senão retorna false. Ambas expressões a e b são sempre avaliadas.
 *
 * ^ OU EXCLUSIVO ("boolean logical exclusive OR") a ^ b retorna true se a for
 * true e b for false ou vice-versa. Senão retorna false
 *
 * ! NÃO ("logical NOT") !a retorna true se a for false. Senão retorna false
 *
 *
 *
 *
 *
 */
public class MetodoAuxiliar {
    /* ATRIBUTO LE DO TIPO SCANNER RECEBE A ENTRADA DO TECLADO */

    private static Scanner le = new Scanner(System.in);
    private static int auxMenu = 0;
    private static String num1;
    private static String num2;

    /*-----------------------------------INICIO-------------------------------*/
    /*-----------------------------METODOS-DE-SORTEIO-------------------------*/
    /*----------------------------(01)-METODOS-DE-SORTEIO---------------------*/
    /*-----------------------------------INICIO-------------------------------*/
    /**
     * Method geraAleatorio
     *
     * @return int integer from 1 to 999
     *
     */
    public static int geraAleatorio() {
        int num = 1000 + (int) (6 * Math.random());
        return num;
    }

    public static void geraAleatorioVIEW() {
        System.out
                .println("Descrição: Gera um número aleatório de 4 digitos Ex. 1000 a 1999");
        System.out.println("@param:");
        System.out.println("@return: int");
        System.out.println("int j= " + geraAleatorio());
    }

    /**
     * Method sorteia
     *
     * @param String
     * @return integer from 1 to 999
     *
     */
    public static int sorteia() {
        ArrayList<Integer> sorteados = new ArrayList<Integer>();
        Random r = new Random();
        final int H = 999; // sorteia entre 1 e 1000
        final int L = 1;
        int result;
        do {
            result = r.nextInt(H + 1) + L;
        } while (!sorteados.add(new Integer(result)));
        return result;

    }

    public static void sorteiaVIEW() {
        System.out
                .println("Descrição: Sorteia um número aleatório com uso de metodo Random");
        System.out.println("@param:");
        System.out.println("@return: int");
        System.out.println("int j= " + sorteia());
    }

    /**
     * Method sorteiaParam
     *
     * @param String
     * @return integer from 1 to Param
     *
     */
    public static int sorteiaParam(int Param) {
        ArrayList<Integer> sorteados = new ArrayList<Integer>();
        Random r = new Random();
        final int H = Param; // sorteia entre 1 e Param
        final int L = 1;
        int result;
        do {
            result = r.nextInt(H + 1) + L;
        } while (!sorteados.add(new Integer(result)));
        return result;

    }

    public static void sorteiaParam_VIEW() {
        System.out
                .println("Descrição: Sorteia um número aleatório uso de metodo Random");
        System.out
                .println("@param:int Param:  esse parametro define o range(alcance) do sorteio");
        System.out.println("@return: int");
        System.out.println("Ex: param = 10 int j= " + sorteiaParam(10));
        System.out.println("");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("Agora tente você  digite um inteiro:");
            System.out
                    .println("Esse inteiro representa o Range, O alcance do nosso sorteio:");
            System.out.println("O exemplo anterior usamos 10 que tal 20...");
            String var = le.nextLine();
            dataCorreta = ehNumerico(var);
            if (dataCorreta == true) {
                int i = Integer.parseInt(var);
                System.out.println("Você digitou " + var);
                System.out
                        .println("O número sortiado foi = " + sorteiaParam(i));
                dataCorreta = true;
            } else {
                System.out.println("");
                System.out.println("Você digitou  " + var
                        + "  Digite um inteiro!");
                System.out.println("");
                dataCorreta = false;
            }
        }
    }

    /**
     * Method sorteiaParamBast
     *
     * @param String quantas posições
     * @return integer from 1 to Param
     *
     */
    public static int sorteiaParamBast(int Param) {
        ArrayList<Integer> sortear = new ArrayList<Integer>();
        for (int i = 0; i < Param; i++) {
            sortear.add(i);
        }
        for (int i = 0; i <= Param; i++) {
            Collections.shuffle(sortear);
        }
        int index = 0;
        int sorteado = sortear.get(index);
        return sorteado;
    }

    public static void sorteiaParamBast_VIEW() {
        System.out
                .println("Descrição: Sorteia um numero aleatorio uso de metodo Collections.shuffle");
        System.out
                .println("Descrição:Esse metodo Collections.shuffle embaralha um arrayList");
        System.out
                .println("@param:int Param:  esse parametro define o range(alcance) monta o arraylist");
        System.out.println("@return: int");
        System.out.println("Ex: param = 10 int j= " + sorteiaParamBast(10));
    }

    /**
     * Method GeraObservacao
     *
     *
     * @return void
     *
     */
    public static int sorteioAleatorioArraylist(List<Integer> globo) {
        int sortiado = 0;
        for (int i = 0; i < 4; i++) {
            /* Embaralha o globo */
            Collections.shuffle(globo);
        }
        sortiado = globo.get(0);
        // System.out.println(sortiado);
        return sortiado;
    }

    public static void sorteioAleatorioArraylist_VIEW() {
        System.out
                .println("Descrição: Sorteia um numero aleatorio uso de metodo Collections.shuffle");
        System.out
                .println("Descrição:Esse metodo Collections.shuffle embaralha um arrayList");
        System.out.println("@param: arraylist<Integer>");
        System.out.println("@return: int");
        List<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            al.add(i);
            System.out.println("Preenche arrayList.add(" + i + ")");
        }
        System.out.println("Ex: arrayList<10> = 10 int j= "
                + sorteioAleatorioArraylist(al));

        System.out.println("");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("Agora tente você  digite um inteiro:");
            System.out
                    .println("Esse inteiro representa o Range, O alcance do nosso sorteio:");
            System.out.println("O exemplo anterior usamos 10 que tal 20...");
            String var = le.nextLine();
            dataCorreta = ehNumerico(var);
            if (dataCorreta == true) {
                int Q = Integer.parseInt(var);
                List<Integer> al1 = new ArrayList<Integer>();
                for (int i = 0; i < Q; i++) {
                    al1.add(i);
                    System.out.println("Preenche arrayList.add(" + i + ")");
                }
                System.out.println("Ex: arrayList<Integer>de =  " + Q
                        + " Posições  = " + sorteioAleatorioArraylist(al1));
                dataCorreta = true;
            } else {
                System.out.println("");
                System.out.println("Você digitou  " + var
                        + "  Digite um inteiro!");
                System.out.println("");
                dataCorreta = false;
            }
        }

    }

    /*-----------------------------------FIM----------------------------------*/
    /*-----------------------------METODOS-DE-SORTEIO-------------------------*/
    /*----------------------------(01)-METODOS-DE-SORTEIO---------------------*/
    /*-----------------------------------FIM----------------------------------*/

    /*-----------------------------------INICIO-------------------------------*/
    /*----------------------METODOS-DE-MANIPULAÇÃO DE STRINGS-----------------*/
    /*--------------------(02)-METODOS-DE-MANIPULAÇÃO DE STRINGS--------------*/
    /*-----------------------------------INICIO-------------------------------*/
    /**
     * Method geraNomeCompletoAleatorio
     *
     *
     * @return string
     *
     */
    public static String geraNomeCompletoAleatorio() {
        /**
         * array de primeiro nomes
         */
        String primeiroNome[] = {"Alfredo ", "Edineide ", "Igor ", "Olga ",
            "Ubaldo ", "Anita ", "Ubaldo ", "Olivia ", "Inacio ",
            "Amelia ", "Baltazar ", "Carmen ", "Denzel ", "Fatima ",
            "Gustavo ", "Hortencia ", "Jaime ", "Karina ", "Luiz ",
            "Marlom ", "Natacha ", "Patricia ", "Quely ", "Rogerio ",
            "Selma ", "Tarcisio ", "Wagner ", "Vanessa ", "Xenia ",
            "Zenir "};
        /**
         * sorteio aleatorio usando metodo dessa mesma classe sorteiaParam
         */
        int nrAleatorio = sorteiaParam(26);
        /**
         * String com usando o vetor para pegar o nome aleatoramnte escolhido
         */
        String primeiro = primeiroNome[nrAleatorio];
        /**
         * array de segundo nomes
         */
        String nomeDoMeio[] = {"de Athaide ", "da Silva ", "da Ttrinda ",
            "de Souza ", "da Fonseca ", "de Mathias ", "da Costa ",
            "da Ribeira ", "de Souza ", "do Mello ", "da Barra ",
            "do Carmo ", "de Almeida ", "do Feitas ", "da Gotta ",
            "de Haroldo ", "de Juta ", "de kanolo ", "do Brasil ",
            "da Moca ", "do Frates ", "do Reino ", "de Quirolga ",
            "dos Reis ", "de Sobral ", "do Terpano ", "do Wegner ",
            "da Vanda ", "de Xerman ", "de Zaratrusta "};
        /**
         * sorteio aleatorio usando metodo dessa mesma classe sorteiaParam
         */
        int nrAleatorio1 = sorteiaParam(26);
        /**
         * String com usando o vetor para pegar o nome aleatoramnte escolhido
         */
        String nomeMeio = nomeDoMeio[nrAleatorio1];

        /**
         * array de ultimo nomes
         */
        String ultimoNome[] = {"Argemiro", "Carneiro", "Ribeiro",
            "Brasileiro", "Ramos", "Barbosa", "Guimaraes", "Altair",
            "Medeiros", "Franco", "Altamira", "Franz", "Prado", "Vieira",
            "Molhado", "Sakianno", "Figueredo", "Soares", "Guerra",
            "Alberto", "Padre", "Celeste", "Bittar", "Verissimo", "Severo",
            "Manfrine", "Salazart", "Soraia", "Feijo", "Morreno"};
        /**
         * sorteio aleatorio usando metodo dessa mesma classe sorteiaParam
         */
        int nrAleatorio2 = sorteiaParam(26);
        /**
         * String com usando o vetor para pegar o nome aleatoramnte escolhido
         */
        String ultimo = ultimoNome[nrAleatorio2];
        /**
         * StringBuffer para concatenar os tres nomes escolhidos
         */
        StringBuffer nameCompleto = new StringBuffer();
        nameCompleto.append(primeiro);
        nameCompleto.append(nomeMeio);
        nameCompleto.append(ultimo);

        String retorno = nameCompleto.toString();
        return retorno;
    }

    public static void geraNomeCompletoAleatorio_VIEW() {
        System.out
                .println("Descrição: Gera um nome completo sortiando numeros das posiçãoes de 3 arrays");
        System.out.println("com 30 nomes cada ");
        System.out.println("@param: - ");
        System.out.println("@return: String: com nome completo de 3 partes ");
        System.out.println("Ex: Nome = " + geraNomeCompletoAleatorio());
    }

    /**
     * Method GeraTelefone
     *
     *
     * @return void
     *
     */
    public static String GeraTelefone() {

        String telefone = null;
        String numeral[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int nrAleatorio;
        StringBuffer numTel = new StringBuffer();

        for (int i = 0; i <= 12; i++) {
            // escolhe uma posição de 0 a 7
            nrAleatorio = sorteiaParam(7);
            if (i == 0) {
                numTel.append("(");
            } else if (i == 1) {
                numTel.append(numeral[nrAleatorio]);
            } else if (i == 2) {
                numTel.append(numeral[nrAleatorio]);
            } else if (i == 3) {
                numTel.append(")");
            } else if (i == 4) {
                numTel.append(numeral[nrAleatorio]);
            } else if (i == 5) {
                numTel.append(numeral[nrAleatorio]);
            } else if (i == 6) {
                numTel.append(numeral[nrAleatorio]);
            } else if (i == 7) {
                numTel.append(numeral[nrAleatorio]);
            } else if (i == 8) {
                numTel.append("-");
            } else if (i == 9) {
                numTel.append(numeral[nrAleatorio]);
            } else if (i == 10) {
                numTel.append(numeral[nrAleatorio]);
            } else if (i == 11) {
                numTel.append(numeral[nrAleatorio]);
            } else if (i == 12) {
                numTel.append(numeral[nrAleatorio]);
            }

        }

        telefone = numTel.toString();

        // System.out.println(telefone);
        return telefone;
    }

    public static void GeraTelefone_VIEW() {
        System.out
                .println("Descrição: Gera um telefone completo sortiando numeros das posiçãoes de 1 arrays");
        System.out
                .println("com 10 posições String numeral[] = { 0,1,3,4,5,6,7,8,9 };");
        System.out.println("@param: - ");
        System.out.println("@return: String:");
        System.out.println("Ex: Telefone = " + GeraTelefone());

    }

    /**
     * Method GeraGmail
     *
     *
     * @return void
     *
     */
    public static String GeraGmail(String Nome) {
        String gmail = null;

        String primeiroNome = primeiroNome(Nome);
        StringBuffer email = new StringBuffer();

        email.append(primeiroNome);
        email.append("@gmail.com");

        gmail = email.toString().toLowerCase();

        // System.out.println(gmail);
        return gmail;
    }

    public static void GeraGmail_VIEW() {
        System.out
                .println("Descrição: Gera um email (@gmail.com) com o nome dados");
        System.out.println("o nome pode ser completo pego so o primeiro nome");
        System.out.println("@param: String nome que pode ser completo ");
        System.out.println("@return: String: Ex. magnus@gmail ");
        System.out.println("Ex: Email = "
                + GeraGmail(geraNomeCompletoAleatorio()));
    }

    /**
     * Method GeraObservacao
     *
     *
     * @return void
     *
     */
    public static String GeraObservacao() {
        String OBS = null;

        String observacao[] = {"Novo cliente", "Cliente em dia",
            "Cliente Exigente", "Telefone de Recado", "Tel casa Mae",
            "Cliente VIP", "Somente as Segundas", "Somente as Terças",
            "Somente as Quartas", "Somente as Quintas",
            "Somente as Sextas", "Horario comercial", "Parte da Manha",
            "Parte da Tarde", "Parte da Noite", "Cliente Satisfeito",
            "Usuario do Systema", "Não encontrado", " do Trabalho",
            "Ex-cliente", "Agente de Servicos", "Profissional",
            "Professor", "Estudante", " do Soares", "Prontuario",
            "Aniversarios", "Especial", "Comercial", "Preferencial"};

        int nrAleatorio1;
        nrAleatorio1 = sorteiaParam(25);// vogais
        OBS = observacao[nrAleatorio1];

        // System.out.println(OBS);
        return OBS;
    }

    public static void GeraObservacao_VIEW() {
        System.out.println("Descrição: Gera um texto qualquer de Observação");
        System.out
                .println("Sorteio um numero aleatorio que é a posição de um array com 30 posiçães");
        System.out.println("@param: -");
        System.out.println("@return: String: Ex. Somente as Quintas ");
        System.out.println("Ex: Observação: = " + GeraObservacao());

    }

    /**
     * Method retiraAspasHtml
     *
     * @param String
     * @return String without quotes
     *
     */
    public static String retiraAspasHtml(String input) {
        Pattern p = Pattern.compile("<.*?>");
        Matcher m = p.matcher(input);
        String semHtml = m.replaceAll("");
        String semAspas = semHtml.replaceAll("'", "");
        return semAspas;
    }

    /**
     * Method elimina_aspas
     *
     * @param String
     * @return String without quotes
     *
     */
    public static String elimina_aspas(String str) {
        String a = str.replaceAll("[\"\']", "");
        return a;
    }

    public static void elimina_aspas_View() {
        System.out
                .println("Descrição: Metodo elimina dotas as aspas simples e duplas");
        System.out.println("@param: String input  String com aspas)");
        System.out.println("@return: String: Sem aspas");
        String exemplo = "[\"ad's'f\"ha's\"shs'g'\"sh\"jj'j'j'mn\"m]";
        System.out.println("Ex: String com Aspas+ " + exemplo + ": = "
                + elimina_aspas(exemplo));
        System.out.println("Ex: String sem Aspas= " + elimina_aspas(exemplo));

        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("");
            System.out.println("Sua vez...");
            System.out
                    .println("Digite um texto com aspas: Ex kddl\"kjhlkj\"jgfjhg\"b'b'b'll'l");
            String var = le.nextLine();
            System.out.println("Você digitou: " + var);
            System.out.println("Sem aspas: " + elimina_aspas(var));
            dataCorreta = true;

        }

    }

    public static void retiraAspasHtml_VIEW() {
        System.out.println("Descrição: Retira espas de HTML");
        System.out.println("@param: String input  (HTML COM ASPAS)");
        System.out.println("@return: String: Ex. <'OI '0>KK'LL'LL''> ");
        System.out.println("Ex: HTML: = "
                + retiraAspasHtml("<'OI '0>KK'LL'LL''>"));

    }

    /**
     * Method removeSpaces enter a string to remove spaces
     *
     * @param String
     *
     * @return String
     *
     */
    public static String removeSpaces(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", false);
        String t = "";
        while (st.hasMoreElements()) {
            t += st.nextElement();
        }
        return t;
    }

    public static void removeSpaces_VIEW() {
        System.out.println("Descrição: Remove os ospaços de uma string");
        System.out
                .println("@param: String input    String que deseja retirar espaços ");
        System.out.println("@return: String:");

        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("Digite uma palavra, frase com espaços:");
            String var = le.nextLine();
            dataCorreta = verificaData(var);
            System.out.println("Vocẽ digitou = " + var);
            System.out.println("Sem espaços:" + removeSpaces(var));

            dataCorreta = true;
        }

    }

    /**
     * Method primeiroNome Full name string with spaces returns the first name
     *
     *
     *
     * @param nome
     * @return String
     *
     */
    public static String primeiroNome(String nome) {
        String primeiroNome = "";
        for (int i = 0; i < nome.length(); i++) {
            if ((i == 0) && (nome.substring(i, i + 1).equalsIgnoreCase(" "))) {
                System.out
                        .println("Erro: Nome digitado iniciado com tecla ESPAÇO.");
                break;
            } else if (!nome.substring(i, i + 1).equalsIgnoreCase(" ")) {
                primeiroNome += nome.substring(i, i + 1);
            } else {
                break;
            }

        }

        return primeiroNome;
    }

    public static void primeiroNome_VIEW() {
        System.out
                .println("Descrição: Recupera o primeiro nome de um nome com espaços");
        System.out.println("@param: String input    um nome completo ");
        System.out.println("@return: String:");
        System.out.println("Ex: Nome:  Magnus teixeira ribeiro  ");
        System.out.println("Ex: O primeiro nome = "
                + primeiroNome("Magnus teixeira ribeiro"));

    }

    /*-----------------------------------FIM----------------------------------*/
    /*----------------------METODOS-DE-MANIPULAÇÃO DE STRINGS-----------------*/
    /*--------------------(02)-METODOS-DE-MANIPULAÇÃO DE STRINGS--------------*/
    /*-----------------------------------FIM----------------------------------*/

    /*-----------------------------------INICIO--------------------------------*/
    /*--------------------(03)-METODOS-DE-MANIPULAÇÃO DE DATAS-I---------------*/
    /*--------------------(04)-METODOS-DE-MANIPULAÇÃO DE DATAS-II--------------*/
    /*-----------------------------------INICIO--------------------------------*/
    /**
     * Method formataData
     *
     * @param data
     * @return Date formated dd/MM/yyyy
     * @throws java.lang.Exception
     *
     */
    public static Date formataData(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date) formatter.parse(data);
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    public static void formataData_VIEW() {
        System.out
                .println("Descrição: Transfora uma string formatada em Data (type) dd/MM/yyyy");
        System.out.println("@param: String formatada dd/MM/yyyy");
        System.out.println("@return: Date: ");

        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("DIGITE UMA DATA CORRETA Ex: 06/03/1971");
            String var = le.nextLine();
            dataCorreta = verificaData(var);
            if (dataCorreta == true) {
                try {
                    System.out.println("Ex: Data String: " + var);
                    System.out.println("Ex: Date = " + formataData(var));
                } catch (Exception e) {
                    // TODO Auto-generated catch block

                }
                dataCorreta = true;
            }
        }

    }

    /**
     * Method formataDataString
     *
     * @param data
     * @return Date formated dd/MM/yyyy
     * @throws java.lang.Exception
     *
     */
    public static String formataDataString(Date data) throws Exception {
        if (data != null) {
        } else {
            return null;
        }
        String date;

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        date = formatter.format(data);

        return date;
    }

    private static void formataDataString_VIEW() {
        System.out
                .println("Descrição: Entre com uma data do tipo Date trnasforma numa string");
        System.out.println("@param: Date input ");
        System.out.println("@return: String: Data formatada ");
        System.out.println("Ex: Date: = Wed Nov 23 00:00:00 BRST 2089");
        Date h = new Date();
        try {
            System.out.println("Ex: Date: = " + h + "  Formatada: "
                    + formataDataString(h));
        } catch (Exception e) {
            // TODO Auto-generated catch block

        }

    }

    /**
     * Method verificaData if the date is valid
     *
     * @param texto
     * @return boolean
     *
     */
    public static boolean verificaData(String texto) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(texto);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    private static void verificaData_VIEW() {
        System.out.println("Descrição: Verifica se uma data é valida ou não");
        System.out.println("@param: String input  data s ser conferida");
        System.out.println("@return: boolean ");
        System.out.println(" ");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("DIGITE UMA DATA CORRETA Ex: 06/03/1971");
            String var = le.nextLine();
            dataCorreta = verificaData(var);
            if (dataCorreta == true) {
                System.out.println("Você digitou! " + var);
                System.out.println("Data válida " + dataCorreta);
                dataCorreta = true;
            } else {
                System.out.println("Você digitou! " + var);
                System.out.println("Data válida " + dataCorreta);
                dataCorreta = false;
            }

        }

    }

    /**
     * Method verificaHora if the Hora is format HH:mm
     *
     * @param texto
     * @return boolean
     *
     */
    public static boolean verificaHora(String texto) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setLenient(false);
        try {
            sdf.parse(texto);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    private static void verificaHora_VIEW() {
        System.out.println("Descrição: Verifica se uma data é valida ou não");
        System.out.println("@param: String input  data s ser conferida");
        System.out.println("@return: boolean ");
        System.out.println(" ");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("DIGITE UMA HORA CORRETA Ex: 10:00");
            String var = le.nextLine();
            dataCorreta = verificaHora(var);
            if (dataCorreta == true) {
                System.out.println("Você digitou! " + var);
                System.out.println("Hora válida " + dataCorreta);
                dataCorreta = true;
            } else {
                System.out.println("Você digitou! " + var);
                System.out.println("Hora válida " + dataCorreta);
                dataCorreta = false;
            }

        }

    }

    /**
     * Method getWeeksOfMonth method returns how many weeks months has
     *
     *
     *
     * @param month
     * @param year
     * @return Integer[]
     *
     */
    public static Integer[] getWeeksOfMonth(int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Set<Integer> weeks = new HashSet<Integer>();

        int ndays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < ndays; i++) {
            weeks.add(cal.get(Calendar.WEEK_OF_YEAR));
            cal.add(Calendar.DATE, 1);
        }
        for (Integer in : weeks) {
            System.out.println(in);
        }
        return weeks.toArray(new Integer[0]);

    }

    private static void getWeeksOfMonth_VIEW() {
        System.out.println("Descrição: Verifica se uma data é valida ou não");
        System.out.println("@param: String input  data s ser conferida");
        System.out.println("@return: boolean ");
        System.out.println("Mês: 10 - ano- 2013" + getWeeksOfMonth(10, 2013));
    }

    /**
     * Inner Class Datas internal helper class
     *
     *
     */
    class Datas {

        private int ano;
        private String datas;
        private String dia;
        private String mes;

        public int getAno() {
            return ano;
        }

        public void setAno(int ano) {
            this.ano = ano;
        }

        public String getDatas() {
            return datas;
        }

        public void setDatas(String datas) {
            this.datas = datas;
        }

        public String getDia() {
            return dia;
        }

        public void setDia(String dia) {
            this.dia = dia;
        }

        public String getMes() {
            return mes;
        }

        public void setMes(String mes) {
            this.mes = mes;
        }
    }

    /**
     * Inner Class MesesAno internal helper class
     *
     */
    class MesesAno {

        private int idMesesDoAno;
        private String mDoAno;

        public MesesAno() {
        }

        public MesesAno(int idMesesDoAno, String mDoAno) {
            this.idMesesDoAno = idMesesDoAno;
            this.mDoAno = mDoAno;
        }

        public int getIdMesesDoAno() {
            return idMesesDoAno;
        }

        public void setIdMesesDoAno(int idMesesDoAno) {
            this.idMesesDoAno = idMesesDoAno;
        }

        public String getmDoAno() {
            return mDoAno;
        }

        public void setmDoAno(String mDoAno) {
            this.mDoAno = mDoAno;
        }

    }

    /**
     * Method getDiasDeDeusTerQua method returns all dates whose weekdays are
     * weaves Tuesday and Wednesday
     *
     * @param mes
     * @param ano
     *
     * @return ArrayList<Datas>
     *
     */
    public static ArrayList<Datas> getDiasDeDeusTerQua(int mes, int ano) {

        Set<Integer> weeks = new HashSet<Integer>();
        ArrayList<Datas> datas = new ArrayList<Datas>();
        ArrayList<Datas> dataCorreta = new ArrayList<Datas>();

        Date T;
        GregorianCalendar calendar = new GregorianCalendar();
        Calendar data = new GregorianCalendar();
        Date hoje = data.getTime();
        int dia = 1;

        data.set(ano, mes, dia);

        int diaMaximo = data.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (dia = 1; dia <= diaMaximo; dia++) {
            data.set(Calendar.DAY_OF_MONTH, dia);
            int diaDaSemana = data.get(Calendar.DAY_OF_WEEK);
            if ((diaDaSemana == Calendar.TUESDAY)
                    || (diaDaSemana == Calendar.WEDNESDAY)) {// 1 = terça e 2 =
                // quarta
                T = data.getTime();
                if (hoje.before(T)) {// before = antes - after = depois
                    int diaDaSemanaE = data.get(Calendar.DAY_OF_WEEK);
                    String formato = "dd/MM/yyyy";
                    SimpleDateFormat formatter = new SimpleDateFormat(formato);
                    String dateRetorn = formatter.format(T);
                    /* COMO INSTANCIAR UMA CLASSE INTERNA */
                    MetodoAuxiliar mt = new MetodoAuxiliar();
                    Datas dts = mt.new Datas();
                    /* COMO INSTANCIAR UMA CLASSE INTERNA */
                    String g = getDiaDaSemana(diaDaSemana);
                    dts.setAno(ano);
                    dts.setDatas(dateRetorn);
                    dts.setDia(g);
                    String mesdoano = getMesesdoAno(mes);
                    dts.setMes(mesdoano);
                    datas.add(dts);
                }
            }
        }

        for (Datas dt : datas) {
            System.out
                    .println("-x-x-x-x-x-QUAIS-OS-DIAS-DA-SEMANA-TERÇA-E-QUARTA-x-x-x-x-x-x ");
            System.out.println(dt.getMes() + " DE " + dt.getAno());
            System.out.println(dt.getDia() + " DATA: " + dt.getDatas());
            System.out.println(" ");
        }

        return datas;
    }

    private static void getDiasDeDeusTerQua_VIEW() {
        System.out
                .println("Descrição: Retorna um array com todos as datas de Terça e Quarta de um determinado mes e ano");
        System.out.println("Apartir do Mês atual");
        System.out.println("@param: String Mes String ano");
        System.out.println("@return: String ");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("digite um inteiro para Mês de 1 a 12");
            String var = le.nextLine();
            dataCorreta = eNumericoEstaFaixaGeneric(var, 12);
            if (dataCorreta == true) {
                System.out
                        .println("digite um inteiro para Ano de ex: 1981 ou 2013");
                int c = Integer.parseInt(var);
                String var1 = le.nextLine();
                int varcontaux = c - 1;
                dataCorreta = eNumericoEstaFaixaGeneric(var, 2999);
                if (dataCorreta == true) {

                    int d = Integer.parseInt(var1);

                    ArrayList<Datas> datas = getDiasDeDeusTerQua(varcontaux, d);
                    System.out
                            .println("|-----------QUAIS-OS-DIAS-DA-SEMANA-TERÇA-E-QUARTA-----------|");
                    System.out.println(var + " DE " + var1);
                    for (Datas dt : datas) {
                        System.out.println(dt.getDia() + " DATA: "
                                + dt.getDatas());
                        System.out.println(" ");
                    }
                    dataCorreta = true;
                } else {
                    dataCorreta = false;
                }

            }
        }
    }

    /**
     * Method getDiasDeDeusTerQua method returns all dates whose weekdays are
     * weaves Wednesday and Thursday
     *
     *
     *
     * @param mes
     * @param ano
     * @return ArrayList<Datas>
     *
     */
    public static ArrayList<Datas> getDiasDeDeusQuaQui(int mes, int ano) {

        Set<Integer> weeks = new HashSet<Integer>();
        ArrayList<Datas> datas = new ArrayList<Datas>();
        ArrayList<Datas> dataCorreta = new ArrayList<Datas>();

        Date T = null;
        GregorianCalendar calendar = new GregorianCalendar();
        Calendar data = new GregorianCalendar();
        Date hoje = data.getTime();
        int dia = 1;

        data.set(ano, mes, dia);

        int diaMaximo = data.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (dia = 1; dia <= diaMaximo; dia++) {
            data.set(Calendar.DAY_OF_MONTH, dia);
            int diaDaSemana = data.get(Calendar.DAY_OF_WEEK);
            if ((diaDaSemana == Calendar.WEDNESDAY)
                    || (diaDaSemana == Calendar.THURSDAY)) {// 1 = terça e 2 =
                // quarta
                T = data.getTime();
                if (hoje.before(T)) {// before = antes - after = depois
                    int diaDaSemanaE = data.get(Calendar.DAY_OF_WEEK);
                    String formato = "dd/MM/yyyy";
                    SimpleDateFormat formatter = new SimpleDateFormat(formato);
                    String dateRetorn = formatter.format(T);
                    /* COMO INSTANCIAR UMA CLASSE INTERNA */
                    MetodoAuxiliar mt = new MetodoAuxiliar();
                    Datas dts = mt.new Datas();
                    /* COMO INSTANCIAR UMA CLASSE INTERNA */
                    String g = getDiaDaSemana(diaDaSemana);
                    dts.setAno(ano);
                    dts.setDatas(dateRetorn);
                    dts.setDia(g);
                    String mesdoano = getMesesdoAno(mes);
                    dts.setMes(mesdoano);
                    datas.add(dts);
                }
            }
        }

        for (Datas dt : datas) {
            System.out
                    .println("-x-x-x-x-x-QUAIS-OS-DIAS-DA-SEMANA-QUARTA-E-QUINTA-x-x-x-x-x-x ");
            System.out.println(dt.getMes() + " DE " + dt.getAno());
            System.out.println(dt.getDia() + " DATA: " + dt.getDatas());
            System.out.println(" ");
        }
        return datas;
    }

    private static void getDiasDeDeusQuaQui_VIEW() {
        System.out
                .println("Descrição: Retorna um array com todos as datas de Quarta e quintade um determinado mes e ano");
        System.out.println("Apartir do Mês atual");
        System.out.println("@param: String Mes String ano");
        System.out.println("@return: String ");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("digite um inteiro para Mês de 1 a 12");
            String var = le.nextLine();
            dataCorreta = eNumericoEstaFaixaGeneric(var, 12);
            if (dataCorreta == true) {
                System.out
                        .println("digite um inteiro para Ano de ex: 1981 ou 2013");
                int c = Integer.parseInt(var);
                String var1 = le.nextLine();
                int varcontaux = c - 1;
                dataCorreta = eNumericoEstaFaixaGeneric(var, 2999);
                if (dataCorreta == true) {

                    int d = Integer.parseInt(var1);

                    ArrayList<Datas> datas = getDiasDeDeusQuaQui(varcontaux, d);
                    System.out
                            .println("|-----------QUAIS-OS-DIAS-DA-SEMANA-QUARTA-E-QUINTA---------|");
                    System.out.println(var + " DE " + var1);
                    for (Datas dt : datas) {
                        System.out.println(dt.getDia() + " DATA: "
                                + dt.getDatas());
                        System.out.println(" ");
                    }
                    dataCorreta = true;
                } else {
                    dataCorreta = false;
                }

            }
        }
    }

    /**
     * Method getDiasDeDeusTerQuaAnoSeguinte method returns all dates whose
     * weekdays are weaves Tuesday and Wednesday of the following year
     *
     * @param mes
     * @param ano
     *
     * @return ArrayList<Datas>
     *
     */
    @SuppressWarnings({"unused"})
    public static ArrayList<Datas> getDiasDeDeusTerQuaAnoSeguinte(int mes,
            int ano) {

        Set<Integer> weeks = new HashSet<Integer>();
        ArrayList<Datas> datas = new ArrayList<Datas>();
        ArrayList<Datas> dataCorreta = new ArrayList<Datas>();

        Date T;
        GregorianCalendar calendar = new GregorianCalendar();
        Calendar data = new GregorianCalendar();
        Date hoje = data.getTime();
        int dia = 1;

        data.set(ano, mes, dia);

        int diaMaximo = data.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (dia = 1; dia <= diaMaximo; dia++) {
            data.set(Calendar.DAY_OF_MONTH, dia);
            int diaDaSemana = data.get(Calendar.DAY_OF_WEEK);
            if ((diaDaSemana == Calendar.TUESDAY)
                    || (diaDaSemana == Calendar.WEDNESDAY)) {// 1 = terça e 2 =
                // quarta
                T = data.getTime();
                // if (hoje.after(T)) {//before = antes - after = depois
                int diaDaSemanaE = data.get(Calendar.DAY_OF_WEEK);
                String formato = "dd/MM/yyyy";
                SimpleDateFormat formatter = new SimpleDateFormat(formato);
                String dateRetorn = formatter.format(T);
                /* COMO INSTANCIAR UMA CLASSE INTERNA */
                MetodoAuxiliar mt = new MetodoAuxiliar();
                Datas dts = mt.new Datas();
                /* COMO INSTANCIAR UMA CLASSE INTERNA */
                String g = getDiaDaSemana(diaDaSemana);
                dts.setAno(ano);
                dts.setDatas(dateRetorn);
                dts.setDia(g);
                String mesdoano = getMesesdoAno(mes);
                dts.setMes(mesdoano);
                datas.add(dts);
            }
        }

        for (Datas dt : datas) {
            System.out
                    .println("-x-x-x-x-x-QUAIS-OS-DIAS-DA-SEMANA-TERÇA-E-QUARTA-DO-ANO-x-x-x-x-x-x ");
            System.out.println(dt.getMes() + " DE " + dt.getAno());
            System.out.println(dt.getDia() + " DATA: " + dt.getDatas());
            System.out.println(" ");
        }
        return datas;
    }

    private static void getDiasDeDeusTerQuaAnoSeguinte_VIEW() {
        System.out
                .println("Descrição: Retorna um array com todos as datas de Quarta e quintade um determinado mes e ano");
        System.out.println("qualquer data");
        System.out.println("@param: String Mes String ano");
        System.out.println("@return: String ");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("digite um inteiro para Mês de 1 a 12");
            String var = le.nextLine();
            dataCorreta = eNumericoEstaFaixaGeneric(var, 12);
            if (dataCorreta == true) {
                System.out
                        .println("digite um inteiro para Ano de ex: 1981 ou 2013");
                int c = Integer.parseInt(var);
                String var1 = le.nextLine();
                int varcontaux = c - 1;
                dataCorreta = eNumericoEstaFaixaGeneric(var, 2999);
                if (dataCorreta == true) {

                    int d = Integer.parseInt(var1);

                    ArrayList<Datas> datas = getDiasDeDeusTerQuaAnoSeguinte(
                            varcontaux, d);
                    System.out
                            .println("|-----------QUAIS-OS-DIAS-DA-SEMANA-QUARTA-E-QUINTA---------|");
                    System.out.println(var + " DE " + var1);
                    for (Datas dt : datas) {
                        System.out.println(dt.getDia() + " DATA: "
                                + dt.getDatas());
                        System.out.println(" ");
                    }
                    dataCorreta = true;
                } else {
                    dataCorreta = false;
                }

            }
        }
    }

    /**
     * Method getDiasDeDeusQuaQuiAnoSeguinte method returns all dates whose
     * weekdays are weaves Wednesday and Thursday of the following year
     *
     * @param mes
     * @param ano
     *
     * @return ArrayList<Datas>
     *
     */
    @SuppressWarnings({"unused"})
    public static ArrayList<Datas> getDiasDeDeusQuaQuiAnoSeguinte(int mes,
            int ano) {

        Set<Integer> weeks = new HashSet<Integer>();
        ArrayList<Datas> datas = new ArrayList<Datas>();
        ArrayList<Datas> dataCorreta = new ArrayList<Datas>();

        Date T;
        GregorianCalendar calendar = new GregorianCalendar();
        Calendar data = new GregorianCalendar();
        Date hoje = data.getTime();
        int dia = 1;

        data.set(ano, mes, dia);

        int diaMaximo = data.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (dia = 1; dia <= diaMaximo; dia++) {
            data.set(Calendar.DAY_OF_MONTH, dia);
            int diaDaSemana = data.get(Calendar.DAY_OF_WEEK);
            if ((diaDaSemana == Calendar.WEDNESDAY)
                    || (diaDaSemana == Calendar.THURSDAY)) {// 1 = terça e 2 =
                // quarta
                T = data.getTime();
                // if (hoje.after(T)) {//before = antes - after = depois
                int diaDaSemanaE = data.get(Calendar.DAY_OF_WEEK);
                String formato = "dd/MM/yyyy";
                SimpleDateFormat formatter = new SimpleDateFormat(formato);
                String dateRetorn = formatter.format(T);
                /* COMO INSTANCIAR UMA CLASSE INTERNA */
                MetodoAuxiliar mt = new MetodoAuxiliar();
                Datas dts = mt.new Datas();
                /* COMO INSTANCIAR UMA CLASSE INTERNA */
                String g = getDiaDaSemana(diaDaSemana);
                dts.setAno(ano);
                dts.setDatas(dateRetorn);
                dts.setDia(g);
                String mesdoano = getMesesdoAno(mes);
                dts.setMes(mesdoano);
                datas.add(dts);
            }
        }

        for (Datas dt : datas) {
            System.out
                    .println("-x-x-x-x-x-QUAIS-OS-DIAS-DA-SEMANA-QUARTA-E-QUINTA-DO-ANO-x-x-x-x-x-x ");
            System.out.println(dt.getMes() + " DE " + dt.getAno());
            System.out.println(dt.getDia() + " DATA: " + dt.getDatas());
            System.out.println(" ");
        }
        return datas;
    }

    private static void getDiasDeDeusQuaQuiAnoSeguinte_VIEW() {
        System.out
                .println("Descrição: Retorna um array com todos as datas de Quarta e quintade um determinado mes e ano");
        System.out.println("qualquer data");
        System.out.println("@param: String Mes String ano");
        System.out.println("@return: String ");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("digite um inteiro para Mês de 1 a 12");
            String var = le.nextLine();
            dataCorreta = eNumericoEstaFaixaGeneric(var, 12);
            if (dataCorreta == true) {
                System.out
                        .println("digite um inteiro para Ano de ex: 1981 ou 2013");
                int c = Integer.parseInt(var);
                String var1 = le.nextLine();
                int varcontaux = c - 1;
                dataCorreta = eNumericoEstaFaixaGeneric(var, 2999);
                if (dataCorreta == true) {

                    int d = Integer.parseInt(var1);

                    ArrayList<Datas> datas = getDiasDeDeusQuaQuiAnoSeguinte(
                            varcontaux, d);
                    System.out
                            .println("|-----------QUAIS-OS-DIAS-DA-SEMANA-QUARTA-E-QUINTA---------|");
                    System.out.println(var + " DE " + var1);
                    for (Datas dt : datas) {
                        System.out.println(dt.getDia() + " DATA: "
                                + dt.getDatas());
                        System.out.println(" ");
                    }
                    dataCorreta = true;
                } else {
                    dataCorreta = false;
                }

            }
        }
    }

    /**
     * Method getMesesdoAno method enters an integer return one month of the
     * year
     *
     * @param mesEscolhido
     *
     * @return String
     *
     */
    public static String getMesesdoAno(int mesEscolhido) {
        String viewMesEscolhido = "";
        if (mesEscolhido == 0) {
            viewMesEscolhido = "Janeiro";
        } else if (mesEscolhido == 1) {
            viewMesEscolhido = "Fevereiro";
        } else if (mesEscolhido == 2) {
            viewMesEscolhido = "Março";
        } else if (mesEscolhido == 3) {
            viewMesEscolhido = "Abril";
        } else if (mesEscolhido == 4) {
            viewMesEscolhido = "Maio";
        } else if (mesEscolhido == 5) {
            viewMesEscolhido = "Junho";
        } else if (mesEscolhido == 6) {
            viewMesEscolhido = "Julho";
        } else if (mesEscolhido == 7) {
            viewMesEscolhido = "Agosto";
        } else if (mesEscolhido == 8) {
            viewMesEscolhido = "Setembro";
        } else if (mesEscolhido == 9) {
            viewMesEscolhido = "Outubro";
        } else if (mesEscolhido == 10) {
            viewMesEscolhido = "Novembro";
        } else if (mesEscolhido == 11) {
            viewMesEscolhido = "Dezembro";
        }

        return viewMesEscolhido;
    }

    private static void getMesesdoAno_VIEW() {
        System.out
                .println("Descrição: Entre com um inteiro e devolve os meses do ano");
        System.out.println("@param: int Meses");
        System.out.println("@return: String ");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("digite um inteiro de 1 a 12");
            String var = le.nextLine();
            dataCorreta = eNumericoEstaFaixaGeneric(var, 12);
            if (dataCorreta == true) {
                int c = Integer.parseInt(var);
                int b = c - 1;
                String valor = getMesesdoAno(b);
                System.out.println("MÊS ESCOLHODO FOI: " + valor);
                dataCorreta = true;
            }
        }
    }

    /**
     * Method getDiaDaSemana method enters an integer return one day a week
     *
     * @param dia
     *
     * @return String
     *
     */
    public static String getDiaDaSemana(int dia) {
        String diaDaSemana = "";
        if (dia == 1) {
            diaDaSemana = "Domingo";
        } else if (dia == 2) {
            diaDaSemana = "Segunda-Feira";
        } else if (dia == 3) {
            diaDaSemana = "Terca-Feira";
        } else if (dia == 4) {
            diaDaSemana = "Quarta-Feira";
        } else if (dia == 5) {
            diaDaSemana = "Quinta-Feira";
        } else if (dia == 6) {
            diaDaSemana = "Sexta-Feira";
        } else if (dia == 7) {
            diaDaSemana = "Sabado";
        }

        return diaDaSemana;
    }

    private static void getDiaDaSemana_VIEW() {
        System.out
                .println("Descrição: Entre com um inteiro e devolve os dias da semana");
        System.out.println("@param: int dias da semana");
        System.out.println("@return: String ");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("digite um inteiro de 1 a 7");
            String var = le.nextLine();
            dataCorreta = eNumericoEstaFaixaGeneric(var, 7);
            if (dataCorreta == true) {
                int c = Integer.parseInt(var);
                // int b = c - 1;
                String valor = getDiaDaSemana(c);
                System.out.println("DIAS DA SEMANA ESCOLHODO FOI: " + valor);
                dataCorreta = true;
            }
        }
    }

    /**
     * Method getMesesDoAno method fills an array of months of the year always
     * filled with five months
     *
     * @param mes
     *
     * @return ArrayList<MesesAno>
     *
     */
    public static ArrayList<String> get6em6MesesDoAno(int mes) {

        ArrayList<String> mesesAno = new ArrayList<String>();

        if (mes == 0) {
            // mesesAno.add("Janeiro");
            mesesAno.add("Fevereiro");
            mesesAno.add("Março");
            mesesAno.add("Abril");
            mesesAno.add("Maio");
            mesesAno.add("Junho");
            mesesAno.add("Julho");

        } else if (mes == 1) {
            // mesesAno.add("Fevereiro");
            mesesAno.add("Março");
            mesesAno.add("Abril");
            mesesAno.add("Maio");
            mesesAno.add("Junho");
            mesesAno.add("Julho");
            mesesAno.add("Agosto");

        } else if (mes == 2) {
            // mesesAno.add("Março");
            mesesAno.add("Abril");
            mesesAno.add("Maio");
            mesesAno.add("Junho");
            mesesAno.add("Julho");
            mesesAno.add("Agosto");
            mesesAno.add("Setembro");

        } else if (mes == 3) {
            // mesesAno.add("Abril");
            mesesAno.add("Maio");
            mesesAno.add("Junho");
            mesesAno.add("Julho");
            mesesAno.add("Agosto");
            mesesAno.add("Setembro");
            mesesAno.add("Outubro");

        } else if (mes == 4) {
            // mesesAno.add("Maio");
            mesesAno.add("Junho");
            mesesAno.add("Julho");
            mesesAno.add("Agosto");
            mesesAno.add("Setembro");
            mesesAno.add("Outubro");
            mesesAno.add("Novembro");

        } else if (mes == 5) {
            // mesesAno.add("Junho");
            mesesAno.add("Julho");
            mesesAno.add("Agosto");
            mesesAno.add("Setembro");
            mesesAno.add("Outubro");
            mesesAno.add("Novembro");
            mesesAno.add("Dezembro");

        } else if (mes == 6) {
            // mesesAno.add("Julho");
            mesesAno.add("Agosto");
            mesesAno.add("Setembro");
            mesesAno.add("Outubro");
            mesesAno.add("Novembro");
            mesesAno.add("Dezembro");
            mesesAno.add("Janeiro");

        } else if (mes == 7) {
            // mesesAno.add("Agosto");
            mesesAno.add("Setembro");
            mesesAno.add("Outubro");
            mesesAno.add("Novembro");
            mesesAno.add("Dezembro");
            mesesAno.add("Janeiro");
            mesesAno.add("Fevereiro");

        } else if (mes == 8) {
            // mesesAno.add("Setembro");
            mesesAno.add("Outubro");
            mesesAno.add("Novembro");
            mesesAno.add("Dezembro");
            mesesAno.add("Janeiro");
            mesesAno.add("Fevereiro");
            mesesAno.add("Março");

        } else if (mes == 9) {
            // mesesAno.add("Outubro");
            mesesAno.add("Novembro");
            mesesAno.add("Dezembro");
            mesesAno.add("Janeiro");
            mesesAno.add("Fevereiro");
            mesesAno.add("Março");
            mesesAno.add("Abril");

        } else if (mes == 10) {
            // mesesAno.add("Novembro");
            mesesAno.add("Dezembro");
            mesesAno.add("Janeiro");
            mesesAno.add("Fevereiro");
            mesesAno.add("Março");
            mesesAno.add("Abril");
            mesesAno.add("Maio");

        } else if (mes == 11) {
            // mesesAno.add("Dezembro");
            mesesAno.add("Janeiro");
            mesesAno.add("Fevereiro");
            mesesAno.add("Março");
            mesesAno.add("Abril");
            mesesAno.add("Maio");
            mesesAno.add("Junho");

        }

        for (String ma : mesesAno) {
            System.out.println(ma);
        }
        return mesesAno;
    }

    private static void get6em6MesesDoAno_VIEW() {
        System.out
                .println("Descrição: Entre com um inteiro e devolve os Proximos seis meses");
        System.out.println("@param: int mes atual");
        System.out.println("@return: String ");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("digite um inteiro de 1 a 12");
            String var = le.nextLine();
            dataCorreta = eNumericoEstaFaixaGeneric(var, 12);
            if (dataCorreta == true) {
                int c = Integer.parseInt(var);
                int b = c - 1;
                ArrayList<String> valor = get6em6MesesDoAno(b);
                String mes = getMesesdoAno(b);
                System.out.println("O Mês escolhdo foi " + mes);
                System.out.println("Os próximos Seis Meses Sao:");
                for (String ma : valor) {
                    System.out.println(ma);
                }

                dataCorreta = true;
            }
        }
    }

    /**
     * Method calcIdade erases file contents
     *
     * @param dataNasc
     *
     * @return int
     *
     * para clcular a idade entrando com data convertendo string em data String
     * formato = "dd/MM/yyyy"; SimpleDateFormat formatter = new
     * SimpleDateFormat(formato); Date date = (Date)formatter.parse(dataBanco);
     * int idade = MetodoAuxiliar.calcIdade(date);
     *
     *
     */
    public static int calcIdade(Date dataNasc) {
        Date hoje = new Date();
        Calendar cal = Calendar.getInstance();

        cal.setTime(hoje);
        int day1 = cal.get(Calendar.DAY_OF_YEAR);
        int ano1 = cal.get(Calendar.YEAR);

        cal.setTime(dataNasc);
        int day2 = cal.get(Calendar.DAY_OF_YEAR);
        int ano2 = cal.get(Calendar.YEAR);

        int nAno = ano1 - ano2;

        if (day1 < day2) {
            nAno--; // Ainda não completou aniversario esse ano.
        }
        return nAno;
    }

    private static void calcIdade_VIEW() {
        System.out
                .println("Descrição: Calcula a idade apartir de uma data inserida");
        System.out.println("Esse metodo recebe uma data do tipo Date");
        System.out.println("Esse exemplo Transformaremos uma estring em Date");
        System.out.println("@param: Date  data");
        System.out.println("@return: Int  idate");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("DIGITE UMA DATA CORRETA Ex: 06/03/1971");
            String var = le.nextLine();
            dataCorreta = verificaData(var);
            if (dataCorreta == true) {
                try {
                    Date nascimento = formataData(var);
                    int idade = calcIdade(nascimento);
                    String dados = retornaDadosAniversario(var);
                    System.out.println("Data digitada: " + var + " Idade: "
                            + idade);
                    System.out.println(dados);
                } catch (Exception e) {
                    // TODO Auto-generated catch block

                }

                dataCorreta = true;
            }
        }
    }

    /**
     * Method pegaDadosAniversario erases file contents
     *
     * @param dataNasc
     *
     * @return String
     *
     */
    public static String retornaDadosAniversario(String dataNasc) {

        boolean verific = verificaData(dataNasc);
        Date nascimento = null;
        if (verific == true) {
            try {
                nascimento = formataData(dataNasc);
            } catch (Exception e) {

            }
        } else {
            System.out.println(dataNasc + " NAO É UMA DATA VÁLIDA!!");
        }
        Calendar cal = Calendar.getInstance();

        cal.setTime(nascimento);
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int diaDoMes = cal.get(Calendar.DAY_OF_MONTH);
        int diaDaSemana = cal.get(Calendar.DAY_OF_WEEK);

        /* Obtendo valores por escrito */
        String diaEscritoSegTerQuaQuiSexSabDom = getDiaDaSemana(diaDaSemana);
        String mesEscritoJanFevMarAbrMaiEtc = getMesesdoAno(mes);
        StringBuilder dadosaniversario;
        dadosaniversario = new StringBuilder();
        StringBuilder append;
        append = dadosaniversario.append("Você nasceu em ").append(diaDoMes).append(" de ").append(mesEscritoJanFevMarAbrMaiEtc).append(" de ").append(ano).append(" , um(a) ").append(diaEscritoSegTerQuaQuiSexSabDom);
        String retorno = dadosaniversario.toString();
        return retorno;
    }

    public static void retornaDadosAniversario_VIEW() {
        System.out
                .println("Descrição: Retorna escrito por extenso o dia, o mes o ano o dia da semana de uma determinada data");
        System.out
                .println("Esse metodo recebe uma data do tipo String e converte em date");
        System.out.println("@param: String  data");
        System.out.println("@return: String  ");

        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("DIGITE UMA DATA CORRETA Ex: 06/03/1971");
            String var = le.nextLine();
            dataCorreta = verificaData(var);
            if (dataCorreta == true) {

                String valor = retornaDadosAniversario(var);
                System.out.println(valor);
                dataCorreta = true;
            }
        }
    }

    /**
     * Method calcIdadeString erases file contents
     *
     * @param dataNasc
     *
     * @return int
     *
     * para clcular a idade entrando com data convertendo string em data String
     * formato = "dd/MM/yyyy"; SimpleDateFormat formatter = new
     * SimpleDateFormat(formato); Date date = (Date)formatter.parse(dataBanco);
     * int idade = MetodoAuxiliar.calcIdade(date);
     *
     *
     */
    public static int calcIdadeString(String dataNasc) {

        boolean verific = verificaData(dataNasc);
        Date nascimento = null;
        if (verific == true) {
            try {
                nascimento = formataData(dataNasc);
            } catch (Exception e) {
                // TODO Auto-generated catch block

            }
        } else {
            System.out.println(dataNasc + " NAO É UMA DATA VÁLIDA!!");
        }

        Date hoje = new Date();
        Calendar cal = Calendar.getInstance();

        cal.setTime(hoje);
        int day1 = cal.get(Calendar.DAY_OF_YEAR);
        int ano1 = cal.get(Calendar.YEAR);

        cal.setTime(nascimento);
        int day2 = cal.get(Calendar.DAY_OF_YEAR);
        int ano2 = cal.get(Calendar.YEAR);

        int nAno = ano1 - ano2;

        if (day1 < day2) {
            nAno--; // Ainda não completou aniversario esse ano.
        }
        return nAno;
    }

    private static void calcIdadeString_VIEW() {
        System.out
                .println("Descrição: Calcula a idade apartir de uma data inserida");
        System.out
                .println("Esse metodo recebe uma data do tipo String e converte em date");
        System.out.println("@param: String  data");
        System.out.println("@return: Int  idate");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("DIGITE UMA DATA CORRETA Ex: 06/03/1971");
            String var = le.nextLine();
            dataCorreta = verificaData(var);
            if (dataCorreta == true) {

                int idade = calcIdadeString(var);
                String dados = retornaDadosAniversario(var);
                System.out
                        .println("Data digitada: " + var + " Idade: " + idade);
                System.out.println(dados);
                dataCorreta = true;
            }
        }
    }

    /**
     * Method retornaDiaSemana enter a date returns the day of the week
     *
     * @param Date
     *
     * @return String
     *
     */
    public static String retornaDiaSemana(String dataNasc) {

        boolean verific = verificaData(dataNasc);
        Date nascimento = null;
        if (verific == true) {
            try {
                nascimento = formataData(dataNasc);
            } catch (Exception e) {

            }
        } else {
            System.out.println(dataNasc + " NAO É UMA DATA VÁLIDA!!");
        }

        String msg = "";
        int dia_semana;

        // Calendar data = Calendar.getInstance();
        Calendar data = Calendar.getInstance();
        data.setTime(nascimento);
        dia_semana = data.get(Calendar.DAY_OF_WEEK);

        switch (dia_semana) {
            case 1:
                msg = "Domingo";
                break;
            case 2:
                msg = "Segunda-Feira";
                break;
            case 3:
                msg = "Terca-Feira";
                break;
            case 4:
                msg = "Quarta-Feira";
                break;
            case 5:
                msg = "Quinta-Feira";
                break;
            case 6:
                msg = "Sexta-Feira";
                break;
            case 7:
                msg = "Sábado";
                break;
        }
        return msg;

    }

    private static void retornaDiaSemana_VIEW() {
        System.out
                .println("Descrição: Retorna o dia da semana apartir de uma data");
        System.out
                .println("Esse metodo recebe uma data do tipo String e converte em date");
        System.out.println("@param: String  data");
        System.out
                .println("@return: String  Dia da Semana  Ex: Você digitou: 01/09/2012 Retorna dia da semana = Sábado");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("DIGITE UMA DATA CORRETA Ex: 06/03/1971");
            String var = le.nextLine();
            dataCorreta = verificaData(var);
            if (dataCorreta == true) {
                String data = retornaDiaSemana(var);
                System.out.println("Você digitou: " + var
                        + " Retorna dia da semana = " + data);
                dataCorreta = true;
            }
        }

    }

    /*
     * Outros métodos muito importantes da classe java.util.Calendar são:
     * before() e after()(depois). before()(antes) nos permite saber se uma
     * determinada data é anterior a outra data. after() é o inverso, retorna se
     * uma data é posterior a outra data. Tem a seguinte sintaxe:
     * 
     * import java.util.Calendar; class JavaIniciante { public static void main
     * (String args[]){ Calendar data1 = Calendar.getInstance();
     * data1.set(Calendar.DAY_OF_MONTH, 1; data1.set(Calendar.MONTH, 10);
     * data1.set(Calendar.YEAR, 2005); Calendar data2 = Calendar.getInstance();
     * data2.set(Calendar.DAY_OF_MONTH, 12); data2.set(Calendar.MONTH, ;
     * data2.set(Calendar.YEAR, 2007); if (data1.before(data2)){
     * System.out.println("data1 é anterior a data2"); } else{
     * System.out.println("data1 não é anterior a data2"); } } }
     */
    /**
     * Method dataPassada enter a date check if that date is before or after the
     * current date
     *
     * @param Date
     *
     * @return boolean
     *
     */
    public static boolean dataPassada(String dataVerifik) {
        boolean verific = verificaData(dataVerifik);
        Date nascimento = null;
        if (verific == true) {
            try {
                nascimento = formataData(dataVerifik);
            } catch (Exception e) {

            }
        } else {
            System.out.println(dataVerifik + " NAO É UMA DATA VÁLIDA!!");
        }
        boolean msg = false;
        Date hoje = new Date();
        Calendar D1 = Calendar.getInstance();
        Calendar D2 = Calendar.getInstance();
        D1.setTime(hoje);
        D2.setTime(nascimento);
        /* (D1(HOJE) ANTES DE D2(DATA-PARAM)) ISSO É VERDADEIRO */
        if (D1.before(D2)) {
            msg = true;
        } else {
            msg = false;
        }

        return msg;

    }

    private static void dataPassada_VIEW() {
        System.out.println("Descrição: Recebe uma data e retorna um booleano.");
        System.out.println("Se a tada é passada da data atual retorna true");
        System.out.println("@param: String  data");
        System.out.println("@return: boolean  se a data é passada");

        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("DIGITE UMA DATA CORRETA Ex: 06/03/1971");
            String var = le.nextLine();
            dataCorreta = verificaData(var);
            if (dataCorreta == true) {
                boolean data = dataPassada(var);
                String resposta = "";
                if (data == false) {
                    resposta = " anterior a data atual (Data Passada!)";
                } else {
                    resposta = " Posterior a data atual (Data futura!)";
                }
                System.out.println("Você digitou: " + var + " Essa Data é: "
                        + resposta);
                dataCorreta = true;
            }
        }

    }

    /**
     * Method getHojeFormat() returns today's date formatted dd / MM / yyyy
     * current date
     *
     * @return String
     *
     */
    public static String getHojeFormat() {
        Date hoje = new Date();
        String formato = "dd/MM/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        String data = formatter.format(hoje);
        // System.out.println("HOJE: " + data);
        return data;
    }

    private static void getHojeFormat_VIEW() {
        System.out
                .println("Descrição: Retorna a data atual formatada (dd/MM/yyyy) padrão Brasileiro");
        System.out.println("@param: -");
        System.out.println("@return: String   data atual formadata");
        String x = getHojeFormat();
        System.out.println("HOJE: " + x);
    }

    /**
     * Method horaNow() returns the current date time current date
     *
     * @return String
     *
     */
    public static String getHora() {
        Calendar calendar = new GregorianCalendar();
        Date hoje = new Date();
        calendar.setTime(hoje);
        int horas1 = calendar.get(Calendar.HOUR_OF_DAY);
        int minutos1 = calendar.get(Calendar.MINUTE);
        int segundos1 = calendar.get(Calendar.SECOND);
        String horaCerta = horas1 + ":" + minutos1 + ":" + segundos1;
        // System.out.println("Hora: " + horaCerta);
        return horaCerta;
    }

    private static void horaNow_VIEW() {
        System.out
                .println("Descrição: Retorna a Hora atual formatada (HH:MM:SS) padrão Brasileiro");
        System.out.println("@param: -");
        System.out.println("@return: String   data atual formadata");
        String horaCerta = getHora();
        System.out.println("HORA: " + horaCerta);
    }

    /**
     * Method getHoje() returns formatted date written out
     *
     * @return String
     *
     */
    public static String getHoje() {
        String diaf = null;
        String mesf = null;
        String retorno;
        Calendar calendar = new GregorianCalendar();
        Date hoje = new Date();
        calendar.setTime(hoje);
        int semana = calendar.get(Calendar.DAY_OF_WEEK);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int ano = calendar.get(Calendar.YEAR);

        // semana
        switch (semana) {
            case 1:
                diaf = "Domingo";
                break;
            case 2:
                diaf = "Segunda";
                break;
            case 3:
                diaf = "Terça";
                break;
            case 4:
                diaf = "Quarta";
                break;
            case 5:
                diaf = "Quinta";
                break;
            case 6:
                diaf = "Sexta";
                break;
            case 7:
                diaf = "Sábado";
                break;
        }
        // mês
        switch (mes) {
            case 0:
                mesf = "Janeiro";
                break;
            case 1:
                mesf = "Fevereiro";
                break;
            case 2:
                mesf = "Março";
                break;
            case 3:
                mesf = "Abril";
                break;
            case 4:
                mesf = "Maio";
                break;
            case 5:
                mesf = "Junho";
                break;
            case 6:
                mesf = "Julho";
                break;
            case 7:
                mesf = "Agosto";
                break;
            case 8:
                mesf = "Setembro";
                break;
            case 9:
                mesf = "Outubro";
                break;
            case 10:
                mesf = "Novembro";
                break;
            case 11:
                mesf = "Dezembro";
                break;
        }

        retorno = diaf + ", " + dia + " de " + mesf + ", de " + ano;
        // System.out.println("Data Formatada: " + retorno);
        return retorno;
    }

    private static void getHoje_VIEW() {
        System.out.println("Descrição: Retorna uma data Escrito por extenso");
        System.out.println("@param: -");
        System.out
                .println("@return: String   data atual formadata Ex.: Terça, 19 de Novembro, de 2013");
        String horaCerta = getHoje();
        System.out.println("Hoje escrito extenso: " + horaCerta);
    }

    /**
     * Method subtraiHora Subtract one time from another current date
     *
  
     *
     * @param hora
     * @param hora2
     * @return String
     *
     */
    public static String subtraiHora(String hora, String hora2) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

        long min_1 = getMinutos(hora, formatter);
        long min_2 = getMinutos(hora2, formatter);
        long result = (min_1 - min_2) * 60 * 1000;
        Date data = new Date(result);
        return formatter.format(data);
    }

    private static void subtraiHora_VIEW() {
        System.out.println("Descrição: Subtrai uma hora da outra");
        System.out.println("@param: String hora1  - String Hora2");
        System.out.println("@return: String   ");
        boolean dataCorreta = false;
        while (dataCorreta == false) {
            System.out.println("DIGITE UMA DATA CORRETA Ex: 06/03/1971");
            String var = le.nextLine();
            dataCorreta = verificaData(var);
            if (dataCorreta == true) {

                dataCorreta = true;
            }
        }
    }

    /**
     * Method getDATA returns formatted date written out
     *
     * @param data

     *
     * @return String
     *
     */
    public static String getDATA(String data) {
        String diaf = null;
        String mesf = null;
        String retorno;
        Calendar calendar = new GregorianCalendar();
        Date hoje = new Date();
        Date DATA = hoje;
        String formato = "dd/MM/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        try {
            DATA = (Date) formatter.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(MetodoAuxiliar.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        calendar.setTime(DATA);
        int semana = calendar.get(Calendar.DAY_OF_WEEK);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int ano = calendar.get(Calendar.YEAR);

        // semana
        switch (semana) {
            case 1:
                diaf = "Domingo";
                break;
            case 2:
                diaf = "Segunda";
                break;
            case 3:
                diaf = "Terça";
                break;
            case 4:
                diaf = "Quarta";
                break;
            case 5:
                diaf = "Quinta";
                break;
            case 6:
                diaf = "Sexta";
                break;
            case 7:
                diaf = "Sábado";
                break;
        }
        // mês
        switch (mes) {
            case 0:
                mesf = "Janeiro";
                break;
            case 1:
                mesf = "Fevereiro";
                break;
            case 2:
                mesf = "Março";
                break;
            case 3:
                mesf = "Abril";
                break;
            case 4:
                mesf = "Maio";
                break;
            case 5:
                mesf = "Junho";
                break;
            case 6:
                mesf = "Julho";
                break;
            case 7:
                mesf = "Agosto";
                break;
            case 8:
                mesf = "Setembro";
                break;
            case 9:
                mesf = "Outubro";
                break;
            case 10:
                mesf = "Novembro";
                break;
            case 11:
                mesf = "Dezembro";
                break;
        }

        retorno = diaf + ", " + dia + " de " + mesf + ", de " + ano;
        return retorno;
    }

    private static void getDATA_VIEW() {

    }

    /**
     * Method getMinutos returns the time in minutes
     *
     * @param String
     *
     * @return long
     *
     */
    private static long getMinutos(String hora, SimpleDateFormat formatter) {
        Date data;
        try {
            data = formatter.parse(hora);
        } catch (ParseException e) {
            return 0;
        }
        long minutos = data.getTime() / 1000 / 60;
        return minutos;
    }

    private static void getMinutos_VIEW() {

    }

    /*-----------------------------------FIM----------------------------------*/
    /*----------------------METODOS-DE-MANIPULAÇÃO DE DATAS-------------------*/
    /*--------------------(02)-METODOS-DE-MANIPULAÇÃO DE DATAS----------------*/
    /*-----------------------------------FIM----------------------------------*/

    /*-----------------------------------INICIO--------------------------------*/
    /*--------------------(05)-METODOS-DE-VERIFICAÇÕES-I-----------------------*/
    /*--------------------(06)-METODOS-DE-VERIFICAÇÕES-II----------------------*/
    /*-----------------------------------INICIO--------------------------------*/
    /**
     * Method verificaNumerosString check if a string contains numbers
     *
     * @param String
     *
     * @return boolean
     *
     */
    public static boolean verificaNumerosString(String nome) {

        char[] c = nome.toCharArray();
        boolean temNumero = false;
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                temNumero = true;
                break;
            }
        }

        return temNumero;
    }

    private static void verificaNumerosString_VIEW() {

    }

    /**
     * Method ehNumerico checks a string is numeric
     *
     * @param String
     * @return boolean
     *
     */
    public static boolean ehNumerico(String texto) {
        boolean result = false;
        try {
            @SuppressWarnings("unused")
            int num = Integer.parseInt(texto);
            result = true;
        } catch (NumberFormatException ex) {
            result = false;
        }
        return result;
    }

    private static void ehNumerico_VIEW() {

    }

    /**
     * Method ehNumerico02 checks a string is numeric
     *
     * @param String
     * @return boolean
     *
     */
    public static boolean ehNumerico02(String valor) {
        boolean valido = true;
        for (int i = 0; i < valor.length(); i++) {
            Character caractere = valor.charAt(i);
            if (!Character.isDigit(caractere)) {
                valido = false;
                break;
            }
        }

        return valido;
    }

    private static void ehNumerico02_VIEW() {

    }

    /**
     * Method tamanhoIgualA11 checks of a string is the size of 11 characters
     *
     * @param String
     * @return boolean
     *
     */
    public static boolean tamanhoIgualA11(String valor) {
        boolean valido = true;
        int tamanho = valor.length();
        if (tamanho == 11) {
            valido = true;
        } else {
            valido = false;
        }

        return valido;
    }

    private static void tamanhoIgualA11_VIEW() {

    }

    /**
     * METODO É NUMERICO E ESTA NA FAIXA GENERICO VERDADEIRO OU FALSE UTILIZA
     * METODO ANTERIOR EHNUMERICO EMITE MENSAGENS NOS DOIS CASOS CASO RETORNO
     * FOR FALSO (Verifica se x é numerico ou nao, verifico se x esta no
     * range(alcance) de 1 a r))
     *
     * @param String
     * @param int
     * @return boolean
     */
    public static boolean eNumericoEstaFaixaGeneric(String x, int r) {
        boolean result = false;
        boolean mum = ehNumerico(x);
        if (mum == false) {
            result = false;
            System.out.println("");
            System.out.println("");
            System.out.println("|------------------WARNING------------------|");
            System.out.println("       A ENTRADA: " + x + " NÃO É NUMÉRICA!");
            System.out.println("       DIGITE INTEIRO DE (1) A (" + r + ").");
            System.out.println("|------------------WARNING------------------|");
            System.out.println("");
            System.out.println("");
        } else {
            int f = Integer.parseInt(x);
            if ((f >= 1) & (f <= r)) {
                result = true;
            } else {
                result = false;
                System.out.println("");
                System.out.println("");
                System.out
                        .println("|-------------------WARNING-----------------|");
                System.out.println("     A ENTRADA: " + f
                        + " ESTA FORA DA FAIXA.");
                System.out.println("       DIGITE INTEIRO DE (1) A (" + r
                        + ").");
                System.out
                        .println("|-------------------WARNING-----------------|");
                System.out.println("");
                System.out.println("");
            }
        }
        return result;
    }

    public static void eNumericoEstaFaixaGeneric_VIEW() {

    }

    /**
     * Method nhaFaixa1 receives a string to integer transforms checks if this
     * emtre in the range 0 to 4
     *
     * @param String
     *
     * @return boolean
     *
     */
    public static boolean nhaFaixa1(String valor) {
        boolean result = false;
        boolean mum = ehNumerico(valor);
        if (mum == false) {
            result = false;
        } else {
            int fx1 = Integer.parseInt(valor);
            if ((fx1 <= 0) | (fx1 >= 4)) {
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    private static void nhaFaixa1_VIEW() {

    }

    /**
     * Method naFaixaEntre1e9 receives a string to integer transforms checks if
     * this emtre in the range 0 to 9
     *
     * @param String
     * @return boolean
     *
     */
    public static boolean naFaixaEntre1e9(String valor) {
        boolean result = false;
        boolean mum = ehNumerico(valor);
        int fx1 = Integer.parseInt(valor);
        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 10)) {// intervalo de 1 a 9
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    private static void naFaixaEntre1e9_VIEW() {

    }

    /**
     * Method naFaixaEntre1e2 receives a string to integer transforms checks if
     * this emtre in the range 0 to 2
     *
     * @param String
     * @return boolean
     *
     */
    public static boolean naFaixaEntre1e2(String valor) {
        boolean result = false;
        boolean mum = ehNumerico(valor);
        int fx1 = Integer.parseInt(valor);
        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 3)) {// vai de 1 a 2// os extremos é falso
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    private static void naFaixaEntre1e2_VIEW() {

    }

    /**
     * Method tamanhoEntre4e9 receives a Integer checks if this emtre in the
     * range 4 to 9
     *
     * @param int fx
     * @return boolean
     *
     */
    public static boolean tamanhoEntre4e9(int fx) {

        boolean result = false;

        if ((fx <= 4) | (fx >= 9)) {// vai de 1 a 2// os extremos é falso
            result = false;
        } else {
            result = true;
        }

        return result;
    }

    private static void tamanhoEntre4e9_VIEW() {

    }

    /**
     * Method tamanhoEntre1e11 receives a Integer checks if this emtre in the
     * range 1 to 11
     *
     * @param int fx
     *
     * @return boolean
     *
     */
    public static boolean tamanhoEntre1e11(int fx) {

        boolean result = false;

        if ((fx <= 0) | (fx >= 12)) {// vai de 1 a 2// os extremos é falso
            result = false;
        } else {
            result = true;
        }

        return result;
    }

    private static void tamanhoEntre1e11_VIEW() {

    }

    /**
     * Method nhaFaixa2 receives a string to integer transforms checks if this
     * emtre in the range 0 to 6
     *
     * @param String
     *
     * @return boolean
     *
     */
    public static boolean nhaFaixa2(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        if (mum == false) {
            result = false;
        } else {
            int fx1 = Integer.parseInt(fx);
            if ((fx1 <= 0) | (fx1 >= 6)) {
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    private static void nhaFaixa2_VIEW() {

    }

    /**
     * Method naFaixaEntre1e5 receives a string to integer transforms checks if
     * this emtre in the range 0 to 5
     *
     * @param String
     *
     * @return boolean
     *
     */
    public static boolean naFaixaEntre1e5(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);

        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 6)) {// vai de 1 a 5// os extremos é falso
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    private static void naFaixaEntre1e5_VIEW() {

    }

    /**
     * Method naFaixaEntre1e6 receives a string to integer transforms checks if
     * this emtre in the range 0 to 6
     *
     * @param String
     * @return boolean
     *
     */
    public static boolean naFaixaEntre1e6(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);

        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 7)) {// vai de 1 a 6// os extremos é falso
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    private static void naFaixaEntre1e6_VIEW() {

    }

    /**
     * Method naFaixaEntre1e7 receives a string to integer transforms checks if
     * this emtre in the range 0 to 7
     *
     * @param String
     * @return boolean
     *
     */
    public static boolean naFaixaEntre1a7(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);

        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 8)) {// vai de 1 a 7// os extremos é falso
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    private static void naFaixaEntre1a7_VIEW() {

    }

    /**
     * Method naFaixaEntre1e8 receives a string to integer transforms checks if
     * this emtre in the range 0 to 8
     *
     * @param String
     * @return boolean
     *
     */
    public static boolean naFaixaEntre1e8(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);
        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 9)) {// vai de 1 a 8// os extremos é falso
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    private static void nhaFaixa1a8_VIEW() {

    }

    /**
     * Method naFaixaEntre1a9 receives a string to integer transforms checks if
     * this emtre in the range 0 to 9
     *
     * @param String
     * @return boolean
     *
     */
    public static boolean naFaixaEntre1a9(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);
        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 10)) {// vai de 1 a 9// os extremos é falso
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    private static void naFaixaEntre1a9_VIEW() {

    }

    /**
     * Method naFaixaEntre1a8 receives a string to integer transforms checks if
     * this emtre in the range 0 to 7
     *
     * @param String
     * @return boolean
     *
     */
    public static boolean nhaFaixa1a8(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        if (mum == false) {
            result = false;
        } else {
            int fx1 = Integer.parseInt(fx);
            if ((fx1 <= 0) || (fx1 >= 8)) {
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    /**
     * Method nhaFaixa3 receives a string to integer transforms checks if this
     * emtre in the range 0 to 3
     *
     * @param String
     * @return boolean
     *
     */
    public static boolean nhaFaixa3(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        if (mum == false) {
            result = false;
        } else {
            int fx1 = Integer.parseInt(fx);
            if ((fx1 >= 0) | (fx1 >= 3)) {
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    private static void nhaFaixa3_VIEW() {

    }

    /**
     * Method naFaixaEntre1e3 receives a string to integer transforms checks if
     * this emtre in the range 0 to 3
     *
     * @param String
     * @return boolean
     *
     */
    public static boolean naFaixaEntre1e3(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);

        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 4)) {// observando so extremos menor igual
                // a zero ou maior igual a quatro
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    private static void naFaixaEntre1e3_VIEW() {

    }

    /**
     * Method validaIdentificador checks if the string has length 7 characters
     *
     * @param String
     * @return boolean
     *
     */
    public static boolean validaIdentificador(String valor) {
        boolean n = false;
        int charCount = valor.length();
        if (charCount == 7) {
            n = true;
        } else {
            n = false;
        }

        return n;
    }

    private static void validaIdentificador_VIEW() {

    }

    /**
     * Method validaIdentificador2 whether a given string starts with prefixes
     *
     * @param String I
     *
     * @return boolean
     *
     */
    public static boolean validaIdentificador2(String I) {
        boolean n = false;
        if (I.startsWith("A0")) {
            n = true;
        } else {
            if (I.startsWith("O0")) {
                n = true;
            } else {
                if (I.startsWith("R0")) {
                    n = true;
                } else {
                    if (I.startsWith("E0")) {
                        n = true;
                    } else {
                        if (I.startsWith("P0")) {
                            n = true;
                        } else {
                            n = false;
                        }
                    }
                }
            }
        }
        return n;
    }

    private static void validaIdentificador2_VIEW() {

    }

    /**
     * Method validaIdentificador2 whether a given string starts with prefixes
     *
     *
     * @param ident
     * @return String
     *
     */
    public static String retornaTypeIdentificador(String ident) {
        String aux = "";
        if (ident.startsWith("A0")) {
            aux = "A0";
        } else {
            if (ident.startsWith("O0")) {
                aux = "O0";
            } else {
                if (ident.startsWith("R0")) {
                    aux = "R0";
                } else {
                    if (ident.startsWith("E0")) {
                        aux = "E0";
                    } else {
                        if (ident.startsWith("P0")) {
                            aux = "P0";
                        }
                    }
                }
            }
        }
        return aux;

    }

    private static void retornaTypeIdentificador_VIEW() {

    }

    /**
     * Method WhatSystemOS returns the name of the operating system
     *
     *
     *
     */
    public static void WhatSystemOS() {
        System.out.println(System.getProperty("os.name"));
    }

    private static void WhatSystemOS_VIEW() {

    }

    /**
     * && E ("logical AND") a && b retorna true se a e b forem ambos true. Senão
     * retorna false. Se a for false, b não é avaliada.
     *
     * & E ("boolean logical AND") a & b retorna true se a e b forem ambos true.
     * Senão retorna false. Ambas expressões a e b são sempre avaliadas.
     *
     * || OU ("logical OR") a || b retorna true se a ou b for true. Senão
     * retorna false. Se a for true, b não é avaliada.
     *
     * | OU ("boolean logical inclusive OR") a | b retorna true se a ou b for
     * true. Senão retorna false. Ambas expressões a e b são sempre avaliadas.
     *
     * ^ OU EXCLUSIVO ("boolean logical exclusive OR") a ^ b retorna true se a
     * for true e b for false ou vice-versa. Senão retorna false
     *
     * ! NÃO ("logical NOT") !a retorna true se a for false. Senão retorna false
     */

    /*-----------------------------------FIM----------------------------------*/
    /*-----------------------(05)-METODOS-DE-VERIFICAÇÕES-I-------------------*/
    /*-----------------------(06)-METODOS-DE-VERIFICAÇÕES-II------------------*/
    /*-----------------------------------FIM----------------------------------*/

    /*-----------------------------------INICIO-------------------------------*/
    /*--------------------METODOS-DE-MANIPULAÇÃO DE ARQUIVOS------------------*/
    /*-----------------(07)-METODOS-DE-MANIPULAÇÃO DE ARQUIVOS----------------*/
    /*-----------------------------------INICIO-------------------------------*/
    /**
     * Method salvarArquivo receives a string arquivo path, String conteudo
     * content to be recorded
     *
     *
     * @param arquivo
     * @param conteudo
     * @param adicionar
     * @throws java.io.IOException
     */
    public static void salvarArquivo(String arquivo, String conteudo,
            boolean adicionar) throws IOException {
        adicionar = false;
        FileWriter fw = new FileWriter(arquivo, adicionar);

        fw.write(conteudo);
        fw.close();
    }

    private static void salvarArquivo_VIEW() {

    }

    /**
     * Method removieContentFile erases file contents
     *
     *
     * @param pathOndeEstaOarquivo
     */
    public static void removieContentFile(String pathOndeEstaOarquivo) {
        // uma instância de RandomAccessFile para leitura e escrita
        try {
            RandomAccessFile arquivo = new RandomAccessFile(
                    pathOndeEstaOarquivo, "rw");

            // vamos excluir todo o conteúdo do arquivo
            arquivo.setLength(0);

            arquivo.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        System.exit(0);
    }

    private static void removieContentFile_VIEW() {

    }

    /**
     * Method AbreArquivo enter a date check if that date is before or after the
     * current date
     *
     * @param String
     * @param String
     *
     * @return boolean
     *
     */
    @SuppressWarnings({"unused", "resource"})
    private static void AbreArquivo(String nomeArquivo, String pathCaminhoOnde) {

        if (nomeArquivo.isEmpty()) {
            File arq = new File(pathCaminhoOnde);
            if (arq.exists()) {
                try {
                    BufferedWriter arqSaida = new BufferedWriter(
                            new FileWriter(arq, true));
                } catch (IOException ex) {
                }

            } else {
                try {

                    BufferedWriter arqSaida = new BufferedWriter(
                            new FileWriter(arq, false));
                } catch (IOException ex) {
                }

            }
        } else {
            System.out.println("Nome do arquivo não preenchido");
        }

    }

    private static void AbreArquivo_VIEW() {

    }

    /**
     * Method deletFile() delet File
     *
     * @param pathFile
     *
     *
     */
    public static void deletFile(String pathFile) {
        boolean success = (new File(pathFile)).delete();
        if (!success) {
            System.out.print("Falhou deletar \n");
        }

    }

    private static void deletFile_VIEW() {

    }

    /**
     * Method createFile() create File
     *
     * @param URL
     */
    public static void createFile(String URL) {
        try {
            boolean success = (new File(URL)).createNewFile();
            if (!success) {
                System.out.print("Falhou criar \n");
            }
        } catch (IOException ex) {
            Logger.getLogger(MetodoAuxiliar.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

    }

    @SuppressWarnings("unused")
    private static void createFile_VIEW() {

    }

    /**
     * Method lerArquivoPrincipal read a disk file returns array of strings
     *
     * @param urlPath
     * @return ArrayList<String>
     *
     */
    @SuppressWarnings("unused")
    public static ArrayList<String> lerArquivoPrincipal(String urlPath) {
        String linha;
        ArrayList<String> comp = new ArrayList<String>();
        BufferedReader reader;
        try {
            @SuppressWarnings("resource")
            BufferedReader bufferedReader = reader = new BufferedReader(
                    new FileReader(urlPath));
            while ((linha = reader.readLine()) != null) {
                comp.add(linha);
            }
        } catch (IOException e1) {

        }
        return comp;
    }

    /**
     *retorna um array liste de final para inicio
     * @param myList
     * @return
     */
    public static List reverseList(List myList) {
        List invertedList = new ArrayList();
        for (int i = myList.size() - 1; i >= 0; i--) {
            invertedList.add(myList.get(i));
        }
        return invertedList;
    }

    
    
    
    private static void lerArquivoPrincipal_VIEW() {

    }

    /**
     * Method Writingfile with string array to be written to the file
     *
     *
     * @param array
     * @param UrlPath
     * @throws java.io.FileNotFoundException
     */
    public static void Writingfile(ArrayList<String> array, String UrlPath)
            throws FileNotFoundException, IOException {
        String element;
        File arq = new File(UrlPath);
        BufferedWriter rout = null;
        try {

            rout = new BufferedWriter(new FileWriter(arq, false));

            Iterator<String> itr = array.iterator();
            while (itr.hasNext()) {
                element = itr.next();
                rout.write(element + "\n");

            }

        } finally {
            if (rout != null) {
                rout.close();
            }
        }
    }
    
    
     /**
     * Method Writingfile with string array to be written to the file
     *PARAMETROS PARA PERMISSAO 777 EM ARQUIVOS  NO LINUX
     *
     * @param array
     * @param UrlPath
     * @throws java.io.FileNotFoundException
     */
    public static void WritingfileContinuos(ArrayList<String> array, String UrlPath)
            throws FileNotFoundException, IOException {
        String element;
        File arq = new File(UrlPath);
        /*PARAMETROS PARA PERMISSAO 777 EM ARQUIVOS NO LINUX*/
        arq.setReadable(Boolean.TRUE, Boolean.TRUE);
        arq.setWritable(Boolean.TRUE, Boolean.TRUE);
        arq.setExecutable(Boolean.TRUE, Boolean.TRUE);
        BufferedWriter rout = null;
        try {

            rout = new BufferedWriter(new FileWriter(arq, true));

            Iterator<String> itr = array.iterator();
            while (itr.hasNext()) {
                element = itr.next();
                rout.write(element + "\n");

            }

        } finally {
            if (rout != null) {
                rout.close();
            }
        }
    }

    private static void Writingfile_VIEW() {

    }

    /*-----------------------------------FIM----------------------------------*/
    /*--------------------METODOS-DE-MANIPULAÇÃO DE ARQUIVOS------------------*/
    /*-----------------(07)-METODOS-DE-MANIPULAÇÃO DE ARQUIVOS----------------*/
    /*-----------------------------------FIM----------------------------------*/

    /*-----------------------------------INICIO-------------------------------*/
    /*----------------------------METODOS-DE-DEMOSTRAÇÃO----------------------*/
    /*-------------------------(08)-METODOS-DE-DEMOSTRAÇÃO--------------------*/
    /*-----------------------------------INICIO-------------------------------*/
    /**
     * Method HasMapInterator demonstration of the interactor hasMap
     *
     *
     */
    public static void HasMapInterator() {

        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(0, "Ricardo");
        map.put(1, "Teste");
        map.put(2, "Outro Teste");
        map.put(3, "(t)ostre(0)");
        // ...
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue()); // need
        }
    }

    private static void HasMapInterator_VIEW() {

    }

    /**
     * Method LoopMap demonstration of the interactor hasMap
     *
     *
     */
    @SuppressWarnings("rawtypes")
    public static void LoopMap() {
        // initial a Map
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "Jan");
        map.put("2", "Feb");
        map.put("3", "Mar");
        map.put("4", "Apr");
        map.put("5", "May");
        map.put("6", "Jun");

        System.out.println("Example 1...");
        // Map -> Set -> Iterator -> Map.Entry -> troublesome
        Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            System.out.println("The key is: " + mapEntry.getKey()
                    + ",value is :" + mapEntry.getValue());
        }

        System.out.println("Example 2...");
        // more elegant way
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : "
                    + entry.getValue());
        }

        System.out.println("Example 3...");
        // weired way, but works anyway
        for (Object key : map.keySet()) {
            System.out.println("Key : " + key.toString() +" Value : "+ map.get(key));
        }

    }

    private static void LoopMap_VIEW() {

    }

    /**
     * Method StringBufferDemo demonstration how to use StringBuffer
     *
     *
     */
    public static void StringBufferDemo() {
        StringBuffer name = new StringBuffer("Maicon");
        // Adicionando um nome a string
        name.append(", Pedro");

        // Convertendo para string
        String nameStr1 = name.toString();

        // Aloca uma nova string contendo os valores do StringBuffer
        String nameStr2 = new String(name);

        System.out.println("name      : " + name);
        System.out.println("nameStr1  : " + nameStr1);
        System.out.println("nameStr2  : " + nameStr2);
    }

    private static void StringBufferDemo_VIEW() {

    }

    /**
     * Method DEFINITIVAMENTE_COMO_IMPRIMIR_UM_ARRAYLIST - PRINT demonstrates
     * how an ArrayList
     *
     */
    public static void imprimeArrayList() {
        ArrayList<Object> al = new ArrayList<Object>();
        al.add("Teste");
        al.add(new Integer(1));
        al.add(new Long(2));
        al.add(new Float(3.3));
        al.add(Boolean.TRUE);
        // PARA IMPRIMIR
        Iterator<Object> it = al.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static void imprimeArrayList_VIEW() {

    }

    /*-----------------------------------FIM----------------------------------*/
    /*----------------------------METODOS-DE-DEMOSTRAÇÃO----------------------*/
    /*-------------------------(08)-METODOS-DE-DEMOSTRAÇÃO--------------------*/
    /*-----------------------------------FIM----------------------------------*/

    /*-----------------------------------INICIO-------------------------------*/
    /*----------------------------METODOS-DE-GERA-MD5-------------------------*/
    /*-------------------------(09)-METODOS-DE-GERA-MD5-----------------------*/
    /*-----------------------------------INICIO-------------------------------*/
    /**
     * Method geraMD5 entro com uma string retorna uma chave md5
     *
     *
     * @param frase
     * @return 
     * @throws java.security.NoSuchAlgorithmException 
     */
    public static String geraMD5(String frase) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(frase.getBytes());
        byte[] hashMd5 = md.digest();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < hashMd5.length; i++) {
            int parteAlta = ((hashMd5[i] >> 4) & 0xf) << 4;
            int parteBaixa = hashMd5[i] & 0xf;
            if (parteAlta == 0) {
                s.append('0');
            }
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }

    private static void geraMD5_VIEW() {

    }

    /*------------------------------------FIM---------------------------------*/
    /*----------------------------METODOS-DE-GERA-MD5-------------------------*/
    /*-------------------------(09)-METODOS-DE-GERA-MD5-----------------------*/
    /*------------------------------------FIM---------------------------------*/

    /*---------------------------------INICIO---------------------------------*/
    /*------------------------METODOS-DE-SUBMETE-URL-HTTP---------------------*/
    /*----------------------(10)-METODOS-DE-SUBMETE-URL-HTTP------------------*/
    /*---------------------------------INICIO---------------------------------*/
    /**
     * Method submeterUrl method submits a path to the HTTP protocol that
     * returns a resource (webservices) I walk with path and file name then
     * write the contents of the return to a local file
  
     * @param urlSub
     * @param nomeArquivo
     */
    public static void submeterUrl(String urlSub, String nomeArquivo) {

        ArrayList<String> psd = new ArrayList<String>();

        try {
            String urlString = urlSub;

            // cria o objeto url
            URL url = new URL(urlString);
			// System.out.println("URL - FORMADA: " + urlString);

            // cria o objeto httpurlconnection promove o request(solicitação
            // pedido)
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();

            // seta o metodo GET
            connection.setRequestProperty("Request-Method", "GET");

            /*
             * seta a variavel para ler o resultado E marcamos as flags de input
             * como true e output como false, significando que não estamos
             * interessados em enviar dados, porém sim em receber (a resposta,
             * provavelmente uma página HTML):
             */
            connection.setDoInput(true);
            connection.setDoOutput(false);

            // conecta com a url destino
            connection.connect();

            /*
             * O resultado Para extrair o resultado de uma conexão, utilizamos o
             * java.io.InputStream da mesma, encapsulando ela em um
             * java.io.BufferedReader para tornar o acesso aos dados mais veloz:
             */
            // abre a conexão pra input
            // BufferedReader br = new BufferedReader(new
            // InputStreamReader(connection.getInputStream()));
            // cria um stream de entrada do conteúdo
            InputStreamReader inputReader = new InputStreamReader(
                    connection.getInputStream());
            BufferedReader br = new BufferedReader(inputReader);

            // System.out.println(br);
            StringBuilder newData = new StringBuilder(10000);
            String linha;
            while ((linha = br.readLine()) != null) {
                newData.append(linha);
                newData.append("\n");
                psd.add(linha);
            }

            Writingfile(psd, nomeArquivo);

        } catch (IOException ex) {

        }

    }

    private static void submeterUrl_VIEW() {

    }

    /*------------------------------------FIM---------------------------------*/
    /*------------------------METODOS-DE-SUBMETE-URL-HTTP---------------------*/
    /*----------------------(10)-METODOS-DE-SUBMETE-URL-HTTP------------------*/
    /*------------------------------------FIM---------------------------------*/

    /*-----------------------------------INICIO-------------------------------*/
    /*------------------------------------RUN---------------------------------*/
    /*------------------------------------RUN---------------------------------*/
    /*-----------------------------------INICIO-------------------------------*/
    public static void main(String[] args) {
        // DECLAREI UMA VARIAVEL LOCAL BOOLEANA = FALSE :MINHA VARIAVEL DE
        // CONTROLE
        boolean enuricEstaNaFaixa = false;
        // EMQUNTO MINHA VARIAVEL FOR FALSA REPITO O INTERIOR DO WHILE
        while (enuricEstaNaFaixa == false) {
            // AQUI MOSTRO O MENUPRINCIPAL ONDE O USER ESCOLHE 9 OPÇÕES DA
            menuPrincipal();
            // LEIO A ENTRADA DO TECLADO E QUAL A OPÇÃO FOI
            // ESCOLHIDA
            String var = le.nextLine();

            enuricEstaNaFaixa = eNumericoEstaFaixaMain(var, 11);
            /*
             * SE VERDADEIRO ENTRO NO IF USO UMA VARIAVEL GLOBAL AUXILIAR DO
             * TIPO INT
             */
            if (enuricEstaNaFaixa == true) {
                /*
                 * TRANSFORMO MINHA STRING(ENTRADA DO TECLADO SEMPRE É STRING)
                 * EM INTEIRO
                 */
                auxMenu = Integer.parseInt(var);
                // tratamento das operações
                if (auxMenu == 1) {
                    System.out
                            .println("|----------(1)-METODOS-DE-SORTEIO-----------|");
                    metodoSorteio_1();
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 2) {
                    System.out
                            .println("|---(2)-METODOS-DE-MANIPULAÇÃO DE STRINGS---|");
                    metodoManipulaStrings_2();
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 3) {
                    System.out
                            .println("|---(3)-METODOS-DE-MANIPULAÇÃO DE DATAS-I---|");
                    metodoManipulaDatas_3_1();
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 4) {
                    System.out
                            .println("|--(4)-METODOS-DE-MANIPULAÇÃO DE DATAS-II---|");
                    metodoManipulaDatas_3_2();
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 5) {
                    System.out
                            .println("(|-------(5)-METODOS-DE-VERIFICAÇÕES-I------|");
                    metodoVerificacoes_4_1();
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 6) {
                    System.out
                            .println("(|------(6)-METODOS-DE-VERIFICAÇÕES-II------|");
                    metodoVerificacoes_4_2();
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 7) {
                    System.out
                            .println("|--(7)-METODOS-DE-MANIPULAÇÃO DE ARQUIVOS---|");
                    metodoManipulaArquivos_5();
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 8) {
                    System.out
                            .println("|---------(8)-METODOS-DE-DEMOSTRAÇÃO--------|");
                    metodoDemostracao_6();
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 9) {
                    System.out
                            .println("|----------(9)-METODOS-DE-GERA-MD5----------|");
                    metodoGeraMD5_7();
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 10) {
                    System.out
                            .println("|-----(10)-METODOS-DE-SUBMETE-URL-HTTP------|");
                    metodoSubmeteURL_8();
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 11) {
                    System.out
                            .println("|-----------------(11)-SAIR-----------------|");
                    System.out
                            .println("|--------------------fim!-------------------|");
                    System.out
                            .println("|--------------MUITO OBRIGADO!--------------|");

                    enuricEstaNaFaixa = true;
                    break;
                }
            }
        }
    }

    /*-----------------------------------FIM----------------------------------*/
    /*------------------------------------RUN---------------------------------*/
    /*------------------------------------RUN---------------------------------*/
    /*-----------------------------------FIM----------------------------------*/
    /*-----------------------------------INICIO-------------------------------*/
    /*-----------------------------RUM-CONTROLADORES--------------------------*/
    /*-----------------------------RUM-CONTROLADORES--------------------------*/
    /*-----------------------------------INICIO-------------------------------*/
    /**
     * METODO É NUMERICO E ESTA NA FAIXA RETORNA VERDADEIRO OU FALSE UTILIZA
     * METODO ANTERIOR EHNUMERICO EMITE MENSAGENS NOS DOIS CASOS CASO RETORNO
     * FOR FALSO
     * @param x
     * @param r 
     * @return  
     */
    public static boolean eNumericoEstaFaixaMain(String x, int r) {
        boolean result = false;
        boolean mum = ehNumerico(x);
        if (mum == false) {
            result = false;
            System.out.println("");
            System.out.println("");
            System.out.println("|------------------WARNING------------------|");
            System.out.println("       A ENTRADA: " + x + " NÃO É NUMÉRICA!");
            System.out.println("       DIGITE INTEIRO DE (1) A (" + r + ").");
            System.out.println("|------------------WARNING------------------|");
            System.out.println("");
            System.out.println("");
        } else {
            int f = Integer.parseInt(x);
            if ((f >= 1) & (f <= r)) {
                result = true;
            } else {
                result = false;
                System.out.println("");
                System.out.println("");
                System.out
                        .println("|-------------------WARNING-----------------|");
                System.out.println("     A ENTRADA: " + f
                        + " ESTA FORA DA FAIXA.");
                System.out.println("       DIGITE INTEIRO DE (1) A (" + r
                        + ").");
                System.out
                        .println("|-------------------WARNING-----------------|");
                System.out.println("");
                System.out.println("");
            }
        }
        return result;
    }

    private static void metodoSorteio_1() {
        boolean enuricEstaNaFaixa = false;
        while (enuricEstaNaFaixa == false) {
            MenuSorteio_1();
            String var = le.nextLine();
            enuricEstaNaFaixa = eNumericoEstaFaixaMain(var, 6);
            if (enuricEstaNaFaixa == true) {
                auxMenu = Integer.parseInt(var);
                if (auxMenu == 1) {
                    System.out
                            .println("|------------(1.1)-geraAleatorio()----------|");
                    System.out.println("");
                    geraAleatorioVIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 2) {
                    System.out
                            .println("|---------------(1.2)-sorteia()-------------|");
                    System.out.println("");
                    sorteiaVIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 3) {
                    System.out
                            .println("|------------(1.3)-sorteiaParam()-----------|");
                    System.out.println("");
                    sorteiaParam_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 4) {
                    System.out
                            .println("|-----------(1.4)-sorteiaParamBast()--------|");
                    System.out.println("");
                    sorteiaParamBast_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 5) {
                    System.out
                            .println("|-----(1.5)-sorteioAleatorioArraylist()-----|");
                    System.out.println("");
                    sorteioAleatorioArraylist_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 6) {
                    System.out
                            .println("|-----------------(1.6)-SAIR----------------|");
                    enuricEstaNaFaixa = true;
                    System.out.println("");
                    System.out.println("");
                }
            }
        }
    }

    private static void metodoManipulaStrings_2() {

        boolean enuricEstaNaFaixa = false;
        while (enuricEstaNaFaixa == false) {
            MenuManipulaStrings_2();
            String var = le.nextLine();
            enuricEstaNaFaixa = eNumericoEstaFaixaMain(var, 9);
            if (enuricEstaNaFaixa == true) {
                auxMenu = Integer.parseInt(var);
                if (auxMenu == 1) {
                    System.out
                            .println("|-----(2.1)-geraNomeCompletoAleatorio()-----|");
                    System.out.println("");
                    geraNomeCompletoAleatorio_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 2) {
                    System.out
                            .println("|-------------(2.2)-GeraTelefone()----------|");
                    System.out.println("");
                    GeraTelefone_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 3) {
                    System.out
                            .println("|--------------(2.3)-GeraGmail()------------|");
                    System.out.println("");
                    GeraGmail_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 4) {
                    System.out
                            .println("|------------(2.4)-GeraObservacao()---------|");
                    System.out.println("");
                    GeraObservacao_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 5) {
                    System.out
                            .println("|------------(2.5)-retiraAspasHtml----------|");
                    System.out.println("");
                    retiraAspasHtml_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 6) {
                    System.out
                            .println("|-------------(2.6)-removeSpaces()----------|");
                    System.out.println("");
                    removeSpaces_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 7) {
                    System.out
                            .println("|-------------(2.7)-primeiroNome()----------|");
                    System.out.println("");
                    primeiroNome_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 8) {
                    System.out
                            .println("|-------------(2.8)-elimina_aspas_View()----------|");
                    System.out.println("");
                    elimina_aspas_View();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 9) {
                    System.out
                            .println("|----------------(2.9)-SAIR-----------------|");
                    enuricEstaNaFaixa = true;
                    System.out.println("");
                    System.out.println("");
                }
            }
        }
    }

    private static void metodoManipulaDatas_3_1() {

        boolean enuricEstaNaFaixa = false;
        while (enuricEstaNaFaixa == false) {
            menuManipulaDatas_3_1();
            String var = le.nextLine();
            enuricEstaNaFaixa = eNumericoEstaFaixaMain(var, 11);
            if (enuricEstaNaFaixa == true) {
                auxMenu = Integer.parseInt(var);
                if (auxMenu == 1) {
                    System.out
                            .println("|-------------(3.1)-formataData()-----------|");
                    System.out.println("");
                    formataData_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 2) {
                    System.out
                            .println("|----------(3.2)-formataDataString()--------|");
                    System.out.println("");
                    formataDataString_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 3) {
                    System.out
                            .println("|------------(3.3)-verificaData()-----------|");
                    System.out.println("");
                    verificaData_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 4) {
                    System.out
                            .println("|------------(3.4)-verificaHora()-----------|");
                    System.out.println("");
                    verificaHora_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 5) {
                    System.out
                            .println("|-----------(3.5)-getWeeksOfMonth()---------|");
                    System.out.println("");
                    getWeeksOfMonth_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 6) {
                    System.out
                            .println("|--------(3.6)-getDiasDeDeusTerQua()--------|");
                    System.out.println("");
                    getDiasDeDeusTerQua_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 7) {
                    System.out
                            .println("|---------(3.7)-getDiasDeDeusQuaQui()-------|");
                    System.out.println("");
                    getDiasDeDeusQuaQui_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 8) {
                    System.out
                            .println("|--(3.8)-getDiasDeDeusTerQuaAnoSeguinte()---|");
                    System.out.println("");
                    getDiasDeDeusTerQuaAnoSeguinte_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 9) {
                    System.out
                            .println("|--(3.9)-getDiasDeDeusQuaQuiAnoSeguinte()---|");
                    System.out.println("");
                    getDiasDeDeusQuaQuiAnoSeguinte_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 10) {
                    System.out
                            .println("|-----------(3.10)-getMesesdoAno()----------|");
                    System.out.println("");
                    getMesesdoAno_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 11) {
                    System.out
                            .println("|---------------(3.11)-SAIR-----------------|");
                    enuricEstaNaFaixa = true;
                    System.out.println("");
                    System.out.println("");
                }
            }
        }
    }

    private static void metodoManipulaDatas_3_2() {

        boolean enuricEstaNaFaixa = false;
        while (enuricEstaNaFaixa == false) {
            menuManipulaDatas_3_2();
            String var = le.nextLine();
            enuricEstaNaFaixa = eNumericoEstaFaixaMain(var, 14);
            if (enuricEstaNaFaixa == true) {
                auxMenu = Integer.parseInt(var);
                if (auxMenu == 1) {
                    System.out
                            .println("|------------(4.1)-getDiaDaSemana()--------|");
                    System.out.println("");
                    getDiaDaSemana_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 2) {
                    System.out
                            .println("----------(4.2)-get6em6MesesDoAno()--------|");
                    System.out.println("");
                    get6em6MesesDoAno_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 3) {
                    System.out
                            .println("|-------------(4.3)-calcIdade()------------|");
                    System.out.println("");
                    calcIdade_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 4) {
                    System.out
                            .println("|----------(4.4)-calcIdadeString()---------|");
                    System.out.println("");
                    calcIdadeString_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 5) {
                    System.out
                            .println("|-----------(4.5)-retornaDiaSemana()-------|");
                    retornaDiaSemana_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 6) {
                    System.out
                            .println("|-------------(4.6)-dataPassada()----------|");
                    System.out.println("");
                    dataPassada_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 7) {
                    System.out
                            .println("|-----------(4.7)-getHojeFormat()----------|");
                    System.out.println("");
                    getHojeFormat_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 8) {
                    System.out
                            .println("|---------------(4.8)-horaNow()------------|");
                    System.out.println("");
                    horaNow_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 9) {
                    System.out
                            .println("|--------------(4.9)-getHoje()-------------|");
                    System.out.println("");
                    getHoje_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 10) {
                    System.out
                            .println("|------------(4.10)-subtraiHora()-----------|");
                    System.out.println("");
                    subtraiHora_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 11) {
                    System.out
                            .println("|------------(4.11)-getDATA()---------------|");
                    System.out.println("");
                    getDATA_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 12) {
                    System.out
                            .println("|------------(4.12)-getMinutos()------------|");
                    System.out.println("");
                    getMinutos_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 13) {
                    System.out
                            .println("|----(4.13)-retornaDadosAniversario()-------|");
                    System.out.println("");
                    retornaDadosAniversario_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 14) {
                    System.out
                            .println("|---------------(4.14)-SAIR-----------------|");
                    enuricEstaNaFaixa = true;
                    System.out.println("");
                    System.out.println("");
                }
            }
        }
    }

    private static void metodoVerificacoes_4_1() {
        boolean enuricEstaNaFaixa = false;
        while (enuricEstaNaFaixa == false) {
            menuVerificacoes_4_1();
            String var = le.nextLine();
            enuricEstaNaFaixa = eNumericoEstaFaixaMain(var, 12);
            if (enuricEstaNaFaixa == true) {
                auxMenu = Integer.parseInt(var);
                if (auxMenu == 1) {
                    System.out
                            .println("|-------(5.1)-verificaNumerosString()-------|");
                    System.out.println("");
                    verificaNumerosString_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 2) {
                    System.out
                            .println("|-------------(5.2)-ehNumerico()------------|");
                    System.out.println("");
                    ehNumerico_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 3) {
                    System.out
                            .println("|----------(5.3)-ehNumerico02()-------------|");
                    System.out.println("");
                    ehNumerico02_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 4) {
                    System.out
                            .println("|----------(5.4)-tamanhoIgualA11()----------|");
                    System.out.println("");
                    tamanhoIgualA11_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 5) {
                    System.out
                            .println("|--------------(5.5)-nhaFaixa1()------------|");
                    System.out.println("");
                    nhaFaixa1_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 6) {
                    System.out
                            .println("|-----------(5.6)-naFaixaEntre1e9()---------|");
                    System.out.println("");
                    naFaixaEntre1e9_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 7) {
                    System.out
                            .println("|------------(5.7)-naFaixaEntre1e2()--------|");
                    System.out.println("");
                    naFaixaEntre1e2_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 8) {
                    System.out
                            .println("|----------(5.8)-tamanhoEntre4e9()----------|");
                    System.out.println("");
                    tamanhoEntre4e9_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 9) {
                    System.out
                            .println("|----------(5.9)-tamanhoEntre1e11()---------|");
                    System.out.println("");
                    tamanhoEntre1e11_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 10) {
                    System.out
                            .println("|-------------(5.10)-nhaFaixa2()------------|");
                    System.out.println("");
                    nhaFaixa2_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 11) {
                    System.out
                            .println("|-----(5.11)-eNumericoEstaFaixaGeneric()----|");
                    System.out.println("");
                    eNumericoEstaFaixaGeneric_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 12) {
                    System.out
                            .println("|----------------(5.12)-SAIR----------------|");
                    enuricEstaNaFaixa = true;
                    System.out.println("");
                    System.out.println("");
                }
            }
        }
    }

    private static void metodoVerificacoes_4_2() {
        boolean enuricEstaNaFaixa = false;
        while (enuricEstaNaFaixa == false) {
            menuVerificacoes_4_2();
            String var = le.nextLine();
            enuricEstaNaFaixa = eNumericoEstaFaixaMain(var, 12);
            if (enuricEstaNaFaixa == true) {
                auxMenu = Integer.parseInt(var);
                if (auxMenu == 1) {
                    System.out
                            .println("|------------------(6.1)-naFaixaEntre1e5()--------------|");
                    System.out.println("");
                    naFaixaEntre1e5_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 2) {
                    System.out
                            .println("|------------(6.2)-naFaixaEntre1e6()--------|");
                    System.out.println("");
                    naFaixaEntre1e6_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 3) {
                    System.out
                            .println("|----------(6.3)-naFaixaEntre1a7()---------|");
                    System.out.println("");
                    naFaixaEntre1a7_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 4) {
                    System.out
                            .println("|---------(6.4)-naFaixaEntre1a9()----------|");
                    System.out.println("");
                    naFaixaEntre1a9_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 5) {
                    System.out
                            .println("|-----------(6.5)-nhaFaixa1a8()------------|");
                    System.out.println("");
                    nhaFaixa1a8_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 6) {
                    System.out
                            .println("|------------(6.6)-nhaFaixa3()-------------|");
                    System.out.println("");
                    nhaFaixa3_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 7) {
                    System.out
                            .println("|----------(6.7)-naFaixaEntre1e3()---------|");
                    System.out.println("");
                    naFaixaEntre1e3_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 8) {
                    System.out
                            .println("|--------(6.8)-validaIdentificador()-------|");
                    System.out.println("");
                    validaIdentificador_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 9) {
                    System.out
                            .println("|-------(6.9)-validaIdentificador2()-------|");
                    System.out.println("");
                    validaIdentificador2_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 10) {
                    System.out
                            .println("|------(6.10)-retornaTypeIdentificador()----|");
                    retornaTypeIdentificador_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 11) {
                    System.out
                            .println("|-----------(6.11)-WhatSystemOS()-----------|");
                    System.out.println("");
                    WhatSystemOS_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 12) {
                    System.out
                            .println("|----------------(6.12)-SAIR----------------|");
                    enuricEstaNaFaixa = true;
                    System.out.println("");
                    System.out.println("");
                }
            }
        }
    }

    private static void metodoManipulaArquivos_5() {
        boolean enuricEstaNaFaixa = false;
        while (enuricEstaNaFaixa == false) {
            memuManipulaArquivos_5();
            String var = le.nextLine();
            enuricEstaNaFaixa = eNumericoEstaFaixaMain(var, 8);
            if (enuricEstaNaFaixa == true) {
                auxMenu = Integer.parseInt(var);
                if (auxMenu == 1) {
                    System.out
                            .println("|-----------(7.1)-salvarArquivo()-----------|");
                    System.out.println("");
                    salvarArquivo_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 2) {
                    System.out
                            .println("|--------(7.2)-removieContentFile()---------|");
                    System.out.println("");
                    removieContentFile_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 3) {
                    System.out
                            .println("|------------(7.3)-AbreArquivo()------------|");
                    System.out.println("");
                    AbreArquivo_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 4) {
                    System.out
                            .println("|-------------(7.4)-deletFile()-------------|");
                    System.out.println("");
                    deletFile_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 5) {
                    System.out
                            .println("|----(7.5)-sorteioAleatorioArraylist()------|");
                    System.out.println("");
                    sorteioAleatorioArraylist_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 6) {
                    System.out
                            .println("|--------(7.6)-lerArquivoPrincipal()--------|");
                    System.out.println("");
                    lerArquivoPrincipal_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 7) {
                    System.out
                            .println("|------------(7.7)-Writingfile()------------|");
                    System.out.println("");
                    Writingfile_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 8) {
                    System.out
                            .println("|-----------------(7.8)-SAIR----------------|");
                    enuricEstaNaFaixa = true;
                    System.out.println("");
                    System.out.println("");
                }
            }
        }
    }

    private static void metodoDemostracao_6() {
        boolean enuricEstaNaFaixa = false;
        while (enuricEstaNaFaixa == false) {
            menuDemostracao_6();
            String var = le.nextLine();
            enuricEstaNaFaixa = eNumericoEstaFaixaMain(var, 8);
            if (enuricEstaNaFaixa == true) {
                auxMenu = Integer.parseInt(var);
                if (auxMenu == 1) {
                    System.out
                            .println("|----------(8.1)-HasMapInterator()----------|");
                    System.out.println("");
                    HasMapInterator_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 2) {
                    System.out
                            .println("|--------------(8.2)-LoopMap()--------------|");
                    System.out.println("");
                    LoopMap_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 3) {
                    System.out
                            .println("|----------(8.3)-StringBufferDemo()---------|");
                    System.out.println("");
                    StringBufferDemo_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 4) {
                    System.out
                            .println("|---------(8.4)-imprimeArrayList()----------|");
                    System.out.println("");
                    imprimeArrayList_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 5) {
                    System.out
                            .println("|----------(8.5)-retiraAspasHtml()----------|");
                    System.out.println("");
                    retiraAspasHtml_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 6) {
                    System.out
                            .println("|----------(8.6)-removeSpaces()-------------|");
                    System.out.println("");
                    removeSpaces_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 7) {
                    System.out
                            .println("|------------(8.7)-primeiroNome()-----------|");
                    System.out.println("");
                    primeiroNome_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 8) {
                    System.out
                            .println("|------------------(8.8)-SAIR---------------|");
                    enuricEstaNaFaixa = true;
                    System.out.println("");
                    System.out.println("");
                }
            }
        }
    }

    private static void metodoGeraMD5_7() {
        boolean enuricEstaNaFaixa = false;
        while (enuricEstaNaFaixa == false) {
            menudoGeraMD5_7();
            String var = le.nextLine();
            enuricEstaNaFaixa = eNumericoEstaFaixaMain(var, 2);
            if (enuricEstaNaFaixa == true) {
                auxMenu = Integer.parseInt(var);
                if (auxMenu == 1) {
                    System.out
                            .println("|-------------(9.1)-geraMD5()---------------|");
                    System.out.println("");
                    geraMD5_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 2) {
                    System.out
                            .println("|----------------(9.2)-SAIR-----------------|");
                    enuricEstaNaFaixa = true;
                    System.out.println("");
                    System.out.println("");
                }
            }
        }
    }

    private static void metodoSubmeteURL_8() {
        boolean enuricEstaNaFaixa = false;
        while (enuricEstaNaFaixa == false) {
            menudoSubmeteURL_8();
            String var = le.nextLine();
            enuricEstaNaFaixa = eNumericoEstaFaixaMain(var, 2);
            if (enuricEstaNaFaixa == true) {
                auxMenu = Integer.parseInt(var);
                if (auxMenu == 1) {
                    System.out
                            .println("|------------(10.1)-submeterUrl()-----------|");
                    System.out.println("");
                    submeterUrl_VIEW();
                    System.out.println("");
                    enuricEstaNaFaixa = false;
                } else if (auxMenu == 2) {
                    System.out
                            .println("|----------------(10.2)-SAIR----------------|");
                    enuricEstaNaFaixa = true;
                    System.out.println("");
                    System.out.println("");
                }
            }
        }
    }

    public static void menuPrincipal() {

        System.out.println("|-------------|-MENU-PRINCIPAL-|------------|");
        System.out.println("|------****-CATEGORIAS-DE-METODOS-****------|");
        System.out.println("|-(01)-METODOS-DE-SORTEIO-------------------|");
        System.out.println("|-(02)-METODOS-DE-MANIPULAÇÃO DE STRINGS----|");
        System.out.println("|-(03)-METODOS-DE-MANIPULAÇÃO DE DATAS-I----|");
        System.out.println("|-(04)-METODOS-DE-MANIPULAÇÃO DE DATAS-II---|");
        System.out.println("|-(05)-METODOS-DE-VERIFICAÇÕES-I------------|");
        System.out.println("|-(06)-METODOS-DE-VERIFICAÇÕES-II-----------|");
        System.out.println("|-(07)-METODOS-DE-MANIPULAÇÃO DE ARQUIVOS---|");
        System.out.println("|-(08)-METODOS-DE-DEMOSTRAÇÃO---------------|");
        System.out.println("|-(09)-METODOS-DE-GERA-MD5------------------|");
        System.out.println("|-(10)-METODOS-DE-SUBMETE-URL-HTTP----------|");
        System.out.println("|-(11)-PARA SAIR----------------------------|");
        System.out.println("|-------------|--------x-------|------------|");
        System.out.println("");
        System.out.println("");
    }

    private static void MenuSorteio_1() {
        System.out.println("|-------------(1)-Menu Sorteio--------------|");
        System.out.println("|-(01)-geraAleatorio------------------------|");
        System.out.println("|-(02)-sorteia------------------------------|");
        System.out.println("|-(03)-sorteiaParam-------------------------|");
        System.out.println("|-(04)-sorteiaParamBast---------------------|");
        System.out.println("|-(05)-sorteioAleatorioArraylist------------|");
        System.out.println("|-(06)-SAIR---------------------------------|");
        System.out.println("|---------------------x---------------------|");
        System.out.println("");
        System.out.println("");
    }

    private static void MenuManipulaStrings_2() {
        System.out.println("|----------(2)-Menu Manipula Strings--------|");
        System.out.println("|-(01)-geraNomeCompletoAleatorio()----------|");
        System.out.println("|-(02)-GeraTelefone-------------------------|");
        System.out.println("|-(03)-GeraGmail----------------------------|");
        System.out.println("|-(04)-GeraObservacao-----------------------|");
        System.out.println("|-(05)-retiraAspasHtml----------------------|");
        System.out.println("|-(06)-removeSpaces()-----------------------|");
        System.out.println("|-(07)-primeiroNome-------------------------|");
        System.out.println("|-(08)-elimina_aspas_View-------------------|");
        System.out.println("|-(09)-SAIR---------------------------------|");
        System.out.println("|---------------------x---------------------|");
        System.out.println("");
        System.out.println("");
    }

    private static void menuManipulaDatas_3_1() {
        System.out.println("|----------(3)-Menu Manipula Datas-I--------|");
        System.out.println("|-(01)-formataData()------------------------|");
        System.out.println("|-(02)-formataDataString()------------------|");
        System.out.println("|-(03)-verificaData()-----------------------|");
        System.out.println("|-(04)-verificaHora()-----------------------|");
        System.out.println("|-(05)-getWeeksOfMonth()--------------------|");
        System.out.println("|-(06)-getDiasDeDeusTerQua()----------------|");
        System.out.println("|-(07)-getDiasDeDeusQuaQui()----------------|");
        System.out.println("|-(08)-getDiasDeDeusTerQuaAnoSeguinte()-----|");
        System.out.println("|-(09)-getDiasDeDeusQuaQuiAnoSeguinte()-----|");
        System.out.println("|-(10)-getMesesdoAno()----------------------|");
        System.out.println("|-(11)-SAIR---------------------------------|");
        System.out.println("|---------------------x---------------------|");
        System.out.println("");
        System.out.println("");
    }

    private static void menuManipulaDatas_3_2() {
        System.out.println("|----------(4)-Menu Manipula Datas-II-------|");
        System.out.println("|-(01)-getDiaDaSemana()---------------------|");
        System.out.println("|-(02)-get6em6MesesDoAno()------------------|");
        System.out.println("|-(03)-calcIdade()--------------------------|");
        System.out.println("|-(04)-calcIdadeString()--------------------|");
        System.out.println("|-(05)-retornaDiaSemana()-------------------|");
        System.out.println("|-(06)-dataPassada()------------------------|");
        System.out.println("|-(07)-getHojeFormat()----------------------|");
        System.out.println("|-(08)-horaNow()----------------------------|");
        System.out.println("|-(09)-getHoje()----------------------------|");
        System.out.println("|-(10)-subtraiHora()------------------------|");
        System.out.println("|-(11)-getDATA()----------------------------|");
        System.out.println("|-(12)-getMinutos()-------------------------|");
        System.out.println("|-(13)-retornaDadosAniversario--------------|");
        System.out.println("|-(14)-SAIR---------------------------------|");
        System.out.println("|----------------------x--------------------|");
        System.out.println("");
        System.out.println("");
    }

    private static void menuVerificacoes_4_1() {
        System.out.println("|---------(5)-Menu Verificacoes-I-----------|");
        System.out.println("|-(01)-verificaNumerosString()--------------|");
        System.out.println("|-(02)-ehNumerico()-------------------------|");
        System.out.println("|-(03)-ehNumerico02()-----------------------|");
        System.out.println("|-(04)-tamanhoIgualA11()--------------------|");
        System.out.println("|-(05)-nhaFaixa1()--------------------------|");
        System.out.println("|-(06)-naFaixaEntre1e9()--------------------|");
        System.out.println("|-(07)-naFaixaEntre1e2()--------------------|");
        System.out.println("|-(08)-tamanhoEntre4e9()--------------------|");
        System.out.println("|-(09)-gtamanhoEntre1e11()------------------|");
        System.out.println("|-(10)-nhaFaixa2()--------------------------|");
        System.out.println("|-(11)-eNumericoEstaFaixaGeneric()----------|");
        System.out.println("|-(12)-SAIR---------------------------------|");
        System.out.println("|---------------------x---------------------|");
        System.out.println("");
        System.out.println("");
    }

    private static void menuVerificacoes_4_2() {
        System.out.println("|---------(6)-Menu Verificacoes-II----------|");
        System.out.println("|-(01)-naFaixaEntre1e5()--------------------|");
        System.out.println("|-(02)-naFaixaEntre1e6()--------------------|");
        System.out.println("|-(03)-naFaixaEntre1a7()--------------------|");
        System.out.println("|-(04)-naFaixaEntre1a9()--------------------|");
        System.out.println("|-(05)-nhaFaixa1a8()------------------------|");
        System.out.println("|-(06)-nhaFaixa3()--------------------------|");
        System.out.println("|-(07)-naFaixaEntre1e3()--------------------|");
        System.out.println("|-(08)-validaIdentificador()----------------|");
        System.out.println("|-(09)-validaIdentificador2()---------------|");
        System.out.println("|-(10)-retornaTypeIdentificador()-----------|");
        System.out.println("|-(11)-WhatSystemOS()-----------------------|");
        System.out.println("|-(12)-SAIR---------------------------------|");
        System.out.println("|----------------------x--------------------|");
        System.out.println("");
        System.out.println("");
    }

    private static void memuManipulaArquivos_5() {
        System.out.println("|--------(5)-Memu Manipula Arquivos---------|");
        System.out.println("|-(01)-salvarArquivo()----------------------|");
        System.out.println("|-(02)-removieContentFile()-----------------|");
        System.out.println("|-(03)-AbreArquivo()------------------------|");
        System.out.println("|-(04)-deletFile()--------------------------|");
        System.out.println("|-(05)-createFile()-------------------------|");
        System.out.println("|-(06)-lerArquivoPrincipal()----------------|");
        System.out.println("|-(07)-Writingfile()------------------------|");
        System.out.println("|-(08)-SAIR---------------------------------|");
        System.out.println("|----------------------x--------------------|");
        System.out.println("");
        System.out.println("");
    }

    private static void menuDemostracao_6() {
        System.out.println("|------------(6)-Menu Demostracao-----------|");
        System.out.println("|-(01)-HasMapInterator()--------------------|");
        System.out.println("|-(02)-LoopMap()----------------------------|");
        System.out.println("|-(03)-StringBufferDemo()-------------------|");
        System.out.println("|-(04)-imprimeArrayList()-------------------|");
        System.out.println("|-(05)-retiraAspasHtml()--------------------|");
        System.out.println("|-(06)-removeSpaces()-----------------------|");
        System.out.println("|-(07)-primeiroNome()-----------------------|");
        System.out.println("|-(08)-SAIR---------------------------------|");
        System.out.println("|----------------------x--------------------|");
        System.out.println("");
        System.out.println("");
    }

    private static void menudoGeraMD5_7() {
        System.out.println("|-------------(7)-Menu Gera MD5-------------|");
        System.out.println("|-(01)-geraMD5()----------------------------|");
        System.out.println("|-(02)-SAIR---------------------------------|");
        System.out.println("|----------------------x--------------------|");
        System.out.println("");
        System.out.println("");
    }

    private static void menudoSubmeteURL_8() {
        System.out.println("|------------(8)-Menu Submete URL-----------|");
        System.out.println("|-(01)-submeterUrl()------------------------|");
        System.out.println("|-(02)-SAIR---------------------------------|");
        System.out.println("|----------------------x--------------------|");
        System.out.println("");
        System.out.println("");
    }

    public static Scanner getLe() {
        return le;
    }

    public static void setLe(Scanner le) {
        MetodoAuxiliar.le = le;
    }

    public static int getAuxMenu() {
        return auxMenu;
    }

    public static void setAuxMenu(int auxMenu) {
        MetodoAuxiliar.auxMenu = auxMenu;
    }

    public static String getNum1() {
        return num1;
    }

    public static void setNum1(String num1) {
        MetodoAuxiliar.num1 = num1;
    }

    public static String getNum2() {
        return num2;
    }

    public static void setNum2(String num2) {
        MetodoAuxiliar.num2 = num2;
    }
    // System.out.println("|-------------------PADRAO------------------|");

    /*-----------------------------------FIM----------------------------------*/
    /*-----------------------------RUM-CONTROLADORES--------------------------*/
    /*-----------------------------RUM-CONTROLADORES--------------------------*/
    /*-----------------------------------FIM----------------------------------*/
}// ultimo
