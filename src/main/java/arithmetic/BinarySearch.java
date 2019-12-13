package arithmetic;

public class BinarySearch {

    public static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) { // 当 left = right 时，区间 [left, right] 仍然有效
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                left = mid + 1; // target 在 [mid+1, r] 中
            } else {
                right = mid - 1; // target 在 [left, mid - 1] 中
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        int i = binarySearch(arr, 0, arr.length - 1, 3);
        System.out.println("location:" + i);
    }
}
