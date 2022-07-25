package 宫水三叶.DP;

public class DP6_买卖股票的最佳时机 {
    public static int maxProfit1(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++){
            for (int j = i + 1; j < prices.length; j++) {
                result = Math.max(result, prices[j] - prices[i]);
            }
        }
        return result;
    }

    //dp方法
    public int maxProfit2(int[] prices){
        //边界条件考虑
        if(prices == null || prices.length == 0) return 0;
        //dp[i][0]：表示第i天持有股票所得最多现金
        //dp[i][1]: 表示第i天不持有股票所得最多现金
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][1];
    }

    //贪心法
    public static int maxProfit3(int[] prices){
        //找一个最小的点
        int low = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < prices.length; i++){
            low = Math.min(prices[i], low);
            res = Math.max(prices[i] - low, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = DP6_买卖股票的最佳时机.maxProfit3(new int[]{7,1,5,3,6,4});
        System.out.println(res);
    }
}
