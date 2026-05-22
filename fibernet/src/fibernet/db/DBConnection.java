package fibernet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

       
    private static final String URL =
        "jdbc:postgresql://localhost:5432/fibernet_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "kiri89730"; 

    private static Connection connection = null;

    public Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ PostgreSQL Connected!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ DB Error: " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection Closed!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Close Error: " + e.getMessage());
        }
    }
}
