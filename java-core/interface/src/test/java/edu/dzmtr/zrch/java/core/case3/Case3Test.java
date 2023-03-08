package edu.dzmtr.zrch.java.core.case3;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dzmitry_Zorych
 */
public class Case3Test {

    private SimpleHandlerClient testObject = new SimpleHandlerClient();

    @Test
    public void shouldSuccessfullyExecuteAllLambdaCalls() {
        Object input = new Object();

        assertEquals(input, testObject.executeSimpleHandling(input, o -> o));
        assertEquals(input, testObject.executeFirstSimpleHandling(input, o -> o));
        assertEquals(input.toString(), testObject.executeSecondSimpleHandling(input, Object::toString));
        assertEquals(input, testObject.executeThirdSimpleHandling(input, o -> o));
        assertEquals(input, testObject.executeFourthSimpleHandling(input, o -> o));
    }
}