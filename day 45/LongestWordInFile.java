package longestwordinfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LongestWordInFile {

    public static void main(String[] args) {

        String longestWord = "";
        File fi = new File("D:\\git work\\LongestWord.txt");
        try (Scanner sc = new Scanner(fi)) {
            if (fi.createNewFile()) {
                System.out.println("file is created");
                return;
            }
            FileWriter fw = new FileWriter(fi);
            fw.write("May be Im not wrong !");
            
            
            while (sc.hasNext()) {
                String word = sc.next();

                word = word.replaceAll("[^a-zA-Z]", "");

                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file.");
        }catch (IOException ex) {
            System.getLogger(LongestWordInFile.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        if (longestWord.isEmpty()) {
            System.out.println("No words found in file.");
        } else {
            System.out.println("Longest word: " + longestWord);
            System.out.println("Length: " + longestWord.length());
        }
    }
}