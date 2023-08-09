package edu.dzmtr.zrch.java.core.serialization.case4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class ChildClass extends ParentClass implements Serializable {
    private static final long serialVersionUID = 7809064026795477116L;

    private BigDecimal money;

    public ChildClass(String message, int value, BigDecimal money) {
        super(message, value);
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.writeObject(super.getMessage());
        outputStream.writeInt(super.getValue());
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        super.setMessage((String) inputStream.readObject());
        super.setValue(inputStream.readInt());
    }

    private void readObjectNoData() throws ObjectStreamException {

    }
}