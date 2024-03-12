package Scratchwork;

public class QuickUnionDS {
    private int[] parent;

    public QuickUnionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++)
            parent[i] = -1;
    }

     private int find(int p) {
        int r = p;
        while (parent[r] >= 0)
            r = parent[r];
        return r;
     }

     public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void connect(int p, int q) {
        int i = find(p);
        int j = find(q);
          parent[i] = j;
    }

    public static void main(String[] args) {
        QuickUnionDS test = new QuickUnionDS(10);
        test.connect(1, 0);
        test.connect(2, 1);
        test.connect(4, 0);
        test.connect(5, 3);
        System.out.println();
    }
}
