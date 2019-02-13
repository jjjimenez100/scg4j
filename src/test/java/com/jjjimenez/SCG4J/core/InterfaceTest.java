package com.jjjimenez.SCG4J.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class InterfaceTest {

    @Test
    public void givenInterfaceNameAndPackage_whenToString_thenReturnProperStatement(){
        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .build();
        System.out.println(testInterface);
        assertEquals("package org.test;\n" +
                "\n" +
                "interface testInterface {\n" +
                "}", testInterface.toString());
    }

    @Test
    public void givenPublicInterfaceNameAndPackage_whenToString_thenReturnProperStatement(){
        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.PUBLIC)
                .build();
        System.out.println(testInterface);
        assertEquals("package org.test;\n" +
                "\n" +
                "public interface testInterface {\n" +
                "}", testInterface.toString());
    }

    @Test(expected = InvalidInterfaceModifier.class)
    public void givenPrivateAccessModifierInterfaceNameAndPackage_whenToString_thenThrowError(){
        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.PRIVATE)
                .build();
        System.out.println(testInterface);

        //failing test
        assertEquals("package org.test;\n" +
                "\n" +
                "public interface testInterface {\n" +
                "}", testInterface.toString());
    }

    @Test(expected = InvalidInterfaceModifier.class)
    public void givenProtectedAccessModifierInterfaceNameAndPackage_whenToString_thenThrowError(){
        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.PROTECTED)
                .build();
        System.out.println(testInterface);

        //failing test
        assertEquals("package org.test;\n" +
                "\n" +
                "public interface testInterface {\n" +
                "}", testInterface.toString());
    }

    @Test(expected = InvalidInterfaceModifier.class)
    public void givenStaticInterfaceNameAndPackage_whenToString_thenThrowError(){
        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.STATIC)
                .build();
        System.out.println(testInterface);

        //failing test
        assertEquals("package org.test;\n" +
                "\n" +
                "public interface testInterface {\n" +
                "}", testInterface.toString());
    }

    @Test(expected = InvalidInterfaceModifier.class)
    public void givenFinalInterfaceNameAndPackage_whenToString_thenThrowError(){
        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.FINAL)
                .build();
        System.out.println(testInterface);

        //failing test
        assertEquals("package org.test;\n" +
                "\n" +
                "public interface testInterface {\n" +
                "}", testInterface.toString());
    }

    @Test
    public void givenPublicInterfaceNamePackageWithSingleTypeParameter_whenToString_thenReturnProperStatement(){
        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .addTypeParameter("V")
                .modifier(Modifier.Type.PUBLIC)
                .build();
        System.out.println(testInterface);
        assertEquals("package org.test;\n" +
                "\n" +
                "public interface testInterface<V> {\n" +
                "}", testInterface.toString());
    }

    @Test
    public void givenPublicInterfaceNamePackageWithMultipleTypeParameters_whenToString_thenReturnProperStatement(){
        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .addTypeParameter("V")
                .addTypeParameter("AH")
                .addTypeParameter("BA")
                .modifier(Modifier.Type.PUBLIC)
                .build();
        System.out.println(testInterface);
        assertEquals("package org.test;\n" +
                "\n" +
                "public interface testInterface<V, AH, BA> {\n" +
                "}", testInterface.toString());
    }

    @Test
    public void givenPublicInterfaceNamePackageWithSingleTypeParameterAndParent_whenToString_thenReturnProperStatement(){
        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .addTypeParameter("V")
                .parent("CrudRepository")
                .modifier(Modifier.Type.PUBLIC)
                .build();
        System.out.println(testInterface);
        assertEquals("package org.test;\n" +
                "\n" +
                "public interface testInterface<V> extends CrudRepository {\n" +
                "}", testInterface.toString());
    }

    @Test
    public void givenPublicInterfaceNamePackageWithMultipleTypeParametersAndParent_whenToString_thenReturnProperStatement(){
        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .addTypeParameter("V")
                .addTypeParameter("DU")
                .addTypeParameter("DA")
                .parent("CrudRepository")
                .modifier(Modifier.Type.PUBLIC)
                .build();
        System.out.println(testInterface);
        assertEquals("package org.test;\n" +
                "\n" +
                "public interface testInterface<V, DU, DA> extends CrudRepository {\n" +
                "}", testInterface.toString());
    }

    @Test
    public void givenPublicInterfaceNamePackageWithMultipleTypeParametersAndParentWithSingleTypeParameter_whenToString_thenReturnProperStatement(){
        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .addTypeParameter("V")
                .addTypeParameter("DU")
                .addTypeParameter("DA")
                .addParentTypeParameter("S")
                .parent("CrudRepository")
                .modifier(Modifier.Type.PUBLIC)
                .build();
        System.out.println(testInterface);
        assertEquals("package org.test;\n" +
                "\n" +
                "public interface testInterface<V, DU, DA> extends CrudRepository<S> {\n" +
                "}", testInterface.toString());
    }

    @Test
    public void givenPublicInterfaceNamePackageWithMultipleTypeParametersAndParentWithMultipleTypeParameters_whenToString_thenReturnProperStatement(){
        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .addTypeParameter("V")
                .addTypeParameter("DU")
                .addTypeParameter("DA")
                .addParentTypeParameter("S")
                .addParentTypeParameter("HA")
                .addParentTypeParameter("HU")
                .parent("CrudRepository")
                .modifier(Modifier.Type.PUBLIC)
                .build();
        System.out.println(testInterface);
        assertEquals("package org.test;\n" +
                "\n" +
                "public interface testInterface<V, DU, DA> extends CrudRepository<S, HA, HU> {\n" +
                "}", testInterface.toString());
    }

    @Test
    public void givenPublicInterfaceNameAndPackageWithSingleMethod_whenToString_thenReturnProperStatement(){
        Method testMethod = new Method
                .Builder("testMethod")
                .returnType("void")
                .addModifier(Modifier.Type.PUBLIC)
                .build();

        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.PUBLIC)
                .addMethod(testMethod)
                .build();
        System.out.println(testInterface);
        assertEquals("package org.test;\n" +
                "\n" +
                "public interface testInterface {\n" +
                "    public void testMethod();\n" +
                "}", testInterface.toString());
    }

    @Test
    public void givenPublicInterfaceNameAndPackageWithMultipleMethods_whenToString_thenReturnProperStatement(){
        Method testMethod = new Method
                .Builder("testMethod")
                .addModifier(Modifier.Type.PUBLIC)
                .returnType("void")
                .build();

        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.PUBLIC)
                .addMethod(testMethod)
                .addMethod(testMethod)
                .build();
        System.out.println(testInterface);
        assertEquals("package org.test;\n" +
                "\n" +
                "public interface testInterface {\n" +
                "    public void testMethod();\n" +
                "\n" +
                "    public void testMethod();\n" +
                "}", testInterface.toString());
    }

    @Test
    public void givenSingleAnnotationPublicInterfaceNameAndPackageWithMultipleMethods_whenToString_thenReturnProperStatement(){
        Method testMethod = new Method
                .Builder("testMethod")
                .addModifier(Modifier.Type.PUBLIC)
                .returnType("void")
                .build();

        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.PUBLIC)
                .addAnnotation("@Test")
                .addMethod(testMethod)
                .addMethod(testMethod)
                .build();
        System.out.println(testInterface);
        assertEquals("package org.test;\n" +
                "\n" +
                "@Test\n" +
                "public interface testInterface {\n" +
                "    public void testMethod();\n" +
                "\n" +
                "    public void testMethod();\n" +
                "}", testInterface.toString());
    }

    @Test
    public void givenMultipleAnnotationsPublicInterfaceNameAndPackageWithMultipleMethods_whenToString_thenReturnProperStatement(){
        Method testMethod = new Method
                .Builder("testMethod")
                .returnType("void")
                .addModifier(Modifier.Type.PUBLIC)
                .build();

        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.PUBLIC)
                .addAnnotation("@Test")
                .addAnnotation("@Graphify")
                .addAnnotation("@Mod")
                .addMethod(testMethod)
                .addMethod(testMethod)
                .build();
        System.out.println(testInterface);
        assertEquals("package org.test;\n" +
                "\n" +
                "@Test\n" +
                "@Graphify\n" +
                "@Mod\n" +
                "public interface testInterface {\n" +
                "    public void testMethod();\n" +
                "\n" +
                "    public void testMethod();\n" +
                "}", testInterface.toString());
    }

    @Test
    public void givenTwoInstancesWithSameProperties_whenCallingEquals_thenReturnTrue(){
        Method testMethod = new Method
                .Builder("testMethod")
                .addModifier(Modifier.Type.PUBLIC)
                .returnType("void")
                .build();

        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.PUBLIC)
                .addMethod(testMethod)
                .build();

        Method testMethodTwo = new Method
                .Builder("testMethod")
                .addModifier(Modifier.Type.PUBLIC)
                .build();

        Interface testInterfaceTwo = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.PUBLIC)
                .addMethod(testMethod)
                .build();

        assertTrue(testInterface.equals(testInterfaceTwo));
        assertTrue(testInterfaceTwo.equals(testInterface));
    }

    @Test
    public void givenTwoInstancesWithDiffProperties_whenCallingEquals_thenReturnFalse(){
        Method testMethod = new Method
                .Builder("testMethod")
                .addModifier(Modifier.Type.PUBLIC)
                .returnType("void")
                .build();

        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.PUBLIC)
                .addMethod(testMethod)
                .build();

        Method testMethodTwo = new Method
                .Builder("testMethod")
                .addModifier(Modifier.Type.PUBLIC)
                .build();

        Interface testInterfaceTwo = new Interface
                .Builder("testInterfacessssss", "org.test")
                .modifier(Modifier.Type.PUBLIC)
                .addMethod(testMethod)
                .build();

        assertFalse(testInterface.equals(testInterfaceTwo));
        assertFalse(testInterfaceTwo.equals(testInterface));
    }

    @Test
    public void givenTwoInstancesWithSameProperties_whenComparingHashCode_thenReturnTrue(){
        Method testMethod = new Method
                .Builder("testMethod")
                .addModifier(Modifier.Type.PUBLIC)
                .build();

        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.PUBLIC)
                .addMethod(testMethod)
                .build();

        Method testMethodTwo = new Method
                .Builder("testMethod")
                .addModifier(Modifier.Type.PUBLIC)
                .build();

        Interface testInterfaceTwo = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.PUBLIC)
                .addMethod(testMethod)
                .build();

        assertTrue(testInterface.hashCode() == testInterfaceTwo.hashCode());
        assertTrue(testInterfaceTwo.hashCode() == testInterface.hashCode());
    }

    @Test
    public void givenTwoInstancesWithDiffProperties_whenComparingHashCode_thenReturnFalse(){
        Method testMethod = new Method
                .Builder("testMethod")
                .addModifier(Modifier.Type.PUBLIC)
                .build();

        Interface testInterface = new Interface
                .Builder("testInterface", "org.test")
                .modifier(Modifier.Type.PUBLIC)
                .addMethod(testMethod)
                .build();

        Method testMethodTwo = new Method
                .Builder("testMethod")
                .addModifier(Modifier.Type.PUBLIC)
                .build();

        Interface testInterfaceTwo = new Interface
                .Builder("testInterfacessssss", "org.test")
                .modifier(Modifier.Type.PUBLIC)
                .addMethod(testMethod)
                .build();

        assertFalse(testInterface.hashCode() == testInterfaceTwo.hashCode());
        assertFalse(testInterfaceTwo.hashCode() == testInterface.hashCode());
    }
}
