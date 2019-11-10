package sort;

import java.util.Arrays;

public class BubbleSort {

    public int[] sortAsc(int[] toBeSorted) {
        for (int i = 0; i < toBeSorted.length; i++) {
            for (int j = 0; j < toBeSorted.length - i - 1; j++) {
                if (toBeSorted[j] >= toBeSorted[j + 1]) {
                    int temp = toBeSorted[j];
                    toBeSorted[j] = toBeSorted[j + 1];
                    toBeSorted[j + 1] = temp;
                }
            }
        }
        return toBeSorted;
    }

    public static void main(String[] args) {
        int[] toBeSorted = {5, 4, 3, 2, 1};
        BubbleSort bubbleSort = new BubbleSort();
        int[] ints = bubbleSort.sortAsc(toBeSorted);
        System.out.println(Arrays.toString(ints));
    }
}
