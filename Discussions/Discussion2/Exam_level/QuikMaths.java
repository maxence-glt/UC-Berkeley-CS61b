package Discussions.Discussion2.Exam_level;

import java.util.Arrays;

public class QuikMaths {
    public static void multiplyBy3(int[] A) {
        for (int x : A) {
            x = x * 3;
        }
    }

    public static void multiplyBy2(int[] A) {
        int[] B = A;
        for (int i = 0; i < B.length; i += 1) {
            B[i] *= 2;
        }
    }

    public static void swap (int A, int B) {
        int temp = B;
        B = A;
        A = temp;
    }

    public static void main(String[] args) {
        int[] arr;

        arr = new int[]{2, 3, 3, 4};
        multiplyBy3(arr);
        System.out.println(Arrays.toString(arr));
        // Value of arr: {2, 3, 4, 4}

        arr = new int[]{2, 3, 3, 4};
        multiplyBy2(arr);
        System.out.println(Arrays.toString(arr));
        // Value of arr: {4, 6, 8, 8}

        int a = 6;
        int b = 7;
        swap(a, b);
        System.out.println(a + " " + b);
        // a = 6, b = 7
    }
}
