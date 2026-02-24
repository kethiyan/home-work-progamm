
package dailychart;



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Check Working Day");
            System.out.println("2. Check Weekend");
            System.out.println("3. Display All Days");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Day: ");
                    Day d1 = Day.valueOf(sc.next().toUpperCase());
                    Weekday.checkWorkingDay(d1);
                    break;

                case 2:
                    System.out.print("Enter Day: ");
                    Day d2 = Day.valueOf(sc.next().toUpperCase());
                    Weekday.checkWeekend(d2);
                    break;

                case 3:
                    Weekday.displayAllDays();
                    break;

                case 4:
                    System.out.println("Program Ended");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}