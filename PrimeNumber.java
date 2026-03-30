
package primeornot;

import java.util.Scanner;


public class PrimeNumber 
{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number");
        int num = sc.nextInt();
        boolean isPrime = true;
        for(int i = 2; i <= num/2; i++) {

            if(num % i == 0) {
                isPrime = false;
                break;
            }
        }
         if(isPrime && num > 1)
            System.out.println(num+" Prime Number");
        else
            System.out.println(num+" Not Prime Number");

    }
}
