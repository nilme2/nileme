package me.nilme.exercise.java.action;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by nil on 2021/11/27.
 */
@Slf4j
public class Action1 implements Action {
    @Override
    public boolean doAction(Event event) throws Exception {
        log.info("Action1 doAction");
        return true;
    }

    @Override
    public void doFailure(Event event) throws Exception {
        log.info("Action1 doFailure");
    }

    @Override
    public void setObserver(Observer observer) {

    }

    @Override
    public String getActionName() {
        return "Action1";
    }
}
