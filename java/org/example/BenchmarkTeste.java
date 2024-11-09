package org.example;

import org.openjdk.jmh.annotations.Benchmark;

import static org.apache.commons.math3.util.ArithmeticUtils.factorial;

public class BenchmarkTeste
{
    @Benchmark
    public long factorialJava() {
        BenchmarkTeste factorial = new BenchmarkTeste();
        return factorial(10);
    }
}