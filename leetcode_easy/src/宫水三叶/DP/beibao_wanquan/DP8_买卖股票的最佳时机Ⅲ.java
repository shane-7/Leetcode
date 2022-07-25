package 宫水三叶.DP.beibao_wanquan;

public class DP8_买卖股票的最佳时机Ⅲ {
    public int maxProfit(int[] prices) {
        //有5种状态：
        //‘0’：没有操作，‘1’：第一次买入，‘2’：第一次卖出，‘3’：第二次买入，'4':第二次卖出
        int[][] dp = new int[prices.length][5];
        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;

        for(int i = 1; i < prices.length; i++){
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[prices.length - 1][4];
    }

    //用滚动数组优化
    public int maxProfit1(int[] prices) {
        //有4种状态：
        //‘0’：第一次买入，‘1’：第一次卖出，‘2’：第二次买入，'3':第二次卖出
        int[] dp = new int[5];
        //初始化
        dp[0] = -prices[0];
        dp[1] = 0;
        dp[2] = -prices[0];
        dp[3] = 0;

        for(int i = 1; i < prices.length; i++){
            dp[0] = Math.max(- prices[i], dp[0]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            dp[2] = Math.max(dp[1] - prices[i], dp[2]);
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }
        return dp[3];
    }
}
