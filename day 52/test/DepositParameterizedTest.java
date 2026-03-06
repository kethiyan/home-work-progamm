package bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DepositParameterizedTest {

    @ParameterizedTest
    @ValueSource(doubles = {100,200,300})
    void testDeposit(double amount) {

        BankAccount acc = new BankAccount(1000);

        acc.deposit(amount);

        assertTrue(acc.checkBalance() > 1000);
    }
}