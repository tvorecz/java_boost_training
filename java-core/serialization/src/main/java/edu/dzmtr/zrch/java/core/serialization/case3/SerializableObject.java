package edu.dzmtr.zrch.java.core.serialization.case3;

import java.io.ObjectStreamField;
import java.io.Serializable;

/**
 * Overriding of default behavior for field serialization. Only enumerated in ObjectStreamField array fields will be serialized and deserialized.
 *
 * @author Dzmitry_Zorych
 */
public class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1640957473717547463L;

    private AnotherSerializableObject object;

    private String note;

    private SimpleEnum order;

    private Integer occurrence;

    private static final ObjectStreamField[] serialPersistentFields
        = {
        new ObjectStreamField("object", AnotherSerializableObject.class),
        new ObjectStreamField("note", String.class) };
    //        new ObjectStreamField("hahaha", String.class) }; //java.io.InvalidClassException: edu.dzmtr.zrch.java.core.serialization.case3.SerializableObject; unmatched serializable field(s) declared

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