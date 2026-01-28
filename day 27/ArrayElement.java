import java.util.Scanner;

public class ArrayElement{
	public static void main(String[] ars){
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the no of Element length : ");
		int length=sc.nextInt();
		
		int[] arr=new int[length];
		int choice;
		
		do{
			System.out.println("1.Accept arrays");
			System.out.println("2.Display arrays");
			System.out.println("3.Sort arrays");
			System.out.println("4.Search element");
			System.out.println("5.Exit");
			
			 choice=sc.nextInt();
			
			switch(choice){
			
			case 1:
			       System.out.println("Enter the Array element : ");
				   for(int i=0;i<arr.length;i++){
				    arr[i]=sc.nextInt();
				   }
				   break;
			case 2:
                  for(int i=0;i<arr.length;i++)	{
					  
					  System.out.println(arr[i] + " ");
				  }		
			      break;
				  
			case 3:
                  for(int i=0;i<arr.length-1;i++)	{
					for(int j=0;j<arr.length-1;j++)	{
						if(arr[j]> arr[j+1]){
							int temp=arr[j];
							arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
				  }}}
				  break;
			case 4:
                    System.out.println("1. Linear Search");
                    System.out.println("2. Binary Search");
                    System.out.print("Enter choice: ");	
					
					int ch=sc.nextInt();
					
                    System.out.println("Enter the search Element : ");
					int searchvalue=sc.nextInt();
					
					if(ch==1)
					{
						for(int i=0;i<arr.length;i++){
							if(arr[i]==searchvalue){
                    System.out.print("Search value found index"+ i);	
								
							}break;
						}
						
					}
					else if(ch==2){
						for(int i=0;i<arr.length-1;i++){
							if (arr[i]> arr[i + 1]){
								int left = 0;
								int right = arr.length-1;
								int mid = (left + right)/2;
        
									while(left <= right)
									{
										if(searchvalue == arr[mid])
										{
											System.out.println("Element found at index");
										} else if(searchvalue > arr[mid])
										{
											left = mid+1;
										} else if(searchvalue < arr[mid])
										{
											right = mid-1;
										}
										mid = (left + right)/2;
										System.out.println("Search Value found" + mid);
									}
									
							}
						}
						
						
					}break;
				case 5:
						System.out.println("Exit");
					
			break;
			}
			
		}while(choice!=5);
	}
}