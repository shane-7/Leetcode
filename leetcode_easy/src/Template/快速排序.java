package Template;

/**
 * @author shkstart
 * @create 2022-04-28 7:04
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = new int[] { 45, 80, 55, 40, 42, 85 };
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }
        int low = start;
        int high = end;
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high]; // 将小于 pivot 的数放在底位
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low]; // 将大于 pivot 的数放在高位
        }
        arr[low] = pivot;
        quickSort(arr, start, low - 1); // 递归排序左半部分
        quickSort(arr, low + 1, end); // 递归排序右半部分
    }

}
