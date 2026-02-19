
package shoppingcart;


public class Product 
{
      int productId;
    String productName;
    double price;
    Product next;

    public Product(int productId, String productName, double price) 
    {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.next = null;
}
}