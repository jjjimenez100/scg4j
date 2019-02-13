package com.jjjimenez.SCG4J.core;

public final class Formatting {
    public static int SPACING_PER_TAB = 4;

    private Formatting() { }

    public static StringBuilder getIndention(int nestedLevel){
        int indention = SPACING_PER_TAB * nestedLevel;
        StringBuilder indentSpaces = new StringBuilder();

        for(int index=0; index<indention; index++){
            indentSpaces.append(" ");
        }

        return indentSpaces;
    }
}
