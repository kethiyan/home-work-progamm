package bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ExceptionTest {

    @Test
    void withdrawExceptionTest() {

        BankAccount acc = new BankAccount(1000);

        assertThrows(IllegalArgumentException.class, () -> {
            acc.withdraw(2000);
        });
    }
}