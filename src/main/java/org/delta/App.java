package org.delta;

import com.google.inject.Inject;
import org.delta.accounts.*;
import org.delta.accounts.cards.BankCardFacade;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;
import org.delta.investments.*;
import org.delta.serialization.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

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

    @Inject
    StockFactory stockFactory;

    @Inject
    StockTransactionsService stockTransactionsService;

    @Inject
    GlobalStockStorage globalStockStorage;

    @Inject
    BankSerializationService bankSerializationService;

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
        DateFormat dateFormat = DateFormat.getDateInstance();

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

        stockFactory.createDividendStock("AAPL", 222.01, 0.0045f, Stock.DividendFrequency.QUARTERLY, new Date(2024, 8, 15));
        stockFactory.createStock("GOOG", 170.68);
        stockFactory.createDividendStock("O", 170.68, 0.051f, Stock.DividendFrequency.MONTHLY, new Date(2024, 10, 15));

        InvestmentAccount investmentAccount = bankAccountFacade.createInvestmentAccount(1000, owner, "1234");
        globalStockStorage.get("AAPL");

        stockTransactionsService.buyStock(investmentAccount, "AAPL", 10);

        bankSerializationService.serializeAndWriteToFile();
    }
}
