package edu.dzmtr.zrch.java.core.case3;

/**
 * @author Dzmitry_Zorych
 */
@FunctionalInterface
public interface FirstSimpleHandler extends SimpleHandler {
    Object handle(Object o);

    default boolean check(Object o) {
        return true;
    }

    default String content(Object o) {
        return o.toString();
    }
}
