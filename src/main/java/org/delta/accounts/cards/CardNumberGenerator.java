package org.delta.accounts.cards;

import java.util.Random;

public class CardNumberGenerator {

    public String generate() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            int digit = rand.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }
}
