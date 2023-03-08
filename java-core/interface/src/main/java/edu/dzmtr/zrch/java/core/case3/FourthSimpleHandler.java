package edu.dzmtr.zrch.java.core.case3;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
@FunctionalInterface
public interface FourthSimpleHandler extends SimpleHandler  {
    Object handle(Object o);

    private boolean check(Object o) {
        return alwaysTrue();
    }

    private static boolean alwaysTrue() {
        return true;
    }
}
