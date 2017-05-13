package foodapp;

import java.util.*;
import java.sql.*;
import java.util.logging.*;

/**
 * TestDAO manages a list of Test objects
 */
public class LoginDAO {

    private static final String TBLNAME = "admin_user";

    private static void handleSQLException(SQLException ex, String sql, String... parameters) {
        String msg = "Unable to access data; SQL=" + sql + "\n";
        for (String parameter : parameters) {
            msg += "," + parameter;
        }
        Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, msg, ex);
        throw new RuntimeException(msg, ex);
    }

    public static boolean authenticate(String user, String pass) {
        ResultSet rs = null;
        String sql = "Select * from " + TBLNAME
                    + " where username = ?";
        try ( Connection conn = ConnectionManager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, user);
            rs = stmt.executeQuery();
            String password = "";
            while (rs.next()) {
                //Retrieve by column name
                password = rs.getString("password");
                if(password.equals(pass)){
                    return true;
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex, sql, "User={" + user + "}");
        }
        return false;
    }
}
