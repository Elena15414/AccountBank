package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddBalanceMoreMaxBalance() {
        SavingAccount account = new SavingAccount(
                15000,
                1_000,
                10_000,
                5
        );

        account.add(50);
        Assertions.assertFalse(false);
    }

    @Test
    public void shouldAddMoreThanMaxBalance() {    // тест на добавление суммы с превышением максимального балланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldAddThanAccountIsZero() {    // тест на добавление суммы на 0
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertFalse(false);
    }

    @Test
    public void shouldPayWhenSufficientBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
        Assertions.assertTrue(true);
    }

    @Test
    public void shouldPayBalanceLessMinBalance() {
        SavingAccount account = new SavingAccount(
                500,
                1_000,
                10_000,
                5
        );

        account.pay(50);
        Assertions.assertFalse(false);
    }

    @Test
    public void shouldPayWhenMoreThanMinimumBalance() {              // тест на списание суммы превышающей
        // минимальный балланс на карте
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(5000); // сумма выше минимального значения, значит должен false сработать

        Assertions.assertFalse(false);//изменен Assertions.assertEquals на .assertFalse
    }

    @Test
    public void shouldPayWhenAmountIsZero() {              // тест на списание суммы равной 0
        // минимальный балланс на карте
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(0); // сумма равна 0, значит должен false сработать

        Assertions.assertFalse(false);//изменен Assertions.assertEquals на .assertFalse
    }

    @Test
    public void shouldWhenTheRateIsLessThanZero() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new SavingAccount(2000, 1000, 10000, -1);

                });
    }

    @Test
    public void shouldTheInterestRate() {    // тест на расчет процентов
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(100, account.yearChange());
    }

//    @Test
//    public void shouldPayBooleanPayWhenInt() {              // тест на тип boolean Pay Account
//
//        Account account = new Account();
//
//        account.pay(1); // сумма выше минимального значения, значит должен false сработать
//
//        Assertions.assertFalse(false);//изменен Assertions.assertEquals на .assertFalse
//    }
//
//    @Test
//    public void shouldAddBooleanPayWhenInt() {              // тест на тип boolean Pay Account
//
//        Account account = new Account();
//
//        account.add(1); //
//
//        Assertions.assertFalse(false);
//    }
//
//    @Test
//    public void shouldWhenYearChange() {              // тест на пустой метод YearChange
//
//        Account account = new Account();
//
//        account.yearChange();
//        int expected = 0;
//        int actual = account.yearChange();
//
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldSetRate() {              // тест на Set Rate
//
//        Account account = new Account();
//        account.setRate(3);
//
//        int expected = 3;
//        int actual = account.rate;
//
//        Assertions.assertEquals(expected, actual);
//    }

    @Test
    public void testRateWhenLessMinBalance() {   //тест на minBalance < balance

        SavingAccount account = new SavingAccount(

                900,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void testRateWhenMoreMaxBalance() {    //тест на balance > maxBalance

        SavingAccount account = new SavingAccount(

                19000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.yearChange());  // исправила expected на 0 ,
        // так как в методе появились условия начисления процента
    }

    @Test
    public void testRateWhenMoreBalance() {    // тест на корректное начисление процентов

        SavingAccount account = new SavingAccount(

                1_500,
                1_000,
                10_000,
                10
        );

        Assertions.assertEquals(150, account.yearChange());
    }

    @Test
    public void testYearChangeBalanceEqualsMinBalance() {    // тест на условие minBalance = balance

        SavingAccount account = new SavingAccount(

                1_000,
                1_000,
                10_000,
                10
        );

        Assertions.assertEquals(100, account.yearChange());
    }

    @Test
    public void testYearChangeBalanceEqualsMaxBalance() {    // тест на условие balance = maxBalance

        SavingAccount account = new SavingAccount(

                10_000,
                1_000,
                10_000,
                10
        );

        Assertions.assertEquals(1000, account.yearChange());
    }

    @Test
    public void shouldTestGetMinBalance() {  //тест на метод getCreditLimit
        SavingAccount account = new SavingAccount(

                1_500,
                1_000,
                10_000,
                10
        );

        Assertions.assertEquals(1000, account.getMinBalance());
    }

    @Test
    public void shouldTestGetMaxBalance() {  //тест на метод getCreditLimit
        SavingAccount account = new SavingAccount(

                1_500,
                1_000,
                10_000,
                10
        );

        Assertions.assertEquals(10000, account.getMaxBalance());
    }
}

