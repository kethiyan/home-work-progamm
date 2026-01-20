import java.util.Scanner;

class Citizen
{
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		
		int a=sc.nextInt();
		
		if(a >= 60){
			
			System.out.println("Senior citizen");
		}
		else
		{
			System.out.println("Not a senior citizen");
		}
	}
}