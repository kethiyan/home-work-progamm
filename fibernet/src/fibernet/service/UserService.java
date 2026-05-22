package fibernet.service;

import fibernet.dao.UserDAO;
import fibernet.model.UserModel;
import java.sql.SQLException;


public class UserService {

    
    public boolean register(UserModel um)
            throws ClassNotFoundException, SQLException {
        UserDAO dao = new UserDAO();

       
        if (dao.emailExists(um.getEmail())) {
            System.out.println("❌ Email already registered!");
            return false;
        }

        int result = dao.register(um);
        if (result > 0) {
            System.out.println("✅ User registered: " + um.getFullName());
            return true;
        } else {
            System.out.println("❌ Registration failed!");
            return false;
        }
    }

   
    public UserModel login(String email, String password)
            throws ClassNotFoundException, SQLException {
        if (email == null || email.isEmpty() ||
            password == null || password.isEmpty()) {
            System.out.println("❌ Email/Password empty!");
            return null;
        }

        UserDAO dao = new UserDAO();
        UserModel user = dao.login(email, password);

        if (user != null) {
            System.out.println("✅ Login success: " + user.getFullName());
        } else {
            System.out.println("❌ Invalid credentials!");
        }
        return user;
    }
}
