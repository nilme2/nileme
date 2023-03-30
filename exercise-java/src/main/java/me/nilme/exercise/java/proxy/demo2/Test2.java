package me.nilme.exercise.java.proxy.demo2;

/**
 * Created by weizhuang on 2019-03-29.
 */
public class Test2 {
    public static void main(String[] args) {

        ElectricCar car = new ElectricCar();

        ProxyUtils.generateClassFile(car.getClass(), "ElectricCarProxy");
    }
}
