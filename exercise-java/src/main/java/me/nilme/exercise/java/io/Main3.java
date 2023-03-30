package me.nilme.exercise.java.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author weizhuang
 * Created on 2019-09-27.
 */
public class Main3 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("/Users/weizhuang/workspace/github/exercise-book/exercise-io/src/main/java/me/nilme/exercise/io/ExerciseIoApplication.java",
                "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("/Users/weizhuang/workspace/github/exercise-book/exercise-io/src/main/java/me/nilme/exercise/io/ExerciseIoApplicationTests2.java",
                "rw");
        FileChannel toChannel = toFile.getChannel();

        long positon = 0;
        long count = fromChannel.size();


//        long res = fromChannel.transferTo(positon, count, toChannel);
        toChannel.transferFrom(fromChannel, positon, count);

        fromFile.close();
        toFile.close();
    }
}
