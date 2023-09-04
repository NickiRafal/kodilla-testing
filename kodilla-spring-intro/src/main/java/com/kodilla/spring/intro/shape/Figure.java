package com.kodilla.spring.intro.shape;

public class Figure implements Shape{
    @Override

    public String draw() {
        System.out.println("This is a geometric figure");
        return "This is a geometric figure";
    }
}