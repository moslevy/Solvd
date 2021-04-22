package com.solvd.townhall.reflection;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Test t = new Test("Andrew", 45);

        // get the class
        Class<?> getClass = Test.class;

        //
        Field[] fieldsFromClass = getClass.getDeclaredFields();
        for(Field f : fieldsFromClass){
            System.out.println("Field: " + f.getName());
        }

        Method[] methods = getClass.getDeclaredMethods();
        for(Method m : methods){
            System.out.println("Method: " + m.getName());
        }

        Constructor[] constructors = getClass.getDeclaredConstructors();
        for(Constructor c: constructors){
            System.out.println("Constructor: " + c.getName());
        }

        //Calling one method using reflection
        System.out.println(t.getAge());


    }
}
