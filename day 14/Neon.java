class Neon
{
	public static void main(String[] args)
	{
		int a=9;
		int square=a*a;
		int rem=0;
		int sum=0;
		
		while (square>0)
		{
			rem=square%10;
			sum=sum+rem;
			square=square/10;
		}
		if (a==sum)
		{
			System.out.println("Neon");
		}
		else
		{
			System.out.println("not Neon");
		}
	}
}