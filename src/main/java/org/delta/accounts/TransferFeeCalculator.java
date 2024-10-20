package org.delta.accounts;

public class TransferFeeCalculator {
    public static final double TRANSACTION_FEE_FIXED_AMOUNT = 10;

    public static final double DEFAULT_TRANSFER_FEE = 20;
    public static final double SECOND_TRANSFER_FEE = 30;

    public static final double TRANSACTION_FEE_PERCENTAGE = 0.1;
    public static final double TRANSACTION_FEE_PERCENTAGE_MINIMAL_AMOUNT = 500;

    public double calculateTransferFee(double amount) {
        double fee = TRANSACTION_FEE_FIXED_AMOUNT;
        if(amount >= TRANSACTION_FEE_PERCENTAGE_MINIMAL_AMOUNT) {
            fee += TRANSACTION_FEE_PERCENTAGE * amount;
        }
        return fee;
    }

}
