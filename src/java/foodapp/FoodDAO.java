package foodapp;

import java.util.*;
import java.sql.*;
import java.util.logging.*;

/**
 * TestDAO manages a list of Test objects
 */
public class FoodDAO {

    private static final String TBLNAME = "food";

    private void handleSQLException(SQLException ex, String sql, String... parameters) {
        String msg = "Unable to access data; SQL=" + sql + "\n";
        for (String parameter : parameters) {
            msg += "," + parameter;
        }
        Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, msg, ex);
        throw new RuntimeException(msg, ex);
    }

    public void create(String name, int status, double price) {
        List<Food> all = retrieveAll();
        int id = 1;
        if (all != null) {
            id = all.get(all.size()-1).getFid() + 1;
        }
        Food f = new Food(id, name, status, price);
        create(f);

    }

    public void create(Food newFood) {
        String sql = "INSERT INTO " + TBLNAME
                    + " VALUES (?,?,?,?)";
        try ( Connection conn = ConnectionManager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, newFood.getFid());
            stmt.setString(2, newFood.getFname());
        stmt.setInt(3, newFood.getStatus());
            stmt.setDouble(4, newFood.getPrice());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            handleSQLException(ex, sql, "Food={" + newFood + "}");
        }
    }

    public void update(Food toBeUpdated) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = "";
        try {
            conn = ConnectionManager.getConnection();

            sql = "UPDATE " + TBLNAME
                    + " set fname=?, price=? "
                    + " where fid = ? ";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, toBeUpdated.getFname());
            stmt.setDouble(2, toBeUpdated.getPrice());
            stmt.setInt(3, toBeUpdated.getFid());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            handleSQLException(ex, sql, "Food={" + toBeUpdated + "}");
        } finally {
            ConnectionManager.close(conn, stmt);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM " + TBLNAME + " where fid = ? ";
        try ( Connection conn = ConnectionManager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            handleSQLException(ex, sql, "id=" + id);
        }
    }

    public List<Food> retrieveAll() {
        ResultSet rs = null;
        String sql = "SELECT * FROM " + TBLNAME;
        List<Food> results = new ArrayList<>();

         try ( Connection conn = ConnectionManager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){

            rs = stmt.executeQuery();

            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("fid");
                String fname = rs.getString("fname");
                int status = rs.getInt("fstatus");
                double price = rs.getDouble("price");

                Food obj = new Food(id, fname, status, price);
                results.add(obj);
            }

        } catch (SQLException ex) {
            handleSQLException(ex, sql);
        } finally{
            ConnectionManager.close(rs);
        }
        return results;
    }

    public Food retrieve(int id) {
        ResultSet rs = null;
        String sql = "SELECT * FROM "
                    + TBLNAME
                    + " WHERE fid = ?";
        Food result = null;

       try ( Connection conn = ConnectionManager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                //Retrieve by column name
                String fname = rs.getString("fname");
                int status = rs.getInt("fstatus");
                double price = rs.getDouble("price");
                result = new Food(id, fname, status, price);
            }

        } catch (SQLException ex) {
            handleSQLException(ex, sql, "fid=" + id);
        }finally{
            ConnectionManager.close(rs);
        }
        return result;
    }
}
