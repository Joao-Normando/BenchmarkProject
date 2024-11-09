import org.example.ContadorPalavras;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ContadorPalavras.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
