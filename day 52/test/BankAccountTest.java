package bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    void depositTest() {

        BankAccount acc = new BankAccount(1000);

        acc.deposit(500);

        assertEquals(1500, acc.checkBalance());
    }

    @Test
    void withdrawTest() {

        BankAccount acc = new BankAccount(1000);

        acc.withdraw(400);

        assertEquals(600, acc.checkBalance());
    }

    @Test
    void balanceTest() {

        BankAccount acc = new BankAccount(2000);

        assertEquals(2000, acc.checkBalance());
    }
}