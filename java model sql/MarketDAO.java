
package supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;


public class MarketDAO 
{
 static Connection con;
    
     public static Connection Connect() throws SQLException, ClassNotFoundException {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/super_market";
            String user = "postgres";
            String password = "arun@1827";
            con = DriverManager.getConnection(url, user, password);
            return con;
    }
     public int customerDetails(MarketModelClass mm) throws SQLException, ClassNotFoundException
     {
         con = Connect();
         PreparedStatement ps = con.prepareStatement("insert into customer values (?,?,?,?,?)");
         ps.setInt(1,mm.getCusId());
         ps.setString(2,mm.getCusName());
         ps.setString(3,mm.getCity());
         ps.setString(4,mm.getGrade());
         ps.setInt(5,mm.getSalesmanId());
         
         int result = ps.executeUpdate();
         
         return result;
     }
     
}
