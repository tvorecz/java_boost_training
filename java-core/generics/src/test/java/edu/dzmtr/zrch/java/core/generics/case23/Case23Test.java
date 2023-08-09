package edu.dzmtr.zrch.java.core.generics.case23;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case23Test {

    @Test
    public void shouldPlaceObjectsOfDifferentTypeToRawType() {
        ArrayList arrayList = new ArrayList<String>();
        arrayList.add(10);
        arrayList.add(true);
        arrayList.add("Hello");
        System.out.println(arrayList);
        assertEquals("[10, true, Hello]", arrayList.toString());
    }
}