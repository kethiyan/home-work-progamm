
package trappingrainwater;


import java.util.Scanner;

public class TrappingRainWater{

public static int trap(int[] heigth)
{
	
	int water=0;
	
	for(int i=1;i<heigth.length-1;i++)
	{
		int leftmax=0;
		int rigthmax=0;
		
		for(int j=1;j>=0;j--){
		if(heigth[j]>leftmax)
		{
			leftmax=heigth[j];
		}
		}
		
		for(int j=i;j<heigth.length;j++){
			
			if(heigth[j]>rigthmax){
				rigthmax=heigth[j];
			}
		}
		int min;
		if(leftmax<rigthmax){
			min=leftmax;
			
		}
		else{
			min=rigthmax;
		}
		water=water +(min-heigth[i]);
	}
	return water;
}
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter array size: ");

        int n = sc.nextInt();

        int[] arr = new int[n];


        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();
        }


        int result = trap(arr);


        System.out.println("Trapped Water = " + result);


}

}