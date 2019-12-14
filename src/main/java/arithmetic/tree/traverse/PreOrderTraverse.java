package arithmetic.tree.traverse;

import tree.BinaryTree;
import tree.BinaryTreeNode;

/**
 * 根->左->右
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */
public class PreOrderTraverse {
    public static void preOrderTraverse(BinaryTreeNode root) {
        if (root != null) {
            visit(root);
            preOrderTraverse(root.getLchild());
            preOrderTraverse(root.getRchild());
        }
    }

    private static void visit(BinaryTreeNode node) {
        System.out.print(node.getData() + "\t");
    }

    public static void main(String[] args) {
        BinaryTreeNode fullTreeRoot = BinaryTree.getFullTreeRoot();
        //               1
        //             /   \
        //           2       3
        //          / \     / \
        //         4   5   6   7
        preOrderTraverse(fullTreeRoot);
    }
}
