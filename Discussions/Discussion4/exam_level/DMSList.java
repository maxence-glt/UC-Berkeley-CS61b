package Discussions.Discussion4.exam_level;

public class DMSList {
    private IntNode sentinel;

    public DMSList() {
        sentinel = new IntNode(-1000, new LastIntNode());
    }

    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode h) {
            item = i;
            next = h;
        }

        public int max() {
            return Math.max(item, next.max());
        }
    }

    class LastIntNode extends IntNode {
        public LastIntNode() {
            super(0, null);
        }

        @Override
        public int max() {
            return 0;
        }
    }

    public int max() {
        return sentinel.next.max();
    }

    public void insertFront(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
    }
}
