package edu.dzmtr.zrch.java.core.serialization.case6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
public class SerializableOverriddenBehaviorWithDefaultStreamMethodCallingTest {

    public static final String PATH = "C:\\Users\\Dzmitry_Zorych\\Downloads\\tmp6";

    @Test
    public void shouldSerializeAndDeserializeDefaultSerializableFieldsAlongWithOverriddenSerializationLogic()
        throws IOException, ClassNotFoundException {
        AnotherSerializableObject anotherSerializableObject = new AnotherSerializableObject("mmmmmmmmm", 1,
            new int[] { 0, -1, -2 }, "additional info");
        SerializableObject serializableObject = new SerializableObject(anotherSerializableObject, "nnnnnnn", 1);

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

        assertNotNull(
            result.getObject()); //handled by outputStream.defaultWriteObject() and inputStream.defaultReadObject()
        assertEquals("nnnnnnn",
            result.getNote()); //handled by outputStream.defaultWriteObject() and inputStream.defaultReadObject()
        assertEquals(Integer.valueOf(1),
            result.getOccurrence()); //transitive but saved explicitly within writeObject() method and restored in readObject() method
        assertEquals(1,
            result.getObject()
                .getRound()); //handled by outputStream.defaultWriteObject() and inputStream.defaultReadObject()
        assertEquals("mmmmmmmmm",
            result.getObject()
                .getMessage()); //handled by outputStream.defaultWriteObject() and inputStream.defaultReadObject()
        assertNull(result.getObject().getArray()); //no explicit handling is added
        assertNull(result.getObject().getAdditionalInfo()); //no explicit handling is added
    }
}