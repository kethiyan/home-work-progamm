
package threadsafesingleton;


public class MessageLogger
{
     private static MessageLogger instance;

    private MessageLogger() {
        System.out.println("Logger Created");
    }

    
    public static synchronized MessageLogger getInstance() {
        if (instance == null) {
            instance = new MessageLogger();
        }
        return instance;
    }

    
}
