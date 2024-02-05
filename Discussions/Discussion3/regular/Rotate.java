package Discussions.Discussion3.regular;

import java.util.Arrays;

public class Rotate {
    public static int[] rotate(int[] A, int k) {
        int rightShift = A.length;
        int[] newArr = new int[rightShift];

        for (int i = 0; i < rightShift; i++) {
            int newIndex = (k + i) % rightShift;
            newArr[newIndex] = A[i];
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotate(arr, 12)));
    }
}
