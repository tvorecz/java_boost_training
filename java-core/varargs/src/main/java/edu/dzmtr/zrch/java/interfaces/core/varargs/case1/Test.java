package edu.dzmtr.zrch.java.interfaces.core.varargs.case1;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Test {
    public static void main(String... args) {
        Case1Child child = new Case1Child();

        Object valueOf = Integer.valueOf(1);
        Integer[] intArray = new Integer[1];
        intArray[0] = Integer.valueOf(1);
        int[] simpleIntArray = new int[1];
        simpleIntArray[0] = 1;
        Object[] array = new Object[1];
        array[0] = valueOf;

        //        child.handle(1, 2);//Ambiguous method call - compilation error
        child.handle(intArray);
        child.handle(simpleIntArray);
        //        child.handle(Integer.valueOf(1));//Ambiguous method call - compilation error
        //        child.handle(valueOf); //compilation error, array is expected
        child.handle(array);
    }
}