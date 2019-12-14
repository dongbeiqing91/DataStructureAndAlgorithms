package arithmetic.tree.traverse;

import tree.BinaryTree;
import tree.BinaryTreeNode;

/**
 * 左->右->根
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */
public class PostOrderTraverse {
    public static void postOrderTraverse(BinaryTreeNode root) {
        if (root != null) {
            postOrderTraverse(root.getLchild());
            postOrderTraverse(root.getRchild());
            visit(root);
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
        postOrderTraverse(fullTreeRoot);
    }
}
