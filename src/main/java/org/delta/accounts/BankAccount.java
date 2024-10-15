package org.delta.accounts;

import org.delta.accounts.cards.BankCard;
import org.delta.persons.Owner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BankAccount {
    private double balance;

    private Owner owner;

    private String accountNumber;

    private Map<String, BankCard> cards = new HashMap<>();

    public BankCard getCard(String cardNumber) {
        return cards.get(cardNumber);
    }

    public void addCard(BankCard card) {
        cards.put(card. toString(), card);
    }

    public BankAccount(double balance, Owner owner, String accountNumber) {
        this.balance = balance;
        this.owner = owner;
        this.accountNumber = accountNumber;

    }

    public Owner getOwner() { return owner; }

    public String getAccountNumber() { return accountNumber; }

    public double getBalance() { return balance; }

    public void setBalance(double newDestinationBalance) {

    }
}
