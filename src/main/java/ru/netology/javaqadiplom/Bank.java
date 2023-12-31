package ru.netology.javaqadiplom;

public class Bank extends Account {

    protected int from;
    protected int to;

    public Bank(int initialBalance, int rate) {
        if (rate <= 0) {
            throw new IllegalArgumentException(
                    "Накопительная ставка не может быть отрицательной, а у вас: " + rate
            );
        }
        this.balance = initialBalance;
        this.rate = rate;
    }

    /**
     * Операция перевода указанной суммы с одного счёта на другой.
     * Если операция прошла успешно, то баланс счёта from должен
     * уменьшиться на эту сумму, а баланс счёта to увеличиться.
     * Если операция прошла неуспешно, балансы обоих счетов никак
     * измениться не должны.
     *
     * @param from   - счёт с которого переводим
     * @param to     - счёт на который переводим
     * @param amount - сумма перевода
     * @return - true если операция прошла успешно, false иначе
     */

    public boolean transfer(Account from, Account to, int amount) {
        if (amount <= 0) {
            return false;
        }
        if (from.pay(amount)) {
            to.add(amount);
        }
        return true;
    }

    public boolean pay(int amount) {
        if (amount <= 0) {
            return false;
        }
        from = balance - amount;
        return true;
    }

    public boolean add(int amount) {
        if (amount <= 0) {
            return false;
        }
        to = balance + amount;
        return true;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}

