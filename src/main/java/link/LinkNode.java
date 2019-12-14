package link;

/**
 * @author Bei
 * @date 2019-10-09
 */
public class LinkNode {
    private LinkNode next;
    private int data;

    public LinkNode() {}

    public LinkNode(int data) {
        this.data = data;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
