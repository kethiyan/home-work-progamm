import java.util.Scanner;

public class ArrayReverse {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[] arr = new int[5];
        int ch;

        do {
            System.out.println("\n1.Enter Numbers");
            System.out.println("2.Display Numbers");
            System.out.println("3.Display Reverse");
            System.out.println("4.Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {

                case 1:
                    input(arr);
                    break;

                case 2:
                    display(arr);
                    break;

                case 3:
                    reverse(arr);
                    break;

                case 4:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (ch != 4);
    }

     void input(int[] arr) {
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
    }

     void display(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

     void reverse(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
