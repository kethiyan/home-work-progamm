
package singleton;


public class PrinterManager
{
    
    private static PrinterManager instance;

    
    private PrinterManager() {
        System.out.println("Printer Created");
    }

  
    public static PrinterManager getInstance() {
        if (instance == null) {
            instance = new PrinterManager();
        }
        return instance;
    }

   
    public void print() {
        System.out.println("Printing document...");
    
}
}