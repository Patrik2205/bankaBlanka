package org.delta.accounts.cards;

public class BankCard {

    private String CardNumber;
    private String CardPin;

    public BankCard(String generate, String generate1) {
        this.CardNumber = generate;
        this.CardPin = generate1;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public String getCardPin() {
        return CardPin;
    }
}
