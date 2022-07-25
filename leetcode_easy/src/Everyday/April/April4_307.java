package Everyday.April;

/**
 * @author shkstart
 * @create 2022-04-05 16:42
 */
public class April4_307 {
    int[] arr;
    public April4_307(int[] nums) {
        arr = nums;
    }

    public void update(int index, int val) {
        arr[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++){
            sum += arr[i];
        }
        return sum;
    }
}
