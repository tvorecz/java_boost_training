package edu.dzmtr.zrch.java.core.serialization.case4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
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

    private transient String additionalInfo;

    public AnotherSerializableObject(String message, int round, int[] array, String additionalInfo) {
        this.message = message;
        this.round = round;
        this.array = array;
        this.additionalInfo = additionalInfo;
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

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {

    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {

    }

    private void readObjectNoData() throws ObjectStreamException {

    }
}