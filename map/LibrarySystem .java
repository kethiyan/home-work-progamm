import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    public static void main(String[] args) 
	{
		
		
        Map<Integer, String> library = new HashMap<>();

        library.put(101, "Java Complete Reference");
        library.put(102, "Head First Java");

        System.out.println("Book ID 101: " + library.get(101));

        library.put(101, "Java Core - Advanced Edition");

        library.remove(102);

        library.forEach((id, title) -> System.out.println("ID: " + id + " -> Title: " + title));
    }
}