package org.delta;

import com.google.inject.Inject;
import org.delta.accounts.*;
import org.delta.accounts.cards.BankCardFacade;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;

public class App {

    @Inject
    OwnerFactory ownerFactory;

    @Inject
    BankAccountFacade bankAccountFacade;

    @Inject
    BankCardFacade BankCardFacade;

    @Inject
    AtmService atmService;

    @Inject
    Interesting interesting;

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

    public void testBank() throws NoMoneyOnAccountException {

        Owner owner1 = ownerFactory.createOwner("Clovek", "Dva",5463247);
        BankAccount accountOne = bankAccountFacade.createBankAccount(500, owner1);
        Owner owner2 = ownerFactory.createOwner("Clovek", "Dva",5463247);
        BankAccount accountTwo = bankAccountFacade.createBankAccount(500, owner2);
        Owner owner = ownerFactory.createOwner("Clovek", "JEdna", 5463246);

        bankAccountFacade.moneyTransferService.addMoney(accountOne, 100);
        bankAccountFacade.moneyTransferService.addMoney(accountOne, 10);
        bankAccountFacade.moneyTransferService.addMoney(accountOne, 600);
        bankAccountFacade.moneyTransferService.addMoney(accountOne, 150);

        atmService.deposit(accountOne.getCards().get(0), 100);

        String cNumber = accountOne.getCards().get(0).getCardNumber();
        atmService.withdraw(cNumber, 50);

        bankAccountFacade.moneyTransferService.transferMoneyBetweenAccounts(accountOne, accountTwo, 100);

        SavingsAccount savingsAccount = bankAccountFacade.createSavingBankAccount(1000, owner, "1234");

        this.interesting.calculate();
    }
}
