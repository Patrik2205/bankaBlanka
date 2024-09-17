package org.delta.accounts;

import org.delta.persons.Owner;

public class BankAccount {
    private double balance;

    private Owner owner;

    private String accountNumber;

    public BankAccount(double balance, Owner owner, String accountNumber) {
        this.balance = balance;
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    public void setBalance(double amount) {
        balance = amount;
    }

    private void subMoney(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
