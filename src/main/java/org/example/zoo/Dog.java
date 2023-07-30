package org.example.zoo;

public class Dog extends Animal {
    @Override
    public void printYourName() {
        System.out.println("Dog");
    }

    @Override
    public void printYourSound() {
        System.out.println("How");
    }
}
