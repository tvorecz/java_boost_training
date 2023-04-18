package edu.dzmtr.zrch.java.core.generics.case18;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Generics and legacy code
 * <p>
 * To build:
 * path: java_boost_training\java-core\generics\src\main\java>
 * <p>
 * command: javac -Xlint:unchecked -d javac-target  edu/dzmtr/zrch/java/interfaces/core/generics/case18/Case18.java
 * <p>
 * -Xlint:unchecked - provides more information about unchecked warnings
 *
 * @author Dzmitry_Zorych
 */
public class Case18 {

    public static void main(String[] args) {
        //Using legacy code inside generified code

        Collection<Integer> genIntegers = new ArrayList<>();
        genIntegers.add(1);
        genIntegers.add(2);
        genIntegers.add(3);

        Collection<Integer> copiedGenIntegers = new ArrayList<>();

        handleRaw(genIntegers);
        copiedGenIntegers = getRaw(); //warning: [unchecked] unchecked conversion - because cannot ensure the type safety
        //required: Collection<Integer>
        //found:    Collection
        copiedGenIntegers = (Collection<Integer>) getRaw(); //warning: [unchecked] unchecked cast

        System.out.println(copiedGenIntegers);

        //Using generified code inside legacy code
        Collection rawIntegers = new ArrayList<>();
        genIntegers.add(1);
        genIntegers.add(2);
        genIntegers.add(3);

        Collection rawCopiedIntegers = new ArrayList<>();

        handleGen(
            rawIntegers); //warning: [unchecked] unchecked method invocation: method handleGen in class Case18 is applied to given types
        //warning: [unchecked] unchecked conversion - produces two warnings
        //required: Collection<Integer>
        //found: Collection

        rawCopiedIntegers = getGen(); //do not produce warnings
        System.out.println(rawCopiedIntegers);
        rawCopiedIntegers = rawIntegers; //no warnings when raw type is assigned to raw type
    }

    public static void handleRaw(Collection collection) {

    }

    public static Collection getRaw() {
        return new ArrayList();
    }

    public static void handleGen(Collection<Integer> collection) {

    }

    public static Collection<Integer> getGen() {
        return new ArrayList<Integer>();
    }
}