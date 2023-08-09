package edu.dzmtr.zrch.java.core.serialization.case2;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public enum SimpleEnum {

    FIRST(1),
    SECOND(2),
    THIRD(3),
    OTHER(0);

    private Integer order;

    SimpleEnum(Integer order) {
        this.order = order;
    }
}