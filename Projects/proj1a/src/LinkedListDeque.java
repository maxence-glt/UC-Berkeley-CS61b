package Projects.proj1a.src;

import Scratchwork.SLList;

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
//        Node newNode = new Node(x, sentinel);
//        sentinel.prev.next = newNode;
//        newNode.next = sentinel;
//        newNode.prev = sentinel.prev.prev;
//        newNode.prev.next = newNode;
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
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
