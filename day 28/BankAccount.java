  import java.util.Scanner;
  
  class BankAccount
  {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAcc ac = new BankAcc();
		

            int choice = sc.nextInt();
         do{

            switch (choice) {
                case 1:
                    int d = sc.nextInt();
                    ac.deposit(d);
                    break;

                case 2:
                    int w = sc.nextInt();
                    ac.withdraw(w);
                    break;

                case 3:
                    ac.displayBalance();
                    break;

                case 4:
                    System.out.print("Exit");
                    break;
            }
        }while(choice!=4);
    }
}