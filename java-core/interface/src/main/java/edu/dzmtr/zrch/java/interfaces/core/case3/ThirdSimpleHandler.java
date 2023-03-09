package edu.dzmtr.zrch.java.interfaces.core.case3;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
@FunctionalInterface
public interface ThirdSimpleHandler extends SimpleHandler {
    Object handle(Object o);

    static String extract(Object o) {
        return o.toString();
    }
}