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
        return new BankCard(
            this.cardNumberGenerator.generate(),
            this.bankCardPinGenerator.generate()
        );
    }
}
