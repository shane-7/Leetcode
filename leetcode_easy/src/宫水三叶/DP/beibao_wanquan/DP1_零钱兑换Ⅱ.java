package 宫水三叶.DP.beibao_wanquan;

/**
 * 518零钱兑换Ⅱ 本题是组合问题
 */
public class DP1_零钱兑换Ⅱ {
    public int change(int amount, int[] coins) {
        //1.dp[j]数组以及下标的含义：凑成总金额j的货币组合数为dp[j]
        int[] dp = new int[amount + 1];
        //3.dp数组如何初始化：dp[0]一定要为1，dp[0] = 1 是递归公式的基础
        dp[0] = 1;
        //组合问题：先遍历物品后遍历背包
        //排列问题，先遍历背包后遍历物品
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                //2.确定递推公式，类似‘目标和’，dp[j] += dp[j - nums[i]]
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
