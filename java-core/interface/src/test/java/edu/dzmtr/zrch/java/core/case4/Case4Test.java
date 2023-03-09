package edu.dzmtr.zrch.java.core.case4;

import org.junit.Assert;
import org.junit.Test;

import edu.dzmtr.zrch.java.interfaces.core.case4.ChildOverloadedFuncHandlerClient;

/**
 * @author Dzmitry_Zorych
 */
public class Case4Test {

    private ChildOverloadedFuncHandlerClient testObject = new ChildOverloadedFuncHandlerClient();

    @Test
    public void shouldHandle() {
        Assert.assertEquals("word", testObject.handle("WORD", String::toLowerCase));
    }
}