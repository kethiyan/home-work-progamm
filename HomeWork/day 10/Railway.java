import java.util.Scanner;

class Railway
{
	public static void main(String[] agrs)
	{
		Scanner sc=new Scanner(System.in);
		
		int seat=sc.nextInt();
		switch(seat){
			
			case 1->System.out.println("General");
			
			case 2->System.out.println("Sleeper");
			
			case 3->System.out.println("Ac 3tier");
			
			case 4->System.out.println("Ac 2tier");
			
			case 5->System.out.println("First class");
			
			default -> System.out.println("Invalid input! ");
		}
	}
}
		