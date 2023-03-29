package edu.dzmtr.zrch.java.core.exceptions.case3;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dzmitry_Zorych
 */
public class Case3Test {

    @Test
    public void shouldSuppressException() {
        try {
            Case3.handle();
        } catch (Exception e) {
            Assert.assertEquals(HandlerException.class, e.getClass());
            Assert.assertEquals(1, e.getSuppressed().length);
            Assert.assertEquals(IOException.class, e.getSuppressed()[0].getClass());
        }
    }

    @Test
    public void shouldSuppressExceptionInTryWithResources() {
        try {
            Case3.handleWithResources();
        } catch (Exception e) {
            Assert.assertEquals(HandlerException.class, e.getClass());
            Assert.assertEquals(1, e.getSuppressed().length);
            Assert.assertEquals(IOException.class, e.getSuppressed()[0].getClass());
        }
    }

}