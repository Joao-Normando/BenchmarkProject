package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] contagemPalavras = {100000, 500000, 1000000, 5000000};
        for (int contagem : contagemPalavras) {
            System.out.println("\nNúmero total de palavras: " + contagem);
            double tempoTotalExecucao = 0;
            double totalMemoriaUsada = 0;

            for (int i = 1; i <= 10; i++) {
                // Gerando palavras de exemplo
                String[] palavras = gerarPalavras(contagem);

                // Forçando a coleta de lixo antes da medição
                System.gc();
                long memoriaAntes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

                long inicioTempo = System.currentTimeMillis();

                // Processamento das palavras
                int totalCaracteresProcessados = Arrays.stream(palavras)
                        .parallel()
                        .mapToInt(Main::processarPalavra)
                        .sum();

                long tempoFim = System.currentTimeMillis();

                long memoriaDepois = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                double memoriaUsada = (memoriaDepois - memoriaAntes) / (1024.0 * 1024.0); // MB

                tempoTotalExecucao += (tempoFim - inicioTempo);
                totalMemoriaUsada += memoriaUsada;

                System.out.println("Iteração " + i + ": Tempo = " + (tempoFim - inicioTempo) / 1000.0 + " s, Memória usada = " + memoriaUsada + " MB");
                System.out.println("Total de caracteres processados: " + totalCaracteresProcessados);
            }

            double tempoMedio = tempoTotalExecucao / 10;
            double memoriaMedia = totalMemoriaUsada / 10;

            System.out.println("Tempo médio de execução: " + tempoMedio / 1000.0 + " s");
            System.out.println("Memória média usada: " + memoriaMedia + " MB");
        }
    }

    private static String[] gerarPalavras(int contagem) {
        return Arrays.stream(new int[contagem])
                .mapToObj(i -> "Palavra" + i)
                .toArray(String[]::new);
    }

    private static int processarPalavra(String palavra) {
        // Removendo pontuação e convertendo para minúsculas
        String palavraLimpa = palavra.replaceAll("\\p{Punct}", "").toLowerCase();
        return palavraLimpa.length(); // Contando o número de caracteres
    }
}