package com.buralo.demo.polyglot.jmh;

import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class JavaState {
    @Param({"5", "10", "30"})
    public int n;
}
