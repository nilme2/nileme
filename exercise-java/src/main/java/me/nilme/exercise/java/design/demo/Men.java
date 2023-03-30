package me.nilme.exercise.java.design.demo;

public class Men {
    public String name;       // 姓名
    public boolean married;    // 是否已婚
    public int cars;       // 拥有车的数量
    public int houses;     // 拥有房子的数量

    public Men(String name, int cars, int houses, boolean married) {
        this.name = name;
        this.cars = cars;
        this.houses = houses;
        this.married = married;
    }
}