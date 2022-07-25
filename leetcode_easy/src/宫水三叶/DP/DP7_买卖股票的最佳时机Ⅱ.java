package 宫水三叶.DP;

public class DP7_买卖股票的最佳时机Ⅱ {
    public int maxProfit(int[] prices) {
        //dp[i][0]：表示第i天持有股票所得最多现金
        //dp[i][1]: 表示第i天不持有股票所得最多现金
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for(int i = 1; i < prices.length; i++){
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[0] + prices[i], dp[1]);
        }
        return dp[1];
    }

    //优化空间：可以看到dp[i][]在这里是滚动数组，所以可以用
}
