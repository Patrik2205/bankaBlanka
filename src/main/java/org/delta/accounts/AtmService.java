package org.delta.accounts;

import com.google.inject.Inject;
import org.delta.accounts.cards.BankCard;

public class AtmService {

    @Inject
    MoneyTransferService moneyTransferService;

    @Inject
    GlobalCardStorage globalCardStorage;

    public void withdraw(BankCard card, double amount) {
        moneyTransferService.withdrawMoney(card.getBankAccount(), amount);
    }

    public void deposit(BankCard card, double amount) {
        moneyTransferService.depositMoney(card.getBankAccount(), amount);
    }

    public void withdraw(String cardNumber, double amount) {
        BankCard card = globalCardStorage.get(cardNumber);

        moneyTransferService.withdrawMoney(card.getBankAccount(), amount);
    }

    public void deposit(String cardNumber, double amount) {
        BankCard card = globalCardStorage.get(cardNumber);

        moneyTransferService.depositMoney(card.getBankAccount(), amount);
    }
}
