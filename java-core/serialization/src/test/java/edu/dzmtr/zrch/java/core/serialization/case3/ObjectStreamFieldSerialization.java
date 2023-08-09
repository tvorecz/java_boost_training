package edu.dzmtr.zrch.java.core.serialization.case3;

import static edu.dzmtr.zrch.java.core.serialization.case3.SimpleEnum.FIRST;
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
 * Overriding of default behavior for field serialization. Only enumerated in ObjectStreamField array fields will be serialized and deserialized.
 *
 * @author Dzmitry_Zorych
 */
public class ObjectStreamFieldSerialization {

    public static final String PATH = "C:\\Users\\Dzmitry_Zorych\\Downloads\\tmp3";

    @Test
    public void shouldSkipFieldsThatNotPlacedToObjectStreamFieldArray() throws IOException, ClassNotFoundException {
        AnotherSerializableObject anotherSerializableObject = new AnotherSerializableObject("mmmmmmmmm", 1,
            new int[] { 0, -1, -2 });
        SerializableObject serializableObject = new SerializableObject(anotherSerializableObject, "nnnnnnn",
            FIRST, 1);

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
        assertNull(result.getOccurrence()); //not included to serialPersistentFields
        assertEquals("nnnnnnn", result.getNote());
        assertNull(result.getOrder()); //not included to serialPersistentFields

    }
}