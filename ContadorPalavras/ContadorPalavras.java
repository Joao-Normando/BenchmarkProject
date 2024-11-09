package org.example;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class ContadorPalavras {

    private static final String ARQUIVO = "C:\\Users\\joaon\\OneDrive\\Área de Trabalho\\Nova pastaTeste\\testeBenchmark.txt";

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void BenchmarkContadorPalavras() throws IOException {
        Map<String, Integer> contador = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] palavras = linha.split("\\W+");
                for (String palavra : palavras) {
                    palavra = palavra.toLowerCase();
                    contador.put(palavra, contador.getOrDefault(palavra, 0) + 1);
                }
            }
        }
    }
}
