import java.util.Scanner;

class Area
{
	public static void main(String[] agrs)
	{
		Scanner sc=new Scanner(System.in);
		
		int a=sc.nextInt();
		switch(a){
			
			case 1->System.out.println("Area of circle=𝜋𝑟2");
			
			case 2->System.out.println("Area of square=a*a");
			
			case 3->System.out.println("Area of rectangle=l*w");
			
			case 4->System.out.println("Area of triangle=1/2bh");
			
			default -> System.out.println("Invalid input! ");
		}
	}
}
		