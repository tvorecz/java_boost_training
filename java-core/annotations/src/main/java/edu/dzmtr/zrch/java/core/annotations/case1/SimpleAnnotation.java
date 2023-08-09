package edu.dzmtr.zrch.java.core.annotations.case1;

import java.lang.annotation.Documented;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
@Documented
public @interface SimpleAnnotation {
    String value() default "none";

    int number() default 0;

    double altNumber();

    String[] data();

    int[] points();
}