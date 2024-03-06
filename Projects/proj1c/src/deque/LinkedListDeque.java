package Projects.proj1c.src.deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {
    public Node sentinel;
    public int size;

    public static class Node<T> {
        public T item;
        public Node next;
        public Node prev;

        public Node(T i, Node n) {
            item = i;
            next = n;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node("Sentinel", null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node newNode = new Node(x, sentinel.next);
        sentinel.next = newNode;
        newNode.prev = sentinel;
        newNode.next.prev = newNode;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(x, sentinel);
        newNode.prev = sentinel.prev;
        sentinel.prev = newNode;
        newNode.prev.next = newNode;
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node<T> list = sentinel.next;

        while (list.item != "Sentinel") {
            returnList.add(list.item);
            list = list.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node removeNode = sentinel.next;
        T returnVal = (T) removeNode.item;
        sentinel.next = removeNode.next;
        removeNode.next.prev = sentinel;
        return returnVal;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node removeNode = sentinel.prev;
        T returnVal = (T) removeNode.item;
        sentinel.prev = removeNode.prev;
        removeNode.prev.next = sentinel;
        return returnVal;
    }

    @Override
    public T get(int index) {
        Node<T> list = sentinel.next;
        if (size - 1 < index || index < 0) {
            return null;
        } else {
            while (index != 0) {
                list = list.next;
                index -= 1;
            }
            return list.item;
        }

    }

    public T getRecursiveHelper (int index, Node list) {
        if (size - 1 < index || index < 0) {
            return null;
        } if (index == 0) {
            return (T) list.item;
        } else {
            return getRecursiveHelper(index - 1, list.next);
        }
    }

    @Override
    public T getRecursive(int index) {
        Node<T> list = sentinel.next;
        return getRecursiveHelper(index, list);
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private int wizPos;
        public LinkedListIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = get(wizPos);
            wizPos += 1;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque od) {
            if (od.size != this.size)
                return false;

            for (int x = 0; x < size; x++) {
                if (this.get(x) != od.get(x))
                    return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            returnSB.append(get(i));
            returnSB.append(", ");
        }
        returnSB.append(get(size - 1));
        returnSB.append("]");
        return returnSB.toString();
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> test = new LinkedListDeque<>();
        for (int x = 0; x < 20; x++) {
            test.addFirst(x);
            test.addLast(x);
        }

        for (Integer x : test) {
            System.out.println(x);
        }

        Deque<String> lld1 = new LinkedListDeque<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        System.out.println(lld1);


    }
}
