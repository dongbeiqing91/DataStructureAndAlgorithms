package tree;

/**
 * @author Bei
 * @date 2019-11-27
 */
public class BinaryTree {

    public static BinaryTreeNode getFullTreeRoot() {
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode();
        binaryTreeNode1.setData(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode();
        binaryTreeNode2.setData(2);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode();
        binaryTreeNode3.setData(3);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode();
        binaryTreeNode4.setData(4);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode();
        binaryTreeNode5.setData(5);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode();
        binaryTreeNode6.setData(6);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode();
        binaryTreeNode7.setData(7);

        binaryTreeNode1.setLchild(binaryTreeNode2);
        binaryTreeNode1.setRchild(binaryTreeNode3);
        binaryTreeNode2.setLchild(binaryTreeNode4);
        binaryTreeNode2.setRchild(binaryTreeNode5);
        binaryTreeNode3.setLchild(binaryTreeNode6);
        binaryTreeNode3.setRchild(binaryTreeNode7);

        return binaryTreeNode1;
    }

    public static BinaryTreeNode getCompleteTreeRoot() {
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode();
        binaryTreeNode1.setData(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode();
        binaryTreeNode2.setData(2);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode();
        binaryTreeNode3.setData(3);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode();
        binaryTreeNode4.setData(4);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode();
        binaryTreeNode5.setData(5);

        binaryTreeNode1.setLchild(binaryTreeNode2);
        binaryTreeNode1.setRchild(binaryTreeNode3);
        binaryTreeNode2.setLchild(binaryTreeNode4);
        binaryTreeNode2.setRchild(binaryTreeNode5);

        return binaryTreeNode1;
    }
}
