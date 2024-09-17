package org.delta.accounts;

import java.util.Random;

public class BankAccountNumberGenerator {

    private static final byte BASE_ACCOUNT_NUMBER_LENGTH = 10;

    public String generateBankAccountNumber() {
        StringBuilder number = new StringBuilder();
        Random rand = new Random();
        number.append(rand.nextInt(BASE_ACCOUNT_NUMBER_LENGTH));
        return number.toString();
    }

}
