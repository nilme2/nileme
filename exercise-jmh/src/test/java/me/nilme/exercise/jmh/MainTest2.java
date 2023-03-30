package me.nilme.exercise.jmh;

/**
 * @author weizhuang
 * Created on 2019-04-22.
 */
public class MainTest2 {

    public void hrll(String str){
        str = str + "change";
        System.out.println(str);
    }

    public static void main(String[] args) {
        MainTest2 mainTest2 = new MainTest2();

        String url = "source";

        mainTest2.hrll(url);

        System.out.println(url);

    }
}
