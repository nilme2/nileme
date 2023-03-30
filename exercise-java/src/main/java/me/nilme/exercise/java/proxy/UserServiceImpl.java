package me.nilme.exercise.java.proxy;

/**
 * Created by nilme on 2020/4/15.
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("add");
    }
}
