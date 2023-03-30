package me.nilme.exercise.java.base.singleton;

public class InstanceDemo {

    /**
     * 构造方法私有化
     */
    private InstanceDemo(){

    }

    /**
     * 返回实例
     * @return
     */
    public static InstanceDemo getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    /**
     * 使用枚举方法实现单利模式
     */
    private enum Singleton {
        INSTANCE;

        private InstanceDemo instance;

        /**
         * JVM保证这个方法绝对只调用一次
         */
        Singleton() {
            instance = new InstanceDemo();
        }

        public InstanceDemo getInstance() {
            return instance;
        }
    }
}
