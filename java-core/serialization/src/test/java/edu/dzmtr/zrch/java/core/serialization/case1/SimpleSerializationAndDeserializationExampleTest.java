package edu.dzmtr.zrch.java.core.serialization.case1;

import static edu.dzmtr.zrch.java.core.serialization.case1.SimpleSerializationAndDeserializationExample.deserializeExample;
import static edu.dzmtr.zrch.java.core.serialization.case1.SimpleSerializationAndDeserializationExample.serializeExample;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/**
 * Simple Serialization and Deserialization example
 *
 * @author Dzmitry_Zorych
 */
public class SimpleSerializationAndDeserializationExampleTest {

    @Test
    public void shouldSerializeAndDeserialize() throws IOException, ClassNotFoundException {
        serializeExample();
        Object[] results = deserializeExample();

        assertEquals(3, results.length);
        assertTrue(results[0] instanceof String);
        assertTrue(results[1] instanceof Date);
        assertEquals("Today", results[0]);
        assertEquals('a', results[2]);
    }
}