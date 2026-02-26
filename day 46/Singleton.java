
package singleton;

public class Singleton 
{

    
    public static void main(String[] args) 
  {
  {


        PrinterManager p1 = PrinterManager.getInstance();
        PrinterManager p2 = PrinterManager.getInstance();

        p1.print();
      

        
        System.out.println(p1);
}
}
}
    
