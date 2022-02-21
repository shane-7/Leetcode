package Array.easy;


import java.util.Arrays;

/** 34题
 * @author shkstart
 * @create 2021-07-09 0:05
 */
public class array34 {
    public int[] searchRange(int[] nums, int target) {
        int lower = lowerBound(nums, target);
        int upper = upperBound(nums, target);
        if(lower >= upper){
            return new int[] {-1, -1};
        }else{
            return new int[] {lower, upper};
        }
    }
    public int lowerBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int upperBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        array34 test = new array34();
        int[] result = test.searchRange(nums, target);
        System.out.println(Arrays.toString(result));  //数组打印要用到toString方法
    }
}
