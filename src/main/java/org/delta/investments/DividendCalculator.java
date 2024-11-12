package org.delta.investments;

public class DividendCalculator {
    public double calculateDividend(Stock stock, double quantity) {
        switch(stock.getDividendFrequency()) {
            case QUARTERLY:
                return stock.getDividendValue() * quantity / 4;
            case MONTHLY:
                return stock.getDividendValue() * quantity / 12;
            case BIANNUALLY:
                return stock.getDividendValue() * quantity / 2;
            case ANNUALLY:
                return stock.getDividendValue() * quantity;
            default:
                throw new RuntimeException("Invalid dividend frequency");
        }
    }
}