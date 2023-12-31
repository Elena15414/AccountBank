package ru.netology.javaqadiplom;

public abstract class Account {
    protected int balance;
    protected int rate;

    public boolean pay(int amount) {
        return false;
    }

    public boolean add(int amount) {
        return false;
    }

    public boolean transfer(Account from, Account to, int amount) {
        return true;
    }

    public int yearChange() {
        return 0;
    }

    public int getBalance() {
        return balance;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
