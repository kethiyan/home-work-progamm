package fibernet.model;


public class StockModel {

    private int id;
    private String itemId;
    private String itemName;
    private String category;
    private int quantity;
    private String unit;
    private String status;
    private String lastUpdated;

  
    public StockModel() {}

    
    public StockModel(String itemName, String category,
                      int quantity, String unit) {
        this.itemName = itemName;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
    }

    
    public int getId() { return id; }
    public String getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public String getQuantityStr() { return String.valueOf(quantity); }
    public String getUnit() { return unit; }
    public String getStatus() { return status; }
    public String getLastUpdated() { return lastUpdated; }

    
    public void setId(int id) { this.id = id; }
    public void setItemId(String i) { this.itemId = i; }
    public void setItemName(String n) { this.itemName = n; }
    public void setCategory(String c) { this.category = c; }
    public void setQuantity(int q) { this.quantity = q; }
    public void setUnit(String u) { this.unit = u; }
    public void setStatus(String s) { this.status = s; }
    public void setLastUpdated(String l) { this.lastUpdated = l; }
}
