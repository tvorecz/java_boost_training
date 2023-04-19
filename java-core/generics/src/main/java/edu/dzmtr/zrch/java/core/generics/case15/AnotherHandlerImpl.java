package edu.dzmtr.zrch.java.core.generics.case15;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class AnotherHandlerImpl<T> implements IHandler<T> {
    @Override
    public T handle(T value) {
        return value;
    }
}