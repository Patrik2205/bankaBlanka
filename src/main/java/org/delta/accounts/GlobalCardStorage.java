package org.delta.accounts;

import com.google.inject.Singleton;
import org.delta.accounts.cards.BankCard;

import java.util.HashMap;

@Singleton
public class GlobalCardStorage {
    public HashMap<String, BankCard> bankCards = new HashMap<String, BankCard>();

    public void put(BankCard card) {
        this.bankCards.put(card.getCardNumber(), card);
    }

    public BankCard get(String number) {
        return this.bankCards.get(number);
    }
}
