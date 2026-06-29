
package designpattern;


public class OrderDelivery {

    
    public static void main(String[] args) 
    {
        Order order = new Order();
        
        Customer customer = new Customer("Ak");
        
        order.addObserver(customer);
        order.setStatus("Ordered");
        order.setStatus("Packed");
        order.setStatus("Shipped");
        order.setStatus("Delivered");
    }
    
}
