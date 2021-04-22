package com.solvd.townhall.reflection;

public class Test {
    private String name;

    private int age;

    public String getName() {
        return name;
    }


    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Test(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Test(String name) {
        this.name = name;
    }


}
