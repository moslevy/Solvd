package com.example.hw1.methodsoverriding;

import java.util.LinkedHashSet;

public class TestPerson {

    public static void main(String[] args) {

        //Implemented a LinkedHashSet to demonstrate the fact that when you add a Person object to the collection,
        //it doesn't add the object if it finds that they are equal (using first the overridden equal method)
        // and then by the int returned by the hastCode method.
        // both methods were overridden in the Person's class.
        //In the case of the person # 6 (Monica), she is added to the collection since
        // it doesn't have same name and thus,
        //after checking name and finding the comparison to be false (because it used the overridden equal method),
        // then the age doesn't matter if it is equal or not.
        //That's why Monica was added to the LinkedHashSet Collection and John # 3 wasn't.
        LinkedHashSet<Person> people = new LinkedHashSet<>();

        people.add(new Person("John", 20));
        people.add(new Person("Lewis", 30));
        people.add(new Person("John", 20));
        people.add(new Person("Sofia", 50));
        people.add(new Person("Maria", 60));
        people.add(new Person("Monica", 60));

        for (Person p : people) {
            System.out.println(p);
        }
    }


}
