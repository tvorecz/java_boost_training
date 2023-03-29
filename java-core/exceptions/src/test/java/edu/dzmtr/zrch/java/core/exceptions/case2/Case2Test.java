package edu.dzmtr.zrch.java.core.exceptions.case2;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/**
 * @author Dzmitry_Zorych
 */
public class Case2Test {

    @Test(expected = IOException.class)
    public void shouldThrowException() throws IOException {
        Case2.readFile(new File("file"));
    }

    @Test
    public void shouldThrowExceptionWithSuppressed() {
        try {
            Case2.readFile(new File("file"));
        } catch (IOException e) {
            assertEquals(FileNotFoundException.class, e.getClass());
            assertEquals(0, e.getSuppressed().length);
        }
    }
}