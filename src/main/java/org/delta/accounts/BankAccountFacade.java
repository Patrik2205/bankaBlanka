package org.delta.accounts;

import com.google.inject.Inject;
import org.delta.accounts.cards.BankCardFactory;

public class BankAccountFacade {
    @Inject
    public BankAccountFactory bankAccountFactory;

    @Inject
    public BankCardFactory paymentCardFactory;

    @Inject
    public MoneyTransferService moneyTransferService;
}