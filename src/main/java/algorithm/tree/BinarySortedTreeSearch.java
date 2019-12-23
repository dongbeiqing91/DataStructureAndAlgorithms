package arithmetic.tree;

import tree.BinarySortedTree;
import tree.BinaryTreeNode;

public class BinarySortedTreeSearch {

    public static BinaryTreeNode bstSearch(BinaryTreeNode node, int target) {
        if (node != null) {
            if (target == node.getData()) {
                return node;
            }
            if (target > node.getData()) {
                return bstSearch(node.getRightChild(), target);
            } else {
                return bstSearch(node.getLeftChild(), target);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTreeNode node = BinarySortedTree.getInstance();
        BinaryTreeNode binaryTreeNode = bstSearch(node, 7);
        if (binaryTreeNode == null) {
            System.out.println("not found");
            return;
        }
        System.out.println(binaryTreeNode.getData() + " found");
    }
}
