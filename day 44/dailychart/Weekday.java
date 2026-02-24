
package dailychart;

public class Weekday 
{

    public static void checkWorkingDay(Day d) {

        if (d == Day.SATURDAY || d == Day.SUNDAY)
            System.out.println("It is Weekend");
        else
            System.out.println("It is Working Day");
    }

    public static void checkWeekend(Day d) {

        if (d == Day.SATURDAY || d == Day.SUNDAY)
            System.out.println("It is Weekend");
        else
            System.out.println("It is Working Day");
    }

    public static void displayAllDays() {

        for (Day d : Day.values()) {
            System.out.println(d);
        }
    }
}