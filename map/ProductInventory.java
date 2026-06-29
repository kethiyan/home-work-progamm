import java.util.HashMap;
import java.util.Map;

public class ProductInventory {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();

        inventory.put("Apple", 50);
        inventory.put("Banana", 120);

        String searchKey = "Apple";
        if(inventory.containsKey(searchKey)) {
            System.out.println(searchKey + " Stock: " + inventory.get(searchKey));
        }

        inventory.put("Apple", 75); 

        inventory.remove("Banana");

        System.out.println("Current Inventory: " + inventory);
    }
}