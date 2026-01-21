import java.util.Scanner;
class EmployeeId
{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		int empId[]=new int[10];
		int count=0;
		int choice;
		
		do{
			System.out.println("menu");
			System.out.println("1. Add employee Id");
			System.out.println("2. Remove employee Id");
			System.out.println("3. Display employee Id");
			System.out.println("4. Exit");
			System.out.print("Enter your Choice: ");
			choice=sc.nextInt();
			
			switch(choice){
				
				case 1:
				      System.out.print("Enter employee Id: ");
				      empId[count]=sc.nextInt();
					  
					  count++;
				      System.out.print("Enter employee Id added ");
				      break;
					  
				case 2:
				      System.out.print("Enter employee Id  to remove: ");
					int id=sc.nextInt();
					int pos =-1;
					
					for(int i=0;i<count;i++){
						if(empId[i]==id){
							pos=i;
							break;
						}
					}
					if(pos!=-1){
						for (int i=pos;i<count-1;i++)
							empId[i]=empId[i+1];
						count--;
						System.out.println("remove employee id");
						}
				else{
						System.out.println("remove employee id not found");
					}
					break;
				case 3:
						for(int i=0;i<count;i++)
							System.out.println(empId[i]);
						break;
						
				case 4:
					  System.out.println("Exit");
			}
			
		}while(choice!=4);
		
	}
	
}