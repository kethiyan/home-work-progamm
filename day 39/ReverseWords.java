
package reversewords;

 import java.util.Scanner;

public class ReverseWords
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String str=sc.nextLine();

        String words[]=str.split(" ");

        for(int i=0;i<words.length;i++)
        {
            StringBuilder sb=new StringBuilder(words[i]);
            System.out.print(sb.reverse()+" ");
        }
    }
}


  
