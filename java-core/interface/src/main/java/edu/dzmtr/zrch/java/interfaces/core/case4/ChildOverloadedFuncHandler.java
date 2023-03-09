package edu.dzmtr.zrch.java.interfaces.core.case4;

/**
 * @author Dzmitry_Zorych
 */
@FunctionalInterface
public interface ChildOverloadedFuncHandler extends OverloadedFuncHandler {
    String handle(String o);
}
