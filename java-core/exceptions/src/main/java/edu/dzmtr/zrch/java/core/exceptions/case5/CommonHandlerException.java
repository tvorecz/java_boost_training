package edu.dzmtr.zrch.java.core.exceptions.case5;

/**
 * @author Dzmitry_Zorych
 */
public class CommonHandlerException extends Exception {

    public CommonHandlerException() {
    }

    public CommonHandlerException(String message) {
        super(message);
    }

    public CommonHandlerException(Throwable cause) {
        super(cause);
    }
}