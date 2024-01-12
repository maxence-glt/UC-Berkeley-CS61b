package Scratchwork;

public class SLList {
    public static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    private IntNode first;
    private int size;

    public int getFirst() {
        return first.item;
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
        size += 1;
    }

    public void addLast(int x) {
        IntNode p = first;

        if (p == null) {
            this.addFirst(x);
            return;
        }

        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

    public int size() {
        return size;
    }

    public SLList() {
        first = null;
        size = 0;
    }

    public SLList(int x) {
        first = new IntNode(x, null);
        size = 1;
    }

    public static void main(String[] args) {
        System.out.println(args[0]);
        for (String i : args) {
            System.out.println(i);
        }
    }
}
