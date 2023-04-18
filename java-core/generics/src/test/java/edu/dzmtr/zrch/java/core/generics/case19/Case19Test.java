package edu.dzmtr.zrch.java.core.generics.case19;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * all instances of a generic class have the same run-time class, regardless of their actual type
 * parameters
 *
 * @author Dzmitry_Zorych
 */
public class Case19Test {

    @Test
    public void differentlyGenerifiedClassesShouldBeEqual() {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("");

        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(1);

        assertTrue(listOfIntegers.getClass().equals(listOfIntegers.getClass()));
        assertTrue(listOfIntegers.getClass() == listOfIntegers.getClass());
    }
}