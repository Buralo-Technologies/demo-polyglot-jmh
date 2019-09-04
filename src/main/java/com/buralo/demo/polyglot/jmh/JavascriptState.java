package com.buralo.demo.polyglot.jmh;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;

@State(Scope.Benchmark)
public class JavascriptState {
    @Param({"5", "10", "30"})
    public int n;

    private Context context;

    public Value function;

    @Setup(Level.Iteration)
    public void setUp() throws IOException {
        context = Context.create();
        Source source = Source.newBuilder("js", JavascriptState.class.getResource("fibonacci.js")).build();
        function = context.eval(source);
    }

    @TearDown(Level.Iteration)
    public void tearDow() {
        context.close();
    }
}
