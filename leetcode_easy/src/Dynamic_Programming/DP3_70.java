package Dynamic_Programming;

/** 70.爬楼梯 easy
 *  思路和斐波那契数列一样
 * @author shkstart
 * @create 2021-12-03 19:12
 */
public class DP3_70 {
    public int climbStairs(int n){
//        dp数组及下标的定义：爬上第i阶有几种方法
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            //递推公式：爬上第i阶台阶可以从第i-1阶台阶或第i-2阶台阶上来
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
