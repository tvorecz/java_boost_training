package edu.dzmtr.zrch.java.interfaces.core.generics.case4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case4 {

    public static void main(String[] args) {
        Map<String, List<String>> myMap = new HashMap(); //uses unchecked or unsafe operations. //java: Recompile with -Xlint:unchecked for details.
        myMap.put("key", List.of("value"));
        System.out.println(myMap);
    }
}