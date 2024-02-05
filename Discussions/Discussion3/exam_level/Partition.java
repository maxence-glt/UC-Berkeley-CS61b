package Discussions.Discussion3.exam_level;

import Scratchwork.IntList;

import java.util.Arrays;

public class Partition {
    // if lst contains 6, 5, 4, 3, 2, 1 and k = 2, a possible partition is [] and []

    public static IntList[] partition(IntList lst, int k) { // lst is EVENLY divisible
        IntList[] array = new IntList[k];
        int index = 0;
        IntList L = lst;
        while (L != null) {
            array[index] = new IntList(L.first, null);
            L = L.rest;
//            index = L.size %
        }

        return array;
    }

    public static void main (String[] args) {
        IntList arr = new IntList(10, new IntList (20, null));
        IntList[] array = new IntList[5];
        array[0] = new IntList(5, null);
        System.out.println(array[0]);
//        System.out.println(arr.get(1));

    }
}
