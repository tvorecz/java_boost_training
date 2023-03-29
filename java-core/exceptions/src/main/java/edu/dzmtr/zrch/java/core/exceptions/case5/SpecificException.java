package edu.dzmtr.zrch.java.core.exceptions.case5;

/**
 * @author Dzmitry_Zorych
 */
public class SpecificException extends CommonHandlerException {

    public SpecificException() {
    }

    public SpecificException(String message) {
        super(message);
    }

    public SpecificException(Throwable cause) {
        super(cause);
    }
}