package com.jjjimenez.SCG4J.core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ModifierTest {

    @Test
    public void givenStaticFinal_whenInvokingGetNonAccessModifiers_thenReturnStaticFinal(){
        List<Modifier.Type> modifiers = new ArrayList<>();
        modifiers.add(Modifier.Type.FINAL);
        modifiers.add(Modifier.Type.STATIC);

        assertEquals("static final ", Modifier.getCombinedModifiers(modifiers).toString());
    }

    @Test
    public void givenDuplicateStaticFinal_whenInvokingGetNonAccessModifiers_thenIgnoreAndReturnStaticFinal(){
        List<Modifier.Type> modifiers = new ArrayList<>();
        modifiers.add(Modifier.Type.FINAL);
        modifiers.add(Modifier.Type.STATIC);
        modifiers.add(Modifier.Type.FINAL);
        modifiers.add(Modifier.Type.STATIC);

        assertEquals("static final ", Modifier.getCombinedModifiers(modifiers).toString());
    }

    @Test
    public void givenAccessModifier_whenInvokingGetAccessModifier_thenReturnAccessModifier(){
        List<Modifier.Type> modifiers = new ArrayList<>();
        modifiers.add(Modifier.Type.PUBLIC);

        assertEquals("public ", Modifier.getCombinedModifiers(modifiers).toString());
    }

    @Test
    public void givenDuplicateAccessModifier_whenInvokingGetAccessModifier_thenIgnoreAndReturnAccessModifier(){
        List<Modifier.Type> modifiers = new ArrayList<>();
        modifiers.add(Modifier.Type.PUBLIC);
        modifiers.add(Modifier.Type.PUBLIC);

        assertEquals("public ", Modifier.getCombinedModifiers(modifiers).toString());
    }

    @Test(expected = MultipleAccessModifierException.class)
    public void givenDifferentAccessModifiers_whenInvokingGetAccessModifier_thenIgnoreAndReturnAccessModifier(){
        List<Modifier.Type> modifiers = new ArrayList<>();
        modifiers.add(Modifier.Type.PUBLIC);
        modifiers.add(Modifier.Type.PRIVATE);

        //failing test
        assertEquals("public ", Modifier.getCombinedModifiers(modifiers).toString());
    }

    @Test
    public void givenAccessModifierStaticAndFinal_whenInvokingGetCombinedModifiers_thenReturnProperStatement(){
        List<Modifier.Type> modifiers = new ArrayList<>();
        modifiers.add(Modifier.Type.PUBLIC);
        modifiers.add(Modifier.Type.STATIC);
        modifiers.add(Modifier.Type.FINAL);

        //failing test
        assertEquals("public static final ", Modifier.getCombinedModifiers(modifiers).toString());
    }
}
