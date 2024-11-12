package org.delta.investments;

import org.delta.Pair;

import java.util.ArrayList;

public class InvestmentList {
    public ArrayList<Pair<Double, Stock>> stocks = new ArrayList<Pair<Double, Stock>>();

    public void addStock(Stock stock, double percentage) {
        stocks.add(new Pair<>(percentage, stock));
    }
}