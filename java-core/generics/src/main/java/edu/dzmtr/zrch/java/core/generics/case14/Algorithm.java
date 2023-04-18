package edu.dzmtr.zrch.java.core.generics.case14;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Algorithm {
    public static <T> T max(T x, T y) {
        //        return x > y ? x : y; //we cannot use > operator with objects and generics cannot be a primitive types
        return x;
    }

}