package edu.dzmtr.zrch.java.core.case4;

/**
 * @author Dzmitry_Zorych
 */
public interface OverloadedFuncHandler {

    int hashCode(); //instance method has implementation in Object class

    boolean equals(Object obj); //instance method has implementation in Object class

    String toString(); //instance method has implementation in Object class
}
