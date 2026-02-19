package shoppingcart;

public class ShoppingCart 
{
    Product head;

    
    void addProduct(int id, String name, double price)
    {
        Product newProduct = new Product(id, name, price);

        if(head == null)
        {
            head = newProduct;
        }
        else
        {
            Product temp = head;

            while(temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newProduct;
        }

        System.out.println("Product Added Successfully");
    }

    
    void viewCart()
    {
        if(head == null)
        {
            System.out.println("Cart is Empty");
            return;
        }

        Product temp = head;

        System.out.println("Cart Items:");
        while(temp != null)
        {
            System.out.println("ID: "+temp.productId);
            System.out.println(" Name: "+temp.productName);  
            System.out.println(" Price: "+temp.price);            
            

            temp = temp.next;
        }
    }
}
