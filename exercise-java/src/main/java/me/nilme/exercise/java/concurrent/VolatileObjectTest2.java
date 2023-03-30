package me.nilme.exercise.java.concurrent;

/**
 * @author weizhuang
 * Created on 2019-05-16.
 */
public class VolatileObjectTest2 implements Runnable {
    private volatile ObjectA a; // 加上volatile 就可以正常结束While循环了

    public VolatileObjectTest2(ObjectA a) {
        this.a = a;
    }

    public ObjectA getA() {
        return a;
    }

    public void setA(ObjectA a) {
        this.a = a;
    }

    @Override
    public void run() {
        long i = 0;
        while (a.isFlag()) {
            i++;
        }
        System.out.println("stop My Thread " + i);
    }

    public void stop() {
        a.setFlag(false);
    }

    public static void main(String[] args) throws InterruptedException {
        // 如果启动的时候加上-server 参数则会 输出 Java HotSpot(TM) Server VM
        System.out.println(System.getProperty("java.vm.name"));

        ObjectA objectA = new ObjectA();

        VolatileObjectTest2 test = new VolatileObjectTest2(objectA);
        new Thread(test).start();

        Thread.sleep(1000);
        test.stop();
        Thread.sleep(1000);
        System.out.println("Main Thread " + test.getA().isFlag());
    }

}

