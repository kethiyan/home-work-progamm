import java.util.Scanner;

class Swap {

    int a, b;

    void swap(Swap s) {
        int t = s.a;
        s.a = s.b;
        s.b = t;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Swap s = new Swap();

        System.out.print("Enter a: ");
        s.a = sc.nextInt();

        System.out.print("Enter b: ");
        s.b = sc.nextInt();

        s.swap(s);

        System.out.println("a = " + s.a + " b = " + s.b);
    }
}
