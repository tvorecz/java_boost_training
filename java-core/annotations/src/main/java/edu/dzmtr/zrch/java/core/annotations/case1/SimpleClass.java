package edu.dzmtr.zrch.java.core.annotations.case1;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
@SimpleAnnotation(altNumber = 1.1,
    data = { "1", "2" },
    points = { 1, 2 })
@RepeatingAnnotation(dayOfWeek = "Fri")
@RepeatingAnnotation(dayOfWeek = "Sun")
public class SimpleClass {
}