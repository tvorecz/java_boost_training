package edu.dzmtr.zrch.java.core.strings.case3;

import static org.junit.Assert.assertEquals;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class StringConcatenationAndFormattingTest {

    private static final String HELLO = "Hello";
    private static final String WORLD = " World";
    private static final String EXCLAMATION_MARK = "!";
    private static final String NULL = null;

    @Test
    public void shouldConcatConstantStringsUsingPlusOperator() {
        String result = HELLO + WORLD + EXCLAMATION_MARK
            + NULL; //CallSite makeConcatWithConstants(MethodHandles.Lookup lookup,String,MethodType,String,Object...) is called
        assertEquals("Hello World!null", result);

        result = HELLO + WORLD + EXCLAMATION_MARK + null;
        assertEquals("Hello World!null", result);
    }

    @Test
    public void shouldConcatDynamicStringsUsingPlusOperator() {
        String result = newString(HELLO) + newString(WORLD) + newString(EXCLAMATION_MARK);
        assertEquals("Hello World!", result);

        result = newString(HELLO) + newString(WORLD) + newString(EXCLAMATION_MARK);
        assertEquals("Hello World!", result);
    }

    @Test
    public void shouldFormatMessage() {
        String result = MessageFormat.format("The {0}{1}{2}{3} — is my first program!", HELLO, WORLD, EXCLAMATION_MARK,
            null);
        assertEquals("The Hello World!null — is my first program!", result);
    }

    @Test
    public void shouldFormatNotReplaceFormatArgByValue() {
        String result = MessageFormat.format("The '{0}'{1}{2}{3} — is my first program!", HELLO, WORLD,
            EXCLAMATION_MARK,
            null); //single quotes '' makes format argument non-replaceable since it's considered as a string
        assertEquals("The {0} World!null — is my first program!", result);
    }

    @Test
    public void shouldSkipRedundantArgument() {
        String result = MessageFormat.format("The {0}{1}{2} — is my first program!", HELLO, WORLD, EXCLAMATION_MARK,
            "redundant");
        assertEquals("The Hello World! — is my first program!", result);
    }

    @Test
    public void shouldSkipRedundantFormatElement() {
        String result = MessageFormat.format("The {0}{1}{2}{3} — is my first program!", HELLO, WORLD, EXCLAMATION_MARK);
        assertEquals("The Hello World!{3} — is my first program!", result);
    }

    @Test
    public void shouldFormat() {
        String result = String.format(Locale.ENGLISH, "Pi is %.2f", 3.14);
        assertEquals("Pi is 3.14", result);
    }

    @Test
    public void shouldConcatStringByInstanceMethod() {
        String result = HELLO.concat(WORLD).concat(EXCLAMATION_MARK);
        assertEquals("Hello World!", result);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException() {
        HELLO.concat(WORLD).concat(EXCLAMATION_MARK).concat(null); //method argument is marked as non-null
    }

    @Test
    public void shouldConcatenateListOfString() {
        List<String> strings = new ArrayList<>();
        strings.add(HELLO);
        strings.add(WORLD);
        strings.add(EXCLAMATION_MARK);
        strings.add(null);
        String result = String.join("", strings);
        assertEquals("Hello World!null", result);
    }

    @Test
    public void shouldConcatenateArrayOfString() {
        String[] strings = { HELLO, WORLD, EXCLAMATION_MARK, null };
        String result = String.join("", strings); //StringJoiner is used
        assertEquals("Hello World!null", result);
    }

    @Test
    public void shouldConcatenateArrayOfStringByStringUtils() {
        String[] strings = { HELLO, WORLD, EXCLAMATION_MARK, null };
        String result = StringUtils.join(strings); //Uses StringJoiner, nulls are converted to empty string and skipped
        assertEquals("Hello World!", result);
    }

    private String newString(String value) {
        return new String(value);
    }
}