package me.nilme.exercise.java.proxy.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by nilme on 2020/4/21.
 */
public class ParallelStreamTest {

    public static void main(String[] args) {
        List<Long> aList = new ArrayList<>();
        Stream<Long> parallelStream = aList.parallelStream();
    }

    public static void main2(String[] args) throws InterruptedException, ExecutionException {
        long firstNum = 1;
        long lastNum = 1_000_000;

        List<Long> aList = LongStream.rangeClosed(firstNum, lastNum).boxed()
                .collect(Collectors.toList());

        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        long actualTotal = customThreadPool.submit(
                () -> aList.parallelStream().reduce(0L, Long::sum)).get();

    }
}
