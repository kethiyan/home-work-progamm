import java.util.Scanner;

class BubbleSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Length of Element : ");
        int length = sc.nextInt();

        int[] arr = new int[length];

        
        for (int i = 0; i < length; i++) {
			
        System.out.print("Enter the no of Array : ");
            arr[i] = sc.nextInt();
        }

        int passes = 0;

     
        for (int i = 0; i < length - 1; i++) {
            passes++;

            for (int j = 0; j < length- i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        
        System.out.println("Sorted Array:");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nNumber of Passes: " + passes);
    }
}
