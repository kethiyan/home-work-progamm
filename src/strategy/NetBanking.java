package strategy;




public class NetBanking implements PaymentStrategy
{

    @Override
    public void pay(double amount) {
        
        System.out.println("Net Banking Payment successfull");
        System.out.println("Amount Paid "+amount);
    }

}