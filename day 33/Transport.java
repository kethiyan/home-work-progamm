
package transport.management;
abstract class Transport
{
   int passengerId;
   String passengerName;
   String fromCity;
   String toCity;
   int distance;
   double fare;

   abstract void calculateFare();

   void display()
   {
       System.out.println("\n----- TICKET DETAILS -----");
       System.out.println("PassengerID : "+passengerId);
       System.out.println("Passenger Name : "+passengerName);
       System.out.println("From City : "+fromCity);
       System.out.println("To City : "+toCity);
       System.out.println("Distance : "+distance);
       System.out.println("Fare : "+fare);
   }
}

