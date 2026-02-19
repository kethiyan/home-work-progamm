import java.util.Scanner ;
class ReturnBooks
{
	Scanner sc = new Scanner(System.in);
	ReturnBooks (SetLibraryArrays sla)
	{
		
		System.out.println("ENTER THE BOOK ID TO BE RETURNED");
		int returnBookID =sc.nextInt();
		
		for(int i = 0 ; i<=sla.index ; i++)
		{
			
			if(sla.bookID[i]==returnBookID)
			{
				
				sla.isAvailable[i]=true ;
				System.out.println("THANKS FOR RETURNING THE BOOK");
				return;
				
			}
			
			
			
			
			
		}
		
		System.out.println("ENTERED BOOK ID NOT FOUND , KINDLY CHECK THE ID ONCE AGAIN");
		
	}
	
	