package edu.dzmtr.zrch.java.core.serialization.case5;

import java.io.Serializable;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class ParentClass implements Serializable {
    private static final long serialVersionUID = -4096369859346600738L;
    private String message;

    private int value;

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
}