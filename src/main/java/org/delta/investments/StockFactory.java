package org.delta.investments;

import com.google.inject.Inject;

import java.util.Date;

public class StockFactory {
    public Stock createStock(String symbol, double price) {
        return new Stock(symbol, price);
    }

    public Stock createDividendStock(String symbol, double price, float dividendYield, Stock.DividendFrequency dividendFrequency, Date lastDividendPaidAt) {
        return new Stock(symbol, price).withDividendProperties(dividendYield, dividendFrequency, lastDividendPaidAt);
    }
}
