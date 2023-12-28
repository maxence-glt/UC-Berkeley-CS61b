package Scratchwork;

public class Larger {
    public static int larger(int x, int y) {
        if (x > y) {
            return x;
        }
        return y;
    }
    public static void main(String[] args) {
        System.out.println(larger(3, 4));
    }
}

/*
1. Functions must be declared as part of a class in Java.
    A function that is part of a class is called a method.
    So in Java, all functions are methods.
2. To define a function in Java, we use "public static".
    We will see alternate ways to do this later.
3. ALL param of a function must have a declared type, and the
    return value must have a return type.
    Functions in Java return only one value!

 */