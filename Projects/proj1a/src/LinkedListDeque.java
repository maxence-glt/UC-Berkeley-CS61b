package Projects.proj1a.src;

import java.util.ArrayList;
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
}
