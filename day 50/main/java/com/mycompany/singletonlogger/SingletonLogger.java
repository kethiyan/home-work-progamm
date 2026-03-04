

package com.mycompany.singletonlogger;


public class SingletonLogger {

    public static void main(String[] args) 
    {
        
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Are both instances same? " + (logger1 == logger2));

        logger1.log("First message");
        logger2.log("Second message");
    }
}
