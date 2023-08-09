package edu.dzmtr.zrch.java.core.serialization.case5;

import java.math.BigDecimal;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class ChildClass extends ParentClass { //inherits Serializable interface from parent class
    private static final long serialVersionUID = 2560678947548847635L;

    private BigDecimal money;

    public ChildClass(String message, int value, BigDecimal money) {
        super(message, value);
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }
}