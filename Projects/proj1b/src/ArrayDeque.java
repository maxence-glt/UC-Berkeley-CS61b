package Projects.proj1b.src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayDeque<T> implements Deque<T>  {
    int originalFirst, nextFirst;
    int originalLast, nextLast;
    int size = 0;
    public T[] items;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        originalFirst= 3;
        nextFirst = 3;
        originalLast = 4;
        nextLast = 4;
    }

    @Override
    public void addFirst(T x) {
        if (size == items.length || nextLast == nextFirst) {
            resize(items.length * 2);
        } if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }

        items[nextFirst] = x;
        size += 1;
        nextFirst -= 1;
    }

    @Override
    public void addLast(T x) {
        if (size == items.length || nextLast == nextFirst) {
            resize(items.length * 2);
        } if (nextLast == items.length) {
            nextLast = 0;
        }
        items[nextLast] = x;
        size += 1;
        nextLast += 1;
    }

    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];

        for (int x = 0; x < size; x++) {
            a[x] = get(x);
        }

        items = a;
        nextFirst = items.length - 1;
        nextLast = size;

    }

    @Override
    public List<T> toList() {
        List<T> outList = new ArrayList<>();
        for (int x = 0; x < size; x++)
            outList.add(get(x));

        return outList;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        return remove(0);
    }

    @Override
    public T removeLast() {
        return remove(size - 1);
    }

    public T remove(int index) {
        T out = get(index);
        items[Math.floorMod(nextFirst + 1 + (index), items.length)] = null;
        size--;

        if (index == 0)
            nextFirst++;
        else
            nextLast--;

        if (size < (items.length / 3) && items.length > 16) {
            resize(items.length / 3);
        }

        return out;
    }

    @Override
    public T get(int index) {
        if (index > size || index < 0) {
            return null;
        }
        return items[Math.floorMod(nextFirst + 1 + index, items.length)];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

    public static void main(String[] args) {
        ArrayDeque test = new ArrayDeque();
        for (int x = 0; x < 20; x++) {
            test.addLast(x);
            test.addFirst(x);
        }

        for (int x = 0; x < 20; x++) {
            test.removeLast();
            test.removeFirst();
        }

        System.out.println(test.get(test.size - 1));

        ArrayDeque test2 = new ArrayDeque();

    }
}

