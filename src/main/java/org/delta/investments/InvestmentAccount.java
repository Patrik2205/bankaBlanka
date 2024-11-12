package org.delta.investments;

import org.delta.accounts.BankAccount;
import org.delta.persons.Owner;

import java.util.HashMap;
import java.util.Map;

public class InvestmentAccount extends BankAccount {
    private HashMap<String, Stocks> ownedStocks = new HashMap<String, Stocks>();

    private InvestmentList defaultInvestmentList = new InvestmentList();

    public InvestmentList getDefaultInvestmentList() {
        return defaultInvestmentList;
    }

    public void setDefaultInvestmentList(InvestmentList defaultInvestmentList) {
        this.defaultInvestmentList = defaultInvestmentList;
    }

    public InvestmentAccount(double balance, Owner owner, String accountNumber) {
        super(balance, owner, accountNumber);
    }

    public void addStock(Stock stock, double quantity) {
        if(this.ownedStocks.containsKey(stock.getSymbol())) {
            this.ownedStocks.get(stock.getSymbol()).addQuantity(quantity);
        } else {
            this.ownedStocks.put(stock.getSymbol(), new Stocks(stock, quantity));
        }
    }

    public void removeStock(Stock stock, double quantity) {
        this.addStock(stock, -quantity);
    }

    public boolean hasStock(String stockSymbol) {
        return this.ownedStocks.containsKey(stockSymbol);
    }

    public boolean hasSufficientStocks(String stockSymbol, double quantity) {
        if(!this.ownedStocks.containsKey(stockSymbol)) {
            return false;
        }

        return this.ownedStocks.get(stockSymbol).getQuantity() >= quantity;
    }

    public double getStockQuantity(String stockSymbol) {
        if(!this.ownedStocks.containsKey(stockSymbol)) {
            return 0;
        }

        return this.ownedStocks.get(stockSymbol).getQuantity();
    }

    public HashMap<String, Stocks> getOwnedStocks() {
        return ownedStocks;
    }

    public double getAssetsValue() {
        double value = 0;
        for(Map.Entry<String, Stocks> entry : this.ownedStocks.entrySet()) {
            Stocks stockOwnership = entry.getValue();
            value += stockOwnership.getStock().getPrice() * stockOwnership.getQuantity();
        }

        return value;
    }
}