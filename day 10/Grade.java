import java.util.Scanner;

class Grade
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		char data=sc.next().charAt(0);
		switch(data){
			
			case 'A'->System.out.println("Excellent");
			
			case 'B'->System.out.println("Good");
			
			case 'C'->System.out.println("Average");
			
			case 'D'->System.out.println("Below Average");
			
			case 'F'->System.out.println("Fail");
			
			 default -> System.out.println("Invalid input! ");
		}
	}
}