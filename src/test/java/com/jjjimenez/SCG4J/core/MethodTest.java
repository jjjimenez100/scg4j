package com.jjjimenez.SCG4J.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class MethodTest {

    @Test
    public void givenTwoInstancesWithSameProperties_whenCallingEquals_thenReturnTrue(){
        StatementBlock statements = new StatementBlock("return 1;");
        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .build();

        StatementBlock statementsTwo = new StatementBlock("return 1;");
        Method testMethodTwo = new Method
                .Builder("test")
                .statements(statementsTwo)
                .build();

        assertTrue(testMethod.equals(testMethodTwo));
        assertTrue(testMethodTwo.equals(testMethod));
    }

    @Test
    public void givenTwoInstancesWithSameProperties_whenComparingHashCode_thenReturnTrue(){
        StatementBlock statements = new StatementBlock("return 1;");
        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .build();

        StatementBlock statementsTwo = new StatementBlock("return 1;");
        Method testMethodTwo = new Method
                .Builder("test")
                .statements(statementsTwo)
                .build();

        assertTrue(testMethod.hashCode() == testMethodTwo.hashCode());
    }

    @Test
    public void givenTwoInstancesWithDifferentProperties_whenCallingEquals_thenReturnFalse(){
        StatementBlock statements = new StatementBlock("return 12;");
        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .build();

        StatementBlock statementsTwo = new StatementBlock("return 1;");
        Method testMethodTwo = new Method
                .Builder("test")
                .statements(statementsTwo)
                .build();

        assertFalse(testMethod.equals(testMethodTwo));
        assertFalse(testMethodTwo.equals(testMethod));
    }

    @Test
    public void givenTwoInstancesWithDifferentProperties_whenComparingHashCode_thenReturnFalse(){
        StatementBlock statements = new StatementBlock("return 12;");
        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .build();

        StatementBlock statementsTwo = new StatementBlock("return 1;");
        Method testMethodTwo = new Method
                .Builder("test")
                .statements(statementsTwo)
                .build();

        assertFalse(testMethod.hashCode() == testMethodTwo.hashCode());
    }

    @Test
    public void givenConstructorMethod_whenCallingMethodToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(\"Hi\"");
        Method test = new Method
                .Builder("ConsTrucTor")
                .addModifier(Modifier.Type.PUBLIC)
                .statements(statements)
                .build();

        assertEquals("    public ConsTrucTor(){\n" +
                "        System.out.println(\"Hi\"\n" +
                "    }", test.toString());
    }

    @Test
    public void givenReturnTypeAndMethodNameAndNoParametersWithSingleStatement_whenCallingMethodToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("return 1;");
        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .returnType("void")
                .build();

        System.out.println(testMethod);
        assertEquals("    void test(){\n" +
                "        return 1;\n" +
                "    }", testMethod.toString());
    }

    @Test
    public void givenReturnTypeAndMethodNameAndNoParametersWithNoStatement_whenCallingMethodToString_thenReturnProperStatement(){
        Method testMethod = new Method
                .Builder("test")
                .returnType("void")
                .build();

        System.out.println(testMethod);
        assertEquals("    void test();", testMethod.toString());
    }

    @Test
    public void givenReturnTypeAndMethodNameAndSingleParameterWithNoStatement_whenCallingMethodToString_thenReturnProperStatement(){
        Variable parameter = new Variable.Builder("x", "int", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .addParameter(parameter)
                .returnType("void")
                .build();

        System.out.println(testMethod);
        assertEquals("    void test(int x);", testMethod.toString());
    }

    @Test
    public void givenReturnTypeAndMethodNameAndMultipleParametersWithNoStatement_whenCallingMethodToString_thenReturnProperStatement(){
        Variable parameter = new Variable.Builder("x", "int", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .addParameter(parameter)
                .addParameter(parameter)
                .returnType("void")
                .returnType("void")
                .build();

        System.out.println(testMethod);
        assertEquals("    void test(int x, int x);", testMethod.toString());
    }

    @Test
    public void givenAccessModifierReturnTypeAndMethodNameAndMultipleParametersWithNoStatement_whenCallingMethodToString_thenReturnProperStatement(){
        Variable parameter = new Variable.Builder("x", "int", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .addModifier(Modifier.Type.PUBLIC)
                .addParameter(parameter)
                .returnType("void")
                .addParameter(parameter)
                .build();

        System.out.println(testMethod);
        assertEquals("    public void test(int x, int x);", testMethod.toString());
    }

    @Test
    public void givenReturnTypeAndMethodNameAndSingleParameterWithSingleStatement_whenCallingMethodToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("return x;");
        Variable parameter = new Variable.Builder("x", "int", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .addParameter(parameter)
                .returnType("void")
                .build();

        System.out.println(testMethod);
        assertEquals("    void test(int x){\n" +
                "        return x;\n" +
                "    }", testMethod.toString());
    }

    @Test
    public void givenReturnTypeAndMethodNameAndMultipleParametersWithMultipleStatements_whenCallingMethodToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(x + y + z);", "System.out.print(\"Hello\");");

        Variable parameterOne = new Variable.Builder("x", "int", 0).build();
        Variable parameterTwo = new Variable.Builder("y", "String", 0).build();
        Variable parameterThree = new Variable.Builder("z", "double", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .addParameter(parameterOne)
                .addParameter(parameterTwo)
                .addParameter(parameterThree)
                .returnType("void")
                .build();

        System.out.println(testMethod);
        assertEquals("    void test(int x, String y, double z){\n" +
                "        System.out.println(x + y + z);\n" +
                "        System.out.print(\"Hello\");\n" +
                "    }", testMethod.toString());
    }

    @Test
    public void givenStaticAndReturnTypeAndMethodNameAndMultipleParametersWithMultipleStatements_whenCallingMethodToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(x + y + z);", "System.out.print(\"Hello\");");

        Variable parameterOne = new Variable.Builder("x", "int", 0).build();
        Variable parameterTwo = new Variable.Builder("y", "String", 0).build();
        Variable parameterThree = new Variable.Builder("z", "double", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .addParameter(parameterOne)
                .addParameter(parameterTwo)
                .addParameter(parameterThree)
                .returnType("void")
                .addModifier(Modifier.Type.STATIC)
                .build();

        System.out.println(testMethod);
        assertEquals("    static void test(int x, String y, double z){\n" +
                "        System.out.println(x + y + z);\n" +
                "        System.out.print(\"Hello\");\n" +
                "    }", testMethod.toString());
    }

    @Test
    public void givenFinalAndReturnTypeAndMethodNameAndMultipleParametersWithMultipleStatements_whenCallingMethodToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(x + y + z);", "System.out.print(\"Hello\");");

        Variable parameterOne = new Variable.Builder("x", "int", 0).build();
        Variable parameterTwo = new Variable.Builder("y", "String", 0).build();
        Variable parameterThree = new Variable.Builder("z", "double", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .addParameter(parameterOne)
                .addParameter(parameterTwo)
                .addParameter(parameterThree)
                .addModifier(Modifier.Type.FINAL)
                .returnType("void")
                .build();

        System.out.println(testMethod);
        assertEquals("    final void test(int x, String y, double z){\n" +
                "        System.out.println(x + y + z);\n" +
                "        System.out.print(\"Hello\");\n" +
                "    }", testMethod.toString());
    }

    @Test
    public void givenStaticAndFinalAndReturnTypeAndMethodNameAndMultipleParametersWithMultipleStatements_whenCallingMethodToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(x + y + z);", "System.out.print(\"Hello\");");

        Variable parameterOne = new Variable.Builder("x", "int", 0).build();
        Variable parameterTwo = new Variable.Builder("y", "String", 0).build();
        Variable parameterThree = new Variable.Builder("z", "double", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .addParameter(parameterOne)
                .addParameter(parameterTwo)
                .addParameter(parameterThree)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .returnType("void")
                .build();

        System.out.println(testMethod);
        assertEquals("    static final void test(int x, String y, double z){\n" +
                "        System.out.println(x + y + z);\n" +
                "        System.out.print(\"Hello\");\n" +
                "    }", testMethod.toString());
    }

    @Test
    public void givenDuplicateStaticFinalAndReturnTypeAndMethodNameAndMultipleParametersWithMultipleStatements_whenCallingMethodToString_thenIgnoreDuplicatesAndReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(x + y + z);", "System.out.print(\"Hello\");");

        Variable parameterOne = new Variable.Builder("x", "int", 0).build();
        Variable parameterTwo = new Variable.Builder("y", "String", 0).build();
        Variable parameterThree = new Variable.Builder("z", "double", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .addParameter(parameterOne)
                .addParameter(parameterTwo)
                .addParameter(parameterThree)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.STATIC)
                .returnType("void")
                .build();

        System.out.println(testMethod);
        assertEquals("    static final void test(int x, String y, double z){\n" +
                "        System.out.println(x + y + z);\n" +
                "        System.out.print(\"Hello\");\n" +
                "    }", testMethod.toString());
    }

    @Test
    public void givenAccessModifiersWithStaticFinalAndReturnTypeAndMethodNameAndMultipleParametersAndStatements_whenCallingMethodToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(x + y + z);", "System.out.print(\"Hello\");");

        Variable parameterOne = new Variable.Builder("x", "int", 0).build();
        Variable parameterTwo = new Variable.Builder("y", "String", 0).build();
        Variable parameterThree = new Variable.Builder("z", "double", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .addParameter(parameterOne)
                .addParameter(parameterTwo)
                .addParameter(parameterThree)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.PRIVATE)
                .returnType("void")
                .build();

        assertEquals("    private static final void test(int x, String y, double z){\n" +
                "        System.out.println(x + y + z);\n" +
                "        System.out.print(\"Hello\");\n" +
                "    }", testMethod.toString());
        System.out.println(testMethod);
    }

    @Test
    public void givenSingleAnnotationAccessModifiersWithStaticFinalAndReturnTypeAndMethodNameAndMultipleParametersAndStatements_whenCallingMethodToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(x + y + z);", "System.out.print(\"Hello\");");

        Variable parameterOne = new Variable.Builder("x", "int", 0).build();
        Variable parameterTwo = new Variable.Builder("y", "String", 0).build();
        Variable parameterThree = new Variable.Builder("z", "double", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .addParameter(parameterOne)
                .addParameter(parameterTwo)
                .addParameter(parameterThree)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.PRIVATE)
                .returnType("void")
                .addAnnotation("@Test")
                .build();

        System.out.println(testMethod);
        assertEquals("    @Test\n    private static final void test(int x, String y, double z){\n" +
                "        System.out.println(x + y + z);\n" +
                "        System.out.print(\"Hello\");\n" +
                "    }", testMethod.toString());

    }

    @Test
    public void givenMultipleAnnotationsAccessModifiersWithStaticFinalAndReturnTypeAndMethodNameAndMultipleParametersAndStatements_whenCallingMethodToString_thenReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(x + y + z);", "System.out.print(\"Hello\");");

        Variable parameterOne = new Variable.Builder("x", "int", 0).build();
        Variable parameterTwo = new Variable.Builder("y", "String", 0).build();
        Variable parameterThree = new Variable.Builder("z", "double", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .addParameter(parameterOne)
                .addParameter(parameterTwo)
                .addParameter(parameterThree)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.PRIVATE)
                .returnType("void")
                .addAnnotation("@Test")
                .addAnnotation("@Graphify")
                .addAnnotation("@Duh")
                .build();

        System.out.println(testMethod);
        assertEquals("    @Test\n" +
                "    @Graphify\n" +
                "    @Duh\n" +
                "    private static final void test(int x, String y, double z){\n" +
                "        System.out.println(x + y + z);\n" +
                "        System.out.print(\"Hello\");\n" +
                "    }", testMethod.toString());

    }

    @Test
    public void givenDuplicateAccessModifiersWithStaticFinalAndReturnTypeAndMethodNameAndMultipleParametersAndStatements_whenCallingMethodToString_thenIgnoreAndReturnProperStatement(){
        StatementBlock statements = new StatementBlock("System.out.println(x + y + z);", "System.out.print(\"Hello\");");

        Variable parameterOne = new Variable.Builder("x", "int", 0).build();
        Variable parameterTwo = new Variable.Builder("y", "String", 0).build();
        Variable parameterThree = new Variable.Builder("z", "double", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .addParameter(parameterOne)
                .addParameter(parameterTwo)
                .addParameter(parameterThree)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.PRIVATE)
                .returnType("void")
                .build();

        System.out.println(testMethod);
        assertEquals("    private static final void test(int x, String y, double z){\n" +
                "        System.out.println(x + y + z);\n" +
                "        System.out.print(\"Hello\");\n" +
                "    }", testMethod.toString());
    }

    @Test(expected = MultipleAccessModifierException.class)
    public void givenDifferentAccessModifiersWithStaticFinalAndReturnTypeAndMethodNameAndMultipleParametersAndStatements_whenCallingMethodToString_thenThrowError(){
        StatementBlock statements = new StatementBlock("System.out.println(x + y + z);", "System.out.print(\"Hello\");");

        Variable parameterOne = new Variable.Builder("x", "int", 0).build();
        Variable parameterTwo = new Variable.Builder("y", "String", 0).build();
        Variable parameterThree = new Variable.Builder("z", "double", 0).build();

        Method testMethod = new Method
                .Builder("test")
                .statements(statements)
                .addParameter(parameterOne)
                .addParameter(parameterTwo)
                .addParameter(parameterThree)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.PUBLIC)
                .returnType("void")
                .build();

        // failing test, throws MAME exception
        assertEquals("private static final void test(int x, String y, double z){\n" +
                "System.out.println(x + y + z);\n" +
                "System.out.print(\"Hello\");\n" +
                "}", testMethod.toString());
    }
}
