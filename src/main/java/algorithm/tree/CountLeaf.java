package algorithm.tree;

import tree.BinaryTree;
import tree.BinaryTreeNode;

import java.util.Stack;

public class CountLeaf {
    // recursive
    public static int countLeaf(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return 1;
        }
        return countLeaf(node.getLeftChild()) + countLeaf(node.getRightChild());
    }

    // non-recursive
    public static int countLeafPreOrderTraverseNonRecursive(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        int count = 0;
        stack.add(node);
        while (!stack.isEmpty()) {
            BinaryTreeNode item = stack.pop();
            BinaryTreeNode leftChild = item.getLeftChild();
            BinaryTreeNode rightChild = item.getRightChild();
            if (rightChild != null) {
                stack.add(rightChild);
            }
            if (leftChild != null) {
                stack.add(leftChild);
            }
            if (leftChild == null && rightChild == null) {
                count++;
            }
        }
        return count;
    }

    public static int countLeafInOderTraverseNonRecursive(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        int count = 0;
        BinaryTreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.getLeftChild();
            }
            BinaryTreeNode item = stack.pop();
            if (item.getLeftChild() == null && item.getRightChild() == null) {
                count++;
            }
            current = item.getRightChild();
        }
        return count;
    }

    public static void main(String[] args) {
        BinaryTreeNode fullTreeRoot = BinaryTree.getFullTreeRoot();

        int count = countLeaf(fullTreeRoot);
        System.out.println("the number of leaves = " + count);

        int count2 = countLeafPreOrderTraverseNonRecursive(fullTreeRoot);
        System.out.println("the number of leaves = " + count2);

        int count3 = countLeafInOderTraverseNonRecursive(fullTreeRoot);
        System.out.println("the number of leaves = " + count3);
    }
}
