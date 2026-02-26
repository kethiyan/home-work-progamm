
package uppercase;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Uppercase {
    public static void main(String[] args) {

        try {
            File inputFile = new File("D:\\git work\\input.txt");
            if(inputFile.createNewFile()){
                System.out.println("file is created");
            }
            Scanner sc = new Scanner(inputFile);

            FileWriter fw = new FileWriter("output.txt");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                fw.write(line.toUpperCase() + "\n");
            }

            sc.close();
            fw.close();

            System.out.println("Converted to uppercase successfully!");

        } catch (IOException e) 
        {
            System.out.println("Error occurred!");
        }
    }}