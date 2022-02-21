package Dynamic_Programming;

/** 309.最佳买卖股票时机含冷冻期
 * @author shkstart
 * @create 2022-01-12 11:24
 */
public class DP37_309 {
    public int maxProfit(int[] prices){
        //特殊情况：
        if(prices.length == 0){
            return 0;
        }
        //1.确定dp[i][j]数据以及下标的含义：
        // 第i天状态为j，所剩的最多现金为dp[i][j]

        //有4种状态：
//        状态一：买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）
//        卖出股票状态，这里就有两种卖出股票状态
//        状态二：两天前就卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态
//        状态三：今天卖出了股票
//        状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！



        //3.dp数组初始化
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];


        //4.确定遍历顺序
        for(int i = 1; i < prices.length; i++){

            //2.确定递推公式
            //状态1：持有股票（今日持有或是之前就持有）\
//                   1.1:前一天也是持有股票，状态1
//                     1.2:前一天为状态2
//                     1.3:前一天为冷冻期，状态4
            dp[i][0] = Math.max(dp[i - 1][3] - prices[i],Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]));

            //状态2：两天前就卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态

            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            //状态3：今天卖出了股票:
            dp[i][2] = dp[i - 1][0] + prices[i];
            //状态4：今天为冷冻期状态：
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][2],Math.max(dp[prices.length - 1][1], dp[prices.length - 1][3]));
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        DP37_309 test = new DP37_309();
        int res = test.maxProfit(prices);
        System.out.println(res);
    }
}
