package 宫水三叶.DP.beibao_wanquan;

/**
 *  377组合总和Ⅳ，用的是排列，先背包后物品
 */
public class DP2_组合总和Ⅳ {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int j = 0; j < target; j++){
            for(int i = 0; i < nums.length; i++){
                if(j - nums[i] >= 0) dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
