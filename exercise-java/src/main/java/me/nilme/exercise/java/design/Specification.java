package me.nilme.exercise.java.design;

public interface Specification {
    boolean isSatisfiedBy(Object params);

    Specification and(Specification other);

    Specification or(Specification other);

    Specification not();
}