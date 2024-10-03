package org.delta.accounts;

import jakarta.inject.Singleton;

@Singleton
public class SlovakianBankAccountNumberGenerator implements BankAccountNumberGeneratorInterface {
    @Override
    public String generateBankAccountNumber() {
        return "";
    }
}
