package edu.dzmtr.zrch.java.core.serialization.case5;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class OneMoreParentClass {

    private String message;

    private int value;

    public OneMoreParentClass() {
    }

    public OneMoreParentClass(String message, int value) {
        this.message = message;
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public int getValue() {
        return value;
    }
}