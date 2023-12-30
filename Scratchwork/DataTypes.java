package Scratchwork;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class DataTypes {
    public static void main(String[] args) {
        // Dynamic List
        List<String> lst = new ArrayList<>();
        lst.add("zero");
        lst.add("one");
        System.out.println(lst);

        // Fixed List
        int[] array = {4, 7, 10};
        array[0] = 5;
        System.out.println(Arrays.toString(array));

        // Sets
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        // set.remove(2);
        System.out.println(set.size());
        System.out.println(set);

        // Dictionaries and Maps
        Map<String, String> map = new HashMap<>();
        map.put("hello", "hi");
        map.put("hello", "goodbye");
        System.out.println(map.get("hello"));
        System.out.println(map);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }
}