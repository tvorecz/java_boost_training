package edu.dzmtr.zrch.java.core.strings.case2;

import static org.junit.Assert.assertEquals;

import java.util.StringJoiner;

import org.junit.Test;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class StringJoinerTest {

    @Test
    public void shouldJoinStringWithDelimiter() {
        StringJoiner stringJoiner = new StringJoiner(",");
        String actualResult = stringJoiner.add("first")
            .add("second")
            .add("last")
            .toString();
        assertEquals("first,second,last", actualResult);
    }

    @Test
    public void shouldJoinStringWithDelimiterPrefixSuffix() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        String actualResult = stringJoiner.add("first")
            .add("second")
            .add("last")
            .toString();
        assertEquals("[first,second,last]", actualResult);
    }

    @Test
    public void shouldReturnOnlyPrefixAndSuffix() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        String actualResult = stringJoiner.toString();
        assertEquals("[]", actualResult);
    }

    @Test
    public void shouldAlsoReturnOnlyEmptyValue() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        String actualResult = stringJoiner.setEmptyValue("empty").toString();
        assertEquals("empty", actualResult);
    }

    @Test
    public void shouldAlsoReturnOnlyPrefixAndSuffix() {
        StringJoiner stringJoiner = new StringJoiner("", "[", "]");
        String actualResult = stringJoiner.toString();
        assertEquals("[]", actualResult);
    }

    @Test
    public void shouldAddValuesAndDelimitersFromSecondJoinerToTheFirstOne() {
        StringJoiner stringJoiner1 = new StringJoiner(",", "[", "]")
            .add("v1_1")
            .add("v1_2");
        StringJoiner stringJoiner2 = new StringJoiner(";", "(", ")")
            .add("v2_1")
            .add("v2_2");
        String actualResult = stringJoiner1.merge(stringJoiner2)
            .toString(); //adds only values and delimiters from the second joiner to the caller joiner
        assertEquals("[v1_1,v1_2,v2_1;v2_2]", actualResult);
    }
}