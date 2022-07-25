package 宫水三叶.DP;

public class DP3_打家劫舍 {
    public int rob(int[] nums) {
        //考虑边界情况
        if(nums == nums || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        //1.dp[i]:考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], dp[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
