
package filehandling;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandling{

    public static void main(String[] args) {

        try {
            File fi = new File("D:\\numbers.txt");
            FileWriter fw = new FileWriter(fi);
            fw.write("10\n");
            fw.write("100\n");
            fw.write("105\n");
            fw.write("1076\n");
            fw.close();
            
            Scanner sc = new Scanner(fi);

            int sum=0;

            while (sc.hasNextInt()) {
                sum += sc.nextInt();
            }

            System.out.println("Sum = " + sum);  
            sc.close();   

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
  