package edu.dzmtr.zrch.java.interfaces.core.case3;

/**
 *
 * @author Dzmitry_Zorych
 */
public class SimpleHandlerClient {

    public Object executeSimpleHandling(Object o, SimpleHandler simpleHandler) {
        return simpleHandler.handle(o);
    }

    public Object executeFirstSimpleHandling(Object o, FirstSimpleHandler simpleHandler) {
        return simpleHandler.handle(o);
    }

    public Object executeSecondSimpleHandling(Object o, SecondSimpleHandler simpleHandler) {
        return simpleHandler.handle(o);
    }

    public Object executeThirdSimpleHandling(Object o, ThirdSimpleHandler simpleHandler) {
        return simpleHandler.handle(o);
    }

    public Object executeFourthSimpleHandling(Object o, FourthSimpleHandler simpleHandler) {
        return simpleHandler.handle(o);
    }
}