package Menu;

import fibernet.service.RequestService;
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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuController implements Initializable {

    @FXML private VBox sidebarVBox;
    @FXML private TextField searchField;

    @FXML private HBox customerMgmtBox;
    @FXML private Label customerMgmtArrow;
    @FXML private VBox customerSubMenu;

    @FXML private HBox billDetailBox;
    @FXML private HBox statusOnlineBox;
    @FXML private HBox newRequestBox;
    @FXML private HBox approvalRequestBox;

    @FXML private HBox attendanceBox;
    @FXML private VBox attendanceSubMenu;

    @FXML private HBox stockListBox;
    @FXML private HBox requestStockBox;
    @FXML private HBox attendanceItemBox;

    @FXML private LineChart<String, Number> revenueChart;
    @FXML private Label customerMgmtArrow1;

    // Dashboard stat labels (optional - if present in FXML)
    @FXML private Label pendingCount;
    @FXML private Label approvedCount;
    @FXML private Label rejectedCount;

    private RequestService requestService = new RequestService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customerSubMenu.setVisible(false);
        attendanceSubMenu.setVisible(false);
        loadDashboardStats();
        loadRevenueChart();
    }

    private void loadDashboardStats() {
        try {
            if (pendingCount != null)
                pendingCount.setText(String.valueOf(requestService.getPendingCount()));
            if (approvedCount != null)
                approvedCount.setText(String.valueOf(requestService.getApprovedCount()));
            if (rejectedCount != null)
                rejectedCount.setText(String.valueOf(requestService.getRejectedCount()));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Dashboard load error: " + e.getMessage());
        }
    }

    private void loadRevenueChart() {
        try {
            if (revenueChart == null) return;
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Revenue");
            series.getData().add(new XYChart.Data<>("Jan", 85000));
            series.getData().add(new XYChart.Data<>("Feb", 92000));
            series.getData().add(new XYChart.Data<>("Mar", 78000));
            series.getData().add(new XYChart.Data<>("Apr", 105000));
            series.getData().add(new XYChart.Data<>("May", 98000));
            series.getData().add(new XYChart.Data<>("Jun", 112000));
            revenueChart.getData().add(series);
        } catch (Exception e) {
            System.out.println("Chart error: " + e.getMessage());
        }
    }

    @FXML
    private void toggleCustomerMenu(MouseEvent event) {
        boolean isVisible = customerSubMenu.isVisible();
        customerSubMenu.setVisible(!isVisible);
        if (customerMgmtArrow != null)
            customerMgmtArrow.setText(isVisible ? "▶" : "▼");
    }

    @FXML
    private void toggleAttendanceMenu(MouseEvent event) {
        boolean isVisible = attendanceSubMenu.isVisible();
        attendanceSubMenu.setVisible(!isVisible);
        if (customerMgmtArrow1 != null)
            customerMgmtArrow1.setText(isVisible ? "▶" : "▼");
    }

    @FXML
    private void billDetail(ActionEvent event) throws IOException {
        loadPage("/BillDetail/BillDetail.fxml", "Bill Detail", event);
    }

    @FXML
    private void statusOnline(ActionEvent event) throws IOException {
        loadPage("/StatusOnline/StatusOnline.fxml", "Status Online", event);
    }

    @FXML
    private void newRequest(ActionEvent event) throws IOException {
        loadPage("/newRequest/NewRequest.fxml", "New Request", event);
    }

    @FXML
    private void approvalRequest(ActionEvent event) throws IOException {
        loadPage("/ApprovalReq/ApprovalReq.fxml", "Approval Request", event);
    }

    @FXML
    private void stockList(ActionEvent event) throws IOException {
        loadPage("/stockList/StockList.fxml", "Stock List", event);
    }

    @FXML
    private void requestStock(ActionEvent event) throws IOException {
        loadPage("/RequestStock/RequestStock.fxml", "Request Stock", event);
    }

    @FXML
    private void Attendance(ActionEvent event) throws IOException {
        loadPage("/attendance/Attendance.fxml", "Attendance", event);
    }

    private void loadPage(String fxmlPath, String title, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("FiberNet - " + title);
        stage.setScene(new Scene(root));
        stage.setMaximized(true);
    }
}
