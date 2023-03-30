package me.nilme.exercise.java.io;

import java.nio.ByteBuffer;

/**
 * @author weizhuang
 * Created on 2019-09-29.
 */
public class ByteBufferTest {

    public static void main(String[] args) {
        System.out.println("---------test allocate--------");
        System.out.println("test allocate");
        System.out.println("before allocate:" + Runtime.getRuntime().freeMemory());
        System.out.println("max memory:" + Runtime.getRuntime().maxMemory());

        System.out.println("======================");


        ByteBuffer buffer = ByteBuffer.allocate(10240000);
        System.out.println("buffer=" + buffer);
        System.out.println("after allocate:" + Runtime.getRuntime().freeMemory());
        System.out.println("max memory:" + Runtime.getRuntime().maxMemory());

        System.out.println("======================");
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(10240000);
        System.out.println("dircetBuffer = " + directBuffer);
        System.out.println("after directBuffer:" + Runtime.getRuntime().freeMemory());


        System.out.println("---------test warp--------");
        byte[] bytes = new byte[32];
        ByteBuffer wrapBuffer = ByteBuffer.wrap(bytes);
        System.out.println(wrapBuffer);

        ByteBuffer wrapBuffer1 = ByteBuffer.wrap(bytes, 10, 10);
        System.out.println(wrapBuffer1);


    }
}
