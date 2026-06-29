import java.util.HashMap;
import java.util.Map;

public class MovieRatings {
    public static void main(String[] args) {
        Map<String, Double> movieMap = new HashMap<>();

        movieMap.put("Inception", 8.8);
        movieMap.put("Interstellar", 8.6);

        System.out.println("Inception Rating: " + movieMap.get("Inception"));

        movieMap.put("Interstellar", 8.9);

        movieMap.remove("Inception");

        for (Map.Entry<String, Double> entry : movieMap.entrySet()) {
            System.out.println("Movie: " + entry.getKey() + ", Rating: " + entry.getValue());
        }
    }
}