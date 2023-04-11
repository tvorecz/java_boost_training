package edu.dzmtr.zrch.java.interfaces.core.generics.case15;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case16 {

    public static void main(String[] args) {
        List<String> string = new ArrayList<>();
        List<CharSequence> cs = new ArrayList<>();

        System.out.println(string.getClass().getTypeName());
        System.out.println(cs.getClass().getTypeName());
        System.out.println(string.getClass().getTypeParameters()[0]);
        System.out.println(cs.getClass().getTypeParameters()[0]);
        System.out.println(string.getClass().getGenericSuperclass().getTypeName());
        System.out.println(cs.getClass().getGenericSuperclass().getTypeName());
        System.out.println(string.getClass().getGenericInterfaces()[0]);
        System.out.println(cs.getClass().getGenericInterfaces()[0]);

        System.out.println(string.getClass().equals(cs.getClass()));

        // result
        // java.util.ArrayList
        //java.util.ArrayList
        //E
        //E
        //java.util.AbstractList<E>
        //java.util.AbstractList<E>
        //java.util.List<E>
        //java.util.List<E>
        //true
    }
}