package org.delta.serialization;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.GlobalAccountStorage;
import org.delta.accounts.GlobalCardStorage;
import org.delta.investments.GlobalStockStorage;

@Singleton
public class BankJsonDataFacade {
    @Inject
    private GlobalAccountStorage globalBankAccountStorage;

    @Inject
    private GlobalStockStorage globalStockStorage;

    @Inject
    private GlobalCardStorage globalCardStorage;

    @Inject BankJsonDataFactory bankJsonDataFactory;

    public BankJsonData createBankJsonDataFromGlobalStorages() {
        BankJsonData data = bankJsonDataFactory.create();
        data.accounts = globalBankAccountStorage.bankAccounts;
        data.stocks = globalStockStorage.stocks;
        data.bankCards = globalCardStorage.bankCards;

        return data;
    }

    public void updateGlobalStoragesFromBankJsonData(BankJsonData bankJsonData) {
        globalBankAccountStorage.bankAccounts = bankJsonData.accounts;
        globalStockStorage.stocks = bankJsonData.stocks;
        globalCardStorage.bankCards = bankJsonData.bankCards;
    }
}
