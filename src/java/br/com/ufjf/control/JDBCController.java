package br.com.ufjf.control;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import br.com.ufjf.model.AnrafelSQL01;
import br.com.ufjf.model.AnrafelSQL02;
import br.com.ufjf.model.AnrafelSQL03;
import br.com.ufjf.model.AnrafelSQL04;
import br.com.ufjf.model.AnrafelSQL05;
import br.com.ufjf.model.AnrafelSQL06;
import br.com.ufjf.model.AnrafelSQL07;
import br.com.ufjf.model.AnrafelSQL07_1;
import br.com.ufjf.model.AnrafelSQL07_2;
import br.com.ufjf.model.AnrafelSQL07_3;
import br.com.ufjf.model.AnrafelSQL08;
import br.com.ufjf.model.AnrafelSQL08_1;
import br.com.ufjf.model.AnrafelSQL08_2;
import br.com.ufjf.model.AnrafelSQL08_3;
import br.com.ufjf.model.AnrafelSQL08_4;
import br.com.ufjf.model.AnrafelSQL09;
import br.com.ufjf.model.AnrafelSQL09_1;
import br.com.ufjf.model.AnrafelSQL09_2;
import br.com.ufjf.model.AnrafelSQL09_3;
import br.com.ufjf.model.AnrafelSQL09_4;
import br.com.ufjf.model.AnrafelSQL10;
import br.com.ufjf.model.AnrafelSQL11;
import br.com.ufjf.model.ProductDevArtifact;
import br.com.ufjf.util.ConnectionFactory;

/**
 * Classe JDBCController
 *
 * @category control
 * @author magnus, anrafel, jonathan
 *
 */
public class JDBCController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static ProductDevArtifact productDevArtifact;
    private static ArrayList<ProductDevArtifact> listProductDevArtifact = new ArrayList<ProductDevArtifact>();
    private static PreparedStatement ps;
    private static Connection conect;
    private static ResultSet rs;
    private static AnrafelSQL01 anrafelSQL01;
    private static AnrafelSQL02 anrafelSQL02;
    private static AnrafelSQL03 anrafelSQL03;
    private static AnrafelSQL04 anrafelSQL04;
    private static AnrafelSQL05 anrafelSQL05;
    private static AnrafelSQL06 anrafelSQL06;
    private static AnrafelSQL07 anrafelSQL07;
    private static AnrafelSQL07 anrafelSQL07_1;
    private static AnrafelSQL07 anrafelSQL07_2;
    private static AnrafelSQL07 anrafelSQL07_3;

    private static AnrafelSQL07 anrafelSQL08;
    private static AnrafelSQL07 anrafelSQL08_1;
    private static AnrafelSQL07 anrafelSQL08_2;
    private static AnrafelSQL07 anrafelSQL08_3;
    private static AnrafelSQL07 anrafelSQL08_4;

    private static AnrafelSQL07 anrafelSQL09;
    private static AnrafelSQL07 anrafelSQL09_1;
    private static AnrafelSQL07 anrafelSQL09_2;
    private static AnrafelSQL07 anrafelSQL09_3;
    private static AnrafelSQL07 anrafelSQL09_4;

    private static ArrayList<AnrafelSQL01> listAnrafelSQL01 = new ArrayList<AnrafelSQL01>();
    private static ArrayList<AnrafelSQL02> listAnrafelSQL02 = new ArrayList<AnrafelSQL02>();
    private static ArrayList<AnrafelSQL03> listAnrafelSQL03 = new ArrayList<AnrafelSQL03>();
    private static ArrayList<AnrafelSQL04> listAnrafelSQL04 = new ArrayList<AnrafelSQL04>();
    private static ArrayList<AnrafelSQL05> listAnrafelSQL05 = new ArrayList<AnrafelSQL05>();
    private static ArrayList<AnrafelSQL06> listAnrafelSQL06 = new ArrayList<AnrafelSQL06>();
    private static ArrayList<AnrafelSQL07> listAnrafelSQL07 = new ArrayList<AnrafelSQL07>();
    private static ArrayList<AnrafelSQL07_1> listAnrafelSQL07_1 = new ArrayList<AnrafelSQL07_1>();
    private static ArrayList<AnrafelSQL07_2> listAnrafelSQL07_2 = new ArrayList<AnrafelSQL07_2>();
    private static ArrayList<AnrafelSQL07_3> listAnrafelSQL07_3 = new ArrayList<AnrafelSQL07_3>();

    private static ArrayList<AnrafelSQL08> listAnrafelSQL08 = new ArrayList<AnrafelSQL08>();
    private static ArrayList<AnrafelSQL08_1> listAnrafelSQL08_1 = new ArrayList<AnrafelSQL08_1>();
    private static ArrayList<AnrafelSQL08_2> listAnrafelSQL08_2 = new ArrayList<AnrafelSQL08_2>();
    private static ArrayList<AnrafelSQL08_3> listAnrafelSQL08_3 = new ArrayList<AnrafelSQL08_3>();
    private static ArrayList<AnrafelSQL08_4> listAnrafelSQL08_4 = new ArrayList<AnrafelSQL08_4>();

    private static ArrayList<AnrafelSQL09> listAnrafelSQL09 = new ArrayList<AnrafelSQL09>();
    private static ArrayList<AnrafelSQL09_1> listAnrafelSQL09_1 = new ArrayList<AnrafelSQL09_1>();
    private static ArrayList<AnrafelSQL09_2> listAnrafelSQL09_2 = new ArrayList<AnrafelSQL09_2>();
    private static ArrayList<AnrafelSQL09_3> listAnrafelSQL09_3 = new ArrayList<AnrafelSQL09_3>();
    private static ArrayList<AnrafelSQL09_4> listAnrafelSQL09_4 = new ArrayList<AnrafelSQL09_4>();

    private static ArrayList<AnrafelSQL10> listAnrafelSQL10 = new ArrayList<AnrafelSQL10>();
    private static ArrayList<AnrafelSQL11> listAnrafelSQL11 = new ArrayList<AnrafelSQL11>();

    public static ProductDevArtifact getProductDevArtifact() {
        return productDevArtifact;
    }

    public static void setProductDevArtifact(
            ProductDevArtifact productDevArtifact) {
        JDBCController.productDevArtifact = productDevArtifact;
    }

    public static ArrayList<ProductDevArtifact> getListProductDevArtifact() {
        return listProductDevArtifact;
    }

    public static void setListProductDevArtifact(
            ArrayList<ProductDevArtifact> listProductDevArtifact) {
        JDBCController.listProductDevArtifact = listProductDevArtifact;
    }

    public static PreparedStatement getPs() {
        return ps;
    }

    public static void setPs(PreparedStatement ps) {
        JDBCController.ps = ps;
    }

    public static Connection getConect() {
        return conect;
    }

    public static void setConect(Connection conect) {
        JDBCController.conect = conect;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void setRs(ResultSet rs) {
        JDBCController.rs = rs;
    }

    public static AnrafelSQL02 getAnrafelSQL02() {
        return anrafelSQL02;
    }

    public static void setAnrafelSQL02(AnrafelSQL02 anrafelSQL02) {
        JDBCController.anrafelSQL02 = anrafelSQL02;
    }

    public static AnrafelSQL03 getAnrafelSQL03() {
        return anrafelSQL03;
    }

    public static void setAnrafelSQL03(AnrafelSQL03 anrafelSQL03) {
        JDBCController.anrafelSQL03 = anrafelSQL03;
    }

    public static AnrafelSQL04 getAnrafelSQL04() {
        return anrafelSQL04;
    }

    public static void setAnrafelSQL04(AnrafelSQL04 anrafelSQL04) {
        JDBCController.anrafelSQL04 = anrafelSQL04;
    }

    public static AnrafelSQL05 getAnrafelSQL05() {
        return anrafelSQL05;
    }

    public static void setAnrafelSQL05(AnrafelSQL05 anrafelSQL05) {
        JDBCController.anrafelSQL05 = anrafelSQL05;
    }

    public static AnrafelSQL06 getAnrafelSQL06() {
        return anrafelSQL06;
    }

    public static void setAnrafelSQL06(AnrafelSQL06 anrafelSQL06) {
        JDBCController.anrafelSQL06 = anrafelSQL06;
    }

    public static ArrayList<AnrafelSQL02> getListAnrafelSQL02() {
        return listAnrafelSQL02;
    }

    public static void setListAnrafelSQL02(
            ArrayList<AnrafelSQL02> listAnrafelSQL02) {
        JDBCController.listAnrafelSQL02 = listAnrafelSQL02;
    }

    public static ArrayList<AnrafelSQL03> getListAnrafelSQL03() {
        return listAnrafelSQL03;
    }

    public static void setListAnrafelSQL03(
            ArrayList<AnrafelSQL03> listAnrafelSQL03) {
        JDBCController.listAnrafelSQL03 = listAnrafelSQL03;
    }

    public static ArrayList<AnrafelSQL04> getListAnrafelSQL04() {
        return listAnrafelSQL04;
    }

    public static void setListAnrafelSQL04(
            ArrayList<AnrafelSQL04> listAnrafelSQL04) {
        JDBCController.listAnrafelSQL04 = listAnrafelSQL04;
    }

    public static ArrayList<AnrafelSQL05> getListAnrafelSQL05() {
        return listAnrafelSQL05;
    }

    public static void setListAnrafelSQL05(
            ArrayList<AnrafelSQL05> listAnrafelSQL05) {
        JDBCController.listAnrafelSQL05 = listAnrafelSQL05;
    }

    public static ArrayList<AnrafelSQL06> getListAnrafelSQL06() {
        return listAnrafelSQL06;
    }

    public static void setListAnrafelSQL06(
            ArrayList<AnrafelSQL06> listAnrafelSQL06) {
        JDBCController.listAnrafelSQL06 = listAnrafelSQL06;
    }

    public static AnrafelSQL01 getAnrafelSQL01() {
        return anrafelSQL01;
    }

    public static void setAnrafelSQL01(AnrafelSQL01 anrafelSQL01) {
        JDBCController.anrafelSQL01 = anrafelSQL01;
    }

    public static ArrayList<AnrafelSQL01> getListAnrafelSQL01() {
        return listAnrafelSQL01;
    }

    public static void setListAnrafelSQL01(
            ArrayList<AnrafelSQL01> listAnrafelSQL01) {
        JDBCController.listAnrafelSQL01 = listAnrafelSQL01;
    }

    public static AnrafelSQL07 getAnrafelSQL07() {
        return anrafelSQL07;
    }

    public static void setAnrafelSQL07(AnrafelSQL07 anrafelSQL07) {
        JDBCController.anrafelSQL07 = anrafelSQL07;
    }

    public static AnrafelSQL07 getAnrafelSQL07_1() {
        return anrafelSQL07_1;
    }

    public static void setAnrafelSQL07_1(AnrafelSQL07 anrafelSQL07_1) {
        JDBCController.anrafelSQL07_1 = anrafelSQL07_1;
    }

    public static AnrafelSQL07 getAnrafelSQL07_2() {
        return anrafelSQL07_2;
    }

    public static void setAnrafelSQL07_2(AnrafelSQL07 anrafelSQL07_2) {
        JDBCController.anrafelSQL07_2 = anrafelSQL07_2;
    }

    public static AnrafelSQL07 getAnrafelSQL07_3() {
        return anrafelSQL07_3;
    }

    public static void setAnrafelSQL07_3(AnrafelSQL07 anrafelSQL07_3) {
        JDBCController.anrafelSQL07_3 = anrafelSQL07_3;
    }

    public static ArrayList<AnrafelSQL07> getListAnrafelSQL07() {
        return listAnrafelSQL07;
    }

    public static void setListAnrafelSQL07(
            ArrayList<AnrafelSQL07> listAnrafelSQL07) {
        JDBCController.listAnrafelSQL07 = listAnrafelSQL07;
    }

    public static ArrayList<AnrafelSQL07_1> getListAnrafelSQL07_1() {
        return listAnrafelSQL07_1;
    }

    public static void setListAnrafelSQL07_1(
            ArrayList<AnrafelSQL07_1> listAnrafelSQL07_1) {
        JDBCController.listAnrafelSQL07_1 = listAnrafelSQL07_1;
    }

    public static ArrayList<AnrafelSQL07_2> getListAnrafelSQL07_2() {
        return listAnrafelSQL07_2;
    }

    public static void setListAnrafelSQL07_2(
            ArrayList<AnrafelSQL07_2> listAnrafelSQL07_2) {
        JDBCController.listAnrafelSQL07_2 = listAnrafelSQL07_2;
    }

    public static ArrayList<AnrafelSQL07_3> getListAnrafelSQL07_3() {
        return listAnrafelSQL07_3;
    }

    public static void setListAnrafelSQL07_3(
            ArrayList<AnrafelSQL07_3> listAnrafelSQL07_3) {
        JDBCController.listAnrafelSQL07_3 = listAnrafelSQL07_3;
    }

    public static AnrafelSQL07 getAnrafelSQL08() {
        return anrafelSQL08;
    }

    public static void setAnrafelSQL08(AnrafelSQL07 anrafelSQL08) {
        JDBCController.anrafelSQL08 = anrafelSQL08;
    }

    public static AnrafelSQL07 getAnrafelSQL08_1() {
        return anrafelSQL08_1;
    }

    public static void setAnrafelSQL08_1(AnrafelSQL07 anrafelSQL08_1) {
        JDBCController.anrafelSQL08_1 = anrafelSQL08_1;
    }

    public static AnrafelSQL07 getAnrafelSQL08_2() {
        return anrafelSQL08_2;
    }

    public static void setAnrafelSQL08_2(AnrafelSQL07 anrafelSQL08_2) {
        JDBCController.anrafelSQL08_2 = anrafelSQL08_2;
    }

    public static AnrafelSQL07 getAnrafelSQL08_3() {
        return anrafelSQL08_3;
    }

    public static void setAnrafelSQL08_3(AnrafelSQL07 anrafelSQL08_3) {
        JDBCController.anrafelSQL08_3 = anrafelSQL08_3;
    }

    public static AnrafelSQL07 getAnrafelSQL08_4() {
        return anrafelSQL08_4;
    }

    public static void setAnrafelSQL08_4(AnrafelSQL07 anrafelSQL08_4) {
        JDBCController.anrafelSQL08_4 = anrafelSQL08_4;
    }

    public static AnrafelSQL07 getAnrafelSQL09() {
        return anrafelSQL09;
    }

    public static void setAnrafelSQL09(AnrafelSQL07 anrafelSQL09) {
        JDBCController.anrafelSQL09 = anrafelSQL09;
    }

    public static AnrafelSQL07 getAnrafelSQL09_1() {
        return anrafelSQL09_1;
    }

    public static void setAnrafelSQL09_1(AnrafelSQL07 anrafelSQL09_1) {
        JDBCController.anrafelSQL09_1 = anrafelSQL09_1;
    }

    public static AnrafelSQL07 getAnrafelSQL09_2() {
        return anrafelSQL09_2;
    }

    public static void setAnrafelSQL09_2(AnrafelSQL07 anrafelSQL09_2) {
        JDBCController.anrafelSQL09_2 = anrafelSQL09_2;
    }

    public static AnrafelSQL07 getAnrafelSQL09_3() {
        return anrafelSQL09_3;
    }

    public static void setAnrafelSQL09_3(AnrafelSQL07 anrafelSQL09_3) {
        JDBCController.anrafelSQL09_3 = anrafelSQL09_3;
    }

    public static AnrafelSQL07 getAnrafelSQL09_4() {
        return anrafelSQL09_4;
    }

    public static void setAnrafelSQL09_4(AnrafelSQL07 anrafelSQL09_4) {
        JDBCController.anrafelSQL09_4 = anrafelSQL09_4;
    }

    public static ArrayList<AnrafelSQL08> getListAnrafelSQL08() {
        return listAnrafelSQL08;
    }

    public static void setListAnrafelSQL08(
            ArrayList<AnrafelSQL08> listAnrafelSQL08) {
        JDBCController.listAnrafelSQL08 = listAnrafelSQL08;
    }

    public static ArrayList<AnrafelSQL08_1> getListAnrafelSQL08_1() {
        return listAnrafelSQL08_1;
    }

    public static void setListAnrafelSQL08_1(
            ArrayList<AnrafelSQL08_1> listAnrafelSQL08_1) {
        JDBCController.listAnrafelSQL08_1 = listAnrafelSQL08_1;
    }

    public static ArrayList<AnrafelSQL08_2> getListAnrafelSQL08_2() {
        return listAnrafelSQL08_2;
    }

    public static void setListAnrafelSQL08_2(
            ArrayList<AnrafelSQL08_2> listAnrafelSQL08_2) {
        JDBCController.listAnrafelSQL08_2 = listAnrafelSQL08_2;
    }

    public static ArrayList<AnrafelSQL08_3> getListAnrafelSQL08_3() {
        return listAnrafelSQL08_3;
    }

    public static void setListAnrafelSQL08_3(
            ArrayList<AnrafelSQL08_3> listAnrafelSQL08_3) {
        JDBCController.listAnrafelSQL08_3 = listAnrafelSQL08_3;
    }

    public static ArrayList<AnrafelSQL08_4> getListAnrafelSQL08_4() {
        return listAnrafelSQL08_4;
    }

    public static void setListAnrafelSQL08_4(
            ArrayList<AnrafelSQL08_4> listAnrafelSQL08_4) {
        JDBCController.listAnrafelSQL08_4 = listAnrafelSQL08_4;
    }

    public static ArrayList<AnrafelSQL09> getListAnrafelSQL09() {
        return listAnrafelSQL09;
    }

    public static void setListAnrafelSQL09(
            ArrayList<AnrafelSQL09> listAnrafelSQL09) {
        JDBCController.listAnrafelSQL09 = listAnrafelSQL09;
    }

    public static ArrayList<AnrafelSQL09_1> getListAnrafelSQL09_1() {
        return listAnrafelSQL09_1;
    }

    public static void setListAnrafelSQL09_1(
            ArrayList<AnrafelSQL09_1> listAnrafelSQL09_1) {
        JDBCController.listAnrafelSQL09_1 = listAnrafelSQL09_1;
    }

    public static ArrayList<AnrafelSQL09_2> getListAnrafelSQL09_2() {
        return listAnrafelSQL09_2;
    }

    public static void setListAnrafelSQL09_2(
            ArrayList<AnrafelSQL09_2> listAnrafelSQL09_2) {
        JDBCController.listAnrafelSQL09_2 = listAnrafelSQL09_2;
    }

    public static ArrayList<AnrafelSQL09_3> getListAnrafelSQL09_3() {
        return listAnrafelSQL09_3;
    }

    public static void setListAnrafelSQL09_3(
            ArrayList<AnrafelSQL09_3> listAnrafelSQL09_3) {
        JDBCController.listAnrafelSQL09_3 = listAnrafelSQL09_3;
    }

    public static ArrayList<AnrafelSQL09_4> getListAnrafelSQL09_4() {
        return listAnrafelSQL09_4;
    }

    public static void setListAnrafelSQL09_4(
            ArrayList<AnrafelSQL09_4> listAnrafelSQL09_4) {
        JDBCController.listAnrafelSQL09_4 = listAnrafelSQL09_4;
    }

    public static ArrayList<AnrafelSQL10> getListAnrafelSQL10() {
        return listAnrafelSQL10;
    }

    public static void setListAnrafelSQL10(ArrayList<AnrafelSQL10> listAnrafelSQL10) {
        JDBCController.listAnrafelSQL10 = listAnrafelSQL10;
    }

    public static ArrayList<AnrafelSQL11> getListAnrafelSQL11() {
        return listAnrafelSQL11;
    }

    public static void setListAnrafelSQL11(ArrayList<AnrafelSQL11> listAnrafelSQL11) {
        JDBCController.listAnrafelSQL11 = listAnrafelSQL11;
    }

    /**
     * ********************************************************************************
     */
    /**
     * *************** Produtos construídos a partir deste artefato
     * *********************
     */
    /**
     * ********************************************************************************
     * @return
     */
    // Produtos construídos a partir deste artefato (Nome Produto /
    // Cientista)
    public static ArrayList<ProductDevArtifact> productConstructArtifact() {

        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect
                    .prepareStatement("SELECT A.`idRationale`, C.`idScientist`, D.`productName`, C.`NameScientist` FROM `Rationale` A LEFT OUTER JOIN `WhoTable` B on (A.`idWho` = B.`idWho`) LEFT OUTER JOIN `User` C on (B.`idScientist` = C.`idScientist`) LEFT OUTER JOIN `Whattable` D on (A.`idWhat` = D.`idWhat`) LEFT OUTER JOIN `WhereTable` E on (A.`idWhere` = E.`idWhere`) LEFT OUTER JOIN `ArtifactsUsed` F on (E.`idWhere` = F.`idWhere`) WHERE (D.`description` LIKE '%Develop a Product%') AND (F.`idArtifact` = 3)");
            rs = ps.executeQuery();

            if (!listProductDevArtifact.isEmpty()) {
                listProductDevArtifact.clear();
            }

            ProductDevArtifact u = null;
            while (rs.next()) {
                u = new ProductDevArtifact();
                u.setIdRationale(rs.getInt("idRationale"));
                u.setIdScientist(rs.getInt("IdScientist"));
                u.setNameScientist(rs.getString("nameScientist"));
                u.setProductName(rs.getString("productName"));
                listProductDevArtifact.add(u);

                // so para imprimir
				/*
                 * Iterator<ProductDevArtifact> it3 = listProductDevArtifact
                 * .iterator(); while (it3.hasNext()) {
                 * 
                 * ProductDevArtifact id3 = it3.next();
                 * System.out.println("ID-RATIONALE: " + id3.getIdRationale());
                 * System.out.println("ID-SCIENTIST: " + id3.getIdScientist());
                 * System.out.println("NAME-SCIENTIST: " +
                 * id3.getNameScientist()); System.out.println("PRODUCT-NAME: "
                 * + id3.getProductName()); System.out.println(
                 * "-X-X-X-X-X-X-X-X-X-XMETODO-productConstructArtifactX-X-X-X-X-X-X-X-X-X-X"
                 * ); }
                 */
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listProductDevArtifact;
    }

    /**
     * ********************************************************************************
     */
    /**
     * ******* (1) SQL para verificar se existem novas mensagens para o
     * cientista. ******
     */
    /**
     * *********** Esta SQL só verifica se existem novas mensagens (Não lidas)
     * **********
     */
    /**
     * ********************************************************************************
     * @param idCientista
     * @return
     */
    public static ArrayList<AnrafelSQL01> anrafelSQL01(String idCientista) {
        String url = "SELECT A.* FROM `Communication` A WHERE (A.`idScientist_Receptor` = 1) AND (A.`lidaSN` = 0)";

        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL01.isEmpty()) {
                listAnrafelSQL01.clear();
            }

            AnrafelSQL01 u = null;
            while (rs.next()) {
                u = new AnrafelSQL01();
                u.setIdComunication(rs.getInt("idComunication"));
                u.setIdRationale(rs.getInt("idRationale"));
                u.setIdScientist_Emissor(rs.getInt("idScientist_Emissor"));
                u.setIdScientist_Receptor(rs.getInt("idScientist_Emissor"));
                u.setMessage(rs.getString("message"));
                u.setSubfeature(rs.getString("subfeature"));
                u.setData(rs.getString("data"));
                u.setHora(rs.getString("hora"));
                if (rs.getInt("lidaSN") == 0) {
                    u.setLidaSN(false);
                } else {
                    u.setLidaSN(true);
                }

                listAnrafelSQL01.add(u);

                /*
                 * so para imprimir Iterator<AnrafelSQL01> it3 =
                 * listAnrafelSQL01.iterator(); while (it3.hasNext()) {
                 * 
                 * AnrafelSQL01 id3 = it3.next();
                 * System.out.println("getIdComunication: " +
                 * id3.getIdComunication());
                 * System.out.println("getIdRationale: " +
                 * id3.getIdRationale());
                 * System.out.println("getIdScientist_Emissor: " +
                 * id3.getIdScientist_Emissor());
                 * System.out.println("getIdScientist_Receptor: " +
                 * id3.getIdScientist_Receptor());
                 * System.out.println("getIdComunication: " +
                 * id3.getIdComunication());
                 * System.out.println("getSubfeature: " + id3.getSubfeature());
                 * System.out.println("getMessage: " + id3.getMessage());
                 * System.out.println("getData: " + id3.getData());
                 * System.out.println("getHora: " + id3.getHora());
                 * System.out.println("getLidaSN: " + id3.getLidaSN());
                 * System.out.println(
                 * "-X-X-X-X-X-X-X-X-X-XMETODO-anrafelSQL01()-X-X-X-X-X-X-X-X-X-X"
                 * ); }
                 */
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL01;
    }

    /**
     * ********************************************************************************
     */
    /**
     * ******* (2) SQL para quando o Cientista clicar na mensagem para fazer a
     * **********
     */
    /**
     * ************** leitura (Passar o idRationale como Parâmetro)
     * *********************
     */
    /**
     * ********************************************************************************
     */
    public static ArrayList<AnrafelSQL02> anrafelSQL02(String idRational) {
        String url = "SELECT  A.`idRationale`,C.`nameScientist` , C.`institutionScientist` , G.`day` , G.`month`, G.`year` , G.`time` , G.`minute` ,  D.`description` ,D.`productName` , H.`description` FROM `Rationale` A LEFT OUTER JOIN `WhoTable` B ON ( A.`idWho` = B.`idWho` ) LEFT OUTER JOIN `User` C ON ( B.`idScientist` = C.`idScientist` ) LEFT OUTER JOIN `WhatTable` D ON ( A.`idWhat` = D.`idWhat` ) LEFT OUTER JOIN `WhereTable` E ON ( A.`idWhere` = E.`idWhere` ) LEFT OUTER JOIN `ArtifactsUsed` F ON ( E.`idWhere` = F.`idWhere` ) LEFT OUTER JOIN `WhenTable` G ON ( A.idWhen = G.idWhen ) LEFT OUTER JOIN `HowTable` H ON ( A.idHow = H.idHow ) WHERE (A.`idRationale` = "
                + idRational + ") LIMIT 1";

        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL02.isEmpty()) {
                listAnrafelSQL02.clear();
            }

            AnrafelSQL02 u = null;
            while (rs.next()) {
                u = new AnrafelSQL02();
                u.setIdRationale(rs.getInt("idRationale"));
                u.setNameScientist(rs.getString("nameScientist"));
                u.setProductName(rs.getString("productName"));
                u.setDescription(rs.getString("description"));
                u.setInstitutionScientist(rs.getString("institutionScientist"));
                String d = rs.getString("day");
                String n = rs.getString("month");
                String y = rs.getString("year");
                String data = d + "/" + n + "/" + y;
                u.setDate(data);
                String h = rs.getString("time");
                String m = rs.getString("minute");
                String time = h + ":" + m;
                u.setTime(time);

                // System.out.println("datadatadatadatadatadatadatadatadatadatadata: "+data);
                // System.out.println("timetimetimetimetimetimetimetimetimetimetime: "+time);
                listAnrafelSQL02.add(u);

                /*
                 * so para imprimir Iterator<AnrafelSQL02> it3 =
                 * listAnrafelSQL02.iterator(); while (it3.hasNext()) {
                 * 
                 * AnrafelSQL02 id3 = it3.next();
                 * System.out.println("getNameScientist: " +
                 * id3.getNameScientist());
                 * System.out.println("getProductName: " +
                 * id3.getProductName());
                 * System.out.println("getInstitutionScientist: " +
                 * id3.getInstitutionScientist());
                 * System.out.println("getDescription: " +
                 * id3.getDescription()); System.out.println("getDay: " +
                 * id3.getDate()); System.out.println("getTime: " +
                 * id3.getTime()); System.out.println(
                 * "-X-X-X-X-X-X-X-X-X-X-METODO-anrafelSQL02()-X-X-X-X-X-X-X-X-X-X"
                 * ); }
                 */
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL02;
    }

    /**
     * ********************************************************************************
     */
    /**
     * ******* (3) SQL para trazer os artefatos que foram utilizados
     * ********************
     */
    /**
     * ******************** na ATIVIDADE que está selecionado pelo cientista
     * ************
     */
    /**
     * ********************************************************************************
     * @param idRational
     * @return
     */
    public static ArrayList<AnrafelSQL03> anrafelSQL03(String idRational) {
        String url = "SELECT A.`idRationale`, D.`name` , D.`type` FROM `Rationale` A LEFT OUTER JOIN `WhereTable` B ON ( A.`idWhere` = B.`idWhere` ) LEFT OUTER JOIN `ArtifactsUsed` C ON ( B.`idWhere` = C.`idWhere` ) LEFT OUTER JOIN `Artifact` D ON ( C.`idArtifact` = D.`idArtifact` ) WHERE (A.`idRationale` ="
                + idRational + ") LIMIT 0 , 30";

        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL03.isEmpty()) {
                listAnrafelSQL03.clear();
            }

            AnrafelSQL03 u = null;
            while (rs.next()) {
                u = new AnrafelSQL03();
                u.setIdRationale(rs.getInt("idRationale"));
                u.setName(rs.getString("name"));
                u.setType(rs.getString("type"));

                listAnrafelSQL03.add(u);

                /*
                 * so para imprimir Iterator<AnrafelSQL03> it3 =
                 * listAnrafelSQL03.iterator(); while (it3.hasNext()) {
                 * 
                 * AnrafelSQL03 id3 = it3.next();
                 * System.out.println("getIdRationale: " +
                 * id3.getIdRationale()); System.out.println("getName: " +
                 * id3.getName()); System.out.println("getType: " +
                 * id3.getType()); System.out.println(
                 * "-X-X-X-X-X-X-X-X-X-XMETODO-anrafelSQL03()-X-X-X-X-X-X-X-X-X-X"
                 * ); }
                 */
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL03;
    }

    /**
     * ********************************************************************************
     */
    /**
     * ************ ( 4 ) SQL para Trazer as notas feitas sobre este produto
     * ************
     */
    /**
     * ********************************************************************************
     * @param idRational
     * @return
     */
    public static ArrayList<AnrafelSQL04> anrafelSQL04(String idRational) {
        String url = "SELECT A.`idRationale`, A.`description` FROM `Notes` A WHERE A.`idRationale` = "
                + idRational;

        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL04.isEmpty()) {
                listAnrafelSQL04.clear();
            }

            AnrafelSQL04 u = null;
            while (rs.next()) {
                u = new AnrafelSQL04();
                u.setIdRationale(rs.getInt("idRationale"));
                u.setDescription(rs.getString("description"));
                listAnrafelSQL04.add(u);

                /*
                 * so para imprimir Iterator<AnrafelSQL04> it3 =
                 * listAnrafelSQL04.iterator(); while (it3.hasNext()) {
                 * 
                 * AnrafelSQL04 id3 = it3.next();
                 * System.out.println("getIdRationale: "+ id3.getIdRationale());
                 * System.out.println("getDescription: " +
                 * id3.getDescription()); System.out.println(
                 * "-X-X-X-X-X-X-X-X-X-XMETODO-anrafelSQL04()-X-X-X-X-X-X-X-X-X-X"
                 * ); }
                 */
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL04;
    }

    /**
     * ********************************************************************************
     */
    /**
     * *************** ( 5 ) SQL para trazer as mensagens anteriores
     * ********************
     */
    /**
     * ********************************************************************************
     * @param idRationa
     * @return
     */
    public static ArrayList<AnrafelSQL05> anrafelSQL05(String idRationa) {
        String url = "SELECT F.`NameScientist` , F.`institutionScientist` , A.`data` , A.`hora` , A.`message` FROM `Communication` A LEFT OUTER JOIN `Rationale` C ON ( A.`idRationale` = C.`idRationale` ) LEFT OUTER JOIN `WhatTable` D ON ( C.`idWhat` = D.`idWhat` ) LEFT OUTER JOIN `User` F ON ( A.`idScientist_Emissor` = F.`idScientist` ) WHERE (A.`idRationale` = "
                + idRationa + ")";

        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL05.isEmpty()) {
                listAnrafelSQL05.clear();
            }

            AnrafelSQL05 u = null;
            while (rs.next()) {
                u = new AnrafelSQL05();
                u.setNameScientist(rs.getString("nameScientist"));
                u.setInstitutionScientist(rs.getString("institutionScientist"));
                u.setMessage(rs.getString("message"));
                u.setData(rs.getString("data"));
                u.setHora(rs.getString("hora"));
                listAnrafelSQL05.add(u);

                /*
                 * so para imprimir Iterator<AnrafelSQL05> it3 =
                 * listAnrafelSQL05.iterator(); while (it3.hasNext()) {
                 * 
                 * AnrafelSQL05 id3 = it3.next();
                 * System.out.println("getNameScientist: "+
                 * id3.getNameScientist());
                 * System.out.println("getInstitutionScientist: " +
                 * id3.getInstitutionScientist());
                 * System.out.println("getMessage: "+ id3.getMessage());
                 * System.out.println("getData: " + id3.getData());
                 * System.out.println("getHora: " + id3.getHora());
                 * System.out.println
                 * ("-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X");
                 * System.out.println
                 * ("-X-X-X-X-X-X-X-X-X-X-METODO-anrafelSQL05()-X-X-X-X-X-X-X-X-X-X"
                 * ); }
                 */
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL05;
    }

    /**
     * ********************************************************************************
     */
    /**
     * *************** (6) SQL para exibir todas as mensagens do usuário
     * ********************
     */
    /**
     * ********************************************************************************
     * @param idScientistLogado
     * @return
     */
    public static ArrayList<AnrafelSQL06> anrafelSQL06(String idScientistLogado) {
        // String trans = String.valueOf(idScientistLogado);

        String url = "SELECT A.`idRationale` , F.`NameScientist` , D.`description` , A.`lidaSN` FROM `Communication` A LEFT OUTER JOIN `Rationale` C ON ( A.`idRationale` = C.`idRationale` ) LEFT OUTER JOIN `WhatTable` D ON ( C.`idWhat` = D.`idWhat` ) LEFT OUTER JOIN `WhoTable` E ON ( C.`idWho` = E.`idWho` ) LEFT OUTER JOIN `User` F ON ( E.`idScientist` = F.`idScientist` ) WHERE ( A.`idScientist_Receptor` =" + idScientistLogado + ") GROUP BY A.`idRationale` ORDER BY A.`lidaSN` ";

        //String url = "SELECT A.`idRationale`, F.`NameScientist` , F.`institutionScientist` , D.`description` , D.`productName`, A.`data`, A.`hora`, A.`lidaSN` FROM `Communication` A LEFT OUTER JOIN `Rationale` C ON ( A.`idRationale` = C.`idRationale` ) LEFT OUTER JOIN `WhatTable` D ON ( C.`idWhat` = D.`idWhat` ) LEFT OUTER JOIN `User` F ON (A.`idScientist_Emissor` = F.`idScientist`) WHERE (A.`idScientist_Receptor` ="
        //	+ idScientistLogado + ")";
        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL06.isEmpty()) {
                listAnrafelSQL06.clear();
            }

            AnrafelSQL06 u = null;
            while (rs.next()) {
                u = new AnrafelSQL06();
                u.setIdRationale(rs.getInt("idRationale"));
                u.setNameScientist(rs.getString("nameScientist"));
                //u.setProductName(rs.getString("productName"));
                //u.setInstitutionScientist(rs.getString("institutionScientist"));
                //u.setData(rs.getString("data"));
                //u.setHora(rs.getString("hora"));
                if (rs.getInt("lidaSN") == 0) {
                    u.setLidaSN(false);
                } else {
                    u.setLidaSN(true);
                }

                u.setDescription(rs.getString("description"));

                listAnrafelSQL06.add(u);

                /*
                 * so para imprimir Iterator<AnrafelSQL06> it3 =
                 * listAnrafelSQL06.iterator(); while (it3.hasNext()) {
                 * 
                 * AnrafelSQL06 id3 = it3.next();
                 * System.out.println("getNameScientist: "+
                 * id3.getNameScientist());
                 * System.out.println("getProductName: " +
                 * id3.getProductName());
                 * System.out.println("getInstitutionScientist: "+
                 * id3.getInstitutionScientist());
                 * System.out.println("getData: " + id3.getData());
                 * System.out.println("getHora: " + id3.getHora());
                 * System.out.println("getLidaSN: " + id3.getLidaSN());
                 * System.out.println(
                 * "-X-X-X-X-X-X-X-X-X-X-METODO-anrafelSQL06()-X-X-X-X-X-X-X-X-X-X"
                 * ); }
                 */
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL06;
    }

    /**
     * ********************************************************************************
     */
    /**
     * *************** (7) SQL para exibir todas as mensagens do usuário
     * ********************
     */
    /**
     * ********************************************************************************
     * @param idArtifact
     * @return
     */
    public static ArrayList<AnrafelSQL07> anrafelSQL07(String idArtifact) {
        // String trans = String.valueOf(idScientistLogado);
        // "SELECT A.`idRationale` , C.`nameScientist` , C.`institutionScientist` , D.`description` , G.`day` , G.`month` , G.`year` , G.`time` , G.`minute` FROM `Rationale` A LEFT OUTER JOIN `Who` B ON ( A.`idWho` = B.`idWho` ) LEFT OUTER JOIN `User` C ON ( B.`idScientist` = C.`idScientist` ) LEFT OUTER JOIN `What` D ON ( A.`idWhat` = D.`idWhat` ) LEFT OUTER JOIN `Where` E ON ( A.`idWhere` = E.`idWhere` ) LEFT OUTER JOIN `ArtifactsUsed` F ON ( E.`idWhere` = F.`idWhere` ) LEFT OUTER JOIN `When` G ON ( A.idWhen = G.idWhen ) ORDER BY A.`idRationale` DESC LIMIT 5";

        String url = "SELECT A.`idRationale`, C.`NameScientist`, C.`institutionScientist` FROM `Rationale` A LEFT OUTER JOIN `WhoTable` B on (A.`idWho` = B.`idWho`)LEFT OUTER JOIN `User` C on (B.`idScientist` = C.`idScientist`) LEFT OUTER JOIN `WhatTable` D on (A.`idWhat` = D.`idWhat`) LEFT OUTER JOIN `WhereTable` E on (A.`idWhere` = E.`idWhere`) LEFT OUTER JOIN `ArtifactsUsed` F on (E.`idWhere` = F.`idWhere`) WHERE (D.`description` LIKE '%Edit Artifact%') AND (F.`idArtifact` ="
                + idArtifact + ")";

        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL07.isEmpty()) {
                listAnrafelSQL07.clear();
            }

            AnrafelSQL07 u = null;
            while (rs.next()) {
                u = new AnrafelSQL07();
                u.setIdRationale(rs.getInt("idRationale"));
                u.setNameScientist(rs.getString("nameScientist"));
                u.setInstitutionScientist(rs.getString("institutionScientist"));
                listAnrafelSQL07.add(u);

                /*
                 * so para imprimir Iterator<AnrafelSQL07> it3 =
                 * listAnrafelSQL07.iterator(); while (it3.hasNext()) {
                 * 
                 * AnrafelSQL07 id3 = it3.next();
                 * System.out.println("getNameScientist: "+
                 * id3.getNameScientist());
                 * System.out.println("getIdRationale: " +
                 * id3.getIdRationale());
                 * System.out.println("getInstitutionScientist: "+
                 * id3.getInstitutionScientist());
                 * 
                 * System.out.println(
                 * "-X-X-X-X-X-X-X-X-X-X-METODO-anrafelSQL06()-X-X-X-X-X-X-X-X-X-X"
                 * ); }
                 */
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL07;
    }

    /**
     * ********************************************************************************
     */
    /**
     * *************** (7_1) SQL para exibir todas as mensagens do usuário
     * ********************
     */
    /**
     * ********************************************************************************
     * @param idRationale
     * @return
     */
    @SuppressWarnings("unused")
    public static ArrayList<AnrafelSQL07_1> anrafelSQL07_1(String idRationale) {

        String url = "SELECT A.`idRationale`, C.`nameScientist`, C.`institutionScientist`, G.`day`, G.`month`, G.`year`, G.`time`, G.`minute`, H.`description` FROM `Rationale` A LEFT OUTER JOIN `WhoTable` B on (A.`idWho` = B.`idWho`) LEFT OUTER JOIN `User` C on (B.`idScientist` = C.`idScientist`) LEFT OUTER JOIN `WhatTable` D on (A.`idWhat` = D.`idWhat`) LEFT OUTER JOIN `WhereTable` E on (A.`idWhere` = E.`idWhere`) LEFT OUTER JOIN `ArtifactsUsed` F on (E.`idWhere` = F.`idWhere`) LEFT OUTER JOIN `WhenTable` G on (A.idWhen = G.idWhen) LEFT OUTER JOIN `HowTable` H on (A.idHow = H.idHow) WHERE (F.`idArtifact` = 3) AND (A.`idRationale` = "
                + idRationale + ")";
        // idRationale nameScientist institutionScientist day month year time
        // minute description
        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL07_1.isEmpty()) {
                listAnrafelSQL07_1.clear();
            }

            AnrafelSQL07_1 u = null;
            while (rs.next()) {
                u = new AnrafelSQL07_1();// idRationale
                u.setIdRationale(rs.getInt("idRationale"));
                u.setNameScientist(rs.getString("nameScientist"));
                u.setInstitutionScientist(rs.getString("institutionScientist"));
                String d = rs.getString("day");
                String n = rs.getString("month");
                String y = rs.getString("year");
                String data = d + "/" + n + "/" + y;
                u.setData(data);
                String h = rs.getString("time");
                String m = rs.getString("minute");
                String time = h + ":" + m;
                u.setHora(time);
                u.setDescription(rs.getString("description"));
                listAnrafelSQL07_1.add(u);

                // so para imprimir
                Iterator<AnrafelSQL07_1> it3 = listAnrafelSQL07_1.iterator();
                while (it3.hasNext()) {

                    AnrafelSQL07_1 id3 = it3.next();
                    // System.out.println("getNameScientist: "+
                    // id3.getNameScientist());
                    // System.out.println("getIdRationale: " +
                    // id3.getIdRationale());
                    // System.out.println("getInstitutionScientist: "+
                    // id3.getInstitutionScientist());
                    // System.out.println("getDescription: "+
                    // id3.getDescription());
                    // System.out.println("getData: "+ id3.getData());
                    // System.out.println("getHora: "+ id3.getHora());
                    // System.out.println("-X-X-X-X-X-X-X-X-X-X-METODO-anrafelSQL07_1()-X-X-X-X-X-X-X-X-X-X");
                }
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL07_1;
    }

    /**
     * ********************************************************************************
     */
    /**
     * *************** (7_2) SQL para exibir todas as mensagens do usuário
     * ********************
     */
    /**
     * ********************************************************************************
     * @param idRationale
     * @return
     */
    public static ArrayList<AnrafelSQL07_2> anrafelSQL07_2(String idRationale) {

        // String url =
        // "SELECT C.`nameScientist`, C.`institutionScientist`, G.`day`, G.`month`, G.`year`, G.`time`, G.`minute`, H.`description` FROM `Rationale` A LEFT OUTER JOIN `Who` B on (A.`idWho` = B.`idWho`) LEFT OUTER JOIN `User` C on (B.`idScientist` = C.`idScientist`) LEFT OUTER JOIN `What` D on (A.`idWhat` = D.`idWhat`) LEFT OUTER JOIN `Where` E on (A.`idWhere` = E.`idWhere`) LEFT OUTER JOIN `ArtifactsUsed` F on (E.`idWhere` = F.`idWhere`) LEFT OUTER JOIN `When` G on (A.idWhen = G.idWhen) LEFT OUTER JOIN `How` H on (A.idHow = H.idHow) WHERE (F.`idArtifact` = 3) AND (A.`idRationale` = 1)";
        String url = "SELECT A.`idRationale`, A.`description` FROM `Notes` A WHERE A.`idRationale` ="
                + idRationale;

        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL07_2.isEmpty()) {
                listAnrafelSQL07_2.clear();
            }

            AnrafelSQL07_2 u = null;
            while (rs.next()) {
                u = new AnrafelSQL07_2();
                u.setIdRationale(rs.getInt("idRationale"));
                u.setDescription(rs.getString("description"));
                listAnrafelSQL07_2.add(u);

                /*
                 * so para imprimir Iterator<AnrafelSQL07_2> it3 =
                 * listAnrafelSQL07_2.iterator(); while (it3.hasNext()) {
                 * 
                 * AnrafelSQL07_2 id3 = it3.next();
                 * System.out.println("getIdRationale: "+ id3.getIdRationale());
                 * System.out.println("getDescription: " +
                 * id3.getDescription());
                 * 
                 * System.out.println(
                 * "-X-X-X-X-X-X-X-X-X-X-METODO-anrafelSQL07_2()-X-X-X-X-X-X-X-X-X-X"
                 * ); }
                 */
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL07_2;
    }

    /**
     * ********************************************************************************
     */
    /**
     * *************** (7_3) SQL para exibir todas as mensagens do usuário
     * ********************
     */
    /**
     * ********************************************************************************
     * @param idRationale
     * @return
     */
    public static ArrayList<AnrafelSQL07_3> anrafelSQL07_3(String idRationale) {

        String url = "SELECT A.`idRationale`, F.`NameScientist` , F.`institutionScientist` , A.`data` , A.`hora` , A.`message` FROM `Communication` A LEFT OUTER JOIN `Rationale` C ON ( A.`idRationale` = C.`idRationale` ) LEFT OUTER JOIN `WhatTable` D ON ( C.`idWhat` = D.`idWhat` ) LEFT OUTER JOIN `User` F ON ( A.`idScientist_Emissor` = F.`idScientist` ) WHERE (A.`idRationale` ="
                + idRationale + ")";

        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL07_3.isEmpty()) {
                listAnrafelSQL07_3.clear();
            }

            AnrafelSQL07_3 u = null;
            while (rs.next()) {
                u = new AnrafelSQL07_3();
                u.setIdRationale(rs.getInt("idRationale"));
                u.setNameScientist(rs.getString("nameScientist"));
                u.setInstitutionScientist(rs.getString("institutionScientist"));
                u.setData(rs.getString("data"));
                u.setHora(rs.getString("hora"));
                u.setMessage(rs.getString("message"));
                listAnrafelSQL07_3.add(u);

                /*
                 * so para imprimir Iterator<AnrafelSQL07_3> it3 =
                 * listAnrafelSQL07_3.iterator(); while (it3.hasNext()) {
                 * 
                 * AnrafelSQL07_3 id3 = it3.next();
                 * System.out.println("getIdRationale: "+ id3.getIdRationale());
                 * System.out.println("getMessage: " + id3.getMessage());
                 * 
                 * System.out.println(
                 * "-X-X-X-X-X-X-X-X-X-X-METODO-anrafelSQL07_3()-X-X-X-X-X-X-X-X-X-X"
                 * ); }
                 */
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL07_3;
    }

    /**
     * ********************************************************************************
     */
    /**
     * *************** (8) SQL para exibir todas as mensagens do usuário
     * ********************
     */
    /**
     * ********************************************************************************
     * @param idArtifact
     * @return
     */
    public static ArrayList<AnrafelSQL08> anrafelSQL08(String idArtifact) {

        // String url =
        // "SELECT C.`nameScientist`, C.`institutionScientist`, G.`day`, G.`month`, G.`year`, G.`time`, G.`minute`, H.`description` FROM `Rationale` A LEFT OUTER JOIN `Who` B on (A.`idWho` = B.`idWho`) LEFT OUTER JOIN `User` C on (B.`idScientist` = C.`idScientist`) LEFT OUTER JOIN `What` D on (A.`idWhat` = D.`idWhat`) LEFT OUTER JOIN `Where` E on (A.`idWhere` = E.`idWhere`) LEFT OUTER JOIN `ArtifactsUsed` F on (E.`idWhere` = F.`idWhere`) LEFT OUTER JOIN `When` G on (A.idWhen = G.idWhen) LEFT OUTER JOIN `How` H on (A.idHow = H.idHow) WHERE (F.`idArtifact` = 3) AND (A.`idRationale` = 1)";
        // String url
        // ="SELECT A.`idRationale`, A.`description` FROM `Notes` A WHERE A.`idRationale` ="+
        // idRationale;
        // "SELECT A.`idRationale`, F.`NameScientist` , F.`institutionScientist` , A.`data` , A.`hora` , A.`message` FROM `Communication` A LEFT OUTER JOIN `Rationale` C ON ( A.`idRationale` = C.`idRationale` ) LEFT OUTER JOIN `What` D ON ( C.`idWhat` = D.`idWhat` ) LEFT OUTER JOIN `User` F ON ( A.`idScientist_Emissor` = F.`idScientist` ) WHERE (A.`idRationale` ="+idRationale+")";
        String url = "SELECT A.`idRationale`, D.`productName`, C.`NameScientist` FROM `Rationale` A LEFT OUTER JOIN `WhoTable` B on (A.`idWho` = B.`idWho`) LEFT OUTER JOIN `User` C on (B.`idScientist` = C.`idScientist`) LEFT OUTER JOIN `WhatTable` D on (A.`idWhat` = D.`idWhat`) LEFT OUTER JOIN `WhereTable` E on (A.`idWhere` = E.`idWhere`) LEFT OUTER JOIN `ArtifactsUsed` F on (E.`idWhere` = F.`idWhere`) WHERE (D.`description` LIKE '%Develop a Product%') AND (F.`idArtifact` = "
                + idArtifact + ")";

        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL08.isEmpty()) {
                listAnrafelSQL08.clear();
            }

            AnrafelSQL08 u = null;
            while (rs.next()) {
                u = new AnrafelSQL08();
                u.setIdRationale(rs.getInt("idRationale"));
                u.setNameScientist(rs.getString("nameScientist"));
                u.setProductName(rs.getString("productName"));

                listAnrafelSQL08.add(u);

                /*
                 * so para imprimir Iterator<AnrafelSQL08> it3 =
                 * listAnrafelSQL08.iterator(); while (it3.hasNext()) {
                 * 
                 * AnrafelSQL08 id3 = it3.next();
                 * System.out.println("getIdRationale: "+ id3.getIdRationale());
                 * System.out.println("getNameScientist: " +
                 * id3.getNameScientist());
                 * System.out.println("getProductName: " +
                 * id3.getProductName());
                 * 
                 * System.out.println(
                 * "-X-X-X-X-X-X-X-X-X-X-METODO-anrafelSQL07_3()-X-X-X-X-X-X-X-X-X-X"
                 * ); }
                 */
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL08;
    }

    /**
     * ********************************************************************************
     */
    /**
     * ***************confereMessage ********************
     */
    /**
     * ********************************************************************************
     * @param idScientist
     * @return
     */
    public static int confereMessage(int idScientist) {
        String query = "SELECT COUNT(`idComunication`) cont FROM `Communication` WHERE (`idScientist_Receptor` =" + idScientist + ") AND (`lidaSN` = 1)";
        int u = 0;
        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs.next()) {
                u = rs.getInt("cont");
            }

        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        // System.out.println("RETORNA-RETORNA-RETORNA-RETORNA: " + u);
        return u;
    }

    /**
     * ********************************************************************************
     */
    /**
     * *************** buscar Ultimo ********************
     */
    /**
     * ********************************************************************************
     * @param url
     * @param resp
     * @return
     */
    public static int buscaUltimoGravado(String url, String resp) {
        int u = 0;
        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (rs.next()) {
                u = rs.getInt(resp);
            }

        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }

        return u;
    }

    /**
     * ********************************************************************************
     */
    /**
     * *************** UPDATE ********************
     */
    /**
     * ********************************************************************************
     * @param idScientist
     */
    public static void updateMsgLida(int idScientist) {

        String url = "UPDATE `Communication` SET `lidaSN` = 0 WHERE `idScientist_Receptor` =" + idScientist;
        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            ps.executeUpdate();

        } catch (SQLException e) {
        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

    }

    /**
     * ********************************************************************************
     */
    /**
     * *************** (9) SQL para exibir todas as mensagens do usuário
     * ********************
     */
    /**
     * ********************************************************************************
     * @return
     */
    public static ArrayList<AnrafelSQL09> anrafelSQL09() {

        String url = "SELECT A.`idRationale` , C.`idScientist`  , C.`nameScientist` , C.`institutionScientist` ,D.`description` , G.`day` , G.`month` ,G.`year` , G.`time` , G.`minute` FROM `Rationale` A LEFT OUTER JOIN `WhoTable` B ON ( A.`idWho` = B.`idWho` ) LEFT OUTER JOIN `User` C ON ( B.`idScientist` = C.`idScientist` ) LEFT OUTER JOIN `WhatTable` D ON ( A.`idWhat` = D.`idWhat` ) LEFT OUTER JOIN `WhereTable` E ON ( A.`idWhere` = E.`idWhere` ) LEFT OUTER JOIN `ArtifactsUsed` F ON ( E.`idWhere` = F.`idWhere` ) LEFT OUTER JOIN `WhenTable` G ON ( A.idWhen = G.idWhen ) GROUP BY A.`idRationale` DESC LIMIT 5";

        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL09.isEmpty()) {
                listAnrafelSQL09.clear();
            }

            AnrafelSQL09 u;
            while (rs.next()) {
                u = new AnrafelSQL09();
                u.setIdRationale(rs.getInt("idRationale"));
                u.setNameScientist(rs.getString("nameScientist"));
                u.setInstitutionScientist(rs.getString("institutionScientist"));
                String d = rs.getString("day");
                String n = rs.getString("month");
                String y = rs.getString("year");
                String data = d + "/" + n + "/" + y;
                u.setData(data);
                String h = rs.getString("time");
                String m = rs.getString("minute");
                String time = h + ":" + m;
                u.setHora(time);
                u.setDescription(rs.getString("description"));
                u.setNomeFoto(rs.getInt("idScientist"));

                listAnrafelSQL09.add(u);

                //so para imprimir 
               /* Iterator<AnrafelSQL09> it3 = listAnrafelSQL09.iterator();
                 while (it3.hasNext()) {
                 AnrafelSQL09 id3 = it3.next();
                 System.out.println("getIdRationale: " + id3.getIdRationale());
                 System.out.println("getNameScientist: "+ id3.getNameScientist());
                 System.out.println("getHora: "+ id3.getData()+ id3.getHora());
                 System.out.println("getHora: "+ id3.getData()+ id3.getHora());
                 System.out.println("nomeFoto: "+ id3.getNomeFoto());

                 System.out.println(
                 "-X-X-X-X-X-X-X-X-X-X-METODO-anrafelSQL07_3()-X-X-X-X-X-X-X-X-X-X"
                 );
                 }*/
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL09;
    }

    /**
     * ********************************************************************************
     */
    /**
     * *************** (10) SQL para exibir todas as mensagens do usuário
     * ********************
     */
    /**
     * ********************************************************************************
     * @param produc_name
     * @return
     */
    public static ArrayList<AnrafelSQL10> anrafelSQL10(String produc_name) {

        //SELECT A.`idRationale` , C.`idScientist`  , C.`nameScientist` , C.`institutionScientist` ,D.`description` , G.`day` , G.`month` ,G.`year` , G.`time` , G.`minute` FROM `Rationale` A LEFT OUTER JOIN `WhoTable` B ON ( A.`idWho` = B.`idWho` ) LEFT OUTER JOIN `User` C ON ( B.`idScientist` = C.`idScientist` ) LEFT OUTER JOIN `WhatTable` D ON ( A.`idWhat` = D.`idWhat` ) LEFT OUTER JOIN `WhereTable` E ON ( A.`idWhere` = E.`idWhere` ) LEFT OUTER JOIN `ArtifactsUsed` F ON ( E.`idWhere` = F.`idWhere` ) LEFT OUTER JOIN `WhenTable` G ON ( A.idWhen = G.idWhen ) GROUP BY A.`idRationale` DESC LIMIT 5";
        String url = "SELECT A.`idRationale` , C.`NameScientist` , D.`ProductName` FROM `Rationale` A LEFT OUTER JOIN `WhoTable` B ON ( A.`idWho` = B.`idWho` ) LEFT OUTER JOIN `User` C ON ( B.`idScientist` = C.`idScientist` ) LEFT OUTER JOIN `WhatTable` D ON ( A.`idWhat` = D.`idWhat` ) WHERE (D.`ProductName` LIKE '%" + produc_name + "%') AND (A.`idRationale` <>1)";

        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL10.isEmpty()) {
                listAnrafelSQL10.clear();
            }

            AnrafelSQL10 u;
            while (rs.next()) {
                u = new AnrafelSQL10();
                u.setIdRationale(rs.getInt("idRationale"));
                u.setNameScientist(rs.getString("nameScientist"));
                u.setProductName(rs.getString("ProductName"));

                listAnrafelSQL10.add(u);

                //so para imprimir 
               /* Iterator<AnrafelSQL09> it3 = listAnrafelSQL09.iterator();
                 while (it3.hasNext()) {
                 AnrafelSQL09 id3 = it3.next();
                 System.out.println("getIdRationale: " + id3.getIdRationale());
                 System.out.println("getNameScientist: "+ id3.getNameScientist());
                 System.out.println("getHora: "+ id3.getData()+ id3.getHora());
                 System.out.println("getHora: "+ id3.getData()+ id3.getHora());
                 System.out.println("nomeFoto: "+ id3.getNomeFoto());

                 System.out.println(
                 "-X-X-X-X-X-X-X-X-X-X-METODO-anrafelSQL07_3()-X-X-X-X-X-X-X-X-X-X"
                 );
                 }*/
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL10;
    }

    /**
     * ********************************************************************************
     */
    /**
     * *************** (11) SQL para exibir todas as mensagens do usuário
     * ********************
     */
    /**
     * ********************************************************************************
     * @param artefatoUsadoART
     * @param artefatoUsadoMAP
     * @param artefatoUsadoONT
     * @return
     */
    public static ArrayList<AnrafelSQL11> anrafelSQL11(String artefatoUsadoART, String artefatoUsadoMAP, String artefatoUsadoONT) {

        String url = "SELECT A.`idRationale` , D.`productName` , C.`NameScientist` FROM `Rationale` A LEFT OUTER JOIN `WhoTable` B ON ( A.`idWho` = B.`idWho` ) LEFT OUTER JOIN `User` C ON ( B.`idScientist` = C.`idScientist` ) LEFT OUTER JOIN `WhatTable` D ON ( A.`idWhat` = D.`idWhat` ) LEFT OUTER JOIN `WhereTable` E ON ( A.`idWhere` = E.`idWhere` ) LEFT OUTER JOIN `ArtifactsUsed` F ON ( E.`idWhere` = F.`idWhere` ) WHERE (D.`description` LIKE '%PRODUCT DEVELOPMENT%') AND ((F.`idArtifact` = " + artefatoUsadoART + ") OR (F.`idArtifact` =  " + artefatoUsadoMAP + "  ) OR (F.`idArtifact` = " + artefatoUsadoONT + ")) GROUP BY A.`idRationale` ORDER BY A.`idRationale` DESC LIMIT 10";

        try {
            conect = ConnectionFactory.getConnectionMySql();
            ps = conect.prepareStatement(url);
            rs = ps.executeQuery();

            if (!listAnrafelSQL11.isEmpty()) {
                listAnrafelSQL11.clear();
            }

            AnrafelSQL11 u;
            while (rs.next()) {
                u = new AnrafelSQL11();
                u.setIdRationale(rs.getInt("idRationale"));
                u.setNameScientist(rs.getString("nameScientist"));
                u.setProductName(rs.getString("ProductName"));

                listAnrafelSQL11.add(u);

                //so para imprimir 
               /* Iterator<AnrafelSQL09> it3 = listAnrafelSQL09.iterator();
                 while (it3.hasNext()) {
                 AnrafelSQL09 id3 = it3.next();
                 System.out.println("getIdRationale: " + id3.getIdRationale());
                 System.out.println("getNameScientist: "+ id3.getNameScientist());
                 System.out.println("getHora: "+ id3.getData()+ id3.getHora());
                 System.out.println("getHora: "+ id3.getData()+ id3.getHora());
                 System.out.println("nomeFoto: "+ id3.getNomeFoto());

                 System.out.println(
                 "-X-X-X-X-X-X-X-X-X-X-METODO-anrafelSQL07_3()-X-X-X-X-X-X-X-X-X-X"
                 );
                 }*/
            }
        } catch (SQLException e) {

        } finally {
            try {/* FECHANDO A CONEXÃO */

                //conect.close();
                ps.close();
            } catch (SQLException e) {

            }
        }
        return listAnrafelSQL11;
    }

}// ultima
