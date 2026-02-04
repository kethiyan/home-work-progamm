
package area.of.different.shapes;


import java.util.Scanner;

public class AreaOfDifferentShape 
{

    static Scanner sc = new Scanner(System.in);

    static void circleArea() {
        System.out.print("Enter radius: ");
        Shape c = new circle(sc.nextDouble());
        c.calculateArea();
    }

    static void squareArea() {
        System.out.print("Enter side: ");
        Shape s = new Square(sc.nextDouble());
        s.calculateArea();
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- Shape Area Calculator ---");
            System.out.println("1. Circle");
            System.out.println("2. Square");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    circleArea();
                    break;
                case 2: 
                    squareArea();
                    break;
                case 3:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 3);
    }
}
