
package transport.management;
import java.util.Scanner;
        
        
public class TransportManagement 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);

        Transport t=null;
        int choice;

        do
        {
            System.out.println("\n---- TRANSPORT MANAGEMENT SYSTEM ----");
            System.out.println("1. City Bus Booking");
            System.out.println("2. Luxury Bus Booking");
            System.out.println("3. Calculate Fare");
            System.out.println("4. Display Ticket");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice=sc.nextInt();

            switch(choice)
            {
                case 1:
                    t=new CityBus();
                    System.out.print("Enter Passenger ID: ");
                    t.passengerId=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Passenger Name: ");
                    t.passengerName=sc.nextLine();

                    Route.selectRoute(sc,t);
                    t.fromCity="Chennai";

                    System.out.println("City Bus Ticket Booked");
                    break;

                case 2:
                    t=new LuxuryBus();
                    System.out.print("Enter Passenger ID: ");
                    t.passengerId=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Passenger Name: ");
                    t.passengerName=sc.nextLine();

                    Route.selectRoute(sc,t);
                    t.fromCity="Chennai";

                    System.out.println("Luxury Bus Ticket Booked");
                    break;

                case 3:
                    if(t!=null)
                    {
                        t.calculateFare();
                        System.out.println("Fare Calculated Successfully");
                    }
                    else
                        System.out.println("No Booking Found");
                    break;

                case 4:
                    if(t!=null)
                        t.display();
                    else
                        System.out.println("No Ticket Available");
                    break;

                case 5:
                    System.out.println("Program Ended");
                    break;
            }

        }while(choice!=5);
    }
}
                    
                    
                    
                    
              
                    
                
           

