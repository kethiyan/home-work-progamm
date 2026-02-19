
package institution;


import java.util.Scanner;

public class Institution 
{

    private String institutionName;

   
    public Institution(String institutionName) 
    {
        this.institutionName = institutionName;
    }

    
    class Student 
    {

        private String studentName;
        private int rollNo;
        private int[] marks;
        private double average;
        private String grade;

        
        public void addStudent(String name, int roll) 
        {
            this.studentName = name;
            this.rollNo = roll;
        }

        
        public void addMarks(int subjectCount, int[] marksArray)
        {
            this.marks = new int[subjectCount];

            for (int i = 0; i < subjectCount; i++) {
                this.marks[i] = marksArray[i];
            }
        }

        
        public void calculateGrade()
        {

            int total = 0;

            for (int i = 0; i < marks.length; i++)
            {
                total += marks[i];
            }

            average = (double) total / marks.length;

            if (average >= 90) {
                grade = "A";
            } else if (average >= 75) {
                grade = "B";
            } else if (average >= 50) {
                grade = "C";
            } else {
                grade = "Fail";
            }
        }

        
        public void display() 
        {

            System.out.println("Institution Name: " + institutionName);
            System.out.println("Student Name: " + studentName);
            System.out.println("Roll No: " + rollNo);

            System.out.print("Marks: ");
            for (int i = 0; i < marks.length; i++) {
                System.out.print(marks[i] + " ");
            }

            System.out.printf("Average: ", average);
            System.out.println("Grade: " + grade);
        }
    }

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Institution inst = new Institution("ABC Institution");
        Institution.Student student = inst.new Student();

        int choice;

        do {
            System.out.println("1. Add Student");
            System.out.println("2. Add Marks");
            System.out.println("3. Calculate Grade");
            System.out.println("4. Display Student Details");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();

                    student.addStudent(name, roll);
                    break;

                case 2:
                    System.out.print("Enter Number of Subjects: ");
                    int count = sc.nextInt();

                    int[] marksArray = new int[count];

                    System.out.println("Enter Marks:");
                    for (int i = 0; i < count; i++) {
                        marksArray[i] = sc.nextInt();
                    }

                    student.addMarks(count, marksArray);
                    break;

                case 3:
                    student.calculateGrade();
                    System.out.println("Grade Calculated Successfully!");
                    break;

                case 4:
                    student.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        
    }
}

