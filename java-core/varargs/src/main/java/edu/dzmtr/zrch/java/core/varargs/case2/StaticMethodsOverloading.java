package edu.dzmtr.zrch.java.core.varargs.case2;

import java.util.List;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class StaticMethodsOverloading {
    //    public static String format(String pattern, String[] arguments) { //compilation error - error: cannot declare both format(String,String...) and format(String,String[]) in StaticMethodsOverloading
    //        return "";
    //    }

    public static String format(String pattern, String... arguments) {
        return "";
    }

    public static String format(String pattern, String argument) {
        return "";
    }

    public static String format(String pattern, List<String> arguments) {
        return "";
    }

}