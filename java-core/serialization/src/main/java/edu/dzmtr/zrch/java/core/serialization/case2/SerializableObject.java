package edu.dzmtr.zrch.java.core.serialization.case2;

import java.io.Serializable;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1640957473717547463L;

    private AnotherSerializableObject object;

    private String note;

    private SimpleEnum order;

    private Integer occurrence;

    public SerializableObject(AnotherSerializableObject object, String note, SimpleEnum order, Integer occurrence) {
        this.object = object;
        this.note = note;
        this.order = order;
        this.occurrence = occurrence;
    }

    public AnotherSerializableObject getObject() {
        return object;
    }

    public String getNote() {
        return note;
    }

    public SimpleEnum getOrder() {
        return order;
    }

    public Integer getOccurrence() {
        return occurrence;
    }
}