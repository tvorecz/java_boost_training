package edu.dzmtr.zrch.java.interfaces.core.case4;

/**
 * @author Dzmitry_Zorych
 */
public class ChildOverloadedFuncHandlerClient {

    Object handle(String s, ChildOverloadedFuncHandler handler) {
        return handler.handle(s);
    }
}