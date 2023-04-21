package edu.dzmtr.zrch.java.core.generics.case22;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case22 {

    public static void main(String[] args) {
        Class<?> genericType = findSuperClassParameterType(new MyStringSubClass(), MyGenericClass.class, 0);
        assert genericType == String.class : "Should be String class";

        try {
            genericType = findSuperClassParameterType(new MyGenericClass<String>(), MyGenericClass.class, 0);
        } catch (ClassCastException e) {
            System.out.println(
                "generic information can only be retrieved with the help of a descendant of the generified type "
                    + "because descendant extends or implements it with specific type argument");
        }

        genericType = findSubClassParameterType(new AnotherGenericStringSubclass(), MyGenericClass.class, 0);

        MyGenericOuterClass<String>.MyGenericInnerClass<String> inner = new MyGenericOuterClass().new MyGenericInnerClass();
    }

    public static Class<?> findSuperClassParameterType(Object instance, Class<?> classOfInterest, int parameterIndex) {
        Class<?> descendant = instance.getClass();
        Class<?> parentClass = instance.getClass();
        while (parentClass != classOfInterest) {
            descendant = parentClass;
            // instance.getClass() is no subclass of classOfInterest or instance is a direct instance of classOfInterest
            parentClass = parentClass.getSuperclass();
            if (parentClass == null) {
                throw new IllegalArgumentException();
            }
        }
        ParameterizedType parameterizedType = (ParameterizedType) descendant.getGenericSuperclass();
        return (Class<?>) parameterizedType.getActualTypeArguments()[parameterIndex];
    }

    public static Class<?> findSubClassParameterType(Object instance, Class<?> classOfInterest, int parameterIndex) {
        Map<Type, Type> typeMap = new HashMap<>();
        Class<?> instanceClass = instance.getClass();
        while (classOfInterest != instanceClass.getSuperclass()) {
            extractTypeArguments(typeMap, instanceClass);
            instanceClass = instanceClass.getSuperclass();
            if (instanceClass == null) {
                throw new IllegalArgumentException();
            }
        }

        ParameterizedType parameterizedType = (ParameterizedType) instanceClass.getGenericSuperclass();
        Type actualType = parameterizedType.getActualTypeArguments()[parameterIndex];
        if (typeMap.containsKey(actualType)) {
            actualType = typeMap.get(actualType);
        }
        if (actualType instanceof Class) {
            return (Class<?>) actualType;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void extractTypeArguments(Map<Type, Type> typeMap, Class<?> clazz) {
        Type genericSuperclass = clazz.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] typeParameter = ((Class<?>) parameterizedType.getRawType()).getTypeParameters();
        Type[] actualTypeArgument = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < typeParameter.length; i++) {
            if (typeMap.containsKey(actualTypeArgument[i])) {
                actualTypeArgument[i] = typeMap.get(actualTypeArgument[i]);
            }
            typeMap.put(typeParameter[i], actualTypeArgument[i]);
        }
    }
}