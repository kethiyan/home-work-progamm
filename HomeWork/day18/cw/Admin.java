import java.util.Scanner;
class Admin
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		
		String username[]=new String[6];
		String password[]=new String[6];
		
		int count=0;
		int choice;
		
		do{
			System.out.println("welecome to the menu");
			System.out.println("1.Registration");
			System.out.println("2.Login");
			System.out.println("3.Exit");
			
			choice=sc.nextInt();
			
			switch(choice){
				
				case 1: 
				if (count<username.length)
				{
					
					System.out.println("Enter the username :");
					username[count]=sc1.nextLine();
					System.out.println("Enter the password :");
					password[count]=sc.nextLine();
					
					count++;
					
					System.out.println("Registration successful");
					
					}else{
						System.out.println("user full limit ");
					}
				break;
				case 2:
				     if(count<username.length)
					 {
						 System.out.print("enter the username : ");
						 String user =sc1.nextLine();
						 System.out.print("enter the password : ");
						 String pass=sc.nextLine();
						 boolean a=false;
						 for(int i=0;i<count;i++){
						 if(user.equals(username[i]))
						 {
							 if(pass.equals(password[i]))
							 {
								System.out.print("login successful"); 
								a=true;	
								
							 }
						else	{
								System.out.print("password incorrect"); 
						}							 
						 
							
						 } 
							 }
						if(a==false)
						{
								System.out.print("username not found"); 
							
						}
					 }
						break;
				case 3:
				{System.out.println("Exit");}
				break;
				
				default:
				     System.out.print("invalid choice");
				
				
				
				
				
				
			}
			
			
			
			
			
			
			
			
		} while(choice !=3);
		
		
		
		
		
		
		
	}
		
	
	
	
	
	
	
	
	
	
}
