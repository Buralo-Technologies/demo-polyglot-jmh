package com.buralo.demo.polyglot.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Fork(warmups = 1, value = 1)
@Warmup(iterations = 1)
@BenchmarkMode(value = Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 2)
public class PolyglotBenchmarks {
    private int doJavaFibonacci(final int n,
                            final int a,
                            final int b) {
        if (n == 0) return a;
        if (n == 1) return b;
        return doJavaFibonacci(n - 1, b, a + b);
    }

    @Benchmark
    public void javaFibonacci(JavaState state, Blackhole blackhole) {
        blackhole.consume(doJavaFibonacci(state.n, 0, 1));
    }

    @Benchmark
    public void javascriptFibonacci(JavascriptState state, Blackhole blackhole) {
        blackhole.consume(state.function.execute(state.n));
    }
}