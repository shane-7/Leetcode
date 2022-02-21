package Dynamic_Programming;

/**
 * @author shkstart
 * @create 2021-12-08 11:34
 */
public class DP6_62test {
    public int uniquePaths(int m, int n) {

        //1.确定dp[i][j]数组以及下标含义：
        //从(0,0)出发到(i,j)有多少条路

        //3.初始化
        int[][] dp = new int[m][n];
        //边界的两条直线都为0
        for(int j = 0; j < n; j++) dp[0][j] = 1;
        for(int i = 0; i < m; i++) dp[i][0] = 1;

        //4.遍历顺序
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
