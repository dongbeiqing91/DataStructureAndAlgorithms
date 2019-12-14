package arithmetic.tree.traverse;

import tree.BinaryTree;
import tree.BinaryTreeNode;

/**
 * 左->根->右
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */
public class InOrderTraverse {
    public static void inOrderTraverse(BinaryTreeNode root) {
        if (root != null) {
            inOrderTraverse(root.getLchild());
            visit(root);
            inOrderTraverse(root.getRchild());
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
        inOrderTraverse(fullTreeRoot);
    }
}
