
package student.managementsystem;

import java.util.Scanner;


public class Main
{

   
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in); 
       Scanner sc1=new Scanner(System.in); 
       
       StudentManager manager=new StudentManager();
       
       int choice=0;
       
       
       do
       {
           
           System.out.println("1.ADD STUDENT ");
           System.out.println("2.REMOVE STUDENT");
           System.out.println("3.SEARCH STUDENT");
           System.out.println("4.DISPALY ALL STUDENT");
           System.out.println("5.DISPALY TOTAL STUDENT COUNT");
           System.out.println("6.EXIT");
           System.out.print("ENTER THE CHOICE : ");
           
            choice=sc.nextInt();
            
            switch(choice){
            
                case 1:
                       System.out.print("Enter The Student Id :");
                       int id=sc.nextInt();
                    
                       System.out.print("Enter The Student Name :");
                       String name=sc1.nextLine();
                       manager.addStudent(id, name);
                       break;
                case 2:
                       System.out.print("Enter The StudentId To Remove : ");
                       manager.removeStudent(sc.nextInt());
                       break;
                case 3: 
                       System.out.print("Enter The StudentId To Search : ");
                       manager.searchStudent(sc.nextInt());
                       break;
                case 4:
                       manager.displayAllStudents();
                       break;
                case 5:
                       manager.displayTotalCount();
                       break;
                    
                case 6:
                       System.out.println("******Exit*******");
                       break;
            }
             }while(choice!=6);
       
        
        
    
    
       }
}
