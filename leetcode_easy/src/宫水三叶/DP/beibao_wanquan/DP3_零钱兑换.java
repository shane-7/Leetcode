package 宫水三叶.DP.beibao_wanquan;

/**
 *  322零钱兑换,不论排列或组合都可以
 */
public class DP3_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        //dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        //先物品后背包
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if(dp[j - coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount];
    }
}
