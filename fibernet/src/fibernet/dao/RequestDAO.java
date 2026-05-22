package fibernet.dao;

import fibernet.db.DBConnection;
import fibernet.model.RequestModel;
import java.sql.*;
import java.util.*;


public class RequestDAO {

    public Connection connect() throws ClassNotFoundException, SQLException {
        DBConnection db = new DBConnection();
        return db.connect();
    }

    
    public int createRequest(RequestModel rm)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO requests "
          + "(request_id, customer_name, company_name, email, phone, "
          + "plan, status, priority, address, notes) "
          + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        String reqId = "REQ-" + System.currentTimeMillis();
        ps.setString(1, reqId);
        ps.setString(2, rm.getCustomerName());
        ps.setString(3, rm.getCompanyName());
        ps.setString(4, rm.getEmail());
        ps.setString(5, rm.getPhone());
        ps.setString(6, rm.getPlan());
        ps.setString(7, "Pending");
        ps.setString(8, rm.getPriority());
        ps.setString(9, rm.getAddress());
        ps.setString(10, rm.getNotes());
        int result = ps.executeUpdate();
        con.close();
        return result;
    }

   
    public int updateStatus(String requestId, String status)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE requests SET status = ? WHERE request_id = ?");
        ps.setString(1, status);
        ps.setString(2, requestId);
        int result = ps.executeUpdate();
        con.close();
        return result;
    }

  
    public List<RequestModel> getAllRequests()
            throws ClassNotFoundException, SQLException {
        List<RequestModel> list = new ArrayList<>();
        Connection con = connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT * FROM requests ORDER BY submitted_at DESC");
        while (rs.next()) {
            RequestModel rm = new RequestModel();
            rm.setId(rs.getInt("id"));
            rm.setRequestId(rs.getString("request_id"));
            rm.setCustomerName(rs.getString("customer_name"));
            rm.setCompanyName(rs.getString("company_name"));
            rm.setPlan(rs.getString("plan"));
            rm.setStatus(rs.getString("status"));
            rm.setPriority(rs.getString("priority"));
            rm.setSubmittedAt(rs.getTimestamp("submitted_at"));
            list.add(rm);
        }
        con.close();
        return list;
    }

   
    public int countByStatus(String status)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(
            "SELECT COUNT(*) FROM requests WHERE status = ?");
        ps.setString(1, status);
        ResultSet rs = ps.executeQuery();
        int count = rs.next() ? rs.getInt(1) : 0;
        con.close();
        return count;
    }

    
    public List<RequestModel> getPendingRequests()
            throws ClassNotFoundException, SQLException {
        List<RequestModel> list = new ArrayList<>();
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM requests WHERE status = 'Pending' "
          + "ORDER BY submitted_at DESC");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            RequestModel rm = new RequestModel();
            rm.setId(rs.getInt("id"));
            rm.setRequestId(rs.getString("request_id"));
            rm.setCustomerName(rs.getString("customer_name"));
            rm.setPlan(rs.getString("plan"));
            rm.setPriority(rs.getString("priority"));
            rm.setSubmittedAt(rs.getTimestamp("submitted_at"));
            list.add(rm);
        }
        con.close();
        return list;
    }
}
