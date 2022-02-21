package Dynamic_Programming;

/** 96.不同的二叉搜索树，此题可以说是困难了
 * @author shkstart
 * @create 2021-12-05 16:17
 */
public class DP9_96 {
    public int numTrees(int n) {
        //1.确定dp数组以及下标含义
        //dp[i] ： 1到i为节点组成的二叉搜索树的个数为dp[i]。
        //初始化DP
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        //递推公式
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
