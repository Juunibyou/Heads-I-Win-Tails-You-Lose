package org.example.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;
import java.util.Random;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 2)
@Warmup(iterations = 2)

public class CoinBenchmark {

  int[] n = {100, 500, 1000, 5000, 10000, 50000};
  double[] p = {0.25, 0.5, 0.75};
  int m = 10;
  Random random;
  
  @Setup
  public void setup() {
    random = new Random();
  }

  @Benchmark
  @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
  public void flipCoinBenchmark(Blackhole bh) {
    for (double prob : p) {
      for(int flips : n) {
        for(int trial = 1; trial <= m; trial++) {
          int headsCount = 0;
          for (int i = 0; i < flips; i++) {
            if (random.nextDouble() < prob) {
              headsCount++;
            }
          }
          bh.consume(headsCount);
        }
      }
    }
  }
}
