package com.jjjimenez.SCG4J.core;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Interface {
    private final String name;
    private final String packageName;
    private final String parent;
    private final Modifier.Type modifier;
    private final List<String> typeParameters;
    private final List<String> parentTypeParameters;
    private final List<String> imports;
    private final List<Method> methods;
    private final List<Variable> fields;
    private final List<String> annotations;

    private Interface(Builder builder){
        this.name = builder.name;
        this.modifier = builder.modifier;
        this.parent = builder.parent;
        this.packageName = builder.packageName;
        this.parentTypeParameters = Collections.unmodifiableList(builder.parentTypeParameters);
        this.imports = Collections.unmodifiableList(builder.imports);
        this.methods = Collections.unmodifiableList(builder.methods);
        this.fields = Collections.unmodifiableList(builder.fields);
        this.typeParameters = Collections.unmodifiableList(builder.typeParameters);
        this.annotations = Collections.unmodifiableList(builder.annotations);
    }

    public static class Builder{
        private final String name;
        private final String packageName;
        private final List<String> typeParameters;
        private final List<String> parentTypeParameters;
        private final List<String> imports;
        private final List<Method> methods;
        private final List<Variable> fields;
        private final List<String> annotations;
        private String parent;
        private Modifier.Type modifier;

        public Builder(String name, String packageName){
            this.name = name;
            this.typeParameters = new ArrayList<>();
            this.parentTypeParameters = new ArrayList<>();
            this.methods = new ArrayList<>();
            this.fields = new ArrayList<>();
            this.packageName = packageName;
            this.annotations = new ArrayList<>();
            this.imports = new ArrayList<>();
        }

        public Builder modifier(Modifier.Type modifier){
            if(modifier == Modifier.Type.PUBLIC){
                this.modifier = modifier;
            } else {
                throw new InvalidInterfaceModifier("Only public modifier is allowed for interfaces");
            }

            return this;
        }

        public Builder addImport(String importStatement){
            imports.add(importStatement);
            return this;
        }

        public Builder addMethod(Method method){
            methods.add(method);
            return this;
        }

        public Builder addField(Variable field){
            fields.add(field);
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

        public Builder addAnnotation(String annotation){
            annotations.add(annotation);
            return this;
        }

        public Builder parent(String parent){
            this.parent = parent;
            return this;
        }

        public Interface build(){
            return new Interface(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interface that = (Interface) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(packageName, that.packageName) &&
                Objects.equals(typeParameters, that.typeParameters) &&
                modifier == that.modifier &&
                Objects.equals(parent, that.parent) &&
                Objects.equals(parentTypeParameters, that.parentTypeParameters) &&
                Objects.equals(imports, that.imports) &&
                Objects.equals(methods, that.methods) &&
                Objects.equals(fields, that.fields) &&
                Objects.equals(annotations, that.annotations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, packageName, typeParameters, modifier, parent, parentTypeParameters, imports, methods, fields, annotations);
    }

    @Override
    public String toString(){
        StringBuilder declaration = new StringBuilder();
        appendInterfacePackageDeclaration(declaration);
        appendInterfaceImportDeclarations(declaration);
        appendInterfaceAnnotationDeclarations(declaration);
        appendInterfaceDeclaration(declaration);
        appendInterfaceTypeParameterDeclarations(declaration, typeParameters);
        appendInterfaceParentDeclaration(declaration);
        appendInterfaceTypeParameterDeclarations(declaration, parentTypeParameters);
        declaration.append(" {");
        appendInterfaceFieldDeclarations(declaration);
        declaration.append("\n");
        appendInterfaceMethodDeclarations(declaration);

        return declaration.toString();
    }

    private void appendInterfacePackageDeclaration(StringBuilder declaration){
        declaration.append("package ");
        declaration.append(packageName);
        declaration.append(";");
        declaration.append("\n\n");
    }

    private void appendInterfaceImportDeclarations(StringBuilder declaration){
        if(!imports.isEmpty()){
            for(String importStatement: imports){
                declaration.append(importStatement);
                declaration.append("\n");
            }
            declaration.append("\n");
        }
    }

    private void appendInterfaceAnnotationDeclarations(StringBuilder declaration){
        if(!annotations.isEmpty()){
            for(String annotation: annotations){
                declaration.append(annotation);
                declaration.append("\n");
            }
        }
    }

    private void appendInterfaceDeclaration(StringBuilder declaration){
        if(Objects.nonNull(modifier)){
            declaration.append(modifier.toString().toLowerCase());
            declaration.append(" ");
        }

        declaration.append("interface ");
        declaration.append(name);
    }

    private void appendInterfaceTypeParameterDeclarations(StringBuilder declaration, List<String> typeParameters){
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

    private void appendInterfaceParentDeclaration(StringBuilder declaration){
        if(Objects.nonNull(parent)){
            declaration.append(" extends ");
            declaration.append(parent);
        }
    }

    private void appendInterfaceFieldDeclarations(StringBuilder declaration){
        if(!fields.isEmpty()){
            for(Variable field: fields){
                declaration.append(field.toString());
                declaration.append(";");
                declaration.append("\n");
            }
            declaration.append("\n");
        }
    }

    private void appendInterfaceMethodDeclarations(StringBuilder declaration){
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

    public boolean writeJavaInterface(String path){
        try(PrintWriter writer = new PrintWriter(path)){
            writer.println(this.toString());
            return true;
        } catch(FileNotFoundException e){
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getTypeParameters() {
        return typeParameters;
    }

    public Modifier.Type getModifier() {
        return modifier;
    }

    public String getParent() {
        return parent;
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

    public String getPackageName() {
        return packageName;
    }

    public List<String> getAnnotations() {
        return annotations;
    }
}
