package spaceremovefile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Spaceremovefile 
{

    public static void main(String[] args) throws IOException 
    {
        try {
             Scanner sc = new Scanner(new File("D:\\git work\\input.txt"));
            FileWriter fw = new FileWriter("output.txt");

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                line = line.trim().replaceAll("\\s+", " ");
                fw.write(line + "\n");
            }

            sc.close();
            fw.close();

            System.out.println("Extra spaces removed!");
        } catch (FileNotFoundException ex) {
                        System.out.println("Error occurred!");

        }
    }
    
}