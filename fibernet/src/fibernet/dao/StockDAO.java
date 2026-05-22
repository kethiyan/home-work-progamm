package fibernet.dao;

import fibernet.db.DBConnection;
import fibernet.model.StockModel;
import java.sql.*;
import java.util.*;


public class StockDAO {

    public Connection connect() throws ClassNotFoundException, SQLException {
        DBConnection db = new DBConnection();
        return db.connect();
    }

    
    public int addStock(StockModel sm)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO stock (item_name, category, quantity, unit, status) "
          + "VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, sm.getItemName());
        ps.setString(2, sm.getCategory());
        ps.setInt(3, sm.getQuantity());
        ps.setString(4, sm.getUnit());
        ps.setString(5, sm.getQuantity() > 10 ?
            "In Stock" : sm.getQuantity() > 0 ? "Low Stock" : "Out of Stock");
        int result = ps.executeUpdate();
        con.close();
        return result;
    }

   
    public int updateQuantity(int id, int quantity)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE stock SET quantity = quantity + ?, "
          + "status = CASE WHEN quantity + ? > 10 THEN 'In Stock' "
          + "WHEN quantity + ? > 0 THEN 'Low Stock' "
          + "ELSE 'Out of Stock' END "
          + "WHERE id = ?");
        ps.setInt(1, quantity);
        ps.setInt(2, quantity);
        ps.setInt(3, quantity);
        ps.setInt(4, id);
        int result = ps.executeUpdate();
        con.close();
        return result;
    }

    
    public List<StockModel> getAllStock()
            throws ClassNotFoundException, SQLException {
        List<StockModel> list = new ArrayList<>();
        Connection con = connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT * FROM stock ORDER BY item_name");
        while (rs.next()) {
            StockModel sm = new StockModel();
            sm.setId(rs.getInt("id"));
            sm.setItemId("STK-" + String.format("%03d", rs.getInt("id")));
            sm.setItemName(rs.getString("item_name"));
            sm.setCategory(rs.getString("category"));
            sm.setQuantity(rs.getInt("quantity"));
            sm.setUnit(rs.getString("unit"));
            sm.setStatus(rs.getString("status"));
            list.add(sm);
        }
        con.close();
        return list;
    }

    
    public int countByStatus(String status)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(
            "SELECT COUNT(*) FROM stock WHERE status = ?");
        ps.setString(1, status);
        ResultSet rs = ps.executeQuery();
        int count = rs.next() ? rs.getInt(1) : 0;
        con.close();
        return count;
    }
}
