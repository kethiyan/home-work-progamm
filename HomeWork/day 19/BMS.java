import java.util.Scanner;

class BMS
{
	double accountBalance = 0.0;
	
	public static void main(String[] args)
	{
		BMS bms = new BMS();
		bms.mainMenu();
		
	}
	
	void mainMenu()
	{
		int option = 0;
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("******** MAIN MENU **********");
			System.out.println("1. Deposit");
			System.out.println("2. Withdrawal");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");	
			System.out.println("Enter your option: ");
			option = sc.nextInt();
			
			switch(option)
			{
				case 1:
				{
					System.out.println("Enter your deposit amount: ");
					double depositAmount = sc.nextDouble();
					deposit(depositAmount);
					break;
				}
				case 2:
				{
					System.out.println("Enter your withdrawal amount: ");
					double wa = sc.nextDouble();
					withdrawal(wa);
					break;
				}
				case 3:
				{
					checkBalance();
					break;
				}
				case 4:
				{
					System.out.println("Exit");
				}
				default:
				{
					System.out.println("Please enter valid option..");
				}
			}
			
		}while(option!=4);
	}
	
	void deposit(double depositAmt)
	{
		accountBalance += depositAmt;
	}
	
	void withdrawal(double withdrawalAmt)
	{
		if(accountBalance>=withdrawalAmt)
		{
			accountBalance -= withdrawalAmt;
		} else {
			System.out.println("vaaaipu illa raja.....");
		}
	}
	
	void checkBalance()
	{
		System.out.println(accountBalance);
	}
}