package Discussions.Discussion3.exam_level;

import Scratchwork.SLList;

public class DLList {
    public class Node {
        public int item;
        public SLList.IntNode next;

        public Node(int i, SLList.IntNode n) {
            item = i;
            next = n;
        }
    }

    private Node first;
    private int size;



    Node sentinel;

}
