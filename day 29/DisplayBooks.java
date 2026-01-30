import java.util.Scanner;
class DisplayBooks
{
	Scanner sc = new Scanner(System.in);
	
	
	void displayBooks(SetLibraryArrays sla)
	{
		if(sla.bookID==null)
		{
		System.out.println("NO BOOKS TO SHOW ");
			return;
		}
		
		for (int i = 0 ; i < sla.index; i++)
		{
			
			
			System.out.println("BOOK TITLE : "+" "+sla.title[i]);
			System.out.println("BOOK ID : "+" "+sla.bookID[i]);
			System.out.println("BOOK AUTHOR : "+" "+sla.author[i]);
			System.out.println("BOOK AVAILABILITY : "+" "+sla.isAvailable[i]);
			System.out.println("-------------------------------------- ");
			
			
		}
		
	}
