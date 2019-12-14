package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 栈的数组实现, 网上复制的
 * 时间复杂度 : push 和 pop 均为：O(1)
 * 空间复杂度 : push 和 pop 均为：O(1)
 */
public class ArrayStack {

    private String[] data = new String[10];//存储数据
    private int size;//记录个数

    //把item压入堆栈顶部
    public void push(String str) {
        //判断是否需要扩容
        if (size > data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size++] = str;
    }

    //查看堆栈顶部的对象，但不从堆栈中移除它
    public String peek() {
        //判断栈是否为空
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data[size - 1]; //获取栈顶元素
    }

    //移除堆栈顶部的对象，并作为此函数的值返回该对象
    public String pop() {
        String str = this.peek();//获取栈顶元素
        size--;                  //减少元素个数
        return str;
    }

    //测试堆栈是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //返回对象在堆栈中的位置，以 1 为基数
    public int search(String str) {
        //顺着放倒着拿（FILO/LIFO）
        for (int i = size - 1; i >= 0; i--) {
            if (str.equals(data[i])) {
                return size - i;
            }
        }
        return -1;    //返回栈中不存在该元素
    }

}
