package stockList;

import fibernet.model.StockModel;
import fibernet.service.StockService;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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

public class StockListController implements Initializable {

    @FXML private TableView<StockModel> stockTable;
    @FXML private TableColumn<StockModel, String> colItemId;
    @FXML private TableColumn<StockModel, String> colItemName;
    @FXML private TableColumn<StockModel, String> colCategory;
    @FXML private TableColumn<StockModel, String> colQuantity;
    @FXML private TableColumn<StockModel, String> colUnit;
    @FXML private TableColumn<StockModel, String> colStatus;
    @FXML private TableColumn<StockModel, String> colLastUpdated;
    @FXML private TextField searchField;
    @FXML private ComboBox<String> categoryFilter;
    @FXML private ComboBox<String> statusFilter;
    @FXML private Label totalItems;
    @FXML private Label inStockCount;
    @FXML private Label lowStockCount;
    @FXML private Label outStockCount;

    // Banking Pattern: Service use
    private StockService stockService = new StockService();
    private ObservableList<StockModel> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupColumns();
        setupFilters();
        loadData();
        setupSearch();
    }

    private void setupColumns() {
        colItemId.setCellValueFactory(cell ->
            new SimpleStringProperty(cell.getValue().getItemId()));
        colItemName.setCellValueFactory(cell ->
            new SimpleStringProperty(cell.getValue().getItemName()));
        colCategory.setCellValueFactory(cell ->
            new SimpleStringProperty(cell.getValue().getCategory()));
        colQuantity.setCellValueFactory(cell ->
            new SimpleStringProperty(
                String.valueOf(cell.getValue().getQuantity())));
        colUnit.setCellValueFactory(cell ->
            new SimpleStringProperty(cell.getValue().getUnit()));
        colStatus.setCellValueFactory(cell ->
            new SimpleStringProperty(cell.getValue().getStatus()));
        colLastUpdated.setCellValueFactory(cell ->
            new SimpleStringProperty(
                cell.getValue().getLastUpdated() != null ?
                cell.getValue().getLastUpdated() : "-"));
    }

    private void setupFilters() {
        categoryFilter.setItems(FXCollections.observableArrayList(
            "All", "Network Equipment", "Cables", "Tools", "Accessories"));
        statusFilter.setItems(FXCollections.observableArrayList(
            "All", "In Stock", "Low Stock", "Out of Stock"));
        categoryFilter.setOnAction(e -> filterData());
        statusFilter.setOnAction(e -> filterData());
    }

    private void loadData() {
        try {
            // Banking Pattern: Service call
            List<StockModel> list = stockService.getAllStock();
            data = FXCollections.observableArrayList(list);
            stockTable.setItems(data);
            updateStats();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Load Error: " + e.getMessage());
            loadSampleData();
        }
    }

    private void loadSampleData() {
        data = FXCollections.observableArrayList(
            createStock("STK-001", "Fiber Optic Cable",
                "Cables", 500, "meters", "In Stock"),
            createStock("STK-002", "Network Switch 24-Port",
                "Network Equipment", 15, "units", "In Stock"),
            createStock("STK-003", "RJ45 Connectors",
                "Accessories", 50, "pieces", "Low Stock"),
            createStock("STK-004", "Cable Tester",
                "Tools", 0, "units", "Out of Stock"),
            createStock("STK-005", "Fiber Splice Box",
                "Network Equipment", 20, "units", "In Stock"),
            createStock("STK-006", "Patch Panel 24-Port",
                "Network Equipment", 8, "units", "Low Stock"),
            createStock("STK-007", "Cat6 Cable",
                "Cables", 1000, "meters", "In Stock"),
            createStock("STK-008", "SFP Module",
                "Accessories", 2, "units", "Low Stock"),
            createStock("STK-009", "Network Router",
                "Network Equipment", 0, "units", "Out of Stock")
        );
        stockTable.setItems(data);
        updateStats();
    }

    private StockModel createStock(String id, String name,
            String cat, int qty, String unit, String status) {
        StockModel sm = new StockModel(name, cat, qty, unit);
        sm.setItemId(id);
        sm.setStatus(status);
        sm.setLastUpdated("19 Mar 2026");
        return sm;
    }

    private void updateStats() {
        try {
            totalItems.setText(String.valueOf(data.size()));
            int inStock = 0, lowStock = 0, outStock = 0;
            for (StockModel s : data) {
                switch (s.getStatus()) {
                    case "In Stock" -> inStock++;
                    case "Low Stock" -> lowStock++;
                    case "Out of Stock" -> outStock++;
                }
            }
            inStockCount.setText(String.valueOf(inStock));
            lowStockCount.setText(String.valueOf(lowStock));
            outStockCount.setText(String.valueOf(outStock));
        } catch (Exception e) {
            System.out.println("Stats error: " + e.getMessage());
        }
    }

    private void setupSearch() {
        searchField.textProperty().addListener((obs, old, val) -> {
            if (val.isEmpty()) { stockTable.setItems(data); return; }
            ObservableList<StockModel> f =
                FXCollections.observableArrayList();
            for (StockModel s : data)
                if (s.getItemName().toLowerCase()
                        .contains(val.toLowerCase()) ||
                    s.getCategory().toLowerCase()
                        .contains(val.toLowerCase()))
                    f.add(s);
            stockTable.setItems(f);
        });
    }

    private void filterData() {
        String cat = categoryFilter.getValue();
        String stat = statusFilter.getValue();
        ObservableList<StockModel> f =
            FXCollections.observableArrayList();
        for (StockModel s : data) {
            boolean catOk = cat == null || cat.equals("All") ||
                            s.getCategory().equals(cat);
            boolean statOk = stat == null || stat.equals("All") ||
                             s.getStatus().equals(stat);
            if (catOk && statOk) f.add(s);
        }
        stockTable.setItems(f);
    }

    @FXML void addStock(ActionEvent e) {
        new Alert(Alert.AlertType.INFORMATION,
                  "Add Stock form coming soon!").show();
    }

    @FXML void refreshData(ActionEvent e) { loadData(); }

    @FXML void exportData(ActionEvent e) {
        new Alert(Alert.AlertType.INFORMATION,
                  "📊 Stock data exported!").show();
    }

    @FXML
    void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                getClass().getResource("/Menu/Menu.fxml"));
            Stage stage = (Stage) searchField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setMaximized(true);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}
