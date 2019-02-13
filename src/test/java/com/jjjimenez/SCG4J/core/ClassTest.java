
package com.jjjimenez.SCG4J.core;

import org.junit.Test;
import java.io.File;
import static org.junit.Assert.*;

//TODO: rename test cases to shorter names
public class ClassTest {
    @Test
    public void givenImportsClassName_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addImport("import java.util.Scanner;")
                .addImport("import java.util.Arrays;")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n" +
                "\n" +
                "import java.util.Scanner;\n" +
                "import java.util.Arrays;\n" +
                "\n" +
                "class testClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassName_whenCallingClassToString_thenReturnProperStatement(){
       Class testClass = new Class.Builder("testClass", "test.package").build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass testClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAndSingleTypeParameter_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addTypeParameter("T")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass testClass<T> {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameSingleTypeParameterAndParent_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addTypeParameter("T")
                .parent("TestParent")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass testClass<T> extends TestParent {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameSingleTypeParameterParentAndSingleParentTypeParameter_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addTypeParameter("T")
                .parent("TestParent")
                .addParentTypeParameter("V")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass testClass<T> extends TestParent<V> {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameSingleTypeParameterParentAndMultipleParentTypeParameters_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addTypeParameter("T")
                .parent("TestParent")
                .addParentTypeParameter("V")
                .addParentTypeParameter("U")
                .addParentTypeParameter("W")
                .addParentTypeParameter("X")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass testClass<T> extends TestParent<V, U, W, X> {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAndMultipleTypeParameters_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addTypeParameter("T")
                .addTypeParameter("U")
                .addTypeParameter("V")
                .addTypeParameter("W")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass testClass<T, U, V, W> {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameMultipleTypeParametersAndParent_whenCallingClassToString_thenReturnProperStatement() {
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addTypeParameter("T")
                .addTypeParameter("U")
                .addTypeParameter("V")
                .addTypeParameter("W")
                .parent("ParentTest")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass testClass<T, U, V, W> extends ParentTest {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameMultipleTypeParametersParentAndSingleParentTypeParameter_whenCallingClassToString_thenReturnProperStatement() {
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addTypeParameter("T")
                .addTypeParameter("U")
                .addTypeParameter("V")
                .addTypeParameter("W")
                .parent("ParentTest")
                .addParentTypeParameter("T")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass testClass<T, U, V, W> extends ParentTest<T> {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameMultipleTypeParametersParentAndMultipleParentTypeParameters_whenCallingClassToString_thenReturnProperStatement() {
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addTypeParameter("T")
                .addTypeParameter("U")
                .addTypeParameter("V")
                .addTypeParameter("W")
                .parent("ParentTest")
                .addParentTypeParameter("T")
                .addParentTypeParameter("U")
                .addParentTypeParameter("V")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass testClass<T, U, V, W> extends ParentTest<T, U, V> {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAndParent_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .parent("TestParent")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass testClass extends TestParent {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAndAccessModifier_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.PUBLIC)
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\npublic class testClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAndStatic_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.STATIC)
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nstatic class testClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAndFinal_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.FINAL)
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nfinal class testClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameFinalAndStatic_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nstatic final class testClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAccessModifierAndStatic_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.STATIC)
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nprivate static class testClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAccessModifierAndFinal_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.FINAL)
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nprivate final class testClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAccessModifierStaticAndFinal_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.FINAL)
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nprivate static final class testClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameStaticAndParent_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.STATIC)
                .parent("ParentTestClass")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nstatic class testClass extends ParentTestClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAccessModifierStaticAndParent_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.PROTECTED)
                .parent("ParentTestClass")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nprotected static class testClass extends ParentTestClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameFinalAndParent_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.FINAL)
                .parent("ParentTestClass")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nfinal class testClass extends ParentTestClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAccessModifierFinalAndParent_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.PUBLIC)
                .parent("ParentTestClass")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\npublic final class testClass extends ParentTestClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameStaticFinalAndParent_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .parent("ParentTestClass")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nstatic final class testClass extends ParentTestClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAccessModifierStaticFinalAndParent_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.PRIVATE)
                .parent("ParentTestClass")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nprivate static final class testClass extends ParentTestClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAccessModifierStaticFinalSingleTypeParameterAndParent_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.PRIVATE)
                .addTypeParameter("I")
                .parent("ParentTestClass")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nprivate static final class testClass<I> extends ParentTestClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAccessModifierStaticFinalMultipleTypeParametersAndParent_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.PRIVATE)
                .addTypeParameter("I")
                .addTypeParameter("A")
                .addTypeParameter("B")
                .parent("ParentTestClass")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nprivate static final class testClass<I, A, B> extends ParentTestClass {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAccessModifierStaticFinalMultipleTypeParametersParentAndSingleParentTypeParameter_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.PRIVATE)
                .addTypeParameter("I")
                .addTypeParameter("A")
                .addTypeParameter("B")
                .parent("ParentTestClass")
                .addParentTypeParameter("B")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nprivate static final class testClass<I, A, B> extends ParentTestClass<B> {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAccessModifierStaticFinalMultipleTypeParametersParentAndMultipleParentTypeParameters_whenCallingClassToString_thenReturnProperStatement(){
        Class testClass = new Class
                .Builder("testClass", "test.package")
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.PRIVATE)
                .addTypeParameter("I")
                .addTypeParameter("A")
                .addTypeParameter("B")
                .parent("ParentTestClass")
                .addParentTypeParameter("B")
                .addParentTypeParameter("I")
                .addParentTypeParameter("Z")
                .build();
        System.out.println(testClass);
        assertEquals("package test.package;\n\nprivate static final class testClass<I, A, B> extends ParentTestClass<B, I, Z> {\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAndSingleMethod_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass ClassTest {\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameSingleMethodAndSingleField_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addField(field)
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass ClassTest {\n" +
                "    char testVar;\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameSingleMethodAndMultipleFields_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass ClassTest {\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameAndMultipleMethods_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass ClassTest {\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameMultipleMethodsAndSingleField_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass ClassTest {\n" +
                "    char testVar;\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenClassNameMultipleMethodsAndMultipleFields_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n\nclass ClassTest {\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenStaticClassNameMultipleMethodsAndMultipleFields_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .addModifier(Modifier.Type.STATIC)
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n\nstatic class ClassTest {\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenFinalClassNameMultipleMethodsAndMultipleFields_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .addModifier(Modifier.Type.FINAL)
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n\nfinal class ClassTest {\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenStaticFinalClassNameMultipleMethodsAndMultipleFields_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n\nstatic final class ClassTest {\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenAccessModifierStaticFinalClassNameMultipleMethodsAndMultipleFields_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .addModifier(Modifier.Type.PUBLIC)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n\npublic static final class ClassTest {\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenSingleAnnotationAccessModifierStaticFinalClassNameMultipleMethodsAndMultipleFields_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .addModifier(Modifier.Type.PUBLIC)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addAnnotation("@Test")
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n" +
                "\n" +
                "@Test\n" +
                "public static final class ClassTest {\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenMultipleAnnotationsAccessModifierStaticFinalClassNameMultipleMethodsAndMultipleFields_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .addModifier(Modifier.Type.PUBLIC)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addAnnotation("@Test")
                .addAnnotation("@Graphify")
                .addAnnotation("@Dud")
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n" +
                "\n" +
                "@Test\n" +
                "@Graphify\n" +
                "@Dud\n"+
                "public static final class ClassTest {\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenMultipleAnnotationsOnIntegrationAccessModifierStaticFinalClassNameMultipleMethodsAndMultipleFields_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .addAnnotation("@Variable")
                .addAnnotation("@Dummy")
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .addAnnotation("@Method")
                .addAnnotation("@DummyMethod")
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .addModifier(Modifier.Type.PUBLIC)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addAnnotation("@Test")
                .addAnnotation("@Graphify")
                .addAnnotation("@Dud")
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n" +
                "\n" +
                "@Test\n" +
                "@Graphify\n" +
                "@Dud\n" +
                "public static final class ClassTest {\n" +
                "    @Variable\n" +
                "    @Dummy\n" +
                "    char testVar;\n" +
                "    @Variable\n" +
                "    @Dummy\n" +
                "    char testVar;\n" +
                "    @Variable\n" +
                "    @Dummy\n" +
                "    char testVar;\n" +
                "\n" +
                "    @Method\n" +
                "    @DummyMethod\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "\n" +
                "    @Method\n" +
                "    @DummyMethod\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenAccessModifierStaticFinalClassNameMultipleMethodsMultipleFieldsAndMultipleTypeParameters_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .addModifier(Modifier.Type.PUBLIC)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addTypeParameter("U")
                .addTypeParameter("V")
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n\npublic static final class ClassTest<U, V> {\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenAccessModifierStaticFinalClassNameMultipleMethodsMultipleFieldsMultipleTypeParametersParentAndMultipleParentTypeParameters_whenCallingClassToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .addModifier(Modifier.Type.PUBLIC)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addTypeParameter("U")
                .addTypeParameter("V")
                .parent("TestClass")
                .addParentTypeParameter("U")
                .addParentTypeParameter("V")
                .build();

        System.out.println(testClass);
        assertEquals("package test.package;\n\npublic static final class ClassTest<U, V> extends TestClass<U, V> {\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "    char testVar;\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "\n" +
                "    void printHello(){\n" +
                "        System.out.println(\"Hello\");\n" +
                "        System.out.println(1);\n" +
                "    }\n" +
                "}", testClass.toString());
    }

    @Test
    public void givenTwoInstancesWithSameProperties_whenCallingClassEquals_thenReturnTrue(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Variable fieldTwo = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .build();

        Class testClassTwo = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(fieldTwo)
                .addField(fieldTwo)
                .addField(fieldTwo)
                .build();

        assertTrue(testClass.equals(testClassTwo));
        assertTrue(testClassTwo.equals(testClass));
    }

    @Test
    public void givenTwoInstancesWithSameProperties_whenComparingClassHashCode_thenReturnTrue(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Variable fieldTwo = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .build();

        Class testClassTwo = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(fieldTwo)
                .addField(fieldTwo)
                .addField(fieldTwo)
                .build();

        assertTrue(testClass.hashCode() == testClassTwo.hashCode());
    }

    @Test
    public void givenTwoInstancesWithDiffProperties_whenCallingClassEquals_thenReturnFalse(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Variable fieldTwo = new Variable
                .Builder("testVar22222", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .build();

        Class testClassTwo = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(fieldTwo)
                .addField(fieldTwo)
                .addField(fieldTwo)
                .build();

        assertFalse(testClass.equals(testClassTwo));
        assertFalse(testClassTwo.equals(testClass));
    }

    @Test
    public void givenTwoInstancesWithDiffProperties_whenComparingClassHashCode_thenReturnFalse() {
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Variable fieldTwo = new Variable
                .Builder("testVar222", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .build();

        Class testClassTwo = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(fieldTwo)
                .addField(fieldTwo)
                .addField(fieldTwo)
                .build();
        assertFalse(testClass.hashCode() == testClassTwo.hashCode());
    }

    @Test
    public void givenClassInstance_whenCallingWriteJavaClass_thenWriteFileToPath(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hello\");", "System.out.println(1);");
        Variable field = new Variable
                .Builder("testVar", "char", 1)
                .build();

        Method print = new Method
                .Builder("printHello")
                .statements(statements)
                .returnType("void")
                .build();

        Class testClass = new Class
                .Builder("ClassTest", "test.package")
                .addMethod(print)
                .addMethod(print)
                .addField(field)
                .addField(field)
                .addField(field)
                .addModifier(Modifier.Type.PUBLIC)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addTypeParameter("U")
                .addTypeParameter("V")
                .parent("TestClass")
                .addParentTypeParameter("U")
                .addParentTypeParameter("V")
                .build();

        testClass.writeJavaClass("ClassTest.java");
        File javaFile = new File("ClassTest.java");
        assertTrue(javaFile.exists());
    }
}
