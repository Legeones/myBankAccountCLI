package TD1;

import TD1.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @Test @BeforeEach
    void deposit() {
        BankAccount bc = new BankAccount();
        bc.deposit(1000);
        assertEquals(1000.00, bc.checkBalance());
    }

    @Test @BeforeEach
    void withdraw_checkBalance() {
        BankAccount bc = new BankAccount();
        bc.deposit(1000);
        bc.withdraw(500);
        assertEquals(500.00, bc.checkBalance());
    }
    @Test @BeforeEach
    void withdraw_balance_negate() {
        BankAccount bc = new BankAccount();
        assertThrows(Exception.class, () -> {
            bc.withdraw(bc.checkBalance()+10);
        });
    }

    @Test
    void checkBalance() {
    }
}