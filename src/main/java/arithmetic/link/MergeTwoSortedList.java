package arithmetic.link;

import link.LinkNode;

/**
 * 有序合并两个有序链表
 */
public class MergeTwoSortedList {

    public static void printList(LinkNode head) {
        if (head == null || head.getNext() == null) {
            return;
        } else {
            head = head.getNext();
            while (head != null) {
                System.out.print(head.getData() + " ");
                head = head.getNext();
            }
        }
        System.out.println();
    }

    public static void addLast(int i, LinkNode head) {
        if (head != null) {
            while (head.getNext() != null) {
                head = head.getNext();
            }
            head.setNext(new LinkNode());
            head.getNext().setData(i);
        }
    }

    public static LinkNode merge(LinkNode head1, LinkNode head2) {
        // tmp用来当合并后的链表的游标指针, 借用head1当头结点, tmp.next指向最小的数
        LinkNode tmp = head1;
        // 头结点不存值, 只存指向下一个结点的指针
        LinkNode node1 = head1.getNext(); // 第一个数组的游标指针
        LinkNode node2 = head2.getNext(); // 第二个数组的游标指针
        while (node1 != null && node2 != null) {
            if (node1.getData() <= node2.getData()) { // 如果第一个数组的值比较小
                tmp.setNext(node1);  // tmp的next指针指向它
                tmp = tmp.getNext(); // tmp 后移
                node1 = node1.getNext(); // 第一个数组指针后移
            } else {
                tmp.setNext(node2);
                tmp = tmp.getNext();
                node2 = node2.getNext();
            }
        }
        // 处理余下的部分
        if (node1 != null) {
            tmp.setNext(node1);
        } else if (node2 != null) {
            tmp.setNext(node2);
        }

        return head1;
    }

    public static void main(String[] args) {
        LinkNode node1 = new LinkNode();
        addLast(2, node1);
        addLast(9, node1);
        addLast(15, node1);
        addLast(20, node1);
        printList(node1);
        LinkNode node2 = new LinkNode();
        addLast(1, node2);
        addLast(4, node2);
        addLast(7, node2);
        addLast(9, node2);
        addLast(11, node2);
        addLast(13, node2);
        printList(node2);
        printList(merge(node1, node2));
    }
}

