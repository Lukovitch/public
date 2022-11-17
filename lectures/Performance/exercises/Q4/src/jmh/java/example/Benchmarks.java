package example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(2)
@State(Scope.Benchmark)
public class Benchmarks {
    @Benchmark
    public void cacheBenchmark(Blackhole bh) {
        CSVReader reader = new CSVReader("res/students.txt", new StudentCache());
        for (int i = 0; i < 5; ++i) {
            bh.consume(reader.read(10));
        }
    }

    @Benchmark
    public void noCacheBenchmark(Blackhole bh) {
        CSVReader reader = new CSVReader("res/students.txt", new UselessCache<>());
        for (int i = 0; i < 5; ++i) {
            bh.consume(reader.read(10));
        }
    }

    @Benchmark
    public void sequentialBenchmark(Blackhole bh) {
        CSVReader reader = new CSVReader("res/students.txt", new UselessCache<>());
        List<Student> students = new ArrayList<>(reader.read(1000));
        for (int i = 0; i < 1000; ++i) {
            students.addAll(reader.read(1000));
        }
        bh.consume(students.stream().map(Student::getEmail).collect(Collectors.toList()));
    }

    @Benchmark
    public void parallelBenchmark(Blackhole bh) {
        CSVReader reader = new CSVReader("res/students.txt", new UselessCache<>());
        List<Student> students = new ArrayList<>(reader.read(1000));
        for (int i = 0; i < 1000; ++i) {
            students.addAll(reader.read(1000));
        }
        bh.consume(students.stream().parallel().map(Student::getEmail).collect(Collectors.toList()));
    }
}