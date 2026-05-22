package fibernet.dao;

import fibernet.db.DBConnection;
import fibernet.model.AttendanceModel;
import java.sql.*;
import java.util.*;


public class AttendanceDAO {

    public Connection connect() throws ClassNotFoundException, SQLException {
        DBConnection db = new DBConnection();
        return db.connect();
    }

    
    public int saveAttendance(AttendanceModel am)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO attendance (employee_id, date, status, note, time_in) "
          + "VALUES (?, ?, ?, ?, ?) "
          + "ON CONFLICT (employee_id, date) "
          + "DO UPDATE SET status = ?, note = ?, time_in = ?");
        ps.setInt(1, am.getEmployeeId());
        ps.setString(2, am.getDate());
        ps.setString(3, am.getStatus());
        ps.setString(4, am.getNote());
        ps.setString(5, am.getTimeIn());
        ps.setString(6, am.getStatus());
        ps.setString(7, am.getNote());
        ps.setString(8, am.getTimeIn());
        int result = ps.executeUpdate();
        con.close();
        return result;
    }

    
    public List<AttendanceModel> getByDate(String date)
            throws ClassNotFoundException, SQLException {
        List<AttendanceModel> list = new ArrayList<>();
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(
            "SELECT a.*, e.name as emp_name, e.department, e.emp_code "
          + "FROM attendance a "
          + "JOIN employees e ON a.employee_id = e.id "
          + "WHERE a.date = ?");
        ps.setString(1, date);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            AttendanceModel am = new AttendanceModel();
            am.setId(rs.getInt("id"));
            am.setEmployeeId(rs.getInt("employee_id"));
            am.setEmployeeName(rs.getString("emp_name"));
            am.setDepartment(rs.getString("department"));
            am.setEmpCode(rs.getString("emp_code"));
            am.setStatus(rs.getString("status"));
            am.setNote(rs.getString("note"));
            am.setTimeIn(rs.getString("time_in"));
            am.setDate(date);
            list.add(am);
        }
        con.close();
        return list;
    }

    
    public List<AttendanceModel> getAllEmployees()
            throws ClassNotFoundException, SQLException {
        List<AttendanceModel> list = new ArrayList<>();
        Connection con = connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT * FROM employees ORDER BY name");
        while (rs.next()) {
            AttendanceModel am = new AttendanceModel();
            am.setEmployeeId(rs.getInt("id"));
            am.setEmployeeName(rs.getString("name"));
            am.setDepartment(rs.getString("department"));
            am.setEmpCode(rs.getString("emp_code"));
            am.setStatus("P");
            am.setNote("");
            am.setTimeIn("");
            list.add(am);
        }
        con.close();
        return list;
    }

    
    public int countByStatus(String date, String status)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(
            "SELECT COUNT(*) FROM attendance WHERE date = ? AND status = ?");
        ps.setString(1, date);
        ps.setString(2, status);
        ResultSet rs = ps.executeQuery();
        int count = rs.next() ? rs.getInt(1) : 0;
        con.close();
        return count;
    }
}
