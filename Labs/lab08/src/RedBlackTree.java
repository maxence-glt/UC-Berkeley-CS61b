package Labs.lab08.src;

public class RedBlackTree<T extends Comparable<T>> {

    /* Root of the tree. */
    RBTreeNode<T> root;

    static class RBTreeNode<T> {

        final T item;
        boolean isBlack;
        RBTreeNode<T> left;
        RBTreeNode<T> right;

        /* Creates a RBTreeNode with item ITEM and color depending on ISBLACK
           value. */
        RBTreeNode(boolean isBlack, T item) {
            this(isBlack, item, null, null);
        }

        /* Creates a RBTreeNode with item ITEM, color depending on ISBLACK
           value, left child LEFT, and right child RIGHT. */
        RBTreeNode(boolean isBlack, T item, RBTreeNode<T> left,
                   RBTreeNode<T> right) {
            this.isBlack = isBlack;
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    /* Creates an empty RedBlackTree. */
    public RedBlackTree() {
        root = null;
    }

    /* Creates a RedBlackTree from a given 2-3 TREE. */
    public RedBlackTree(TwoThreeTree<T> tree) {
        Node<T> ttTreeRoot = tree.root;
        root = buildRedBlackTree(ttTreeRoot);
    }

    /* Builds a RedBlackTree that has isometry with given 2-3 tree rooted at
       given node R, and returns the root node. */
    RBTreeNode<T> buildRedBlackTree(Node<T> r) {
        if (r == null) {
            return null;
        }

        if (r.getItemCount() == 1) {
            RBTreeNode<T> left = buildRedBlackTree(r.getChildAt(0));
            RBTreeNode<T> right = buildRedBlackTree(r.getChildAt(1));
            return new RBTreeNode<T>(true, r.getItemAt(0), left, right);
        } else {
            RBTreeNode<T> subRoot = new RBTreeNode<T>(true, r.getItemAt(1));
            subRoot.left = new RBTreeNode<T>(false, r.getItemAt(0));
            subRoot.left.left = buildRedBlackTree(r.getChildAt(0));
            subRoot.left.right = buildRedBlackTree(r.getChildAt(1));
            subRoot.right = buildRedBlackTree(r.getChildAt(2));
            return subRoot;
        }
    }

    /* Flips the color of node and its children. Assume that NODE has both left
       and right children. */
    void flipColors(RBTreeNode<T> node) {
        if (node.isBlack) {
            node.isBlack = false;
            node.left.isBlack = true;
            node.right.isBlack = true;
        } else {
            node.isBlack = true;
            node.left.isBlack = false;
            node.right.isBlack = false;
        }
    }

    /* Rotates the given node to the right. Returns the new root node of
       this subtree. For this implementation, make sure to swap the colors
       of the new root and the old root!*/
    RBTreeNode<T> rotateRight(RBTreeNode<T> node) {
        RBTreeNode<T> originalNode = node;
        RBTreeNode<T> rightNode = node.left.right;

        node = node.left;
        node.right = originalNode;
        node.right.left = rightNode;

        node.isBlack = !node.isBlack;
        node.right.isBlack = !node.right.isBlack;


        return node;
    }

    /* Rotates the given node to the left. Returns the new root node of
       this subtree. For this implementation, make sure to swap the colors
       of the new root and the old root! */
    RBTreeNode<T> rotateLeft(RBTreeNode<T> node) {
        RBTreeNode<T> originalNode = node;
        RBTreeNode<T> leftNode = node.right.left;

        node = node.right;
        node.left = originalNode;
        node.left.right = leftNode;


        node.isBlack = !node.isBlack;
        node.left.isBlack = !node.left.isBlack;

        return node;
    }

    public void insert(T item) {
        root = insert(root, item);
        root.isBlack = true;
    }

    /* Inserts the given node into this Red Black Tree. Comments have been provided to help break
     * down the problem. For each case, consider the scenario needed to perform those operations.
     * Make sure to also review the other methods in this class! */
    private RBTreeNode<T> insert(RBTreeNode<T> node, T item) {
        // Insert (return) new red leaf node.
        if (node == null) {
            return new RBTreeNode<>(false, item);
        }

        // Handle normal binary search tree insertion.
        int comp = item.compareTo(node.item);
        if (comp == 0) {
            return node; // do nothing.
        } else if (comp < 0) {
            node.left = insert(node.left, item);
        } else {
            node.right = insert(node.right, item);
        }

        while (true) {
            boolean loopCase = false;

            if (isRed(node.left) && isRed(node.right)) {
                flipColors(node);
                loopCase = true;
            }

            // Rotate left operation
            if (isRed(node.left) && isRed(node.left.right)) {
                node.left = rotateLeft(node.left);
                node.left.isBlack = false;
                node.left.left.isBlack = false;
                loopCase = true;
            }

            if (isRed(node.left) && isRed(node.left.left)) {
                node = rotateRight(node);
                loopCase = true;
            }

            if (isRed(node.right) && !isRed(node) && !isRed(node.left)) {
                node = rotateLeft(node);
                loopCase = true;
            }

            if (!loopCase) break;

        }
        return node; //fix this return statement
    }

    /* Returns whether the given node is red. Null nodes (children of leaf
       nodes) are automatically considered black. */
    private boolean isRed(RBTreeNode<T> node) {
        return node != null && !node.isBlack;
    }

}
