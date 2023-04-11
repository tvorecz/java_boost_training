package edu.dzmtr.zrch.java.interfaces.core.generics.case8;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case8 {

    public static void main(String[] args) {
        addNumbers(new ArrayList<>());
        sumOfList(List.of(1, 2, 3));
    }

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
            list.add(null);
        }

        Object object = list.get(1);

        Integer integer = (Integer) list.get(1); //only explicit casting
    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }

        Number number = list.get(1); //no casting is required

        return s;
    }
}