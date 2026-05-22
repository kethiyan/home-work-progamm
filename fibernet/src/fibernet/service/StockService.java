package fibernet.service;

import fibernet.dao.StockDAO;
import fibernet.model.StockModel;
import java.sql.SQLException;
import java.util.List;


public class StockService {

   
    public boolean addStock(StockModel sm)
            throws ClassNotFoundException, SQLException {
        if (sm.getItemName() == null || sm.getItemName().isEmpty()) {
            System.out.println("❌ Item name required!");
            return false;
        }

        StockDAO dao = new StockDAO();
        int result = dao.addStock(sm);

        if (result > 0) {
            System.out.println("✅ Stock added: " + sm.getItemName());
            return true;
        }
        return false;
    }

    
    public boolean updateStock(int id, int quantity)
            throws ClassNotFoundException, SQLException {
        StockDAO dao = new StockDAO();
        int result = dao.updateQuantity(id, quantity);

        if (result > 0) {
            System.out.println("✅ Stock updated!");
            return true;
        }
        return false;
    }

    
    public List<StockModel> getAllStock()
            throws ClassNotFoundException, SQLException {
        return new StockDAO().getAllStock();
    }

    // Counts
    public int getInStockCount()
            throws ClassNotFoundException, SQLException {
        return new StockDAO().countByStatus("In Stock");
    }

    public int getLowStockCount()
            throws ClassNotFoundException, SQLException {
        return new StockDAO().countByStatus("Low Stock");
    }

    public int getOutOfStockCount()
            throws ClassNotFoundException, SQLException {
        return new StockDAO().countByStatus("Out of Stock");
    }
}
