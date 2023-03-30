package me.nilme.exercise.java.concurrent.hashmap;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by nilme on 2019/11/21.
 */
public class Test4 {
    static int count = 0;
    public static void main(String[] args) {
        float a = 0.1f;
        System.out.println(a);

        System.out.println(-5 % 2);

        long ts2 = System.currentTimeMillis();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();


        // 时间格式化①
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeFormat = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(timeFormat);  // output:2019-08-16 21:15:43
        // 时间格式化②
        String timeFormat2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(timeFormat2);    // output:2019-08-16 21:17:48

    }

}
