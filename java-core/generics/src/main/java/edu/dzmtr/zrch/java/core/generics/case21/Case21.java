package edu.dzmtr.zrch.java.core.generics.case21;

import java.util.ArrayList;
import java.util.List;

/**
 * Regular Arrays and Generic cases
 *
 * @author Dzmitry_Zorych
 */
public class Case21 {

    public static void handle1() {
        List<?>[] lsa = new List<?>[10]; // ok, array of unbounded wildcard type
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<>();
        li.add(Integer.valueOf(3));
        oa[1] = li; // correct
        String s = (String) lsa[1].get(0); // run time error, but cast is explicit
    }

    public static void handle2() {
        List<String>[] lsa = (List<String>[]) new List<?>[10]; //warning: [unchecked] unchecked cast
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<>();
        li.add(Integer.valueOf(3));
        oa[1] = li; // correct
        String s = lsa[1].get(0); // run time error, but we were warned
    }
}