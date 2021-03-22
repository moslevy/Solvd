package com.example.hw5.HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetClass {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>();

        hashSet.add(null);
        hashSet.add(null);
        hashSet.add("Honda");
        hashSet.add("Susuki");
        hashSet.add("Yamaha");
        hashSet.add("Roland");
        hashSet.add("Susuki");

        // 1. Data is unique, no redundancy
        // 2. Data is unordered in output due to hashing.
        System.out.println("hastSet is: " +hashSet);

        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }

        // You can remove an item.
        hashSet.remove("Roland");
        System.out.println(hashSet);
    }
}
