import java.util.Scanner;
class Employee
{
	public static void main(String[] args){
		
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		
		System.out.print("Enter the total no of  employee : ");
		
		int no_employee = sc.nextInt();
		
		String employee_name[]=new String [no_employee];
		
		int count=0;
		int chioce=0;
		do
		{
			System.out.println("welcome to menu ");
			System.out.println("1:add employee name");
			System.out.println("2:see list employee");
			System.out.println("3:Eixt");
			System.out.println("Enter your chioce: ");
			chioce=sc.nextInt();
			switch(chioce){
						case 1:
				if(count<employee_name.length){
					System.out.print("Enter employee Name: ");
					
					employee_name[count]=sc1.nextLine();
					
					count++;
					System.out.println("employee name added Successfully.");
				}
				else{
					System.out.println("employee list is full");
				}
				break;
				case 2:
					System.out.println("employee name: ");
					
					for(int i=0;i<count;i++){
						System.out.println(employee_name [i]);
					}
					break;
					case 3:
					System.out.println("Exit");
					break;
					
					default:
					System.out.println("invalid chioce");
				
				
				
				
			}	
			}while(chioce != 3);
			
			
			
			
			
			
			
		}
		
		
		
	}
	
	
	
	
	
	
