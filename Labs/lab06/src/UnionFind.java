package Labs.lab06.src;

public class UnionFind {
    /**
     * DO NOT DELETE OR MODIFY THIS, OTHERWISE THE TESTS WILL NOT PASS.
     * You can assume that we are only working with non-negative integers as the items
     * in our disjoint sets.
     */
    private int[] data = new int[]{5, 0, 0, 2, -1, -9, 5, 5, 7, 5};


    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        data = new int[N];
        for (int i = 0; i < N; i++)
            data[i] = -1;
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        return data[find(v)] * -1;
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        return data[v];
    }

    /* Returns true if nodes/vertices V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        if (v > data.length)
            throw new IllegalArgumentException();

        if (parent(v) < 0)
            return v;

        while (!(parent(v) < 0))
            v = parent(v);

        return v;
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing an item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        if (connected(v1, v2) || v1 == v2)
            return;

        int size1 = sizeOf(v1);
        int size2 = sizeOf(v2);

        if (size1 > size2) {
            int newSize = sizeOf(v2);
            data[find(v2)] = find(v1);
            data[find(v1)] -= newSize;
        }

        if (size2 > size1) {
            int newSize = sizeOf(v1);
            data[find(v1)] = find(v2);
            data[find(v1)] -= newSize;
        }

        if (size1 == size2) {
            int newSize = sizeOf(v2);
            data[find(v2)] = find(v1);
            data[find(v1)] -= newSize;
//            int newSize = sizeOf(v1);
//            data[find(v1)] = find(v2);
//            data[find(v1)] -= newSize;
        }
    }

    public int[] returnData() {
        return data;
    }

    public static void main(String[] args) {
        UnionFind test = new UnionFind(5);
        test.union(1, 0);
        test.union(1, 2);
        test.union(2, 3);
        test.union(3, 4);
        test.union(4, 5);
    }
}
