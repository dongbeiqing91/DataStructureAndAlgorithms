package link;

/**
 * @author Bei
 * @date 2019-10-09
 */

public class MyLink {
    private LinkNode head;

    public void addNode(int d) {
        LinkNode newNode = new LinkNode(d);
        if (head == null) {
            head = newNode;
            return;
        }
        LinkNode tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        tmp.setNext(newNode);
    }

    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.getNext();
            return true;
        }
        int i = 1;
        LinkNode preNode = head;
        LinkNode curNode = preNode.getNext();
        while (curNode != null) {
            if (i == index) {
                preNode.setNext(curNode.getNext());
                return true;
            }
            preNode = curNode;
            curNode = curNode.getNext();
            i++;
        }
        return false;
    }

    public int length() {
        int length = 0;
        LinkNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.getNext();
        }
        return length;
    }

    public boolean deleteNode11(LinkNode n) {
        if (n == null || n.getNext() == null) {
            return false;
        }
        int tmp = n.getData();
        n.setData(n.getNext().getData());
        n.getNext().setData(tmp);
        n.setNext(n.getNext().getNext());
        System.out.println("删除成功！");
        return true;
    }

    public void printList() {
        LinkNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.getData());
            tmp = tmp.getNext();
        }
    }

    public void printListReversely(LinkNode pListHead) {
        if (pListHead != null) {
            printListReversely(pListHead.getNext());
            System.out.println("printListReversely:" + pListHead.getNext());
        }
    }

    /**
     * 判断链表是否有环，单向链表有环时，尾节点相同
     *
     * @param head
     * @return
     */
    public boolean IsLoop(LinkNode head) {
        LinkNode fast = head, slow = head;
        if (fast == null) {
            return false;
        }
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                System.out.println("该链表有环");
                return true;
            }
        }
        return !(fast == null || fast.getNext() == null);
    }

    /**
     * 找出链表环的入口
     *
     * @param head
     * @return
     */
    public LinkNode FindLoopPort(LinkNode head) {
        LinkNode fast = head, slow = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.getNext() == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;
    }


    public static void main(String[] args) {
        MyLink list = new MyLink();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);
        list.addNode(55);
        list.addNode(36);
        System.out.println("linkLength:" + list.length());
        System.out.println("head.data:" + list.head.getData());
        list.printList();
        list.deleteNode(4);
        System.out.println("After deleteNode(4):");
        list.printList();
    }

}
