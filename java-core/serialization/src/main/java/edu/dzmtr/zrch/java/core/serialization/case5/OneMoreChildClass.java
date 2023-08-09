package edu.dzmtr.zrch.java.core.serialization.case5;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class OneMoreChildClass extends OneMoreParentClass implements Serializable {

    private static final long serialVersionUID = 951501903737137837L;

    private BigDecimal money;

    public OneMoreChildClass(String message, int value, BigDecimal money) {
        super(message, value);
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }
}