package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }
    @Test
    public void shouldTestPayTrue() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean actual = account.pay(50);

        Assertions.assertTrue(actual);
        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void shouldTestPayZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean actual = account.pay(0);

        Assertions.assertFalse(actual);
        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void shouldTestPayNegative() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean actual = account.pay(-50);

        Assertions.assertFalse(actual);
        Assertions.assertEquals(50, account.getBalance());
    }
}
