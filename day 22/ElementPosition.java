import java.util.Scanner;
class ElementPosition
{
	public static void main (String[] agrs){
		Scanner sc=new Scanner(System.in);
	
	int a[]={5,10,20,30,40,50,25,3};
	
	for(int i=1;i<=5;i++)
	{
		System.out.print(a[i]+" ");
	}	
	
	
	int arr[]=new int[arr.length+1];
	int index=sc.nextInt();
	System.out.print("Enter the index: ");
	int value=sc.nextInt();
	System.out.print("Enter the value: " );
	
	
	for(int i=0;i<value;i++)
	{
		new arr[i]=arr[i];
	}
	a[index-1]=value;
	
	for(int i=0;i<=arr.length;i++){
	System.out.print(" "+a[i] );
		
	}
	}
	
}