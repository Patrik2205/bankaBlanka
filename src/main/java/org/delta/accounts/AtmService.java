package org.delta.accounts;

public class AtmService {

    public void withdrawMoney(BankAccount bankAccount, double amount) throws NoMoneyOnAccountException {
        if(bankAccount.getBalance() < amount){
            throw new NoMoneyOnAccountException("No money");
        }

        System.out.println("Balance before: " + bankAccount.getBalance());
        bankAccount.setBalance(bankAccount.getBalance() - amount);
        System.out.println("Balance after: " + bankAccount.getBalance());
    }

    public void depositMoney(BankAccount bankAccount, double amount){
        System.out.println("Balance before: " + bankAccount.getBalance());
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        System.out.println("Balance after: " + bankAccount.getBalance());
    }
}