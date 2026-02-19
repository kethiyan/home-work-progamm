class StudentMark
{
	public static void main(String[] args)
	{
		int mark = 25;
		
		if((mark>=90)&&(mark<=100))
		{
			System.out.println("A Grade");
		}
		else if((mark>=70)&&(mark<90))
		{
			System.out.println("B Grade");		
		}
		else if((mark>50)&&(mark<70))
		{
			System.out.println("C Grade");		
		}
		else if((mark>=25)&&(mark>=50))
		{
			System.out.println("d Grade");		
		}
		else
		{
			System.out.println("fail");		
		}
	}
}