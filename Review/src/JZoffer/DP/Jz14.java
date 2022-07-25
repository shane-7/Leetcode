package JZoffer.DP;

/* 动态规划
 剪绳子
 */
public class Jz14 {
    public int cuttingRope(int n){
        /*
        1.状态定义：dp[i]表示长度为i的绳子剪成m段最大乘积为dp[i]
        2.状态转移：dp[i]有两种途径可以转移得到
            2.1 由前一个dp[j] * (i - j)得到，即前面剪了 >= 2段，后面再剪一段，此时的乘积个数 >= 3
            2.2 前面单独成一段，后面剩下的单独成一段，乘积为j * (i - j),乘积个数为2
            两种情况取最大值作为dp[i]的值，同时应该遍历所有j，j∈[1, i - 1],取最大值
        3.初始化：初始化dp[1] = 1即可
        4.遍历顺序：显然为正序遍历
         */
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i - 1; j++){
                int temp = Math.max(dp[j] * (i - j), j * (i - j));
                dp[i] = Math.max(temp, dp[i]);
            }
        }
        return dp[n];
    }

}
