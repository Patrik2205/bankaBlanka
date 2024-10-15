package org.delta.accounts;

import com.google.inject.Singleton;
import com.google.inject.Inject;
import org.delta.persons.Owner;

@Singleton
public class BankAccountFactory {

    @Inject
    public BankAccountNumberGenerator numberGenerator;

    public BankAccount createBankAccount(double balance, Owner owner) {

        return new BankAccount(balance, owner, numberGenerator.generateBankAccountNumber());

    }

    public BankAccount createBankAccount(double balance, Owner owner, String bankAccountNumber) {
        return new BankAccount(balance, owner, bankAccountNumber);
    }

    public StudentBankAccount createStudentBankAccount(double balance, Owner owner, String accountNumber) {
        String bankAccountNumber = this.numberGenerator.generateBankAccountNumber();

        return new StudentBankAccount(balance, owner, accountNumber);
    }

}
