package arithmetic.tree.traverse;

import tree.BinaryTree;
import tree.BinaryTreeNode;

/**
 * 左->右->根
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 * <p>
 * 后序遍历非递归算法需要两个栈
 */
public class PostOrderTraverse {
    public static void postOrderTraverse(BinaryTreeNode root) {
        if (root != null) {
            postOrderTraverse(root.getLeftChild());
            postOrderTraverse(root.getRightChild());
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
