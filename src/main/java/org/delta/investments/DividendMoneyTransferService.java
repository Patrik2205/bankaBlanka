package org.delta.investments;

import com.google.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.accounts.GlobalAccountStorage;
import org.delta.accounts.MoneyTransferService;

import java.util.Date;

public class DividendMoneyTransferService {
    @Inject
    GlobalAccountStorage globalAccountStorage;

    @Inject
    GlobalStockStorage globalStockStorage;

    @Inject
    MoneyTransferService moneyTransferService;

    @Inject
    DividendCalculator dividendCalculator;

    public void run() {
        for (Stock stock : globalStockStorage.stocks.values()) {
            for (BankAccount account : globalAccountStorage.bankAccounts.values()) {
                if (account instanceof InvestmentAccount investmentAccount) {

                    if (!investmentAccount.hasStock(stock.getSymbol())) {
                        continue;
                    }

                    if (stock.isDividendStock() && stock.isDividendDue(new Date())) {
                        double dividend = dividendCalculator.calculateDividend(stock, investmentAccount.getStockQuantity(stock.getSymbol()));

                        moneyTransferService.addMoney(account, dividend);
                    }
                }
            }

            stock.setLastDividendPaidAt(new Date());
        }
    }
}
