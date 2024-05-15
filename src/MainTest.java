import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testDepositAmount() {
        ATMOperations atmOperations = new ATMOperations();
        String input = "10 20 50 .";
        atmOperations.depositAmount( input);
        int expected_10 = 1;
        int expected_20 = 1;
        int expected_50 = 1;
        assertEquals(expected_10, atmOperations.atm.getBalance_10(), "The balance of 10 denomination is incorrect");
        assertEquals(expected_20, atmOperations.atm.getBalance_20(), "The balance of 20 denomination is incorrect");
        assertEquals(expected_50, atmOperations.atm.getBalance_50(), "The balance of 50 denomination is incorrect");
    }

    @Test
    void testWithdrawAmount() {
        ATMOperations atmOperations = new ATMOperations();
        String input = "10 20 50 .";
        atmOperations.depositAmount(input);
        atmOperations.withdrawAmount(30);
        int expected_10 = 0;
        int expected_20 = 0;
        int expected_50 = 1;
        assertEquals(expected_10, atmOperations.atm.getBalance_10(), "The balance of 10 denomination is incorrect");
        assertEquals(expected_20, atmOperations.atm.getBalance_20(), "The balance of 20 denomination is incorrect");
        assertEquals(expected_50, atmOperations.atm.getBalance_50(), "The balance of 50 denomination is incorrect");
    }

    @Test
    void testBalanceAmount() {
        ATMOperations atmOperations = new ATMOperations();
        String input = "10 20 50 .";
        atmOperations.depositAmount(input);
        atmOperations.withdrawAmount(30);
        int expected_balance = 50;
        assertEquals(expected_balance, atmOperations.atm.getBalance(), "The balance of 50 denomination is incorrect");
    }

}