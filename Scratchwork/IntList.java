package Scratchwork;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    // returns size of list
    public int size() {
        if (rest == null)
            return 1;

        return 1 + this.rest.size();
    }

    public int get(int x) {
        if (x >= this.size())
            return -1;

        if (x == 0)
            return first;

        return rest.get(x - 1);
    }

    public static void main (String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.println(L.get(3));
    }
}
