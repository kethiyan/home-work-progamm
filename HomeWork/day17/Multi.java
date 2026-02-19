import java.util.Scanner;
class Multi
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		char a[][]=new char[4][5];
		
		System.out.println("Enter the characters :");
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<5;j++)
			{
				a[i][j]=sc.next().charAt(0);
			}
			
		}
		  System.out.println("index of characters :");
		  
		  for(int i=0;i<4;i++)
		  {
			  for(int j=0;j<5;j++)
			  {
				  System.out.print(a[i][j]+ " ");
			  }
				System.out.println("");  
			  
		  }
		
		
		
		
	}
	
	
}