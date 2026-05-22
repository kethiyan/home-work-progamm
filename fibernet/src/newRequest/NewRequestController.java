package newRequest;

import fibernet.model.RequestModel;
import fibernet.service.RequestService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewRequestController implements Initializable {

    @FXML private TextField fullName, companyName, email, phone;
    @FXML private ComboBox<String> planSelect, priority;
    @FXML private DatePicker installDate;
    @FXML private TextArea address, notes;
    @FXML private Label msgLabel;

    // Banking Pattern: Service use
    private RequestService requestService = new RequestService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        planSelect.setItems(FXCollections.observableArrayList(
            "Starter - 100 Mbps - Rs.2,999/mo",
            "Business - 1 Gbps - Rs.7,999/mo",
            "Enterprise - 10 Gbps - Custom"
        ));
        priority.setItems(FXCollections.observableArrayList(
            "High", "Medium", "Low"
        ));
        msgLabel.setVisible(false);
    }

    @FXML
    void submitRequest(ActionEvent event) {
        if (fullName.getText().isEmpty() ||
            email.getText().isEmpty() ||
            address.getText().isEmpty() ||
            planSelect.getValue() == null) {
            showMsg("⚠ Please fill all required fields!", "#ff5555");
            return;
        }

        try {
            // Banking Pattern: Model create → Service call
            RequestModel rm = new RequestModel(
                fullName.getText(),
                companyName.getText(),
                email.getText(),
                phone.getText(),
                planSelect.getValue(),
                priority.getValue() != null ? priority.getValue() : "Medium",
                address.getText(),
                notes.getText()
            );

            boolean success = requestService.createRequest(rm);

            if (success) {
                showMsg("✅ Request Submitted Successfully!", "#00cc88");
                clearForm();
            } else {
                showMsg("❌ Submit Failed! Try again.", "#ff5555");
            }
        } catch (ClassNotFoundException | SQLException e) {
            showMsg("❌ DB Error: " + e.getMessage(), "#ff5555");
        }
    }

    @FXML void saveDraft(ActionEvent e) {
        showMsg("📋 Draft Saved!", "#ffa500");
    }

    @FXML void cancel(ActionEvent e) { clearForm(); }

    @FXML
    void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                getClass().getResource("/Menu/Menu.fxml"));
            Stage stage = (Stage) fullName.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setMaximized(true);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void clearForm() {
        fullName.clear(); companyName.clear();
        email.clear(); phone.clear();
        address.clear(); notes.clear();
        planSelect.setValue(null);
        priority.setValue(null);
        installDate.setValue(null);
    }

    private void showMsg(String msg, String color) {
        msgLabel.setText(msg);
        msgLabel.setStyle("-fx-text-fill: " + color + "; -fx-font-size: 13;");
        msgLabel.setVisible(true);
    }
}
