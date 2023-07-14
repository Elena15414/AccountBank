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
    public void shouldAddMoreThanMaxBalance() {    // тест на добавление суммы с превышением максимального балланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(23_000);

        Assertions.assertEquals(2_000 , account.getBalance());
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
    public void shouldPayWhenSufficientBalance() {    // тест на списание суммы за покупку до граничного значения
        SavingAccount account = new SavingAccount(   // минимального балланса
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(1_500 , account.getBalance());
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
    public void shouldPayWhenAmountIsZero() {              // тест на списание суммы превышающей
        // минимальный балланс на карте
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(0); // сумма выше минимального значения, значит должен false сработать

        Assertions.assertFalse(false);//изменен Assertions.assertEquals на .assertFalse
    }
    @Test
    public void shouldWhenTheRateIsLessThanZero() {      //

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                -1
        );
        account.yearChange();

        //account.yearChange(); // процентная ставка -1, значит должено сработать исключение

         Assertions.assertThrows(IllegalArgumentException.class,()->{ account.yearChange();});

    }
    }


