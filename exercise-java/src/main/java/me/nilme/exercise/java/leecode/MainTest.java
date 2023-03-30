package me.nilme.exercise.java.leecode;

import java.util.concurrent.*;

/**
 * Created by nilme on 2020/3/16.
 */
public class MainTest {

    public static void main(String[] args) {
        Work work1 = new Work("work1");
        Work work2 = new Work("work2");
        Work work3 = new Work("work3");
        Work work4 = new Work("work4");

        work1.next = work2;
        work2.next = work3;
        work3.next = work4;

        boolean isdag = isdag(work1);

        if (!isdag) {
            System.out.println("任务成环！！！！");
            return ;
        }

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                new ThreadPoolExecutor.CallerRunsPolicy());

        Work work = work1;
        while (work != null){
            Future<?> result = executor.submit(work);
            try {
                System.out.println(result.get());
                work = work.next;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

    private static boolean isdag(Work work1) {
        Work pointer1 = work1;
        Work pointer2 = work1;

        while (pointer1.next != null && pointer2.next.next != null) {
            if (pointer1.next == pointer2.next.next) {
                return false;
            }
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;

        }
        return true;
    }

    private static class Work implements Callable {
        String name;
        Work next;

        public Work(String name) {
            this.name = name;
        }

        @Override
        public Object call() throws Exception {
            return name + "工作完成";
        }
    }
}
