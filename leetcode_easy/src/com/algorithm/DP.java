package com.algorithm;

/** 求最大子序列和的动态规划方法
 * @author shkstart
 * @create 2021-04-16 9:53
 */
public class DP {
    public static int maxSubArray(int[] nums){
        int result = 0;
        int numSize = nums.length;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < numSize; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(dp[i], result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = 0;
        //DP al = new DP();
        result = DP.maxSubArray(nums);
        System.out.println(result);
        

    }
}
