package com.jjjimenez.SCG4J.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class StatementBlock {
    private final List<String> statements;

    public StatementBlock(String... statements){
        this.statements = new ArrayList<>(Arrays.asList(statements));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatementBlock that = (StatementBlock) o;
        return Objects.equals(statements, that.statements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statements);
    }

    @Override
    public String toString() {
        return "StatementBlock{" +
                "statements=" + statements +
                '}';
    }

    public List<String> getStatements() {
        return statements;
    }

    public void addStatement(String statement){
        statements.add(statement);
    }
}
