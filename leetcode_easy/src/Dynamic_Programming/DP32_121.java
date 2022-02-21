package Dynamic_Programming;

/** 121.买卖股票的最佳时机
 * @author shkstart
 * @create 2021-12-30 8:30
 */
public class DP32_121 {
    //暴力解法
    public int maxProfit(int[] prices){
        int res = 0;
        for(int i = 0; i < prices.length - 1; i++){
            for(int j = i + 1; j < prices.length; j++){
                res = Math.max(prices[j] - prices[i], res);
            }
        }
        return res;
    }

    //贪心算法：最左取最小值，最右取最大值
    public int maxProfit1(int[] prices){
        int low = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < prices.length; i++){
            low = Math.min(prices[i], low);    //取最左最小价格
            res = Math.max(res, prices[i] - low);   //直接取最大区间利润
        }
        return res;
    }

    //动态规划:
    public int maxProfit2(int[] prices){
        //1.dp[i][0]表示第i天持有股票的所得的最多现金
        //  dp[i][1]表示第i天不持有股票所得的最多现金
        //  注意：持有不一定是持有的当天股票，也可能是前一天或者之前的股票

        int[][] dp = new int[prices.length][2];  //第二维赋予dp两种状态表示

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);     //下面两行确定遍历顺序
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }
        return dp[prices.length - 1][1];

    }


    public static void main(String[] args) {
        DP32_121 test = new DP32_121();
        int[] prices = new int[]{7,1,5,3,6,4};
        int res = test.maxProfit1(prices);
        System.out.println(res);

    }
}
