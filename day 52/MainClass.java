package stringoperations;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringOperations obj = new StringOperations();

        int choice;

        do {

            System.out.println("\n--- STRING OPERATIONS MENU ---");
            System.out.println("1. Find Length");
            System.out.println("2. Reverse String");
            System.out.println("3. Convert to Uppercase");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter String: ");
            String str = sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Length = " + obj.findLength(str));
                    break;

                case 2:
                    System.out.println("Reverse = " + obj.reverseString(str));
                    break;

                case 3:
                    System.out.println("Uppercase = " + obj.toUpper(str));
                    break;

                case 4:
                    System.out.println("Program Ended");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);

    }
}