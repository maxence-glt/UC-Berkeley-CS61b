package Labs.lab07.src;

import Scratchwork.SLList;
import edu.princeton.cs.algs4.BST;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import static com.google.common.truth.Truth.assertThat;

public class BSTMap<K extends Comparable<K>, V extends Comparable<V>> implements Map61B<K, V> {
    private Tree tree;
    private int size;
    private class Tree {
        public K key;
        public V val;
        public Tree left;
        public Tree right;

        Tree(K k, V n) {
            key = k;
            val = n;
            left = null;
            right = null;
        }
    }

    @Override
    public void put(K key, V value) {
        Tree newTree = tree;
        tree = putHelper(newTree, key, value);
        size++;
    }

    public Tree putHelper(Tree t, K key, V value) {
        if (t == null)
            return new Tree(key, value);

        if (t.key.compareTo(key) > 0)
            t.left = putHelper(t.left, key, value);

        else if (t.key.compareTo(key) < 0)
            t.right = putHelper(t.right, key, value);

        else if (t.key.compareTo(key) == 0) {
            t.val = value;
            size--;
        }
        return t;
    }

    @Override
    public V get(K key) {
        Tree newTree = tree;
        Tree value = getHelper(newTree, key);
        if (value == null)
            return null;
        return value.val;
    }

    public Tree getHelper(Tree t, K key) {
        while (t != null && t.key.compareTo(key) != 0) {
            if (t.key.compareTo(key) > 0)
                t = t.left;

            else if (t.key.compareTo(key) < 0)
                t = t.right;
        }
        return t;
    }

    @Override
    public boolean containsKey(K key) {
        Tree newTree = tree;
        return getHelper(newTree, key) != null && getHelper(newTree, key).key.compareTo(key) == 0 ;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        tree = null;
        size = 0;
    }

    // optional
    @Override
    public Set<K> keySet() {
        return null;
    }

    // optional
    @Override
    public V remove(K key) {
        return null;
    }

    // optional
    @Override
    public Iterator<K> iterator() {
        return null;
    }

    // print out BSTMap in order of increasing Key
    public void printInOrder() {

    }

    public static void main(String[] args) {
        BSTMap<Integer, Integer> test = new BSTMap<>();
        test.put(5, 3);
        test.put(9, 5);
//        test.put(9, 69);
//        System.out.println(test.get(9));
//        System.out.println(test.containsKey(-1));
//        System.out.println(test.containsKey(9));
//        System.out.println(test.size());
//        test.put(7, 5);
//        test.put(8, 5);
        test.put(2, 5);
//        test.put(1, 5);
//        test.put(4, 5);
    }
}