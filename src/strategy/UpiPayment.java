package strategy;




public class UpiPayment implements PaymentStrategy
{

    @Override
    public void pay(double amount) {
        System.out.println("UPI Payment successfull");
        System.out.println("Amount pid "+amount);
    }
    

}