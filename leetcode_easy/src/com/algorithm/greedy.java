package com.algorithm;

/** 求最大子序列和的 贪心算法
 * @author shkstart
 * @create 2021-04-16 10:53
 */
public class greedy {
    public static int maxSubArray(int[] nums){
        int result = 0;
        int numSize = nums.length;
        int sum = 0;
        for(int i = 0; i < numSize; i++){
            sum += nums[i];
            result = Math.max(result, sum);

            if(sum < 0){
                sum = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

    }
}
