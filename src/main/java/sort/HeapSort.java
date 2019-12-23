package sort;

import util.CommonUtils;

import java.util.Arrays;

/**
 * 基本思想：堆排序是一种树形选择排序，是对直接选择排序的有效改进。
 * 堆的定义如下：具有n个元素的序列（h1,h2,…,hn),当且仅当满足（hi>=h2i,hi>=h2i+1）或（hi<=h2i,hi<=h2i+1） (i=1,2,…,n/2)时称之为堆。
 * 在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。
 * 完全二叉树可以很直观地表示堆的结构。堆顶为根，其它为左子树、右子树。
 * 然后对前面(n-1)个数重新调整使之成为堆。依此类推，直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。
 * 从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。
 * 所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
 *
 * 时间复杂度: 平均O(nlogn), 最好O(nlogn), 最坏O(nlogn)
 * 空间复杂度: O(1)
 * 稳定性: 不稳定
 */

public class HeapSort {

    public static void heapSort(int[] tree) {
        build_heap(tree, tree.length); // 先建立一个大顶堆
        for (int i = tree.length - 1; i >= 0; i--) {
            CommonUtils.swap(tree, i, 0); // 交换最后一个结点和根结点
            heapify(tree, i - 1, 0); // 由于根结点发生变化, 大顶堆不复存在, 要重新恢复大顶堆
        }
    }


    private static void build_heap(int[] tree, int n) { // 建立完整的大顶堆
        int lastIndex = n - 1;
        int parent = (lastIndex - 1) / 2; // 父结点和子结点index之间的关系
        for (int i = parent; i >= 0; i--) { // 从最后一个结点的父节点开始, 向前直到根结点
            heapify(tree, n, i);
        }
    }

    private static void heapify(int[] tree, int n, int i) { // 对索引为i的结点做heapify, n为数组长度
        if (i >= n) {
            return;
        }
        int lChild = 2 * i + 1;
        int rChild = 2 * i + 2;
        int maxValuePosition = i;
        // 找到最大值的位置
        if (lChild < n && tree[lChild] > tree[maxValuePosition]) {
            maxValuePosition = lChild;
        }
        if (rChild < n && tree[rChild] > tree[maxValuePosition]) {
            maxValuePosition = rChild;
        }
        if (maxValuePosition != i) { // i已经是最大值, 无需做交换, 否则要做交换
            CommonUtils.swap(tree, maxValuePosition, i);
            heapify(tree, n, maxValuePosition); // maxValuePosition处被交换了, 对其做heapify (因为交换后该元素子树受到了影响)
        }
    }

    public static void main(String[] args) {
        int []a = {2, 5, 3, 1, 10, 4}; // 完全树, 用一个数组表示
        int []b = {2, 5, 3, 1, 10, 4}; // 完全树, 用一个数组表示
        int []c = {10, 5, 4, 3, 2, 1}; // 完全树, 用一个数组表示
        int []d = {1, 3, 2, 13, 2, 7}; // 完全树, 用一个数组表示
        heapify(d, d.length, 0);
        System.out.println(Arrays.toString(d));
        build_heap(a, a.length);
        System.out.println(Arrays.toString(a));
        heapSort(b);
        System.out.println(Arrays.toString(b));
        heapSort(c);
        System.out.println(Arrays.toString(c));
    }
}
