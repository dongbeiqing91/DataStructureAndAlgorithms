package arithmetic.tree.traverse;

import tree.BinaryTree;
import tree.BinaryTreeNode;

import java.util.Stack;

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

    /**
     * 非递归
     * 1)根入栈
     * 2)栈顶元素出栈, 访问这个出栈元素
     * 3)将出栈元素的右孩子入栈, 再将左孩子入栈, 重复步骤2), 直到栈为空
     */
    public static void preOrderTraverseNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            if (node != null) {
                visit(node);
                stack.push(node.getRchild());
                stack.push(node.getLchild());
            }
        }
    }

    private static void visit(BinaryTreeNode node) {
        System.out.print(node.getData() + "\t");
    }

    public static void main(String[] args) {
        BinaryTreeNode fullTreeRoot = BinaryTree.getFullTreeRoot();
        BinaryTreeNode fullTreeRoot2 = BinaryTree.getFullTreeRoot();
        //               1
        //             /   \
        //           2       3
        //          / \     / \
        //         4   5   6   7
        preOrderTraverse(fullTreeRoot);
        System.out.println();
        preOrderTraverseNonRecursive(fullTreeRoot2);
    }
}
