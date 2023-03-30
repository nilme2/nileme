/**
 * Olymtech.com Inc.
 * Copyright (c) 2002-2015 All Rights Reserved
 */
package me.nilme.exercise.java.action;


/**
 * Created by taoshanchang on 15/11/4.
 */
public interface Action {

    /**
     * 发布动作
     *
     * @param event
     * @return
     * @throws Exception
     */
    public boolean doAction(Event event) throws Exception;

    /**
     * 发布动作失败后执行动作
     *
     * @param event
     * @throws Exception
     */
    public void doFailure(Event event) throws Exception;

    public void setObserver(Observer observer);

    /**
     * your action's name
     *
     * @return
     */
    public String getActionName();


}
