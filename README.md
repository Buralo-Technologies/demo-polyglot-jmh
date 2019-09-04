# GraalVM Polyglot Benchmarks

This code is a simple benchmark to compare Java and polyglot Javascript.

Build and run the benchmarks by executing the following commands:

```
# sdk use java 19.2.0-grl
# mvn clean install
# java -jar target/demo-polyglot-jmh-1.0.0.jar
``` 

As expected the results show that performance is not great with Javascript

```
Benchmark                               (n)  Mode  Cnt    Score   Error  Units
PolyglotBenchmarks.javaFibonacci          5  avgt    2    2.744          ns/op
PolyglotBenchmarks.javaFibonacci         10  avgt    2    2.998          ns/op
PolyglotBenchmarks.javaFibonacci         30  avgt    2    9.465          ns/op
PolyglotBenchmarks.javascriptFibonacci    5  avgt    2   28.850          ns/op
PolyglotBenchmarks.javascriptFibonacci   10  avgt    2   52.562          ns/op
PolyglotBenchmarks.javascriptFibonacci   30  avgt    2  137.016          ns/op
```