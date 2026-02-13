
package wordcounter;


import java.util.Scanner;

public class WordCounter
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String str=sc.nextLine();

        int charCount=0;
        int vowelCount=0;

        String words[]=str.split(" ");
        int wordCount=words.length;

        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);

            if(ch!=' ')
                charCount++;

            if("aeiouAEIOU".indexOf(ch)!=-1)
                vowelCount++;
        }

        System.out.println("Characters (without space): "+charCount);
        System.out.println("Words: "+wordCount);
        System.out.println("Vowels: "+vowelCount);
    }
}

