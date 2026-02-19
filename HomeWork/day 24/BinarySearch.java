
import java.util.Scanner;
public class BinarySearch {
    
    public static void main(String[] args)
    {
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
        
        BinarySearch ob = new BinarySearch();
        int index = ob.binarySearch(arr, searchvalue);
        System.out.println(index);
    }
    
    public int binarySearch(int[] arr, int searchvalue)
    {
        int left = 0;
        int right = arr.length-1;
        int mid = (left + right)/2;
        
        while(left <= right)
        {
            if(searchvalue == arr[mid])
            {
                return mid;
            } else if(searchvalue > arr[mid])
            {
                left = mid+1;
            } else if(searchvalue < arr[mid])
            {
                right = mid-1;
            }
            mid = (left + right)/2;
        }
        return -1;
    }
}