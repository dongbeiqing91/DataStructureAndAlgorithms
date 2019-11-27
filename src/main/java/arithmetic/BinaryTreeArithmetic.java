package arithmetic;

import tree.BinaryTreeNode;

/**
 * 二叉树中的各种算法集合
 * @author Bei
 * @date 2019-11-27
 */
public class BinaryTreeArithmetic {

    /**
     * 计算叶子结点数, 使用递归先序遍历
     */
    public static int countLeafNode(BinaryTreeNode binaryTreeNode){
        return countWithPreOrder(binaryTreeNode);
    }

    /**
     * 对于n个结点的二叉树, 时间复杂度为 O(n)
     * 先序遍历, 递归
     */
    private static int countWithPreOrder(BinaryTreeNode binaryTreeNode){
        if (binaryTreeNode == null) {
            return 0;
        }
        if (binaryTreeNode.getLchild() == null && binaryTreeNode.getRchild() == null) {
            return 1;
        } else {
            return countWithPreOrder(binaryTreeNode.getLchild()) + countWithPreOrder(binaryTreeNode.getRchild());
        }
    }

    /**
     * 计算叶子结点个数, 利用栈, 非递归
     * 根结点不为空, 则将根结点入栈
     * 1) 如果栈不为空, 栈顶结点出栈, 如果出栈结点的的左右子树都不存在, 则叶子结点数+1
     * 2) 如果出栈结点的右子树不为空, 将右子树入栈
     * 3) 如果出栈结点的左子树不为空, 将左子树入栈, 回到1)
     */
    public static int countLeafNodesWithStack(BinaryTreeNode binaryTreeNode) {
        int top = 0; // 栈顶指针
        int sum = 0;
        BinaryTreeNode p = binaryTreeNode;
        BinaryTreeNode[] stack = new BinaryTreeNode[10];
        if (binaryTreeNode != null) {
            stack[++top] = p;
            while (top > 0) {
                p = stack[top--];
                if (p.getRchild() == null && p.getLchild() == null) {
                    sum++;
                }
                if (p.getRchild() != null) {
                    stack[++top] = p.getRchild();
                }
                if (p.getLchild() != null) {
                    stack[++top] = p.getLchild();
                }
            }
        }
        return sum;
    }

    /**
     * 先序遍历的递归算法
     */
    public static void preOrder(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        System.out.println(binaryTreeNode.getData());
        preOrder(binaryTreeNode.getLchild());
        preOrder(binaryTreeNode.getRchild());
    }
}
