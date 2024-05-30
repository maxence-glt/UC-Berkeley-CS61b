package Labs.lab09.src.hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {
    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    public class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    private int capacity;
    private int intCapacity;
    private double intLF;
    private int size;
    private double loadFactor;

    /** Constructors */
    public MyHashMap() {
        this(16, 0.75);
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, 0.75);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialCapacity.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialCapacity initial size of backing array
     * @param loadFactor maximum load factor
     */
    public MyHashMap(int initialCapacity, double loadFactor) {
        intCapacity = initialCapacity;
        intLF = loadFactor;
        resetHelper(initialCapacity, loadFactor);
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new LinkedList<>();
    }

    @Override
    public void put(K key, V value) {
        putHelper(key, value, buckets);
        if ((double) size / capacity > loadFactor)
            resize();

        size++;
    }

    public void resize() {
        Collection<Node>[] tempBuckets = new Collection[capacity * 2];
        for (Collection<Node> bucket : buckets) {
            if (bucket == null) continue;
            for (Node n : bucket) {
                int position = Math.floorMod(n.key.hashCode(), tempBuckets.length);

                if (tempBuckets[position] == null)
                    tempBuckets[position] = createBucket();

                tempBuckets[position].add(new Node(n.key, n.value));
            }
        }
        capacity *= 2;
        buckets = tempBuckets;
    }

    void putHelper(K key, V value, Collection[] arr) {
        int position = Math.floorMod(key.hashCode(), arr.length);

        if (containsKey(key)) {
            ((Node) getHelper(key, true)).value = value;
            size--;
            return;
        }

        if (arr[position] == null)
            arr[position] = createBucket();

        arr[position].add(new Node(key, value));
    }

    @Override
    public V get(K key) {
        return (V) getHelper(key, null);
    }

    @Override
    public boolean containsKey(K key) {
        return (boolean) getHelper(key, false);
    }

    private Object getHelper(K key, Object returnType) {
        int position = Math.floorMod(key.hashCode(), capacity);
        Collection<Node> pos = buckets[position];
        if (pos == null) return returnType;
        for (Node n : pos) {
            if (n.key.hashCode() == key.hashCode()) {
                if (returnType == null)
                    return n.value;
                if (returnType.equals(true))
                    return n;
                return true;
            }
        }

        return returnType;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> m = new MyHashMap<>();
        m.put("maxence", 18);
        m.put("maxence", 17);
        m.put("diane", 15);
        m.put("raphael", 11);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        resetHelper(intCapacity, intLF);
    }

    public void resetHelper(int initialCapacity, double loadFactor) {
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.size = 0;
        buckets = new Collection[capacity];
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

}
