package org.delta.accounts;

import org.delta.persons.Owner;

public class StudentBankAccount extends BankAccount {

    private String studentStudyConfigurateLoan;

    public StudentBankAccount(double balance, Owner owner, String accountNumber) {
        super(balance, owner, accountNumber);
    }
}
