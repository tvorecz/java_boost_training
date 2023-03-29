package edu.dzmtr.zrch.java.core.exceptions.case5;

/**
 * @author Dzmitry_Zorych
 */

public class CommonHandler {

    public void handle() throws CommonHandlerException {
        throw new CommonHandlerException("HandlerException");
    }
}