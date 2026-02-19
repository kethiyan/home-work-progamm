import java.util.Scanner;

class Vowel
{
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		
		char data=sc.next().charAt(0);
		
		
		switch(data){
			
			case 'a'->System.out.println("vowels");
			
			case 'e'->System.out.println("vowels");
			
			case 'i'->System.out.println("vowels");
			
			case 'o'->System.out.println("vowels");
			
			case 'u'->System.out.println("vowels");
			
			case 'A'->System.out.println("vowels");
			
			case 'E'->System.out.println("vowels");
			
			case 'I'->System.out.println("vowels");
			
			case 'O'->System.out.println("vowels");
			
			case 'U'->System.out.println("vowels");
			
			 default -> System.out.println("consonant");
		}
	}
}