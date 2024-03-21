package Labs.lab07.src;

import java.util.*;

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

        int cmp = t.key.compareTo(key);

        if (cmp > 0)
            t.left = putHelper(t.left, key, value);

        else if (cmp < 0)
            t.right = putHelper(t.right, key, value);

        else {
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
            int cmp = t.key.compareTo(key);

            if (cmp > 0)
                t = t.left;

            else if (cmp < 0)
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

    ArrayList<K> newArray = new ArrayList<>();
    // optional
    @Override
    public Set<K> keySet() {
        this.newArray = new ArrayList<>();
        keySetHelper(tree);
        return new HashSet<>(newArray);
    }

    // different order than their implementation but it works
    private void keySetHelper(Tree t) {
        if (t != null) {
            keySetHelper(t.left);
            newArray.add(t.key);
            keySetHelper(t.right);
        }
    }

    // optional
    @Override
    public V remove(K key) {
        if (get(key) == null)
            return null;

        V out = get(key);

        tree = removeHelper(tree, key);
        size--;
        return out;
    }

    private Tree removeHelper(Tree t, K key) {
        if (t == null) return t;

        int cmp = t.key.compareTo(key);

        if (cmp < 0)
            t.right = removeHelper(t.right, key);

        else if (cmp > 0)
            t.left = removeHelper(t.left, key);

        else {
            if (t.left == null)
                return t.right;
            if (t.right == null)
                return t.left;

            t.key = predecessor(t).key;
            t.left = removeHelper(t.left, t.key);
        }
        return t;
    }

    private Tree predecessor(Tree t) {
        t = t.left;
        while (t.right != null) {
            t = t.right;
        }

        return t;
    }

    // optional
    @Override
    public Iterator<K> iterator() {
        return null;
    }

    // print out BSTMap in order of increasing Key
    public void printInOrder() {
        Tree newTree = tree;
        printHelper(newTree);
    }

    public void printHelper(Tree tree) {
        if (tree == null)
            return;

        printHelper(tree.left);

        System.out.print(tree.key + " " + tree.val + '\n');

        printHelper(tree.right);
    }

    public static void main(String[] args) {
        BSTMap<Integer, Integer> test = new BSTMap<>();
        test.put(5, 10);
        test.put(3, 10);
        test.put(4, 10);
        test.put(2, 10);
        test.put(7, 10);
        test.put(8, 10);
        test.put(6, 10);
        System.out.println(test.keySet());

//        test.put(9, 69);
//        test.put(7, 5);
//        test.put(8, 5);
//        test.put(2, 5);
//        test.put(1, 5);
//        test.put(4, 5);
//        test.printInOrder();
    }
}