import java.util.Scanner;
class LibraryManagementMain
{
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		int choice ;
		SetLibraryArrays sla = new SetLibraryArrays ();
		
		do
		{
			
			System.out.println("0 FOR SET LENGTH");
			System.out.println("1 FOR ADD A NEW BOOK");
			System.out.println("2 FOR DISPLAY ALL BOOKS");
			System.out.println("3 FOR BORROW A BOOK");
			System.out.println("4 FOR RETURN A BOOK");
			System.out.println("5 FOR EXIT");
			System.out.println(" ENTER UR CHOICE");
			choice = sc.nextInt();
			
			switch(choice)
			{
				
				case 0 :
				{
					sla.setLibraryArrays();
					break;
				}
				case 1 :
				{
					AddNewBooks anb = new AddNewBooks(sla);
					break;
				}
				case 2 :
				{
					DisplayBooks dpb = new DisplayBooks();
					dpb.displayBooks(sla);
					break;
				}
				case 3 :
				{
					BorrowBook bb = new BorrowBook();
					bb.borrowBooks(sla);
					break;
				}
				case 4 :
				{
					ReturnBooks rb = new ReturnBooks (sla);
					break;
				}
				
				case 5 :
				{
					System.out.println("EXITING , THANKS FOR COMING  ");
				}
				
				
			}
			
			
		}while(choice!=5);
		
	}}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

		   
			
		    
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}