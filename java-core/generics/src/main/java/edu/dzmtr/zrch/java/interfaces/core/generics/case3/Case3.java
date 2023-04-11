package edu.dzmtr.zrch.java.interfaces.core.generics.case3;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case3 {

    static <T> T pick(T a1, T a2) {
        return a1;
    }

    public static void main(String[] args) {
        Serializable s = Case3.pick("d", new ArrayList<>());
        //        Serializable s = Case3.<>pick("d", new ArrayList<>()); //diamond will cause compilation error
        System.out.println(s);
    }

}