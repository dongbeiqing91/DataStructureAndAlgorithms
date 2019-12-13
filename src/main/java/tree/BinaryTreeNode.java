package tree;

/**
 * @author Bei
 * @date 2019-11-27
 */
public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode lchild;
    private BinaryTreeNode rchild;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public BinaryTreeNode() { }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLchild() {
        return lchild;
    }

    public void setLchild(BinaryTreeNode lchild) {
        this.lchild = lchild;
    }

    public BinaryTreeNode getRchild() {
        return rchild;
    }

    public void setRchild(BinaryTreeNode rchild) {
        this.rchild = rchild;
    }
}
