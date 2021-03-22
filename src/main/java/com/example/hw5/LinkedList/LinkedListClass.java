package com.example.hw5.LinkedList;

import java.util.LinkedList;


public class LinkedListClass {


    public static void main(String[] args) {
        LinkedList<String> linky = new LinkedList();

        linky.add("Moses");
        linky.add("Jose");
        linky.add("Tomas");
        linky.add("Adam");

        System.out.println(linky.contains("Tomas"));
        System.out.println(linky.stream().count());

    }
}


