package edu.dzmtr.zrch.java.core.generics.case6;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case6 {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        print(ints);

    }

    //all these methods have the same erasure, however List<Object> do not accept, for example, List<Integer>. But other three methods accept it.

    public static void print(List<?> elements) {
        System.out.println(elements);
    }
    //
    //    public static void print(List<? extends Object> elements) {
    //        System.out.println(elements);
    //    }

    //    public static void print(List elements) {
    //        System.out.println(elements);
    //    }

    //    public static void print(List<Object> elements) {
    //        System.out.println(elements);
    //    }
}