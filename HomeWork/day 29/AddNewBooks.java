import java.util.Scanner;
class AddNewBooks
{
	Scanner sc = new Scanner(System.in);
	
    AddNewBooks(SetLibraryArrays sla)
	{
		if(sla.bookID==null)
		{
		System.out.println("SET THE LENGTH FIRST ");
			return;
		}
		
		if(sla.index>=sla.length)
		{
		System.out.println("LIBRARY IS FULL ");
			return;
		}
		
		
		System.out.println("ENTER THE BOOK TITLE");
		sla.title[sla.index] = sc.nextLine();
		
		
		System.out.println("ENTER THE BOOK ID");
		sla.bookID[sla.index] = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("ENTER THE BOOK AUTHOR");
		sla.author[sla.index] = sc.nextLine();
		
		sla.isAvailable[sla.index]=true ;
		
		sla.index++;
		System.out.println("BOOK ADDED SUCCESSFULLY");
		
	}
