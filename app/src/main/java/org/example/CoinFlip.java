package org.example;

import java.util.Random;

public class CoinFlip {
    private final Random random = new Random();

    public int flipCoins(int numFlips, double bias) {

        int headsCount = 0;

        for (int i = 0; i < numFlips; i++) {
            if (random.nextDouble() < bias) {
                headsCount++;
            }
        }
        return headsCount;
    }
}