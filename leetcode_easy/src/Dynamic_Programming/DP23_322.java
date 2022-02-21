package Dynamic_Programming;

/** 322.兑换零钱, 这道题值得多做！！！！
 * @author shkstart
 * @create 2021-12-15 9:49
 */
public class DP23_322 {
    public int coinChange(int[] coins, int amount) {


        //1.确定dp[j]数组以及下标的含义:
        //凑足总金额为j所需钱币的最少个数dp[j]

        //2.确定递推公式
        //dp[j] = dp[j - coins[i]] + 1
        //所以dp[j]要取所有dp[j - coins[i]] + 1中最小的
        //递推公式变为：dp[j] = min(dp[j - coins[i]] + 1, dp[j])

        //3.dp初始化, 这里除了index=0，其他都要初始化为最大值
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        int max = Integer.MAX_VALUE;
        for(int i = 1; i < dp.length; i++){
            dp[i] = max;
        }

        //4.确定遍历顺序:是组合问题，先物品后背包
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                //这里要加个判断
                if(dp[j - coins[i]] != max){
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        return dp[amount] == max? -1 : dp[amount];
    }
}
