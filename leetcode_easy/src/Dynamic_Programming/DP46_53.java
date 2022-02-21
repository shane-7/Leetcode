package Dynamic_Programming;

/** 53. 最大子序列和
 * @author shkstart
 * @create 2022-02-17 9:21
 */
public class DP46_53 {
    public int maxSubArray(int[] nums) {
        //1.确定dp数组以及下标的含义：
        //dp[i]:包括下标i之前的最大连续子序列和为dp[i]

        //3.dp数组的初始化
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int res = dp[0];

        //4.确定遍历顺序
        for(int i = 1; i < nums.length; i++){
            //2.确定递推公式：
            // dp[i]只有两个方向可以推出来（两个取最大）：
//              dp[i - 1] + nums[i] : nums[i]加入当前连续子序列和
//              nums[i]:从头开始计算当前连续子序列和
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            if(dp[i] > res)
                res = dp[i];
        }
        return res;
    }
}
