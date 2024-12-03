package org.delta.serialization;

import org.delta.accounts.BankAccount;
import org.delta.accounts.cards.BankCard;
import org.delta.investments.Stock;
import org.delta.investments.StockTransactionsService;

import java.util.HashMap;

public class BankJsonData {
    public HashMap<String, BankCard> bankCards;
    public HashMap<String, BankAccount> accounts;
    public HashMap<String, Stock> stocks;
}