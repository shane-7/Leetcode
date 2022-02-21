package Dynamic_Programming;

/** 122.买卖股票Ⅱ, 与Ⅰ不同的是可以买卖多次
 * @author shkstart
 * @create 2021-12-30 10:28
 */
public class DP34_122 {
    public int maxProfit(int[] prices){
        int len = prices.length;
        int[][] dp = new int[len][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);  //这里是与121.唯一不同的地方
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }

        return dp[len - 1][1];
    }

    public static void main(String[] args) {
        DP34_122 test = new DP34_122();
        int[] prices = new int[]{7,1,5,3,6,4};
        int res = test.maxProfit(prices);
        System.out.println(res);


    }
}
