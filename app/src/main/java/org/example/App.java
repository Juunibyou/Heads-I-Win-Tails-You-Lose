package org.example;
import java.util.Random;

public class App {
  public static void main(String[] args) {

    //number of flips n
    int[] n = {100, 500, 1000, 5000, 10000, 50000};
    //probabilities p
    double[] p = {0.25, 0.5, 0.75};
    //number of trials m
    int m = 10;

    Random random = new Random();

    for (double prob : p) {
      for(int flips : n) {
        for(int trial = 1; trial <= m; trial++) {
          int headsCount = 0;
          for (int i = 0; i < flips; i++) {
            if (random.nextDouble() < prob) {
              headsCount++;
            }
          }

          System.out.println(
            "n = " + flips + 
            ", trial = " + trial + 
            ", p = " + prob + 
            ", heads = " + headsCount);
        }
      }
    }
  }
}
