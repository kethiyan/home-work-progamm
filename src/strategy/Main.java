package strategy;




public class Main {
    public static void main(String[] args) {
        
        PaymentContext payment = new PaymentContext();
        
        payment.setStrategy(new UpiPayment());
        payment.makePayment(9090);
        
        System.out.println();
        
        payment.setStrategy(new CreditCard());
        payment.makePayment(2500);

        System.out.println();

        payment.setStrategy(new NetBanking());
        payment.makePayment(3500);
    }
}