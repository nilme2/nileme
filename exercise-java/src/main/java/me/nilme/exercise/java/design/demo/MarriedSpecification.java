package me.nilme.exercise.java.design.demo;


import me.nilme.exercise.java.design.CompositeSpecification;

// 已婚
public class MarriedSpecification extends CompositeSpecification {

      @Override
      public boolean isSatisfiedBy(Object params) {
            Men m = (Men)params;
            return m.married;
      }
}