package edu.dzmtr.zrch.java.core.serialization.case4;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class ParentClass {

    private String message;

    private int value;

    public ParentClass() {
    }

    public ParentClass(String message, int value) {
        this.message = message;
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public int getValue() {
        return value;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setValue(int value) {
        this.value = value;
    }
}