

package randomgame;

import java.util.Random;
import java.util.Scanner;


public class RandomGame 
{

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        Random ra=new Random();
        
        int choice;
        int bot;
        
        System.out.println("1.Rock");
        System.out.println("2.Paper");
        System.out.println("3.Scissors");
        
        System.out.print("Enter Your Choice : ");
        choice=sc.nextInt();
        
        bot=ra.nextInt(3)+1;
        System.out.println("Computer choice: " + bot);
        
        if(choice==bot)
        {
            System.out.println("Draw The Macth");
        }
        else if(choice==1 && bot==3) 
        {
            System.out.println("You Win");
        }
        else if(choice==2 && bot==1)
        {
            System.out.println("You win");
        }
        else if(choice==3 && bot==2)
        {
            System.out.println("You Win");
        }
        else{
            System.out.println("Your lose ");
        }
        




    }

}
