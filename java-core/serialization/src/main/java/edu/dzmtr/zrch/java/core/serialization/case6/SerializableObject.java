package edu.dzmtr.zrch.java.core.serialization.case6;

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
public class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1640957473717547463L;

    private AnotherSerializableObject object;

    private String note;

    private transient Integer occurrence;

    public SerializableObject(AnotherSerializableObject object, String note, Integer occurrence) {
        this.object = object;
        this.note = note;
        this.occurrence = occurrence;
    }

    public AnotherSerializableObject getObject() {
        return object;
    }

    public String getNote() {
        return note;
    }

    public Integer getOccurrence() {
        return occurrence;
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeObject(occurrence);
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        this.occurrence = (Integer) inputStream.readObject();
    }

    private void readObjectNoData() throws ObjectStreamException {

    }
}