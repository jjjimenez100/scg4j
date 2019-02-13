package com.jjjimenez.SCG4J.core;

import org.junit.Test;
import static org.junit.Assert.*;
public class StatementBlockTest {

    @Test
    public void givenStatements_whenCallingGetStatements_thenReturnStatements(){
        StatementBlock testStatementBlock = new StatementBlock("int x = 5; ", "double z = 4;");
        assertEquals(2, testStatementBlock.getStatements().size());
        assertEquals("int x = 5; ", testStatementBlock.getStatements().get(0));
        assertEquals("double z = 4;", testStatementBlock.getStatements().get(1));
    }

    @Test
    public void givenNoStatements_whenCallingGetStatements_thenReturnEmptyArray(){
        StatementBlock testStatementBlock = new StatementBlock();
        assertEquals(0, testStatementBlock.getStatements().size());
    }

    @Test
    public void givenTwoInstancesWithSameProperties_whenCallingEquals_thenReturnTrue(){
        StatementBlock testStatementBlockOne = new StatementBlock("int x = 5; ", "double z = 4;");
        StatementBlock testStatementBlockTwo = new StatementBlock("int x = 5; ", "double z = 4;");

        assertTrue(testStatementBlockOne.equals(testStatementBlockTwo));
        assertTrue(testStatementBlockTwo.equals(testStatementBlockOne));
    }

    @Test
    public void givenTwoInstancesWithDiffProperties_whenCallingEquals_thenReturnFalse(){
        StatementBlock testStatementBlockOne = new StatementBlock("int x = 52; ", "double z = 4;");
        StatementBlock testStatementBlockTwo = new StatementBlock("int x = 5; ", "double z = 41;");

        assertFalse(testStatementBlockOne.equals(testStatementBlockTwo));
        assertFalse(testStatementBlockTwo.equals(testStatementBlockOne));
    }
}
