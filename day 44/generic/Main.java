
package generic;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Box<Integer> intBox = new Box<>();
        Box<String> strBox = new Box<>();

        int choice;

        do {
            System.out.println("\n1. Store Integer");
            System.out.println("2. Store String");
            System.out.println("3. Display Value");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Integer: ");
                    int num = sc.nextInt();
                    intBox.setValue(num);
                    break;

                case 2:
                    System.out.print("Enter String: ");
                    sc.nextLine(); // clear buffer
                    String text = sc.nextLine();
                    strBox.setValue(text);
                    break;

                case 3:
                    System.out.println("Stored Integer: " + intBox.getValue());
                    System.out.println("Stored String: " + strBox.getValue());
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
