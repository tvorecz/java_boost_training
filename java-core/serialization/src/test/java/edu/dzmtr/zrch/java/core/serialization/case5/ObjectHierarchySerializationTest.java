package edu.dzmtr.zrch.java.core.serialization.case5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

import org.junit.Test;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class ObjectHierarchySerializationTest {
    public static final String PATH = "C:\\Users\\Dzmitry_Zorych\\Downloads\\tmp5";

    @Test
    public void shouldSerializeTheWholeHierarchyOfObjectIfAllClassesAreSerializable()
        throws IOException, ClassNotFoundException {

        ChildClass serializableObject = new ChildClass("message", 1, BigDecimal.valueOf(10.1));

        FileOutputStream fileOutputStream = new FileOutputStream(PATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(serializableObject);
        objectOutputStream.flush();

        fileOutputStream.close();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(PATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();

        assertTrue(o instanceof ChildClass);

        ChildClass result = (ChildClass) o;

        assertEquals("message", result.getMessage());
        assertEquals(1, result.getValue());
        assertEquals(BigDecimal.valueOf(10.1), result.getMoney());
    }

    @Test(expected = InvalidClassException.class)
    public void shouldThrowExceptionDueToAbsenceOfDefaultConstructorInParentNonSerializableClass()
        throws IOException, ClassNotFoundException {

        AnotherChildCLass serializableObject = new AnotherChildCLass("message", 1, BigDecimal.valueOf(10.1));

        FileOutputStream fileOutputStream = new FileOutputStream(PATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(serializableObject);
        objectOutputStream.flush();

        fileOutputStream.close();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(PATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject(); //java.io.InvalidClassException: edu.dzmtr.zrch.java.core.serialization.case5.AnotherChildCLass; no valid constructor
    }

    @Test
    public void shouldSerializeAndDeserializeOnlyChildSerializableClassWithDefaultConstructorInParentNonSerializableClass()
        throws IOException, ClassNotFoundException {

        OneMoreChildClass serializableObject = new OneMoreChildClass("message", 1, BigDecimal.valueOf(10.1));

        FileOutputStream fileOutputStream = new FileOutputStream(PATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(serializableObject);
        objectOutputStream.flush();

        fileOutputStream.close();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(PATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();

        assertTrue(o instanceof OneMoreChildClass);

        OneMoreChildClass result = (OneMoreChildClass) o;

        assertNull(result.getMessage()); //parent part is empty
        assertEquals(0, result.getValue()); //parent part has default value
        assertEquals(BigDecimal.valueOf(10.1), result.getMoney());
    }

}