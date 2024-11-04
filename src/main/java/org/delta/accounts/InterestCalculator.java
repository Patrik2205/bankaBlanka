package org.delta.accounts;

public class InterestCalculator {
    public double calculateInterest(SavingsAccount bankAccount) {
        return bankAccount.getBalance() * (bankAccount.getInterestRate() / 100);
    }
}
