package Dynamic_Programming;

/** 70.爬楼梯 easy
 *  思路和斐波那契数列一样
 * @author shkstart
 * @create 2021-12-03 19:12
 */
public class DP3_70 {
    public int climbStairs(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
