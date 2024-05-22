package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest annotation = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (String string : annotation.fullyQualifiedNames()) {
                System.out.println(string);
            }
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest annotation = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (Class<?> aClass : annotation.value()) {
                System.out.println(aClass.getSimpleName());
            }
            return true;
        }
        return false;
    }
}
