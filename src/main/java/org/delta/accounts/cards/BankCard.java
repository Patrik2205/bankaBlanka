package org.delta.accounts.cards;

import org.delta.accounts.BankAccount;

public class BankCard {

    private String CardNumber;
    private String CardPin;

    private BankAccount BankAccount;

    public BankCard(String generate, String generate1) {
        this.CardNumber = generate;
        this.CardPin = generate1;
    }

    public void setBankAccount(org.delta.accounts.BankAccount bankAccount) {
        BankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return BankAccount;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public String getCardPin() {
        return CardPin;
    }
}
