package me.nilme.exercise.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author weizhuang
 * Created on 2019-04-22.
 */
@BenchmarkMode(Mode.AverageTime) // 测试方法平均执行时间
@OutputTimeUnit(TimeUnit.MILLISECONDS) // 输出结果的时间粒度为微秒
@State(Scope.Thread) // 每个测试线程一个实例
public class MainTest {


    @Benchmark
    public void mytest(){
        String idcard1 = "125725666999";
        String idcard2 = "125725666999";
//        ParseUtil.fuzzyMatch(idcard1, idcard2);//true
//        MatchUtils.wildcardMatch(idcard1, idcard2);

        System.out.println(TestData.data.size());

        ParseUtil.collectionDistinct(TestData.data);
    }

    public static void main(String[] args) throws RunnerException {
        // 使用一个单独进程执行测试，执行5遍warmup，然后执行5遍测试
        Options opt = new OptionsBuilder().include(MainTest.class.getSimpleName()).forks(1).warmupIterations(5)
                .measurementIterations(5).build();
        new Runner(opt).run();
    }


}
