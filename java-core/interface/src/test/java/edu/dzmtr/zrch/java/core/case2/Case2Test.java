package edu.dzmtr.zrch.java.core.case2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.dzmtr.zrch.java.interfaces.core.case2.A;
import edu.dzmtr.zrch.java.interfaces.core.case2.B;
import edu.dzmtr.zrch.java.interfaces.core.case2.C;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case2Test {

    @Test
    public void shouldCallAllMethods() {
        assertEquals("A: static String and private static method",
            A.value("1", "2")); //public static method called only on initial Interface type name
        assertEquals("B: static String and private static method",
            B.value("1", "2")); //public static method called only on initial Interface type name
        //        assertEquals(2, C.value("1", "2")); //compile error - static method belongs to initial interface only
        assertEquals("A: default String and private instance method", new ATest().value()); //class in not override interface default method, so it will be called here

        assertEquals("B: default String and private instance method", new C().value());
        assertEquals("C: public String child method", new C().value("1"));
    }

    private class ATest implements A {

    }
}