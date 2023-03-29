package edu.dzmtr.zrch.java.core.exceptions.case6;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dzmitry_Zorych
 */
public class Case6Test {

    @Test
    public void objectShouldBeCreatedIfExceptionCaughtInsideConstructor() {
        Pet pet = new Pet(null);

        Assert.assertNotEquals(null, pet);
    }

    @Test
    public void objectShouldNotBeCreatedIfExceptionCaughtOutsideConstructor() {
        File file = null;
        
        try {
            file = new File((String) null);
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        Assert.assertEquals(null, file);
    }
}