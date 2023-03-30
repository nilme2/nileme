package me.nilme.exercise.java.action;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by nil on 2021/11/27.
 */
@Slf4j
public class Action2 implements Action {
    @Override
    public boolean doAction(Event event) throws Exception {
        log.info("Action2 doAction");
        return true;
    }

    @Override
    public void doFailure(Event event) throws Exception {
        log.info("Action2 doFailure");
        throw new RuntimeException("xxxx");
    }

    @Override
    public void setObserver(Observer observer) {

    }

    @Override
    public String getActionName() {
        return "Action2";
    }
}
