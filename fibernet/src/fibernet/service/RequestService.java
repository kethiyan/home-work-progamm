package fibernet.service;

import fibernet.dao.RequestDAO;
import fibernet.model.RequestModel;
import java.sql.SQLException;
import java.util.List;


public class RequestService {

   
    public boolean createRequest(RequestModel rm)
            throws ClassNotFoundException, SQLException {
        if (rm.getCustomerName() == null ||
            rm.getCustomerName().isEmpty()) {
            System.out.println("❌ Customer name required!");
            return false;
        }

        RequestDAO dao = new RequestDAO();
        int result = dao.createRequest(rm);

        if (result > 0) {
            System.out.println("✅ Request created!");
            return true;
        } else {
            System.out.println("❌ Request failed!");
            return false;
        }
    }

    
    public boolean approveRequest(String requestId)
            throws ClassNotFoundException, SQLException {
        RequestDAO dao = new RequestDAO();
        int result = dao.updateStatus(requestId, "Approved");

        if (result > 0) {
            System.out.println("✅ Request approved: " + requestId);
            return true;
        }
        return false;
    }

   
    public boolean rejectRequest(String requestId)
            throws ClassNotFoundException, SQLException {
        RequestDAO dao = new RequestDAO();
        int result = dao.updateStatus(requestId, "Rejected");

        if (result > 0) {
            System.out.println("✅ Request rejected: " + requestId);
            return true;
        }
        return false;
    }

    
    public List<RequestModel> getAllRequests()
            throws ClassNotFoundException, SQLException {
        RequestDAO dao = new RequestDAO();
        return dao.getAllRequests();
    }

    
    public List<RequestModel> getPendingRequests()
            throws ClassNotFoundException, SQLException {
        RequestDAO dao = new RequestDAO();
        return dao.getPendingRequests();
    }

   
    public int getPendingCount()
            throws ClassNotFoundException, SQLException {
        return new RequestDAO().countByStatus("Pending");
    }

    public int getApprovedCount()
            throws ClassNotFoundException, SQLException {
        return new RequestDAO().countByStatus("Approved");
    }

    public int getRejectedCount()
            throws ClassNotFoundException, SQLException {
        return new RequestDAO().countByStatus("Rejected");
    }
}
