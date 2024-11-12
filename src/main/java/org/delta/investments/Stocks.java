package org.delta.investments;

public class Stocks {
    private Stock stock;
    private double quantity;

    public Stocks(Stock stock, double quantity) {
        this.stock = stock;
        this.quantity = quantity;
    }

    public Stock getStock() {
        return stock;
    }

    public double getQuantity() {
        return quantity;
    }

    public void addQuantity(double quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(double quantity) {
        this.quantity -= quantity;
    }
}