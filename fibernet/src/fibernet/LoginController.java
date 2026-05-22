package fibernet;

import fibernet.model.UserModel;
import fibernet.service.UserService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Label errorLabel;

    private UserService userService = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLabel.setVisible(false);
    }

    @FXML
    private void login(ActionEvent event) {
        String user = username.getText().trim();
        String pass = password.getText().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            showError("⚠ Please enter username and password!");
            return;
        }

        try {
           
            UserModel loggedUser = userService.login(user, pass);

            if (loggedUser != null) {
                Parent root = FXMLLoader.load(
                    getClass().getResource("/Menu/Menu.fxml"));
                Stage stage = new Stage();
                stage.setTitle("FiberNet - " + loggedUser.getFullName());
                stage.setScene(new Scene(root));
                stage.setMaximized(true);
                stage.show();
                ((Stage)((Node) event.getSource())
                    .getScene().getWindow()).close();
            } else {
                showError("❌ Invalid Username or Password!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            showError("❌ DB Error: " + e.getMessage());
            System.out.println("DB Error: " + e.getMessage());
        } catch (IOException e) {
            showError("❌ Page Error: " + e.getMessage());
        }
    }

    @FXML
    private void signup(javafx.scene.input.MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(
                getClass().getResource("/signup/SignUp.fxml"));
            Stage stage = new Stage();
            stage.setTitle("FiberNet - Sign Up");
            stage.setScene(new Scene(root, 1000, 650));
            stage.show();
        } catch (IOException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void showError(String msg) {
        errorLabel.setText(msg);
        errorLabel.setVisible(true);
    }
}
