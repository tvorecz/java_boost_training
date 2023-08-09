package edu.dzmtr.zrch.java.core.serialization.case2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class CustomObjectsSerializationAndDeserializationExample {
    public static final String PATH = "C:\\Users\\Dzmitry_Zorych\\Downloads\\tmp2";

    @Test
    public void shouldSerializeAndDeserializeCustomObject() throws IOException, ClassNotFoundException {
        AnotherSerializableObject anotherSerializableObject = new AnotherSerializableObject("mmmmmmmmm", 1,
            new int[] { 0, -1, -2 });
        SerializableObject serializableObject = new SerializableObject(anotherSerializableObject, "nnnnnnn",
            SimpleEnum.FIRST, 1);

        FileOutputStream fileOutputStream = new FileOutputStream(PATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(serializableObject);
        objectOutputStream.flush();

        fileOutputStream.close();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(PATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();

        fileInputStream.close();
        objectInputStream.close();

        assertTrue(o instanceof SerializableObject);
        SerializableObject result = (SerializableObject) o;

        assertEquals("mmmmmmmmm", result.getObject().getMessage());
        assertEquals(1, result.getObject().getRound());
        assertNull(result.getObject().getArray()); //transient field
        assertEquals(Integer.valueOf(1), result.getOccurrence());
        assertEquals("nnnnnnn", result.getNote());
        assertEquals(SimpleEnum.FIRST, result.getOrder());

    }
}