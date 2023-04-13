package edu.dzmtr.zrch.java.core.exceptions.case7;

import org.junit.Test;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class ClassLoadingExceptionsTest {

    @Test(expected = ClassNotFoundException.class)
    public void shouldThrowClassNotFoundException() throws ClassNotFoundException {
        ClassLoadingExceptions.loadClassByFullName();
    }

    @Test(expected = NoClassDefFoundError.class)
    public void shouldThrowNoClassDefFoundErrorWhileErrorsWithinClassInitialization() {
        ClassLoadingExceptions.userClassWithInitErrors();
    }
}