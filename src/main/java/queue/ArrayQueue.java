package queue;

// 网上复制的
public class ArrayQueue<E> {
    private int front;//队头一端，只允许删除
    private int rear;//队尾一端，只允许插入操作
    private int maxSize = 16;
    private Object[] data;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("队列初始化失败，原因是：" + size);
        }
        this.maxSize = size;
        front = rear = 0;
        data = new Object[maxSize];
    }

    //判断是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //入队
    public boolean add(E e) {
        if (rear == maxSize) {
            throw new RuntimeException("队列满了");
        } else {
            data[rear++] = e;
            return true;
        }
    }

    //返回队首元素,不删除元素
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) data[front];
    }

    //出队
    public E poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            E e = (E) data[front];
            data[front++] = null;
            return e;
        }
    }

    //长度
    public int length() {
        return rear - front;
    }
}
