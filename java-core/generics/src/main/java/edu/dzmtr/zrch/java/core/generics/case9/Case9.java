package edu.dzmtr.zrch.java.core.generics.case9;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case9 {

    public static void main(String[] args) {
        List<?> anyObjectList = new ArrayList<>();

        List<? super Integer> superIntegerList = new ArrayList<>();

        List<? super Number> superNumberList = new ArrayList<>();

        List<Number> numberList = new ArrayList<>();

        List<Integer> integerList = new ArrayList<>();

        List<? extends Number> extendsNumberList = new ArrayList<>();

        List<? extends Integer> extendsIntegerList = new ArrayList<>();

        anyObjectList = extendsIntegerList;

        extendsIntegerList = (List<? extends Integer>) anyObjectList; //only explicit casting

        //        extendsIntegerList = (List<? extends Integer>)  superNumberList; //compile error since List<? extends Integer> and List<? super Number> are not subtypes of each otherc
    }
}