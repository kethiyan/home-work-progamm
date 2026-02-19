import java.util.Scanner;

class TrafficLigth
{
	public static void main(String[] args){
		
		Scanner sc=new Scanner(System.in);
		
		 String singal=sc.nextLine(); 
		switch(singal){
			
			case "Red"->System.out.println("stop");
			
			case "Yellow"->System.out.println("Waiting");
			
			case "Green"->System.out.println("Go");
			
			default -> System.out.println("Invalid input! ");
		}
	}
}
			