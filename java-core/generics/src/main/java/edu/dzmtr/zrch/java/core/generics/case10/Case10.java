package edu.dzmtr.zrch.java.core.generics.case10;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case10 {

    public static void main(String[] args) {
        List<Number> l1 = new ArrayList<>();
        List<Number> l2 = new ArrayList<>();
        l1.add(1);
        l2.add(2);

        foo(List.of());
        swapFirst(l1, l2);
    }

    public static void foo(List<?> i) {
        //        i.set(0, new Object()); //new Object() - java: incompatible types: java.lang.Object cannot be converted to capture#1 of ?
        //        i.set(0, i.get(0));//i.get(0) - java: incompatible types: java.lang.Object cannot be converted to capture#1 of ?
        // the actual problem here that List<?> can contain any type of values.
        // if we insert to the List<?> the reference of Object type it can lead to inconsistency because actual List<?> references may contain more specific type
    }

    public static void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
        Number temp = l1.get(0);
        //        l1.set(0, l2.get(0)); // java: incompatible types: java.lang.Number cannot be converted to capture#1 of ? extends java.lang.Number
        //        l2.set(0, temp);// java: incompatible types: java.lang.Number cannot be converted to capture#1 of ? extends java.lang.Number
    }
}