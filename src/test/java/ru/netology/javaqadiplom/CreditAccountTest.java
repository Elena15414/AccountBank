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
    @Test
    public void shouldTestPayBalanceNegative() {
        CreditAccount account = new CreditAccount(
                -5,
                5_000,
                15
        );

        boolean actual = account.pay(-50);

        Assertions.assertFalse(actual);
        Assertions.assertEquals(-5, account.getBalance());
    }
    @Test
    public void shouldTestAddTrue() {
        CreditAccount account = new CreditAccount(
                5,
                5_000,
                15
        );

        boolean actual = account.add(50);

        Assertions.assertTrue(actual);
        Assertions.assertEquals(55, account.getBalance());
    }
    @Test
    public void shouldTestAddFalseZero() {
        CreditAccount account = new CreditAccount(
                5,
                5_000,
                15
        );

        boolean actual = account.add(0);

        Assertions.assertFalse(actual);
        Assertions.assertEquals(5, account.getBalance());
    }
    @Test
    public void shouldTestAddFalseNegative() {
        CreditAccount account = new CreditAccount(
                5,
                5_000,
                15
        );

        boolean actual = account.add(-5);

        Assertions.assertFalse(actual);
        Assertions.assertEquals(5, account.getBalance());
    }
    @Test
    public void shouldTestYearChange() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }
    @Test
    public void shouldTestYearChange2() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }
    @Test
    public void shouldTestGetCreditLimit() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(5000, account.getCreditLimit());
    }
}
