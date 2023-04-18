package edu.dzmtr.zrch.java.core.generics.case17;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case17 {

    public static <T extends List<String>> void handle(List<T> listsOfList) {
        List<T> ls = new ArrayList<T>();
    }
}