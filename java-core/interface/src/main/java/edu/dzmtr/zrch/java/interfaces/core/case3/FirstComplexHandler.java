package edu.dzmtr.zrch.java.interfaces.core.case3;

/**
 * @author Dzmitry_Zorych
 */
//@FunctionalInterface //compilation error, parent contains two methods
public interface FirstComplexHandler extends ComplexHandler {
    Object handle(String o);
}
