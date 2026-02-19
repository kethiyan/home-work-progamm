
package supermarket;

import java.util.Scanner;

public class ShoppingCart {

    private String cartOwnerName;

    
    public ShoppingCart(String cartOwnerName) 
    {
        this.cartOwnerName = cartOwnerName;
    }

    
    class Item 
    {

        private String itemName;
        private double price;
        private int quantity;
        private double[] priceHistory;

       
        public void addItem(String itemName, int quantity, double[] priceHistory) {

            this.itemName = itemName;
            this.quantity = quantity;
            this.priceHistory = priceHistory;

           
            for (int i = 0; i < priceHistory.length; i++) 
            {
                price = priceHistory[i];
            }
        }

        
        public double calculateTotal() 
        {
            return price * quantity;
        }

        public void display()
        {

            System.out.println("Cart Owner: " + cartOwnerName);
            System.out.println("Item Name: " + itemName);
            System.out.println("Quantity: " + quantity);

            System.out.print("Price History: ");
            for (int i = 0; i < priceHistory.length; i++) {
                System.out.print((int)priceHistory[i] + " ");
            }

            System.out.println("\nLatest Price: " + (int)price);
            System.out.println("Total Bill: " + (int)calculateTotal());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Cart Owner Name: ");
        String owner = sc.nextLine();

        ShoppingCart cart = new ShoppingCart(owner);
        ShoppingCart.Item item = cart.new Item();

        int choice;

        do {
            System.out.println("1. Add Item");
            System.out.println("2. Calculate Total Bill");
            System.out.println("3. Display Cart Details");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    System.out.print("Enter Number of Price Updates: ");
                    int n = sc.nextInt();

                    double[] prices = new double[n];

                    System.out.println("Enter Prices:");
                    for (int i = 0; i < n; i++) {
                        prices[i] = sc.nextDouble();
                    }

                    item.addItem(name, qty, prices);
                    break;

                case 2:
                    System.out.println("Total Bill: " + (int)item.calculateTotal());
                    break;

                case 3:
                    item.display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
