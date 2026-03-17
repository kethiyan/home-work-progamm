import java.util.Scanner;

public class CharacterFrequency
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        char arr[] = str.toCharArray();

        for(int i = 0; i < arr.length; i++)
        {
            int count = 1;

            if(arr[i] == '0')
                continue;

            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[i] == arr[j])
                {
                    count++;
                    arr[j] = '0';
                }
            }

            System.out.println(arr[i] + " : " + count);
        }
    }
}