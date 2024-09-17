package org.delta.print;

import org.delta.accounts.BankAccount;

public class AccountDetailPrinter {
    public void printDetail(BankAccount account) {
        System.out.println("Bank account balance: " + account);
    }

    public void printDetail(BankAccount account, double fee) {
        System.out.println("Bank account balance: " + account + ", Fee: " + fee);
    }

}
