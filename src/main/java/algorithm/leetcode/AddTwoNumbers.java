package algorithm.leetcode;

/**
 * @author Bei
 * @date 2020-01-08
 */

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Length = getListLength(l1);
        int l2Length = getListLength(l2);
        if (l1Length >= l2Length) {
            return calc(l2, l1);
        } else {
            return calc(l1, l2);
        }
    }

    private ListNode calc(ListNode first, ListNode second) {
        ListNode temp = second;
        boolean flag = false;
        ListNode pre = null;
        while (second != null && first != null) {
            second.val = second.val + first.val + (flag ? 1 : 0);
            if (second.val >= 10) {
                second.val -= 10;
                flag = true;
            } else {
                flag = false;
            }
            pre = second;
            second = second.next;
            first = first.next;
        }
        if (second == null && first == null && flag) {
            pre.next = new ListNode(1);
        }
        if (second == null && first != null) {
            if (!flag) {
                pre.next = first;
            } else {
                boolean flag2 = true;
                while (first != null && flag2) {
                    first.val += 1;
                    if (first.val >= 10) {
                        first.val -= 10;
                        flag2 = true;
                    } else {
                        flag2 = false;
                    }
                    pre = first;
                    first = first.next;
                }
                if (flag2) {
                    pre.next = new ListNode(1);
                }
            }
        }
        if (first == null && second != null && flag) {
            boolean flag2 = true;
            while (second != null && flag2) {
                second.val += 1;
                if (second.val >= 10) {
                    second.val -= 10;
                    flag2 = true;
                } else {
                    flag2 = false;
                }
                pre = second;
                second = second.next;
            }
            if (flag2) {
                pre.next = new ListNode(1);
            }
        }

        return temp;
    }

    private int getListLength(ListNode listNode) {
        if (listNode == null) {
            return 0;
        }
        int length = 1;
        while (listNode.next != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }

    public static void main(String[] args) {
        AddTwoNumbers f = new AddTwoNumbers();
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode = f.addTwoNumbers(listNode1, listNode4);
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }


        System.out.println();
        ListNode listNode7 = new ListNode(1);
        ListNode listNode8 = new ListNode(8);
        listNode7.next = listNode8;
        ListNode listNode9 = new ListNode(0);
        ListNode listNodeZZZ = f.addTwoNumbers(listNode7, listNode9);
        while (listNodeZZZ != null) {
            System.out.print(listNodeZZZ.val + "->");
            listNodeZZZ = listNodeZZZ.next;
        }

    }
}
