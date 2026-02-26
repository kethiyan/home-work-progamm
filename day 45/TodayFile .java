package todayfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class TodayFile {

    public static void main(String[] args) 
    {
        File fi = new File("Today.txt");
        
        try {
            if(fi.createNewFile()){
                System.out.println("file is created");
            FileWriter writer = new FileWriter(fi);

            LocalDate today = LocalDate.now();
            writer.write("Today's Date: " + today);

            }
        } catch (IOException ex) {
            System.out.println("Ordinary one");
        }
    }
    
}