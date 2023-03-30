package me.nilme.exercise.java.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author weizhuang
 * Created on 2019-09-27.
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("/Users/weizhuang/workspace/github/exercise-book/exercise-io/src/test/java/me/nilme/exercise/io/ExerciseIoApplicationTests.java",
                "rw");

        FileChannel channel = aFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(48);

        int read = channel.read(buffer);
        while(read != -1){

            System.out.println("Read" + read);
            buffer.flip();

            while (buffer.hasRemaining()){
                System.out.println((char)buffer.get());
            }
            buffer.clear();
            read = channel.read(buffer);
        }

        aFile.close();
    }
}
