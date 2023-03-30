package me.nilme.exercise.java.concurrent.visualvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MakeVmAbort {

    static List<Thread> ts = new ArrayList<>();

    static List<byte[]> bs = new ArrayList<>();

    // -Xmx50M -Xms50M -XX:ErrorFile=/Users/nilme/temp/log/javacode/java_error.log
    // -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -Xloggc:/Users/nilme/temp/log/javacode/gc.log
    public static void main(String[] args) {

        try {
            while (true) {
                Thread t = new Thread(() -> {
                    while (true) {
                        bs.add(new byte[1024 * 1024]);
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
                ts.add(t);
            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

}