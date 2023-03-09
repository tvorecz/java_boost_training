package edu.dzmtr.zrch.java.interfaces.core.case2;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class C implements A, B {

    @Override
    public String value() {
//        return A.value("1", "2"); //works fine: public static methods of parent interfaces are available by type
//        return B.value("1", "2"); //works fine: public static methods of parent interfaces are available by type


//        return A.super.value("1", "2", "3"); //compilation error: private static method is not available in descendant
//        return B.super.value("1", "2", "3", "4"); //compilation error: private static method is not available in descendant

        //default method with the same name and signature exists both in A and B parent interfaces
        //We can call the default implementation of the specific parent interface using following syntax: InterfaceName.super.method()
//        return A.super.value();
        return B.super.value();

    }

    @Override
    public String value(String input1) {
        return "C: public String child method";
    }
}