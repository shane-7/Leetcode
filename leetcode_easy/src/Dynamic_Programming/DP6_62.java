package Dynamic_Programming;

 // 非常值得多做几遍
/** 62.不同路径 mid  ！！！！
 *
 *   dp[i][j]表示从(0,0)出发到(i, j)有dp[i][j]条不同路径
 * @author shkstart
 * @create 2021-12-03 18:58
 */
public class DP6_62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }

        }
        return dp[m - 1][n - 1];
    }
}
