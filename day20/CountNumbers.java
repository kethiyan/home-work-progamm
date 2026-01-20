import java.util.Scanner;

public class CountNumbers {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[] a = new int[10];
        int ch;

        do {
            System.out.println("\n1.Enter Numbers");
            System.out.println("2.Display Numbers");
            System.out.println("3.Count Positive");
            System.out.println("4.Count Negative");
            System.out.println("5.Count Zero");
            System.out.println("6.Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1: input(a); break;
                case 2: display(a); break;
                case 3: positive(a); break;
                case 4: negative(a); break;
                case 5: zero(a); break;
                case 6: System.out.println("Exit"); break;
                default: System.out.println("Invalid choice");
            }

        } while (ch != 6);
    }

     void input(int[] a) {
        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < a.length; i++)
            a[i] = sc.nextInt();
    }

    void display(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

     void positive(int[] a) {
        int c = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] > 0) c++;
        System.out.println("Positive count: " + c);
    }

     void negative(int[] a) {
        int c = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] < 0) c++;
        System.out.println("Negative count: " + c);
    }

     void zero(int[] a) {
        int c = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] == 0) c++;
        System.out.println("Zero count: " + c);
    }
}
