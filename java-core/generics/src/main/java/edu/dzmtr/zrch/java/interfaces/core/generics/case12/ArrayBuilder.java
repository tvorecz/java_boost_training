package edu.dzmtr.zrch.java.interfaces.core.generics.case12;

import java.util.Arrays;
import java.util.List;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class ArrayBuilder {

    public static <T> void addToList(List<T> listArg,
                                     T... elements) { //Possible heap pollution from parameterized vararg type T
        for (T x : elements) {
            listArg.add(x);
        }
    }

    public static void faultyMethod(
        List<String>... l) { //Possible heap pollution from parameterized vararg type List<String>
        Object[] objectArray = l;     // Valid, heap pollution occurs
        objectArray[0] = Arrays.asList(42);  //compiler cannot check it
        String s = l[0].get(0);       // ClassCastException thrown here
    }

}