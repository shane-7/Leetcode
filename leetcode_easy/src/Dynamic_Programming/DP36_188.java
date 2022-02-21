package Dynamic_Programming;

/** 188.买卖股票的最佳时机IV
 * @author shkstart
 * @create 2022-01-09 11:23
 */
public class DP36_188 {
    public int maxProfit(int[] prices, int k){
        //1.确定dp[i][j]数组以及下标的含义：
        //表示第i天的状态为j，所剩下的最大现金为dp[i][j]
        //3.dp的初始化
        if(prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2 * k + 1];

        //奇数是买入的价格，初始化为-price[i]
        dp[0][0] = 0;
        for(int j = 1; j < 2 * k; j += 2){
            dp[0][j] = -prices[0];
        }

        //4.确定遍历顺序
        for(int i = 1; i < prices.length; i++){
            //2.确定递推公式
            for(int j = 0; j < 2 * k - 1; j +=2){  //根据买入卖出（奇偶）分组，总共2k组，进行循环
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);   //一组中买入的状态：max(该组昨天买入的状态， 该组今天买入的状态 = 昨天卖出的状态 + 今天股价)
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]); //一组中卖出的状态：max(该组昨天卖出的状态，该组今天卖出的状态 = 昨天买入的状态 + 今日股价)

            }
        }
        return dp[prices.length - 1][2 * k];
    }
}
