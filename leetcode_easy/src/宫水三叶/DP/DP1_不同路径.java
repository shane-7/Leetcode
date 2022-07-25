package 宫水三叶.DP;

/**
 * @author shkstart
 * @create 2022-05-15 20:29
 */
public class DP1_不同路径 {
    public int uniquePaths(int m, int n) {
        //1. dp[i][j]数组以及下标表示的含义:
        // 表示从[0, 0]出发，到达[i][j]有dp[i][j]条路径
        int[][] dp = new int[m][n];

        //2.确定递推公式
        //dp[i][j]由 dp[i][j - 1] 和 dp[i - 1][j]推出来
        //dp[i][j] = dp[i][j - 1] + dp[i - 1][j]

        //3.dp数组的初始化
        //首先dp[i][0]一定都是1，因为从(0, 0)的位置到(i, 0)的路径只有一条，那么dp[0][j]也同理
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++) dp[0][j] = 1;

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        DP1_不同路径 test = new DP1_不同路径();
        int res = test.uniquePaths(3, 7);
        System.out.println(res);
    }
}
