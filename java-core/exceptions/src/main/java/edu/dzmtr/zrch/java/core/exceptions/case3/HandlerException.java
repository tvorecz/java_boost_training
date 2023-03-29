package edu.dzmtr.zrch.java.core.exceptions.case3;

/**
 * @author Dzmitry_Zorych
 */
public class HandlerException extends Exception {

    public HandlerException() {
    }

    public HandlerException(String message) {
        super(message);
    }

    public HandlerException(Throwable cause) {
        super(cause);
    }
}