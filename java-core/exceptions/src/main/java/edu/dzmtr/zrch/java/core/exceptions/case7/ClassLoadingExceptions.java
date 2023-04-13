package edu.dzmtr.zrch.java.core.exceptions.case7;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class ClassLoadingExceptions {

    public static void loadClassByFullName() throws ClassNotFoundException {
        Class.forName("io.zrch.dzmtr.AnyClass");
    }

    public static void userClassWithInitErrors() {
        ClassWithInitError classWithInitError;

        try {
            classWithInitError = new ClassWithInitError();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e);
        }
        classWithInitError = new ClassWithInitError();
    }
}