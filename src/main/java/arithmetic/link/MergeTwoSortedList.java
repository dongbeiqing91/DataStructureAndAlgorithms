package arithmetic.link;

import link.LinkNode;
import org.junit.Test;

/**
 * 有序合并两个有序链表
 */
public class MergeTwoSortedList {

    public void printList(LinkNode head) throws Exception {
        if (head == null || head.next == null) {
            throw new Exception("Empty List");
        } else {
            head = head.next;
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
        }
        System.out.println();
    }

    public void addLast(int i, LinkNode head) {
        if (head != null) {
            while (head.next != null) {
                head = head.next;
            }
            head.next = new LinkNode();
            head.next.data = i;
        }
    }

    public LinkNode merge(LinkNode head1, LinkNode head2) {
        // tmp用来当合并后的链表的游标指针, 借用head1当头结点, tmp.next指向最小的数
        LinkNode tmp = head1;
        // 头结点不存值, 只存指向下一个结点的指针
        LinkNode node1 = head1.next; // 第一个数组的游标指针
        LinkNode node2 = head2.next; // 第二个数组的游标指针
        while (node1 != null && node2 != null) {
            if (node1.data <= node2.data) { // 如果第一个数组的值比较小
                tmp.next = node1;  // tmp的next指针指向它
                tmp = tmp.next; // tmp 后移
                node1 = node1.next; // 第一个数组指针后移
            } else {
                tmp.next = node2;
                tmp = tmp.next;
                node2 = node2.next;
            }
        }
        // 处理余下的部分
        if (node1 != null) {
            tmp.next = node1;
        } else if (node2 != null) {
            tmp.next = node2;
        }

        return head1;
    }

    @Test
    public void test() throws Throwable {
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

