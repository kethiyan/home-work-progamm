import java.util.Scanner;

class KnowLedge
{
	public static void main(String[] agrs)
	
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("THE WORLD OF KNOWLEDGE");
		System.out.println("WE WELCOME YOU");
        System.out.println("SELECT YOUR OPTION");
		System.out.println("1.FICTION");
		System.out.println("2.FANTASY");
		System.out.println("3.BUSINESS");
		System.out.println("4.PSYCHOLOGY");
		System.out.print("choose your book: ");
		
		
		int collection=sc.nextInt();
		 
		 if (collection==1){
			 System.out.println("FICTION");
			 System.out.println("1. Rise of The Fallen");
			 System.out.println("2. Shadows Rising");
			 System.out.println("3. Kunex,it Ends with us");
			 System.out.println("choose your book: ");
			 
			 int book=sc.nextInt();
			 
			 if(book==1)
			 {
				 System.out.println("RISE OF THE FALLEN: The Manwaan Series Book 1");                        
				 System.out.println("Author: Abhishek Krishnan ");
				 System.out.println("Language: English");
				 System.out.println("Rate: Rs.300");
				 }
			else if(book==2)	 
			{
				System.out.println("Shadows Rising");
				System.out.println("Author:Rohan Monteiro");
				System.out.println("Language: English");
				System.out.println("Rate: Rs.300");
				
			}
			 else if(book==3){
				System.out.println("Kunex, It Ends with Us ");
				System.out.println("Author:Rohan Monteiro");
				System.out.println("Language: English");
				System.out.println("Rate: Rs.350");
				 }
	 }
	
		    if (collection==2){
			 System.out.println("FANTASY");
			 System.out.println("1. Compass and Blade");
			 System.out.println("2. Blood metal Bone");
			 System.out.println("3. The shadows between us");
			 System.out.println("choose your book: ");
			 
			 int book=sc.nextInt();
			 
	        if(book==1){
			     System.out.println("Compass and Blade");                        
				 System.out.println("Author: Rachel Greenlaw ");
				 System.out.println("Language: English");
				 System.out.println("Rate: Rs.370");
			}
			else if(book==2){
				 System.out.println("Blood metal Bone");                        
				 System.out.println("Author: Lindsay cummings ");
				 System.out.println("Language: English");
				 System.out.println("Rate: Rs.275");
			}
			else if(book==3){
				System.out.println("The Shadows between us");                        
				 System.out.println("Author: Tricia Leven-seller ");
				 System.out.println("Language: English");
				 System.out.println("Rate: Rs.304");
			}
			}
			 if (collection==3){
			 System.out.println("BUSINESS");
			 System.out.println("1. The Psychology of money");
			 System.out.println("2. Do it Today");
			 System.out.println("3. Atomic Habits");
			 System.out.println("choose your book: ");
			 
			 int book=sc.nextInt();
			 
	        if(book==1){
			     System.out.println("The Psychology of Money ");                        
				 System.out.println("Author: Morgan Housel ");
				 System.out.println("Language: English");
				 System.out.println("Rate: Rs.300");
			}
			else if(book==2){
				 System.out.println("Do It Today ");                        
				 System.out.println("Author: Darius Foroux ");
				 System.out.println("Language: English");
				 System.out.println("Rate: Rs.100");
			}
			else if(book==3){
				 System.out.println("Atomic Habits ");                        
				 System.out.println("Author: James Clear ");
				 System.out.println("Language: English");
				 System.out.println("Rate: Rs.350");
			}
			}
			if (collection==4){
			 System.out.println(" PSYCHOLOGY ");
			 System.out.println("1. Dark Psychology Secrets & Manipulation");
			 System.out.println("2. The Power of Your Subconscious Mind Do It Today ");
			 System.out.println("3. The Courage to Be Disliked  ");
			 System.out.println("choose your book: ");
			 
			 int book=sc.nextInt();
			 
	        if(book==1){
			     System.out.println("Dark Psychology Secrets & Manipulation");                        
				 System.out.println("Author: Amy Brown   ");
				 System.out.println("Language: English");
				 System.out.println("Rate: Rs.300");
			}
			else if(book==2){
				 System.out.println(" The Power of Your Subconscious Mind Do It Today ");                        
				 System.out.println("Author:  Joseph Murphy ");
				 System.out.println("Language: English");
				 System.out.println("Rate: Rs.350");
			}
			else if(book==3){
				 System.out.println(" The Courage to Be Disliked  ");                        
				 System.out.println("Author:  Ichiro Kishimi and Fumitake Koga ");
				 System.out.println("Language: English");
				 System.out.println("Rate: Rs.350");
			}
			}
			else{
				System.out.println("Thank you for visit");
			}
	
	
	
	
	
	
	
	}
	
	
}