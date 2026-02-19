class Armstrong
{
	public static void main(String[] args)
	{
		int a = 3258;
		int b = a%100;
		int c = a/100;
		int d = c%100;
		int e = c/100;
		
		int f = (e*e*e*e)+(d*d*d*d)+(b*b*b*b);
		
		boolean g = (a==f);
		System.out.println(g);
	}
}