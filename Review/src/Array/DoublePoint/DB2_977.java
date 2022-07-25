package Array.DoublePoint;

import java.util.Arrays;

/**
 * 有序数组的平方
 */

public class DB2_977 {
    //暴力解法
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int sq = nums[i] * nums[i];
            nums[i] = sq;
        }
        Arrays.sort(nums);
        return nums;
    }

    //双指针
    public int[] slove(int[] nums){
        int start = 0, end = nums.length - 1;
        int[] res = new int[nums.length];
        int k = res.length - 1;
        while (start <= end){
            if(nums[start] * nums[start] < nums[end] * nums[end]){
                res[k--] = nums[end] * nums[end];
                end--;
            }else {
                res[k--] = nums[start] * nums[start];
                start++;
            }
        }
        return res;
    }

}
