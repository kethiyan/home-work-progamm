import java.util.Scanner;
class SetLibraryArrays
{
	
	Scanner sc = new Scanner(System.in);
	
	int bookID[];
	String title [];
	String author[];
	int length;
	int index = 0;
	boolean isAvailable[] ; 
	
	void setLibraryArrays ()
	{
		System.out.println("ENTER THE LENGTH");
		length=sc.nextInt();
		title=new String [length];
		author=new String [length];
		bookID=new int [length];
		isAvailable = new boolean [length];
	}