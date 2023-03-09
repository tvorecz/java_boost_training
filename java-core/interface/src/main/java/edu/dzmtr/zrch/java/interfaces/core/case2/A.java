package edu.dzmtr.zrch.java.interfaces.core.case2;

/**
 *
 *
 * @author Dzmitry_Zorych
 */
public interface A {

    default String value() {
        return "A: default String and " + value("1", "2", "3", "4");
        //instance private method available for default instance method, but not available inside initial interface and for its descendants
    }

    static String value(String input1, String input2) {
        return "A: static String and " + value("1", "2", "3");
        //static private method available for public static method and instance method, but not available inside initial interface and for its descendants
    }

    private static String value(String input1, String input2, String input3) {
        return "private static method";
    }

    private String value(String input1, String input2, String input3, String input4) {
        return "private instance method";
    }
}
