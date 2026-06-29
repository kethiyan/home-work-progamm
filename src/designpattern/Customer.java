package designpattern;




public class Customer implements Observer
{
    private String name;
    public Customer(String name){
        this.name=name;
    }
    
    @Override
    public void update(String status){
       
        switch(status){
        case "Ordered":
            System.out.println(name+" : Order placed successfull");
            break;
            
        case "Packed":
            System.out.println(name+" : order paked");
            break;
            
        case "Shipped":
            System.out.println(name+" : order shipped");
            
        case "Delivered":
            System.out.println(name+" : order delivered");
    }
    }

}