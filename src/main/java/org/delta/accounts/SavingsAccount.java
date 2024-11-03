package org.delta.accounts;

import org.delta.persons.Owner;

public class SavingsAccount extends BankAccount implements Interesting {

    public SavingsAccount(double balance, Owner owner, String accountNumber) {
        super(balance, owner, accountNumber);
    }

    @Override
    public double getInterest() {
        if (this.getBalance() < 500000) {
            return 4;
        }

        return 1;
    }
}
