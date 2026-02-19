import java.util.Scanner;

class PrimeNumber
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		int a=sc.nextInt();
		
		if((a==2)||(a==3)||(a==5)||(a==7)){
		System.out.println(a+"is a prime number");}
		
		else if(a <= 1 ||a% 2 == 0 ||a % 3 == 0 ||a % 5 ==0||a% 7 == 0){
		System.out.println(a+"is a not prime number");}
			else{
				System.out.println(a+"is a prime number");
			}
		
		}
	}

			
			