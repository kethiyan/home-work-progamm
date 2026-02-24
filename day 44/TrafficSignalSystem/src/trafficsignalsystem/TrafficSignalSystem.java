
package trafficsignalsystem;

import java.util.Scanner;




public class TrafficSignalSystem
{

    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int choice;
       
       do{
           System.out.println("-----Traffic Signal System----");
           System.out.println("1.Show Singal Meaning");
           System.out.println("2.check stop or go");
           System.out.println("3.Exit");
           System.out.print("Enter the choice : ");
           choice=sc.nextInt();
           
           switch(choice)
           {
               case 1:
                   System.out.print("Enter Singal(Red,Yellow,Green) : ");
                   Signal s1=Signal.valueOf(sc.next().toUpperCase());
                    Traffic.showMeaning(s1);
                    break;
               case 2:
                     System.out.print("Enter Signal (RED, YELLOW, GREEN): ");
                     Signal s2 = Signal.valueOf(sc.next().toUpperCase());
                     Traffic.checkAction(s2);
                     break;
               case 3:
                     System.out.println("Eixt");
                     break;
           
           
           }
               
       
       
       }while(choice!=3);
       
       
        
        
        
    }
    
    
}
