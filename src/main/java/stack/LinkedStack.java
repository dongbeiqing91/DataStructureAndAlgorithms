package stack;


import link.LinkNode;

/**
 * 栈的链表实现
 * 时间复杂度 pop = O(n), push = O(1), 查找O(n)
 * 空间复杂度 O(1) 出栈和入栈都只需要一两个临时变量
 */
public class LinkedStack {
    //栈底指针
    private LinkNode bottom;
    //栈顶指针
    private LinkNode top;
    //栈的当前大小
    private Integer size;

    /**
     * 栈的初始化
     */
    public void InitStack() {
        top = bottom = new LinkNode(0);
        size = 0;
    }


    /**
     * 获取栈的大小
     */
    public int StackLength() {
        return this.size;
    }

    /**
     * 获取栈顶元素
     */
    public Integer GetTop() {
        return top.data;
    }

    /**
     * 入栈
     */
    public void Push(int element) {
        LinkNode newNode = new LinkNode(element);
        top.next = newNode;
        top = newNode;
        size++;
    }

    /**
     * 出栈
     */
    public Integer Pop() {
        if (bottom == top) { // 栈为空
            return null;
        }
        int e = top.data;
        size--; // 减小栈的大小
        LinkNode nowNode = bottom;
        while (nowNode.next.next != null) { // 获取指向top的指针
            nowNode = nowNode.next;
        }
        nowNode.next = null; // 释放top所指向的元素
        top = nowNode; // top指向顶部元素
        return e;

    }

    /**
     * 获取指定位置的链表中的元素
     */
    public Integer getElement(int i) {
        LinkNode nowNode = bottom;
        int j = 1;
        while (nowNode != null && nowNode.next != null) {
            nowNode = nowNode.next;
            if (i == j) {
                return nowNode.data;
            }
            j++;
        }

        return null;
    }

    /**
     * 遍历栈
     */
    public void print() {
        for (int i = size; i > 0; i--) {
            System.out.print(this.getElement(i) + " ");
        }
        System.out.println();
    }
}