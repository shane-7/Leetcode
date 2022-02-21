package Dynamic_Programming;

/** 不同路径II，设置了障碍
 * @author shkstart
 * @create 2021-12-05 10:51
 */
public class DP7_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;  //行
        int n = obstacleGrid[0].length; //列

        //dp初始化 ,注意：有障碍物时，初始化要设为0；
        int[][] dp = new int[m][n];
        for(int i = 0; i < m && obstacleGrid[i][0] == 0; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n && obstacleGrid[0][j] == 0; j++){
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }else{   //如果有障碍物，则路径数为0
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        DP7_63 test = new DP7_63();
        int[][] obs = {{0,1},{0,0}};
        int res = test.uniquePathsWithObstacles(obs);
        System.out.println(res);
    }
}
