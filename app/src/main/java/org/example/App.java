package org.example;

public class App {
  public static void main(String[] args) {

    //number of flips n
    int[] n = {100, 500, 1000, 5000, 10000, 50000};
    //probabilities p
    double[] p = {0.25, 0.5, 0.75};
    //number of trials m
    int m = 10;

    CoinFlip coinFlipper = new CoinFlip();

    for (double prob : p) {
      for(int flips : n) {
        for(int trial = 1; trial <= m; trial++) {

          int headsCount = coinFlipper.flipCoins(flips, prob);

          System.out.println("Flips: " + flips + 
          ", Probability: " + prob + ", Trial: " + 
          trial + ", Heads: " + headsCount);
        }
      }
    }
  }
}
