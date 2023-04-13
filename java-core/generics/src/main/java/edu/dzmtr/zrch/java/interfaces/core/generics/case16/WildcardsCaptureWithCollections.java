package edu.dzmtr.zrch.java.interfaces.core.generics.case16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class WildcardsCaptureWithCollections {

    public static void main(String[] args) {
        List<?> unknownList = new ArrayList<>();
        //        addToList(unknownList,
        //            "abc"); //Compiler error: cannot infer the T type because List<?> may contain any type, so compiler cannot ensure List<?> will actually contain String
        //        WildcardsCaptureWithCollections.<String>addToList(unknownList,
        //            "abc");// Compiler error: the same here even with type witness
        addToList((List<String>) unknownList, "abc"); //works with unchecked forcing cast

        Set<?> unknownSet = new HashSet<>();
        //        addToSet(unknownSet,
        //            "abc"); //Compiler error: cannot infer the T type because List<?> may contain any type, so compiler cannot ensure List<?> will actually contain String
        //        WildcardsCaptureWithCollections.<String>addToSet(unknownSet,
        //            "abc"); //Compiler error: the same here even with type witness
        addToSet((Set<String>) unknownSet, "abc");//works with unchecked forcing cast

        List<? extends Number> numbers = new ArrayList<>();
    }

    public static <T> void addToSet(Set<T> s, T t) {

    }

    public static <T> void addToList(List<T> l, T t) {

    }

    void foo(List<?> i) {
        fooHelper(i);
    }

    // Helper method created so that the wildcard can be captured
    // through type inference.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }

    void fooFoo(List<?> l) {
        fooFooHelper(l);
    }

    private <T> void fooFooHelper(List<T> l) {
        //        l.set(0, new Object()); //compiler error, unsafe, cannot be allowed
    }
}