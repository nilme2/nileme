package me.nilme.exercise.java.design.demo;


import me.nilme.exercise.java.design.Specification;

/**
 * @author weizhuang
 * Created on 2019-04-11.
 */
public class MainTest {


    public static void main(String[] args) {
        Men[] candidates = {
                new Men("李精英", 1, 1, false),
                new Men("王老五", 5, 3, true),
                new Men("赵白领", 0, 1, false),
                new Men("West_Link", 0, 0, false)
        };

        HasHousesSpecification hasHouse = new HasHousesSpecification();
        HasCarsSpecification hasCar = new HasCarsSpecification();
        MarriedSpecification married = new MarriedSpecification();

        Specification spec = hasHouse.and(hasCar).and(married.not()).and(married.not());
        for (Men men : candidates) {
            if(spec.isSatisfiedBy(men))
                System.out.println(men.name);
        }
    }
}
