package org.delta.accounts.cards;

import com.google.inject.Inject;
import org.delta.accounts.GlobalCardStorage;

public class BankCardFactory {

    @Inject
    private CardNumberGenerator cardNumberGenerator;

    @Inject
    private BankCardPinGenerator bankCardPinGenerator;

    @Inject
    GlobalCardStorage globalCardStorage;

    public BankCard createBankCard() {
        BankCard card = new BankCard(
            this.cardNumberGenerator.generate(),
            this.bankCardPinGenerator.generate()
        );

        this.globalCardStorage.put(card);

        return card;
    }

    public BankCard findCard(String number) {
        return this.globalCardStorage.get(number);
    }
}
