package Dynamic_Programming;

/**
 * @author shkstart
 * @create 2022-01-13 20:54
 */
public class DP39_714 {
    public int maxProfit(int[] prices, int fee){
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];

        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }

        return dp[prices.length - 1][1];

    }

    public static void main(String[] args) {
        DP39_714 test = new DP39_714();
        int[] prices = {1,3,7,5,10,3};
        int fee = 3;
        int res = test.maxProfit(prices, fee);
        System.out.println(res);
    }
}
