package Scratchwork;

import java.util.ArrayList;

public class Scratch {
    static class Animal {
        void testMethod() {
            System.out.println("sakdjasjhd");
        }
        void sound() {
            System.out.println("ygo bulls");
        }
    }

    static class Dog extends Animal {
        void sound() {
            System.out.println("go umass amherst");
        }
    }

    public static void main(String[] args) {
        ArrayList<Animal> test = new ArrayList<>();
        for (int i = 0; i < 1; i++)
            test.add(new Dog());
        test.get(0).sound();
    }
}
