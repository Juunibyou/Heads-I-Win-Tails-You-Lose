package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GreetingGeneratorTest {
    @Test
    void TestAverage() {
        CoinFlip coinFlip = new CoinFlip();

        int numFlips = 10000;
        double bias = 0.5;

        int headsCount = coinFlip.flipCoins(numFlips, bias);
        double proportionHeads = (double) headsCount / numFlips;

        assertTrue(Math.abs(proportionHeads - bias) < 0.05, 
        "Proportion of heads should be close to the bias");
    }
}
