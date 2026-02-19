import java.util.Scanner;
class Library
{
	public static void main(String[] args){
		
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		
		System.out.print("Enter the total no of  add book : ");
		
		int no_book = sc.nextInt();
		
		String book_name[]=new String [no_book];
		
		int count=0;
		int chioce=0;
		do
		{
			System.out.println("welcome to library ");
			System.out.println("1:add book name");
			System.out.println("2:see list book");
			System.out.println("3:Eixt");
			System.out.println("Enter your chioce: ");
			chioce=sc.nextInt();
			switch(chioce){
						case 1:
				if(count<book_name.length){
					System.out.print("Enter book Name: ");
					
					book_name[count]=sc1.nextLine();
					
					count++;
					System.out.println("book name added Successfully.");
				}
				else{
					System.out.println("book list is full");
				}
				break;
				case 2:
					System.out.println("book name: ");
					
					for(int i=0;i<count;i++){
						System.out.println(book_name [i]);
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
	
	
	
	
	
	
