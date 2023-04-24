package edu.dzmtr.zrch.java.core.strings.case1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Different replacing methods in class String
 *
 * @author Dzmitry_Zorych
 */
public class StringPartReplacementTest {
    private static final String VALUE = "White. Red. White.";

    @Test
    public void shouldReplaceAllCharOccurrencesByAnotherChar() {
        String actualResult = VALUE.replace('.', '#');
        Assert.assertEquals("White# Red# White#", actualResult);
    }

    @Test
    public void shouldReplaceAllStringOccurrencesByAnotherString() {
        String actualResult = VALUE.replace(".", "#");
        Assert.assertEquals("White# Red# White#", actualResult);
    }

    @Test
    public void shouldReplaceFirstPatternOccurrenceByAnotherString() {
        String actualResult = VALUE.replaceFirst(".", "#");
        Assert.assertEquals("#hite. Red. White.", actualResult);
    }

    @Test
    public void shouldReplaceAllPatternOccurrencesByAnotherString() {
        String actualResult = VALUE.replaceAll(".", "#");
        Assert.assertEquals("##################", actualResult);
    }
}