package edu.dzmtr.zrch.java.core.generics.case7;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case7 {

    public static void main(String[] args) {
        insert();
    }

    public static void insert() {

        List<?> listOfAny = new ArrayList<>();
        //        listOfAny.add(Integer.valueOf(1));// compilation error
        listOfAny.add(null);//ok

        List<Object> listOfObjects = new ArrayList<>();
        listOfObjects.add(Integer.valueOf(1));
        listOfObjects.add(null);
        listOfObjects.add("");

        List<? extends Object> listOfAnyObjects = new ArrayList<>();
        //        listOfAnyObjects.add(Integer.valueOf(1));// compilation error
        listOfAnyObjects.add(null);
        //        listOfAnyObjects.add("");// compilation error

        List objects = new ArrayList<>();
        objects.add(Integer.valueOf(1));
        objects.add(null);
        objects.add("");

        Node<?> node = new Node<>();
        //        node.setField(Integer.valueOf(1)); // compilation error
        node.setField(null);//ok

        Node<? extends Number> node2 = new Node<>();
        node2.setField(null); //ok
        //        node2.setField(Integer.valueOf(1));// compilation error

    }
}