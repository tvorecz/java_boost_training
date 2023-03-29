package edu.dzmtr.zrch.java.core.exceptions.case6;

import java.util.Objects;

/**
 * Throw and catch exception in constructor and observe if object will be created.
 *
 * @author Dzmitry_Zorych
 */
public class Pet {
    private String type;

    public Pet(String type) {
        try {
            Objects.requireNonNull(type);
            this.type = type;
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            if (Objects.isNull(this.type)) {
                type = "";
            }
        }
    }
}