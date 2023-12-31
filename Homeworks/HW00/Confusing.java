//https:// practiceit.cs.washington.edu/problem/view/bjp5/chapter1/s26%2DConfusing

package Homeworks.HW00;

public class Confusing {
    public static void method1() {
        System.out.println("I am method 1.");
    }

    public static void method2() {
        method1();
        System.out.println("I am method 2.");
    }

    public static void method3() {
        method2();
        System.out.println("I am method 3.");
        method1();
    }

    public static void main(String[] args){
        method1();
        method3();
        method2();
        method3();
    }
    /* Answer
    I am method 1.
    I am method 1.
    I am method 2.
    I am method 3.
    I am method 1.
    I am method 1.
    I am method 2.
    I am method 1.
    I am method 2.
    I am method 3.
    I am method 1.
     */
}
