package org.delta;

import org.delta.*;
import org.delta.accounts.BankAccount;
import org.delta.accounts.MoneyTransferService;
import org.delta.persons.Owner;

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
        MoneyTransferService service = new MoneyTransferService();

        Owner owner = new Owner();
        BankAccount account =
    }
}
