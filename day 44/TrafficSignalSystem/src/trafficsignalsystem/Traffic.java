
package trafficsignalsystem;


public class Traffic 
{
    public static void showMeaning(Signal s) 
    {

        if (s == Signal.RED)
            System.out.println("Stop");

        else if (s == Signal.YELLOW)
            System.out.println("Get Ready");

        else if (s == Signal.GREEN)
            System.out.println("Go");
    }

    public static void checkAction(Signal s) 
    {

        if (s == Signal.RED)
            System.out.println("STOP");

        else if (s == Signal.GREEN)
            System.out.println("GO");

        else
            System.out.println("WAIT");
    }
}
