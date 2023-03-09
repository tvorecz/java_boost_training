package edu.dzmtr.zrch.java.interfaces.core.case5;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public interface A {
    <T extends CharSequence> void handle(T param); //compilation error: both methods have the same erasure, as a result they would be indistinguishable in runtime

//    void handle(CharSequence param);
}
