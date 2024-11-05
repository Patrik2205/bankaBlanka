package org.delta.accounts;

import com.google.inject.Singleton;
import com.google.inject.Inject;
import org.delta.persons.Owner;

@Singleton
public class BankAccountFactory {

    @Inject
    public GlobalAccountStorage globalAccountStorage;

    @Inject
    public BankAccountNumberGenerator numberGenerator;

    public BankAccount createBankAccount(double balance, Owner owner, String bankAccountNumber) { return new BankAccount(balance, owner, bankAccountNumber); }

    public StudentBankAccount createStudentBankAccount(double balance, Owner owner) { return new StudentBankAccount(balance, owner, this.numberGenerator.generateBankAccountNumber()); }

    public SavingsAccount createSavingBankAccount(double balance, Owner owner, String accountNumber, double interestRate) { return new SavingsAccount(balance, owner, accountNumber, interestRate); }
}
