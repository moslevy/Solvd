package com.solvd.townhall.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericList<T>{
    List<T> list;

    public GenericList(T typeOfList){
        this.list = new ArrayList<T>();
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}