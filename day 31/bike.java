
package vehicle.management.system;


public class bike extends car
{
    String type;
    public bike(String Brand, int Year,int Seats ,String type ) 
    {
        super(Brand, Year,Seats);
        this.type=type;
        
    }
    void display()
    {
        System.out.println(super.Brand);
        System.out.println(super.Year);
        System.out.println(super.Seats);
        System.out.println("TYPE :"+type);
    
    }
}
