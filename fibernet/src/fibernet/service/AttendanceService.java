package fibernet.service;

import fibernet.dao.AttendanceDAO;
import fibernet.model.AttendanceModel;
import java.sql.SQLException;
import java.util.List;


public class AttendanceService {

  
    public boolean markAttendance(AttendanceModel am)
            throws ClassNotFoundException, SQLException {
        if (am.getDate() == null || am.getDate().isEmpty()) {
            System.out.println("❌ Date required!");
            return false;
        }

        AttendanceDAO dao = new AttendanceDAO();
        int result = dao.saveAttendance(am);

        if (result > 0) {
            System.out.println("✅ Attendance saved: " +
                am.getEmployeeName() + " - " + am.getStatus());
            return true;
        }
        return false;
    }

   
    public int saveAllAttendance(List<AttendanceModel> list, String date)
            throws ClassNotFoundException, SQLException {
        AttendanceDAO dao = new AttendanceDAO();
        int saved = 0;
        for (AttendanceModel am : list) {
            am.setDate(date);
            int result = dao.saveAttendance(am);
            if (result > 0) saved++;
        }
        System.out.println("✅ " + saved + " records saved!");
        return saved;
    }

    
    public List<AttendanceModel> getByDate(String date)
            throws ClassNotFoundException, SQLException {
        return new AttendanceDAO().getByDate(date);
    }

    
    public List<AttendanceModel> getAllEmployees()
            throws ClassNotFoundException, SQLException {
        return new AttendanceDAO().getAllEmployees();
    }

   
    public int getPresentCount(String date)
            throws ClassNotFoundException, SQLException {
        return new AttendanceDAO().countByStatus(date, "P");
    }

    public int getAbsentCount(String date)
            throws ClassNotFoundException, SQLException {
        return new AttendanceDAO().countByStatus(date, "A");
    }

    public int getLeaveCount(String date)
            throws ClassNotFoundException, SQLException {
        return new AttendanceDAO().countByStatus(date, "L");
    }
}
