package com.song;

public class Demo {
    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.name = "Tomcat";
        animal.age = 18;
        System.out.println(animal);

        Animal dog = new Dog();
        dog.name = "dog";
        dog.age = 20;
        System.out.println(dog);

    }
}
