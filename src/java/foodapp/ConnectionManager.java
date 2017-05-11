package foodapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TohZJ
 */
import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class ConnectionManager {

    private static final String PROPS_FILENAME = "/foodapp/connection.properties";
    private static String dbUser;
    private static String dbPassword;
    private static String dbURL;

    static {

                    dbURL = "jdbc:sqlserver://myfirstjsp.database.windows.net:1433;database=foodapp;user=tohzj@myfirstjsp;password=AdminAdmin!;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    }

    /**
     * Get a database connection object.
     *
     * @return Connection object to the database.
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("CONN:" + dbURL);
            conn = DriverManager.getConnection(dbURL);

        } catch (ClassNotFoundException ex) {
            String msg = "Unable to load MySQL JDBC Driver.";

            // Note that I'm using Logger as per default.
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, msg, ex);

            throw new RuntimeException(msg, ex);
        }
        return conn;
    }

    /**
     * close the given connection, statement and resultset
     *
     * @param conn the connection object to be closed
     * @param stmt the statement object to be closed
     * @param rs the resultset object to be closed
     */
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.WARNING,
                    "Unable to close ResultSet", ex);
        }

    }

    /**
     * close the given connection, statement
     *
     * @param conn the connection object to be closed
     * @param stmt the statement object to be closed
     */
    public static void close(Connection conn, Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.WARNING,
                    "Unable to close Statement", ex);
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.WARNING,
                    "Unable to close Connection", ex);
        }
    }
}
