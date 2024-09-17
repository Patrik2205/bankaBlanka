package org.delta.accounts;

public class TransferFeeCalculator {
    public static final double DEFAULT_TRANSFER_FEE = 10;
    public static final double SECOND_TRANSFER_FEE = 30;

    public double calculateFee(double amount) {
        double fee = DEFAULT_TRANSFER_FEE;
        if (amount < 0) {

        }

        return 0;
    }
}
