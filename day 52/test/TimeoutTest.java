package bank;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

public class TimeoutTest {

    @Test
    void timeoutTest() {

        BankAccount acc = new BankAccount(1000);

        assertTimeout(Duration.ofSeconds(2), () -> {

            acc.deposit(200);
            acc.withdraw(100);

        });
    }
}