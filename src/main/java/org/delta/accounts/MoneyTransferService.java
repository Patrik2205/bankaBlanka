package org.delta.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.print.AccountDetailPrinter;

import static org.delta.accounts.TransferFeeCalculator.DEFAULT_TRANSFER_FEE;
import static org.delta.accounts.TransferFeeCalculator.SECOND_TRANSFER_FEE;

@Singleton
public class MoneyTransferService {

    @Inject
    AccountDetailPrinter accountDetailPrinter;

    @Inject
    TransferFeeCalculator feeCalculator;

    public void depositMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance + amount;

        newBalance -= this.feeCalculator.calculateTransferFee(amount);

        bankAccount.setBalance(newBalance);
        accountDetailPrinter.printDetail(bankAccount);
    }

    public void withdrawMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance - amount;

        newBalance += this.feeCalculator.calculateTransferFee(amount);

        bankAccount.setBalance(newBalance);
        accountDetailPrinter.printDetail(bankAccount);
    }

    public void transferMoneyBetweenAccounts(BankAccount from, BankAccount to, double amount) throws NoMoneyOnAccountException {
        if(from.getBalance() < amount) {
            throw new NoMoneyOnAccountException("No money on account!");
        }

        this.accountDetailPrinter.printDetail(from);
        this.accountDetailPrinter.printDetail(to);

        double sourceBalance = from.getBalance();
        double newSourceBalance = sourceBalance - amount;

        from.setBalance(newSourceBalance);
        double destinationBalance = to.getBalance();
        double newDestinationBalance = destinationBalance + amount;

        to.setBalance(newDestinationBalance);

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

    public void subtractMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance - amount;
        bankAccount.setBalance(newBalance);
    }

    public boolean hasEnoughMoney(BankAccount bankAccount, double amount) {
        return bankAccount.getBalance() >= amount;
    }
}
