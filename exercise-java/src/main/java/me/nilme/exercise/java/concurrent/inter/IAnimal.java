package me.nilme.exercise.java.concurrent.inter;

@FunctionalInterface
interface IAnimal {
    static String animalName = "Animal Name";
    static void printSex() {
        System.out.println("Male Dog");
    }
    default void printAge() {
        System.out.println("18");
    }
    void sayHi(String name);
}