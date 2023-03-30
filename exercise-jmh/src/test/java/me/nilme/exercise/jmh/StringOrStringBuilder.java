package me.nilme.exercise.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime) // 测试方法平均执行时间
@OutputTimeUnit(TimeUnit.MICROSECONDS) // 输出结果的时间粒度为微秒
@State(Scope.Thread) // 每个测试线程一个实例
public class StringOrStringBuilder {
    private static Logger log = LoggerFactory.getLogger(StringOrStringBuilder.class);

    @Benchmark
    public String stringConcat() {
//        String str = this.doit("count", "sequenceId", "bizId");

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            str.append(i);
        }

        return str.toString();
    }

    public String doit(String count, String sequenceId, String bizId){
        String str = "预加载事件处理次数:" + count + ", 已达到预警阀值，请尽快查看处理!\n" +
                "sequenceId:" + sequenceId + ",\n" +
                "bizId:" + bizId + ",\n" +
                "时间:" + new Date();
        return str;
    }

    public static void main(String[] args) throws RunnerException {
        // 使用一个单独进程执行测试，执行5遍warmup，然后执行5遍测试
        Options opt = new OptionsBuilder().include(StringOrStringBuilder.class.getSimpleName()).forks(1).warmupIterations(5)
                .measurementIterations(5).build();
        new Runner(opt).run();
    }
}