package com.example.hw4.generics;

import java.util.List;

public class MyGenericClass<T>{
    List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}