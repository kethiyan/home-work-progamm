package strategy;




public class CreditCard implements PaymentStrategy
{

    @Override
    public void pay(double amount) {
        System.out.println("Credit card payment successfull");
        System.out.println("Amount paid "+amount);
    }
    

}