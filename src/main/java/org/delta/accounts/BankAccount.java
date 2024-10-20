package org.delta.accounts;

import org.delta.accounts.cards.BankCard;
import org.delta.persons.Owner;

import java.util.*;

public class BankAccount {
    private double balance;

    private Owner owner;

    private String accountNumber;

    private List<BankCard> bankCards = new ArrayList<BankCard>();

    public void addCard(BankCard card) {
        this.bankCards.add(card);

        card.setBankAccount(this);
    }

    public List<BankCard> getCards() {
        return this.bankCards;
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
