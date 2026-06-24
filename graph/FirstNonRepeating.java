import java.util.*;

public class FirstNonRepeating{

    public static void main(String[] args) {

        String str = "aabbcde";

        Map<Character,Integer> map = new LinkedHashMap<>();

        for(char ch : str.toCharArray())
            map.put(ch, map.getOrDefault(ch,0)+1);

        for(Map.Entry<Character,Integer> e : map.entrySet()) {

            if(e.getValue()==1) {
                System.out.println(e.getKey());
                break;
            }
        }
    }
}