package org.delta;

import org.delta.*;
import org.delta.accounts.BankAccount;
import org.delta.accounts.BankAccountFactory;
import org.delta.accounts.MoneyTransferService;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;

public class App {
    public void run() {
        System.out.print("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        int a = 2, b = 2;

        System.out.println(a + b);

        String text = "muj String s velkým S";
        char charKHLedani = 'b';
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == charKHLedani) {
                System.out.println("Char nalezen na indexu: " + i);
            }
        }
    }

    public void testBank() {
        OwnerFactory ownerFactory = new OwnerFactory();
        Owner owner = ownerFactory.createOwner("Clovek", "JEdna", 5463246);
        BankAccountFactory accountFactory = new BankAccountFactory();
        accountFactory.createBankAccount(1234, owner);

        MoneyTransferService service = new MoneyTransferService();

        BankAccountFactory accountFactoryOne = new BankAccountFactory();
        OwnerFactory ownerFactoryOne = new OwnerFactory();
        Owner owner1 = ownerFactoryOne.createOwner("Clovek", "Dva",5463247);
        BankAccount accountOne = accountFactoryOne.createBankAccount(500, owner1);
        BankAccountFactory accountFactoryTwo = new BankAccountFactory();
        OwnerFactory ownerFactoryTwo = new OwnerFactory();
        Owner owner2 = ownerFactoryTwo.createOwner("Clovek", "Dva",5463247);
        BankAccount accountTwo = accountFactoryTwo.createBankAccount(500, owner2);
//        BankAccount accountThree = bankAccountFactory.createSavingsBankAccount(owner, 500);

        service.addMoney(accountOne, 100);
        service.addMoney(accountOne, 10);
        service.addMoney(accountOne, 600);
        service.addMoney(accountOne, 150);

        service.transferMoneyBetweenAccounts(accountOne, accountTwo, 100);
    }
}
