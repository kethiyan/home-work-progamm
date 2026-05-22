package signup;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController implements Initializable {

    @FXML private TextField fullName;
    @FXML private TextField mobile;
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private PasswordField confirmPassword;
    @FXML private Label errorLabel;

    private UserService userService = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (errorLabel != null) errorLabel.setVisible(false);
    }

    @FXML
    private void signUp(ActionEvent event) {
        if (fullName.getText().isEmpty() || email.getText().isEmpty()
                || password.getText().isEmpty()) {
            showMsg("⚠ Please fill all fields!", "#ff5555");
            return;
        }
        if (!password.getText().equals(confirmPassword.getText())) {
            showMsg("❌ Passwords do not match!", "#ff5555");
            return;
        }
        try {
            UserModel um = new UserModel(
                fullName.getText(), email.getText(),
                mobile.getText(), password.getText(), "user"
            );
            boolean success = userService.register(um);
            if (success) {
                showMsg("✅ Account Created Successfully!", "#00cc88");
                fullName.clear(); email.clear(); mobile.clear();
                password.clear(); confirmPassword.clear();
            } else {
                showMsg("❌ Email already registered!", "#ff5555");
            }
        } catch (ClassNotFoundException | SQLException e) {
            showMsg("❌ DB Error: " + e.getMessage(), "#ff5555");
        }
    }

    @FXML
    private void goToLogin(javafx.scene.input.MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fibernet/login.fxml"));
        Stage stage = (Stage) fullName.getScene().getWindow();
        stage.setScene(new Scene(root, 950, 600));
    }

    private void showMsg(String msg, String color) {
        errorLabel.setText(msg);
        errorLabel.setStyle("-fx-text-fill: " + color + "; -fx-font-size: 12;");
        errorLabel.setVisible(true);
    }
}
