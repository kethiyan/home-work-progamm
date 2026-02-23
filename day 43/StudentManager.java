
package student.managementsystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class StudentManager

{
    
     Set<Integer>studentIds=new HashSet<>();
     
     
   
    private Map<Integer, String>studentMap = new HashMap<>();


    
    public void addStudent(int id, String name) {

        if (studentIds.contains(id)) {
            System.out.println("Student ID already exists. Duplicate not allowed.");
            return;
        }

        studentIds.add(id);
        studentMap.put(id, name);

        System.out.println("Student added successfully.");
    }


    
    public void removeStudent(int id) {

        if (!studentIds.contains(id)) {
            System.out.println("Student ID not found.");
            return;
        }

        studentIds.remove(id);
        studentMap.remove(id);

        System.out.println("Student removed successfully.");
    }


    
    public void searchStudent(int id) {

        if (!studentMap.containsKey(id)) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Student Name: " + studentMap.get(id));
    }


    
    public void displayAllStudents() {

        if (studentMap.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("---- Student List ----");

        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() +" | Name: " + entry.getValue());
        }
    }


    
    public void displayTotalCount() {
        System.out.println("Total Students: " + studentIds.size());
    }
    
    
}
 