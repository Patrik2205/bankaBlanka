package org.delta.accounts;

import org.delta.accounts.*;

import static org.delta.accounts.TransferFeeCalculator.DEFAULT_TRANSFER_FEE;
import static org.delta.accounts.TransferFeeCalculator.SECOND_TRANSFER_FEE;

public class MoneyTransferService {
    private final TransferFeeCalculator transferFeeCalculator;

    public MoneyTransferService() {
        this.transferFeeCalculator = new TransferFeeCalculator();
    }

    public void addMoney(BankAccount account, double amount) {
        double balance = account.getBalance();
        double newBalance;

        if (500 >= amount) {
            newBalance = balance + amount - DEFAULT_TRANSFER_FEE;
        } else {
            newBalance = balance + amount - SECOND_TRANSFER_FEE;
        }
        account.setBalance(newBalance);
    }
}
