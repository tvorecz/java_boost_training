package edu.dzmtr.zrch.java.interfaces.core.generics.case13;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public interface ICase13 {
    public List<?> objects = new ArrayList<>(); //ok
    public static List<?> collection = new ArrayList<>(); //ok
    //    List<?> list = new ArrayList<?>();  // compile-time error
    List<List<?>> lists = new ArrayList<List<?>>(); //ok, nested wildcards are allowed
}
