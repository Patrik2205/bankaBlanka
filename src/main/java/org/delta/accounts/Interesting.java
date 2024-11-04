package org.delta.accounts;

import com.google.inject.Inject;

public class Interesting {
    @Inject
    private GlobalAccountStorage globalAccountStorage;

    @Inject
    private InterestCalculator interestCalculator;

    @Inject
    private MoneyTransferService moneyTransferService;

    public void calculate() {
        for (BankAccount account : this.globalAccountStorage.bankAccounts.values()) {

            if (account instanceof SavingsAccount savingsAccount) {

                long interestInterval = 2592000000L;

                if (System.currentTimeMillis() - interestInterval > savingsAccount.getLastInterestedAt()) {
                    this.moneyTransferService.addMoney(account, this.interestCalculator.calculateInterest(savingsAccount));
                    savingsAccount.setLastInterestedAt(System.currentTimeMillis());
                }
            }
        }
    }
}
