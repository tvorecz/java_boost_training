package edu.dzmtr.zrch.java.core.annotations.case1;

import java.lang.annotation.Repeatable;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
@Repeatable(RepeatingAnnotationContainer.class)
public @interface RepeatingAnnotation {
    String dayOfMonth() default "first";

    String dayOfWeek() default "Mon";

    int hour() default 12;
}