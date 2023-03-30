package me.nilme.exercise.jvm.memory;

/**
 * @author weizhuang
 * Created on 2019-05-20.
 * <p>
 * curl -L -O http://central.maven.org/maven2/org/openjdk/jol/jol-cli/0.9/jol-cli-0.9-full.jar
 * java -cp jol-cli-0.9-full.jar org.openjdk.jol.Main internals java.lang.String
 */
public class B extends A {
    long a = 100;
    int b;

    public B() {
        System.out.println("a=" + a);
    }
}
