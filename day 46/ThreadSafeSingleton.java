
package threadsafesingleton;


public class ThreadSafeSingleton {

    
    public static void main(String[] args) 
    {
        Runnable task1=()->
        {
            MessageLogger ml = MessageLogger.getInstance();
            MessageLogger ml1 = MessageLogger.getInstance();
           
        };
        
        Runnable task2=()->{
            MessageLogger ml2=MessageLogger.getInstance();
        };
        Thread t1=new Thread(task1);
        Thread t2=new Thread(task2);
        
        
        t1.start();
        t2.start();
    }
    
}
