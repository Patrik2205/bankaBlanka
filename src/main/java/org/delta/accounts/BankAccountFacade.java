package org.delta.accounts;

import com.google.inject.Inject;
import org.delta.accounts.cards.BankCard;
import org.delta.accounts.cards.BankCardFactory;
import org.delta.persons.Owner;

public class BankAccountFacade {
    @Inject
    public BankAccountFactory bankAccountFactory;

    @Inject
    public BankCardFactory bankCardFactory;

    @Inject
    public MoneyTransferService moneyTransferService;

    public BankAccount createBankAccount(double balance, Owner owner) {
        BankAccount bankAccount = bankAccountFactory.createBankAccount(balance, owner);
        BankCard paymentCard = bankCardFactory.createBankCard();

        bankAccount.addCard(paymentCard);

        return bankAccount;
    }

    public SavingsAccount createSavingBankAccount(double balance, Owner owner, String accountNumber) {

        return bankAccountFactory.createSavingBankAccount(balance, owner, accountNumber, 4);
    }
}