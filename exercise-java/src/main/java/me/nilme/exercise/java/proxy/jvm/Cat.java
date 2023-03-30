package me.nilme.exercise.java.proxy.jvm;

class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("The cat is eating");
    }
}