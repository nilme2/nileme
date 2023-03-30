package me.nilme.exercise.java.proxy.doublemetch.jdk;

class Cat implements Animal {

    private Object targte;

    public Object getTargte() {
        return targte;
    }

    public void setTargte(Object targte) {
        this.targte = targte;
    }

    @Override
    public void eat() {
        System.out.println("The cat is eating");
        ((Animal)targte).run();//测试嵌套调用
    }

    @Override
    public void run() {
        System.out.println("The cat is running");
    }
}