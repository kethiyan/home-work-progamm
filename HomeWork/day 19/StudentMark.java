import java.util.Scanner;
class StudentMark
{
	
	int TOTAL(int subj1,int subj2,int subj3)
	{
		int Total=subj1+subj2+subj3;
		return Total;
	}
	float PERCENTAGE(int subj1,int subj2,int subj3)
	{
		float Percentage=(subj1+subj2+subj3)/3.0f;
		return Percentage;
	}
	boolean RESULT(int subj1,int subj2,int subj3)
	{
		boolean Result=((subj1+subj2+subj3)/3>=45);
	
	return Result;
	}
	char GRADE(int subj1,int subj2,int subj3)
	{
		 char Grade;
		 if((subj1+subj2+subj3)/3>=75)
			 Grade='A';
		 else if((subj1+subj2+subj3)/3>=60)
			 Grade='B';
		 else if((subj1+subj2+subj3)/3>=59)
			 Grade='C';
		 else
			 Grade='D';
		 return Grade;
		 
	}
     public static void main(String[] args)
	 {
		 
         Scanner sc=new Scanner(System.in);
		  System.out.println ("Enter the subj1 mark :");
		 int subj1=sc.nextInt(); 
		 System.out.println ("Enter the subj2 mark :");
		 int subj2=sc.nextInt(); 
		 System.out.println ("Enter the subj3 mark :");
		 int subj3=sc.nextInt();
		 
		 int a;
		 
		 do{
			 StudentMark sm=new StudentMark();
		
			 System.out.println ("1 for total");
		  System.out.println ("2 for percentage");
		  System.out.println ("3 for result");
		  System.out.println ("4 for grade");
		  System.out.println ("5 for exit");
		  System.out.println ("Enter ur choices");
	
		     a = sc.nextInt();
		  
		   switch (a)
		   {
			   
			 case 1->System.out.println("TOTAL MARK : "+sm.TOTAL(subj1,subj2,subj3));  
			 case 2->System.out.println("PERCENTAGE  : "+sm.PERCENTAGE(subj1,subj2,subj3));  
			 case 3->System.out.println("RESULT : "+sm.RESULT(subj1,subj2,subj3));  
			 case 4->System.out.println("GRADE : "+sm.GRADE(subj1,subj2,subj3));  
			 case 5->System.out.println("Exit");  
			   
			   
			   
			   
			   
		   }
			 
			 
		 }while(a!=5);
		 
		 
		 
	 }









	
}