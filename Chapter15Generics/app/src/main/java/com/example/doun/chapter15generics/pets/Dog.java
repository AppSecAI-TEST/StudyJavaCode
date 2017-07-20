//: typeinfo/pets/Dog.java
package com.example.doun.chapter15generics.pets;

public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }

    public void speak() {
        System.out.println("Dog speak wang wang .");
    }
} ///:~
