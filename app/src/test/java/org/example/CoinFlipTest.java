package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoinFlipTest {
    @Test
    void TestExpectedProb() {
        CoinFlip coinFlip = new CoinFlip();

        int numFlips = 100000;
        double bias = 0.75;

        int heads = coinFlip.flipCoins(numFlips, bias);
        double observed = heads / numFlips;

        double tolerance = 0.03;

        assertTrue(
            Math.abs(observed - bias) < tolerance,
            "Observed probability " + observed + " differs too much from expected " + bias
        );
    }
}
