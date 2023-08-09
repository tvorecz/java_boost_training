package edu.dzmtr.zrch.java.core.serialization.case4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

import org.junit.Test;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class SerializableOverriddenBehaviorTest {
    public static final String PATH = "C:\\Users\\Dzmitry_Zorych\\Downloads\\tmp4";

    @Test
    public void shouldSerializeAndDeserializeTransientFieldExplicitlyHandledWithinWriteObjectMethod()
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

        assertNull(result.getObject()); //not handled within writeObject
        assertNull(result.getNote()); //not handled with writeObject
        assertEquals(Integer.valueOf(1),
            result.getOccurrence()); //transitive but saved within writeObject() method and restored in readObject() method
    }

    @Test
    public void shouldSkipSerializationForAllFieldsIfNoLogicInWriteObjectMethod()
        throws IOException, ClassNotFoundException {
        AnotherSerializableObject anotherSerializableObject = new AnotherSerializableObject("mmmmmmmmm", 1,
            new int[] { 0, -1, -2 }, "additional info");

        FileOutputStream fileOutputStream = new FileOutputStream(PATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(anotherSerializableObject);
        objectOutputStream.flush();

        fileOutputStream.close();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(PATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();

        fileInputStream.close();
        objectInputStream.close();

        assertTrue(o instanceof AnotherSerializableObject);
        AnotherSerializableObject result = (AnotherSerializableObject) o;

        assertNull(result.getAdditionalInfo()); //not handled within writeObject
        assertNull(result.getMessage()); //not handled with writeObject
        assertNull(result.getArray()); //not handled with writeObject
        assertEquals(0, result.getRound()); //not handled with writeObject, gets default value for primitive types
    }

    @Test
    public void shouldSerializeAndDeserializeNonSerializableParentClassFieldsByExplicitHandlingWithinWriteObjectMethodInChildObject()
        throws IOException, ClassNotFoundException {
        ChildClass serializableObject = new ChildClass("message", 2, BigDecimal.valueOf(11.11));

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

        assertTrue(o instanceof ChildClass);
        ChildClass result = (ChildClass) o;

        assertEquals("message",
            result.getMessage()); //handled within writeObject using public getter and setter from parent class
        assertEquals(2,
            result.getValue()); //handled within writeObject using public setter and setter from parent class
        assertNull(result.getMoney()); //not handled within writeObject
    }
}