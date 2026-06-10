import java.lang.reflect.Field;

class Product {
    String name = "Laptop";
    int price = 50000;
}

public class ReflectionDemo {

   
    public static Object readProperty(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        Object value = field.get(obj);
        System.out.println("Read Operation -> " + fieldName + ": " + value);
        return value;
    }

    
    public static void writeProperty(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.set(obj, value);
        System.out.println("Write Operation -> " + fieldName + ": " + value);
    }

    public static void main(String[] args) {
        try {
            Product product = new Product();

           
            readProperty(product, "name");
            readProperty(product, "price");

            
            writeProperty(product, "price", 55000);

            
            readProperty(product, "price");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}