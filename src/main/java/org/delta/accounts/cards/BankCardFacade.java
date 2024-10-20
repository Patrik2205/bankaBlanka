package org.delta.accounts.cards;

import com.google.inject.Inject;
import org.delta.accounts.GlobalCardStorage;

public class BankCardFacade {
    @Inject
    public BankCardFactory paymentCardFactory;

    @Inject
    public GlobalCardStorage globalCardStorage;

}
