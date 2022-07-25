package 宫水三叶.DP.beibao_wanquan;

public class DP4_完全平方数 {
    public static int numSquares(int n) {
        //dp[i]：和为i的完全平方数的最少数量为dp[i]
        int[] dp = new int[n + 1];
        for(int i = 1; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        //先遍历背包后遍历物品
        for(int i = 0; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

//        先物品后背包
        for(int i = 1;  i * i < n; i++){
            for(int j = 1; j <= n; j++){
                if(j - i * i >= 0){
                    dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = DP4_完全平方数.numSquares(5);
        System.out.println(i);
    }
}
