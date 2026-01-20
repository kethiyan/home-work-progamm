import java.util.Scanner;

public class LargerNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		

        if (a > b) {
            System.out.println(a+" is the larger number");
        } else {
            System.out.println(b+" is the larger number");
        }
    }
}
