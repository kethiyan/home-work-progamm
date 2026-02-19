import java.util.Scanner;
class Load
{
	public static void main(String[] args)
	{ Scanner sc=new Scanner (System.in);
	
	 int a =sc.nextInt ();
	 int b =sc.nextInt ();
	 
	 if ((a > 21)&&(b > 25000)){
		 
		 System.out.println("eligible for a load");
	 }
	 else
	 {
		 System.out.println("not eligible for a load");
	 }
	}
}