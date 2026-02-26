
package demo1;


public class Hero 
{
    private static Hero Vijya;
    
    private Hero()
    {
        System.out.println("Thala\n  Thalapathy");
    
    }
    public static Hero Title()
    {
        if(Vijya == null)
        {
            Vijya=new Hero();
       }
         return Vijya;
    }
    
    
}
