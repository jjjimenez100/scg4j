
package com.jjjimenez.SCG4J.core;

import static org.junit.Assert.*;

import org.junit.Test;
public class VariableTest {
    @Test
    public void givenNameTypeAndNestedLevel_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 2)
                .build();
        System.out.println(testVar);
        assertEquals("        int test", testVar.toString());
    }

    @Test
    public void givenNameTypeNestedLevelAndValue_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 2)
                .value("5")
                .build();
        System.out.println(testVar);
        assertEquals("        int test = 5", testVar.toString());
    }

    @Test
    public void givenNameTypeNestedLevelAndAccessModifier_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.PUBLIC)
                .build();
        System.out.println(testVar);
        assertEquals("    public int test", testVar.toString());
    }

    @Test
    public void givenNameTypeNestedLevelAccessModifierAndValue_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.PUBLIC)
                .value("10")
                .build();
        System.out.println(testVar);
        assertEquals("    public int test = 10", testVar.toString());
    }

    @Test
    public void givenDuplicateAccessModifier_whenCallingVariableToString_thenIgnoreDuplicate(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.PUBLIC)
                .addModifier(Modifier.Type.PUBLIC)
                .build();
        System.out.println(testVar);
        assertEquals("    public int test", testVar.toString());
    }

    @Test(expected = MultipleAccessModifierException.class)
    public void givenDifferentAccessModifiers_whenCallingVariableToString_thenThrowError(){
        Variable testVar = new Variable
                .Builder("test", "int", 3)
                .addModifier(Modifier.Type.PUBLIC)
                .addModifier(Modifier.Type.PRIVATE)
                .build();
        System.out.println(testVar);
        //failing test
        assertEquals("    public int test", testVar.toString());
    }

    @Test
    public void givenStatic_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.STATIC)
                .build();
        System.out.println(testVar);
        assertEquals("    static int test", testVar.toString());
    }

    @Test
    public void givenStaticWithValue_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.STATIC)
                .value("9999")
                .build();
        System.out.println(testVar);
        assertEquals("    static int test = 9999", testVar.toString());
    }

    @Test
    public void givenFinal_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.FINAL)
                .build();
        System.out.println(testVar);
        assertEquals("    final int test", testVar.toString());
    }

    @Test
    public void givenStaticAndFinal_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.FINAL)
                .build();
        System.out.println(testVar);
        assertEquals("    static final int test", testVar.toString());
    }

    @Test
    public void givenDuplicateStatic_whenCallingVariableToString_thenIgnoreDuplicate(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.STATIC)
                .build();
        System.out.println(testVar);
        assertEquals("    static int test", testVar.toString());
    }

    @Test
    public void givenDuplicateFinal_whenCallingVariableToString_thenIgnoreDuplicate(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.FINAL)
                .build();
        System.out.println(testVar);
        assertEquals("    final int test", testVar.toString());
    }

    @Test
    public void givenDuplicateFinalAndStatic_whenCallingVariableToString_thenIgnoreDuplicates(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .addModifier(Modifier.Type.STATIC)
                .build();
        System.out.println(testVar);
        assertEquals("    static final int test", testVar.toString());
    }

    @Test
    public void givenModifiersAndStatic_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.STATIC)
                .build();
        System.out.println(testVar);
        assertEquals("    private static int test", testVar.toString());
    }

    @Test
    public void givenModifiersStaticAndValue_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.STATIC)
                .value("23")
                .build();
        System.out.println(testVar);
        assertEquals("    private static int test = 23", testVar.toString());
    }

    @Test
    public void givenSingleAnnotationModifiersStaticAndValue_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.STATIC)
                .addAnnotation("@Test")
                .value("23")
                .build();
        System.out.println(testVar);
        assertEquals("    @Test\n" +
                "    private static int test = 23", testVar.toString());
    }

    @Test
    public void givenMultipleAnnotationsModifiersStaticAndValue_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.STATIC)
                .addAnnotation("@Test")
                .addAnnotation("@Graphify")
                .addAnnotation("@Duh")
                .value("23")
                .build();
        System.out.println(testVar);
        assertEquals("    @Test\n" +
                "    @Graphify\n" +
                "    @Duh\n" +
                "    private static int test = 23", testVar.toString());
    }

    @Test
    public void givenModifiersAndFinal_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.FINAL)
                .build();
        System.out.println(testVar);
        assertEquals("    private final int test", testVar.toString());
    }

    @Test
    public void givenModifiersFinalAndValue_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.FINAL)
                .value("9182")
                .build();
        System.out.println(testVar);
        assertEquals("    private final int test = 9182", testVar.toString());
    }

    @Test
    public void givenModifiersStaticAndFinal_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .build();
        System.out.println(testVar);
        assertEquals("    private static final int test", testVar.toString());
    }

    @Test
    public void givenModifiersStaticFinalAndValue_whenCallingVariableToString_thenReturnProperStatement(){
        Variable testVar = new Variable
                .Builder("test", "int", 1)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .value("293")
                .build();
        System.out.println(testVar);
        assertEquals("    private static final int test = 293", testVar.toString());
    }

    @Test
    public void givenTwoInstancesWithSameProperties_whenCallingVariableEquals_thenReturnTrue(){
        Variable testVar = new Variable
                .Builder("test", "int", 3)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .build();

        Variable secondTestVar = new Variable
                .Builder("test", "int", 3)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .build();

        assertTrue(testVar.equals(secondTestVar));
        assertTrue(secondTestVar.equals(testVar));
    }

    @Test
    public void givenTwoInstancesWithSameProperties_whenComparingHashCode_thenReturnTrue(){
        Variable testVar = new Variable
                .Builder("test", "int", 3)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .build();

        Variable secondTestVar = new Variable
                .Builder("test", "int", 3)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .build();

        assertTrue(testVar.hashCode() == secondTestVar.hashCode());
    }

    @Test
    public void givenTwoInstancesWithDiffProperties_whenCallingVariableEquals_thenReturnFalse(){
        Variable testVar = new Variable
                .Builder("test1", "int", 3)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .build();

        Variable secondTestVar = new Variable
                .Builder("test2", "int", 3)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .build();

        assertFalse(testVar.equals(secondTestVar));
        assertFalse(secondTestVar.equals(testVar));
    }

    @Test
    public void givenTwoInstancesWithDiffProperties_whenComparingHashCode_thenReturnFalse(){
        Variable testVar = new Variable
                .Builder("test1", "int", 3)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .build();

        Variable secondTestVar = new Variable
                .Builder("test2", "int", 3)
                .addModifier(Modifier.Type.PRIVATE)
                .addModifier(Modifier.Type.FINAL)
                .addModifier(Modifier.Type.STATIC)
                .build();

        assertFalse(testVar.hashCode() == secondTestVar.hashCode());
    }
}
