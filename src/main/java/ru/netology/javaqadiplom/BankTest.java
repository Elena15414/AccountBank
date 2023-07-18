package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BankTest {
    // @Test

    //    public void testTransferAccountFromAccountTo() {
//        Bank account = new Bank();
//
//        //int expected = 2000;
//        boolean actual = account.transfer(2000);
//
//        Assertions.assertTrue(actual);
//    }
    @Test
    public void testPayTrue() {
        Bank account = new Bank(
                1000,
                10
        );

        boolean actual = account.pay(500);

        Assertions.assertTrue(actual);
    }

    @Test
    public void testPayFalse() {
        Bank account = new Bank(
                1000,
                10
        );

        boolean actual = account.pay(-10);

        Assertions.assertFalse(actual);
    }

    @Test
    public void testPayZero() {
        Bank account = new Bank(
                1000,
                10
        );

        boolean actual = account.pay(0);

        Assertions.assertFalse(actual);
    }

    @Test
    public void testPay() {  //тест на выполнение условия from = balance - amount
        Bank account = new Bank(
                1000,
                10
        );

        account.pay(1000);

        Assertions.assertEquals(0, account.getFrom());
    }

    @Test
    public void testAddZero() {
        Bank account = new Bank(
                1000,
                10
        );

        boolean actual = account.add(0);

        Assertions.assertFalse(actual);
    }

    @Test
    public void testAddFalse() {
        Bank account = new Bank(
                1000,
                10
        );

        boolean actual = account.add(-10);

        Assertions.assertFalse(actual);
    }

    @Test
    public void testAddTrue() {
        Bank account = new Bank(
                1000,
                10
        );

        boolean actual = account.add(500);

        Assertions.assertTrue(actual);
    }

    @Test
    public void testAdd() {  //тест на выполнение условия to = balance + amount
        Bank account = new Bank(
                1000,
                10
        );

        account.add(1000);

        Assertions.assertEquals(2000, account.getTo());
    }



}
