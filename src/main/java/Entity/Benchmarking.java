package Entity;

public class Benchmarking {
    public static void main(String[] args) throws Exception {
        var options = new org.openjdk.jmh.runner.options.OptionsBuilder()
                .include(StringConcatenationBenchmark.class.getSimpleName())
                .forks(1)
                .build();
        new org.openjdk.jmh.runner.Runner(options).run();


    }
}
