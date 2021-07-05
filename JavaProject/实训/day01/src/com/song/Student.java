package com.song;

public class Student {

    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void study() {
        System.out.println("Student");
    }

    public static void main(String[] args) {
        Student student = new Student();

        student.name = "song";
        student.age = 18;

        System.out.println(student);
        System.out.println(student.name + "\t" + student.age);


        Student student1 = new Student("aaa", 20);
        System.out.println(student1.name + "\t" + student1.age);


    }
}
