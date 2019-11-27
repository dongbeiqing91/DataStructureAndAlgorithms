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
     * @param binaryTreeNode
     * @return
     */
    public static int countLeafNode(BinaryTreeNode binaryTreeNode){
        return countWithPreOrder(binaryTreeNode);
    }

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
