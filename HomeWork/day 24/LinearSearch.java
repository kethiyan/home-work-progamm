import java.util.Scanner;
class LinearSearch{
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the Element length : ");
		int length=sc.nextInt();
		
        int[] arr = new int[length];
		for(int i=0;i<length;i++){
		System.out.print("Enter the arr value  : ");
			arr[i]=sc.nextInt();
		}
		
		System.out.print("Enter the Search value  : ");
        int searchvalue = sc.nextInt();
		
		LinearSearch obj=new LinearSearch();
		
		int index = obj.LinearsearchSearch(arr,searchvalue);
		
		if(index!=-1){
        System.out.println(index);}
		
		
	}
	public int linearsearch(int[] arr, int searchvalue)
	{
		for(int i=0;i<arr.length;i++){
			if(arr[i]==searchvalue){
				return i;
			}
			
		}return -1;
	}
	
	
}