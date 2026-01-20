class Palindrome
{
	public static void main(String[] args)
	{
		int a=1331;
		int temp=a;
		int rem=0;
		int sum=0;
		
		while(temp>0)
		{
			rem=temp%10;
			sum=rem+(sum*10);
			temp=temp/10;
		}
		if (a==sum)
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("not Palindrome");
		}
	}
}