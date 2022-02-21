package Dynamic_Programming;

/**
 * @author shkstart
 * @create 2021-12-08 10:48
 */
public class DP4_746test {
    public int minCostClimbingStairs(int[] cost){

        //初始化
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        //第一步是要花费的
        for(int i = 2; i < cost.length; i++){
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);

    }
}
