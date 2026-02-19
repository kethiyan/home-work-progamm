class Pyramid {
    public static void main(String[] args) {

        int n = 4; 

        
        for (int i = 0; i <= n; i++) {

            
            for (int s = n; s > i; s--) {
                System.out.print(" ");
            }

            
            for (int j = 0; j < (2 * i + 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        
        for (int i = n - 1; i >= 0; i--) {

            
            for (int s = n; s > i; s--) {
                System.out.print(" ");
            }

            
            for (int j = 0; j < (2 * i + 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
