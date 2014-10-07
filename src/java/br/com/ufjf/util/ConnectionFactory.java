package br.com.ufjf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class ConnectionFactory
 *
 * @author magnus, anrafel, jonathan
 *
 */
public class ConnectionFactory {

    /**
     * Method getConnectionMySql() connect BD MYSQL
     *
     * @return Connection
     * @throws java.sql.SQLException
     *
     */
    public static Connection getConnectionMySql() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/collaborate", "root", "");// localHost

        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }

    /**
     * Method closeConnection() desconnect BD MYSQL
     *
     *
     *
     * @param a
     * @param ps
     */
    public static void closeConnection(Connection a, PreparedStatement ps) {
        try {
            a.close();
            ps.close();
            System.out.println("conecxões fechadas");
        } catch (SQLException e) {
        }
    }

}
