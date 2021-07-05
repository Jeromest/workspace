package com.song;

public class Animal {

    String name;
    Integer age;

    public Animal() {
    }

    public Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
