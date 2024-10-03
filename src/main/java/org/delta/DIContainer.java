package org.delta;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.BankAccountFactory;
import org.delta.accounts.BankAccountNumberGenerator;
import org.delta.accounts.MoneyTransferService;
import org.delta.accounts.TransferFeeCalculator;
import org.delta.persons.OwnerFactory;
import org.delta.persons.OwnerJsonSerializationService;
import org.delta.persons.PersonIdValidator;
import org.delta.print.AccountDetailPrinter;

@Singleton
public class DIContainer {
    PersonIdValidator idValidator = new PersonIdValidator();
    BankAccountNumberGenerator generator = new BankAccountNumberGenerator();

    OwnerFactory ownerFactory = new OwnerFactory(idValidator);

    @Inject
    BankAccountFactory accountFactory;

    TransferFeeCalculator calculator = new TransferFeeCalculator();
    AccountDetailPrinter accountDetailPrinter = new AccountDetailPrinter();
    MoneyTransferService service = new MoneyTransferService(calculator, accountDetailPrinter);

    OwnerJsonSerializationService ownerJsonSerializationService = new OwnerJsonSerializationService();

    public OwnerJsonSerializationService getOwnerJsonSerializationService() {
        return ownerJsonSerializationService;
    }

    public PersonIdValidator getIdValidator() {
        return idValidator;
    }

    public BankAccountNumberGenerator getGenerator() {
        return generator;
    }

    public OwnerFactory getOwnerFactory() {
        return ownerFactory;
    }

    public BankAccountFactory getAccountFactory() {
        return accountFactory;
    }

    public TransferFeeCalculator getCalculator() {
        return calculator;
    }

    public AccountDetailPrinter getAccountDetailPrinter() {
        return accountDetailPrinter;
    }

    public MoneyTransferService getService() {
        return service;
    }
}
