package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {  // тест на проверку добавления баланса
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldTestPayTrue() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean actual = account.pay(50);

        //Assertions.assertTrue(actual);
        Assertions.assertEquals(-50, account.getBalance());
    }
    @Test
    public void shouldTestPayLessCreditLimit() {
        CreditAccount account = new CreditAccount(
                -6_000,
                5_000,
                15
        );

        boolean actual = account.pay(50);

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldTestPayZero() {   //тест на amount=0
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
    public void shouldTestPayNegative() {   //тест на amount<0
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean actual = account.pay(-50);

        Assertions.assertFalse(actual);
       // Assertions.assertEquals(50, account.getBalance());
    }

    @Test
    public void shouldTestPayBalanceNegative() {   // тест на  balance<-creditLimit
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
    public void shouldTestAddTrue() {   // тест , когда amount >0. Результат должен быть True. balance+amount
        CreditAccount account = new CreditAccount(
                5,
                5_000,
                15
        );

        boolean actual = account.add(50);

        //Assertions.assertTrue(actual); -не нужен
        Assertions.assertEquals(55, account.getBalance());
    }

    @Test
    public void shouldTestAddFalseZero() {  // тест когда amount =0
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
    public void shouldTestAddFalseNegative() {  //  тест , когда amount<0
        CreditAccount account = new CreditAccount(
                5,
                5_000,
                15
        );

        boolean actual = account.add(-5);

        Assertions.assertFalse(actual);
       // Assertions.assertEquals(5, account.getBalance());
    }

    @Test
    public void shouldTestYearChange() {   // тест на первое условие -если на счёте -200 рублей, то при ставке 15% ответ должен быть -30.
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void shouldTestYearChange2() {     // тест на второе условие "если на счёте 200 рублей, то при любой ставке ответ должен быть 0"
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }
    @Test
    public void shouldTestYearChangeBalanceEqualsCreditLimit() {
        CreditAccount account = new CreditAccount(
                -5000,
                5_000,
                15
        );

        Assertions.assertEquals(-750, account.yearChange());
    }
    @Test
    public void shouldTestYearChangeBalanceMoreCreditLimit() {
        CreditAccount account = new CreditAccount(
                -6000,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldTestGetCreditLimit() {  //тест на метод getCreditLimit
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(5000, account.getCreditLimit());
    }

    @Test
    public void shouldWhenTheRateIsLessThanZero() {
       // CreditAccount account = new CreditAccount(
       //         200,
      //          5_000,
       //         -10
       // );

        // процентная ставка -10, значит должено сработать исключение

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(200,5000,-10);
        });

    }
}
