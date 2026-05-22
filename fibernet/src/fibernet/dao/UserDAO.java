package fibernet.dao;

import fibernet.db.DBConnection;
import fibernet.model.UserModel;
import java.sql.*;


public class UserDAO {

    
    public Connection connect() throws ClassNotFoundException, SQLException {
        DBConnection db = new DBConnection();
        return db.connect();
    }

    
    public int register(UserModel um)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO users (full_name, email, mobile, password, role) "
          + "VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, um.getFullName());
        ps.setString(2, um.getEmail());
        ps.setString(3, um.getMobile());
        ps.setString(4, um.getPassword());
        ps.setString(5, "user");
        int result = ps.executeUpdate();
        con.close();
        return result;
    }

    
    public UserModel login(String email, String password)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM users WHERE email = ? AND password = ?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            UserModel um = new UserModel();
            um.setId(rs.getInt("id"));
            um.setFullName(rs.getString("full_name"));
            um.setEmail(rs.getString("email"));
            um.setMobile(rs.getString("mobile"));
            um.setRole(rs.getString("role"));
            con.close();
            return um;
        }
        con.close();
        return null;
    }

    public boolean emailExists(String email)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(
            "SELECT id FROM users WHERE email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        con.close();
        return exists;
    }
}
