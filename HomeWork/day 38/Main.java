import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        MobileLinkedList list = new MobileLinkedList();

        int choice;

        do
        {
            System.out.println("\n===== Mobile Shop Menu =====");
            System.out.println("1. Add Latest Launch");
            System.out.println("2. Add Regular Stock");
            System.out.println("3. Display Mobiles");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                {
                    System.out.print("Enter Mobile ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Brand Name: ");
                    String brand = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    list.insertAtHead(id, brand, price);
                    break;
                }

                case 2:
                {
                    System.out.print("Enter Mobile ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Brand Name: ");
                    String brand = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    list.insertAtTail(id, brand, price);
                    break;
                }

                case 3:
                    list.display();
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 4);

        sc.close();
    }
}
