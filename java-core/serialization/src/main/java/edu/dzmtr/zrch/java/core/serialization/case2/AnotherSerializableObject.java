package edu.dzmtr.zrch.java.core.serialization.case2;

import java.io.Serializable;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class AnotherSerializableObject implements Serializable {

    private static final long serialVersionUID = 8722273532636465834L;

    private String message;

    private int round;

    private transient int[] array;

    public AnotherSerializableObject(String message, int round, int[] array) {
        this.message = message;
        this.round = round;
        this.array = array;
    }

    public String getMessage() {
        return message;
    }

    public int getRound() {
        return round;
    }

    public int[] getArray() {
        return array;
    }
}