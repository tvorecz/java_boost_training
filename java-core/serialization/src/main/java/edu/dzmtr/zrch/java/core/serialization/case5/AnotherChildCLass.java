package edu.dzmtr.zrch.java.core.serialization.case5;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class AnotherChildCLass extends AnotherParentClass implements Serializable {

    private static final long serialVersionUID = -1292266811065694908L;

    private BigDecimal money;

    public AnotherChildCLass(String message, int value, BigDecimal money) {
        super(message, value);
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }
}