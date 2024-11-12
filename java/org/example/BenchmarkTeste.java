package org.example;
import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class BenchmarkTesteJava {

    private static final int N = 10;

    @Benchmark
    public long factorialIterative() {
        long result = 1;
        for (int i = 2; i <= N; i++) {
            result *= i;
        }
        return result;
    }
}