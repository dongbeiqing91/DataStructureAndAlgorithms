package arithmetic.tree.traverse;

import tree.BinaryTree;
import tree.BinaryTreeNode;

import java.util.Stack;

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

    /**
     * 非递归
     * 1)根入栈
     * 2)左孩子存在, 入栈, 直到左孩子不存在
     * 3)栈顶元素出栈, 如果出栈元素的右孩子存在, 入栈, 重复2), 如果出栈元素的右孩子不存在, 继续出栈下一个, 直到栈为空
     */
    public static void inOrderTraverseNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;
        while (current != null || !stack.empty()) {
            while (current != null) { // 左孩子一直入栈
                stack.add(current);
                current = current.getLchild();
            }
            current = stack.pop(); // 直到左孩子为空, 开始出栈
            visit(current);
            current = current.getRchild(); // 出栈元素的有孩子存在, 则入栈
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
        inOrderTraverse(fullTreeRoot);
        System.out.println();
        inOrderTraverseNonRecursive(fullTreeRoot2);
    }


}
