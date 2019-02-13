package com.jjjimenez.SCG4J.core;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class FormattingTest {
    @Test
    public void givenHugeNumber_whenInvokingGetIndention_thenReturnProperSpaces(){
        int stressNum = 1000000000;
        String spaces = IntStream
                .range(0, stressNum * Formatting.SPACING_PER_TAB)
                .mapToObj(i -> " ")
                .collect(Collectors.joining(""));
        StringBuilder testSpaces = Formatting.getIndention(stressNum);

        assertEquals(spaces, testSpaces.toString());
    }

    @Test
    public void givenANumberGreaterThanZeroForSpacingPerTabAndNestedLevel1_whenInvokingGetIndention_thenReturnProperSpaces(){
        Formatting.SPACING_PER_TAB = 12;
        StringBuilder test = Formatting.getIndention(1);
        assertEquals("            ", test.toString());
    }

    @Test
    public void givenZeroForSpacingPerTabAndNestedLevel1_whenInvokingGetIndention_thenReturnNoSpaces(){
        Formatting.SPACING_PER_TAB = 0;
        StringBuilder test = Formatting.getIndention(1);
        assertEquals("", test.toString());
    }

    @Test
    public void givenANumberLowerThanZeroForSpacingPerTabAndNestedLevel1_whenInvokingGetIndention_thenReturnNoSpaces(){
        Formatting.SPACING_PER_TAB = -1;
        StringBuilder test = Formatting.getIndention(1);
        assertEquals("", test.toString());
    }
}
