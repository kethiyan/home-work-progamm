
package vehicle.management.system;

public class car 
{
    String Brand;
    int Year;
    int Seats;
    
    public car(String Brand,int Year,int Seats)
    {
        this.Brand=Brand;
        this.Year=Year;
        this.Seats=Seats;
    
    }
    void dispaly()
    {
        System.out.println("Brand :"+Brand);
        System.out.println("Year :"+Year);
        System.out.println("Seats :"+Seats);
    
    }
    
}
