package com.jjjimenez.SCG4J.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Method {
    private final String name;
    private final String returnType;
    private final int nestedLevel;
    private final StatementBlock statements;
    private final List<String> annotations;
    private final List<Variable> parameters;
    private final List<Modifier.Type> modifiers;

    private Method(Builder builder){
        this.name = builder.name;
        this.returnType = builder.returnType;
        this.statements = builder.statements;
        this.nestedLevel = 1;
        this.modifiers = Collections.unmodifiableList(builder.modifiers);
        this.parameters = Collections.unmodifiableList(builder.parameters);
        this.annotations = Collections.unmodifiableList(builder.annotations);
    }

    public static class Builder{
        private final String name;
        private final List<Modifier.Type> modifiers;
        private final List<Variable> parameters;
        private final List<String> annotations;
        private String returnType;
        private StatementBlock statements;

        public Builder(String name){
            this.name = name;
            this.modifiers = new ArrayList<>();
            this.parameters = new ArrayList<>();
            this.annotations = new ArrayList<>();
        }

        public Builder addModifier(Modifier.Type modifier){
            modifiers.add(modifier);
            return this;
        }

        public Builder addParameter(Variable parameter){
            parameters.add(parameter);
            return this;
        }

        public Builder addAnnotation(String annotation){
            annotations.add(annotation);
            return this;
        }

        public Builder returnType(String returnType){
            this.returnType = returnType;
            return this;
        }

        public Builder statements(StatementBlock statements){
            this.statements = statements;
            return this;
        }

        public Method build(){
            return new Method(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Method method = (Method) o;
        return nestedLevel == method.nestedLevel &&
                Objects.equals(name, method.name) &&
                Objects.equals(modifiers, method.modifiers) &&
                Objects.equals(returnType, method.returnType) &&
                Objects.equals(parameters, method.parameters) &&
                Objects.equals(statements, method.statements) &&
                Objects.equals(annotations, method.annotations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, modifiers, returnType, parameters, statements, nestedLevel, annotations);
    }

    @Override
    public String toString() {
        StringBuilder method = new StringBuilder();
        appendMethodAnnotations(method);
        method.append(Modifier.getCombinedModifiers(modifiers));
        appendMethodDeclaration(method);
        appendMethodParameters(method);
        appendMethodStatements(method);
        return method.toString();
    }

    private void appendMethodAnnotations(StringBuilder method){
        if(!annotations.isEmpty()){
            for(String annotation: annotations){
                method.append(Formatting.getIndention(nestedLevel));
                method.append(annotation);
                method.append("\n");
            }
        }
        method.append(Formatting.getIndention(nestedLevel));
    }

    private void appendMethodStatements(StringBuilder method){
        if(Objects.nonNull(statements)){
            method.append("{\n");
            for(String statement: statements.getStatements()){
                method.append(Formatting.getIndention(nestedLevel+1));
                method.append(statement);
                method.append("\n");
            }
            method.append(Formatting.getIndention(nestedLevel));
            method.append("}");
        } else {
            method.append(";");
        }
    }

    private void appendMethodParameters(StringBuilder method){
        for(Variable parameter: parameters){
            method.append(parameter.toString());
            method.append(", ");
        }

        if(!parameters.isEmpty()){
            method.deleteCharAt(method.length()-1);
            method.deleteCharAt(method.length()-1);
        }

        method.append(")");
    }

    private void appendMethodDeclaration(StringBuilder method){
        if(Objects.nonNull(returnType)){
            method.append(returnType);
            method.append(" ");
        }

        method.append(name);
        method.append("(");
    }

    public String getName() {
        return name;
    }

    public List<Modifier.Type> getModifiers() {
        return modifiers;
    }

    public String getReturnType() {
        return returnType;
    }

    public List<Variable> getParameters() {
        return parameters;
    }

    public int getNestedLevel(){
        return nestedLevel;
    }
}
