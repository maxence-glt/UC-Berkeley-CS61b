package Scratchwork;

public class AList {
    private int[] items;
    private int size;

    public AList() {
        items = new int[10];
        size = 0;
    }

    private void resize(int capacity) {
        int[] a = new int[size + 1];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addLast(int x) {
        if (size == items.length) {
            resize(size + 1);
        }

        items[size] = x;
        size += 1;
    }

    public int getLast() {
        return items[size - 1];
    }

    public int get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public int removeLast() {
        int x = getLast();
        size -= 1;
        return x;
    }

    public static void main(String[] args) {
        AList arr = new AList();
        System.out.println(arr.size());
        arr.addLast(12);
        arr.addLast(11);
        arr.addLast(11);
        arr.addLast(11);
        arr.addLast(11);
        arr.addLast(11);
        arr.addLast(11);
        arr.addLast(11);
        arr.addLast(11);
        arr.addLast(11);
        arr.addLast(21);
    }
}
