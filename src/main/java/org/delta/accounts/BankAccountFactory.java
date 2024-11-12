package org.delta.accounts;

import com.google.inject.Singleton;
import com.google.inject.Inject;
import org.delta.investments.InvestmentAccount;
import org.delta.persons.Owner;

@Singleton
public class BankAccountFactory {

    @Inject
    public BankAccountNumberGenerator numberGenerator;

    @Inject
    GlobalAccountStorage globalAccountStorage;

    public BankAccount createBankAccount(double balance, Owner owner, String bankAccountNumber) { return new BankAccount(balance, owner, bankAccountNumber); }

    public StudentBankAccount createStudentBankAccount(double balance, Owner owner) { return new StudentBankAccount(balance, owner, this.numberGenerator.generateBankAccountNumber()); }

    public SavingsAccount createSavingBankAccount(double balance, Owner owner, String accountNumber, double interestRate) { return new SavingsAccount(balance, owner, accountNumber, interestRate); }

    public InvestmentAccount createInvestmentAccount(double balance, Owner owner, String accountNumber) {
        InvestmentAccount account = new InvestmentAccount(balance, owner, accountNumber);
        this.globalAccountStorage.put(account);
        return account;
    }
}
