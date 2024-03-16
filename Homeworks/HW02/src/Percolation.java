package Homeworks.HW02.src;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private WeightedQuickUnionUF siteGrid;
    private int[] siteGridOpen;
    private int siteGridLength;
    private int numOpen = 0;

    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        siteGrid = new WeightedQuickUnionUF(N * N + 2);
        siteGridOpen = new int [N * N];
        siteGridLength = N;
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col))
            return;

        int index = rcTo1D(row, col);
        siteGridOpen[index] = 1;

        if (index < siteGridLength)
            siteGrid.union(0, index + 1);

        if (index >= (siteGridLength * siteGridLength )- siteGridLength)
            siteGrid.union(index + 1, siteGridLength * siteGridLength + 1);

        if (validEdge(row - 1, col))
            siteGrid.union(index + 1, rcTo1D(row - 1, col) + 1);

        if (validEdge(row, col - 1))
            siteGrid.union(index + 1, rcTo1D(row, col - 1) + 1);

        if (validEdge(row + 1, col))
            siteGrid.union(index + 1, rcTo1D(row + 1, col) + 1);

        if (validEdge(row, col + 1))
            siteGrid.union(index + 1, rcTo1D(row, col + 1) + 1);
    }

    private boolean validEdge(int newRow, int newCol) {
        if (newRow < 0 || newCol < 0 || newRow >= siteGridLength || newCol >= siteGridLength)
            return false;

        return isOpen(newRow, newCol);
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int index = rcTo1D(row, col);
        return siteGridOpen[index] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int index = rcTo1D(row, col);

        return siteGrid.connected(0, index + 1);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numOpen;
    }

    // does the system percolate?
    public boolean percolates() {
        return siteGrid.connected(0, siteGridLength * siteGridLength + 1);
    }

    public int rcTo1D(int r, int c) {
        int out = 0;
        if (r >= siteGridLength || c >= siteGridLength)
            throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < r; i++)
            out += siteGridLength;

        return out + c;
    }

    public static void main(String[] args) {
        Percolation testP = new Percolation(5);
        testP.open(3, 4);
        testP.open(2, 4);
        testP.open(2, 2);
        testP.open(2, 3);
        testP.open(0, 2);
        testP.open(1, 2);
        System.out.println(testP.isFull(2, 2));
        testP.open(4, 4);


        System.out.println(testP.percolates());
    }
}
