import java.util.Scanner;

class Month
{
	public static void main(String[] agrs)
	{
		Scanner sc=new Scanner(System.in);
		
		int a=sc.nextInt();
		
		switch(a)
		{
			case 1: {
				System.out.println("january ");
			    System.out.println("31 days");}
			break;
			case 2:{
				System.out.println("february");
				System.out.println("28 or 29 days ");
			}
			break;
			case 3:{
				System.out.println("march");
				System.out.println("31 days");
			}
			break;
			case 4:{
					System.out.println("april");
					System.out.println("30 days");
				}
			break;
			case 5:{
					System.out.println("may");
					System.out.println("31 days");
				}
			break;
			case 6:{
					System.out.println("june");
					System.out.println("30 days");
				}
			break;
			case 7:{
					System.out.println("july");
				System.out.println("31 days");
				}
			break;
			case 8:{
					System.out.println("august");
					System.out.println("31 days");
				}
			break;
			case 9:{System.out.println("september");
			        System.out.println("30 days");
			}
			break;
			case 10:{System.out.println("october");
			         System.out.println("31 days");
			}
			break;
			case 11:{System.out.println("november");
			         System.out.println("30 days");
			}
			break;
			case 12:{System.out.println("december");
			         System.out.println("31 days");
			}
			default:
			        System.out.println("invalid months");
		}
	}
}

					
					