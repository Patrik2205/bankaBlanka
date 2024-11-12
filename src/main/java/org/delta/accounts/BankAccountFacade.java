package org.delta.accounts;

import com.google.inject.Inject;
import org.delta.accounts.cards.BankCard;
import org.delta.accounts.cards.BankCardFactory;
import org.delta.investments.InvestmentAccount;
import org.delta.persons.Owner;

public class BankAccountFacade {
    @Inject
    public BankAccountFactory bankAccountFactory;

    @Inject
    public GlobalAccountStorage globalAccountStorage;

    @Inject
    public BankCardFactory bankCardFactory;

    @Inject
    public MoneyTransferService moneyTransferService;

    @Inject
    public BankAccountNumberGenerator numberGenerator;

    public BankAccount createBankAccount(double balance, Owner owner) {
        BankAccount bankAccount = bankAccountFactory.createBankAccount(balance, owner, numberGenerator.generateBankAccountNumber());
        BankCard paymentCard = bankCardFactory.createBankCard();

        bankAccount.addCard(paymentCard);

        globalAccountStorage.put(bankAccount);

        return bankAccount;
    }

    public SavingsAccount createSavingBankAccount(double balance, Owner owner, String accountNumber) {

        SavingsAccount savingsAccount = bankAccountFactory.createSavingBankAccount(balance, owner, accountNumber, 4);

        globalAccountStorage.put(savingsAccount);

        return savingsAccount;
    }

    public InvestmentAccount createInvestmentAccount(double balance, Owner owner, String accountNumber) {
        InvestmentAccount account = bankAccountFactory.createInvestmentAccount(balance, owner, accountNumber);
        return account;
    }
}