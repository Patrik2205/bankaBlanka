package org.delta;

import com.google.inject.Inject;
import org.delta.*;
import org.delta.accounts.*;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;
import org.delta.persons.PersonIdValidator;
import org.delta.print.AccountDetailPrinter;

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

    @Inject
    DIContainer container;

    public void testBank() throws NoMoneyOnAccountException {

        Owner owner1 = container.getOwnerFactory().createOwner("Clovek", "Dva",5463247);
        BankAccount accountOne = container.getAccountFactory().createBankAccount(500, owner1);
        Owner owner2 = container.getOwnerFactory().createOwner("Clovek", "Dva",5463247);
        BankAccount accountTwo = container.getAccountFactory().createBankAccount(500, owner2);
//        BankAccount accountThree = bankAccountFactory.createSavingsBankAccount(owner, 500);
        Owner owner = container.getOwnerFactory().createOwner("Clovek", "JEdna", 5463246);
        container.getAccountFactory().createBankAccount(1234, owner);

        container.getService().addMoney(accountOne, 100);
        container.getService().addMoney(accountOne, 10);
        container.getService().addMoney(accountOne, 600);
        container.getService().addMoney(accountOne, 150);

        container.getService().transferMoneyBetweenAccounts(accountOne, accountTwo, 100);
    }
}
