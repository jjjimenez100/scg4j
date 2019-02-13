package com.jjjimenez.SCG4J.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Variable {
    private final String name;
    private final String type;
    private final String value;
    private final int nestedLevel;
    private final List<String> annotations;
    private final List<Modifier.Type> modifiers;

    private Variable(Builder builder){
        this.name = builder.name;
        this.type = builder.type;
        this.nestedLevel = builder.nestedLevel;
        this.value = builder.value;
        this.annotations = Collections.unmodifiableList(builder.annotations);
        this.modifiers = Collections.unmodifiableList(builder.modifiers);
    }

    public static class Builder{
        private final String name;
        private final String type;
        private final List<Modifier.Type> modifiers;
        private final int nestedLevel;
        private String value;
        private final List<String> annotations;

        public Builder(String name, String type, int nestedLevel){
            this.name = name;
            this.type = type;
            this.modifiers = new ArrayList<>();
            this.nestedLevel = nestedLevel;
            this.annotations = new ArrayList<>();
        }

        public Builder addAnnotation(String annotation){
            annotations.add(annotation);
            return this;
        }

        public Builder addModifier(Modifier.Type modifier){
            modifiers.add(modifier);
            return this;
        }

        public Builder value(String value){
            this.value = value;
            return this;
        }

        public Variable build(){
            return new Variable(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return nestedLevel == variable.nestedLevel &&
                Objects.equals(name, variable.name) &&
                Objects.equals(type, variable.type) &&
                Objects.equals(modifiers, variable.modifiers) &&
                Objects.equals(value, variable.value) &&
                Objects.equals(annotations, variable.annotations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, modifiers, nestedLevel, value, annotations);
    }

    @Override
    public String toString() {
        StringBuilder variableDeclaration = new StringBuilder();
        appendVariableAnnotations(variableDeclaration);
        appendVariableDeclaration(variableDeclaration);

        return variableDeclaration.toString();
    }

    private void appendVariableAnnotations(StringBuilder declaration){
        if(!annotations.isEmpty()){
            for(String annotation: annotations){
                declaration.append(Formatting.getIndention(nestedLevel));
                declaration.append(annotation);
                declaration.append("\n");
            }
            declaration.append(Formatting.getIndention(nestedLevel));
        } else {
            declaration.append(Formatting.getIndention(nestedLevel));
        }
    }

    private void appendVariableDeclaration(StringBuilder variableDeclaration){
        if(!modifiers.isEmpty()){
            variableDeclaration.append(Modifier.getCombinedModifiers(modifiers));

            variableDeclaration.append(type);
            variableDeclaration.append(" ");
            variableDeclaration.append(name);

            if(value != null){
                variableDeclaration.append(" = ");
                variableDeclaration.append(value);
            }
        } else {
            if(value != null){
                variableDeclaration.append(type);
                variableDeclaration.append(" ");
                variableDeclaration.append(name);
                variableDeclaration.append(" = ");
                variableDeclaration.append(value);
            } else {
                variableDeclaration.append(type);
                variableDeclaration.append(" ");
                variableDeclaration.append(name);
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<Modifier.Type> getModifiers() {
        return modifiers;
    }

    public int getNestedLevel(){
        return nestedLevel;
    }

    public String getValue() {
        return value;
    }

    public List<String> getAnnotations() {
        return annotations;
    }
}
