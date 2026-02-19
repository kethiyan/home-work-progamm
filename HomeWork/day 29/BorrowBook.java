import java.util.Scanner;
class BorrowBook
{
	Scanner sc = new Scanner(System.in);
	
	void borrowBooks(SetLibraryArrays sla)
	{
		
		if(sla.bookID==null)
		{
		System.out.println("NO BOOKS TO SHOW ");
			return;
		}
		
		System.out.println("ENTER THE BOOK ID TO BE BORROWED");
		int borrowBookID = sc.nextInt();
		
		searchBorrowBook(0,borrowBookID,sla);
		
		
		
		
		
	}
	
	void searchBorrowBook(int i ,int borrowBookID,SetLibraryArrays sla)
	{
		if(i<sla.index)
		{
			if(borrowBookID==sla.bookID[i])
			{
				if(sla.isAvailable[i])
				{
					
					sla.isAvailable[i]=false ;
			        System.out.println("U R BORROWED A BOOK FROM THE LIBRARY , KINDLY RETURN THE BOOK ASAP");
			        return ;
				}
			    System.out.println("BOOK IS ALREADY BORROWED");
			 
			}searchBorrowBook(++i,borrowBookID,sla);
		}
		else
		{
	    System.out.println("ENTERED BOOK ID NOT FOUND , KINDLY CHECK THE ID ONCE AGAIN");
		}