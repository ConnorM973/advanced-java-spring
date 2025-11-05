package com.codingnomads.springweb.springrestcontrollers.simpledemo;

import lombok.Data;


public class Cat {
    public String name;
    public int age;
    public String color;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;

    }
}
