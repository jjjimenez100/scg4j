package com.jjjimenez.SCG4J.core;

import java.util.List;

public final class Modifier {
    public enum Type{
        PRIVATE, PUBLIC, PROTECTED, STATIC, FINAL
    }

    private Modifier() {}

    private static String getAccessModifierFromList(List<Type> modifiers){
        Type accessModifier = null;

        for(Type modifier: modifiers){
            if(modifier == Type.PUBLIC || modifier == Type.PROTECTED || modifier == Type.PRIVATE){
                if(accessModifier == null){
                    accessModifier = modifier;
                } else if(accessModifier != modifier){
                    throw new MultipleAccessModifierException("Only one access modifier is allowed");
                }
            }
        }

        return accessModifier != null ? accessModifier.toString().toLowerCase() + " " : "";
    }

    private static String getNonAccessModifiersFromList(List<Type> modifiers){
        StringBuilder nonAccessModifiers = new StringBuilder();

        if(modifiers.contains(Type.STATIC)){
            int index = modifiers.indexOf(Type.STATIC);
            nonAccessModifiers.append(modifiers.get(index));
            nonAccessModifiers.append(" ");
        }

        if(modifiers.contains(Type.FINAL)){
            int index = modifiers.indexOf(Type.FINAL);
            nonAccessModifiers.append(modifiers.get(index));
            nonAccessModifiers.append(" ");
        }

        return nonAccessModifiers.toString().toLowerCase();
    }

    public static StringBuilder getCombinedModifiers(List<Type> modifiers){
        StringBuilder modifierPrefix = new StringBuilder();

        String accessModifier = getAccessModifierFromList(modifiers);
        if(!accessModifier.isEmpty()){
            modifierPrefix.append(accessModifier);
        }

        String nonAccessModifiers = getNonAccessModifiersFromList(modifiers);
        if(!nonAccessModifiers.isEmpty()){
            modifierPrefix.append(nonAccessModifiers);
        }

        return modifierPrefix;
    }
}

