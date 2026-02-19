
package emailvalidator;

import java.util.Scanner;

public class EmailValidator
{

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Email: ");
        String email=sc.nextLine();

        int at=email.indexOf("@");
        int dot=email.indexOf(".");

        if(at!=-1 && dot!=-1 && at<dot)
            System.out.println("Valid Email");
        else
            System.out.println("Invalid Email");
    }
}
