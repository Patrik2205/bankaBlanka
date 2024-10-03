package org.delta.accounts;

import com.google.inject.Singleton;
import com.google.inject.Inject;
import org.delta.persons.Owner;

@Singleton
public class BankAccountFactory {

    private BankAccountNumberGenerator bankAccountNumberGenerator;

    @Inject
    public BankAccountFactory(BankAccountNumberGenerator bankAccountNumberGenerator) {
        this.bankAccountNumberGenerator = bankAccountNumberGenerator;
    }

    public BankAccount createBankAccount(double balance, Owner owner) {

        return new BankAccount(balance, owner, bankAccountNumberGenerator.generateBankAccountNumber());

    }

    public BankAccount createBankAccount(double balance, Owner owner, String bankAccountNumber) {
        return new BankAccount(balance, owner, bankAccountNumber);
    }

    public StudentBankAccount createStudentBankAccount(double balance, Owner owner, String accountNumber) {
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();

        return new StudentBankAccount(balance, owner, accountNumber);
    }

}
