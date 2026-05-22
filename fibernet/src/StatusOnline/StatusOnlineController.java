package StatusOnline;

import fibernet.db.DBConnection;
import java.io.IOException;
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

public class StatusOnlineController implements Initializable {

    @FXML private Label totalLabel;
    @FXML private Label onlineLabel;
    @FXML private Label offlineLabel;
    @FXML private Label suspendedLabel;
    @FXML private TextField searchField;
    @FXML private ComboBox<String> statusFilter;
    @FXML private Label lastUpdated;
    @FXML private TableView<ObservableList<String>> statusTable;
    @FXML private TableColumn<ObservableList<String>, String> colUserId;
    @FXML private TableColumn<ObservableList<String>, String> colName;
    @FXML private TableColumn<ObservableList<String>, String> colPlan;
    @FXML private TableColumn<ObservableList<String>, String> colStatus;
    @FXML private TableColumn<ObservableList<String>, String> colLastSeen;
    @FXML private TableColumn<ObservableList<String>, String> colIp;

    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupColumns();
        setupFilters();
        loadData();
        setupSearch();
        if (lastUpdated != null)
            lastUpdated.setText("Updated: " + java.time.LocalTime.now()
                .toString().substring(0, 8));
    }

    private void setupColumns() {
        colUserId.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().get(0)));
        colName.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().get(1)));
        colPlan.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().get(2)));
        colStatus.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().get(3)));
        colLastSeen.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().get(4)));
        colIp.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().get(5)));
    }

    private void setupFilters() {
        if (statusFilter != null) {
            statusFilter.setItems(FXCollections.observableArrayList(
                "All", "Online", "Offline", "Suspended"));
            statusFilter.setOnAction(e -> filterByStatus());
        }
    }

    private void loadData() {
        data.clear();
        try {
            Connection con = DBConnection.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(
                    "SELECT u.id, u.full_name, 'Business - 1 Gbps' as plan FROM users u ORDER BY u.id");
                String[] statuses = {"Online", "Online", "Offline", "Online", "Suspended"};
                String[] ips = {"192.168.1.10","10.0.0.5","192.168.2.20","10.0.1.15","192.168.3.30"};
                int i = 0;
                while (rs.next()) {
                    ObservableList<String> row = FXCollections.observableArrayList();
                    row.add("USR-" + String.format("%04d", rs.getInt("id")));
                    row.add(rs.getString("full_name"));
                    row.add(rs.getString("plan"));
                    row.add(statuses[i % statuses.length]);
                    row.add(i == 2 ? "2 hours ago" : "Just now");
                    row.add(ips[i % ips.length]);
                    data.add(row);
                    i++;
                }
                con.close();
            }
        } catch (Exception e) {
            System.out.println("StatusOnline DB: " + e.getMessage());
        }

        if (data.isEmpty()) loadSampleData();

        statusTable.setItems(data);
        updateStats();
    }

    private void loadSampleData() {
        String[][] rows = {
            {"USR-0001","Rajesh Kumar","Business - 1 Gbps","Online","Just now","192.168.1.10"},
            {"USR-0002","Arun Mehta","Enterprise - 10 Gbps","Online","Just now","10.0.0.5"},
            {"USR-0003","Kiran Rajan","Starter - 100 Mbps","Offline","2 hours ago","192.168.2.20"},
            {"USR-0004","Sunita Shah","Business - 1 Gbps","Online","5 min ago","10.0.1.15"},
            {"USR-0005","Mohan Das","Starter - 100 Mbps","Suspended","3 days ago","192.168.3.30"},
            {"USR-0006","Priya Nair","Enterprise - 10 Gbps","Online","Just now","10.0.2.25"},
        };
        for (String[] r : rows)
            data.add(FXCollections.observableArrayList(r));
    }

    private void updateStats() {
        int online = 0, offline = 0, suspended = 0;
        for (ObservableList<String> row : data) {
            switch (row.get(3)) {
                case "Online" -> online++;
                case "Offline" -> offline++;
                case "Suspended" -> suspended++;
            }
        }
        if (totalLabel != null) totalLabel.setText(String.valueOf(data.size()));
        if (onlineLabel != null) onlineLabel.setText(String.valueOf(online));
        if (offlineLabel != null) offlineLabel.setText(String.valueOf(offline));
        if (suspendedLabel != null) suspendedLabel.setText(String.valueOf(suspended));
    }

    private void setupSearch() {
        if (searchField == null) return;
        searchField.textProperty().addListener((obs, old, val) -> {
            if (val.isEmpty()) { statusTable.setItems(data); return; }
            ObservableList<ObservableList<String>> f = FXCollections.observableArrayList();
            for (ObservableList<String> row : data)
                if (row.get(1).toLowerCase().contains(val.toLowerCase()) ||
                    row.get(0).toLowerCase().contains(val.toLowerCase()))
                    f.add(row);
            statusTable.setItems(f);
        });
    }

    private void filterByStatus() {
        String selected = statusFilter.getValue();
        if (selected == null || selected.equals("All")) {
            statusTable.setItems(data); return;
        }
        ObservableList<ObservableList<String>> f = FXCollections.observableArrayList();
        for (ObservableList<String> row : data)
            if (row.get(3).equals(selected)) f.add(row);
        statusTable.setItems(f);
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Menu/Menu.fxml"));
        Stage stage = (Stage) statusTable.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setMaximized(true);
    }

    @FXML
    private void refreshData(ActionEvent event) {
        loadData();
        if (lastUpdated != null)
            lastUpdated.setText("Updated: " + java.time.LocalTime.now()
                .toString().substring(0, 8));
    }
}
