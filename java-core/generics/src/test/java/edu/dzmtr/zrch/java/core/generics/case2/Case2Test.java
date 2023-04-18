package edu.dzmtr.zrch.java.core.generics.case2;

import org.junit.Test;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case2Test {

    @Test(expected = ClassCastException.class)
    public void shouldProduceException() {
        Case2.main(new String[1]);
    }
}