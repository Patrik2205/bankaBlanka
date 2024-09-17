package org.delta.accounts;

import org.delta.persons.Owner;

public class BankAccountFactory {

    private BankAccountNumberGenerator bankAccountNumberGenerator;

    public BankAccount BankAccountFactory(double balance, Owner owner   ) {
        this.bankAccountNumberGenerator = new BankAccountNumberGenerator();

        return new BankAccount(balance, owner, bankAccountNumber);

    }

    public BankAccount createBankAccount(double balance, Owner owner) {
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();

        return new BankAccount(balance, owner, bankAccountNumber);
    }

    public StudentBankAccount createStudentBankAccount(double balance, Owner owner, String accountNumber) {
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();

        return new StudentBankAccount(balance, owner, accountNumber);
    }

}
