package edu.dzmtr.zrch.java.core.generics.case3;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case3 {

    static <T> T handle(T a1, T a2) {
        return a1;
    }

    public static void main(String[] args) {
        Serializable s = Case3.handle("d", new ArrayList<>());
        //        Serializable s = Case3.<>pick("d", new ArrayList<>()); //diamond will cause compilation error
        System.out.println(s);
    }

}