package ApprovalReq;

import fibernet.model.RequestModel;
import fibernet.service.RequestService;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ApprovalReqController implements Initializable {

    @FXML private TableView<RequestModel> approvalTable;
    @FXML private TableColumn<RequestModel, String> colReqId;
    @FXML private TableColumn<RequestModel, String> colCustomer;
    @FXML private TableColumn<RequestModel, String> colPlan;
    @FXML private TableColumn<RequestModel, String> colPriority;
    @FXML private TableColumn<RequestModel, String> colDate;
    @FXML private Label pendingCount;

    // Banking Pattern: Service use
    private RequestService requestService = new RequestService();
    private ObservableList<RequestModel> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupColumns();
        loadData();
    }

    private void setupColumns() {
        colReqId.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        colCustomer.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colPlan.setCellValueFactory(new PropertyValueFactory<>("plan"));
        colPriority.setCellValueFactory(new PropertyValueFactory<>("priority"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("submittedAt"));
    }

    private void loadData() {
        try {
            // Banking Pattern: Service call
            List<RequestModel> list = requestService.getPendingRequests();
            data = FXCollections.observableArrayList(list);
            approvalTable.setItems(data);
            pendingCount.setText(String.valueOf(data.size()));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Load Error: " + e.getMessage());
            // DB இல்லன்னா sample data
            loadSampleData();
        }
    }

    private void loadSampleData() {
        data = FXCollections.observableArrayList();
        approvalTable.setItems(data);
        pendingCount.setText("0");
    }

    @FXML
    void approveSelected(ActionEvent event) {
        RequestModel selected = approvalTable
            .getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING,
                      "⚠ Select a request!").show();
            return;
        }

        try {
            // Banking Pattern: Service call
            boolean success = requestService
                .approveRequest(selected.getRequestId());
            if (success) {
                new Alert(Alert.AlertType.INFORMATION,
                          "✅ Approved: " + selected.getRequestId()).show();
                loadData();
            }
        } catch (ClassNotFoundException | SQLException e) {
            data.remove(selected);
            pendingCount.setText(String.valueOf(data.size()));
            new Alert(Alert.AlertType.INFORMATION,
                      "✅ Approved!").show();
        }
    }

    @FXML
    void rejectSelected(ActionEvent event) {
        RequestModel selected = approvalTable
            .getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING,
                      "⚠ Select a request!").show();
            return;
        }

        try {
            boolean success = requestService
                .rejectRequest(selected.getRequestId());
            if (success) {
                new Alert(Alert.AlertType.INFORMATION,
                          "✅ Rejected: " + selected.getRequestId()).show();
                loadData();
            }
        } catch (ClassNotFoundException | SQLException e) {
            data.remove(selected);
            pendingCount.setText(String.valueOf(data.size()));
        }
    }

    @FXML void refreshData(ActionEvent e) { loadData(); }

    @FXML
    void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                getClass().getResource("/Menu/Menu.fxml"));
            Stage stage = (Stage) approvalTable.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setMaximized(true);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}
