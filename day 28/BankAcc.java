class BankAcc
{
	
	 int  balance=1000;
	 
	 
	 void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Amount deposited Balance = " + balance);
    }

    void withdraw(int amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount withdrawn Balance = " + balance);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void displayBalance() {
        System.out.println("Balance = " + balance);
    }

	
	
	
}

