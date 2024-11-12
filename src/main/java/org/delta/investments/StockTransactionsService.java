package org.delta.investments;

import com.google.inject.Inject;
import org.delta.Pair;
import org.delta.accounts.MoneyTransferService;

public class StockTransactionsService {
    @Inject
    GlobalStockStorage globalStockStorage;

    @Inject
    MoneyTransferService moneyTransferService;

    public void buyStock(InvestmentAccount account, String stockSymbol, double quantity) {
        Stock stock = globalStockStorage.get(stockSymbol);

        if(stock == null) {
            throw new RuntimeException("Stock not found");
        }

        if(!moneyTransferService.hasEnoughMoney(account, quantity * globalStockStorage.get(stockSymbol).getPrice())) {
            throw new RuntimeException("Insufficient funds");
        }

        moneyTransferService.subtractMoney(account, quantity * globalStockStorage.get(stockSymbol).getPrice());

        account.addStock(stock, quantity);
    }

    public void sellStock(InvestmentAccount account, String stockSymbol, double quantity) {
        if(!account.hasSufficientStocks(stockSymbol, quantity)) {
            throw new RuntimeException("Insufficient stocks");
        }

        Stock stock = globalStockStorage.get(stockSymbol);

        if(stock == null) {
            throw new RuntimeException("Stock not found");
        }


        moneyTransferService.addMoney(account, quantity * stock.getPrice());

        account.removeStock(stock, quantity);
    }

    public void autoInvest(InvestmentAccount account, InvestmentList investmentPie, double amount) {
        for(Pair<Double, Stock> stockPair : investmentPie.stocks) {
            double percentage = stockPair.x;
            Stock stock = stockPair.y;

            double stockAmount = amount * percentage;

            buyStock(account, stock.getSymbol(), stockAmount / stock.getPrice());
        }
    }

    public void autoInvest(InvestmentAccount account, double amount) {
        InvestmentList investmentList = account.getDefaultInvestmentList();

        if(investmentList == null) {
            throw new RuntimeException("No default investment pie set.");
        }

        this.autoInvest(account, investmentList, amount);
    }
}
