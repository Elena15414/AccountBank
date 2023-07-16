package ru.netology.javaqadiplom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BankTest {
    @Test

    public void testTransferAccountFromAccountTo() {
        Bank account = new Bank();


 //int expected = 2000;
boolean actual = account.transfer(2000);


        Assertions.assertTrue(actual);
    }



}
