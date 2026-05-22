package BillDetail;

import fibernet.db.DBConnection;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class BillDetailController implements Initializable {

    @FXML private Label totalBills;
    @FXML private Label paidBills;
    @FXML private Label pendingBills;
    @FXML private Label overdueBills;
    @FXML private TextField searchField;
    @FXML private ComboBox<String> statusFilter;
    @FXML private TableView<ObservableList<String>> billTable;
    @FXML private TableColumn<ObservableList<String>, String> colBillId;
    @FXML private TableColumn<ObservableList<String>, String> colCustomer;
    @FXML private TableColumn<ObservableList<String>, String> colAmount;
    @FXML private TableColumn<ObservableList<String>, String> colDate;
    @FXML private TableColumn<ObservableList<String>, String> colStatus;

    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupColumns();
        setupFilters();
        loadData();
        setupSearch();
    }

    private void setupColumns() {
        colBillId.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().get(0)));
        colCustomer.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().get(1)));
        colAmount.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().get(2)));
        colDate.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().get(3)));
        colStatus.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().get(4)));
    }

    private void setupFilters() {
        if (statusFilter != null) {
            statusFilter.setItems(FXCollections.observableArrayList(
                "All", "Paid", "Pending", "Overdue"));
            statusFilter.setOnAction(e -> filterByStatus());
        }
    }

    private void loadData() {
        data.clear();
        try {
            // Try DB first - bills table if exists
            Connection con = DBConnection.getConnection();
            if (con != null) {
                // Try to load from requests as billing reference
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(
                    "SELECT request_id, customer_name, plan, submitted_at, status FROM requests ORDER BY submitted_at DESC");
                int i = 1;
                while (rs.next()) {
                    ObservableList<String> row = FXCollections.observableArrayList();
                    row.add("BILL-" + String.format("%04d", i++));
                    row.add(rs.getString("customer_name"));
                    row.add(getPlanPrice(rs.getString("plan")));
                    row.add(rs.getTimestamp("submitted_at") != null ?
                        rs.getTimestamp("submitted_at").toString().substring(0, 10) : "-");
                    row.add(rs.getString("status").equals("Approved") ? "Paid" : "Pending");
                    data.add(row);
                }
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Bill DB load: " + e.getMessage());
        }

        // If no DB data, load sample
        if (data.isEmpty()) {
            loadSampleData();
        }

        billTable.setItems(data);
        updateStats();
    }

    private String getPlanPrice(String plan) {
        if (plan == null) return "₹0";
        if (plan.contains("10 Gbps")) return "₹45,000";
        if (plan.contains("1 Gbps")) return "₹7,999";
        if (plan.contains("100 Mbps")) return "₹2,999";
        return "₹5,000";
    }

    private void loadSampleData() {
        String[][] bills = {
            {"BILL-0001","Rajesh Kumar","₹7,999","2024-01-15","Paid"},
            {"BILL-0002","Arun Mehta","₹45,000","2024-01-20","Paid"},
            {"BILL-0003","Kiran Rajan","₹2,999","2024-02-01","Pending"},
            {"BILL-0004","Sunita Shah","₹7,999","2024-02-10","Overdue"},
            {"BILL-0005","Mohan Das","₹2,999","2024-02-15","Paid"},
            {"BILL-0006","Priya Nair","₹45,000","2024-03-01","Pending"},
        };
        for (String[] b : bills) {
            ObservableList<String> row = FXCollections.observableArrayList(b);
            data.add(row);
        }
    }

    private void updateStats() {
        int paid = 0, pending = 0, overdue = 0;
        for (ObservableList<String> row : data) {
            switch (row.get(4)) {
                case "Paid" -> paid++;
                case "Pending" -> pending++;
                case "Overdue" -> overdue++;
            }
        }
        if (totalBills != null) totalBills.setText(String.valueOf(data.size()));
        if (paidBills != null) paidBills.setText(String.valueOf(paid));
        if (pendingBills != null) pendingBills.setText(String.valueOf(pending));
        if (overdueBills != null) overdueBills.setText(String.valueOf(overdue));
    }

    private void setupSearch() {
        if (searchField == null) return;
        searchField.textProperty().addListener((obs, old, val) -> {
            if (val.isEmpty()) { billTable.setItems(data); return; }
            ObservableList<ObservableList<String>> filtered = FXCollections.observableArrayList();
            for (ObservableList<String> row : data)
                if (row.get(1).toLowerCase().contains(val.toLowerCase()) ||
                    row.get(0).toLowerCase().contains(val.toLowerCase()))
                    filtered.add(row);
            billTable.setItems(filtered);
        });
    }

    private void filterByStatus() {
        String selected = statusFilter.getValue();
        if (selected == null || selected.equals("All")) {
            billTable.setItems(data); return;
        }
        ObservableList<ObservableList<String>> filtered = FXCollections.observableArrayList();
        for (ObservableList<String> row : data)
            if (row.get(4).equals(selected)) filtered.add(row);
        billTable.setItems(filtered);
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Menu/Menu.fxml"));
            Stage stage = (Stage) billTable.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setMaximized(true);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    @FXML
    private void newBill(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "New Bill form coming soon!").show();
    }

    @FXML
    private void refreshData(ActionEvent event) {
        loadData();
    }
}
