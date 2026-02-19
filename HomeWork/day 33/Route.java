package transport.management;
import java.util.Scanner;

public class Route 
{
    static void selectRoute(Scanner sc,Transport t)
    {
        System.out.println("Select the Route");
        System.out.println("1. Chennai -> Bangalore");
        System.out.println("2. Chennai -> Coimbatore");
        System.out.println("3. Chennai -> Madurai");
        System.out.println("4. Chennai -> Trichy");
        System.out.println("5. Chennai -> Salem");

        int ro=sc.nextInt();

        switch(ro)
        {
            case 1: t.toCity="Bangalore"; t.distance=350; break;
            case 2: t.toCity="Coimbatore"; t.distance=500; break;
            case 3: t.toCity="Madurai"; t.distance=460; break;
            case 4: t.toCity="Trichy"; t.distance=330; break;
            case 5: t.toCity="Salem"; t.distance=340; break;
            default: System.out.println("Invalid Route");
        }
    }
}
