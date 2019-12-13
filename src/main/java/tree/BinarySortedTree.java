package tree;

public class BinarySortedTree {

    public static BinaryTreeNode getInstance(){
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(7);
        BinaryTreeNode node3 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(3);
        root.setLchild(node1);
        root.setRchild(node2);
        node1.setLchild(node4);
        node1.setRchild(node5);
        node2.setLchild(node2);
        node2.setLchild(node3);
        return root;
    }
}