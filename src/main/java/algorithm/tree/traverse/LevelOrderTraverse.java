package arithmetic.tree.traverse;

import tree.BinaryTree;
import tree.BinaryTreeNode;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LevelOrderTraverse {

    /**
     * 使用队列
     * 1)根结点入队
     * 2)队列不为空时循环: 从队列中出列一个结点P, 访问它, 若P有左孩子, 左孩子入队; 若P有右孩子, 右孩子入队
     */
    public static void levelTraverse(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode p = queue.poll();
            visit(p);
            if (p.getLeftChild() != null) {
                queue.add(p.getLeftChild());
            }
            if (p.getRightChild() != null) {
                queue.add(p.getRightChild());
            }
        }
    }

    private static void visit(BinaryTreeNode node) {
        System.out.print(node.getData() + "\t");
    }

    public static void main(String[] args) {
        BinaryTreeNode fullTreeRoot = BinaryTree.getFullTreeRoot();
        levelTraverse(fullTreeRoot);
    }
}
