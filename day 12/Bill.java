import java.util.Scanner;
class Bill
{
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		
		int unit=sc.nextInt();

         int bill;
		 
		 if (unit<=100){
			 bill=unit*5;
		 }
		 else if(unit<=200){
			 bill=unit* 7;
		 }
		else{
			bill=unit*10;
		}
		System.out.println("eletricity bill: " + bill);
		
		
	}
}
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
