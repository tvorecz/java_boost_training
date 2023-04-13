package edu.dzmtr.zrch.java.interfaces.core.varargs.case1;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case1Child extends Case1 {
    @Override
    public void handle(Object[] args) {
        super.handle(args);
        System.out.println("public void handle(Object[] args)");
    }

    public void handle(Integer... args) {
        super.handle(args);
        System.out.println("public void handle(Number... args)");
    }

    public void handle(int... args) {
        super.handle(args);
        System.out.println("public void handle(int... args)");
    }

    //    public void handleTwo(int... numbers, String... strings) { } //two varargs not allowed, compilation error
}