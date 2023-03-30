/**
 * Olymtech.com Inc.
 * Copyright (c) 2002-2015 All Rights Reserved
 */
package me.nilme.exercise.java.action.exception;

/**
 * @author taoshanchang 15/11/23
 */
public class ActionNullException extends RuntimeException {

    public ActionNullException() {
        super();
    }

    public ActionNullException(String message) {
        super(message);
    }


    public ActionNullException(Throwable cause) {
        super(cause);
    }

    public ActionNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
