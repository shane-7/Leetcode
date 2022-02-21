package Dynamic_Programming;

/** 746.使用最小花费爬楼梯
 *  作为动态规划的入门题目，这个题目值得多做几次
 * cost.length >= 2
 * @author shkstart
 * @create 2021-12-03 18:12
 */
public class DP4_746 {

    //最后一步不花费体力
    public int minCostClimbingStairs(int[] cost){
        int[] dp = new int[cost.length];
//        dp[0] = Math.min(cost[0], cost[1]);
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < cost.length; i++){
            dp[i] = Math.min(dp[i - 1], dp[i -2]) + cost[i];
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    //第一步不花费体力
    public int minCostClimbingStairs1(int[] cost){
        int [] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= cost.length; i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }
}
