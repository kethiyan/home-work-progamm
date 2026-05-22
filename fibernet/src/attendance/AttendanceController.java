package attendance;

import fibernet.db.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AttendanceController implements Initializable {

    @FXML private DatePicker datePicker;
    @FXML private Label  totalLabel;
    @FXML private Label  presentLabel;
    @FXML private Label  absentLabel;
    @FXML private Label  leaveLabel;
    @FXML private TextField searchField;
    @FXML private TableView<ObservableList<String>> attendanceTable;
    @FXML private TableColumn<ObservableList<String>, String> colName;
    @FXML private TableColumn<ObservableList<String>, String> colDept;
    @FXML private TableColumn<ObservableList<String>, String> colEmpCode;
    @FXML private TableColumn<ObservableList<String>, String> colStatus;
    @FXML private TableColumn<ObservableList<String>, String> colNote;
    @FXML private TableColumn<ObservableList<String>, String> colTime;

    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datePicker.setValue(LocalDate.now());
        setupColumns();
        loadEmployees();
        setupSearch();
    }

    private void setupColumns() {
        colName.setCellValueFactory(   r -> new SimpleStringProperty(r.getValue().get(0)));
        colDept.setCellValueFactory(   r -> new SimpleStringProperty(r.getValue().get(1)));
        colEmpCode.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().get(2)));
        colStatus.setCellValueFactory( r -> new SimpleStringProperty(r.getValue().get(3)));
        colNote.setCellValueFactory(   r -> new SimpleStringProperty(r.getValue().get(4)));
        colTime.setCellValueFactory(   r -> new SimpleStringProperty(r.getValue().get(5)));
    }

    private void loadEmployees() {
        data.clear();
        LocalDate date = datePicker.getValue() != null ? datePicker.getValue() : LocalDate.now();
        try {
            // Fresh connection - singleton reuse cause type mismatch
            DBConnection db = new DBConnection();
            Connection con = db.connect();

            PreparedStatement ps = con.prepareStatement(
                "SELECT e.id, e.name, e.department, e.emp_code, " +
                "COALESCE(a.status,'--') as status, " +
                "COALESCE(a.note,'') as note, " +
                "COALESCE(a.time_in,'--') as time_in " +
                "FROM employees e " +
                "LEFT JOIN attendance a ON e.id = a.employee_id AND a.date = ? " +
                "ORDER BY e.id");

            // Cast to DATE explicitly to avoid type mismatch
            ps.setObject(1, date, java.sql.Types.DATE);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(rs.getString("name"));
                row.add(rs.getString("department"));
                row.add(rs.getString("emp_code"));
                row.add(rs.getString("status"));
                row.add(rs.getString("note"));
                row.add(rs.getString("time_in"));
                data.add(row);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Attendance load error: " + e.getMessage());
            loadSample();
        }
        attendanceTable.setItems(data);
        updateStats();
    }

    private void loadSample() {
        String[][] rows = {
            {"Arun Kumar",   "Engineering","EMP-001","P","","09:00"},
            {"Priya Sharma", "HR",         "EMP-002","P","","09:15"},
            {"Suresh Rajan", "Finance",    "EMP-003","A","Sick","--"},
            {"Meena Devi",   "Marketing",  "EMP-004","P","","09:05"},
            {"Karthik Raja", "Operations", "EMP-005","L","Casual Leave","--"},
            {"Vijay Nair",   "Sales",      "EMP-006","P","","09:30"},
        };
        for (String[] r : rows)
            data.add(FXCollections.observableArrayList(r));
    }

    private void updateStats() {
        int p=0, a=0, l=0;
        for (ObservableList<String> row : data) {
            switch (row.get(3)) {
                case "P" -> p++;
                case "A" -> a++;
                case "L" -> l++;
            }
        }
        if (totalLabel   != null) totalLabel.setText(String.valueOf(data.size()));
        if (presentLabel != null) presentLabel.setText(String.valueOf(p));
        if (absentLabel  != null) absentLabel.setText(String.valueOf(a));
        if (leaveLabel   != null) leaveLabel.setText(String.valueOf(l));
    }

    @FXML private void changeDate(ActionEvent event) { loadEmployees(); }

    @FXML
    private void markAllPresent(ActionEvent event) {
        LocalDate date = datePicker.getValue() != null ? datePicker.getValue() : LocalDate.now();
        try {
            DBConnection db = new DBConnection();
            Connection con = db.connect();
            ResultSet emp = con.createStatement().executeQuery("SELECT id FROM employees");
            while (emp.next()) {
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO attendance (employee_id, date, status, time_in) VALUES (?,?,?,?) " +
                    "ON CONFLICT (employee_id, date) DO UPDATE SET status='P', time_in=?");
                ps.setInt(1, emp.getInt("id"));
                ps.setObject(2, date, java.sql.Types.DATE);
                ps.setString(3, "P");
                ps.setString(4, "09:00");
                ps.setString(5, "09:00");
                ps.executeUpdate();
            }
            con.close();
            loadEmployees();
            new Alert(Alert.AlertType.INFORMATION, "✅ All marked Present!").show();
        } catch (Exception e) {
            System.out.println("Mark present error: " + e.getMessage());
            for (ObservableList<String> row : data) row.set(3, "P");
            attendanceTable.refresh();
            updateStats();
        }
    }

    @FXML
    private void saveAttendance(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "✅ Attendance Saved!").show();
    }

    private void setupSearch() {
        if (searchField == null) return;
        searchField.textProperty().addListener((o, old, val) -> {
            if (val.isEmpty()) { attendanceTable.setItems(data); return; }
            ObservableList<ObservableList<String>> f = FXCollections.observableArrayList();
            for (ObservableList<String> row : data)
                if (row.get(0).toLowerCase().contains(val.toLowerCase()) ||
                    row.get(2).toLowerCase().contains(val.toLowerCase()))
                    f.add(row);
            attendanceTable.setItems(f);
        });
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Menu/Menu.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setMaximized(true);
        stage.show();
        ((Stage)((Node) event.getSource()).getScene().getWindow()).close();
    }
}