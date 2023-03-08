package edu.dzmtr.zrch.java.core.case3;

/**
 *
 * @author Dzmitry_Zorych
 */
@FunctionalInterface
public interface SecondSimpleHandler extends SimpleHandler  {
    String handle(Object o);

    int hashCode(); //instance method has implementation in Object class

    boolean equals(Object obj); //instance method has implementation in Object class

    String toString(); //instance method has implementation in Object class

//    Object clone(); //compilation error, method 'clone' is abstract in Object class
}
