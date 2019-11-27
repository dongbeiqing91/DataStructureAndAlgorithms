package arithmetic;

import org.junit.Test;
import tree.BinaryTree;
import tree.BinaryTreeNode;

/**
 * @author Bei
 * @date 2019-11-27
 */
public class BinaryTreeArithmeticTest {

    @Test
    public void preOrder() {
        BinaryTreeNode fullTreeRoot = BinaryTree.getFullTreeRoot();
        BinaryTreeArithmetic.preOrder(fullTreeRoot);
    }

    @Test
    public void countLeafNodes() {
        BinaryTreeNode fullTreeRoot = BinaryTree.getFullTreeRoot();
        int i = BinaryTreeArithmetic.countLeafNode(fullTreeRoot);
        System.out.println(i);
        BinaryTreeNode completeTreeRoot = BinaryTree.getCompleteTreeRoot();
        int j = BinaryTreeArithmetic.countLeafNode(completeTreeRoot);
        System.out.println(j);
    }

    @Test
    public void countLeafNodesWithStack() {
        BinaryTreeNode fullTreeRoot = BinaryTree.getFullTreeRoot();
        int i = BinaryTreeArithmetic.countLeafNodesWithStack(fullTreeRoot);
        System.out.println(i);
        BinaryTreeNode completeTreeRoot = BinaryTree.getCompleteTreeRoot();
        int j = BinaryTreeArithmetic.countLeafNodesWithStack(completeTreeRoot);
        System.out.println(j);
    }
}