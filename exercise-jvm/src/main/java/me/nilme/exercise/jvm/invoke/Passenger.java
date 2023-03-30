package me.nilme.exercise.jvm.invoke;


//// Run with: java -XX:CompileCommand='dontinline,*. goout' Passenger
abstract class Passenger {
    abstract void goout();

    @Override
    public String toString() {
        return "我是乘客";
    }

    public static void main(String[] args) {
        Passenger a = new Foreigner();
        Passenger b = new Foreigner();
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            Passenger c = (i < 1_000_000_000) ? a : b;
            c.goout();
        }
    }
}



