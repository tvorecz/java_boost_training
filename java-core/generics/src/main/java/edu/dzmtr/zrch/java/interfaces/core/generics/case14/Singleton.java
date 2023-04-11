package edu.dzmtr.zrch.java.interfaces.core.generics.case14;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Singleton<T> {

    //    public static T getInstance() { //method returns T, that belongs to the instance of the class
    //        //we can generify static method only
    //        //compile error: cannot be referenced from static context
    //        if (instance == null) {
    //            instance = new Singleton<T>(); //instance have a type T, however we try to assign Singleton<T> to it
    //        }
    //        return instance;
    //    }
    //
    //    private static T instance = null; //compiler error: cannot be referenced from static context
    //    // static variable can not be generified, it should contain only one specific reference type since it is exists on class level

}
