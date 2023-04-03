package edu.dzmtr.zrch.java.interfaces.core.generics.case2;

import java.util.ArrayList;
import java.util.List;

/**
 * Use for compilation:
 * javac -Xlint:unchecked -d javac-target  edu/dzmtr/zrch/java/interfaces/core/generics/case2/Case2.java
 * <p>
 * Produces:
 * edu\dzmtr\zrch\java\interfaces\core\generics\case2\Case2.java:16: warning: [unchecked] unchecked call to add(E) as a member of the raw type List
 * rawStrings.add(1);
 * ^
 * where E is a type-variable:
 * E extends Object declared in interface List
 * 1 warning
 *
 * @author Dzmitry_Zorych
 */
public class Case2 {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List rawStrings = strings;
        rawStrings.add(1);
        System.out.println(strings.get(0)); //ClassCastException
    }
}