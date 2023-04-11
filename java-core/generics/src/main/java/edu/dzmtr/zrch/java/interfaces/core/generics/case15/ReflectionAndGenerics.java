package edu.dzmtr.zrch.java.interfaces.core.generics.case15;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class ReflectionAndGenerics {

    public static void main(String[] args) {
        Class<Integer> ki = Integer.class;
        Number n = Integer.valueOf(42);
        Class<Number> kni = Number.class;
        Class<? extends Number> kn = n.getClass(); //for interface types used upper bound only
        //        Class<Number> knn = n.getClass(); //compilation error: capture of
        assert ki == kn;
    }
}