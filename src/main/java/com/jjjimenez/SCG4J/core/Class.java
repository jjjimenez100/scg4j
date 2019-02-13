package com.jjjimenez.SCG4J.core;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Class {
    private final String name;
    private final String packageName;
    private final String parentClass;
    private final List<Variable> fields;
    private final List<Modifier.Type> modifiers;
    private final List<String> typeParameters;
    private final List<String> parentTypeParameters;
    private final List<String> imports;
    private final List<Method> methods;
    private final List<String> annotations;
    private final List<String> interfaces;

    private Class(Builder builder){
        this.name = builder.name;
        this.parentClass = builder.parent;
        this.packageName = builder.packageName;
        this.typeParameters = Collections.unmodifiableList(builder.typeParameters);
        this.modifiers = Collections.unmodifiableList(builder.modifiers);
        this.parentTypeParameters = Collections.unmodifiableList(builder.parentTypeParameters);
        this.imports = Collections.unmodifiableList(builder.imports);
        this.methods = Collections.unmodifiableList(builder.methods);
        this.fields = Collections.unmodifiableList(builder.fields);
        this.annotations = Collections.unmodifiableList(builder.annotations);
        this.interfaces = Collections.unmodifiableList(builder.interfaces);
    }

    public static class Builder{
        private final String name;
        private final String packageName;
        private final List<Modifier.Type> modifiers;
        private final List<String> typeParameters;
        private final List<String> parentTypeParameters;
        private final List<Method> methods;
        private final List<Variable> fields;
        private final List<String> annotations;
        private final List<String> interfaces;
        private List<String> imports;
        private String parent;

        public Builder(String name, String packageName){
            this.name = name;
            this.packageName = packageName;
            this.annotations = new ArrayList<>();
            this.imports = new ArrayList<>();
            this.interfaces = new ArrayList<>();
            this.modifiers = new ArrayList<>();
            this.typeParameters = new ArrayList<>();
            this.parentTypeParameters = new ArrayList<>();
            this.methods = new ArrayList<>();
            this.fields = new ArrayList<>();
        }

        public Builder addModifier(Modifier.Type modifier){
            modifiers.add(modifier);
            return this;
        }

        public Builder addField(Variable field){
            fields.add(field);
            return this;
        }

        public Builder addMethod(Method method){
            methods.add(method);
            return this;
        }

        public Builder addAnnotation(String annotation){
            annotations.add(annotation);
            return this;
        }

        public Builder addImport(String importStatement){
            imports.add(importStatement);
            return this;
        }

        public Builder addTypeParameter(String typeParameter){
            typeParameters.add(typeParameter);
            return this;
        }

        public Builder addParentTypeParameter(String parentTypeParameter){
            parentTypeParameters.add(parentTypeParameter);
            return this;
        }

        public Builder addInterface(String interfaceStr){
            interfaces.add(interfaceStr);
            return this;
        }

        public Builder parent(String parent){
            this.parent = parent;
            return this;
        }

        public Class build(){
            return new Class(this);
        }
    }

    @Override
    public String toString(){
        StringBuilder declaration = new StringBuilder();
        appendClassPackageDeclaration(declaration);
        appendClassImportDeclarations(declaration);
        appendClassAnnotationDeclarations(declaration);
        appendClassDeclaration(declaration);
        appendClassTypeParameterDeclarations(declaration, typeParameters);
        appendClassParentDeclaration(declaration);
        appendClassInterfaceImplementations(declaration);
        appendClassTypeParameterDeclarations(declaration, parentTypeParameters);
        appendClassFieldDeclarations(declaration);
        appendClassMethodDeclarations(declaration);

        return declaration.toString();
    }

    private void appendClassPackageDeclaration(StringBuilder declaration){
        declaration.append("package ");
        declaration.append(packageName);
        declaration.append(";");
        declaration.append("\n\n");
    }

    private void appendClassImportDeclarations(StringBuilder declaration){
        if(!imports.isEmpty()){
            for(String importStatement: imports){
                declaration.append(importStatement);
                declaration.append("\n");
            }
            declaration.append("\n");
        }
    }

    private void appendClassAnnotationDeclarations(StringBuilder declaration){
        if(!annotations.isEmpty()){
            for(String annotation: annotations){
                declaration.append(annotation);
                declaration.append("\n");
            }
        }
    }

    private void appendClassDeclaration(StringBuilder declaration){
        declaration.append(Modifier.getCombinedModifiers(modifiers));
        declaration.append("class ");
        declaration.append(name);
    }

    private void appendClassTypeParameterDeclarations(StringBuilder declaration, List<String> typeParameters){
        if(!typeParameters.isEmpty()){
            declaration.append("<");
            for(String typeParameter: typeParameters){
                declaration.append(typeParameter);
                declaration.append(", ");
            }
            declaration.deleteCharAt(declaration.length()-1);
            declaration.deleteCharAt(declaration.length()-1);
            declaration.append(">");
        }
    }

    private void appendClassFieldDeclarations(StringBuilder declaration){
        declaration.append(" {");
        declaration.append("\n");
        if(!fields.isEmpty()){
            for(Variable field: fields){
                declaration.append(field.toString());
                declaration.append(";");
                declaration.append("\n");
            }
            declaration.append("\n");
        }
    }

    private void appendClassMethodDeclarations(StringBuilder declaration){
        if(!methods.isEmpty()){
            for(Method method: methods){
                declaration.append(method.toString());
                declaration.append("\n");
                declaration.append("\n");
            }
            declaration.deleteCharAt(declaration.length()-1);
        }

        declaration.append("}");
    }

    private void appendClassParentDeclaration(StringBuilder declaration){
        if(Objects.nonNull(parentClass)){
            declaration.append(" extends ");
            declaration.append(parentClass);
        }
    }

    private void appendClassInterfaceImplementations(StringBuilder declaration){
        if(!interfaces.isEmpty()){
            declaration.append(" implements ");

            for(String interfaceStr: interfaces){
                declaration.append(interfaceStr);
                declaration.append(", ");
            }
            declaration.deleteCharAt(declaration.length()-1);
            declaration.deleteCharAt(declaration.length()-1);
        }
    }

    public boolean writeJavaClass(String path){
        try(PrintWriter writer = new PrintWriter(path)){
            writer.println(this.toString());
            return true;
        } catch(FileNotFoundException e){
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return Objects.equals(name, aClass.name) &&
                Objects.equals(packageName, aClass.packageName) &&
                Objects.equals(typeParameters, aClass.typeParameters) &&
                Objects.equals(modifiers, aClass.modifiers) &&
                Objects.equals(parentClass, aClass.parentClass) &&
                Objects.equals(parentTypeParameters, aClass.parentTypeParameters) &&
                Objects.equals(imports, aClass.imports) &&
                Objects.equals(methods, aClass.methods) &&
                Objects.equals(fields, aClass.fields) &&
                Objects.equals(annotations, aClass.annotations) &&
                Objects.equals(interfaces, aClass.interfaces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, packageName, typeParameters, modifiers, parentClass, parentTypeParameters, imports, methods, fields, annotations, interfaces);
    }

    public String getName() {
        return name;
    }

    public String getPackageName() {
        return packageName;
    }

    public List<String> getTypeParameters() {
        return typeParameters;
    }

    public List<Modifier.Type> getModifiers() {
        return modifiers;
    }

    public String getParentClass() {
        return parentClass;
    }

    public List<String> getParentTypeParameters() {
        return parentTypeParameters;
    }

    public List<String> getImports() {
        return imports;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public List<Variable> getFields() {
        return fields;
    }

    public List<String> getAnnotations() {
        return annotations;
    }
}
