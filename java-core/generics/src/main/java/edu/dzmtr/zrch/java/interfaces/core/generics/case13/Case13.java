package edu.dzmtr.zrch.java.interfaces.core.generics.case13;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
//public class Case13<?> { //compilation error: <identifier> expected
public class Case13 {
    private static List<?> objects = new ArrayList<>(); //ok

    public static List<?> handle() { //ok
        return List.of();
    }

    public static void handle(List<?> collection) { //ok
    }

    //    public static <?> void(? object) {} //compilation error: <identifier> expected

    public static void main(String[] args) {
        
    }
}