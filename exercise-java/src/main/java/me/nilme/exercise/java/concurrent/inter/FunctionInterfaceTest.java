package me.nilme.exercise.java.concurrent.inter;

class FunctionInterfaceTest {
    public static void main(String[] args) {
        IAnimal animal = System.out::println;
        animal.sayHi("WangWang");
    }
}